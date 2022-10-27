import styled from 'styled-components';

const LoadingContainer = styled.div`
  width: 300px;
  height: 500px;
  background-color: white;
  display: flex;
  justify-content: center;
  align-items: center;
`;
export function Loading() {
  return (
    <LoadingContainer>
      <h3>Loading...</h3>
    </LoadingContainer>
  );
}
