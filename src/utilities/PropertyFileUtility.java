package utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
	
	File file;
	FileInputStream fileInput;
	Properties prop;

	
	
	public  PropertyFileUtility(String PropertiesPath)  {
		file = new File(PropertiesPath);
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.getMessage();
		}
		prop = new Properties();
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
}
	public String getValue(String value)
	{
		return prop.getProperty(value);
	}
}






	
	



