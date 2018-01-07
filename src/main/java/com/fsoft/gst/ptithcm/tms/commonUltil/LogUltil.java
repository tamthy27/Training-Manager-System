/**
 * 
 */
package com.fsoft.gst.ptithcm.tms.commonUltil;

import java.util.Date;

import com.fsoft.gst.ptithcm.tms.model.Log;

/**
 * The Class LogUltil.
 *
 * @author NVTT Jun 11, 2017
 */
public class LogUltil {
	
	/**
	 * New log.
	 *
	 * @return the log
	 */
	public static Log newLog() {
		Log log = new Log();
		log.setCreatedBy(SessionUtil.getUserSession());
		log.setCreatedDate(new Date());
		log.setLastModifiedBy(SessionUtil.getUserSession());
		log.setLastModifiedDate(new Date());
		log.setFlagDelete(false);

		return log;
	}
}
