import styled from 'styled-components';
import { CKEditor } from '@ckeditor/ckeditor5-react';
import ClassicEditor from '@ckeditor/ckeditor5-build-classic';

const Answer = styled.div`
  * {
    margin: 20px 0;
  }
  h2 {
    font-size: 20px;
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
`;

export const DetailAnswer = () => {
  return (
    <Answer>
      <p>Know someone who can answer? Share a link to this question via email, Twitter, or Facebook.</p>
      <h2>Your Answer</h2>
      <CKEditor
        editor={ClassicEditor}
        data="<p>Hello from CKEditor 5!</p>"
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
  );
};
