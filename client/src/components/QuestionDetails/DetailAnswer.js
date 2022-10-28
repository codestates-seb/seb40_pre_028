import styled from 'styled-components';
import { CKEditor } from '@ckeditor/ckeditor5-react';
import ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import { DetailMain } from './DetailMain';

const Container = styled.div`
  h2 {
    font-size: 20px;
    border-top: 1px solid #d6d9dc;
    padding-top: 25px;
  }
  .qanswer {
    padding-left: 20px;
    font-size: 20px;
  }
  margin-top: 30px;
  .select {
    margin-left: 10px;
    padding: 5px;
  }
`;

const Answer = styled.div`
  * {
    margin: 20px 0;
  }
  .ck.ck-editor {
    max-width: 100%;
  }
  // 에디터 쓸 있는공간(네모박스)
  .ck-editor__editable {
    min-height: 300px;
  }
  .ck-content .marker-yellow {
    background-color: var(--ck-highlight-marker-yellow);
  }
  a {
    color: #0074cc;
  }
`;

const Btn = styled.button`
  all: unset;
  height: 20px;
  width: 130px;
  text-align: center;
  color: white;
  background-color: #0a96ff;
  cursor: pointer;
  padding: 0.8em;
  border-radius: 5px;
  &:hover {
    background: #0074cc;
  }
  margin-top: 10px;
`;

const AnswerCount = styled.div`
  display: flex;
  justify-content: space-between;
  padding-right: 30px;
`;

export const DetailAnswer = () => {
  return (
    <Container>
      <AnswerCount>
        <h3 className="qanswer">1 Answer</h3>
        <div>
          <span>sorted by:</span>
          <select name="" id="" className="select">
            <option value="scoredesc" selected="selected">
              Highest score (default)
            </option>
            <option value="modifieddesc"> Date modified (newest first) </option>
            <option value="createdasc"> Date created (oldest first) </option>
          </select>
        </div>
      </AnswerCount>
      <DetailMain />
      <Answer>
        {/* <p>
          Know someone who can answer? Share a link to this <a href="/question">question</a> via <a href="email">email</a>,{' '}
          <a href="/twitter">Twitter</a>, or <a href="/Facebook">Facebook</a>.
        </p> */}
        <h2>Your Answer</h2>
        <CKEditor
          editor={ClassicEditor}
          config={{
            placeholder: '내용을 입력하세요.',
          }}
          onReady={editor => {
            console.log('Editor is ready to use!', editor);
          }}
          onChange={(event, editor) => {
            const data = editor.getData();
            console.log({ event, editor, data });
          }}
          onBlur={(event, editor) => {
            console.log('Blur.', editor);
          }}
          onFocus={(event, editor) => {
            console.log('Focus.', editor);
          }}
        />
        <Btn>Post Your Answer</Btn>
      </Answer>
    </Container>
  );
};
