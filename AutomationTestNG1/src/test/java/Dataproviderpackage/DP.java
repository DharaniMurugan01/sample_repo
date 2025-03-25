package Dataproviderpackage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DP{
	  @DataProvider(name="testdata",parallel=true)
	  public Object[][] dataprofun(){
	 	 return new Object[][] {{"selenium"},{"TestNG"},{"automation"}};
	  }
}
