package org.llama.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

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

   @Resource(name="atlantisSnackStore")
   private SnackStore atlantisSnacks;
   @Resource(name="beardsAndSnacks")
   private SnackStore beardsAndSnacks; 
   
  @Test
   public void llama_properlyPopulated(){
       Map<String, Integer> snackPrefs = testLlama.getSnackPreferences();
       Map<String, Integer> atlantisPrices = atlantisSnacks.getSnackPrices();
       Set<String> allKeys =  new HashSet<>();
       allKeys.addAll(atlantisPrices.keySet());
       allKeys.addAll(beardsAndSnacks.getSnackPrices().keySet());
       assertThat(snackPrefs).isNotEmpty().hasSize(allKeys.size());
       assertThat(allKeys).containsExactlyElementsOf(snackPrefs.keySet());
   }

   @Test
   public void llama_getUnknownSnack_noPref(){
      assertThat(testLlama.getSnackPreference("Dog meat")).isZero();
   }

}
