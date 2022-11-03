import { createSlice } from '@reduxjs/toolkit';
import { getQuestionList } from '../action/questionListAction';

const initialState = {
  page: 1,
  size: 10,
  totalElements: 2,
  questions: [],
  errorMsg: '',
  isLoading: false,
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

// 리듀서 & 액션 리턴
export const { changeQPage } = questionSlice.actions;
export const questionReducer = questionSlice.reducer;
