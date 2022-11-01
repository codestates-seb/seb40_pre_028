import styled from 'styled-components';
import { Aside } from '../components/Aside';
import { Nav } from '../components/Nav';
import Footer from '../components/Footer';
import { Outlet } from 'react-router-dom';

export const MiddleContainer = styled.div`
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

export const SMain = styled.main`
  position: relative;
  flex: 0 1 100%;
  display: flex;
  justify-content: center;
  padding: 24px 24px 24px 0px;
  @media (max-width: 1100px) {
    padding: 24px 0 24px 0px;
  }
`;

const SharedLayout2 = () => {
  return (
    <>
      <MiddleContainer>
        <MainContainer>
          <Nav />
          <SMain>
            <Outlet />
            <Aside />
          </SMain>
        </MainContainer>
      </MiddleContainer>
      <Footer />
    </>
  );
};

export default SharedLayout2;
