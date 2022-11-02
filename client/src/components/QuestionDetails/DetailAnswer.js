import { DetailAnswerElement } from './DetailAnswerElement';

export const DetailAnswer = ({
  answers = [
    {
      answerId: 0,
      answerBody: 'helloo!!!!!!!!!!!!!!!',
      name: '555',
      questionId: 2,
      answerCreatedAt: '2022-11-01T16:04:32.804473',
      answerModified: '2022-11-01T16:04:32.804473',
      answerNum: 0,
    },
  ],
}) => {
  return (
    <>
      <DetailAnswerElement answers={answers} />
    </>
  );
};
