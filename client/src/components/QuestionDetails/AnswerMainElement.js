import styled from 'styled-components';
import { VscTriangleUp, VscTriangleDown } from 'react-icons/vsc';
import { BsBookmark, BsPersonSquare } from 'react-icons/bs';
import { GiBackwardTime } from 'react-icons/gi';
import { useState } from 'react';
import { getDateToString } from '../../utils/dateFormat';
import { fetchUpdateVote, fetchDelete, fetchEdit } from '../../utils/apis';
import { useSelector } from 'react-redux';
// import { useParams } from 'react-router-dom';
import ChEditor from '../ChEditor';
import { BlueButton } from '../DefaultButton';
// import { MarkdownRenderer } from './MarkdownRenderer';

const Main = styled.div`
  padding: 5px 40px 10px 5px;
  width: 740px;
  border-bottom: 1px solid #d6d9dc;
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
    cursor: pointer;
  }
`;

const VoteBtnUp = styled(VscTriangleUp)`
  &:hover {
    cursor: pointer;
    color: var(--blue-500);
    transition: 0.4s all;
  }
`;
const VoteBtnDown = styled(VscTriangleDown)`
  &:hover {
    cursor: pointer;
    color: var(--blue-500);
    transition: 0.4s all;
  }
`;

export const AnswerMainElement = ({ id, body, createdAt, name, vote = '0' }) => {
  let [count, SetCount] = useState(vote);
  const { user } = useSelector(state => state.user);

  const voteHandler = action => {
    let answerVoteCnt = 0;
    if (action === 'up') answerVoteCnt = 1;
    if (action === 'down') answerVoteCnt = -1;

    const payload = {
      userId: user.userId,
      answerId: id,
      answerVoteCnt,
    };

    fetchUpdateVote('/user/answervote', JSON.stringify(payload)).then(data => {
      console.log('vote: ', data);
      SetCount(data.answerVoteSum);
    });
  };

  const [onEdit, setOnEdit] = useState(false);
  const [editAnswer, setEditAnswer] = useState('');
  const aEditHandler = () => {
    const payload = {
      answerBody: editAnswer,
    };
    fetchEdit(`/user/answer/${id}`, JSON.stringify(payload)).then(data => {
      console.log('edit: ', data);
      window.location.reload();
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
              <VoteBtnUp className="icon triangle" />
            </button>
            <span>{count}</span>
            <button
              onClick={() => {
                voteHandler('down');
              }}
            >
              <VoteBtnDown className="icon triangle" />
            </button>
          </div>
          <BsBookmark className="icon booktime" />
          <GiBackwardTime className="icon booktime time" />
        </Select>
        <Question>
          <p>{body}</p>
          <User>
            <SEF>
              <a href="question">Share</a>
              <button onClick={() => setOnEdit(!onEdit)}>Edit</button>
              <button>Follow</button>
              <button
                onClick={() => {
                  if (confirm('????????? ??????????????????????')) fetchDelete(`/user/answer/${id}`).then(window.location.reload);
                }}
              >
                Delete
              </button>
            </SEF>
            <UserInfo>
              <div>asked {getDateToString(createdAt)}</div>
              <div className="center">
                <BsPersonSquare className="userPicture" />
                <span>{name}</span>
              </div>
            </UserInfo>
          </User>
          {onEdit && (
            <>
              <ChEditor onchange={setEditAnswer} />
              <BlueButton onClick={aEditHandler}>Edit</BlueButton>
            </>
          )}
        </Question>
      </Section>
    </Main>
  );
};
