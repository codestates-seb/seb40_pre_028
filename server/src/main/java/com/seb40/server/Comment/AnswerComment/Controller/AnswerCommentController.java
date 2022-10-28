//package com.seb40.server.Comment.AnswerComment.Controller;
//
//import com.seb40.server.Comment.AnswerComment.Dto.AnswerCommentPatchDto;
//import com.seb40.server.Comment.AnswerComment.Dto.AnswerCommentPostDto;
//import com.seb40.server.Comment.AnswerComment.Entity.AnswerComment;
//import com.seb40.server.Comment.AnswerComment.Mapper.AnswerCommentMapper;
//import com.seb40.server.Comment.AnswerComment.Service.AnswerCommentService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import javax.validation.constraints.Positive;
//
//@RestController
//@RequestMapping("/user")
//@RequiredArgsConstructor
//public class AnswerCommentController {
//
//    private final AnswerCommentService commentService;
//    private final AnswerCommentMapper mapper;
//
//    //답변 코멘트
//    @PostMapping("answer/{answer_id}")
//    public ResponseEntity postComment(@Valid @RequestBody AnswerCommentPostDto commentPostDto){
//
//        AnswerComment comment = mapper.commentPostDtoToComment(commentPostDto);
//        AnswerComment response = commentService.createComment(comment);
//
//        return new ResponseEntity<>(mapper.commentToCommentResponseDto(response), HttpStatus.CREATED);
//    }
//
//    //답변 코멘트 수정
//    //@PatchMapping("/{answer-id}/{answerComment-id}")
//    @PatchMapping("/{answerComment-id}")
//    public ResponseEntity patchComment(
//            @PathVariable("answerComment-id") @Positive long commentId,
//            @Valid @RequestBody AnswerCommentPatchDto answerCommentPatchDto){
//
//        answerCommentPatchDto.setAnswerCommentId(commentId);
//        AnswerComment response = commentService.updateComment(mapper.commentPatchDtoToComment(answerCommentPatchDto));
//
//        return new ResponseEntity<>(mapper.commentToCommentResponseDto(response), HttpStatus.OK);
//
//    }
//
//    //답변 코멘트 삭제
//    //@DeleteMapping("/{answer-id}/{answerComment-id}")
//    @DeleteMapping("/{answerComment-id}")
//    public ResponseEntity deleteComment(
//            @PathVariable("answerComment-id") @Positive long commentId){
//
//        System.out.println("delete AnswerComment");
//        commentService.deleteComment(commentId);
//
//        return new ResponseEntity(HttpStatus.NO_CONTENT);
//    }
//
//}
