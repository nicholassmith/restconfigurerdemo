package com.nicksmith.restconfigurer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.data.mapping.context.PersistentEntities;
import org.springframework.data.repository.support.Repositories;
import org.springframework.data.repository.support.RepositoryInvokerFactory;
import org.springframework.data.rest.core.UriToEntityConverter;


public class ValidatingUriToEntityConverter extends UriToEntityConverter {

  protected PersistentEntities entities;

  @Autowired
  public ValidatingUriToEntityConverter(PersistentEntities entities, RepositoryInvokerFactory invokerFactory,
                                        Repositories repositories) {
    super(entities, invokerFactory, repositories);
    this.entities = entities;
  }

  @Autowired
  @Override
  public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
    Object conversion = super.convert(source, sourceType, targetType);
    //DO VALIDATION HERE
    System.out.println("Custom convert");
    return conversion;
  }
}
