package com.nicksmith.restconfigurer.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestProperties;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.web.HttpMessageConvertersAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@Configuration
@ConditionalOnWebApplication
@ConditionalOnBean(RepositoryRestMvcConfiguration.class)
@ConditionalOnClass(RepositoryRestMvcConfiguration.class)
@AutoConfigureAfter({HttpMessageConvertersAutoConfiguration.class,
        JacksonAutoConfiguration.class})
@EnableConfigurationProperties(RepositoryRestProperties.class)
@Import(RepositoryRestMvcConfiguration.class)
public class ExtendedRepositoryRestMvcAutoConfiguration {
  @Bean
  public RepositoryRestConfigurer springBootRepositoryRestConfigurer() {
    return new RepositoryRestConfigurer();
  }
}
