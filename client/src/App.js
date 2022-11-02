import GlobalStyle from './assets/style/GlobalStyle';
import Router from './Router';
import UserPage from './pages/UserPage';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import QuestionDetail from './pages/QuestionDetail';

function App() {
  return (
    <>
      <GlobalStyle />
      <BrowserRouter>
        <UserPage />
      </BrowserRouter>
    </>
  );
}

export default App;
