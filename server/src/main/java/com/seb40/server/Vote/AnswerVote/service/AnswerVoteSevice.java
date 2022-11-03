package com.seb40.server.Vote.AnswerVote.service;

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

            AnswerVote findAnswerVote = optionalAnswerVote.orElseThrow();
            findAnswerVote.setAnswerVoteCnt(answerVotePatchDto.getAnswerVoteCnt());
            answerVoteRepository.save(findAnswerVote);
        }
        // 투표한 적이 없을 때
        else{
             AnswerVote answerVote= mapper.answerVotePatchDtoTOAnswerVote(answerVotePatchDto);
            answerVoteRepository.save(answerVote);
        }
    }


}
