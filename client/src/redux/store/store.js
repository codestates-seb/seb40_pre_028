import { configureStore } from '@reduxjs/toolkit';
import { authSlice } from '../slice/authSlice';
import { userSlice } from '../slice/userSlice';
import questionSlice from '../slice/questionSlice';

const store = configureStore({
  reducer: {
    auth: authSlice.reducer,
    user: userSlice.reducer,
    question: questionSlice.reducer,
  },
});

export default store;
