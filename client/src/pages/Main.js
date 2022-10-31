import styled from 'styled-components';
import { Aside } from '../components/Aside';
import { MainBar } from '../components/MainBar';
import { Nav } from '../components/Nav';
import Footer from '../components/Footer';
import Header from '../components/Header';

export const BodyContainter = styled.div`
  display: flex;
  flex-direction: column;
  width: 100%;
  height: 100%;
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
  border-left: 1px solid var(--black-100);
  @media (max-width: 1100px) {
    padding: 24px 0 24px 0px;
  }
`;

const Main = () => {
  return (
    <BodyContainter>
      <Header />
      <MiddleContainer>
        <MainContainer>
          <Nav />
          <SMain>
            <MainBar />
            <Aside />
          </SMain>
        </MainContainer>
      </MiddleContainer>
      <Footer />
    </BodyContainter>
  );
};

export default Main;
