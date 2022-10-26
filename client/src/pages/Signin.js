import styled from "styled-components";
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
  height: 700px;
  padding: 30px 30px;
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
const RobotCheck = styled.div`
  width: 100%;
  height: 26%;
  border-radius: 4px;
  background-color: rgba(0, 0, 0, 0.1);
  margin-bottom: 20px;
`;
const Checkbox = styled.div`
  display: flex;
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
export default function SignIn() {
  return (
    <Bg>
      <BtnContainer>
        <BtnWith>Sign up with Google</BtnWith>
        <BtnWith bgColor="github">Sign up with Github</BtnWith>
        <BtnWith bgColor="facebook">Sign up with FaceBook</BtnWith>
      </BtnContainer>
      <Form>
        <Fieldset>
          <Field>
            <Label htmlFor="name">Display name</Label>
            <Input type="text" id="name" required />
          </Field>

          <Field>
            <Label htmlFor="email">Email</Label>
            <Input type="text" id="email" />
          </Field>

          <Field>
            <Label htmlFor="password">Password</Label>
            <Input type="text" id="password" />
            <div>
              <span>
                Passwords must contain at least eight characters, including at
                least 1 letter and 1 number.
              </span>
            </div>
          </Field>
          <RobotCheck></RobotCheck>
          <Checkbox>
            <div>
              <input type="checkbox" id="checkbox"></input>
            </div>
            <div>
              <label htmlFor="checkbox">
                Opt-in to receive occasional product updates, user research
                invitations, company announcements, and digests.
              </label>
            </div>
          </Checkbox>
          <Button>Sign up</Button>
          <FieldsetFooter>
            <span>
              By clicking “Sign up”, you agree to our{" "}
              <a
                href="https://stackoverflow.com/legal/terms-of-service/public"
                target="_blank"
                rel="noreferrer"
              >
                terms of service
              </a>
              ,{" "}
              <a
                href="https://stackoverflow.com/legal/terms-of-service/public"
                target="_blank"
                rel="noreferrer"
              >
                privacy policy
              </a>{" "}
              and{" "}
              <a
                href="https://stackoverflow.com/legal/terms-of-service/public"
                target="_blank"
                rel="noreferrer"
              >
                cookie policy
              </a>
            </span>
          </FieldsetFooter>
        </Fieldset>
      </Form>
      <TextContainer>
        <div>
          <span>
            Already have an account?{" "}
            <a
              href="https://stackoverflow.com/users/login?ssrc=head"
              target="_blank"
              rel="noreferrer"
            >
              Log in
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
