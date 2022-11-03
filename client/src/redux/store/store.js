import { configureStore } from '@reduxjs/toolkit';
import { authSlice, userSlice } from '../../App';
import questionSlice from '../slice/questionSlice';

const store = configureStore({
  reducer: {
    auth: authSlice.reducer,
    user: userSlice.reducer,
    question: questionSlice.reducer,
  },
});

export default store;
