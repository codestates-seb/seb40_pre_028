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
  const [question, setQuestion] = useState({});
  const [answerBody, setAnswerBody] = useState('');
  const [isLoading, setIsLoading] = useState(false); // true로 나중에 변경
  const { id } = useParams();
  const URL = `https://4ab3-14-39-204-244.jp.ngrok.io/user/`;


  const getData = async () => {
    const res = await fetch(URL + `question/${id}`);
    const data = await res.json();
    setQuestion(data.data);
    setIsLoading(false);
  };


  useEffect(() => {
    getData();
  }, []);

  const postData = async (userId = 3) => {
    // console.log('q: ', questionId);
    try {
      await fetch(URL + `answer/${id}/post`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          // questionId,
          userId,
          answerBody,
        }),
      }).then(() => getData());
    } catch (error) {
      console.error(error);
    }
  };

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
              <DetailAnswer answers={question.answers} onchange={setAnswerBody} postData={postData} />
            </div>
            <Aside />
          </Section>
        </Main>
      )}
    </div>
  );
}
