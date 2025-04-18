# Brandon Kang (brand0nnn) - Project Portfolio Page

## Overview
PayPals is a CLI-based application that aims to provide assistance in simplifying payments by minimising the number of transactions needed to balance expenses.

### Summary of Contributions

Given below are my contributions to the project.

* **New Feature**: Added data storage within groups
  * What it does: This feature introduces the ability to store data for a group into a save file. It includes methods for 
    loading data from the save file to memory, and saving data from memory to save files.
  * Justification: The ability to store data is essential for preserving data between program executions. By storing data in files,
    users can continue their tracking and maintain a record of their transactions even after closing the application. This feature enhances
    the usability and practicality of the application.
  * Highlights: The data gets automatically saved after each command that requires modification of the data 
    (such as `AddCommand`, `DeleteCommand`, etc).


* **New Feature**: Implemented Edit Command
  * What it does: This feature allows users to modify the current activities and their relevant data that have been added previously.
    It includes editing for the activity description, the name of the payer for an activity, the name of someone that owes money, 
    and the amount owed by a person.
  * Justification: The implementation of an Edit Command was a critical design decision aimed at enhancing the flexibility 
    and usability of the application. Users often need the ability to modify existing transactions, whether to correct errors, 
    update details as circumstances change, or reflect new information that was not available at the time of initial entry. 
    By providing an Edit Command, the application avoids the need for users to delete and re-enter transactions, which reduces 
    the risk of data loss and minimizes user effort. 
  * Highlights: The design of the command allows for granular edits, ensuring
    that only the intended field is updated. This improves data integrity and user confidence in the system.


* **General Contributions**: Abstraction of Commands, Exceptions, and Logging
  * What it does:
    * Commands: All the command types implemented are inherited from a base abstract class `Command`, providing a standardized 
      format for all commands in the application.
    * Exceptions: Centralizes exception handling logic using enumerations for all exception messages, allowing for easy error
      reporting and graceful error recovery across the application.
    * Logging: Encapsulation of logging logic for consistent logging across the application.
  * Justification: Abstraction of Commands, Exceptions and Logging enhances the overall structure and maintainability of the codebase.
    It hides the complex inner workings of components behind simple interfaces, allowing developers to work with 
    high-level concepts without getting bogged down in implementation details.


* **Enhancement to Existing Features**:
  * Preventing the user from editing the amount owed by a person after it has been marked as paid. (Pull Request [#106](https://github.com/AY2425S2-CS2113-T13-2/tp/pull/106))
  * Wrote additional JUnit tests for existing features to increase test coverage. (Pull Requests [#96](https://github.com/AY2425S2-CS2113-T13-2/tp/pull/96), 
    [#109](https://github.com/AY2425S2-CS2113-T13-2/tp/pull/109), [#111](https://github.com/AY2425S2-CS2113-T13-2/tp/pull/111), [#113](https://github.com/AY2425S2-CS2113-T13-2/tp/pull/113), [#121](https://github.com/AY2425S2-CS2113-T13-2/tp/pull/121), [#141](https://github.com/AY2425S2-CS2113-T13-2/tp/pull/141), [#171](https://github.com/AY2425S2-CS2113-T13-2/tp/pull/171))


* **Code Contributed**: [RepoSense Link](https://nus-cs2113-ay2425s2.github.io/tp-dashboard/?search=brand0nnn&breakdown=true)


* **Documentation**
  * User Guide
    * Added initial outline of User Guide and added the Features section. (Pull Request [#88](https://github.com/AY2425S2-CS2113-T13-2/tp/pull/88))
    * Added Command Reference Table, and updated Command Format for all commands with full details and sample code.
      (Pull Request [#107](https://github.com/AY2425S2-CS2113-T13-2/tp/pull/107))
  * Developer Guide
    * Added initial content for the following sections: Table of Contents, Acknowledgements, Product Scope, v1.0 User Stories, Non-Functional Requirements, Glossary and 
      Instructions for Manual Testing. (Pull Request [#87](https://github.com/AY2425S2-CS2113-T13-2/tp/pull/87))
    * Added initial UML diagram for Command Class inheritance. (Pull Request [#91](https://github.com/AY2425S2-CS2113-T13-2/tp/pull/91))
    * Added content details of Command Component. (Pull Request [#93](https://github.com/AY2425S2-CS2113-T13-2/tp/pull/93))
    * Added content details of Storage Component. Added sequence diagram for loading of save file. Added sample image of save file. 
      (Pull Request [#95](https://github.com/AY2425S2-CS2113-T13-2/tp/pull/95), [#127](https://github.com/AY2425S2-CS2113-T13-2/tp/pull/127))
    * Added content details of UI and Parser Component. (Pull Request [#107](https://github.com/AY2425S2-CS2113-T13-2/tp/pull/107))
    * Added UML Class diagram to provide an overview of the main classes. (Pull Request [#138](https://github.com/AY2425S2-CS2113-T13-2/tp/pull/138))


* **Project Management**
  * Led discussions on project implementation.
  * Maintained issues and managed milestones.
  * Conducted triaging of bugs during and after PE-D.


* **Community**
  * Pull Requests reviewed: [#98](https://github.com/AY2425S2-CS2113-T13-2/tp/pull/98), [#108](https://github.com/AY2425S2-CS2113-T13-2/tp/pull/108), [#114](https://github.com/AY2425S2-CS2113-T13-2/tp/pull/114), [#115](https://github.com/AY2425S2-CS2113-T13-2/tp/pull/115), [#139](https://github.com/AY2425S2-CS2113-T13-2/tp/pull/139), [#154](https://github.com/AY2425S2-CS2113-T13-2/tp/pull/154), [#181](https://github.com/AY2425S2-CS2113-T13-2/tp/pull/181), [#182](https://github.com/AY2425S2-CS2113-T13-2/tp/pull/182), [#184](https://github.com/AY2425S2-CS2113-T13-2/tp/pull/184)
  * Reported bugs and suggestions for other teams in the class: [#1](https://github.com/brand0nnn/ped/issues/1), [#2](https://github.com/brand0nnn/ped/issues/2), [#3](https://github.com/brand0nnn/ped/issues/3), [#4](https://github.com/brand0nnn/ped/issues/4), [#5](https://github.com/brand0nnn/ped/issues/5), [#6](https://github.com/brand0nnn/ped/issues/6), [#7](https://github.com/brand0nnn/ped/issues/7), [#8](https://github.com/brand0nnn/ped/issues/8), [#9](https://github.com/brand0nnn/ped/issues/9), [#10](https://github.com/brand0nnn/ped/issues/10)