package com.fsoft.gst.ptithcm.tms.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/* Class ApplicationContextConfig được sử dụng để khai báo các Spring BEAN. Nó được chú thích bởi @Configuration. 
 *	@ComponentScan("com.fsoft.gst.ptithcm.tms.*"") - Nói với Spring tìm kiếm các Spring BEAN khác, 
 * và các Controller trong các package "con trực tiếp" của package com.fsoft.gst.ptithcm.tms.*".
*/
/**
 * The Class ApplicationContextConfig.
 * 
 * @author NVTT May 13, 2017
 */
@Configuration
@ComponentScan("com.fsoft.gst.ptithcm.tms.*")
public class ApplicationContextConfig {

	/**
	 * Gets the view resolver.
	 * 
	 * @return the view resolver
	 */
	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver getMultipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(20971520);
		multipartResolver.setMaxInMemorySize(1048576);
		return multipartResolver;
	}

}