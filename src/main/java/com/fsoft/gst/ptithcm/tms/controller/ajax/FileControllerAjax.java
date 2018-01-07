/**
 * 
 */
package com.fsoft.gst.ptithcm.tms.controller.ajax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Thy Dinh Jun 18, 2017
 *
 */

@RestController
@RequestMapping(value = { "/file" })
public class FileControllerAjax {

	@RequestMapping(value = { "/file", "" }, method = RequestMethod.GET)
	public void getFile( HttpServletResponse response,
			HttpServletRequest request) {
		String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/downloads/");
		String fileName = "TRAININGMANAGERSYSTEM_TRAINEEACCOUNTS.xlsx";
		Path file = Paths.get(dataDirectory, fileName);
		if (Files.exists(file)) {
			if (file.endsWith("xlsx")) {
				response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			} else if (file.endsWith("xls")) {
				response.setContentType("application/pdf");
			}			
			response.addHeader("Content-Disposition", "attachment; filename=" + fileName);
			try {
				Files.copy(file, response.getOutputStream());
				response.getOutputStream().flush();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}
}
