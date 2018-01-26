package org.llama.web;

import org.llama.service.SnackStoreService;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;



@RestController
public class SnackStoreController{
   @Autowired
   private SnackStoreService snackStoreService;
   @RequestMapping("/snackStore")
   public Map<String, Integer> getSnackList(@RequestParam(value="name", defaultValue="Atlantis") String store ){
      return snackStoreService.getSnackList(store);
   }

   @RequestMapping("/stores")
   public List<String> getAllStores(){
      String[] stores = {"Atlantis", "Artisanal Beards and Snacks"};
      return Arrays.asList(stores);
   }

}
