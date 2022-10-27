import styled from 'styled-components';
import { FaGlobeAmericas } from 'react-icons/fa';

const NavTap = styled.div`
  display: inline-block;
  padding-top: 100px;
  margin-left: 30px;
  height: 100vh;
  color: #6a737c;
  font-size: 11px;
  width: 100px;
  position: sticky;
  top: 0px;

  ul {
  }
  li {
    margin-top: 10px;
    color: #525960;
    font-size: 13px;
    width: 130px;
    height: 30px;
    display: inline-block;
    padding-top: 5px;
    padding-left: 15px;
  }
  .title {
    background-color: #f1f2f3;
    border-right: 6px solid #f38225;
    color: #0d0d0e;
    font-weight: bold;
  }
  .under {
    margin-left: 15px;
  }
`;

const NavLayout = styled.div`
  height: 100vh;
  width: 160px;
  border-right: solid gray 0.1rem;
  overflow: scroll;
  position: sticky;
  margin-left: 70px;
`;

function Nav() {
  return (
    <NavLayout>
      <NavTap>
        <ul>
          <div>PUBLIC</div>
          <li className="title">
            <a href="/">
              <FaGlobeAmericas /> Questions
            </a>
          </li>
          <li className="under">
            <a href="/">Tags</a>
          </li>
          <li className="under">
            <a href="/">Users</a>
          </li>
          <li className="under">
            <a href="/">Companies</a>
          </li>
        </ul>
      </NavTap>
    </NavLayout>
  );
}

export { Nav };
