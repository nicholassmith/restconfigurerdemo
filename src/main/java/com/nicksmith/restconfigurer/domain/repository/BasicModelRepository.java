package com.nicksmith.restconfigurer.domain.repository;

import com.nicksmith.restconfigurer.domain.model.BasicModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.UUID;

@RepositoryRestResource(path = "/basicmodels", collectionResourceRel = "basicmodels", itemResourceRel = "basicmodel")
public interface BasicModelRepository extends PagingAndSortingRepository<BasicModel, UUID> {
  @Override
  @RestResource(exported = false)
  void delete(UUID id);
}
