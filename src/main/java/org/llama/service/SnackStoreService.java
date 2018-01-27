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
   @Resource(name="emptyStore")
   private SnackStore emptyStore;
   @Autowired
   private Stores knownStores;
 
   public Map<String, Integer>  getSnackList(String storeName){

      return knownStores.getOrDefault(storeName, emptyStore).getSnackPrices();
   }
}
