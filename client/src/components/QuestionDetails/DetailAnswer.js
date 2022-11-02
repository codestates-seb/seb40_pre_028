import { DetailAnswerElement } from './DetailAnswerElement';

export const DetailAnswer = ({ answers }) => {
  return (
    <>
      {/* 더미데이터 */}
      {/* <DetailAnswerElement body={'안녕하세요'} createdAt={'2022-01-01 00:00:00'} modified={'2022-01-01 00:00:00'} name={'helloUser'} /> */}

      <DetailAnswerElement answers={answers} />
    </>
  );
};
