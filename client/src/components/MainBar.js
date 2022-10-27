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
        <QuestionElement />
        <QuestionElement />
        <QuestionElement />
        <QuestionElement />
        <QuestionElement />
      </MainUList>
    </SMainBar>
  );
}
