import styled from 'styled-components';
import Header from '../components/Header';
import Footer from '../components/Footer';
import { Outlet, useLocation } from 'react-router-dom';

export const SBodyContainter = styled.div`
  display: flex;
  flex-direction: column;
  width: 100%;
  height: 100%;
  min-height: 100vh;
`;

const footerHideURL = ['/login', '/signup'];

const BodyContainter = () => {
  const { pathname } = useLocation();
  const footerHide = footerHideURL.includes(pathname);
  return (
    <SBodyContainter>
      <Header />
      <Outlet />
      {footerHide || <Footer />}
    </SBodyContainter>
  );
};

export default BodyContainter;
