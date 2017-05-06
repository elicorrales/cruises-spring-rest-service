package com.eli.cruises.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//public class WebAppInitializer implements WebApplicationInitializer {
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	private static final Logger logger = LoggerFactory.getLogger(WebAppInitializer.class);

	public WebAppInitializer() {
		logger.debug("\n\n\nConstructor\n\n\n");
	}

/* 
	//this is overkill to just set missing handler
	@Override
	protected DispatcherServlet createDispatcherServlet(WebApplicationContext servletAppContext) {
		final DispatcherServlet dispatcherServlet = (DispatcherServlet)super.createDispatcherServlet(servletAppContext);
		dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
		return dispatcherServlet;
	}
*/
	@Override
	protected Class<?>[] getRootConfigClasses() {

		return new Class[] { PersistenceConfig.class, WebServicesConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

    @Override
    public void customizeRegistration(ServletRegistration.Dynamic registration) {
		logger.debug("\n\n\ncustomizeRegistration\n\n\n");
        registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
    }

    /*
	 * @Override public void onStartup(ServletContext servletContext) throws
	 * ServletException {
	 * 
	 * logger.debug("\n\n\n\nWeb AppInitializer onStartup() \n\n\n\n");
	 * 
	 * AnnotationConfigWebApplicationContext rootCtx = new
	 * AnnotationConfigWebApplicationContext();
	 * rootCtx.setConfigLocation("com.eli.cruises.config");
	 * 
	 * //commenting out the customary listener causes a "no service found": //
	 * curl http://localhost:8080/project/services/rest/cruise/cruises //
	 * <html><body>No service was found.</body></html>
	 * servletContext.addListener(new ContextLoaderListener(rootCtx));
	 * 
	 * DispatcherServlet dispatcherServlet = new DispatcherServlet(rootCtx);
	 * ServletRegistration.Dynamic servletRegistration =
	 * servletContext.addServlet("dispatcher",dispatcherServlet);
	 * 
	 * servletRegistration.setLoadOnStartup(1);
	 * servletRegistration.addMapping("/");
	 * 
	 * logger.debug("\n\n\n\nEND Web AppInitializer onStartup()\n\n\n\n");
	 * 
	 * }
	 */
}
