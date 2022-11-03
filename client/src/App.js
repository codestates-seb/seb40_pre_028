import GlobalStyle from './assets/style/GlobalStyle';
import Router from './Router';
import { Provider } from 'react-redux';
import store from './redux/store/store';

// dispatch
// 1. login & signup -> header
// 2. logout -> header, UserToolbar
// selector
// 1. createQuestion
// 2. createAnswer
// 리덕스 잘되면 localstorage 지우기 (QuestionList, )
// -> 새로고침했을때 로그인 정보가 남아있도록 로컬스토리지는 유지해야할듯

function App() {
  return (
    <>
      <GlobalStyle />
      <Provider store={store}>
        <Router />
      </Provider>
    </>
  );
}

export default App;
