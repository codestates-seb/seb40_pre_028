import styled from 'styled-components';
import OauthBtn from '../components/OauthButton';

// const Google = styled.svg`
//   aria-hidden: 'true';
//   width: 18px;
//   height: 18px;
//   viewbox: '0 0 18 18';
// `;
const Logo = styled.div`
  width: 50px;
  height: 50px;
  background-color: rgba(0, 0, 0, 0.1);
  margin-bottom: 20px;
`;

const Bg = styled.div`
  background-color: #f1f2f3;
  padding: 20px 0;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
`;
const Form = styled.form`
  display: flex;
`;
const Fieldset = styled.fieldset`
  background-color: white;
  width: 340px;
  height: 240px;
  padding: 30px 30px;
  border-radius: 10px;
  border: none;
  margin: 20px;
  box-shadow: 0px 5px 20px rgba(0, 0, 0, 0.1);
`;
const Field = styled.div`
  margin-bottom: 20px;
  div {
    display: flex;
    justify-content: space-between;
    span {
      font-size: 14px;
    }
  }
  a {
    color: #0273cc;
    text-decoration: none;
    &:hover {
      color: #50a7ec;
    }
    &:visited {
      text-decoration: none;
    }
  }
`;
const Label = styled.label`
  margin-bottom: 2px;
  display: block;
  &:hover {
    cursor: pointer;
  }
`;
const Input = styled.input`
  display: block;
  width: 100%;
  padding: 0.6rem 0.7rem;
  border: 1px solid rgba(0, 0, 0, 0.3);
  border-radius: 3px;

  &:focus {
    outline: 3px solid #bfe4ff;
    border-color: #8fcaf2;
  }
`;

const Button = styled.button`
  width: 100%;
  height: 2.4rem;
  color: white;
  background-color: #0996ff;
  border: none;
  border-radius: 4px;
  margin-bottom: 50px;
  &:hover {
    cursor: pointer;
    background-color: #077cd2;
  }
`;
const TextContainer = styled.div`
  margin: 20px 0;
  font-size: 14px;
  text-align: center;
  div {
    margin-bottom: 8px;
  }
  a {
    color: #0273cc;
    text-decoration: none;
    &:hover {
      color: #50a7ec;
    }
    &:visited {
      text-decoration: none;
    }
  }
`;
export default function LogIn() {
  return (
    <Bg>
      <Logo />
      <OauthBtn />
      <Form>
        <Fieldset>
          <Field>
            <Label htmlFor="email">Email</Label>
            <Input type="text" id="email" />
          </Field>
          <Field>
            <div>
              <Label htmlFor="password">Password</Label>
              <span>
                <a href='https://stackoverflow.com/users/account-recovery target="_blank" rel="noreferrer'>Forgot password?</a>
              </span>
            </div>
            <Input type="text" id="password" />
          </Field>
          <Button>Log in</Button>
        </Fieldset>
      </Form>
      <TextContainer>
        <div>
          <span>
            Don’t have an account?{' '}
            <a href="https://stackoverflow.com/users/signup?ssrc=head" target="_blank" rel="noreferrer">
              Sign up
            </a>
          </span>
        </div>
        <div>
          <span>
            Are you an employer? <a href='https://talent.stackoverflow.com/users/login target="_blank" rel="noreferrer'>Sign up on Talent </a>
          </span>
        </div>
      </TextContainer>
    </Bg>
  );
}
