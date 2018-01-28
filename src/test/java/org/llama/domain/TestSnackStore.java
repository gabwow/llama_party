package org.llama.domain;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;


import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSnackStore{
   @Resource
   private FileSnackStore atlantisSnacks;

   @Autowired
   private EmptyStore empty;
   @Test
   public void atlantisGetSnacks_properlyPopulated(){
       Map<String, Integer> snackPrices = atlantisSnacks.getSnackPrices();
       assertThat(snackPrices).isNotEmpty().hasSize(10);
       Map<String, Integer> expectedSnackPrices = new HashMap<>();
       expectedSnackPrices.put("SmartPops",2);
       expectedSnackPrices.put("Lucky Potato Chips",1);
       expectedSnackPrices.put("Health Bars",4);
       expectedSnackPrices.put("Corn-o's",1);
       expectedSnackPrices.put("Pretzle Pops",2);
       expectedSnackPrices.put("Freeze-dried Corn",2);
       expectedSnackPrices.put("Captain Crunch Munchers",2);
       expectedSnackPrices.put("Panda Mochi Cakes",3);
       expectedSnackPrices.put("Beet Blast",2);
       expectedSnackPrices.put("Crick-eats",1);
       assertThat(snackPrices).containsAllEntriesOf(expectedSnackPrices);
   }
   @Test
   public void emptyGetSnacks_isEmpty(){
       Map<String, Integer> snackPrices = empty.getSnackPrices();
       assertThat(snackPrices).isEmpty();
   }
}
