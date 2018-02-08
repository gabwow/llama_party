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
    Map<String, Snack> snackToPreference;
    private final int snackIndex = 0;
    private final int preferenceIndex = 1;
    Snack emptySnack;

    public Llama(){
       snackToPreference = new HashMap<>();
    }

    @PostConstruct
    public void populateFromFile() throws IOException{
        Files.lines(Paths.get("LlamaPreferences.txt")).map(line -> line.split(":")).
                      forEach(lineInfo -> snackToPreference.put(lineInfo[snackIndex], new Snack().
                         preferenceScore(Integer.parseInt(lineInfo[preferenceIndex])).
                         name(lineInfo[snackIndex])
                    ));
        emptySnack = new Snack();
    }

    Map<String, Snack> getSnackPreferences(){
       return snackToPreference;
    }

    public Snack getSnackPreference(String snack){
      return snackToPreference.getOrDefault(snack, emptySnack);
    }
}
