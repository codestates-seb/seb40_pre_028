import { DetailMainElement } from './DetailMainElement';
import { useState, useEffect } from 'react';

export const DetailMain = () => {
  let [question, setQuestions] = useState([]);
  // let URL = 'http://localhost:3001/user/question/{question_id}';

  const getData = async () => {
    const res = await fetch(URL, { headers: { 'ngrok-skip-browser-warning': 'skip' } });
    const data = await res.json();
    setQuestions(data.data);
  };

  useEffect(() => {
    getData();
  }, []);

  return (
    <>
      {/* 더미데이터 */}
      <DetailMainElement
        body={
          'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using Content here, content here, making it look like readable English.'
        }
        createdAt={'2022-01-01 00:00:00'}
        modified={'2022-01-01 00:00:00'}
        name={'helloUser'}
      />
      {question.map(question => (
        <DetailMainElement key={question.questionId} body={question.questionBody} createdAt={question.questionCreatedAt} name={question.name} />
      ))}
    </>
  );
};
