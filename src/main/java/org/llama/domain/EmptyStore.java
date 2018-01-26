package org.llama.domain;

import java.util.Map;
import java.util.HashMap;
import org.springframework.stereotype.Component;

@Component(value="emptyStore")
public class EmptyStore implements SnackStore{
   private final Map<String, Integer> snackPrices;

   public EmptyStore(){
       snackPrices = new HashMap<>();
   }

   public Map<String, Integer> getSnackPrices(){
       return snackPrices;
   }


}
