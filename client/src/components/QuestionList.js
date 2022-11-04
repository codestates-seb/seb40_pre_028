import { useEffect } from 'react';
import styled from 'styled-components';
import { BlueButton } from './DefaultButton';
import { QuestionElement } from './QuestionElement/QuestionElement';
import { SortButton } from './SortButton';
import { Pagenation } from '../utils/Pagenation';
import { Link } from 'react-router-dom';
import { authSlice } from '../redux/slice/authSlice';
import { userSlice } from '../redux/slice/userSlice';
import { useDispatch, useSelector } from 'react-redux';
import { getQuestionList, changeQPage, changeQSize } from '../redux/slice/questionSlice';

export const MainCointainer = styled.div`
  position: relative;
  display: flex;
  flex-flow: column nowrap;
  width: calc(100% - 300px);
  min-height: calc(100vh - 420px);
  overflow-x: hidden;
  padding: 0 24px;
  margin-left: -2px;

  @media (max-width: 1100px) {
    width: 100%;
    padding: 0 0 0 24px;
    // 첫번째와 두번째 자식요소 동시에 선택해서 오른쪽 패딩을 24px로 설정
    > *:first-child,
    > *:nth-child(2) {
      padding-right: 24px;
    }
  }
`;

const HeaderContainer = styled.div`
  display: flex;
  justify-content: space-between;
  height: 50px;
  margin-bottom: 12px;

  > h1 {
    font-size: 1.7rem;
  }
`;

const InfoContainer = styled.div`
  display: flex;
  justify-content: space-between;
  margin-bottom: 12px;

  > div {
    display: flex;
    align-items: center;
    justify-content: center;
    min-width: 100px;
  }
`;

export const MainUList = styled.ul`
  display: flex;
  flex-flow: column nowrap;

  @media (max-width: 1100px) {
    justify-content: flex-start;
  }
  margin-left: -24px;
  border-bottom: 1px solid var(--black-100);
`;

export function QuestionList() {
  const dispatch = useDispatch();
  const { questions, page, size, totalElements, isLoading } = useSelector(store => store.question);

  useEffect(() => {
    dispatch(getQuestionList());
  }, [dispatch]);

  const setPage = page => {
    dispatch(changeQPage(page));
  };

  const setSize = size => {
    dispatch(changeQSize(size));
  };

  // 새로고침시 로컬스토리지에 사용자 정보를 확인함
  // 사용자가 사이트를 떠나면 사용자 정보를 삭제함
  useEffect(() => {
    const user = window.localStorage.getItem('user');
    const auth = window.localStorage.getItem('auth');
    user && dispatch(userSlice.actions.setUser(JSON.parse(user)));
    auth && dispatch(authSlice.actions.login());

    window.addEventListener('beforeunload', () => {
      window.localStorage.removeItem('auth');
      window.localStorage.removeItem('user');
    });
  }, []);

  return (
    <MainCointainer>
      <HeaderContainer>
        <h1>All Questions</h1>
        <Link to="/ask">
          <BlueButton height="40px">Ask Question</BlueButton>
        </Link>
      </HeaderContainer>
      <InfoContainer>
        <div>{totalElements} questions</div>
        <SortButton nameList={['Newest', 'Votes']} />
      </InfoContainer>
      <MainUList>
        {/* 더미데이터 */}
        <QuestionElement
          id={1}
          title={'Hi, how I can make a dashboard with JS but I can add graphs according to what is loaded in the excel file or csv file'}
          body={
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
          }
          tag={['JavaScript', 'Java', 'HTML']}
          name={'일곱ㅎ쟁이'}
          createdAt={'2022-01-01 00:00:00'}
          votes={1}
          answers={2}
          views={3}
        />
        {isLoading ? (
          <div>Loading...</div>
        ) : (
          questions.map(question => (
            <QuestionElement
              key={question.questionId}
              id={question.questionId}
              title={question.questionTitle}
              body={question.questionBody}
              tag={question.tag}
              name={question.name}
              createdAt={question.questionCreatedAt}
              votes={question.votes}
              answers={question.answers}
              views={question.views}
            />
          ))
        )}
      </MainUList>
      <Pagenation total={totalElements} page={page} size={size} setPage={setPage} setSize={setSize} />
    </MainCointainer>
  );
}
