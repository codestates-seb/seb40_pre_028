import styled from 'styled-components';
import { DetailHeader } from '../components/QuestionDetails/DetailHeader';
import { DetailMain } from '../components/QuestionDetails/DetailMain';
import { DetailAnswer } from '../components/QuestionDetails/DetailAnswer';
import { Aside } from '../components/Aside';

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
    </div>
  );
}
