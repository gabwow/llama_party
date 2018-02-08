package org.llama.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
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
public class TestSnack{
   
  @Test
   public void snack_EqualsCorrect(){
       Snack fullS1 = (new Snack()).name("Chips").preferenceScore(3).price(10);
       Snack fullS2 = (new Snack()).name("Chips").price(10).preferenceScore(3);
       Snack empty1 = new Snack();
       Snack empty2 = new Snack();
       assertThat(fullS1).isEqualTo(fullS2);
       assertThat(fullS2).isEqualTo(fullS1);
       assertThat(empty1).isEqualTo(empty2);
       assertThat(fullS1).isNotEqualTo(empty1);
       assertThat(empty1).isNotEqualTo(fullS2);
   }

}
