import { useState } from 'react';
import styled from 'styled-components';
import { MdError } from 'react-icons/md';

const Form = styled.form`
  display: flex;
`;
const Fieldset = styled.fieldset`
  background-color: white;
  width: 340px;
  height: 280px;
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
  margin-bottom: 5px;
  display: block;
  &:hover {
    cursor: pointer;
  }
`;
const Input = styled.input`
  display: block;
  width: 100%;
  padding: 0.6rem 0.7rem;
  border: ${props => (props.error ? '1px solid #de4f55' : '1px solid rgba(0, 0, 0, 0.3)')};

  /* border: 1px solid red; */
  border-radius: 3px;

  &:focus {
    outline: ${props => (props.error ? '3px solid #FFD1D3' : '3px solid #bfe4ff')};
    border-color: ${props => (props.error ? '#de4f55' : '#8fcaf2')};
  }
`;
const ErrorMSG = styled.p`
  margin: 7px 0;
  font-size: 13px;
  color: #de4f55;
  position: relative;
`;
const ErrorIcon = styled(MdError)`
  font-size: 22px;
  color: #de4f55;
  position: absolute;
  right: 10px;
  top: -36px;
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
    margin-bottom: 12px;
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

// function
const emailValidation = str => {
  return /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i.test(str);
  // 숫자 (0~9) or 알파벳 (a~z, A~Z) 으로 시작하며 중간에 -_. 문자가 있을 수 있으며 그 후 숫자 (0~9) or 알파벳 (a~z, A~Z)이 올 수도 있고 연달아 올 수도 있고 없을 수도 있다. @는 반드시 존재하며 . 도 반드시 존재하고 a~z, A~Z 의 문자가 2,3개 존재하고 i = 대소문자 구분 안한다.
};

export function LoginForm() {
  const [emailValue, setEmailValue] = useState('');
  const [passwordValue, setPasswordValue] = useState('');
  const [emailValid, setEmailValid] = useState(false);
  const [emailValid2, setEmailValid2] = useState(false);
  const [passwordValid, setPasswordValid] = useState(false);

  const [verifiSuccess, setVerifiSuccess] = useState(false); // 로그인 시도 후 아이디,비밀번호 정보의 일치 유무

  const formSubmitHandler = e => {
    e.preventDefault();

    // 인풋값 존재
    if (emailValue === '') setEmailValid(true);
    else setEmailValid(false);
    if (passwordValue === '') setPasswordValid(true);
    else setPasswordValid(false);

    // 형식 체크
    if (!emailValidation(emailValue)) setEmailValid2(true);
    else setEmailValid2(false);
  };

  const emailValueHandler = e => {
    setEmailValue(e.target.value);
  };
  const passwordValueHandler = e => {
    setPasswordValue(e.target.value);
  };
  return (
    <>
      <Form onSubmit={formSubmitHandler}>
        {verifiSuccess ? (
          <Fieldset>
            <Field>
              <Label htmlFor="email">Email</Label>
              <Input type="text" id="email" onChange={emailValueHandler} error={emailValid || emailValid2 || verifiSuccess} />
              {emailValid ? (
                <ErrorMSG>
                  Email cannot be empty.
                  <ErrorIcon />
                </ErrorMSG>
              ) : emailValid2 ? (
                <ErrorMSG>
                  The email is not a valid email address.
                  <ErrorIcon />
                </ErrorMSG>
              ) : (
                <ErrorMSG>
                  The email or password is incorrect.
                  <ErrorIcon />
                </ErrorMSG>
              )}
            </Field>
            <Field>
              <div>
                <Label htmlFor="password">Password</Label>
                <span>
                  <a href='https://stackoverflow.com/users/account-recovery target="_blank" rel="noreferrer'>Forgot password?</a>
                </span>
              </div>
              <Input type="text" id="password" onChange={passwordValueHandler} error={passwordValid} />
              {passwordValid ? (
                <ErrorMSG>
                  Password cannot be empty.
                  <ErrorIcon />
                </ErrorMSG>
              ) : (
                ''
              )}
            </Field>
            <Button>Log in</Button>
          </Fieldset>
        ) : (
          <Fieldset>
            <Field>
              <Label htmlFor="email">Email</Label>
              <Input type="text" id="email" onChange={emailValueHandler} error={emailValid || emailValid2} />
              {emailValid ? (
                <ErrorMSG>
                  Email cannot be empty.
                  <ErrorIcon />
                </ErrorMSG>
              ) : emailValid2 ? (
                <ErrorMSG>
                  The email is not a valid email address.
                  <ErrorIcon />
                </ErrorMSG>
              ) : (
                ''
              )}
            </Field>
            <Field>
              <div>
                <Label htmlFor="password">Password</Label>
                <span>
                  <a href='https://stackoverflow.com/users/account-recovery target="_blank" rel="noreferrer'>Forgot password?</a>
                </span>
              </div>
              <Input type="text" id="password" onChange={passwordValueHandler} error={passwordValid} />
              {passwordValid ? (
                <ErrorMSG>
                  Password cannot be empty.
                  <ErrorIcon />
                </ErrorMSG>
              ) : (
                ''
              )}
            </Field>
            <Button>Log in</Button>
          </Fieldset>
        )}
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
    </>
  );
}

export { Form, Fieldset, Field, Label, Input, ErrorMSG, ErrorIcon, Button, TextContainer, emailValidation };