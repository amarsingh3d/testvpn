# Torstar web automation tests
TorStar Web Automation Project
### Run UI tests for RDR
Currently it is possible only by modify of `<baseurlor>` variable in `ExternalObjects.xml` and `ExternalObjects_environment.xml` 
### Run UI tests

To run sanity UI tests cases use:

```mvn test``` 

Sanity test suite is  here `src/test/resources/Local_BStack/Full_Sanity_Suite.xml`

To run all specific UI tests cases in class:

```mvn -Dtest={Path to class with tests} test```

Note Java 8 installed should be installed, JAVA_HOME should be set

### UI tests structure 
- Test browser settings are here src/main/java/com/thestar/base/BrowserDriverFactory.java

- All asserts for elements and pages are here src/main/java/com/thestar/base/AssertObjectsonPages.java

- All web driver are here src/main/resources/Drivers

- TestNG configuration are here test/src/main/resources

- All tests presented here test/java and split by suites 

- All required dependencies are setup in pom.xml

- All test data here /ExternalObjects.xml

### Run UI tests on local Safari
Before run automation tests on local Safari please make sure that you meet all requirements https://developer.apple.com/documentation/webkit/testing_with_webdriver_in_safari

### Browserstack usage
# testvpn
