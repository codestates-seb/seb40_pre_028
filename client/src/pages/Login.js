import styled from 'styled-components';
import { LoginForm } from '../components/LoginForm';

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
  color: ${props => (props.bgColor ? 'white' : 'rgba(0,0,0,0.8)')};
  background-color: ${props =>
    props.bgColor
      ? props.bgColor === 'github'
        ? '#2F3337'
        : '#385499'
      : '#FFFFFF'};
  border: 0.5px solid rgba(0, 0, 0, 0.4);
  border-radius: 4px;
  margin: 5px 0;
  &:hover {
    cursor: pointer;
    background-color: ${props =>
      props.bgColor
        ? props.bgColor === 'github'
          ? '#131517'
          : '#254799'
        : '#F7F7F7'};
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
export default function LoginPage() {
  return (
    <>
      <LoginForm />
    </>
  );
}
