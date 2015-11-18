package com.seleniumtests.core;

import org.testng.Assert;
import org.testng.Reporter;

import com.thoughtworks.selenium.SeleneseTestBase;

public class CustomVerification extends SeleneseTestBase {

	private StringBuffer verificationErrors;

	public CustomVerification() {
		verificationErrors = new StringBuffer();
	}

	public void verifyTrue(String msg, Boolean b) {
		try {
			Assert.assertTrue(b.booleanValue());
		} catch (Error e) {
			verificationErrors.append(e);
			Reporter.log(msg + "<br>");
		}
	}

	public void verifyFalse(String msg, Boolean b) {
		try {
			Assert.assertFalse(b.booleanValue());
		} catch (Error e) {
			verificationErrors.append(e);
			Reporter.log(msg + "<br>");
		}
	}

	public void verifyTrue(String elementDefinition, String elementLocator,
			Boolean b, String pageURL) {
		try {
			Assert.assertTrue(b.booleanValue());
		} catch (Error e) {
			verificationErrors.append(e);
			Reporter.log("Verification failed for element: "
					+ elementDefinition + ",Element locator: " + elementLocator
					+ "On page: " + pageURL);
		}
	}

	public void verifyEquals(String msg, String s1, String s2) {
		try {
			Assert.assertEquals(s1, s2);
		} catch (Error e) {
			verificationErrors.append(e);
			Reporter.log(msg + "<br>");
		}
	}

	public void verifyEquals(String msg, Object obj1, Object obj2) {
		try {
			Assert.assertEquals(obj1, obj2);
		} catch (Error e) {
			verificationErrors.append(e);
			Reporter.log(msg + " ");
		}
	}

	public void verifyNotEquals(String msg, Object obj1, Object obj2) {
		try {
			assertNotEquals(obj1, obj2);
		} catch (Error e) {
			verificationErrors.append(e);
			Reporter.log(msg + "<br>");
		}
	}

	public void verifyEquals(String msg, String str1[], String str2[]) {
		try {
			Assert.assertEquals(str1, str2);
		} catch (Error e) {
			verificationErrors.append(e);
			Reporter.log(msg + "<br>");
		}
	}

	public void verifyEquals(Object str1[], Object str2[], String msg) {
		try {
			Assert.assertEquals(((Object) (str1)), ((Object) (str2)));
		} catch (Error e) {
			verificationErrors.append(e);
			Reporter.log(msg + "<br>");
		}
	}

	public void clearVerificationErrors() {
		verificationErrors = new StringBuffer();
	}

	public void checkForVerificationErrors() {
		String verificationErrorString = verificationErrors.toString();
		// Clear Verification Errors so that it is ready to test new
		// verifications
		clearVerificationErrors();
		if (!"".equals(verificationErrorString))
			fail(verificationErrorString);
	}
}