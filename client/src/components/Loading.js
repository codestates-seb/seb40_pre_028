import styled from 'styled-components';

const LoadingContainer = styled.div`
  width: 200px;
  height: 200px;
  background-color: white;
  display: flex;
  justify-content: center;
  align-items: center;
`;
export function Loading() {
  return (
    <LoadingContainer>
      <h3>Not Found</h3>
    </LoadingContainer>
  );
}
