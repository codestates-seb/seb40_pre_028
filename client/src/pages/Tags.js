import styled from 'styled-components';

function Tags() {
  return (
    <TagLayout>
      <h1>Tags</h1>
      <p>
        A tag is a keyword or label that categorizes your question with other, similar questions. Using the right tags makes it easier for others to
        find and answer your question.
      </p>
    </TagLayout>
  );
}
const TagLayout = styled.div`
  display: flex;
  font-size: 22px;
  flex-direction: column;
  margin-top: 200px;
  h1 {
    width: 100%;
    height: 50px;
    border: 1px solid blue;
    display: flex;
  }
  p {
    font-size: 14px;
  }
`;
export default Tags;
