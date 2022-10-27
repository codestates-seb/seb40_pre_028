package com.seb40.server.Answer;

import com.google.gson.Gson;
import com.seb40.server.Answer.Dto.AnswerPatchDto;
import com.seb40.server.Answer.Dto.AnswerPostDto;
import com.seb40.server.Answer.Entity.Answer;
import com.seb40.server.Answer.Mapper.AnswerMapper2;
import com.seb40.server.Answer.Repository.AnswerRepository;
import com.seb40.server.Answer.Service.AnswerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AnswerControllerSliceTest {
    @Autowired // 필요한 의존 객체의 타입에 해당하는 빈을 찾아 주입함.
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    @MockBean
    private AnswerService service;

    @Autowired
    private AnswerMapper2 mapper;

    private Answer answer;
    private AnswerPostDto post;

    @BeforeEach
    public void init(){
        this.post = new AnswerPostDto(4,1,2,"hello!222222");
        this.answer = mapper.answerPostDtoToAnswer(post);
    }

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

//    @Test
//    void patchAnswerTest1() throws Exception {
//        //given 조건, 입력값
//        AnswerPatchDto patch = new AnswerPatchDto(4,"안녕하세요!");
//
//        String content = gson.toJson(patch);
//
//        // when
//        ResultActions actions =
//                mockMvc.perform(patch("/user/answer/4")
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(content)
//                );
//
//        Answer findAnswer = service.findVerifiedAnswer(4);
//
//        // then
//        MvcResult result = actions.andExpect(status().is2xxSuccessful())
////                .andExpect(jsonPath("$.stackoverflow.answer.answer_body").value(this.post.getAnswerBody()))
//                .andReturn();
//    }
}
