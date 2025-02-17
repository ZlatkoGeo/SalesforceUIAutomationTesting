# Salesforce UI Automation Testing  

## Overview  
This project is designed to automate UI testing for Salesforce using Selenium with Java. It includes end-to-end (E2E) testing and UI Testing.  

## Features  
- **Automation Framework:** Selenium with Java  
- **Testing Types:** E2E, and UI Testing  
- **Salesforce Testing:** Interaction with Salesforce UI  
- **Logging & Reporting:** Log4j2 and TestNG  

## Project Structure  
📂 Project Root<br>
│-- 📂 src<br>
│ ├── 📂 main/java<br>
│ │ ├── 📂 testbase<br>
│ │ │ ├── 📂 common (Common utilities and setup)<br>
│ │ │ ├── 📂 uiSalesforceBase (Base classes for Salesforce interaction)<br>
│ │ │ ├── 📂 utilities (Additional utilities for testing)<br>
│ ├── 📂 test/java<br>
│ │ ├── 📂 uiSalesforce (Test cases for Salesforce UI)<br>
│ ├── 📂 resources (Configuration files, test data)<br>
│
│-- 📂 target (Compiled files and reports)<br>
│-- 📂 test-output (Test reports)<br>
│-- pom.xml (Maven build file)<br>
│-- mastertestng.xml (TestNG suite configuration)<br>
│-- SF Test Suite AddInfo.xml (TestNG suite configuration)<br>
│-- SF Test Suite Create.xml (TestNG suite configuration)<br>


## Prerequisites  
- Java (JDK 17 or later)  
- Maven  
- Selenium WebDriver  
- TestNG  
- Postman (for API testing)  

## Setup and Installation  
1. Clone the repository:  
   ```sh
   git clone https://github.com/ZlatkoGeo/SalesforceUIAutomationTesting.git
   cd <repository_folder>

mvn clean install

To execute tests, run:
mvn test -DsuiteXmlFile=mastertestng.xml
For specific test suites:
mvn test -DsuiteXmlFile="SF Test Suite AddInfo.xml"
mvn test -DsuiteXmlFile="SF Test Suite Create.xml"

Reporting
Test execution results can be found under the test-output folder.
Contribution
1.	Fork the repository.
2.	Create a feature branch (git checkout -b feature-branch).
3.	Commit changes (git commit -m "Your message").
4.	Push to the branch (git push origin feature-branch).
5.	Open a Pull Request.

License
This project is licensed under MIT License.

Notes
•	Use log4j2.xml for logging configurations.

You can modify details based on your preferences. Let me know if you need changes! 
