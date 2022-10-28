import styled from 'styled-components';
import { AlertMsg } from '../components/CreateQuestion/AlertMsg';
import { useState, useRef, useEffect } from 'react';
const Bg = styled.div`
  background-color: #f1f2f3;
  /* padding: 20px 0; */
  height: 100vh;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
`;

//component
const Form = styled.form`
  display: flex;
  flex-direction: column;
`;
const FieldSet = styled.div`
  display: flex;
`;
const Field = styled.div`
  background-color: white;
  width: 700px;
  height: 150px;
  padding: 20px 30px;
  border: 0.5px solid var(--black-200);
  border-radius: 2px;

  margin-bottom: 20px;
`;
const Label1 = styled.label`
  font-family: 'Noto Sans KR';
  font-weight: 600;
  font-size: 18px;
  margin-bottom: 8px;
  display: inline-block;
  &:hover {
    cursor: pointer;
  }
`;
const Label2 = styled.label`
  font-family: 'Noto Sans KR';
  color: var(--black-600);
  margin-bottom: 8px;
  display: block;
  font-size: 14px;
  font-weight: 100px;
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
  ::placeholder {
    color: var(--black-200);
  }
`;

const AlertMsgTitle = styled.div`
  margin-left: 20px;
`;

export default function CreateQuestionPage() {
  const [isAlertMsg1, setIsAlertMsg1] = useState(false);
  const [isAlertMsg2, setIsAlertMsg2] = useState(false);
  const [isAlertMsg3, setIsAlertMsg3] = useState(false);

  const inputEl = useRef(null);

  const AlertMsgHandlerOn1 = () => {
    setIsAlertMsg1(true);
  };
  const AlertMsgHandlerOn2 = () => {
    setIsAlertMsg2(true);
  };
  const AlertMsgHandlerOn3 = () => {
    setIsAlertMsg3(true);
  };
  const AlertMsgHandlerOff = () => {
    setIsAlertMsg1(false);
    setIsAlertMsg2(false);
    setIsAlertMsg3(false);
  };

  useEffect(() => {
    inputEl.current.focus();
  }, []);
  return (
    <Bg>
      <Form>
        <FieldSet>
          <Field>
            <Label1 htmlFor="title">Title</Label1>
            <Label2 htmlFor="title">Be specific and imagine you’re asking a question to another person.</Label2>
            <Input
              ref={inputEl}
              type="text"
              id="title"
              onFocus={AlertMsgHandlerOn1}
              onBlur={AlertMsgHandlerOff}
              placeholder="e.g. Is there an R function for finding the index of an element in a vector?"
            ></Input>
          </Field>

          {isAlertMsg1 ? (
            <AlertMsgTitle>
              <AlertMsg
                title={'Writing a good title'}
                content1={'Your title should summarize the problem.'}
                content2={'You might find that you have a better idea of your title after writing out the rest of the question.'}
              />
            </AlertMsgTitle>
          ) : (
            ''
          )}
        </FieldSet>

        <FieldSet>
          <Field>
            <Label1 htmlFor="body">Body</Label1>
            <Label2 htmlFor="body">The body of your question contains your problem details and results. Minimum 30 characters.</Label2>
          </Field>
          {isAlertMsg2 ? (
            <AlertMsgTitle>
              <AlertMsg
                title={'Proof-read before posting'}
                content1={'Now that you’re ready to post your question, read through it from start to finish. Does it make sense?'}
                content2={
                  'Add any details you missed and read through it again. Now is a good time to make sure that your title still describes the problem!'
                }
              />
            </AlertMsgTitle>
          ) : (
            ''
          )}
        </FieldSet>
        <FieldSet>
          <Field>
            <Label1 htmlFor="tags">Tags</Label1>
            <Label2 htmlFor="tags">Add up to 5 tags to describe what your question is about. Start typing to see suggestions.</Label2>
            <Input type="text" id="tags" onFocus={AlertMsgHandlerOn3} onBlur={AlertMsgHandlerOff} placeholder="e.g. (excel string regex)"></Input>
          </Field>
          {isAlertMsg3 ? (
            <AlertMsgTitle>
              <AlertMsg
                title={'Adding tags'}
                content1={'Tags help ensure that your question will get attention from the right people.'}
                content2={
                  'Tag things in more than one way so people can find them more easily. Add tags for product lines, projects, teams, and the specific technologies or languages used.'
                }
              />
            </AlertMsgTitle>
          ) : (
            ''
          )}
        </FieldSet>
      </Form>
    </Bg>
  );
}
