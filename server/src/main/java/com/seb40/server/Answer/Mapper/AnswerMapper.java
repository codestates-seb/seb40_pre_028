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


//    @Mapping(target = "question.questionId")
//    @Mapping(target = "user.userId")
//    Answer answerPostDtoToAnswer(AnswerPostDto answerPostDto);
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
        return user;
    }

    default Answer answerPatchDtoToAnswer(AnswerPatchDto answerPatchDto){
        Answer answer = new Answer();
        answer.setAnswerId(answerPatchDto.getAnswerId());
        answer.setAnswerBody(answer.getAnswerBody());

        return answer;
    }

//    @Mapping(target = "answerComments",
//            expression = "java(answerCommentMapper.commentsToCommentResponseDtos(answer.getAnswerComments()))")
//    @Mapping(target = "userId", expression = "java(answer.getUser().getUserId())")
//    @Mapping(target = "questionId", expression = "java(answer.getQuestion().getQuestionId())")
//    @Mapping(source = "answer.user.userId", target = "userId")
//    @Mapping(source = "answer.question.questionId", target = "questionId")
//    AnswerResponseDto answerToAnswerResponseDto(Answer answer,AnswerCommentMapper answerCommentMapper);

    default AnswerResponseDto answerToAnswerResponseDto(Answer answer, AnswerCommentMapper answerCommentMapper){
        AnswerResponseDto answerResponseDto = new AnswerResponseDto();
        answerResponseDto.setQuestionId(answer.getQuestion().getQuestionId());
        answerResponseDto.setUserName(answer.getUser().getName());
        answerResponseDto.setAnswerBody(answer.getAnswerBody());
        answerResponseDto.setAnswerCreatedAt(answer.getAnswerCreatedAt());
        answerResponseDto.setAnswerModified(answer.getAnswerModified());
        answerResponseDto.setAnswerComments(answer.getAnswerComments());

        return answerResponseDto;
    }

    // AnswerResponseDto 타입의 List mapper 파라미터로 List<Answer> 타입의 Answer 를 받는다.

    //   List<AnswerResponseDto> answersToAnswerResponseDtos(List<Answer> answers);
    default List<AnswerResponseDto> answersToAnswerResponseDtos(List<Answer> answers){
        return answers.stream()
                .map(answer -> AnswerResponseDto
                        .builder()
                        .questionId(answer.getQuestion().getQuestionId())
                        .userName(answer.getUser().getName())
                        .answerBody(answer.getAnswerBody())
                        .answerCreatedAt(answer.getAnswerCreatedAt())
                        .answerModified(answer.getAnswerModified())
                        .build())
                .collect(Collectors.toList());

    }

//    List<AnswerResponseDto> answerResponseDtoToAnswerResponseDtos(List<AnswerResponseDto> answerResponseDtos);

}
