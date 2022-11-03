import QuestionDetail from './pages/QuestionDetail';
import GlobalStyle from './assets/style/GlobalStyle';
import Header from './components/Header';
import UserPage from './pages/UserPage';
import { BrowserRouter, Routes, Route } from 'react-router-dom';

function Appdev() {
  return (
    <>
      <GlobalStyle />
      <BrowserRouter>
        <UserPage />
      </BrowserRouter>
    </>
  );
}

export default Appdev;
