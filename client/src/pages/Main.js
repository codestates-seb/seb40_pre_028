import styled from 'styled-components';
import { MainBar } from '../components/MainBar';

const MainContainer = styled.div`
  display: flex;
  justify-content: center;
  width: 100%;
  height: 100%;
`;

const NavLayout = styled.div`
  height: 100vh;
  flex: 0 0 170px;
`;

export const SMain = styled.main`
  position: relative;
  flex: 0 1 100%;
  display: flex;
  justify-content: center;
  padding: 74px 24px 24px 24px;
  border: solid red 1px;
`;

export const Sidebar = styled.div`
  position: relative;
  width: 300px;
  min-height: calc(100vh - 420px);
  max-width: 1300px;
  overflow-x: hidden;
  border: solid blue 1px;
`;

const Main = () => {
  return (
    <MainContainer>
      <NavLayout></NavLayout>
      <SMain>
        <MainBar></MainBar>
        <Sidebar>side bar</Sidebar>
      </SMain>
    </MainContainer>
  );
};

export default Main;