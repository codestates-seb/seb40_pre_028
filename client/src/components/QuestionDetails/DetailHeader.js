import { DetailHeaderElement } from './DetailHeaderElement';

export const DetailHeader = ({ title = 'title', createdAt, modified, views = 123 }) => {
  return (
    <>
      {/* 더미데이터 */}
      {/* <DetailHeaderElement
        title={'Hi, how I can make a dashboard with JS but I can add'}
        createdAt={'2022-01-01 00:00:00'}
        modified={'2022-01-01 00:00:00'}
        views={123}
      /> */}

      <DetailHeaderElement title={title} createdAt={createdAt} modified={modified} views={views} />
    </>
  );
};
