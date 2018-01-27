package org.llama.web;

import org.llama.service.SnackStoreService;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.test.web.servlet.result.JsonPathResultMatchers;


@RunWith(SpringRunner.class)
@WebMvcTest(SnackStoreController.class)
public class TestStoresWeb{
   @Autowired
   private MockMvc mockMvc; 

   @MockBean
   private SnackStoreService snackStoreService;

  @Test
   public void snackStore_shouldReturnList() throws Exception {
       mockMvc.perform(get("/stores")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Atlantis")));
   }
}
