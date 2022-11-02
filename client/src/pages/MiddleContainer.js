import styled from 'styled-components';
import { Aside } from '../components/Aside';
import { Nav } from '../components/Nav';
import { Outlet } from 'react-router-dom';

export const SMiddleContainer = styled.div`
  display: flex;
  justify-content: center;
  flex: 1;
  width: 100%;
  height: 100%;
`;

export const MainContainer = styled.div`
  display: flex;
  width: 100%;
  height: 100%;
  max-width: 1264px;
`;

const MiddleContainer = () => {
  return (
    <SMiddleContainer>
      <MainContainer>
        <Nav />
        <Outlet />
      </MainContainer>
    </SMiddleContainer>
  );
};

export default MiddleContainer;
