import LogIn from './pages/Login';
import BodyContainter from './pages/BodyContainter';
import MiddleContainer from './pages/MiddleContainer';
import MainBox from './pages/MainBox';
import SignupPage from './pages/Signup';
import CreateQuestionPage from './pages/CreateQuestion';
import QuestionDetail from './pages/QuestionDetail';
import { QuestionList } from './components/QuestionList';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import NotFound from './pages/NotFound';
import Tags from './pages/Tags';

function Router() {
  return (
    <BrowserRouter>
      <Routes>
        <Route element={<BodyContainter />}>
          {/* header, footer */}
          <Route path="login" element={<LogIn />} />
          <Route path="signup" element={<SignupPage />} />
          <Route path="ask" element={<CreateQuestionPage />} />
          <Route element={<MiddleContainer />}>
            {/* nav */}
            <Route path=":id" element={<QuestionDetail />} />
            <Route path="tags" element={<Tags />} />
            <Route path="*" element={<NotFound />} />
            <Route element={<MainBox />}>
              {/* aside */}
              <Route index element={<QuestionList />} />
            </Route>
          </Route>
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default Router;
