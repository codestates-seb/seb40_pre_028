import styled from 'styled-components';
import { CKEditor } from '@ckeditor/ckeditor5-react';
import Editor from 'ckeditor5-custom-build/build/ckeditor';
import { useRef } from 'react';

const ChContainer = styled.div`
  margin-bottom: 0.4rem;
`;

export default function ChEditor({ onfocus, setInputEl2, onchange }) {
  const edit = useRef(null);
  return (
    <ChContainer className="App">
      <CKEditor
        ref={edit}
        editor={Editor}
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
