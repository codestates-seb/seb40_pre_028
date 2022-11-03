import { createAsyncThunk } from '@reduxjs/toolkit';

export const getQuestionList = createAsyncThunk('question/getQuestionList', async (_, thunkAPI) => {
  try {
    const { page, size } = thunkAPI.getState().question;
    const response = await fetch(`http://localhost:3001/question?page=${page}&size=${size}`);
    const data = await response.json();
    return data;
  } catch (error) {
    return thunkAPI.rejectWithValue(error.message);
  }
});
