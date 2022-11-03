import styled from 'styled-components';
import { BlueButton } from '../DefaultButton';
import { getDateToString } from '../../utils/dateFormat';
import { Link } from 'react-router-dom';

const Header = styled.div`
  border-bottom: 1px solid #d6d9dc;
  width: 1070px;
  height: 102px;
  padding: 10px;
`;

const Title = styled.h1`
  font-size: 1.6rem;
  color: #3b4045;
  line-height: 40px;
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
    color: black;
  }
`;

const Span = styled.span`
  margin-right: 10px;
  color: #6b737d;
`;

export const DetailHeaderElement = ({ title, createdAt, modified, views }) => {
  return (
    <Header>
      <TitleSet>
        <Title>{title}</Title>
        <Link to="/ask">
          <BlueButton height="40px">Ask Question</BlueButton>
        </Link>
      </TitleSet>
      <TitleInfo>
        <div>
          <Span>Asked</Span>
          {getDateToString(createdAt)}
        </div>
        <div>
          <Span>Modified</Span>
          {getDateToString(modified)}
        </div>
        <div>
          <Span>Viewed</Span>
          {views}
        </div>
      </TitleInfo>
    </Header>
  );
};
