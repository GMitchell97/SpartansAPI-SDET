# SpartansAPI-SDET

### Project Description
The goal of this project was to create an api testing framework for an api developed by the devs of our group, this was to be created in parallel as the api itself.



###Functionality of the framework covers:
- whether all the possible endpoints that have been created return spartan objects where appropriate
- whether the correct status codes are returned
- whether the filtered search return the correct objects.
- whether startdate and enddate are in the correct format
- whether email is in the correct format

### User Instructions
In order to run the framework, the only thing that needs to be done is to ensure that the api is running, and you have the correct url in the connection manager.
However this should be changed in the future, the addition of an api key will mean that an application properties file needs to be created which will contain the key itself.
For future groups who may have to create this we have already created an api key class which will be able to lead the api key from the application properties file.


### Framework Code Approach




### Tools Used
- Cucumber 6.11
- Junit 5.8
