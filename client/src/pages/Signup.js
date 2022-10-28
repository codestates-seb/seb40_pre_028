import styled from 'styled-components';
import { OauthBtn } from '../components/Authentications/OauthButton';
import { SignupForm } from '../components/Authentications/SignupForm';

const Bg = styled.div`
  background-color: #f1f2f3;
  padding: 20px 0;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
`;

export default function SignupPage({ setIsLoading, setUserData }) {
  return (
    <Bg>
      <OauthBtn />
      <SignupForm setIsLoading={setIsLoading} setUserData={setUserData} />
    </Bg>
  );
}
