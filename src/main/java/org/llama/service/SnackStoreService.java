package org.llama.service;

import org.llama.domain.ArtisanalBeardsAndSnacks;
import org.llama.domain.EmptyStore;
import org.llama.domain.SnackStore;
import org.llama.domain.Stores;
import org.llama.domain.AtlantisSnacks;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.Resource;

import java.util.Map;


@Service
public class SnackStoreService{
   @Autowired
   private Stores knownStores;
   @Resource(name="atlantisSnackStore")
   private SnackStore atlantisSnacks;
   @Resource(name="emptyStore")
   private SnackStore emptyStore;
   @Resource(name="beardsAndSnacks")
   private SnackStore beardsAndSnacks;
 

   public Map<String, Integer>  getSnackList(String storeName){
      knownStores.put("Atlantis", atlantisSnacks);
      knownStores.put("Artisanal Beards and Snacks", beardsAndSnacks);

      return knownStores.getOrDefault(storeName, emptyStore).getSnackPrices();
   }
}
