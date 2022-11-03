import { createSlice } from '@reduxjs/toolkit';

const authSlice = createSlice({
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

export { authSlice };
