# APPLITOOLS HACKATHON SOLUTION USING TRADITIONAL AUTOMATION APPROACH
This file contains details about the traditional approach used for automating the user scenarios provided in [hackathon instruction](https://applitools.com/hackathon-instructions). 
# Tools Used
* Build Automation Tool - Maven
* Programming Language - Java
* Testing Framework - TestNG
# Project Structure - The project structure is shown below - 
```
Traditional_Approach
├
├───Chrome_Driver
├───src
│   ├
│   │
│   │
│   └───test
│       ├───java
│       │   └───com
│       │       └───applitools
│       │           ├───base
│       │           ├───listener
│       │           ├───tests
│       │           └───webpages
│       │               └───factory
│       └───resources
├___environment.properties
|___TestNG.xml
|___pom.xml
└───TestData
```
# Package Components in the project -
	* Chrome_Driver - Contains the chrome_driver.exe
	* com.applitools.base package - Contains Base Class for getting and closing driver object
	* com.applitools.listener package - Contains Listener Class for capturing screen shots for failed test cases
	* com.applitools.tests package - Contains test classes
	* com.applitools.webpages.factory packages - Contains the page factory objects for respective pages
# TestNG.xml -
	Contains the test cases and the mode of execution (parallel / sequential)
	```
	<?xml version="1.0" encoding="UTF-8"?>
	<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
	<suite name="AAPLITOOLS_SUITE">
		<listeners>
			<listener
				class-name="com.applitools.listener.ScreenShotListener" />
		</listeners>
		<test name="LOGIN_PAGE" parallel="methods" thread-count="10">
			<classes>
				<class name="com.applitools.tests.LoginPageUIElementsTest" />
			</classes>
		</test>
		<test name="DATA_DRIVEN_TEST">
			<classes>
				<class name="com.applitools.tests.LoginPageDataDrivenTesting" />
			</classes>
		</test>
		<test name="TABLE_SORT_TEST">
			<classes>
				<class name="com.applitools.tests.TableSortTest" />
			</classes>
		</test>
		<test name="CANVAS_CHART_TEST">
			<classes>
				<class name="com.applitools.tests.CanvasChartTest" />
			</classes>
		</test>
		<test name="DYNAMIC_CONTENT_TEST" parallel="methods"
			thread-count="2">
			<classes>
			<class name="com.applitools.tests.DynamicContentTest" />
			</classes>
		</test>
	</suite>
	```
# 'environment.properties' - It contains the V1 and V2 test environments URLs. During execution we will pass them as parameters
	```
	V1_URL = https://demo.applitools.com/hackathon.html
	V2_URL = https://demo.applitools.com/hackathonV2.html
	DYNAMIC_V1_URL = https://demo.applitools.com/hackathon.html?showAd=true
	DYNAMIC_V2_URL = https://demo.applitools.com/hackathonV2.html?showAd=true
	```
# Execution of the project - 
	Pre-Requisites -
		* Maven is installed
	Execution command -
		* 'mvn -f pom.xml clean test -DAPP_URL=V1_URL -DDYNAMIC_URL=DYNAMIC_V1_URL' for execution in V1 environment
		* 'mvn -f pom.xml clean test -DAPP_URL=V2_URL -DDYNAMIC_URL=DYNAMIC_V2_URL' for execution in V2 environment
	TestNG Report -
		Navigate to 'Traditional_Approach\target\surefire-reports' and click on 'index.html' page
