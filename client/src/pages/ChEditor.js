import styled from 'styled-components';
import { CKEditor } from '@ckeditor/ckeditor5-react';

import Editor from 'ckeditor5-custom-build/build/ckeditor';

const ChContainer = styled.div`
  width: 600px;
  height: 140px;
`;

export default function ChEditor({ onfocus }) {
  return (
    <ChContainer className="App">
      <CKEditor
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
          console.log('Editor is ready to use!', editor);
        }}
        onChange={(event, editor) => {
          const data = editor.getData();
          console.log({ event, editor, data });
        }}
        onFocus={(event, editor) => {
          onfocus();
        }}
      />
    </ChContainer>
  );
}
