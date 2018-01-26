package org.llama.domain;

import java.util.Map;
import java.util.HashMap;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.stereotype.Component;

@Component
public class Llama{
    Map<String, Integer> snackToPreference;

    public Llama(){
       snackToPreference = new HashMap<>();
       try{
          Files.lines(Paths.get("LlamaPreferences.txt")).map(line -> line.split(":")).forEach(lineInfo -> snackToPreference.put(lineInfo[0], Integer.parseInt(lineInfo[1])));
       } catch(IOException ioe){}
    }

    public Map<String, Integer> getSnackPreferences(){
       return snackToPreference;
    }

    public Integer getSnackPreference(String snack){
       return snackToPreference.getOrDefault(snack, 0);
    }
}
