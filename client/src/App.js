import GlobalStyle from "./assets/style/GlobalStyle";
import Header from "./components/Header";
import LogIn from "./pages/Login";
import SignUp from "./pages/Signup";
import Footer from "./components/Footer";
import { Nav } from "./components/Nav";

function App() {
  return (
    <div>
      <GlobalStyle />
      <Header />
      <SignUp />
      <LogIn />
      <Nav />
      <Footer />
    </div>
  );
}

export default App;
