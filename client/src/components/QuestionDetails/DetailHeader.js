import styled from 'styled-components';

const Header = styled.div`
  border-bottom: 1px solid #d6d9dc;
`;

const Title = styled.div`
  a {
    font-size: 1.6rem;
    color: #3b4045;
    line-height: 40px;
  }
`;

const Btn = styled.button`
  all: unset;
  height: 20px;
  width: 110px;
  text-align: center;
  color: white;
  background-color: #0a96ff;
  cursor: pointer;
  padding: 0.8em;
  border-radius: 5px;
  &:hover {
    background: #0074cc;
  }
`;

const TitleSet = styled.div`
  display: flex;
  justify-content: space-between;
  padding: 10px 0;
`;

const TitleInfo = styled.div`
  display: flex;
  div {
    margin: 0 10px 10px 0;
  }
  & a {
    text-decoration: none;
    color: black;
  }
`;

const Span = styled.span`
  margin-right: 10px;
  color: #6b737d;
`;

export const DetailHeader = () => {
  return (
    <Header>
      <TitleSet>
        <Title>
          <a href="/question">Cannot move behind a shared reference</a>
        </Title>
        <Btn>Ask Question</Btn>
      </TitleSet>
      <TitleInfo>
        <div>
          <Span>Asked</Span>
          <time>today</time>
        </div>
        <div>
          <Span>Modified</Span>
          <a href="?lastactivity">today</a>
        </div>
        <div>
          <Span>Viewed</Span>
          14 times
        </div>
      </TitleInfo>
      <div></div>
    </Header>
  );
};
