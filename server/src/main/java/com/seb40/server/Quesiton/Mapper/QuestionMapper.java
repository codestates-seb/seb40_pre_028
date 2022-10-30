package com.seb40.server.Quesiton.Mapper;

import com.seb40.server.Answer.Dto.AnswerResponseDto;
import com.seb40.server.Answer.Mapper.AnswerMapper;
import com.seb40.server.Quesiton.Dto.QuestionPatchDto;
import com.seb40.server.Quesiton.Dto.QuestionPostDto;
import com.seb40.server.Quesiton.Dto.QuestionResponseDto;
import com.seb40.server.Quesiton.Entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    @Mapping(target = "user.userId")
    Question questionPostDtoToQuestion(QuestionPostDto questionPostDto);

    Question questionPatchDtoToQuestion(QuestionPatchDto questionPatchDto);


//    QuestionResponseDto questionToQuestionResponseDto(Question question);

//    default QuestionResponseDto questionToQuestionResponseDto(Question question, AnswerMapper answerMapper){
//        QuestionResponseDto questionResponseDto = new QuestionResponseDto();
//
//        questionResponseDto.setQuestionId(question.getQuestionId());
//        questionResponseDto.setQuestionTitle(question.getQuestionTitle());
//        questionResponseDto.setQuestionBody(question.getQuestionBody());
//        questionResponseDto.setQuestionCreatedAt(question.getQuestionCreatedAt());
//        questionResponseDto.setQuestionModified(question.getQuestionModified());
//
//        List<AnswerResponseDto> answerResponseDtos =
//                answerMapper.answersToAnswerResponseDtos(question.getAnswers());
//
//        questionResponseDto.setAnswers(answerResponseDtos);
//
//        return questionResponseDto;
//    }

    @Mapping(target = "answers", expression = "java(answerMapper.answersToAnswerResponseDtos(question.getAnswers()))")
    @Mapping(target = "userId",expression = "java(question.getUser().getUserId())")
    QuestionResponseDto questionToQuestionResponseDto(Question question, AnswerMapper answerMapper);

//    List<QuestionResponseDto> questionsToQuestionResponseDtos(List<Question> questions);


    List<QuestionResponseDto> questionsToQuestionResponseDtos(List<Question> questions);

}