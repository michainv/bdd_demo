# BDD Workshop Demo Project

This project is a Test automation project implemented with BDD principals.


Site to be tested was http://168.119.186.3/

This a Java Maven project
uses Selenium,Cucumber and SerenityBDD framework

Selenium Version : 4.1.4
Serenity Version : 3.2.5
Junit : 5
Cucumber : 7.2.3
Java : 8


Cucumber with SerenityBDD can offer nice reporting, while SerenityBDD  
offers some existing methods to handle browser instantiation and can easily configure  
different environments through serenity.config file and also offer implementation of 
common and frequently used methods.

### The project package structure is the following :


### utils:

    Common helper methods, not specific to any Test or Case.

### actions

    Generalized functionalities so they can be reused,
    mainly as preconditions for other test scenarios/cases.

### steps

    All steps defined for different site pages.
    Classes defined all extend CoreSteps

### pages

    Holds all the selectors used by steps.
    The selector are stored as static By selectors.
    This class should have no logic or steps only selectors.
    The element location and/or interactions should all happen in steps package clases
    Classes defined all extend CorePage


### runners

    All test runners,predefined to run for the core @tag annotation for a feature
    They can be configured with different tag values in order to run specific tests
    TestRunner class is used to execute all tests

### features

    Holds all site features that are defined 
    Using gherkin language and trying to parameteerize as much as possible the step definitions

## How to execute tests

    Through the existing runners:
    The tag parameters can be changed to run desired features  

    Through terminal:
        -type mvn clean verify test -Dtags="tag1" to execute all features with the value @tag1
        Tag values can be combined( and logic) when separated by ","
        e.g. mvn clean verify test -Dtags="UserLogin,Positive" will execute features  
        tagged with @UserLogin and @Positive
        
         -type mvn clean verify test -Dtest="Runner" to execute runner class called "Runner"

### General

    You can check Scenarios and Cases implemented in src/test/resources/features
    The are split per different page functionalities and features