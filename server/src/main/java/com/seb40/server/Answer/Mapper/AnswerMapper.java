package com.seb40.server.Answer.Mapper;

import com.seb40.server.Answer.Dto.AnswerPatchDto;
import com.seb40.server.Answer.Dto.AnswerPostDto;
import com.seb40.server.Answer.Dto.AnswerResponseDto;
import com.seb40.server.Answer.Entity.Answer;
import com.seb40.server.Comment.AnswerComment.Mapper.AnswerCommentMapper;
import com.seb40.server.Quesiton.Entity.Question;
import com.seb40.server.Quesiton.Service.QuestionService;
import com.seb40.server.User.entity.User;
import com.seb40.server.User.mapper.UserMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface AnswerMapper {

    default Answer answerPostDtoToAnswer(AnswerPostDto answerPostDto){
        Answer answer = new Answer();
        answer.setAnswerId(answerPostDto.getAnswerId());
        answer.setAnswerBody(answerPostDto.getAnswerBody());
        answer.setQuestion(answerPostDtoToQuestion(answerPostDto));
        answer.setUser(answerPostDtoToUser(answerPostDto));

        return answer;
    }
    default Question answerPostDtoToQuestion(AnswerPostDto postDto){
        Question question = new Question();
        question.setQuestionId(postDto.getQuestionId());
        return question;
    }

    default User answerPostDtoToUser(AnswerPostDto answerPostDto){
        User user = new User();
        user.setUserId(answerPostDto.getUserId());
        user.setName(answerPostDto.getName());

        return user;
    }

    default Answer answerPatchDtoToAnswer(AnswerPatchDto answerPatchDto) {
        Answer answer = new Answer();
        answer.setAnswerId(answerPatchDto.getAnswerId());
        answer.setAnswerBody(answer.getAnswerBody());

        return answer;

    }

    @Mapping(source = "answer.user.name", target = "name")
    @Mapping(source = "answer.question.questionId", target = "questionId")
    AnswerResponseDto answerToAnswerResponseDto(Answer answer);

//    default AnswerResponseDto answerToAnswerResponseDto(Answer answer, AnswerCommentMapper answerCommentMapper){
//        AnswerResponseDto answerResponseDto = new AnswerResponseDto();
//        answerResponseDto.setQuestionId(answer.getQuestion().getQuestionId());
//        answerResponseDto.setName(answer.getUser().getName());
//        answerResponseDto.setAnswerBody(answer.getAnswerBody());
//        answerResponseDto.setAnswerCreatedAt(answer.getAnswerCreatedAt());
//        answerResponseDto.setAnswerModified(answer.getAnswerModified());
////        answerResponseDto.setAnswerComments(answer.getAnswerComments());
//
//        return answerResponseDto;
//    }

    // AnswerResponseDto 타입의 List mapper 파라미터로 List<Answer> 타입의 Answer 를 받는다.

    //   List<AnswerResponseDto> answersToAnswerResponseDtos(List<Answer> answers);
    default List<AnswerResponseDto> answersToAnswerResponseDtos(List<Answer> answers){
        return answers.stream()
                .map(answer -> AnswerResponseDto
                        .builder()
                        .questionId(answer.getQuestion().getQuestionId())
                        .name(answer.getUser().getName())
                        .answerBody(answer.getAnswerBody())
                        .answerCreatedAt(answer.getAnswerCreatedAt())
                        .answerModified(answer.getAnswerModified())
                        .build())
                .collect(Collectors.toList());

    }

//    List<AnswerResponseDto> answerResponseDtoToAnswerResponseDtos(List<AnswerResponseDto> answerResponseDtos);

}
