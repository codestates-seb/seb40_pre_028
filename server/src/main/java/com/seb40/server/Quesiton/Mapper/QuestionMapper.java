package com.seb40.server.Quesiton.Mapper;


import com.seb40.server.Answer.Mapper.AnswerMapper;
import com.seb40.server.Quesiton.Dto.*;
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

    // tag 포함된 postDto를 entity로 변환
    default Question questionPostDtoToQuestion(QuestionPostDto questionPostDto){
        Question question = new Question(); // 질문 만들어짐 이 안에 title, body, tag가 있음
        // 아래문장: questionPostDto에서 tag이름만 뽑아옴(?)
        List<QuestionTag> questionTags = questionTagsDtosToQuestionTags(questionPostDto.getQuestionTags(),question);
        question.setQuestionTags(questionTags); // question에 tag가 더해지며 수정됨
        question.setQuestionTitle(questionPostDto.getQuestionTitle());
        question.setQuestionBody(questionPostDto.getQuestionBody());
        question.setUser(questionPostDtoUser(questionPostDto));
        return question;
    }

    // tag포함된 patchDto를 entity로 변환
    default Question questionPatchDtoToQuestion(QuestionPatchDto questionPatchDto){
        Question question = new Question(); // 질문 만들어짐 이 안에 title, body, tag가 있음
        // 아래문장: questionPatchDto에서 tag이름만 뽑아옴(?)
        List<QuestionTag> questionTags = questionTagsDtosToQuestionTags(questionPatchDto.getQuestionTags(),question);
        question.setQuestionTags(questionTags);
        question.setQuestionId(questionPatchDto.getQuestionId());
        question.setQuestionTitle(questionPatchDto.getQuestionTitle());
        question.setQuestionBody(questionPatchDto.getQuestionBody());
        return question;
    }


    // tag와 question 합쳐버려
    default List<QuestionTag> questionTagsDtosToQuestionTags(List<QuestionTagDto> questionTagsDtos,Question question){

        return questionTagsDtos.stream().map(questionTagDto -> {
            QuestionTag questionTag = new QuestionTag();
            questionTag.addQuestion(question);
            questionTag.setTagName(questionTagDto.getTagName());
            return questionTag;
        }).collect(Collectors.toList());
    }


    default User questionPostDtoUser(QuestionPostDto dto){
        User user = new User();
        user.setUserId(dto.getUserId());
        user.setName(dto.getName());
        return user;
    }


    ///////////////////////위에서 questionDto tagDto가 합쳐진 question엔티티감 만들어진것 같은데..


    // tag list이것도 같이 responseDto로 만들어주고 싶은데 표현방법을 어떻게 할지 연구 및 구현 중
    // 따로 responseDto를 만들것인지 아니면 어차피 내생각엔 question엔티티 안에 tag 리스트가 포함된것 같은데
    // 같이 responseDto에 넣을것인지.

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