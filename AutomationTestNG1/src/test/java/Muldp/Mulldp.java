package Muldp;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Mulldp extends Multilple{
	  @DataProvider(name="testdata1")
	  public Object[][] dataprofun(){
	 	 return new Object[][] {{"Admin","admin123"}};
	  }
}
