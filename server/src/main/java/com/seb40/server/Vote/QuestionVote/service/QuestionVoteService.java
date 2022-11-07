package com.seb40.server.Vote.QuestionVote.service;

import com.seb40.server.Vote.QuestionVote.Dto.QuestionVotePatchDto;
import com.seb40.server.Vote.QuestionVote.Entity.QuestionVote;
import com.seb40.server.Vote.QuestionVote.Mapper.QuestionVoteMapper;
import com.seb40.server.Vote.QuestionVote.Repository.QuestionVoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionVoteService {
    private final QuestionVoteRepository questionVoteRepository;

    private final QuestionVoteMapper mapper;

    public void vote(QuestionVotePatchDto questionVotePatchDto ) {
        Optional<QuestionVote> optionalQuestionVote =  questionVoteRepository.findQuestionVotesByUser_UserIdAndQuestion_QuestionId(questionVotePatchDto.getUserId(),
                questionVotePatchDto.getQuestionId());
        // 기존에 투표한 사람으로 투표값 update
        if(optionalQuestionVote.isPresent()){

            QuestionVote findQuestionVote = optionalQuestionVote.orElseThrow();

            if(questionVotePatchDto.getQuestionVoteCnt() != findQuestionVote.getQuestionVoteCnt()){
                questionVoteRepository.deleteById(findQuestionVote.getQuestionVoteId());
            }
        }
        // 투표한 적이 없을 때
        else{
            QuestionVote questionVote= mapper.questionVotePatchDtoTOQuestionVote(questionVotePatchDto);
            questionVoteRepository.save(questionVote);
        }
    }
}
