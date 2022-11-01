package com.seb40.server.Comment.AnswerComment.Service;

import com.seb40.server.Comment.AnswerComment.Entity.AnswerComment;
import com.seb40.server.Comment.AnswerComment.Repository.AnswerCommentRepository;
import com.seb40.server.Exception.BusinessLogicException;
import com.seb40.server.Exception.ExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;



@Service
@RequiredArgsConstructor
public class AnswerCommentService {

    private final AnswerCommentRepository commentRepository;

//    public AnswerCommentService(AnswerCommentRepository commentRepository) {
//        this.commentRepository = commentRepository;
//    }

    public AnswerComment createComment(AnswerComment answerComment) {
        return commentRepository.save(answerComment);

    }

    public void deleteComment(long commentId) {
        AnswerComment comment = findVerifiedAnswerComment(commentId);

        commentRepository.delete(comment);
    }

    public AnswerComment updateComment(AnswerComment answerComment) {
        AnswerComment comment =
                findVerifiedAnswerComment(answerComment.getAnswerCommentId());

        comment.setAnswerCommentBody(answerComment.getAnswerCommentBody());
        return commentRepository.save(comment);

    }

    public AnswerComment findComment(long commentId){
        return findVerifiedAnswerComment(commentId);
    }

    public Page<AnswerComment> findComments(int page, int size){
        return commentRepository.findAll(PageRequest.of(page,size,
                Sort.by("answerCommentId")));

    }

    public AnswerComment findVerifiedAnswerComment(long commentId) {
        Optional<AnswerComment> optionalComment =
                commentRepository.findByAnswerCommentId(commentId);
        AnswerComment findComment =
                optionalComment.orElseThrow(()->
                        new BusinessLogicException(ExceptionCode.Comment_NOT_FOUND));

        return findComment;

    }
}
