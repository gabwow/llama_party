package org.llama.domain;

import java.util.Map;
import java.util.HashMap;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import org.springframework.stereotype.Component;

@Component(value="atlantisSnackStore")
public class AtlantisSnacks implements SnackStore{
   private final Map<String, Integer> snackPrices;

   public AtlantisSnacks(){
       snackPrices = new HashMap<>();
       try{
           Files.lines(Paths.get("AtlantisSnacks.txt")).map(line -> line.split(":")).forEach(lineInfo -> snackPrices.put(lineInfo[SNACK_INDEX], Integer.parseInt(lineInfo[COST_INDEX])));   
       } catch(IOException ieo){}
}

   public Map<String, Integer> getSnackPrices(){
       return snackPrices;
   }

}
