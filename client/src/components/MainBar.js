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
  padding: 0 24px;
  margin-left: -2px;

  @media (max-width: 1100px) {
    width: 100%;
    padding: 0 0 0 24px;
    // 첫번째와 두번째 자식요소 동시에 선택해서 오른쪽 패딩을 24px로 설정
    > *:first-child,
    > *:nth-child(2) {
      padding-right: 24px;
    }
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

  @media (max-width: 1100px) {
    justify-content: flex-start;
  }
  margin-left: -24px;
  border-bottom: 1px solid var(--black-100);
`;

export function MainBar() {
  let [questions, setQuestions] = useState([]);
  let [isLoading, setIsLoading] = useState(true);
  let [page, setPage] = useState(1);
  let [perPage, setPerPage] = useState(10);

  useEffect(() => {
    getData();
  }, [page, perPage]);

  const getData = async () => {
    const res = await fetch(`http://localhost:3001/questions?_page=${page}&_limit=${perPage}`);
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
      <Pagenation total={11} limit={perPage} page={page} setPage={setPage} perPage={perPage} setPerPage={setPerPage} />
    </SMainBar>
  );
}
