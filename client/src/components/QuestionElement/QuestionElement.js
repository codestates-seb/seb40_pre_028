import styled from 'styled-components';
import LeftCounts from './LeftCounts';

export const MainUList = styled.ul`
  display: flex;
  flex-flow: column nowrap;
  padding: 16px;
  padding: 0px 0px 5px 0px;

  @media (max-width: 640px) {
    justify-content: flex-start;
    flex-direction: column;
  }
`;

export const SQuestionList = styled.li`
  display: flex;
  flex-flow: row nowrap;
  row-gap: 7px;
  padding: 14px;
  width: 100%;
  border-top: 0.2px solid var(--black-100);

  @media (max-width: 640px) {
    justify-content: flex-start;
    flex-direction: column;
  }
`;

export const Container = styled.section`
  display: flex;
  flex-direction: column;
  row-gap: 3px;
  height: auto;
  width: 100%;
`;

export const STitleLink = styled.a`
  margin-bottom: 5px;
  font-size: 17px;
  line-height: 1.4rem;
  color: var(--blue-600);

  &:link,
  &:visited {
    color: var(--blue-600);
  }

  @media (max-width: 640px) {
    font-size: 1rem;
  }
`;

export const STextP = styled.p`
  font-size: 14px;
  color: var(--black-700);
  margin-bottom: 8px;
  padding-right: 23px;
  line-height: 1.3rem;
  max-height: 43px;
  width: calc(100%);
  overflow: hidden;
  word-break: break-all;

  @media (max-width: 640px) {
    font-size: 0.83rem;
    line-height: 1.1rem;
    max-height: 36px;
  }
`;

export const ContentFooter = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;
  flex-wrap: wrap;
  padding-right: 23px;
`;

export const Tags = styled.div`
  display: flex;
  flex-flow: wrap;
  row-gap: 1px;

  @media (max-width: 640px) {
    margin-bottom: 5px;
  }
  > div {
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 13px;
    color: var(--blue-600);
    background-color: var(--blue-100);
    border-radius: 3px;
    padding: 2px 6px;
    margin-right: 5px;
    margin-bottom: 5px;
    cursor: pointer;
  }
`;

export const UserContainer = styled.div`
  display: flex;
  align-items: center;
  margin-left: auto;
  font-size: 12px;
  justify-content: space-between;
  column-gap: 6px;
  flex-wrap: wrap;
  padding-top: 4px;
  padding-left: 5px;

  img {
    border-radius: 30%;
  }

  @media (max-width: 640px) {
  }
`;

export const UserName = styled.div`
  color: var(--blue-600);
  width: auto;
`;

export const UserAsked = styled.div`
  color: var(--black-600);
`;

const UserFooter = () => {
  return (
    <UserContainer>
      <UserName>User name</UserName>
      <UserAsked>asked 1 hour ago</UserAsked>
    </UserContainer>
  );
};

const QuestionElement = () => {
  return (
    <MainUList>
      <SQuestionList>
        <LeftCounts />
        <Container>
          <STitleLink>This is subject</STitleLink>
          <STextP>This is content</STextP>
          <ContentFooter>
            <Tags>
              <div>Tag1</div>
              <div>Tag2</div>
              <div>Tag3</div>
            </Tags>
            <UserFooter />
          </ContentFooter>
        </Container>
      </SQuestionList>
    </MainUList>
  );
};

export default QuestionElement;
