import { configureStore } from '@reduxjs/toolkit';
import { authSlice } from '../slice/authSlice';
import { userSlice } from '../slice/userSlice';

const store = configureStore({
  reducer: {
    auth: authSlice.reducer,
    user: userSlice.reducer,
  },
});

export default store;
