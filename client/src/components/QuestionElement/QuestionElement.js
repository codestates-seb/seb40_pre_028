import styled from 'styled-components';
import LeftCounts from './LeftCounts';
import { getDateToString } from '../../utils/dateFormat';
import { Link } from 'react-router-dom';

//! UI

export const SQuestionList = styled.li`
  display: flex;
  flex-flow: row nowrap;
  row-gap: 7px;
  padding: 16px;
  width: 100%;
  border-top: 1px solid var(--black-100);

  @media (max-width: 640px) {
    justify-content: flex-start;
    flex-direction: column;
  }
`;

export const SectionContainer = styled.section`
  display: flex;
  flex-direction: column;
  row-gap: 3px;
  height: auto;
  width: 100%;
`;

// 라우터 Link로 바꿔야함
export const STitleLink = styled(Link)`
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
  line-height: 1.3rem;
  max-height: 43px;
  width: 100%;
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
`;

export const Tags = styled.div`
  display: flex;
  flex-flow: wrap;
  row-gap: 1px;
  margin-bottom: 8px;

  > div {
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 12px;
    color: var(--powder-700);
    background-color: var(--powder-100);
    border-radius: 3px;
    padding: 2px 6px;
    margin: 2px;
    padding: 4.8px 6px;
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

const Tag = ({ tag }) => {
  return <div>{tag}</div>;
};

const QuestionElement = ({ id, title, body, tag = ['Tag1'], name = 'User Name', createdAt, votes = 1, answers, views = 3 }) => {
  return (
    <SQuestionList>
      <LeftCounts votes={votes} answers={answers} views={views} />
      <SectionContainer>
        <STitleLink to={`/${id}`} state={name}>
          {title}
        </STitleLink>
        <STextP>{body.length > 160 ? `${body.slice(0, 160)}...` : body}</STextP>
        <ContentFooter>
          <Tags>
            {tag.map(tag => (
              <Tag key={tag} tag={tag} />
            ))}
          </Tags>
          <UserContainer>
            <UserName>{name}</UserName>
            <UserAsked> {`asked ${getDateToString(createdAt)}`}</UserAsked>
          </UserContainer>
        </ContentFooter>
      </SectionContainer>
    </SQuestionList>
  );
};

export { QuestionElement };
