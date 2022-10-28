import styled from 'styled-components';
import { FaGlobeAmericas } from 'react-icons/fa';

const NavTap = styled.div`
  display: inline-block;
  padding-top: 100px;
  height: 100vh;
  color: #6a737c;
  font-size: 11px;
  width: 100px;
  position: sticky;
  top: 0px;
  li {
    margin-top: 10px;
    color: #525960;
    font-size: 13px;
    width: 157px;
    height: 30px;
    display: inline-block;
    padding-left: 15px;
  }
  .title {
    background-color: #f1f2f3;
    border-right: 3px solid #f38225; // 여기 적용 안됨
    color: #0d0d0e;
    font-weight: bold;
    display: flex;
    align-items: center;
    margin-bottom: 5px;
    height: 40px;
  }
  .under {
    margin-left: 15px;
  }
`;

const NavLayout = styled.div`
  height: 100%;
  width: 180px;
  border-right: solid var(--black-100) 1px;
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
