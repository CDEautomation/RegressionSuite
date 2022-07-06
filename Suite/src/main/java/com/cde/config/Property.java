package com.cde.config;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

// TODO: Auto-generated Javadoc
/**
 * The Class Property.
 */
public class Property {
	
	/** The props. */
	static Properties props=new Properties();
	
	/** The str file name. */
	String strFileName;
	
	/** The str value. */
	String strValue;
	
	/**
	 * Gets the property.
	 *
	 * @param strKey the str key
	 * @return the property
	 */
	public String getProperty(String strKey) {
		try{
			File f = new File(strFileName);
			if(f.exists()){
				FileInputStream in=new FileInputStream(f);
				props.load(in);
				strValue=props.getProperty(strKey);
				in.close();
			}
			else
				System.out.println("File not found!");
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return strValue;
	}
	
	/**
	 * Sets the property.
	 *
	 * @param strKey the str key
	 * @param strValue the str value
	 * @throws Throwable the throwable
	 */
	public void setProperty(String strKey,String strValue) throws Throwable {
		try{
			File f = new File(strFileName);
			if(f.exists()){
				FileInputStream in=new FileInputStream(f);
				props.load(in);
				props.setProperty(strKey, strValue);
				props.store(new FileOutputStream(strFileName),null);
				in.close();
			}
			else{
				System.out.println("File not found!");
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * Removes the property.
	 *
	 * @param strKey the str key
	 */
	public void removeProperty(String strKey){
		try{
			File f = new File(strFileName);
			if(f.exists()){
				FileInputStream in=new FileInputStream(f);
				props.load(in);
				props.remove(strKey);
				props.store(new FileOutputStream(strFileName),null);
				in.close();
			}
			else
				System.out.println("File not found!");
		}
		catch (Exception e) {
			System.out.println(e);
		}

	}
	
	/**
	 * Instantiates a new property.
	 *
	 * @param strFileName the str file name
	 */
	public Property(String strFileName){
		this.strFileName=strFileName;
	}

	// return environmental details
	/**
	 * Gets the host name.
	 *
	 * @return the host name
	 * @throws UnknownHostException the unknown host exception
	 */
	public static String getHostName() throws UnknownHostException{
		InetAddress addr = InetAddress.getLocalHost();
		String hostname = addr.getHostName();

		return hostname;
	}

	
}
