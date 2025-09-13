package generic_utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class File1Utility {
	public static void  main(String[] args) {
	}
	
	 public String getDataFromPropertiesFile(String key) throws IOException {
		
		FileInputStream fis=new FileInputStream("C:\\Users\\91790\\eclipse-workspace\\A11selenium_mock\\src\\test\\resources\\mock.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
		
	}
	}


