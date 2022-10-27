import styled from 'styled-components';
import StackIcon from '../assets/img/stackicon.png';

const UserContainer = styled.div`
  width: 300px;
  height: 500px;
  background-color: white;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;

  position: relative;
  h2 {
    position: absolute;
    top: 100px;
  }
  h4 {
    position: absolute;
    top: 150px;
  }
  div {
    margin-bottom: 20px;
  }
`;
const Logo = styled.div`
  img {
    width: 60px;
  }
`;
export function User({ userData }) {
  return (
    <UserContainer>
      <Logo>
        <img src={StackIcon} alt="logo" />
      </Logo>
      <h2>안녕하세요 {userData.user_name}님 </h2>
      <h4>*회원정보*</h4>
      <div>ID: {userData.user_id}</div>
      <div>Email: {userData.user_email}</div>
    </UserContainer>
  );
}
