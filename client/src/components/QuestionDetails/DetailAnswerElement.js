import styled from 'styled-components';
import { BlueButton } from '../DefaultButton';
import { AnswerMainElement } from './AnswerMainElement';
import ChEditor from '../../pages/ChEditor';

const Container = styled.div`
  h2 {
    font-size: 20px;
    border-top: 1px solid #d6d9dc;
    padding-top: 25px;
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
  * {
    margin: 20px 0;
  }
  a {
    color: #0074cc;
  }
`;

const AnswerCount = styled.div`
  display: flex;
  justify-content: space-between;
  padding-right: 30px;
`;

export const DetailAnswerElement = ({ answers }) => {
  return (
    <Container>
      <AnswerCount>
        <h3 className="qanswer">{answers.length} Answer</h3>
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
          key={answer.answerId}
          id={answer.answerId}
          createdAt={answer.answerCreatedAt}
          body={answer.answerBody}
          name={answer.name}
          vote={answer.vote}
        />
      ))}
      <Answer>
        <h2>Your Answer</h2>
        {/* <ChEditor /> */}
        <BlueButton>Post Your Answer</BlueButton>
      </Answer>
    </Container>
  );
};
