import { useEffect, useState } from 'react';
import styled from 'styled-components';
import { BlueButton } from './DefaultButton';
import { QuestionElement } from './QuestionElement/QuestionElement';
import { SortButton } from './SortButton';
import { Pagenation } from '../utils/Pagenation';

const SMainBar = styled.div`
  position: relative;
  display: flex;
  flex-flow: column nowrap;
  width: calc(100% - 300px);
  min-height: calc(100vh - 420px);
  overflow-x: hidden;
  padding: 0 24px 0 24px;

  @media (max-width: 1100px) {
    width: 100%;
  }
`;

const HeaderContainer = styled.div`
  display: flex;
  justify-content: space-between;
  height: 50px;
  margin-bottom: 12px;

  > h1 {
    font-size: 1.7rem;
  }
`;

const InfoContainer = styled.div`
  display: flex;
  justify-content: space-between;
  margin-bottom: 12px;

  > div {
    display: flex;
    align-items: center;
    justify-content: center;
    min-width: 100px;
  }
`;

export const MainUList = styled.ul`
  display: flex;
  flex-flow: column nowrap;
  padding: 16px;

  @media (max-width: 640px) {
    justify-content: flex-start;
    flex-direction: column;
  }
  margin-left: -32px;
  border-bottom: 1px solid var(--black-100);
`;

export function MainBar() {
  let [questions, setQuestions] = useState([]);
  let [isLoading, setIsLoading] = useState(true);
  let [page, setPage] = useState(1);

  useEffect(() => {
    getData();
  }, [page]);

  const getData = async () => {
    const res = await fetch(`http://localhost:3001/questions?_page=${page}&_limit=5`);
    const data = await res.json();
    setQuestions(data);
    setIsLoading(false);
    window.scroll({
      top: 0,
      behavior: 'smooth',
    });
  };

  return (
    <SMainBar>
      <HeaderContainer>
        <h1>All Questions</h1>
        <BlueButton height="40px">Ask Question</BlueButton>
      </HeaderContainer>
      <InfoContainer>
        <div>23,148,368 questions</div>
        <SortButton nameList={['Newest', 'Votes']} />
      </InfoContainer>
      <MainUList>
        {isLoading ? (
          <div>Loading...</div>
        ) : (
          questions.map(question => (
            <QuestionElement
              key={question.id}
              title={question.title}
              body={question.body}
              tag={question.tag}
              name={question.name}
              createdAt={question.createdAt}
              votes={question.votes}
              answers={question.answers}
              views={question.views}
            />
          ))
        )}
      </MainUList>
      <Pagenation total={11} limit={5} page={page} setPage={setPage} />
    </SMainBar>
  );
}
