import styled from 'styled-components';
import { FaGlobeAmericas } from 'react-icons/fa';

const NavTap = styled.div`
  display: inline-block;
  color: #6a737c;
  font-size: 11px;
  position: sticky;
  width: 162px;
  top: 110px;
  li {
    margin-top: 10px;
    color: #525960;
    font-size: 13px;
    height: 30px;
    display: block;
    padding-left: 15px;
  }
  .title {
    background-color: #f1f2f3;
    border-right: 3px solid #f38225;
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
  /* border-right: solid var(--black-100) 1px; */
  /* width: 162px; */
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
