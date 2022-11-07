package com.seb40.server.Quesiton.Mapper;

import com.seb40.server.Answer.Mapper.AnswerMapper;
import com.seb40.server.Quesiton.Dto.*;
import com.seb40.server.Quesiton.Entity.Question;
import com.seb40.server.Tag.Mapper.TagMapper;
import com.seb40.server.User.entity.User;
import com.seb40.server.User.mapper.UserMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring" , uses = {UserMapper.class, TagMapper.class})
public interface QuestionMapper {

    default Question questionPostDtoToQuestion(QuestionPostDto questionPostDto){
        Question question = new Question();
        question.setQuestionTitle(questionPostDto.getQuestionTitle());
        question.setQuestionBody(questionPostDto.getQuestionBody());
        question.setUser(questionPostDtoUser(questionPostDto));
        return question;
    }

    default Question questionPatchDtoToQuestion(QuestionPatchDto questionPatchDto){
        Question question = new Question();
        question.setQuestionId(questionPatchDto.getQuestionId());
        question.setQuestionTitle(questionPatchDto.getQuestionTitle());
        question.setQuestionBody(questionPatchDto.getQuestionBody());
        return question;
    }

    default User questionPostDtoUser(QuestionPostDto dto){
        User user = new User();
        user.setUserId(dto.getUserId());
        user.setName(dto.getName());
        return user;
    }

    default QuestionResponseDto questionToQuestionResponseDto(Question question, AnswerMapper answerMapper){
        QuestionResponseDto questionResponseDto = new QuestionResponseDto();
        questionResponseDto.setQuestionId(question.getQuestionId());
        questionResponseDto.setQuestionTitle(question.getQuestionTitle());
        questionResponseDto.setQuestionBody(question.getQuestionBody());
        questionResponseDto.setQuestionCreatedAt(question.getQuestionCreatedAt());
        questionResponseDto.setQuestionModified(question.getQuestionModified());
        questionResponseDto.setAnswerNum(question.getAnswerNum());
        questionResponseDto.setAnswers(answerMapper.answersToAnswerResponseDtos(question.getAnswers()));
        questionResponseDto.setName(question.getUser().getName());

        return questionResponseDto;
    }

    default List<QuestionsResponseDto> questionsToQuestionResponseDtos(List<Question> questions){
        return questions.stream()
                .map(question -> QuestionsResponseDto
                        .builder()
                        .questionId(question.getQuestionId())
                        .questionTitle(question.getQuestionTitle())
                        .questionBody(question.getQuestionBody())
                        .name(question.getUser().getName())
                        .questionCreatedAt(question.getQuestionCreatedAt())
                        .questionModified(question.getQuestionModified())
                        .answerNum(question.getAnswers().size())
                        .views(question.getViews())
                        .build())
                .collect(Collectors.toList());

    }
}