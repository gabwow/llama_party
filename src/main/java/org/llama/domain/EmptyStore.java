package org.llama.domain;


import java.util.List;
import java.util.LinkedList;
import org.springframework.stereotype.Component;

@Component(value="emptyStore")
public class EmptyStore implements SnackStore{
   private final List<Snack> snackPrices;

   public EmptyStore(){
       snackPrices = new LinkedList<>();
   }

   public List<Snack> getSnackPrices(){
       return snackPrices;
   }


}
