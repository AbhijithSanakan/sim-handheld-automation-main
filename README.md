# IMAF
Infosys Mobile Automation Framework - BDD

To compile and generate the XML files based on platform, use the below maven command
COMPILATION & EXECUTION : mvn compile exec:java

To execute test, use the below command.
clean test -Dsurefire.suiteXmlFiles=TestNgD.xml -Dconfig=Config.Properties -Denv=QA1 site
