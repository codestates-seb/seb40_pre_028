import styled from 'styled-components';
import { DetailHeader } from '../components/QuestionDetails/DetailHeader';
import { DetailMain } from '../components/QuestionDetails/DetailMain';
import { DetailAnswer } from '../components/QuestionDetails/DetailAnswer';
import { Nav } from '../components//Nav';
import { Aside } from '../components//Aside';
import Footer from '../components/Footer';

export const TopContainer = styled.div`
  display: flex;
  justify-content: center;
  height: 100%;
  Aside {
    margin-top: 20px;
  }
`;

const MainContainer = styled.div`
  display: flex;
  justify-content: center;
`;

const Section = styled.div`
  display: flex;
`;

const Main = styled.div`
  display: flex;
  flex-direction: column;
  padding: 20px;
  border-left: 1px solid #d6d9dc;
`;

export default function QuestionDetail() {
  return (
    <div>
      <TopContainer>
        <MainContainer>
          <Nav />
          <Main>
            <DetailHeader />
            <Section>
              <div>
                <DetailMain />
                <DetailAnswer />
              </div>
              <Aside />
            </Section>
          </Main>
        </MainContainer>
      </TopContainer>
      <Footer />
    </div>
  );
}
