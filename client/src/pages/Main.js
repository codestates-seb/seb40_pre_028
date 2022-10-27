import styled from 'styled-components';
import { MainBar } from '../components/MainBar';

const TopContainer = styled.div`
  display: flex;
  justify-content: center;
  width: 100%;
`;

const MainContainer = styled.div`
  display: flex;
  justify-content: center;
  width: 100%;
  height: 100%;
  max-width: 1264px;
`;

const NavLayout = styled.div`
  height: 100vh;
  flex: 0 0 170px;
  border: skyblue 1px solid;
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
  overflow-x: hidden;
  border: solid blue 1px;
`;

const Main = () => {
  return (
    <TopContainer>
      <MainContainer>
        <NavLayout></NavLayout>
        <SMain>
          <MainBar></MainBar>
          <Sidebar>side bar</Sidebar>
        </SMain>
      </MainContainer>
    </TopContainer>
  );
};

export default Main;
