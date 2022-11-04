import styled from 'styled-components';
import { BlueButton } from '../DefaultButton';
import { AnswerMainElement } from './AnswerMainElement';
import ChEditor from '../ChEditor';
import { useState } from 'react';

const Container = styled.div`
  h2 {
    font-size: 20px;
    border-top: 1px solid #d6d9dc;
    padding: 25px 0;
  }
  .qanswer {
    padding-left: 20px;
    font-size: 20px;
  }
  margin-top: 30px;
  .select {
    margin-left: 10px;
    padding: 5px;
  }
`;

const Answer = styled.div`
  a {
    color: #0074cc;
  }
`;

const AnswerCount = styled.div`
  display: flex;
  justify-content: space-between;
  padding-right: 30px;
`;

const Blank = styled.div`
  height: 20px;
`;

export const DetailAnswerElement = ({ answers, onchange, postData }) => {
  const [editorBody, setInputEl2] = useState('');
  const editorInit = () => {
    editorBody.setData('');
    // editorBody.focus(); 작성 후 인풋박스 포커싱
  };

  return (
    <Container>
      <AnswerCount>
        <h3 className="qanswer">{answers.length} Answers</h3>
        <div>
          <span>sorted by:</span>
          <select defaultValue="1" name="" id="" className="select">
            <option value="1">Highest score (default)</option>
            <option value="0"> Date modified (newest first) </option>
            <option value="0"> Date created (oldest first) </option>
          </select>
        </div>
      </AnswerCount>
      {answers.map(answer => (
        <AnswerMainElement
          key={answer.answerCreatedAt} //key 중복오류
          id={answer.answerId}
          createdAt={answer.answerCreatedAt}
          body={answer.answerBody}
          name={answer.name}
          vote={answer.vote}
        />
      ))}
      <Answer>
        <h2>Your Answer</h2>
        <ChEditor onchange={onchange} setInputEl2={setInputEl2} />
        <Blank />
        <BlueButton
          onClick={() => {
            postData();
            editorInit();
          }}
          height="35px"
        >
          Post Your Answer
        </BlueButton>
      </Answer>
    </Container>
  );
};
