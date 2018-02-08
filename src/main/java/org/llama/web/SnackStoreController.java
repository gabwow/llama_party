package org.llama.web;

import org.llama.service.SnackStoreService;
import org.llama.domain.Snack;

import java.util.Arrays;
import java.util.List;

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
   public ResponseEntity<List<Snack>> getSnackList(@RequestParam(value="name", defaultValue="") String store ){
      return ResponseEntity.ok(snackStoreService.getSnackList(store));
   }

   @RequestMapping("/stores")
   public ResponseEntity<List<String>> getAllStores(){
      String[] stores = {"Atlantis", "Artisanal Beards and Snacks"};
      return ResponseEntity.ok(Arrays.asList(stores));
   }

}
