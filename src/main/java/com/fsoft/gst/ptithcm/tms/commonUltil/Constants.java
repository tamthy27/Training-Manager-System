
package com.fsoft.gst.ptithcm.tms.commonUltil;

// TODO: Auto-generated Javadoc
/**
 * The Class Constants.
 */
public class Constants {
    
	/** The Constant PAGINATION_NUMBER. */
	public static final int PAGINATION_NUMBER = 25;
	
    /** The Constant ACTION_DELETE. */
    public static final String ACTION_DELETE = "delete";
    
    /** The Constant ACTION_DISABLE. */
    public static final String ACTION_DISABLE = "disable";
    
    /** The Constant ACTION_EXPORT. */
    public static final String ACTION_EXPORT = "export";
    
    /** The Constant ACTION_SEARCH. */
    public static final String ACTION_SEARCH = "search";
    
    /** The Constant ACTION_INSERT_OR_UPDATE. */
    public static final String ACTION_INSERT_OR_UPDATE = "insert-update";
    
    /** The Constant ACTION_INSERT_OR_UPDATE_PROFILE. */
    public static final String ACTION_INSERT_OR_UPDATE_PROFILE = "insert-update-profile";
    
   
    /** The Constant DELIMITER. */
    public static final String DELIMITER = ",";
    
    /** The Constant EMAIL_DELIMITER. */
    public static final String EMAIL_DELIMITER = ";";
    
    /** The Constant SEPERATE. */
    public static final String SEPERATE = ":";
    
    /** Sort direction constants. */
    public static final String SORT_ASC = "2";
    
    /** The Constant SORT_DESC. */
    public static final String SORT_DESC = "1";

    /** The Constant MAXPAGEITEMS. */
    public static final int MAXPAGEITEMS = 20;

    /** The Constant REPORT_MAXPAGEITEMS. */
    public static final int REPORT_MAXPAGEITEMS = 100;


    //~ Static fields/initializers =============================================

    /** The Constant DATE_FORMAT. */
    public static final String DATE_FORMAT = "dd/MM/yyyy";
    
    /** The Constant VI_DATE_FORMAT. */
    public static final String VI_DATE_FORMAT = "dd-MM-yyyy HH:mm:ss";
    
    /** The Constant DB_DATE_FORMAT. */
    public static final String DB_DATE_FORMAT = "YYYY-MM-DD";
    
    /** The Constant JAVA_DATE_FORMAT. */
    public static final String JAVA_DATE_FORMAT = "yyyy-MM-dd";
    
    /** The Alphabet number for search query. */
    public static final String ALPHABET_SEARCH_PREFIX = "^$^";
    
    /** The name of the ResourceBundle used in this application. */
    public static final String BUNDLE_KEY = "ApplicationResources";

    /** File separator from System properties. */
    public static final String FILE_SEP = System.getProperty("file.separator");

    /** User home from System properties. */
    public static final String USER_HOME = System.getProperty("user.home") + FILE_SEP;

    /**
     * The name of the configuration hashmap stored in application scope.
     */
    public static final String CONFIG = "appConfig";

    /**
     * Session scope attribute that holds the locale set by the user. By setting this key
     * to the same one that Struts uses, we get synchronization in Struts w/o having
     * to do extra work or have two session-level variables.
     */
    public static final String PREFERRED_LOCALE_KEY = "org.apache.struts2.action.LOCALE";

    /** The request scope attribute that holds the list form. */
    public static final String LIST_MODEL_KEY = "items";

    /** The request scope attribute that holds the form. */
    public static final String FORM_MODEL_KEY = "item";

    /**
     * The name of the available roles list, common.a request-scoped attribute
     * when adding/editing common.a user.
     */
    public static final String AVAILABLE_ROLES = "availableRoles";

    /**
     * The name of the CSS Theme setting.
     */
    public static final String CSS_THEME = "csstheme";


    /** Acegi security constants. */

    public static final String ACEGI_SECURITY_FORM_USERNAME_KEY = "j_username";
    
    /** The Constant ACEGI_SECURITY_FORM_PASSWORD_KEY. */
    public static final String ACEGI_SECURITY_FORM_PASSWORD_KEY = "j_password";
    
    /** The Constant ACEGI_SECURITY_LAST_USERNAME_KEY. */
    public static final String ACEGI_SECURITY_LAST_USERNAME_KEY = "ACEGI_SECURITY_LAST_USERNAME";


    /** Cookie for web and content security. */
    public static final String LOGIN_USER_ID_COOKIE = "j_loggined_userid";
    
    /** The Constant LOGIN_CHECKSUM. */
    public static final String LOGIN_CHECKSUM = "j_loginned_checksum";
    
    /** The Constant LOGIN_ROLE_COOKIE. */
    public static final String LOGIN_ROLE_COOKIE = "j_role";

    /**
     * Spring Credential delimiter.
     */
    public static final String SECURITY_CREDENTIAL_DELIMITER = "${SEC_CRED}";

    /** The Constant FLG_DELETE_ON. */
    public static final String FLG_DELETE_ON = "1";
    
    /** The Constant FLG_DELETE_OFF. */
    public static final String FLG_DELETE_OFF = "0";

    /** The Constant GLOBAL_META_ROLE_PREFIX. */
    public static final String GLOBAL_META_ROLE_PREFIX = "role_";
    
    /** The Constant REPORT_REMEMBER_ME_COOKIE_KEY. */
    public static final String REPORT_REMEMBER_ME_COOKIE_KEY = "REPORT_REMEMBER_ME_COOKIE_KEY";
    
    /** The Constant CHECKSUM_SECURITY_HASH. */
    public static final String CHECKSUM_SECURITY_HASH = "VMS_REPORT_SEC_HASH";

    /** The Constant MESSAGE_RESPONSE_MODEL_KEY. */
    public static final String MESSAGE_RESPONSE_MODEL_KEY = "messageResponse";

    /** The Constant IS_WARNING. */
    public static final String IS_WARNING = "isWarning"; 
    
    /** The Constant ALERT_TYPE. */
    public static final String ALERT_TYPE = "alertType";

    /** The Constant LOGON_ROLE. */
    public static final String LOGON_ROLE = "LOGON";
    
    /** The Constant ADMIN_ROLE. */
    public static final String ADMIN_ROLE = "ADMIN";

    /** The Constant JAN. */
    //    month
    public static final Integer JAN = 1;
    
    /** The Constant FEB. */
    public static final Integer FEB = 2;
    
    /** The Constant MAR. */
    public static final Integer MAR = 3;
    
    /** The Constant APR. */
    public static final Integer APR = 4;
    
    /** The Constant MAY. */
    public static final Integer MAY = 5;
    
    /** The Constant JUN. */
    public static final Integer JUN = 6;
    
    /** The Constant JUL. */
    public static final Integer JUL = 7;
    
    /** The Constant AUG. */
    public static final Integer AUG = 8;
    
    /** The Constant SEP. */
    public static final Integer SEP = 9;
    
    /** The Constant OTC. */
    public static final Integer OTC = 10;
    
    /** The Constant NOV. */
    public static final Integer NOV = 11;
    
    /** The Constant DEC. */
    public static final Integer DEC = 12;
}
