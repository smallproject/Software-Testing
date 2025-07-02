package controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class HelloControllerIntegrationTest {
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        HelloController controller = new HelloController();
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void testGreetEndpoint() throws Exception {
        mockMvc.perform(get("/hello")
                .accept(String.valueOf(MediaType.TEXT_PLAIN)))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World"));
    }

    @Test
    void testGreet() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk());
    }

    @Test
    void testGoodbye() throws Exception {
        mockMvc.perform(get("/goodbye"))
                .andExpect(status().isOk());
    }
}
