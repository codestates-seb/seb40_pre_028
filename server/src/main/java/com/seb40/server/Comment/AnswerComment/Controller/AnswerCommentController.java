package com.seb40.server.Comment.AnswerComment.Controller;

import com.seb40.server.Answer.Service.AnswerService;
import com.seb40.server.Comment.AnswerComment.Dto.AnswerCommentPatchDto;
import com.seb40.server.Comment.AnswerComment.Dto.AnswerCommentPostDto;
import com.seb40.server.Comment.AnswerComment.Entity.AnswerComment;
import com.seb40.server.Comment.AnswerComment.Mapper.AnswerCommentMapper;
import com.seb40.server.Comment.AnswerComment.Service.AnswerCommentService;
import com.seb40.server.Response.MultiResponseDto;
import com.seb40.server.Response.SingleResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/user/answer/comment")
@AllArgsConstructor
public class AnswerCommentController {

    private final AnswerCommentService commentService;
    private final AnswerService answerService;
    private final AnswerCommentMapper mapper;

    //답변 코멘트 작성
    @PostMapping("/{answer_id}/post")
    public ResponseEntity postComment(@PathVariable("answer_id")
                                          @Positive long answerId,
                                      @Valid @RequestBody AnswerCommentPostDto commentPostDto){
        commentPostDto.setAnswerId(answerId);
        AnswerComment comment = commentService.createComment(
                mapper.commentPostDtoToComment(commentPostDto));

        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.commentToCommentResponseDto(comment))
                        , HttpStatus.CREATED);
    }

    //답변 코멘트 수정
    @PatchMapping("/{answer-id}/{answerComment-id}")
    public ResponseEntity patchComment(
            @PathVariable("answer-id") @Positive long answerId,
            @PathVariable("answerComment-id") @Positive long commentId,
            @Valid @RequestBody AnswerCommentPatchDto answerCommentPatchDto){

        answerCommentPatchDto.setAnswerCommentId(commentId);
        AnswerComment response =
                commentService.updateComment(
                        mapper.commentPatchDtoToComment(answerCommentPatchDto));

        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.commentToCommentResponseDto(response))
                , HttpStatus.OK);

    }

    //답변 코멘트 확인
    @GetMapping("/{answer-id}/{answerComment-id}")
    public ResponseEntity getAnswerComment(
            @PathVariable("answer-id") @Positive long answerId,
            @PathVariable("answerComment-id") @Positive long commentId){
        AnswerComment response = commentService.findVerifiedAnswerComment(commentId);

        return new ResponseEntity<>(
                new SingleResponseDto<>(response),HttpStatus.OK);
    }

    //답변 코멘트 List
    @GetMapping("/{answer-id}")
    public ResponseEntity getAnswerComments(
            @PathVariable("answer-id") @Positive long answerId,
            @Positive @RequestParam int page,
            @Positive @RequestParam int size){

        Page<AnswerComment> pageAnswers = commentService.findComments(page - 1, size);
        List<AnswerComment> comments = pageAnswers.getContent();

        return new ResponseEntity<>(
                new MultiResponseDto<>(mapper.commentsToCommentResponseDtos(comments), pageAnswers),
                HttpStatus.OK);
    }

    //답변 코멘트 삭제
    @DeleteMapping("/{answer-id}/{answerComment-id}")
    public ResponseEntity deleteComment(
            @PathVariable("answer-id") @Positive long answerId,
            @PathVariable("answerComment-id") @Positive long commentId){

        System.out.println("delete AnswerComment");
        commentService.deleteComment(commentId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
