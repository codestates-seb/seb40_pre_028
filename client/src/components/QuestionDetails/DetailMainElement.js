import styled from 'styled-components';
import { VscTriangleUp, VscTriangleDown } from 'react-icons/vsc';
import { BsBookmark, BsPersonSquare } from 'react-icons/bs';
import { GiBackwardTime } from 'react-icons/gi';
import { useState } from 'react';
import { getDateToString } from '../../utils/dateFormat';
import { fetchUpdateVote } from '../../utils/apis';
import { useSelector } from 'react-redux';
import { useParams } from 'react-router-dom';
// import { MarkdownRenderer } from './MarkdownRenderer';

const Main = styled.div`
  padding: 5px 40px 10px 5px;
  width: 740px;
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
  width: 200px;
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
    background-color: var(--powder-100);
    color: var(--powder-700);
    border-radius: 3px;
    padding: 3px 6px;
  }
  & li {
    float: left;
    margin-right: 10px;
    font-size: 12px;
  }
  & ul {
    display: block;
  }
  margin-bottom: 40px;
`;

const Select = styled.div`
  padding: 10px;
  & > * {
    display: block;
    display: flex;
    margin: auto;
    margin-bottom: 5px;
  }
  span {
    color: #6b737d;
    font-size: 18px;
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

  div {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    button {
      all: unset;
    }
  }
`;

const Question = styled.div`
  p {
    margin: 20px 0;
    width: 650px;
    height: 100px;
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
  return (
    <ul>
      <li>
        <a href="/question">{tag}</a>
      </li>
    </ul>
  );
};

export const DetailMainElement = ({ body, createdAt, name, tag, vote = '0' }) => {
  let [count, SetCount] = useState(vote);
  const { user } = useSelector(state => state.user);
  const { id: questionId } = useParams();

  const voteHandler = action => {
    let questionVoteCnt = 0;
    if (action === 'up') questionVoteCnt = '+1';
    if (action === 'down') questionVoteCnt = '-1';

    const payload = {
      userId: user.userId,
      questionId,
      questionVoteCnt,
    };

    fetchUpdateVote('/user/questionvote', JSON.stringify(payload)).then(data => {
      console.log('vote: ', data);
      SetCount(data.questionVoteSum);
    });
  };

  return (
    <Main>
      <Section>
        <Select>
          <div>
            <button //API PATCH
              onClick={() => {
                voteHandler('up');
              }}
            >
              <VscTriangleUp className="icon triangle" />
            </button>
            <span>{count}</span>
            <button
              onClick={() => {
                voteHandler('down');
              }}
            >
              <VscTriangleDown className="icon triangle" />
            </button>
          </div>

          <BsBookmark className="icon booktime" />
          <GiBackwardTime className="icon booktime time" />
        </Select>
        <Question>
          <p>{body}</p>
          {/* <MarkdownRenderer /> */}
          <PostTag>
            {tag.map(tag => (
              <Tag key={tag} tag={tag} />
            ))}
          </PostTag>
          <User>
            <SEF>
              <a href="question">Share</a>
              <button>Edit</button>
              <button>Follow</button>
              <button>Delete</button>
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
