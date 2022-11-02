import styled from 'styled-components';
import { CKEditor } from '@ckeditor/ckeditor5-react';
import Editor from 'ckeditor5-custom-build/build/ckeditor';
import { useRef, useState } from 'react';

const ChContainer = styled.div`
  /* width: 600px; */
  /* height: 200px; */
  margin-bottom: 0.4rem;
`;
export default function ChEditor({ onfocus, setInputEl2, onchange }) {
  const edit = useRef(null);
  // console.log('editor: ', Editor.data);
  return (
    <ChContainer className="App">
      <CKEditor
        ref={edit}
        editor={Editor}
        // data="<p>Hello from CKEditor 5!</p>"
        config={{
          toolbar: [
            'heading',
            '|',
            'bold',
            'italic',
            'code',
            '|',
            'link',
            'blockQuote',
            'codeBlock',
            'imageUpload',
            'table',
            '|',
            'horizontalLine',
            'list',
          ],
        }}
        onReady={editor => {
          setInputEl2(editor);
        }}
        onChange={(event, editor) => {
          const data = editor.getData();
          // console.log({ event, editor, data });
          onchange(data.slice(3, -4));
        }}
        onFocus={() => {
          onfocus();
        }}
      />
    </ChContainer>
  );
}
