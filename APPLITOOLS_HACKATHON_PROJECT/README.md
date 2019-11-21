# APPLITOOLS HACKATHON SOLUTION USING TRADITIONAL AND VISAUAL AI AUTOMATION APPROACH
This ReadMe document contains details about the traditional and visual AI approach used for automating the user scenarios provided in [hackathon](https://applitools.com/hackathon-instructions).
# Project Structure - The project structure is shown below - 
```
 APPLITOOLS_HACKATHON_PROJECT
    ├── Chrome_Driver
    │   └── chromedriver.exe
    ├── README.md
    ├── pom.xml
    ├── src
    │   └── test
    │       └── java
    │           └── com
    │               └── applitools
    │                   ├── traditional
    │                   │   └── approach
    │                   │       ├── base
    │                   │       │   └── BaseClass.java
    │                   │       ├── testrunner
    │                   │       │   └── TraditionalTestSuite.java
    │                   │       ├── tests
    │                   │       │   ├── CanvasChartTest.java
    │                   │       │   ├── DynamicContentTest.java
    │                   │       │   ├── LoginPageDataDrivenTesting.java
    │                   │       │   ├── LoginPageUIElementsTest.java
    │                   │       │   └── TableSortTest.java
    │                   │       └── webpages
    │                   │           └── factory
    │                   │               ├── CanvasChart.java
    │                   │               ├── DynamicContentPage.java
    │                   │               ├── ExpensePage.java
    │                   │               └── LoginPage.java
    │                   └── visual
    │                       └── ai
    │                           └── approach
    │                               ├── base
    │                               │   └── VisualBaseClass.java
    │                               └── tests
    │                                   └── VisualAITests.java
    ├── traditional_environment.properties
    ├── traditional_suite.xml
    └── visual_environment.properties
```
## Traditional Approach
### Tools Used
    * Build Automation Tool - Maven
    * Programming Language - Java
    * Testing Framework - Junit
    * Automation Framework - Selenium Webdriver

### Package Components for traditional approach -
	* Chrome_Driver - Contains the chrome_driver.exe for executing tests in Chrome Browser
	* com.applitools.traditional.approach.base package - Contains Base Class for getting and closing driver object
	* com.applitools.traditional.approach.tests - Contains test classes for executing the test cases
	* com.applitools.traditional.approach.webpages.factory - Contains the page factory objects for respective pages
### 'traditional_environment.properties' - It contains the V1 and V2 test environments URLs. During execution we will pass them as parameters
```
V1_URL = https://demo.applitools.com/hackathon.html
V2_URL = https://demo.applitools.com/hackathonV2.html
DYNAMIC_V1_URL = https://demo.applitools.com/hackathon.html?showAd=true
DYNAMIC_V2_URL = https://demo.applitools.com/hackathonV2.html?showAd=true
```
### Execution of test cases via traditional approach - 
    Pre-Requisites -
		* Maven is installed
	Execution command - Navigate to project base directory and provide the below commands
		* 'mvn -f pom.xml clean test -DAPP_URL=V1_URL -DDYNAMIC_URL=DYNAMIC_V1_URL' for execution in V1 environment
		* 'mvn -f pom.xml clean test -DAPP_URL=V2_URL -DDYNAMIC_URL=DYNAMIC_V2_URL' for execution in V2 environment
	Junit Report -
		The test run report can be found under 'APPLITOOLS_HACKATHON_PROJECT\target\surefire-reports' and also in console
## Visual AI Approach
### Tools Used
    * Build Automation Tool - Maven
    * Programming Language - Java
    * Testing Framework - Junit
    * Automation Framework - Selenium Webdriver
    * Automation Tool - Applitools SDK
### Package Components for traditional approach -
	* Chrome_Driver - Contains the chrome_driver.exe for executing tests in Chrome Browser
	* com.applitools.visual.ai.approach.base - Contains Base Class for configuring web driver, Batch Info, Classic Runner and Eyes
	* com.applitools.visual.ai.approach.tests - Contains test classes for executing the test cases
### 'visual_environment.properties' - It contains the V1 and V2 test environments URLs. During execution we will pass them as parameters
```
V1_URL = https://demo.applitools.com/hackathon.html
V2_URL = https://demo.applitools.com/hackathonV2.html
DYNAMIC_V1_URL = https://demo.applitools.com/hackathon.html?showAd=true
DYNAMIC_V2_URL = https://demo.applitools.com/hackathonV2.html?showAd=true
```
### Execution of test cases via visual UI approach - 
    Pre-Requisites -
		* Maven is installed
		* API Key is set in environment by the name 'APPLITOOLS_API_KEY'
	Execution Command - Navigate to project base directory and execute the following command - 
    * 'mvn -DAPP_URL=V1_URL -DDYNAMIC_URL=DYNAMIC_V1_URL -Dtest=VisualAITests test' for execution in V1 environment
    * 'mvn -DAPP_URL=V2_URL -DDYNAMIC_URL=DYNAMIC_V2_URL -Dtest=VisualAITests test' for execution in V2 environment
    Test Results -
    The test results can be viewed in Applitools Report Dashboards
