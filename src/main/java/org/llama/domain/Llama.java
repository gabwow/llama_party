package org.llama.domain;

import java.util.Map;
import java.util.HashMap;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Llama{
    Map<String, Integer> snackToPreference;
    private final int snackIndex = 0;
    private final int preferenceIndex = 1;

    public Llama(){
       snackToPreference = new HashMap<>();
    }

    @PostConstruct
    public void populateFromFile() throws IOException{
        Files.lines(Paths.get("LlamaPreferences.txt")).map(line -> line.split(":")).forEach(lineInfo -> snackToPreference.put(lineInfo[snackIndex], Integer.parseInt(lineInfo[preferenceIndex])));
    }

    Map<String, Integer> getSnackPreferences(){
       return snackToPreference;
    }

    public Integer getSnackPreference(String snack){
       return snackToPreference.getOrDefault(snack, 0);
    }
}
