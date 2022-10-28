import styled from 'styled-components';

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

const Field = styled.div`
  background-color: white;
  width: 800px;
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
  display: block;
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

export default function CreateQuestionPage() {
  return (
    <Bg>
      <Form>
        <Field>
          <Label1 htmlFor="title">Title</Label1>
          <Label2 htmlFor="title">Be specific and imagine you’re asking a question to another person.</Label2>
          <Input type="text" id="title" placeholder="e.g. Is there an R function for finding the index of an element in a vector?"></Input>
        </Field>
        <Field>
          <Label1 htmlFor="body">Body</Label1>
          <Label2 htmlFor="body">The body of your question contains your problem details and results. Minimum 30 characters.</Label2>
        </Field>
        <Field>
          <Label1 htmlFor="tags">Tags</Label1>
          <Label2 htmlFor="tags">Add up to 5 tags to describe what your question is about. Start typing to see suggestions.</Label2>
          <Input type="text" id="tags" placeholder="e.g. (excel string regex)"></Input>
        </Field>
      </Form>
    </Bg>
  );
}
