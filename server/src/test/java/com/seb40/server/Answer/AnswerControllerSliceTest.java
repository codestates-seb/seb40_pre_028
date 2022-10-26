package com.seb40.server.Answer;

import com.google.gson.Gson;
import com.seb40.server.Answer.Dto.AnswerPostDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AnswerControllerSliceTest {
    @Autowired // 필요한 의존 객체의 타입에 해당하는 빈을 찾아 주입함.
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    @Test
    void postAnswerTest1() throws Exception {
        //given 조건, 입력값
        AnswerPostDto post = new AnswerPostDto(1,1,2,"hello!222222");

        String content = gson.toJson(post);

        // when

        ResultActions actions =
                mockMvc.perform(post("/user/answer/post")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content));

        // then
        MvcResult result = actions.andExpect(status().isCreated())
                .andReturn();
    }

    @Test
    void patchAnswerTest1() throws Exception {
        //given 조건, 입력값


        // when


        // then

    }
}
