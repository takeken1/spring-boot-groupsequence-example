package com.example.demo.controller;

import javax.validation.GroupSequence;

import com.example.demo.group.GroupOrder1;
import com.example.demo.group.GroupOrder2;
import com.example.demo.group.GroupOrder3;
import com.example.demo.model.Greeting;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GreetingController {

  @GroupSequence({ GroupOrder1.class, GroupOrder2.class, GroupOrder3.class })
  public interface GroupOrder {
  }

  @GetMapping("/greeting")
  public String greetingForm(Model model) {
    model.addAttribute("greeting", new Greeting());
    return "greeting";
  }

  @PostMapping("/greeting")
  public String greetingSubmit(@Validated(GroupOrder.class) Greeting greeting, BindingResult bindingResult,
      Model model) {
    if (bindingResult.hasErrors()) {
      return "greeting";
    }

    model.addAttribute("greeting", greeting);

    return "result";
  }

}
