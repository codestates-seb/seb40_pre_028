import { DetailHeader } from '../components/QuestionDetails/DetailHeader';
import { DetailMain } from '../components/QuestionDetails/DetailMain';
import { DetailAnswer } from '../components/QuestionDetails/DetailAnswer';

export default function QuestionDetail() {
  return (
    <div>
      {/* nav */}
      <section>
        <div>
          <DetailHeader />
          <div>
            <DetailMain />
            <DetailAnswer />
            {/* aside */}
          </div>
        </div>
      </section>
    </div>
  );
}
