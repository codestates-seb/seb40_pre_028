package com.seb40.server.Quesiton.Mapper;

import com.seb40.server.Answer.Dto.AnswerResponseDto;
import com.seb40.server.Answer.Mapper.AnswerMapper;
import com.seb40.server.Quesiton.Dto.QuestionPatchDto;
import com.seb40.server.Quesiton.Dto.QuestionPostDto;
import com.seb40.server.Quesiton.Dto.QuestionResponseDto;
import com.seb40.server.Quesiton.Entity.Question;
import com.seb40.server.User.mapper.UserMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring" , uses = UserMapper.class)
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