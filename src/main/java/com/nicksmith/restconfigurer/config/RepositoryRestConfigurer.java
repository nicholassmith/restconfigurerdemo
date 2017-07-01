package com.nicksmith.restconfigurer.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestProperties;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

public class RepositoryRestConfigurer extends RepositoryRestConfigurerAdapter {
  @Autowired(required = false)
  private Jackson2ObjectMapperBuilder objectMapperBuilder;

  @Autowired
  private RepositoryRestProperties properties;

  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
    this.properties.applyTo(config);
  }

  @Override
  public void configureJacksonObjectMapper(ObjectMapper objectMapper) {
    if (this.objectMapperBuilder != null) {
      this.objectMapperBuilder.configure(objectMapper);
    }
  }
}
