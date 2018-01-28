package org.llama.domain;

import java.util.HashMap;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;


@Component
public class Stores extends HashMap<String, SnackStore>{

   
   @Resource
   private FileSnackStore atlantisSnacks;
   @Resource
   private FileSnackStore beardsAndSnacks;

   
   @PostConstruct
   public  void init(){
     atlantisSnacks.populateFromFile("AtlantisSnacks.txt");
     beardsAndSnacks.populateFromFile("ArtisanalSnacks.txt");
     this.put(LlamaStrings.ATLANTIS, atlantisSnacks);
     this.put(LlamaStrings.BEARDS_AND_SNACKS, beardsAndSnacks);
   }

}


