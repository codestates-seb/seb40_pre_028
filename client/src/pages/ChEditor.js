import styled from 'styled-components';
import { CKEditor } from '@ckeditor/ckeditor5-react';

/*
import ClassicEditor from '@ckeditor/ckeditor5-build-classic';
// import ClassicEditor from '@ckeditor/ckeditor5-editor-classic/src/classiceditor';
import BlockQuote from '@ckeditor/ckeditor5-block-quote/src/blockquote.js';
import Bold from '@ckeditor/ckeditor5-basic-styles/src/bold.js';
import Code from '@ckeditor/ckeditor5-basic-styles/src/code.js';
// import CodeBlock from '@ckeditor/ckeditor5-code-block/src/codeblock.js';
import Essentials from '@ckeditor/ckeditor5-essentials/src/essentials.js';
import Heading from '@ckeditor/ckeditor5-heading/src/heading.js';
// import HorizontalLine from '@ckeditor/ckeditor5-horizontal-line/src/horizontalline.js';
// import Image from '@ckeditor/ckeditor5-image/src/image.js';
// import ImageUpload from '@ckeditor/ckeditor5-image/src/imageupload.js';
import Italic from '@ckeditor/ckeditor5-basic-styles/src/italic.js';
import Link from '@ckeditor/ckeditor5-link/src/link.js';
import List from '@ckeditor/ckeditor5-list/src/list.js';
import Paragraph from '@ckeditor/ckeditor5-paragraph/src/paragraph.js';
import Table from '@ckeditor/ckeditor5-table/src/table.js';
*/
import Editor from 'ckeditor5-custom-build/build/ckeditor';

const ChContainer = styled.div`
  width: 600px;
  height: 140px;
`;

// const editorConfiguration = {
//   plugins: [Heading, Bold, Italic, Code, Link, BlockQuote, CodeBlock, Table, HorizontalLine, List, Image],
//   toolbar: ['heading', '|', 'bold', 'italic', 'code', '|', 'link', 'blockQuote', 'codeBlock', 'table', '|', 'horizontalLine', 'list', 'image'],
// };
// const editorConfiguration = {
//   plugins: [Heading, Bold, Italic, Code, Link, BlockQuote, Essentials, Table, Paragraph, List, Image],
//   toolbar: ['heading', '|', 'bold', 'italic', 'code', '|', 'link', 'blockQuote', 'codeBlock', 'table', '|', 'horizontalLine', 'list', 'image'],
// };

// 'bulletedList', 'numberedList', 'blockQuote'],
export default function ChEditor({ onfocus }) {
  return (
    <ChContainer className="App">
      {''}
      <h1>test</h1>
      <CKEditor
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
          // You can store the "editor" and use when it is needed.
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
          onfocus();
        }}
      />
    </ChContainer>
  );
}
