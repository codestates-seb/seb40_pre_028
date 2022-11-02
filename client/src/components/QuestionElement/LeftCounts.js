import styled from 'styled-components';

export const Wrapper = styled.div`
  display: flex;
  justify-content: flex-end;
  font-size: 13px;
  color: var(--fc-dark);

  @media (max-width: 640px) {
    font-size: 13px;
    margin-right: 6px;
  }
`;

export const Container = styled.div`
  display: flex;
  flex-direction: column;
  align-items: flex-end;
  width: 108px;
  flex-shrink: 0;
  margin-right: 16px;
  row-gap: 7px;

  @media (max-width: 640px) {
    margin: 0px 0px 4px 0px;
    flex-direction: row;
    width: auto;
  }
`;

const LeftCounts = ({ votes, answers, views }) => {
  return (
    <Container>
      <Wrapper>{votes} votes</Wrapper>
      <Wrapper>{answers} answers</Wrapper>
      <Wrapper>{views} views</Wrapper>
    </Container>
  );
};

export default LeftCounts;
