package org.llama.domain; 

import java.util.Objects;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
public class Snack{
   private String name =  "";
   private int price = -1;
   private int preferenceScore = -1;

   public Snack name(String name){
      this.name = name;
      return this;
   }

   public Snack price(int price){
      this.price = price;
      return this;
   }

   public Snack preferenceScore(int preferenceScore){
      this.preferenceScore = preferenceScore;
      return this;
   }
   
   @JsonInclude(Include.ALWAYS)
   public String getName(){
      return name;
   }

   public int getPrice(){
      return price;
   }

   public int getPreferenceScore(){
      return preferenceScore;
   }
   
   //need this for testing
   @Override
   public boolean equals(Object o){
     if(o == this)
        return true;
     if(!(o instanceof Snack))
         return false;
     Snack testSnack = (Snack)o;
     return testSnack.price == price && testSnack.preferenceScore == preferenceScore &&
         testSnack.name.equals(name);

   }

   //Mediocre performance -- change if scales
   @Override
   public int hashCode(){
      return Objects.hash(name, price, preferenceScore);
   }
}
