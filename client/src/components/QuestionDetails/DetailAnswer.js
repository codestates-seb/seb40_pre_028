import styled from 'styled-components';
import { DetailMain } from './DetailMain';

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

const Btn = styled.button`
  all: unset;
  height: 20px;
  width: 130px;
  text-align: center;
  color: white;
  background-color: #0a96ff;
  cursor: pointer;
  padding: 0.8em;
  border-radius: 5px;
  &:hover {
    background: #0074cc;
  }
  margin-top: 10px;
`;

const AnswerCount = styled.div`
  display: flex;
  justify-content: space-between;
  padding-right: 30px;
`;

export const DetailAnswer = () => {
  return (
    <Container>
      <AnswerCount>
        <h3 className="qanswer">1 Answer</h3>
        <div>
          <span>sorted by:</span>
          <select defaultValue="1" name="" id="" className="select">
            <option value="1">Highest score (default)</option>
            <option value="0"> Date modified (newest first) </option>
            <option value="0"> Date created (oldest first) </option>
          </select>
        </div>
      </AnswerCount>
      <DetailMain />
      <Answer>
        <h2>Your Answer</h2>
        <Btn>Post Your Answer</Btn>
      </Answer>
    </Container>
  );
};
