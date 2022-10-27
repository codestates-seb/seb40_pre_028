import styled from 'styled-components';
import { LoginForm } from '../components/LoginForm';
import StackIcon from '../assets/img/stackicon.png';
import { OauthBtn } from '../components/OauthButton';
const Bg = styled.div`
  background-color: #f1f2f3;
  padding: 20px 0;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
`;
const Logo = styled.div`
  img {
    width: 60px;
  }
`;

export default function LoginPage({ setIsLoading, setUserData }) {
  return (
    <Bg>
      <Logo>
        <img src={StackIcon} alt="logo" />
      </Logo>
      <OauthBtn />
      <LoginForm setIsLoading={setIsLoading} setUserData={setUserData} />
    </Bg>
  );
}
