import styled from 'styled-components';
import { BlueButton } from './DefaultButton';
import { SortButton } from './SortButton';

const SMainBar = styled.div`
  position: relative;
  display: flex;
  flex-flow: column nowrap;
  width: calc(100% - 300px);
  min-height: calc(100vh - 420px);
  max-width: 1300px;
  overflow-x: hidden;
  padding-right: 24px;
`;

const Header = styled.div`
  display: flex;
  justify-content: space-between;
  height: 50px;
  margin-bottom: 12px;
  > h1 {
    font-size: 2rem;
  }
`;

const InfoContainer = styled.div`
  display: flex;
  border: 1px solid red;

  > div {
    align-items: center;
    justify-content: center;
    min-width: 100px;
    height: 45px;
    margin-right: 12px;
  }
`;

export function MainBar() {
  return (
    <SMainBar>
      <Header>
        <h1>All Questions</h1>
        <BlueButton>Ask Question</BlueButton>
        <SortButton nameList={['Newest', 'Votes']}></SortButton>
      </Header>
      <InfoContainer>
        <div>23,148,368 questions</div>
      </InfoContainer>
    </SMainBar>
  );
}
