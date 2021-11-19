# SpartansAPI-SDET

### Project Description
The goal of this project was to create an API testing framework for an API developed by the devs of our group, this was to be created in parallel as the api itself.
The API for this project can be accessed at this [link](https://github.com/LewisT543/SpartansAPI-Devs).

#Table of Contents

1. [Functionality Covered](#Functionality)
2. [Setup Guide](#1-setup-guide)
3. [Server setup](#2-run-the-server)
5. [Acknowledgements](#6-acknowledgements)



###1. Functionality Covered <a name="Functionality"></a>

- [x]  Multiple endpoints and granular filtering
- [x]  Crud commands
- [x]  

### 2. Setup Guide <a name="1-setup-guide"></a>
In order to run the framework you need to run the pom.xml file so Maven can fetch the required dependencies, and you need to have the correct url in the connection manager.

### 3. Run the Server   <a name="2-run-the-server"></a>

The API framework can be run by running the main method of the `RunTests` class located in the cucumber package in the test folder

```java
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {"pretty", "html:target/testReport.html", "json:target/jsonReport.json"}

)
public class RunTests {
}
```


### 4. Acknowledgements <a name="6-acknowledgements"></a>

- We would like to take moment to thank my trainers Manish, Neil, Nish and Cathy for the help and support in putting this project together.
- We would like to thank the C# group for helping us with this project.
- We would like to thank Richard for participating in this project as the Product Owner.