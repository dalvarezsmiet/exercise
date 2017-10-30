## Problem statement

We are building a simple web application for the commune of city of Lausanne. The city has a list of residents (stored in a file **user.json** ) with the following information: social security number, first name, last name, email, date of birth, mobile number and town.

The commune has to develop several features to help the authorities to search and query the resident file information:

1. Load the list of residents into the application and display it
2. Generate a report listing all resident families with the number of adult and children (&lt;18) per family sorted by family name
3. Search a resident using email address

## Exercise

1. Load the list of user from the json file **user.json** convert them to a user list. This should be implemented in the class **UserService.loadUser().**

**Output:** All the users in the file will be loaded and displayed. 

**Improvement** : Once the list displayed try to add a Cache so that instead of loading the user list from file every time we use the cache.

- You will evaluated the way you load the JSON file and create user object and the use of basic JAVA libraries.

1. For this exercise you should load the contacts and then group them by their last name and count the number of adults and children in the group.  Then sort the result based on family name and return in the list. This algorithm should be implement in loadSortedUserGroup()

| **Last name** | **Adult (&gt;=18)** | **Children (&lt;18)** |
| --- | --- | --- |
| Mazzariol | 2 | 2 |
| Sinha | 2 | 0 |
| Srivastava | 1 | 0 |
| … |   |   |

- You will evaluated on the algorithm and the reuse of the code.

1. For the third assignment, when an email address is entered, search for a user in the list with the email address. If user is present return the user else return null. If there are multiple users with the same email address return the oldest user with this email address. This service should be implement in **UserService.getUserByEmail()**

**Output:** If user is found the user information will be displayed in a tabular format. 

- You will evaluated on the proper error handling.

## Starting the exercise

1. Download the Sprint tool suite from [http://download.springsource.com/release/STS/3.9.0.RELEASE/dist/e4.7/spring-tool-suite-3.9.0.RELEASE-e4.7.0-win32-x86\_64.zip](http://download.springsource.com/release/STS/3.9.0.RELEASE/dist/e4.7/spring-tool-suite-3.9.0.RELEASE-e4.7.0-win32-x86_64.zip)
2. Unzip the sprint tool suite go to **sts-bundle** and find STS.exe and launch the IDE
3. Once the application is running, download the exercise from the git repository [https://github.com/gautamiita/exercise](https://github.com/gautamiita/exercise) and import the exercise as Maven project.
4. To launch the application, search the file &quot;ExerciseApplication.java&quot;. Right click and &quot;Run as Java application&quot;. You will have your server running and the application page accessible on [https://localhost:8090](https://localhost:8090)

## Troubleshoot

If you can&#39;t build the application, please set up java correctly in the IDE.

The port can be updated in application.properties file. 