import styled from 'styled-components';
import { Aside } from '../components/Aside';
import { Outlet } from 'react-router-dom';

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

const MainBox = () => {
  return (
    <SMain>
      <Outlet />
      <Aside />
    </SMain>
  );
};

export default MainBox;
