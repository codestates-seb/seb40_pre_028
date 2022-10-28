package com.seb40.server.Comment.QuestionComment.Service;

import com.seb40.server.Comment.AnswerComment.Entity.AnswerComment;
import com.seb40.server.Comment.QuestionComment.Entity.QuestionComment;
import com.seb40.server.Comment.QuestionComment.Repository.QuestionCommentRepository;
import com.seb40.server.Exception.BusinessLogicException;
import com.seb40.server.Exception.ExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionCommentService {

    private final QuestionCommentRepository commentRepository;

    public QuestionComment createComment(QuestionComment questionComment) {
        return commentRepository.save(questionComment);
    }

    public void deleteComment(long commentId) {
        QuestionComment comment = findVerifiedAnswerComment(commentId);

        commentRepository.delete(comment);
    }

    public QuestionComment updateComment(QuestionComment questionComment) {
        QuestionComment comment = findVerifiedAnswerComment(questionComment.getQuestionCommentId());

        comment.setQuestionCommentBody(questionComment.getQuestionCommentBody());
        return commentRepository.save(comment);

    }

    public QuestionComment findComment(long commentId){
        return findVerifiedAnswerComment(commentId);
    }

    public Page<QuestionComment> findComments(int page, int size){
        return commentRepository.findAll(PageRequest.of(page,size, Sort.by("commentId").descending()));

    }
    public QuestionComment findVerifiedAnswerComment(long commentId) {
        Optional<QuestionComment> optionalComment =
                commentRepository.findById(commentId);
        QuestionComment findComment =
                optionalComment.orElseThrow(()->
                        new BusinessLogicException(ExceptionCode.Comment_NOT_FOUND));

        return findComment;

    }
    

}
