package com.applitools.traditional.approach.testrunner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)				
@Suite.SuiteClasses({				
  		com.applitools.traditional.approach.tests.LoginPageUIElementsTest.class,
  		com.applitools.traditional.approach.tests.LoginPageDataDrivenTesting.class,
  		com.applitools.traditional.approach.tests.TableSortTest.class,
  		com.applitools.traditional.approach.tests.CanvasChartTest.class,
  		com.applitools.traditional.approach.tests.DynamicContentTest.class,
})		

public class TraditionalTestSuite {				
}