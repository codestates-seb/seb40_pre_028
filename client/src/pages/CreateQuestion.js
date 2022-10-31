import styled from 'styled-components';
import { AlertMsg } from '../components/CreateQuestion/AlertMsg';
import { useState, useRef, useEffect } from 'react';
import ChEditor from './ChEditor';
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
  h1 {
    font-family: 'sans-serif';
    font-weight: 800;
    font-size: 24px;
    margin-bottom: 30px;
  }
`;

const FieldSet = styled.div`
  display: flex;
`;
const Field = styled.div`
  background-color: white;
  width: 700px;
  /* height: 180px; */
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
const Button = styled.button`
  padding: 0 12px;
  /* width: 50px;*/
  width: fit-content;
  height: 34px;
  color: white;
  background-color: #0996ff;
  border: none;
  border-radius: 3px;

  &:hover {
    cursor: pointer;
    background-color: #077cd2;
  }
`;
const Input = styled.input`
  display: block;
  width: 100%;
  margin-bottom: 0.4rem;
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

const Board = styled.div`
  width: 700px;
  height: 210px;
  padding: 24px;
  margin-bottom: 20px;

  border: 1px solid #a5cfed;
  background-color: #ecf4fb;

  font-family: 'Noto Sans KR';

  ul {
    list-style: disc;
  }
  div {
    margin-bottom: 9px;
    &:nth-child(1) {
      font-size: 20px;
    }
    &:nth-child(2) {
      font-size: 14px;
      font-weight: 400;
    }
  }
  ul {
    span {
      font-size: 13px;
      font-weight: 600;
    }
    li {
      margin-top: 4px;
      margin-left: 30px;
      font-size: 13px;
    }
  }
`;
const TagContainer = styled.div`
  display: flex;
`;
const Tag = styled.div`
  width: fit-content;
  color: #39739d;
  background-color: #e1ecf4;
  border-radius: 5px;
  padding: 5px 0 5px 7px;
  font-size: 12px;

  margin-right: 3px;
  button {
    box-sizing: content-box;
    width: 7px;
    margin-left: 3px;
    border: none;
    border-radius: 4px;
    color: #39739d;
    background-color: transparent;

    &:hover {
      cursor: pointer;
      color: #e1ecf4;
      background-color: #39739d;
    }
  }
`;
const Overlay = styled.div`
  /* position: absolute;
top: 0;
left: 0; */
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.6);
  backdrop-filter: blur(3px);
  z-index: 5;
`;
export default function CreateQuestionPage() {
  const [isAlertMsg1, setIsAlertMsg1] = useState(false);
  const [isAlertMsg2, setIsAlertMsg2] = useState(false);
  const [isAlertMsg3, setIsAlertMsg3] = useState(false);

  const [btn1, setBtn1] = useState(true);
  const [btn2, setBtn2] = useState(false);
  const [btn3, setBtn3] = useState(false);

  // input3: tag
  const [tagName, setTagName] = useState([]);

  const inputEl1 = useRef(null);
  // const inputEl2 = useRef(null);
  const inputEl3 = useRef(null);

  const AlertMsgHandlerOn1 = () => {
    setIsAlertMsg1(true);
    setIsAlertMsg2(false);
    setIsAlertMsg3(false);
  };
  const AlertMsgHandlerOn2 = () => {
    setIsAlertMsg1(false);
    setIsAlertMsg2(true);
    setIsAlertMsg3(false);
  };
  const AlertMsgHandlerOn3 = () => {
    setIsAlertMsg1(false);
    setIsAlertMsg3(false);
    setIsAlertMsg3(true);
  };
  const btnHandler1 = e => {
    e.preventDefault();
    inputEl3.current.focus();
    setBtn1(false);
    setBtn2(false);
    setBtn3(true);
  };
  const btnHandler2 = e => {
    e.preventDefault();
    setBtn1(false);
    setBtn2(false);
    setBtn3(true);
  };
  const btnHandler3 = e => {
    e.preventDefault();
    setBtn1(false);
    setBtn2(false);
    setBtn3(false);
  };
  const onsubmit = e => {
    e.preventDefault();
    console.log('form submiting');
  };

  //tag handler
  const tagNameHandlerByKeyup = e => {
    if (e.key !== ' ') return; // key가 스페이스바 일때만 아래 코드가 실행됨.
    if (e.target.value.trim() === '') return;
    if (tagName.includes(e.target.value.trim())) return;
    setTagName([...tagName, e.target.value.trim()]);
    e.target.value = '';
    return;
  };
  const tagNameHandlerByFocusout = e => {
    if (e.target.value.trim() === '') return;
    if (tagName.includes(e.target.value.trim())) return;
    setTagName([...tagName, e.target.value.trim()]);
    e.target.value = '';
    return;
  };
  const tagCloseBtn = (e, el) => {
    e.preventDefault();
    setTagName(tagName.filter(tag => tag !== el));
  };
  useEffect(() => {
    inputEl1.current.focus();
  }, []);

  return (
    <Bg>
      <Form>
        <h1>Ask a public question</h1>
        <Board>
          <div>
            <span>Writing a good question</span>
          </div>
          <div>
            <span>You’re ready to ask a programming-related question and this form will help guide you through the process.</span>
            <span>Looking to ask a non-programming question? See the topics here to find a relevant site.</span>
          </div>
          <ul>
            <span>Steps</span>
            <li>Summarize your problem in a one-line title.</li>
            <li>Describe your problem in more detail.</li>
            <li>Describe what you tried and what you expected to happen.</li>
            <li>Add “tags” which help surface your question to members of the community.</li>
            <li>Review your question and post it to the site.</li>
          </ul>
        </Board>

        <FieldSet>
          <Field>
            <Label1 htmlFor="title">Title</Label1>
            <Label2 htmlFor="title">Be specific and imagine you’re asking a question to another person.</Label2>
            <Input
              ref={inputEl1}
              type="text"
              id="title"
              onFocus={AlertMsgHandlerOn1}
              placeholder="e.g. Is there an R function for finding the index of an element in a vector?"
            ></Input>
            {btn1 ? <Button onClick={btnHandler1}>Next</Button> : ''}
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
            <ChEditor />
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
            <Input
              ref={inputEl3}
              type="text"
              id="tags"
              onFocus={AlertMsgHandlerOn3}
              onKeyUp={tagNameHandlerByKeyup}
              onBlur={tagNameHandlerByFocusout}
              placeholder="e.g. (excel string regex)"
            />

            <TagContainer>
              {tagName.map((el, idx) => (
                <Tag key={idx}>
                  <span>{el}</span>
                  <button onClick={e => tagCloseBtn(e, el)}>X</button>
                </Tag>
              ))}
            </TagContainer>
            {btn3 ? <Button onClick={btnHandler3}>Next</Button> : ''}
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
        <Button onClick={onsubmit}>Post your question</Button>
      </Form>
    </Bg>
  );
}
