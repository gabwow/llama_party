package org.llama.domain;

import java.util.List;
import java.util.LinkedList;
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
   private final List<Snack> snackPrices;
   
   
   public FileSnackStore(){
       snackPrices = new LinkedList<>();
   }

   void populateFromFile(String filePath) throws IOException {
       try(Stream<String> items = Files.lines(Paths.get(filePath))) {
           items.map(line -> line.split(":")).forEach(lineInfo -> snackPrices.add(
                (new Snack()).name(lineInfo[SNACK_INDEX])
                             .price(Integer.parseInt(lineInfo[COST_INDEX]))
                 ));
       }
   }

   public List<Snack> getSnackPrices(){
       return snackPrices;
   }

}
