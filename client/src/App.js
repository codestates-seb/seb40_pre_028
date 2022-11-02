import GlobalStyle from './assets/style/GlobalStyle';
import Router from './Router';
import { Provider } from 'react-redux';
import { createSlice, configureStore } from '@reduxjs/toolkit';

// redux
export const authSlice = createSlice({
  name: 'authSlice',
  initialState: { isLogin: false },
  reducers: {
    login: (state, action) => {
      state.isLogin = true;
    },
    logout: (state, action) => {
      state.isLogin = false;
    },
  },
});
export const userSlice = createSlice({
  name: 'userSlice',
  initialState: { name: null, id: null },
  reducers: {
    setName: (state, action) => {
      state.name = action.payload;
    },
    setId: (state, action) => {
      state.id = action.payload;
    },
  },
});
export const store = configureStore({
  reducer: {
    auth: authSlice.reducer,
    user: userSlice.reducer,
  },
});

// dispatch
// 1. login & signup -> header
// 2. logout -> header, UserToolbar
// selector
// 1. createQuestion
// 2. createAnswer
// 리덕스 잘되면 localstorage 지우기 (QuestionList, )

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
