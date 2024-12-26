package com.jsp.spring.appconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.jsp.spring.appconfig")
public class AppConfig {

}



// no need for spring.xml file
/*in case of sub-packages we don't need to give multiple package name 
     (but we can if want)

 @ComponentScan({"com.jsp.spring.appconfig", "om.jsp.spring.appconfig.entity"})

 still it will create object for sub package classes
 */