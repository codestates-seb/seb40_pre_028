import styled from "styled-components";

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
const BtnContainer = styled.div`
  display: flex;
  flex-direction: column;
`;
const BtnWith = styled.button`
  width: 340px;
  padding: 10px 0;
  color: ${(props) => (props.bgColor ? "white" : "rgba(0,0,0,0.8)")};
  background-color: ${(props) =>
    props.bgColor
      ? props.bgColor === "github"
        ? "#2F3337"
        : "#385499"
      : "#FFFFFF"};
  border: 0.5px solid rgba(0, 0, 0, 0.4);
  border-radius: 4px;
  margin: 5px 0;
  &:hover {
    cursor: pointer;
    background-color: ${(props) =>
      props.bgColor
        ? props.bgColor === "github"
          ? "#131517"
          : "#254799"
        : "#F7F7F7"};
  }
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
  width: 280px;
  height: 200px;
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
  width: 93%;
  padding: 0.6rem 0.7rem;
  border: 1px solid rgba(0, 0, 0, 0.3);
  border-radius: 3px;

  &:focus {
    outline: none;
    border-color: #8fcaf2;
    box-shadow: 0 0 6px #0091f4;
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
      <BtnContainer>
        <BtnWith>
          <svg
            aria-hidden="true"
            viewBox="0 0 18 18"
            width="18px"
            height="18px"
          >
            <path
              d="M16.51 8H8.98v3h4.3c-.18 1-.74 1.48-1.6 2.04v2.01h2.6a7.8 7.8 0 0 0 2.38-5.88c0-.57-.05-.66-.15-1.18Z"
              fill="#4285F4"
            />
            <path
              d="M8.98 17c2.16 0 3.97-.72 5.3-1.94l-2.6-2a4.8 4.8 0 0 1-7.18-2.54H1.83v2.07A8 8 0 0 0 8.98 17Z"
              fill="#34A853"
            />
            <path
              d="M4.5 10.52a4.8 4.8 0 0 1 0-3.04V5.41H1.83a8 8 0 0 0 0 7.18l2.67-2.07Z"
              fill="#FBBC05"
            />
            <path
              d="M8.98 4.18c1.17 0 2.23.4 3.06 1.2l2.3-2.3A8 8 0 0 0 1.83 5.4L4.5 7.49a4.77 4.77 0 0 1 4.48-3.3Z"
              fill="#EA4335"
            />
          </svg>
          <img
            src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/Google_%22G%22_Logo.svg/320px-Google_%22G%22_Logo.svg.png"
            alt="google-logo"
            width="10px"
          />
          Sign up with Google
        </BtnWith>
        <BtnWith bgColor="github">Sign up with Github</BtnWith>
        <BtnWith bgColor="facebook">Sign up with FaceBook</BtnWith>
      </BtnContainer>
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
                <a href='https://stackoverflow.com/users/account-recovery target="_blank" rel="noreferrer'>
                  Forgot password?
                </a>
              </span>
            </div>
            <Input type="text" id="password" />
          </Field>
          <Button>Log up</Button>
        </Fieldset>
      </Form>
      <TextContainer>
        <div>
          <span>
            Don’t have an account?{" "}
            <a
              href="https://stackoverflow.com/users/signup?ssrc=head"
              target="_blank"
              rel="noreferrer"
            >
              Sign up
            </a>
          </span>
        </div>
        <div>
          <span>
            Are you an employer?{" "}
            <a href='https://talent.stackoverflow.com/users/login target="_blank" rel="noreferrer'>
              Sign up on Talent{" "}
            </a>
          </span>
        </div>
      </TextContainer>
    </Bg>
  );
}
