import GlobalStyle from './assets/style/GlobalStyle';
import Router from './Router';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import QuestionDetail from './pages/QuestionDetail';

function App() {
  return (
    <>
      <GlobalStyle />
      <Router />
    </>
  );
}

export default App;
