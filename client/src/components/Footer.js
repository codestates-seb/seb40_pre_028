import styled from 'styled-components';

const FooterLayout = styled.div`
  width: 100%;
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
  .title {
    color: #babfc4;
    font-weight: bold;
  }
  ul {
    color: #9199a1;
    list-style: none;
  }
`;

const Social = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  color: #9199a1;
  font-size: 11px;
  ul {
    list-style: none;
    display: flex;
    column-gap: 10px;
  }
  p {
    margin-left: 40px;
  }
`;

function Footer() {
  return (
    <FooterLayout>
      <FooterTextBox>
        <Column>
          <ul>
            <div className="title">STACK OVERFLOW</div>
            <li>Questions</li>
            <li>Help</li>
          </ul>
        </Column>
        <Column>
          <ul>
            <div className="title">PRODICTS</div>
            <li>Teams</li>
            <li>Advertising</li>
            <li>Collectives</li>
            <li>Talent</li>
          </ul>
        </Column>
        <Column>
          <ul>
            <div className="title">COMPANY</div>
            <li>About</li>
            <li>Press</li>
            <li>Work Here</li>
            <li>Legal</li>
            <li>Privacy Policy</li>
            <li>Terms of Service</li>
            <li>Contact Us</li>
            <li>Cookie Settings</li>
            <li>Cookie Policy</li>
          </ul>
        </Column>
        <Column>
          <ul>
            <div className="title">STACK EXCHANGE NETWORK</div>
            <li>Technology</li>
            <li>Culture & recreation</li>
            <li>Life & arts</li>
            <li>Science</li>
            <li>Professional</li>
            <li>Business</li>
            <li>API</li>
            <li> </li>
            <li>Data</li>
          </ul>
        </Column>
        <Social>
          <ul>
            <li>Blog</li>
            <li>FaceBook</li>
            <li>Twitter</li>
            <li>Linkedin</li>
            <li>Instagram</li>
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
