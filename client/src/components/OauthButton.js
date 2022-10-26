import styled from 'styled-components';
import { ReactComponent as GoogleFavicon } from '../assets/img/google_favicon.svg';
import { ReactComponent as GithubFavicon } from '../assets/img/github_favicon.svg';
import { ReactComponent as FacebookFavicon } from '../assets/img/facebook_favicon.svg';

const BtnContainer = styled.div`
  display: flex;
  flex-direction: column;
  margin-top: 50px;
`;
const BtnWith = styled.button`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 340px;
  padding: 10px 0;
  color: ${props => (props.bgColor ? 'white' : 'rgba(0,0,0,0.8)')};
  background-color: ${props => (props.bgColor ? (props.bgColor === 'github' ? '#2F3337' : '#385499') : '#FFFFFF')};
  border: 0.5px solid rgba(0, 0, 0, 0.4);
  border-radius: 4px;
  margin: 5px 0;
  &:hover {
    cursor: pointer;
    background-color: ${props => (props.bgColor ? (props.bgColor === 'github' ? '#131517' : '#254799') : '#F7F7F7')};
  }
`;
const GoogleLogo = styled(GoogleFavicon)`
  width: 20px;
  margin-right: 3px;
`;
const GithubLogo = styled(GithubFavicon)`
  width: 20px;
  margin-right: 3px;
`;
const FacebookLogo = styled(FacebookFavicon)`
  width: 20px;
  margin-right: 3px;
`;

export default function OauthBtn() {
  return (
    <BtnContainer>
      <BtnWith>
        <GoogleLogo />
        <span>Sign up with Google</span>
      </BtnWith>
      <BtnWith bgColor="github">
        <GithubLogo />
        <span>Sign up with Github</span>
      </BtnWith>
      <BtnWith bgColor="facebook">
        <FacebookLogo />
        <span>Sign up with FaceBook</span>
      </BtnWith>
    </BtnContainer>
  );
}
