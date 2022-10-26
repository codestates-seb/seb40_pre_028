package com.seb40.server.Answer;

import com.google.gson.Gson;
import com.seb40.server.Answer.Dto.AnswerPatchDto;
import com.seb40.server.Answer.Dto.AnswerPostDto;
import com.seb40.server.Answer.Entity.Answer;
import com.seb40.server.Answer.Mapper.AnswerMapper2;
import com.seb40.server.Answer.Service.AnswerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import javax.transaction.Transactional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
public class AnswerControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private Gson gson;

    @MockBean
    private AnswerService answerService;

    @Autowired
    private AnswerMapper2 mapper;

    private Answer answer;
    private AnswerPostDto post;

    @BeforeEach
    public void init(){
        this.post = new AnswerPostDto(1,1,2, "hello hello");
        this.answer = mapper.answerPostDtoToAnswer(post);
    }

    @Test
    void patchAnswerTest() throws Exception{
        // given 바꾸고싶은 내용 answerbody

        AnswerPatchDto patchDto = new AnswerPatchDto(
                1, "hello Thank you!");

        Answer patchAnswer = mapper.answerPatchDtoToAnswer(patchDto);

        // json 으로 바꾸기
        String content = gson.toJson(patchAnswer);

        given(answerService.updateAnswer(Mockito.any(Answer.class)))
                .willReturn(patchAnswer);

        // when 메서드
        ResultActions actions =
                mockMvc.perform(
                        patch("/user/answer/1")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(content)
                );
        // then 메서드

        MvcResult result = actions
                .andExpect(jsonPath("$.data.answerBody").value(patchAnswer.getAnswerBody()))
                .andReturn();

    }

}
