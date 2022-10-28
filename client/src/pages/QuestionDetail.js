import { DetailHeader } from '../components/QuestionDetails/DetailHeader';
import { DetailMain } from '../components/QuestionDetails/DetailMain';
import { DetailAnswer } from '../components/QuestionDetails/DetailAnswer';

function QuestionDetail() {
  return (
    <div>
      {/* header */}
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

export default QuestionDetail;
