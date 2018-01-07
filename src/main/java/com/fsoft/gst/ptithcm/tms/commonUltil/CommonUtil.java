package com.fsoft.gst.ptithcm.tms.commonUltil;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;

import org.apache.commons.lang.StringUtils;

/**
 * The Class CommonUtil.
 */
public class CommonUtil {

	/**
	 * Instantiates a new common util.
	 */
	public CommonUtil() {
	}
    /** The Constant EMAIL_P. */
    private static final Pattern EMAIL_P = Pattern
	    .compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
    
    /** The Constant ZIP_P. */
    private static final Pattern ZIP_P = Pattern.compile("\\d{5}(-\\d{4})?");
    
    /** The Constant USERNAME_P. */
    private static final Pattern USERNAME_P = Pattern.compile("^[A-Za-z0-9_-]{3,25}");
    // private static final Pattern ALPHABET = Pattern.compile("[A-Za-z]+");

    /**
     * Checks if is valid email.
     *
     * @param email the email
     * @return true, if is valid email
     */
    public static boolean isValidEmail(String email) {
	Matcher m = EMAIL_P.matcher(email);
	return m.matches();
    }

    /**
     * Checks if is valid zip.
     *
     * @param email the email
     * @return true, if is valid zip
     */
    public static boolean isValidZip(String email) {
	Matcher m = ZIP_P.matcher(email);
	return m.matches();
    }

    /**
     * Checks if is valid username.
     *
     * @param username the username
     * @return true, if is valid username
     */
    public static boolean isValidUsername(String username) {
	Matcher m = USERNAME_P.matcher(username);
	return m.matches();
    }

    
    /**
     * Gets the name without extension.
     *
     * @param fileName the file name
     * @return the name without extension
     */
    public static String getNameWithoutExtension(String fileName) {
	return (fileName.indexOf(".") > 0) ? fileName.substring(0, fileName.lastIndexOf(".")) : fileName;
    }

   
    /**
     * Gets the extension.
     *
     * @param fileName the file name
     * @return the extension
     */
    public static String getExtension(String fileName) {
	return (fileName.indexOf(".") < fileName.length()) ? fileName.substring(fileName.lastIndexOf(".") + 1) : "";
    }

    /**
     * Generate UUID.
     *
     * @return the string
     */
    public static String generateUUID() {
	return UUID.randomUUID().toString();

    }

    /**
     * Round up.
     *
     * @param val the val
     * @param decimalDigit the decimal digit
     * @return the string
     */
    public static String roundUp(Double val, int decimalDigit) {
	if (val == null) {
	    return "";
	}
	BigDecimal decimal = new BigDecimal(val);
	decimal = decimal.setScale(decimalDigit, RoundingMode.HALF_UP);
	return decimal.toString();
    }

    /**
     * Trims, removes line breaks, multiple spaces and generally cleans text
     * before processing.
     *
     * @param input            Text to be transformed
     * @return the string
     */
    public static String cleanHtmlTags(String input) {
	try {
	    // Remove math expression
	    input = input.replaceAll("<span class=\"AM\">`", "");
	    input = input.replaceAll("`</span>", " ");
	    List<String> res = extractText(new StringReader(input));
	    input = StringUtils.join(res, ' ');
	} catch (IOException ex) {

	}

	return input;
    }

    /**
     * Extract text.
     *
     * @param reader the reader
     * @return the list
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static List<String> extractText(Reader reader) throws IOException {
	final ArrayList<String> list = new ArrayList<String>();

	ParserDelegator parserDelegator = new ParserDelegator();
	HTMLEditorKit.ParserCallback parserCallback = new HTMLEditorKit.ParserCallback() {
	    public void handleText(final char[] data, final int pos) {
		list.add(new String(data));
	    }

	    public void handleStartTag(HTML.Tag tag, MutableAttributeSet attribute, int pos) {
	    }

	    public void handleEndTag(HTML.Tag t, final int pos) {
	    }

	    public void handleSimpleTag(HTML.Tag t, MutableAttributeSet a, final int pos) {
		if (t.toString().equalsIgnoreCase("img")) {
		    list.add("###");
		}
	    }

	    public void handleComment(final char[] data, final int pos) {
	    }

	    public void handleError(final String errMsg, final int pos) {
	    }
	};
	parserDelegator.parse(reader, parserCallback, true);
	return list;
    }

    /**
     * Removes the diacritic.
     *
     * @param str the str
     * @return the string
     */
    public static String removeDiacritic(String str) {
    	String result = Normalizer.normalize(str, Normalizer.Form.NFD);
    	result = result.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    	result = result.replace('đ', 'd');
    	result = result.replace('Đ', 'D');
    	result = result.replaceAll("[^a-z A-Z0-9-]", "");
    	return result;
        }

        /**
         * Seo URL.
         *
         * @param input the input
         * @return the string
         */
        public static String seoURL(String input) {
    	String result = Normalizer.normalize(input, Normalizer.Form.NFD);
    	result = result.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    	result = result.replace('đ', 'd');
    	result = result.replace('Đ', 'D');
    	result = result.replaceAll("[^a-z A-Z0-9-]", "");
    	result = result.replaceAll(" ", "-");
    	return result.toLowerCase();
        }

    /**
     * Unaccent.
     *
     * @param input the input
     * @return the string
     */
    @SuppressWarnings("unused")
    private static String unaccent(String input) {
    	if (StringUtils.isEmpty(input)) {
    	    return "";
    	} else {
    	    String result = Normalizer.normalize(input, Normalizer.Form.NFD);
    	    result = result.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    	    result = result.replace('đ', 'd');
        	result = result.replace('Đ', 'D');
    	    return result;
    	}
    }

    /**
     * Format date.
     *
     * @param input the input
     * @return the string
     */
    public static String formatDate(Date input) {
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
	return sdf.format(input);
    }

    /**
     * Gets the config file.
     *
     * @param fileName the file name
     * @return the config file
     */
    public static File getConfigFile(String fileName) {
	String domainConfigDir = System.getProperty("jboss.domain.config.dir");
	File f;
	if (StringUtils.isNotBlank(domainConfigDir)) {
	    f = new File(domainConfigDir + File.separator + fileName);
	    if (f.exists()) {
		return f;
	    }
	}
	String configDir = System.getProperty("jboss.server.config.dir");
	if (StringUtils.isNotBlank(configDir)) {
	    f = new File(configDir + File.separator + fileName);
	    if (f.exists()) {
		return f;
	    }
	}
	return null;
    }
}
