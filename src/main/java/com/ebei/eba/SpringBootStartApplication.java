package com.ebei.eba;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class SpringBootStartApplication extends SpringBootServletInitializer
{
  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder)
  {
    return builder.sources(new Class[] { Application.class });
  }
}