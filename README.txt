LetsRace 
Version : 1.0.0

LetsRace is an Console application, implemented in Java.


Javadoc :
TODO


RUNNING THE APPLICATION FROM THE COMMAND LINE
---------------------------------------------------
A convenience jar is supplied, so that you can run the app locally, without 
needing to do a complete build, if desired. You may run the app using, AFTER completing the SETUP steps below :

[LETSRACE_HOME]/target>java -jar LetsRace.jar -c=2
[PS. The argument passed represents the number of races to run]

This convenience jar is located in the target directory, and contain the dependancies needed to run the application.

To run the application with logging to a file, execute the following:
java -Djava.util.logging.config.file=C:\\Temp\\logging.properties -jar lets-race-jar.jar -c=2

REQUIREMENTS
---------------------------------------------------
JDK 1.8.0 (or later) is required to compile LetsRace.
Apache Maven 3.6.3 (or later)
Refer to the pom.xml file detailing the dependant libraries:


GETTING STARTED
---------------------------------------------------
SETUP:
1. Ensure that MySQL is installed
2. Run the MySQL Command Line Client
3. After logging in execute the following command (command to created the database used by the application): 
	CREATE DATABASE IF NOT EXISTS racing_game_db;
4. You have to option to run the sql statements interactively or execute the statements from the sql file.
	4.1 To execute interactively: open the following script file [LETSRACE_HOME]/scripts/create_load_tables.sql
	4.2 Execute each sql statements
5.	Execute the following to compile and package: mvn compile package
	- this step involves downloading the required dependancies
	- the compiled jar file will copied to the [LETSRACE_HOME]/target folder
	
PS.: The database password is currently hardcoded as K1ll3r$16o1. This SHOULD be read from a properties file.


LOGGING
---------------------------------------------------
LetsRace uses the logging services of the JDK.

Logging for your machine is usually configured using this file :
[JDK_HOME]/jre/lib/logging.properties

TODO
- JUnit tests
- store database password in a properties file


