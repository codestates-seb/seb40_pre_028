import styled from 'styled-components';
import { Aside } from '../components/Aside';
import { Nav } from '../components/Nav';
import Footer from '../components/Footer';
import Header from '../components/Header';
import { Outlet, useLocation } from 'react-router-dom';

export const BodyContainter = styled.div`
  display: flex;
  flex-direction: column;
  width: 100%;
  height: 100%;
  min-height: 100vh;
`;

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

const asideHideURL = ['/ask', '/login', '/logout', '/signup', '/question'];
const footerHideURL = ['/login', '/logout', '/signup'];
const navHideURL = ['/login', '/logout', '/signup', '/ask'];

const SharedLayout = () => {
  const { pathname } = useLocation();
  const asideHide = asideHideURL.includes(pathname);
  const footerHide = footerHideURL.includes(pathname);
  const navHide = navHideURL.includes(pathname);
  console.log(asideHide);
  return (
    <BodyContainter>
      <Header />
      <MiddleContainer>
        <MainContainer>
          {navHide || <Nav />}
          <SMain>
            <Outlet />
            {asideHide || <Aside />}
          </SMain>
        </MainContainer>
      </MiddleContainer>
      {footerHide || <Footer />}
    </BodyContainter>
  );
};

export default SharedLayout;
