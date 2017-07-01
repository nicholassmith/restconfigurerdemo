package com.nicksmith.restconfigurer.domain.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "basicmodel")
public class BasicModel {
  @Id
  @GeneratedValue
  @Column(name = "id")
  private UUID uuid;

  @Column(nullable = false, length = 120)
  @NotNull
  private String name;

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
