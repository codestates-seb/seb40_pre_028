import { DetailHeader } from "../components/QuestionDetails/DetailHeader";
import { DetailMain } from "../components/QuestionDetails/DetailMain";

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
            {/* aside */}
          </div>
        </div>
      </section>
    </div>
  );
}

export default QuestionDetail;
