import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import { fetchQuestionList } from '../../utils/apis';

const initialState = {
  questions: [],
  page: 1,
  size: 10,
  totalElements: 0,
  isLoading: false,
  errorMsg: '',
  // sortOption: 'newest',
};

// 리듀서 슬라이스
const questionSlice = createSlice({
  name: 'question',
  initialState,
  reducers: {
    changeQPage: (state, { payload }) => {
      state.page = payload;
    },
    changeQSize: (state, { payload }) => {
      state.size = payload;
    },
  },
  extraReducers: builder =>
    builder
      .addCase(getQuestionList.pending, state => {
        state.isLoading = true;
      })
      .addCase(getQuestionList.fulfilled, (state, { payload }) => {
        const { data, pageInfo } = payload;
        const { totalElements } = pageInfo;

        state.isLoading = false;
        state.questions = data;
        state.totalElements = totalElements;
      })
      .addCase(getQuestionList.rejected, (state, { payload }) => {
        state.isLoading = false;
        if (payload) {
          state.errorMsg = payload;
        }
      }),
});

export const getQuestionList = createAsyncThunk('question/getQuestionList', async (_, thunkAPI) => {
  try {
    const { page, size } = thunkAPI.getState().question;

    // const response = await fetch(`https://4f1a-14-39-204-244.jp.ngrok.io/question?page=${page}&size=${size}`);
    // const data = await response.json();

    const data = await fetchQuestionList(`/user/question?page=${page}&size=${size}`);
    return data;
  } catch (error) {
    return thunkAPI.rejectWithValue(error.message);
  }
});

// 리듀서 & 액션 리턴
export const { changeQPage, changeQSize } = questionSlice.actions;
export default questionSlice;
