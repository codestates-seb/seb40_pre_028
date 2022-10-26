import GlobalStyle from "./assets/style/GlobalStyle";
import Header from "./components/Header";
import LogIn from "./pages/Login";
import SignIn from "./pages/Signin";
import { Footer } from "./components/Footer";
import { Nav } from "./components/Nav";

function App() {
  return (
    <div>
      <GlobalStyle />
      <Header />
      <SignIn />
      <LogIn />
      <Nav />
      <Footer />
    </div>
  );
}

export default App;
