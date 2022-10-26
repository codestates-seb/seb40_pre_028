import styled from "styled-components";

const Main = styled.div`
  padding: 10px;
`;

const Section = styled.div`
  display: flex;
`;

const User = styled(Section)`
  display: flex;
  justify-content: space-between;
`;

const UserInfo = styled(Section)`
  background-color: #d9eaf7;
`;

const PostTag = styled.div`
  & ul {
    list-style: none;
  }

  & a {
    background-color: #d9eaf7;
    color: #38749d;
    text-decoration: none;
    border-radius: 5px;
    padding: 5px;
  }
`;

export const DetailMain = () => {
  return (
    <Main>
      <Section>
        <div>
          <div>▲</div>
          <div>0</div>
          <div>▼</div>
          <div>✉️</div>
          <div>⏱</div>
        </div>
        <div>
          <p>
            This code doesnt compile This code doesnt compileThis code doesnt
            compile This code doesnt compile This code doesnt compile This code
            doesnt compile
          </p>
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
            <div>
              <a href="question">Share</a>
              <button>Edit</button>
              <button>Follow</button>
            </div>
            <UserInfo>
              <div>
                asked <span>1 minute ago</span>
              </div>
              <img alt="." />
              <div>
                <a href="/login">TSK</a>
                <span>133</span>
              </div>
            </UserInfo>
          </User>
        </div>
      </Section>
      <div>Add a comment</div>
    </Main>
  );
};
