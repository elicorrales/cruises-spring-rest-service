package com.eli.cruises.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@PropertySource("classpath:webservice.properties")
@ComponentScan(basePackages="com.eli.cruises")
 class WebServicesConfig extends WebMvcConfigurerAdapter  {

	private static final Logger logger = LoggerFactory.getLogger(WebServicesConfig.class);


     WebServicesConfig() {
    	logger.debug("\n\n\nConstructor\n\n\n");
    }

/*
    @Bean(name = Bus.DEFAULT_BUS_ID) //this is REQUIRED or you get "No bean named 'cxf' is defined"
	public SpringBus cxf() {
        logger.debug("\n\n\n\nWebServiceContext cxf (SpringBus) \n\n\n\n");
	    return new SpringBus();
	}


    @Bean
    public CruiseWebService cruiseWebServiceImpl() {
		logger.debug("\n\n\n\nWebServiceContext shapeCalculatorWebServiceImpl \n\n\n\n");
    	return new CruiseWebServiceImpl();
    }
 

    @Bean
    public JacksonJsonProvider jsonProvider() {
		logger.debug("\n\n\n\nWebServiceContext jsonProvider \n\n\n\n");
    	return new JacksonJsonProvider();
    }


    @Bean
    public Swagger2Feature swagger2Feature() {
    	Swagger2Feature swagger = new Swagger2Feature();
    	swagger.setScanAllResources(true);
    	return swagger;
    }


    @Bean
    @DependsOn("cxf")
    public Server jaxRsServer() {

		logger.debug("\n\n\n\nWebServiceContext JaxRsServer \n\n\n\n");
    	JAXRSServerFactoryBean factory = new JAXRSServerFactoryBean();
    	//factory.setServiceBean(shapeCalculatorWebServiceImpl());
    	factory.setServiceBean(cruiseWebServiceImpl());

    	//OLD
    	//this works for straight REST but..
    	//factory.setAddress("/rest/shapecalc");

    	//NEW
    	// '/shapecalc' portion of URL moved to Service Interface
    	factory.setAddress("/rest");

    	//NEW - For Swagger
    	factory.setProvider(jsonProvider());
    	List<Feature> features = new ArrayList<Feature>();
    	features.add(swagger2Feature());
    	factory.setFeatures(features);

		logger.debug("\n\n\n\nEND OF WebServicesConfig JaxRsServer \n\n\n\n");
    	return factory.create();
    }
*/
}
