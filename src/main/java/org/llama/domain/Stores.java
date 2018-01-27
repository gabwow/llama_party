package org.llama.domain;

import java.util.HashMap;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;


@Component
public class Stores extends HashMap<String, SnackStore>{

   @Resource(name="atlantisSnackStore")
   private SnackStore atlantisSnacks;
   @Resource(name="beardsAndSnacks")
   private SnackStore beardsAndSnacks;

   
   @PostConstruct
   public  void init(){
     this.put(LlamaStrings.ATLANTIS, atlantisSnacks);
     this.put(LlamaStrings.BEARDS_AND_SNACKS, beardsAndSnacks);
   }

}


