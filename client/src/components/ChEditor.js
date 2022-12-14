import styled from 'styled-components';
import { CKEditor } from '@ckeditor/ckeditor5-react';
import Editor from 'ckeditor5-custom-build/build/ckeditor';
import { useRef, useEffect } from 'react';
import { VscEditorLayout } from 'react-icons/vsc';

const ChContainer = styled.div`
  margin-bottom: 0.4rem;

  .ck-editor__editable {
    min-height: 150px;
    font-size: 13px;
  }
`;

export default function ChEditor({ onfocus, setInputEl2, onchange }) {
  const edit = useRef(null);
  // useEffect(() => {
  //   edit.current.focus();
  // }, []);
  return (
    <ChContainer className="App">
      <CKEditor
        ref={edit}
        editor={Editor}
        config={{
          toolbar: ['heading', '|', 'bold', 'italic', 'code', '|', 'link', 'blockQuote', 'codeBlock', 'imageUpload', '|', 'horizontalLine'],
        }}
        onReady={editor => {
          setInputEl2?.(editor);
          // editorInit?.(edit);
        }}
        onChange={(event, editor) => {
          const data = editor.getData();
          // console.log({ event, editor, data });
          onchange?.(data.slice(3, -4));
        }}
        onFocus={() => {
          onfocus?.();
        }}
      />
    </ChContainer>
  );
}
