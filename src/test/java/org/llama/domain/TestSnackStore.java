package org.llama.domain;

import java.util.LinkedList;
import java.util.List;
import java.io.IOException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatCode;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSnackStore{
   @Resource
   private FileSnackStore atlantisSnacks;



   @Autowired
   private EmptyStore empty;
   @Test
   public void atlantisGetSnacks_properlyPopulated(){
       List<Snack> snackPrices = atlantisSnacks.getSnackPrices();
       assertThat(snackPrices).isNotEmpty().hasSize(10);
       List<Snack> expectedSnackPrices = new LinkedList<>();
       expectedSnackPrices.add(new Snack().name("SmartPops").price(2));
       expectedSnackPrices.add(new Snack().name("Lucky Potato Chips").price(1));
       expectedSnackPrices.add(new Snack().name("Health Bars").price(4));
       expectedSnackPrices.add(new Snack().name("Corn-o's").price(1));
       expectedSnackPrices.add(new Snack().name("Pretzle Pops").price(2));
       expectedSnackPrices.add(new Snack().name("Freeze-dried Corn").price(2));
       expectedSnackPrices.add(new Snack().name("Captain Crunch Munchers").price(2));
       expectedSnackPrices.add(new Snack().name("Panda Mochi Cakes").price(3));
       expectedSnackPrices.add(new Snack().name("Beet Blast").price(2));
       expectedSnackPrices.add(new Snack().name("Crick-eats").price(1));
       assertThat(snackPrices).containsOnlyElementsOf(expectedSnackPrices);
   }
   @Test
   public void emptyGetSnacks_isEmpty(){
       List<Snack> snackPrices = empty.getSnackPrices();
       assertThat(snackPrices).isEmpty();
   }

   @Test
   public void fileStore_fastFailOnInitializationError(){
      assertThatExceptionOfType(IOException.class).isThrownBy(() -> atlantisSnacks.populateFromFile("NoSuchFile.txt") );
      assertThatCode(() -> {atlantisSnacks.populateFromFile("AtlantisSnacks.txt");}).doesNotThrowAnyException();
   }
}
