package com.fsoft.gst.ptithcm.tms.commonUltil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// TODO: Auto-generated Javadoc
/**
 * The Class WebCommonUtil.
 */
public class WebCommonUtil {

	/**
	 * Gets the base folder.
	 *
	 * @return the base folder
	 */
	public static String getBaseFolder() {
		return "/files/";
	}

	/**
	 * Gets the temp folder name.
	 *
	 * @return the temp folder name
	 */
	public static String getTempFolderName() {
		return "temp";
	}

	/**
	 * Gets the extension.
	 *
	 * @param fileName
	 *            the file name
	 * @return the extension
	 */
	/*
	 * get extension of file
	 */
	public static String getExtension(String fileName) {
		return (fileName.indexOf(".") < fileName.length()) ? fileName.substring(fileName.lastIndexOf(".") + 1) : "";
	}

	/**
	 * Gets the name without extension.
	 *
	 * @param fileName
	 *            the file name
	 * @return the name without extension
	 */
	/*
	 * get fileName without extension
	 */
	public static String getNameWithoutExtension(String fileName) {
		return (fileName.indexOf(".") > 0) ? fileName.substring(0, fileName.lastIndexOf(".")) : fileName;
	}

	/** The Constant EMAIL_P. */
	private static final Pattern EMAIL_P = Pattern.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");

	/** The Constant ZIP_P. */
	private static final Pattern ZIP_P = Pattern.compile("\\d{5}(-\\d{4})?");

	/** The Constant USERNAME_P. */
	private static final Pattern USERNAME_P = Pattern.compile("^[A-Za-z0-9_-]{3,25}");

	/**
	 * Checks if is valid email.
	 *
	 * @param email
	 *            the email
	 * @return true, if is valid email
	 */
	public static boolean isValidEmail(String email) {
		Matcher m = EMAIL_P.matcher(email);
		return m.matches();
	}

	/**
	 * Checks if is valid zip.
	 *
	 * @param email
	 *            the email
	 * @return true, if is valid zip
	 */
	public static boolean isValidZip(String email) {
		Matcher m = ZIP_P.matcher(email);
		return m.matches();
	}

	/**
	 * Checks if is valid username.
	 *
	 * @param username
	 *            the username
	 * @return true, if is valid username
	 */
	public static boolean isValidUsername(String username) {
		Matcher m = USERNAME_P.matcher(username);
		return m.matches();
	}

	/**
	 * Gets the session without suffix.
	 *
	 * @param jSession
	 *            the j session
	 * @return the session without suffix
	 */
	public static String getSessionWithoutSuffix(String jSession) {
		int index = jSession.indexOf(".");
		return index > 0 ? jSession.substring(0, index) : jSession;
	}

	/**
	 * Compare 2 double.
	 *
	 * @param value
	 *            the value
	 * @param compareValue
	 *            the compare value
	 * @return the integer
	 */
	public static Integer compare2Double(Double value, Double compareValue) {
		return new Integer(value.compareTo(compareValue));
	}

	/**
	 * Split username and password.
	 *
	 * @param input
	 *            the input
	 * @return the string[]
	 */
	public static String[] splitUsernameAndPassword(String input) {
		String username = "";
		String password = "";
		String[] tmp = input.split(Pattern.quote(Constants.SECURITY_CREDENTIAL_DELIMITER));
		username = tmp[0];
		if (tmp.length > 1) {
			password = tmp[1];
		}

		return new String[] { username, password };
	}
}
