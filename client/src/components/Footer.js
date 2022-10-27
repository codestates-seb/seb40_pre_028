import styled from 'styled-components';
import StackIcon from '../assets/img/stackicon.png';

const FooterLayout = styled.div`
  background-color: #232629;
`;

const FooterTextBox = styled.div`
  top: 0;
  bottom: 0;
  width: 90%;
  padding: 1rem;
  box-sizing: border-box;
  display: flex;
  justify-content: center;
`;

const Column = styled.div`
  font-size: 13px;
  margin-right: 70px;

  .title {
    color: #babfc4;
    font-weight: bold;
  }
  ul {
    color: #9199a1;
    list-style: none;
    margin-top: 20px;
  }
  li {
    margin-top: 10px;
  }
  li.blank {
    color: #232629;
  }
`;

const Social = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  color: #9199a1;
  font-size: 11px;
  margin-right: 40px;
  margin-top: 20px;
  ul {
    list-style: none;
    display: flex;
    column-gap: 10px;
  }
  p {
    margin-left: 40px;
  }
`;

const LogoBox = styled.div`
  img {
    display: flex;
    height: 50px;
    margin-right: 15px;
  }
`;

function Footer() {
  return (
    <FooterLayout>
      <FooterTextBox>
        <LogoBox>
          <img src={StackIcon} alt="logo" />
        </LogoBox>
        <Column>
          <ul>
            <div className="title">
              <a href="https://stackoverflow.com/">STACK OVERFLOW</a>
            </div>
            <li>Questions</li>
            <li>Help</li>
          </ul>
        </Column>
        <Column>
          <ul>
            <div className="title">
              <a href="https://stackoverflow.co/">PRODICTS</a>
            </div>
            <li>
              <a href="https://stackoverflow.co/teams/">Teams</a>
            </li>
            <li>
              <a href="https://stackoverflow.co/advertising/">Advertising</a>
            </li>
            <li>
              <a href="https://stackoverflow.co/collectives/">Collectives</a>
            </li>
            <li>
              <a href="https://stackoverflow.co/talent/">Talent</a>
            </li>
          </ul>
        </Column>
        <Column>
          <ul>
            <div className="title">
              <a href="https://stackoverflow.co/">COMPANY</a>
            </div>
            <li>
              <a href="https://stackoverflow.co/">About</a>
            </li>
            <li>
              <a href="https://stackoverflow.co/company/press">Press</a>
            </li>
            <li>
              <a href="https://stackoverflow.co/company/work-here">Work Here</a>
            </li>
            <li>
              <a href="https://stackoverflow.com/legal/terms-of-service">Legal</a>
            </li>
            <li>
              <a href="https://stackoverflow.com/legal/privacy-policy">Privacy Policy</a>
            </li>
            <li>
              <a href="https://stackoverflow.com/legal/terms-of-service">Terms of Service</a>
            </li>
            <li>
              <a href="https://stackoverflow.co/company/contact">Contact Us</a>
            </li>
            <li>Cookie Settings</li>
            <li>
              <a href="https://stackoverflow.com/legal/cookie-policy">Cookie Policy</a>
            </li>
          </ul>
        </Column>
        <Column>
          <ul>
            <div className="title">
              <a href="https://stackexchange.com/">STACK EXCHANGE NETWORK</a>
            </div>
            <li>
              <a href="https://stackexchange.com/sites#technology">Technology</a>
            </li>
            <li>
              <a href="https://stackexchange.com/sites#culturerecreation">Culture & recreation</a>
            </li>
            <li>
              <a href="https://stackexchange.com/sites#lifearts">Life & arts</a>
            </li>
            <li>
              <a href="https://stackexchange.com/sites#science">Science</a>
            </li>
            <li>
              <a href="https://stackexchange.com/sites#professional">Professional</a>
            </li>
            <li>
              <a href="https://stackexchange.com/sites#business">Business</a>
            </li>
            <li>
              <a href="https://api.stackexchange.com/">API</a>
            </li>
            <li className="blank">공백</li>
            <li>
              <a href="https://data.stackexchange.com/">Data</a>
            </li>
          </ul>
        </Column>
        <Social>
          <ul>
            <li>
              <a href="https://stackoverflow.blog/?blb=1">Blog</a>
            </li>
            <li>
              <a href="https://www.facebook.com/officialstackoverflow/">FaceBook</a>
            </li>
            <li>
              <a href="https://twitter.com/stackoverflow">Twitter</a>
            </li>
            <li>
              <a href="https://www.linkedin.com/company/stack-overflow">Linkedin</a>
            </li>
            <li>
              <a href="https://www.instagram.com/thestackoverflow/">Instagram</a>
            </li>
          </ul>
          <div className="pre028">
            <p>Made by. 일곱ㅎ쟁이 seb40_pre_028</p>
          </div>
        </Social>
      </FooterTextBox>
    </FooterLayout>
  );
}

export default Footer;
