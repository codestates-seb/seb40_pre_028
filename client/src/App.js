import GlobalStyle from './assets/style/GlobalStyle';
import Router from './Router';
import { Provider } from 'react-redux';
import { createSlice, configureStore } from '@reduxjs/toolkit';
import questionSlice from './redux/slice/questionSlice';

// redux
export const authSlice = createSlice({
  name: 'authSlice',
  initialState: { isLogin: false },
  reducers: {
    login: (state, action) => {
      console.log('log-in!');
      state.isLogin = true;
      return state;
    },
    logout: (state, action) => {
      console.log('log-out!');
      state.isLogin = false;
      return state;
    },
  },
});
export const userSlice = createSlice({
  name: 'userSlice',
  initialState: { user: null },
  reducers: {
    // setName: (state, action) => {
    //   state.name = action.payload;
    // },
    // setId: (state, action) => {
    //   state.id = action.payload;
    // },
    setUser: (state, action) => {
      state.user = action.payload;
    },
  },
});

const store = configureStore({
  reducer: {
    auth: authSlice.reducer,
    user: userSlice.reducer,
    question: questionSlice.reducer,
  },
});

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
