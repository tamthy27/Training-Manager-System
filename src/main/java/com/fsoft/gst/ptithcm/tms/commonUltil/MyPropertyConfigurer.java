package com.fsoft.gst.ptithcm.tms.commonUltil;



/**
 * Overriding PropertyConfigurer to make the application switchable using
 * properties files.
 */
public class MyPropertyConfigurer extends org.springframework.beans.factory.config.PropertyPlaceholderConfigurer {

	/**
	 * Instantiates a new my property configurer.
	 */
	public MyPropertyConfigurer() {
		super();

	}
}
