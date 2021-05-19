package com.example.demo.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.example.demo.group.GroupOrder1;
import com.example.demo.group.GroupOrder2;
import com.example.demo.group.GroupOrder3;

public class Greeting {

  private long id;

  @NotEmpty(groups = { GroupOrder1.class })
  @Min(value = 3, groups = { GroupOrder2.class })
  @Pattern(regexp = "[0-9a-zA-Z]+", groups = { GroupOrder3.class })
  private String content;

  public long getId() {
    return id;
  }
  
  public void setId(long id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

}