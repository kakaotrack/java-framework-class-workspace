package kr.ac.jejunu.usermanagement;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.ac.jejunu.usermanagement.controller.UserApiController;
import kr.ac.jejunu.usermanagement.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserApiControllerTests {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private UserApiController userApiController;
    String name = "허윤호";
    Integer id = 1;
    String password = "1234";

    @Test
    public void testList() throws Exception {
        List<User> users = List.of(User.builder().id(id).name(name).build());
        given(userApiController.list()).willReturn(users);
        mvc.perform(get("/api/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(id)))
                .andExpect(jsonPath("$[0].name", is(name)));
    }

    @Test
    public void testCreate() throws Exception {
        User user = User.builder().name(name).password(password).build();
        String jsonString = objectMapper.writeValueAsString(user);
        given(userApiController.save(user)).willReturn(user);
        mvc.perform(post("/api/save")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andExpect(status().isOk());
    }

    @Test
    public void testGet() throws Exception {
        User user = User.builder().id(id).name(name).password(password).build();
        given(userApiController.get(id)).willReturn(user);
        mvc.perform(get("/api/get/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(id)))
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.password", is(password)));
    }

    @Test
    public void testModify() throws Exception {
        User user = User.builder().id(id).name(name).password(password).build();
        String jsonString = objectMapper.writeValueAsString(user);
        given(userApiController.modify(user)).willReturn(user);
        mvc.perform(put("/api/save")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andExpect(status().isOk());
    }

    @Test
    public void testDelete() throws Exception {
        mvc.perform(delete("/api/delete/1"))
        .andExpect(status().isOk());
    }

}

















