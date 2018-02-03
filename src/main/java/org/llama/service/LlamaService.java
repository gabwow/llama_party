package org.llama.service;

import org.llama.domain.Llama;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;

@Service
public class LlamaService{
   @Autowired
   private Llama partyLlama; 
  

   public Integer getSnackPreference(String snack){
      return partyLlama.getSnackPreference(snack); 
   }
}
