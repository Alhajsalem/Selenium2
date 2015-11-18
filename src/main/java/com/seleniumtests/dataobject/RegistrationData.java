package com.seleniumtests.dataobject;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.testng.annotations.DataProvider;

import au.com.bytecode.opencsv.CSVReader;

public class RegistrationData {

	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String userName;
	private String country;
	private String email;
	private String password;
	private String confirmPassword;

	private Properties properties = new Properties();

	public RegistrationData() throws IOException {
		properties.load(RegistrationData.class
				.getResourceAsStream("/registrationdata.properties"));
		firstName = properties.getProperty("firstname");
		lastName = properties.getProperty("lastname");
		phoneNumber = properties.getProperty("phonenumber");
		userName = properties.getProperty("username");
		country = properties.getProperty("country");
		email = properties.getProperty("email");
		password = properties.getProperty("password");
		confirmPassword = properties.getProperty("confirmpassword");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	/**
	 * Test data provider for data hard coded with in test
	 * 
	 * @return
	 * @throws IOException
	 */
	@DataProvider(name = "regData")
	public static Object[][] getRegistrationData() throws IOException {
		RegistrationData registrationData1 = new RegistrationData();
		registrationData1.setFirstName("first name 1");
		registrationData1.setLastName("last name 1");
		registrationData1.setPhoneNumber("1234567890");
		registrationData1.setUserName("seleniumuser1");
		registrationData1.setCountry("ANGOLA");
		registrationData1.setEmail("test1@selenium.com");
		registrationData1.setPassword("123456");
		registrationData1.setConfirmPassword("123456");
		return new RegistrationData[][] { { registrationData1 } };
	}

	/**
	 * Test data provider reading data from csv file
	 * 
	 * @return
	 * @throws IOException
	 */
	@DataProvider(name = "regCSVData")
	public static Object[][] getCSVData() throws IOException {
		CSVReader csvReader = new CSVReader(new FileReader(
				RegistrationData.class.getResource("/regdata.csv").getPath()));
		List<String[]>dataList = csvReader.readAll();
		Object[][] data = new Object[dataList.size()][1];
		List<RegistrationData> regList = new ArrayList<RegistrationData>();
		for (String[] strArray:dataList) {
			RegistrationData registrationData = new RegistrationData();
			registrationData.setFirstName(strArray[0].trim());
			registrationData.setLastName(strArray[1].trim());
			registrationData.setPhoneNumber(strArray[2].trim());
			registrationData.setUserName(strArray[3].trim());
			registrationData.setCountry(strArray[4].trim());
			registrationData.setEmail(strArray[5].trim());
			registrationData.setPassword(strArray[6].trim());
			registrationData.setConfirmPassword(strArray[7].trim());
			regList.add(registrationData);
		}
		for(int i=0; i<data.length; i++) {
			for(int j=0; j<data[i].length; j++) {
				data[i][j]=regList.get(i);
			}
		}
		csvReader.close();
		return data;
	}

	@DataProvider(name = "loginData")
	public static Object[][] getLoginData() {
		return new Object[][] { { "first name 1", "password1" },
				{ "first name 2", "password2" } };
	}
}
