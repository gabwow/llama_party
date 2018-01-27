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
public class TestStores{
   @Autowired
   private Stores stores; 

   
  @Test
   public void stores_properlyPopulated(){
       assertThat(stores).isNotEmpty().hasSize(2);
       assertThat(stores.get(LlamaStrings.BEARDS_AND_SNACKS)).isNotNull();
   }


}
