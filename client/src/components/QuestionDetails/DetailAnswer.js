import styled from 'styled-components';
import { CKEditor } from '@ckeditor/ckeditor5-react';
import ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import { DetailMain } from './DetailMain';

const Container = styled.div`
  h2 {
    font-size: 20px;
  }
  .qanswer {
    padding-left: 20px;
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

export const DetailAnswer = () => {
  return (
    <Container>
      <h2 className="qanswer">1 Answer</h2>
      <DetailMain />
      <Answer>
        <p>
          Know someone who can answer? Share a link to this <a href="/question">question</a> via <a href="email">email</a>,{' '}
          <a href="/twitter">Twitter</a>, or <a href="/Facebook">Facebook</a>.
        </p>
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
