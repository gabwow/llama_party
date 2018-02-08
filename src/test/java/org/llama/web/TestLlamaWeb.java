package org.llama.web;

import org.llama.service.LlamaService;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.test.web.servlet.result.JsonPathResultMatchers;


@RunWith(SpringRunner.class)
@WebMvcTest(LlamaController.class)
public class TestLlamaWeb{
   @Autowired
   private MockMvc mockMvc; 

   @MockBean
   private LlamaService llamaService;

  @Test
   public void llama_shouldReturnEmptySnackOnUnkownSnackName() throws Exception {
       mockMvc.perform(get("/llama?snack=AN+UNKNOWN+SNACK").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()); 
   }
  @Test
   public void llama_shouldReturnOne() throws Exception {
       mockMvc.perform(get("/llama").param("snack", "Crick-eats")).andDo(print()).andExpect(status().isOk());
   } 
}
