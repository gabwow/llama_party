package org.llama.service;

import org.llama.domain.EmptyStore;
import org.llama.domain.SnackStore;
import org.llama.domain.Stores;
import org.llama.domain.Snack;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.Resource;

import java.util.List;


@Service
public class SnackStoreService{
   @Resource(name="emptyStore")
   private SnackStore emptyStore;
   @Autowired
   private Stores knownStores;
 
   public List<Snack> getSnackList(String storeName){
      return knownStores.getOrDefault(storeName, emptyStore).getSnackPrices();
   }
}
