import styled from 'styled-components';
import { Aside } from '../components/Aside';
import { MainBar } from '../components/MainBar';
import { Nav } from '../components/Nav';

export const TopContainer = styled.div`
  display: flex;
  justify-content: center;
  width: 100%;
  height: 100%;
`;

export const MainContainer = styled.div`
  display: flex;
  justify-content: center;
  width: 100%;
  height: 100%;
  max-width: 1264px;
`;

export const SMain = styled.main`
  position: relative;
  flex: 0 1 100%;
  display: flex;
  justify-content: center;
  margin-top: 50px;
  padding: 24px 24px 24px 0px;
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
        <Nav />
        <SMain>
          <MainBar />
          <Aside>side bar</Aside>
        </SMain>
      </MainContainer>
    </TopContainer>
  );
};

export default Main;
