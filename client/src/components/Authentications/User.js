import styled from 'styled-components';
import StackIcon from '../../assets/img/stackicon.png';

const UserContainer = styled.div`
  width: 200px;
  height: 200px;
  background-color: white;
  display: flex;
  flex-direction: column;
  justify-content: start;
  align-items: center;
  /* position: relative; */
  h2 {
    margin-bottom: 20px;
  }
  h4 {
    margin-bottom: 10px;
  }
`;
const Logo = styled.div`
  margin: 10px 0;
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
      <h2>* 회원정보 *</h2>
      <div>
        <h4>이름: {userData.name} </h4>
        <h4>Email: {userData.email}</h4>
      </div>
    </UserContainer>
  );
}
