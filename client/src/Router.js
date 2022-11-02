import LogIn from './pages/Login';
import SharedLayout from './pages/SharedLayout';
import SignupPage from './pages/Signup';
import CreateQuestionPage from './pages/CreateQuestion';
import QuestionDetail from './pages/QuestionDetail';
import { QuestionList } from './components/QuestionList';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import NotFound from './pages/NotFound';

function Router() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<SharedLayout />}>
          <Route index element={<QuestionList />} />
          <Route path="/ask" element={<CreateQuestionPage />} />
          <Route path="/question" element={<QuestionDetail />} />
          <Route path="*" element={<NotFound />} />
        </Route>
        <Route path="/login" element={<LogIn />} />
        <Route path="/signup" element={<SignupPage />} />
      </Routes>
    </BrowserRouter>
  );
}

export default Router;
