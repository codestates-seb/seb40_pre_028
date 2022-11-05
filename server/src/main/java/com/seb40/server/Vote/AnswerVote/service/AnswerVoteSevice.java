package com.seb40.server.Vote.AnswerVote.service;

import com.seb40.server.Answer.Entity.Answer;
import com.seb40.server.Vote.AnswerVote.Dto.AnswerVotePatchDto;
import com.seb40.server.Vote.AnswerVote.Entity.AnswerVote;
import com.seb40.server.Vote.AnswerVote.Mapper.AnswerVoteMapper;
import com.seb40.server.Vote.AnswerVote.Repository.AnswerVoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnswerVoteSevice {
    private final AnswerVoteRepository answerVoteRepository;
    private final AnswerVoteMapper mapper;

    public void vote(AnswerVotePatchDto answerVotePatchDto ) {
        Optional<AnswerVote>  optionalAnswerVote =  answerVoteRepository.findAnswerVotesByUser_UserIdAndAnswer_AnswerId(answerVotePatchDto.getUserId(),
                                                                                                                        answerVotePatchDto.getAnswerId());
        // 기존에 투표한 사람으로 투표값 update
        if(optionalAnswerVote.isPresent()){
            System.out.println("중복됨");
            AnswerVote findAnswerVote = optionalAnswerVote.orElseThrow();

            if(answerVotePatchDto.getAnswerVoteCnt() != optionalAnswerVote.get().answerVoteCnt ){ // 좋아요 1, 싫어요 1
                System.out.print("값이 다를때");
                System.out.printf("%d",optionalAnswerVote.get().answerVoteId);
                System.out.println();
                answerVoteRepository.deleteById(optionalAnswerVote.get().answerVoteId);
                System.out.print("값이 다를때 삭제 완료");
            }

            //answerVoteRepository.save(findAnswerVote);
        }
        // 투표한 적이 없을 때
        else{
            System.out.println("중복되지 않음");
             AnswerVote answerVote= mapper.answerVotePatchDtoTOAnswerVote(answerVotePatchDto);
            answerVoteRepository.save(answerVote);
        }
    }


}
