package com.jfb.workshopcassandra.models.embedded;

import com.jfb.workshopcassandra.models.enums.PropType;

import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@UserDefinedType("prop")
public class Prop {

  private String name;
  private String value;
  private PropType type;

  public Prop() {
  }

  public Prop(String name, String value, PropType type) {
    this.name = name;
    this.value = value;
    this.type = type;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getValue() {
    return this.value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public PropType getType() {
    return this.type;
  }

  public void setType(PropType type) {
    this.type = type;
  }

}
