import GlobalStyle from './assets/style/GlobalStyle';
import Router from './Router';
import Tags from './pages/Tags';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import QuestionDetail from './pages/QuestionDetail';

function App() {
  return (
    <>
      <GlobalStyle />
      <BrowserRouter>
        <Tags />
      </BrowserRouter>
    </>
  );
}

export default App;
