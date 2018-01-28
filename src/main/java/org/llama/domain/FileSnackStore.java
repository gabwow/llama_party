package org.llama.domain;

import java.util.Map;
import java.util.HashMap;
import java.util.stream.Stream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct; 

@Component
public class FileSnackStore implements SnackStore {
   private final Map<String, Integer> snackPrices;
   
   
   public FileSnackStore(){
       snackPrices = new HashMap<>();
   }

   public void populateFromFile(String filePath){
       try(Stream<String> items = Files.lines(Paths.get(filePath))) {
           items.map(line -> line.split(":")).forEach(lineInfo -> snackPrices.put(lineInfo[SNACK_INDEX], Integer.parseInt(lineInfo[COST_INDEX])));
       } catch(IOException ieo){}
   }

   public Map<String, Integer> getSnackPrices(){
       return snackPrices;
   }

}
