package com.seb40.server.Comment.QuestionComment.Controller;


import com.seb40.server.Comment.QuestionComment.Dto.QuestionCommentPatchDto;
import com.seb40.server.Comment.QuestionComment.Dto.QuestionCommentPostDto;
import com.seb40.server.Comment.QuestionComment.Entity.QuestionComment;
import com.seb40.server.Comment.QuestionComment.Mapper.QuestionCommentMapper;
import com.seb40.server.Comment.QuestionComment.Service.QuestionCommentService;
import com.seb40.server.Response.MultiResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class QuestionCommentController {

    private final QuestionCommentService commentService;
    private final QuestionCommentMapper mapper;

    //질문 코멘트 작성
    @PostMapping("/{question_id}")
    public ResponseEntity postComment(@Valid @RequestBody QuestionCommentPostDto commentPostDto){

        QuestionComment comment = mapper.commentPostDtoToComment(commentPostDto);
        QuestionComment response = commentService.createComment(comment);

        return new ResponseEntity<>(mapper.commentToCommentResponseDto(response), HttpStatus.CREATED);
    }

    //질문 코멘트 수정
    @PatchMapping("/{question_id}/{questionComment-id}")
    public ResponseEntity patchComment(
            @PathVariable("question_id") @Positive long questionId,
            @PathVariable("questionComment-id") @Positive long commentId,
            @Valid @RequestBody QuestionCommentPatchDto questionCommentPatchDto){

        questionCommentPatchDto.setQuestionCommentId(commentId);
        QuestionComment response = commentService.updateComment(mapper.commentPatchDtoToComment(questionCommentPatchDto));

        return new ResponseEntity<>(mapper.commentToCommentResponseDto(response), HttpStatus.OK);

    }

    //질문 코멘트 확인
    @GetMapping("/{question_id}/{questionComment-id}")
    public ResponseEntity getQuestionComment(
            @PathVariable("question_id") @Positive long questionId,
            @PathVariable("questionComment-id") @Positive long commentId){

        QuestionComment response = commentService.findVerifiedAnswerComment(commentId);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    //질문 코멘트 List
    @GetMapping("/{question-id}")
    public ResponseEntity getQuestionComments(
            @PathVariable("question_id") @Positive long questionId,
            @Positive @RequestParam int page,
            @Positive @RequestParam int size){

        Page<QuestionComment> pageQuestions = commentService.findComments(page - 1, size);
        List<QuestionComment> comments = pageQuestions.getContent();

        return new ResponseEntity<>(
                new MultiResponseDto<>(mapper.commentsToCommentResponseDtos(comments), pageQuestions),
                HttpStatus.OK);
    }

    //답변 코멘트 삭제
    @DeleteMapping("/{question_id}/{questionComment-id}")
    public ResponseEntity deleteComment(
            @PathVariable("question_id") @Positive long questionId,
            @PathVariable("questionComment-id") @Positive long commentId){

        System.out.println("delete QuestionComment");
        commentService.deleteComment(commentId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }




}
