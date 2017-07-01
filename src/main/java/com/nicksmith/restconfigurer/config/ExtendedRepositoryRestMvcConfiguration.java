package com.nicksmith.restconfigurer.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.rest.core.UriToEntityConverter;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@Configuration
public class ExtendedRepositoryRestMvcConfiguration extends RepositoryRestMvcConfiguration implements InitializingBean {
  @Override
  @ConfigurationProperties(prefix = "spring.data.rest")
  public RepositoryRestConfiguration config() {
    RepositoryRestConfiguration config = super.config();
    config.setMaxPageSize(100);
    return config;
  }

  @Override
  protected UriToEntityConverter uriToEntityConverter(ConversionService conversionService) {
    return new ValidatingUriToEntityConverter(
            persistentEntities(),
            repositoryInvokerFactory(conversionService),
            repositories());
  }
}
