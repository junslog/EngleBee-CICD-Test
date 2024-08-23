package com.beelinkers.englebee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DBConnectionTestController {

  @GetMapping("/db/conn")
  public void testDB(){

  }

}
