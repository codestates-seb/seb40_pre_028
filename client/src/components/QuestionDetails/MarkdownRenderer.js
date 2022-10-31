import ReactMarkdown from 'react-markdown';
import styled from 'styled-components';
import remarkGfm from 'remark-gfm';
// import SyntaxHighlighter from 'react-syntax-highlighter';

const MarkDownStyle = styled.div`
  font-size: 1rem;
  line-height: 2.5rem;
`;

const markdown = `
Just a link: https://reactjs.com.

  * Lists
* [ ] todo
* [x] done

  \`\`\`
      코드 블럭
  \`\`\`

  *기울이기*

  글자 \`배경색\`

  > 인용문

  > A block quote with ~strikethrough~ and a URL: https://reactjs.org.
`;

export const MarkdownRenderer = () => {
  return (
    <MarkDownStyle>
      <ReactMarkdown remarkPlugins={remarkGfm}>{markdown}</ReactMarkdown>
    </MarkDownStyle>
  );
};
