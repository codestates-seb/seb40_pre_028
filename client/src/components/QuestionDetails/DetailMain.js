import { DetailMainElement } from './DetailMainElement';

export const DetailMain = ({
  id,
  body = 'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using Content here, content here, making it look like readable English.',
  createdAt,
  name = 'UserName',
  tag = ['HTML', 'JavaScript', 'Java'],
  vote = '123',
}) => {
  return (
    <>
      {/* 더미데이터 */}
      {/* <DetailMainElement
        body={
          'It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using Content here, content here, making it look like readable English.'
        }
        createdAt={'2022-01-01 00:00:00'}
        modified={'2022-01-01 00:00:00'}
        name={'helloUser'}
        tag={['JavaScript', 'Java', 'HTML']}
      /> */}

      <DetailMainElement id={id} body={body} createdAt={createdAt} name={name} tag={tag} vote={vote} />
    </>
  );
};
