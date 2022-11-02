import { DetailHeaderElement } from './DetailHeaderElement';
import { useState, useEffect } from 'react';

export const DetailHeader = () => {
  let [question, setQuestions] = useState([]);

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
      <DetailHeaderElement
        title={'Hi, how I can make a dashboard with JS but I can add'}
        createdAt={'2022-01-01 00:00:00'}
        modified={'2022-01-01 00:00:00'}
        views={123}
      />
      {question.map(question => (
        <DetailHeaderElement
          key={question.questionId}
          title={question.questionTitle}
          createdAt={question.questionCreatedAt}
          modified={question.questionModified}
          views={question.views}
        />
      ))}
    </>
  );
};
