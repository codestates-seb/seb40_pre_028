import styled from 'styled-components';
import { BlueButton } from './DefaultButton';
import { QuestionElement } from './QuestionElement/QuestionElement';
import { SortButton } from './SortButton';

const SMainBar = styled.div`
  position: relative;
  display: flex;
  flex-flow: column nowrap;
  width: calc(100% - 300px);
  min-height: calc(100vh - 420px);
  max-width: 1300px;
  overflow-x: hidden;
  padding: 0 24px 0 24px;
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
  padding: 0px 0px 5px 0px;

  @media (max-width: 640px) {
    justify-content: flex-start;
    flex-direction: column;
  }
  margin-left: -32px;
`;

let questions = [
  {
    id: 1,
    title: 'This is title',
    body: 'This is body',
    tag: ['Tag1', 'Tag2', 'Tag3'],
    name: 'User name',
    createdAt: '2021-10-01 00:00:00',
    modifiedAt: '2022-02-02 00:00:00',
    votes: 123,
    answers: 10,
    views: 100,
  },
  {
    id: 2,
    title: 'This is title',
    body: 'This is body',
    tag: ['Tag1', 'Tag2', 'Tag3'],
    name: 'User name',
    createdAt: '2022-10-01 00:00:00',
    modifiedAt: '2022-02-02 00:00:00',
    votes: 123,
    answers: 10,
    views: 100,
  },
];

export function MainBar() {
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
        {questions.map(question => (
          <QuestionElement
            key={question.id}
            title={question.title}
            body={question.body}
            tag={question.tag}
            name={question.name}
            createdAt={question.createdAt}
            modifiedAt={question.modifiedAt}
            votes={question.votes}
            answers={question.answers}
            views={question.views}
          />
        ))}
      </MainUList>
    </SMainBar>
  );
}
