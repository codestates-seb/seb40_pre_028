import styled from 'styled-components';
import { VscTriangleUp, VscTriangleDown } from 'react-icons/vsc';
import { BsBookmark, BsPersonSquare } from 'react-icons/bs';
import { GiBackwardTime } from 'react-icons/gi';
import { useState } from 'react';
import { getDateToString } from '../../utils/dateFormat';
// import { MarkdownRenderer } from './MarkdownRenderer';

const Main = styled.div`
  padding: 5px 40px 10px 5px;
  width: 772px;
`;

const Section = styled.div`
  display: flex;
`;

const User = styled.div`
  display: flex;
  justify-content: space-between;
`;

const UserInfo = styled(Section)`
  padding: 10px 50px 10px 10px;
  background-color: #d9eaf7;
  display: flex;
  flex-direction: column;
  font-size: 12px;
  border-radius: 3px;
  div:first-child {
    color: #69737c;
  }
  .userPicture {
    margin: 5px 5px 0 0;
    font-size: 20px;
  }

  .center {
    display: flex;
    line-height: 30px;
  }
`;

const PostTag = styled.div`
  & a {
    background-color: #d9eaf7;
    color: #38749d;
    border-radius: 5px;
    padding: 5px;
  }
  & li {
    float: left;
    margin-right: 10px;
  }
  & ul {
    display: block;
  }
  margin-bottom: 40px;
`;

const Select = styled.div`
  padding: 10px;
  & > button {
    all: unset;
  }
  & > * {
    display: block;
    display: flex;
    margin: auto;
    margin-bottom: 5px;
  }
  & > span {
    width: 10px;
  }
  .triangle {
    font-size: 40px;
  }
  .booktime {
    font-size: 15px;
    margin-bottom: 10px;
  }
  .icon {
    color: #bbbfc4;
  }
  .time {
    font-size: 20px;
  }
`;

const Question = styled.div`
  p {
    margin: 20px 0;
  }
  display: flex;
  flex-direction: column;
`;

const SEF = styled.div`
  * {
    margin-right: 8px;
    color: #69737c;
    font-size: 13px;
  }
  button {
    border: 0;
    outline: 0;
    background-color: white;
  }
`;

const Tag = ({ tag }) => {
  return <div>{tag}</div>;
};

export const DetailMainElement = ({ body, createdAt, name }) => {
  let [count, SetCount] = useState(0);

  return (
    <Main>
      <Section>
        <Select>
          <button
            onClick={() => {
              SetCount(count + 1);
            }}
          >
            <VscTriangleUp className="icon triangle" />
          </button>
          <span>{count}</span>
          <button
            onClick={() => {
              SetCount(count - 1);
            }}
          >
            <VscTriangleDown className="icon triangle" />
          </button>
          <BsBookmark className="icon booktime" />
          <GiBackwardTime className="icon booktime time" />
        </Select>
        <Question>
          <p>{body}</p>
          {/* <MarkdownRenderer /> */}
          <PostTag>
            <ul>
              <li>
                <a href="/question">javascript</a>
              </li>
              <li>
                <a href="/question">react</a>
              </li>
            </ul>
          </PostTag>
          <User>
            <SEF>
              <a href="question">Share</a>
              <button>Edit</button>
              <button>Follow</button>
            </SEF>
            <UserInfo>
              <div>asked {getDateToString(createdAt)}</div>
              <div className="center">
                <BsPersonSquare className="userPicture" />
                <span>{name}</span>
              </div>
            </UserInfo>
          </User>
        </Question>
      </Section>
    </Main>
  );
};
