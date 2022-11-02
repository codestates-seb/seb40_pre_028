import styled from 'styled-components';
import { DetailHeader } from '../components/QuestionDetails/DetailHeader';
import { DetailMain } from '../components/QuestionDetails/DetailMain';
import { DetailAnswer } from '../components/QuestionDetails/DetailAnswer';
import { Aside } from '../components/Aside';
import { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';

const Section = styled.div`
  display: flex;
`;

const Main = styled.div`
  display: flex;
  flex-direction: column;
  padding: 20px;
  border-left: 1px solid #d6d9dc;
`;
// {
//     "data": {
//         "questionId": 1,
//         "questionTitle": "test123",
//         "questionBody": "hello!!!!!!!!!!!!!!!!!!!!!!!!!",
//         "questionCreatedAt": "2022-11-01T21:22:56.964261",
//         "questionModified": "2022-11-01T21:22:56.964261",
//         "answers": [{
//          "answerId": 0,
//          "answerBody": "helloo!!!!!!!!!!!!!!!",
//          "name": "555",
//          "questionId": 2,
//           "answerCreatedAt": "2022-11-01T16:04:32.804473",
//          "answerModified": "2022-11-01T16:04:32.804473",
//          "answerNum": 0
//          }],
//         "name": "028",
//         "answerNum": 0
//     }
// }

export default function QuestionDetail() {
  let [question, setQuestion] = useState({});
  let [isLoading, setIsLoading] = useState(true);
  let { id } = useParams();

  let URL = `https://4e1b-61-255-255-90.jp.ngrok.io/user/question/2`;

  const getData = async () => {
    const res = await fetch(URL);
    const data = await res.json();
    setQuestion(data.data);
    setIsLoading(false);
    console.log(question.answers);
  };

  useEffect(() => {
    getData();
  }, []);

  return (
    <div>
      {isLoading ? null : (
        <Main>
          <DetailHeader
            title={question.questionTitle}
            createdAt={question.questionCreatedAt}
            modified={question.questionModified}
            views={question.views}
          />
          <Section>
            <div>
              <DetailMain
                id={question.questionId}
                createdAt={question.questionCreatedAt}
                body={question.questionBody}
                name={question.name}
                tag={question.tag}
                vote={question.vote}
              />
              <DetailAnswer answers={question.answers} />
            </div>
            <Aside />
          </Section>
        </Main>
      )}
    </div>
  );
}
