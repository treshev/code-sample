package com.charter.enterprise.motd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)

public class MotdControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void getMotdTest() throws Exception {
        String initialMessage = "Did I pass the test.";
        checkMessage(initialMessage);
    }

    @Test
    public void changeMessageByGetTest() throws Exception {
        String newMessage = "updateByGET";
        mvc.perform(MockMvcRequestBuilders.get("/updateMessage?newMessageOfTheDay=" + newMessage))
                .andExpect(status().isOk());
        checkMessage(newMessage);
    }

    @Test
    public void changeMessageByPutTest() throws Exception {
        String newMessage = "updateByPut";
        mvc.perform(MockMvcRequestBuilders.put("/updateMessage").param("newMessageOfTheDay", newMessage))
                .andExpect(status().isOk());
        checkMessage(newMessage);
    }

    private void checkMessage(String newMessage) throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(newMessage)));
    }


}
