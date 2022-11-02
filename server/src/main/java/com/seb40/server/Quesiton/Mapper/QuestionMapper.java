package com.seb40.server.Quesiton.Mapper;


import com.seb40.server.Answer.Mapper.AnswerMapper;
import com.seb40.server.Quesiton.Dto.QuestionPatchDto;
import com.seb40.server.Quesiton.Dto.QuestionPostDto;
import com.seb40.server.Quesiton.Dto.QuestionResponseDto;
import com.seb40.server.Quesiton.Dto.QuestionTagDto;
import com.seb40.server.Quesiton.Entity.Question;
import com.seb40.server.Quesiton.Entity.QuestionTag;
import com.seb40.server.User.entity.User;
import com.seb40.server.User.mapper.UserMapper;
import com.seb40.server.User.service.UserService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring" , uses = UserMapper.class)
public interface QuestionMapper {


    default Question questionPostDtoToQuestion(QuestionPostDto questionPostDto){ // <- 원래 이거
        Question question = new Question();

        question.setQuestionTitle(questionPostDto.getQuestionTitle());
        question.setQuestionBody(questionPostDto.getQuestionBody());
        question.setUser(questionPostDtoUser(questionPostDto));

        return question;
    }


    default User questionPostDtoUser(QuestionPostDto dto){
        User user = new User();
        user.setUserId(dto.getUserId());
        user.setName(dto.getName());


        return user;
    }

    default Question questionPatchDtoToQuestion(QuestionPatchDto questionPatchDto){
        Question question = new Question();

        question.setQuestionId(questionPatchDto.getQuestionId());
        question.setQuestionTitle(questionPatchDto.getQuestionTitle());
        question.setQuestionBody(questionPatchDto.getQuestionBody());

        return question;
    }


    @Mapping(target = "answers", expression = "java(answerMapper.answersToAnswerResponseDtos(question.getAnswers()))")
    @Mapping(target = "name",expression = "java(question.getUser().getName())")
    QuestionResponseDto questionToQuestionResponseDto(Question question, AnswerMapper answerMapper);
    default List<QuestionResponseDto> questionsToQuestionResponseDtos(List<Question> questions){
        return questions.stream()
                .map(question -> QuestionResponseDto
                        .builder()
                        .questionId(question.getQuestionId())
                        .questionTitle(question.getQuestionTitle())
                        .questionBody(question.getQuestionBody())
                        .name(question.getUser().getName())
                        .questionCreatedAt(question.getQuestionCreatedAt())
                        .questionModified(question.getQuestionModified())
                        .answerNum(question.getAnswers().size()) // 답변 수 세기
                        .build())
                .collect(Collectors.toList());
    }
























}