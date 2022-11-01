import LogIn from './pages/Login';
import SharedLayout from './pages/SharedLayout';
import SharedLayout2 from './pages/SharedLayout2';
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
          <Route path="login" element={<LogIn />} />
          <Route path="signup" element={<SignupPage />} />
          <Route path="hi*" element={<SharedLayout2 />}>
            <Route path="ask" element={<CreateQuestionPage />} />
          </Route>
        </Route>
      </Routes>
      <Routes>
        <Route path="/" element={<QuestionDetail />} />
        <Route path="questions" element={<QuestionList />} />
        <Route path="*" element={<NotFound />} />
      </Routes>
    </BrowserRouter>
  );
}

export default Router;
