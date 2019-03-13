package kr.ac.jejunu.usermanagement;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.ac.jejunu.usermanagement.controller.UserApiController;
import kr.ac.jejunu.usermanagement.model.User;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

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
    @MockBean
    private UserApiController userApiController;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testList() throws Exception {
        Integer id = 1;
        String name = "허윤호";
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
        User user = User.builder().name("허윤호").password("1234").build();
        given(userApiController.create(user)).willReturn(user);
        mvc.perform(post("/api/save")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk());
    }

    @Test
    public void testGet() throws Exception {
        var id = 1;
        User user = User.builder().id(1).name("허윤호").password("1234").build();
        given(userApiController.get(id)).willReturn(user);
        mvc.perform(get("/api/get/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(user.getId())))
                .andExpect(jsonPath("$.name", is(user.getName())))
                .andExpect(jsonPath("$.password", is(user.getPassword())));

    }

    @Test
    public void testModify() throws Exception {
        User user = User.builder().id(1).name("허윤호").password("1234").build();
        given(userApiController.modify(user)).willReturn(user);
        mvc.perform(put("/api/save")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk());
    }

    @Test
    public void testDelete() throws Exception {
        mvc.perform(delete("/api/delete/1"))
                .andExpect(status().isOk());
    }
}
