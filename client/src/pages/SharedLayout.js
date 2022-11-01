import styled from 'styled-components';
import Header from '../components/Header';
import { Outlet } from 'react-router-dom';

export const BodyContainter = styled.div`
  display: flex;
  flex-direction: column;
  width: 100%;
  height: 100%;
  min-height: 100vh;
`;

const SharedLayout = () => {
  return (
    <BodyContainter>
      <Header />
      <Outlet />
    </BodyContainter>
  );
};

export default SharedLayout;
