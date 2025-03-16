package paypals.commands;

import paypals.Activity;
import paypals.ActivityManager;
import paypals.Person;
import paypals.exception.ExceptionMessage;
import paypals.exception.PayPalsException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddCommand extends Command {

    private static final String WRONG_ADD_FORMAT = "Format: add d/DESCRIPTION n/PAYER f/FRIEND1 a/AMOUNT_OWED_1 f/FRIEND2 a/AMOUNT_OWED_2...";

    public AddCommand(String command) {
        super(command);
    }

    private String extractValue(String key, ExceptionMessage exceptionMessage) throws PayPalsException {
        String regex = key + "\\s*([^/]+?)(?=\\s+[a-zA-Z]/|$)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(command);

        if (matcher.find()) {
            return matcher.group(1).trim();
        } else {
            System.out.println(WRONG_ADD_FORMAT);
            throw new PayPalsException(exceptionMessage);
        }
    }

    private void validateFriend(String payer, String oweName, HashMap<String, Double> owedMap) throws PayPalsException {
        if (payer.equals(oweName)) {
            throw new PayPalsException(ExceptionMessage.PAYER_OWES);
        }
        if (owedMap.containsKey(oweName)) {
            System.out.println(WRONG_ADD_FORMAT);
            throw new PayPalsException(ExceptionMessage.DUPLICATE_FRIEND);
        }
    }

    public void execute(ActivityManager activityManager) throws PayPalsException {
        HashMap<String, Double> owed = new HashMap<String, Double>();
        HashMap<String, Double> netOwedMap = activityManager.getNetOwedMap();
        HashMap<String, ArrayList<Activity>> personActivitesMap = activityManager.getPersonActivitiesMap();

        // Step 2: Capture all (f/... a/...) pairs

        String description = extractValue("d/", ExceptionMessage.NO_DESCRIPTION);
        String name = extractValue("n/", ExceptionMessage.NO_PAYER);

        double totalOwed = 0;
        String[] pairs = command.split("\\s+f/");
        for (int i = 1; i< pairs.length; i++) {
            String[] parameters = pairs[i].split("\\s+a/");
            if (parameters.length==2) {
                String oweName = parameters[0].trim();
                Double oweAmount = Double.parseDouble(parameters[1]);
                validateFriend(name, oweName, owed);
                owed.put(oweName, oweAmount);
                netOwedMap.put(oweName, netOwedMap.getOrDefault(oweName,0.0) - oweAmount);
                totalOwed += oweAmount;
            }
        }

        netOwedMap.put(name, netOwedMap.getOrDefault(name,0.0) + totalOwed);

        System.out.println("Desc: "+description);
        System.out.println("Name of payer: "+name);
        System.out.println("Number of friends who owe " + name +": "+owed.size());
        Activity newActivity = new Activity(description, new Person(name, -totalOwed, false), owed);
        activityManager.addActivity(newActivity);

        //Map each friend to the activity
        for (Map.Entry<String, Double> entry : owed.entrySet()){
            ArrayList<Activity> activitiesList =
                    personActivitesMap.computeIfAbsent(entry.getKey(), k -> new ArrayList<>());

            activitiesList.add(newActivity);
        }
        //Map the payer to the activity
        ArrayList<Activity> activitiesList = personActivitesMap.computeIfAbsent(name, k -> new ArrayList<>());

        activitiesList.add(newActivity);
    }
}
