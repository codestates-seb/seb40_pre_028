import { useState } from 'react';
import styled from 'styled-components';
import { FaQuestionCircle } from 'react-icons/fa';
import * as LoginForm from './LoginForm.js';
import { useDispatch } from 'react-redux';
import { useNavigate } from 'react-router-dom';
import { authSlice } from '../../redux/slice/authSlice.js';
import { fetchCreateSignup } from '../../utils/apis.js';

const Form = styled(LoginForm.Form)`
  display: flex;
  margin-bottom: 20px;
`;
const Fieldset = styled(LoginForm.Fieldset)`
  background-color: white;
  /* width: 280px; */
  width: 340px;
  height: 820px;
  padding: 30px 30px 0 30px;
  border-radius: 10px;
  border: none;
  margin: 20px;
  box-shadow: 0px 5px 20px rgba(0, 0, 0, 0.1);
`;
const Field = styled.div`
  margin-bottom: 20px;
  div {
    margin-top: 8px;
    span {
      font-size: 14px;
      color: rgba(0, 0, 0, 0.5);
      line-height: 0;
    }
  }
`;
//   display: block;
//   width: 100%;
//   padding: 0.6rem 0.7rem;
//   border: 1px solid rgba(0, 0, 0, 0.3);
//   border-radius: 3px;

//   &:focus {
//     outline: 3px solid #bfe4ff;
//     border-color: #7cc2f2;
//   }
// `;
const RobotCheck = styled.div`
  width: 100%;
  height: 26%;
  border-radius: 4px;
  background-color: rgba(0, 0, 0, 0.1);
  margin-bottom: 20px;
`;
const Checkbox = styled.div`
  display: flex;
  justify-content: space-between;
  margin-bottom: 20px;
  div {
    input {
      margin-right: 6px;
      &:hover {
        cursor: pointer;
      }
      &:checked {
        box-shadow: 0 0 6px #0091f4;
      }
    }
    label {
      font-size: 14px;
      &:hover {
        cursor: pointer;
      }
    }
  }
`;
const QuestionCircle = styled(FaQuestionCircle)`
  font-size: 14px;
  color: var(--black-400);

  &:hover {
    cursor: pointer;
  }
`;

const FieldsetFooter = styled.div`
  span {
    font-size: 14px;
    color: rgba(0, 0, 0, 0.5);
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
  }
`;
const TextContainer = styled.div`
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
export function SignupForm() {
  const [emailValue, setEmailValue] = useState('');
  const [passwordValue, setPasswordValue] = useState('');
  const [nameValue, setNameValue] = useState('');

  const [emailValid, setEmailValid] = useState(false);
  const [emailValid2, setEmailValid2] = useState(false);
  const [passwordValid, setPasswordValid] = useState(false);

  // const [userData, setUserData] = useState({});
  const [verifiSuccess, setVerifiSuccess] = useState(false); // 로그인 시도 후 아이디,비밀번호 정보의 일치 유무

  //  redux state
  const dispatch = useDispatch();

  // router
  const navigate = useNavigate();

  const formSubmitHandler = e => {
    e.preventDefault();

    // 인풋값 존재
    if (emailValue === '') setEmailValid(true);
    else setEmailValid(false);
    if (passwordValue === '') setPasswordValid(true);
    else setPasswordValid(false);

    // 형식 체크
    if (!LoginForm.emailValidation(emailValue)) setEmailValid2(true);
    else setEmailValid2(false);

    if (emailValue === '' || passwordValue === '' || !LoginForm.emailValidation(emailValue)) return;

    const payload = JSON.stringify({
      name: nameValue,
      email: emailValue,
      password: passwordValue,
    });

    fetchCreateSignup('/user/join', payload).then(data => {
      //  db에 동일한 이메일이 있으면 알림창
      if (data.status >= 500) {
        alert('이미 존재하는 이메일 입니다😞');
        return;
      }

      dispatch(authSlice.actions.login());
      window.localStorage.setItem('user', JSON.stringify(data));
      window.localStorage.setItem('auth', true);
      navigate('/');
    });
  };

  const emailValueHandler = e => {
    setEmailValue(e.target.value);
  };
  const passwordValueHandler = e => {
    setPasswordValue(e.target.value);
  };
  const nameValueHandler = e => {
    setNameValue(e.target.value);
  };
  return (
    <>
      <Form onSubmit={formSubmitHandler}>
        <Fieldset>
          <Field>
            <LoginForm.Label htmlFor="name">Display name</LoginForm.Label>
            <LoginForm.Input type="text" id="name" onChange={nameValueHandler} />
          </Field>

          <Field>
            <LoginForm.Label htmlFor="email">Email</LoginForm.Label>
            <LoginForm.Input type="text" id="email" onChange={emailValueHandler} error={emailValid || emailValid2 || verifiSuccess} />
            {emailValid ? (
              <LoginForm.ErrorMSG>
                Email cannot be empty.
                <LoginForm.ErrorIcon />
              </LoginForm.ErrorMSG>
            ) : emailValid2 ? (
              <LoginForm.ErrorMSG>
                The email is not a valid email address.
                <LoginForm.ErrorIcon />
              </LoginForm.ErrorMSG>
            ) : (
              ''
            )}
          </Field>

          <Field>
            <LoginForm.Label htmlFor="password">Password</LoginForm.Label>
            <LoginForm.Input type="password" id="password" onChange={passwordValueHandler} error={passwordValid} />
            {passwordValid ? (
              <LoginForm.ErrorMSG>
                Password cannot be empty.
                <LoginForm.ErrorIcon />
              </LoginForm.ErrorMSG>
            ) : (
              ''
            )}
            <div>
              <span>Passwords must contain at least eight characters, including at least 1 letter and 1 number.</span>
            </div>
          </Field>
          <RobotCheck></RobotCheck>
          <Checkbox>
            <div>
              <input type="checkbox" id="checkbox"></input>
            </div>
            <div>
              <label htmlFor="checkbox">
                Opt-in to receive occasional product updates, user research invitations, company announcements, and digests.
              </label>
            </div>
            <div>
              <QuestionCircle />
            </div>
          </Checkbox>
          <LoginForm.Button>Sign up</LoginForm.Button>

          <FieldsetFooter>
            <span>
              By clicking “Sign up”, you agree to our{' '}
              <a href="https://stackoverflow.com/legal/terms-of-service/public" target="_blank" rel="noreferrer">
                terms of service
              </a>
              ,{' '}
              <a href="https://stackoverflow.com/legal/terms-of-service/public" target="_blank" rel="noreferrer">
                privacy policy
              </a>{' '}
              and{' '}
              <a href="https://stackoverflow.com/legal/terms-of-service/public" target="_blank" rel="noreferrer">
                cookie policy
              </a>
            </span>
          </FieldsetFooter>
        </Fieldset>
      </Form>
      <TextContainer>
        <div>
          <span>
            Already have an account?{' '}
            <a href="https://stackoverflow.com/users/login?ssrc=head" target="_blank" rel="noreferrer">
              Log in
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
