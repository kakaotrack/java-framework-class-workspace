package kr.ac.jejunu.usermanagement;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTests {
    @Autowired
    MockMvc mvc;
    @MockBean
    private UserController userController;
    @Autowired
    private ObjectMapper objectMapper;

    String name = "허윤호";
    String password = "1234";
    @Test
    public void list() throws Exception {
        List<User> users = new ArrayList<>();
        int id = 1;
        User user = User.builder().id(id).name(name).build();
        users.add(user);
        given(userController.list()).willReturn(users);
        mvc.perform(get("/api/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(id)))
                .andExpect(jsonPath("$[0].name", is(name)));
    }

    @Test
    public void create() throws Exception {
        User user = User.builder().name(name).password(password).build();
        given(userController.save(user)).willReturn(user);
        String jsonString = objectMapper.writeValueAsString(user);
        mvc.perform(post("/api/save")
        .contentType(MediaType.APPLICATION_JSON)
        .content(jsonString))
                .andExpect(status().isOk());
    }

    int id = 1;

    @Test
    public void testGet() throws Exception {
        User user = User.builder().id(id).name(name).password(password).build();
        given(userController.get(id)).willReturn(user);
        mvc.perform(get("/api/get/" + String.valueOf(id)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(id)))
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.password", is(password)));
    }

    @Test
    public void modify() throws Exception {
        User user = User.builder().id(id).name(name).password(password).build();
        given(userController.save(user)).willReturn(user);
        String jsonString = objectMapper.writeValueAsString(user);
        mvc.perform(put("/api/save")
        .contentType(MediaType.APPLICATION_JSON)
        .content(jsonString))
                .andExpect(status().isOk());
    }

    @Test
    public void testDelete() throws Exception {
        mvc.perform(delete("/api/delete/" + id))
                .andExpect(status().isOk());
    }

}
