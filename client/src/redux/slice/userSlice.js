import { createSlice } from '@reduxjs/toolkit';

const userSlice = createSlice({
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

export { userSlice };
