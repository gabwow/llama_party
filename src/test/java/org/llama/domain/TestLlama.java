package org.llama.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.Resource;


import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestLlama{
   @Autowired
   private Llama testLlama;

   @Resource
   private FileSnackStore atlantisSnacks;
   @Resource
   private FileSnackStore beardsAndSnacks; 
   
  @Test
   public void llama_properlyPopulated(){
        
       Map<String, Snack> snackPrefs = testLlama.getSnackPreferences();
       List<Snack> atlantisPrices = atlantisSnacks.getSnackPrices();
       Set<Snack> allKeys =  new HashSet<>();
       allKeys.addAll(atlantisPrices);
       allKeys.addAll(beardsAndSnacks.getSnackPrices());
       Set<String> allNames = allKeys.stream().map(Snack::getName).collect(Collectors.toSet());
       assertThat(snackPrefs).isNotEmpty().hasSize(allNames.size());
       assertThat(allNames).containsOnlyElementsOf(snackPrefs.keySet());
  }

   @Test
   public void llama_getUnknownSnack_noPref(){
      assertThat(testLlama.getSnackPreference("Dog meat")).isEqualTo(new Snack());
   }

}
