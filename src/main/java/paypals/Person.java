package paypals;

public class Person {
    private String name;
    private double amount;
    private Boolean hasPaid;

    public Person(String name, double amount, Boolean hasPaid) {
        this.name = name;
        this.amount = amount;
        this.hasPaid = hasPaid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void markAsPaid() {
        this.hasPaid = true;
    }

    public Boolean hasPaid() {
        return hasPaid;
    }

    public String toString(Boolean printAmount) {
        return printAmount ? printPaidStatus() +  " $" + amount + " for" :
                name + " " + printPaidStatus();
    }

    public String printPaidStatus(){
        return hasPaid ? "[Paid]" : "[Not Paid]";
    }
}
