package com.fsoft.gst.ptithcm.tms.configuration;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;


// TODO: Auto-generated Javadoc
/**
 * 
 * SpringWebAppInitializer là class thi hành (implements) 
	interface WebApplicationInitializer. 
 * Spring sẽ đọc các thông tin cấu hình trong class này để bắt đầu (initial) ứng dụng Web.
 * Thông thường trong class này có thể đăng ký các Servlet, các Servlet Filter, 
 * và Servlet Listener thay cho việc đăng ký chúng trong web.xml.
 * Một servlet quan trọng là org.springframework.web.servlet.DispatcherServlet,  cần đăng ký nó.
 */

/**
 * The Class SpringWebAppInitializer.
 * @author NVTT May 13, 2017
 */
public class SpringWebAppInitializer implements WebApplicationInitializer {
 
    /* (non-Javadoc)
     * @see org.springframework.web.WebApplicationInitializer#onStartup(javax.servlet.ServletContext)
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        
    
    	AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(ApplicationContextConfig.class);
 
        // Dispatcher Servlet
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("SpringDispatcher",new DispatcherServlet(appContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
         
        dispatcher.setInitParameter("contextClass", appContext.getClass().getName());
 
        servletContext.addListener(new ContextLoaderListener(appContext));
         
        // UTF8 Charactor Filter.
        FilterRegistration.Dynamic fr = servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
 
        fr.setInitParameter("encoding", "UTF-8");
        fr.setInitParameter("forceEncoding", "true");
        fr.addMappingForUrlPatterns(null, true, "/*");        
    }
 
}