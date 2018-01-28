package org.llama;

import org.llama.domain.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App{

  @Bean
  public FileSnackStore atlantisSnacks(){ 
      return new FileSnackStore();
  }
  @Bean
  public FileSnackStore beardsAndSnacks(){ 
      return new FileSnackStore();
  }

  public static void main(String[] args){
     SpringApplication.run(App.class, args);
  }

}
