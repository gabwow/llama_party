package org.llama.domain;

import java.util.List;
import java.util.LinkedList;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct; 

@Component
public class FileSnackStore implements SnackStore {
   private List<Snack> snackPrices;
   
   
   public FileSnackStore(){
       snackPrices = new LinkedList<>();
   }
 
  private Snack buildSnack(String info){
     String[] snackValues = info.split(":");
     return (new Snack()).name(snackValues[SNACK_INDEX])
                     .price(Integer.parseInt(snackValues[COST_INDEX]));
  } 

  public void populateFromFile(String filePath) throws IOException {
       try(Stream<String> items = Files.lines(Paths.get(filePath))) {
           snackPrices = items.map(line ->  buildSnack(line)).collect(Collectors.toList());
       }
  }

   public List<Snack> getSnackPrices(){
       return snackPrices;
   }

}
