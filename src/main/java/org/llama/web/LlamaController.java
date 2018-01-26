package org.llama.web;

import org.llama.service.LlamaService;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;


@RestController
public class LlamaController{
   @Autowired
   private LlamaService llamaService;
  
   @RequestMapping("/llama")
   public Integer getSnackPreference(@RequestParam(value="snack") String snack ){
      return llamaService.getSnackPreference(snack);
   }
}
