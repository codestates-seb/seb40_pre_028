import styled from 'styled-components';
import { VscTriangleUp, VscTriangleDown } from 'react-icons/vsc';
import { BsBookmark, BsPersonSquare } from 'react-icons/bs';
import { GiBackwardTime } from 'react-icons/gi';
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
  a {
    margin: auto 0;
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
  & > div {
    display: flex;
    align-items: center;
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

const Comment = styled.div`
  color: #b7bbc0;
  font-size: 12px;
  margin-top: 10px;
`;

export const DetailMain = () => {
  return (
    <Main>
      <Section>
        <Select>
          <button>
            <VscTriangleUp className="icon triangle" />
          </button>
          <div>0</div>
          <button>
            <VscTriangleDown className="icon triangle" />
          </button>
          <BsBookmark className="icon booktime" />
          <GiBackwardTime className="icon booktime time" />
        </Select>
        <Question>
          <p>
            This code doesnt compile This code doesnt compileThis code doesnt compile This code doesnt compile This code doesnt compile This code
            doesnt compile This code doesnt compile This code doesnt compileThis code doesntcompile This code doesnt compile This code doesnt compile
            This code doesnt compile This code doesnt compile This code doesnt compileThis code doesntcompile This code doesnt compile This code
            doesnt compile This code doesnt compile This code doesnt compile This code doesnt compileThis code doesnt compile This code doesnt compile
            This code doesnt compile This code doesnt compileThis code doesnt compile This code doesnt compileThis code doesnt compile This code
            doesnt compile This code doesnt compile This codedoesnt compile This code doesnt compile This code doesnt compileThis code doesnt compile
            This code doesnt compile This code doesnt compile This code doesnt compile This code doesnt compile This code doesnt compile This code
            doesntcompile This code doesnt compile This code doesnt compile This code doesnt compile This code doesnt compile This code doesnt
            compileThis code doesnt compile This code doesnt compile This code doesnt compile This code doesnt compile
          </p>
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
              <div>
                asked <span>1 minute ago</span>
              </div>
              <div className="center">
                <BsPersonSquare className="userPicture" />
                <a href="/login">UserName</a>
              </div>
            </UserInfo>
          </User>
          <Comment>Add a comment</Comment>
        </Question>
      </Section>
    </Main>
  );
};
