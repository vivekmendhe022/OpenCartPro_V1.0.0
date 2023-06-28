package com.generic.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains generic method related to property file.
 * 
 * @author Vivekanand M
 *
 */
public class PropertyFileUtility {

	/**
	 * This method read from property file for Admin
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDatafromPropertyFile(String key) throws IOException {
		FileInputStream file = new FileInputStream(IConstatantsUtility.PropertyFilePath);
		Properties pObj = new Properties();
		pObj.load(file);
		String value = pObj.getProperty(key);
		return value;
	}
	
	/**
	 * This method read data from property file for user
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readDatafromPropertyFileUser(String key) throws IOException {
		FileInputStream file = new FileInputStream(IConstatantsUtility.UserPropertyFilePath);
		Properties pObj = new Properties();
		pObj.load(file);
		String value = pObj.getProperty(key);
		return value;
	}

}
