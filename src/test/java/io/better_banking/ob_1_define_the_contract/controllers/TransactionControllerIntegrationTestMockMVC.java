package io.better_banking.ob_1_define_the_contract.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class TransactionControllerIntegrationTestMockMVC {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testFindAllByAccountNumberReturnTransactions() throws Exception {
        
        String accountNumber = "111111111";

        mockMvc.perform(get("/transactions/{accountNumber}", accountNumber))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$", hasSize(0)));
    }

    
}
