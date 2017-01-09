package com.opt.swconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

/** 
* @ClassName: MySwaggerConfig 
* @Description: TODO 
* @author muqingyang
* @date 2017年1月9日 上午11:54:46 
*  
*/
@Configuration  
@EnableSwagger //Loads the spring beans required by the framework  
//@ComponentScan("com.opt.sw")  
public class MySwaggerConfig {
	 private SpringSwaggerConfig springSwaggerConfig;  
	  
     /**  
      * Required to autowire SpringSwaggerConfig  
      */  
     @Autowired  
     public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {  
        this.springSwaggerConfig = springSwaggerConfig;  
     }  

     /**  
      * Every SwaggerSpringMvcPlugin bean is picked up by the swagger-mvc framework - allowing for multiple  
      * swagger groups i.e. same code base multiple swagger resource listings.  
      */  
     @Bean  
     public SwaggerSpringMvcPlugin customImplementation(){  
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)  
        .includePatterns(".*?");    
     }  
}
