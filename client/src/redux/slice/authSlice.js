import { createSlice } from '@reduxjs/toolkit';

const authSlice = createSlice({
  name: 'authSlice',
  initialState: { isLogin: false },
  reducers: {
    login: (state, action) => {
      state.isLogin = true;
      return state;
    },
    logout: (state, action) => {
      state.isLogin = false;
      return state;
    },
  },
});

export { authSlice };
