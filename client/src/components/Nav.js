import styled, { css } from 'styled-components';
import { FaGlobeAmericas } from 'react-icons/fa';
import { NavLink, useMatch } from 'react-router-dom';

const NavTap = styled.div`
  display: inline-block;
  color: #6a737c;
  font-size: 13px;
  position: sticky;
  width: 162px;
  top: 110px; // top 적용안됨 확인 필요
  row-gap: 20px;

  /* 나중에 빼야할 것 */
  margin-left: 30px;
  margin-top: 100px;

  a {
    display: flex;
    align-items: center;
    height: 40px;
    margin-left: 15px;
    &.choice {
      color: #525960;
      font-size: 15px;
      padding-left: 15px;
      display: flex;
      margin-left: 15px;
      ${props =>
        props.isHome === 'true' &&
        css`
          border-right: 3px solid #f38225;
          background-color: #f1f2f3;
          color: #0d0d0e;
          font-weight: bold;
          margin-left: 30px;
          font-size: 15px;
        `}
    }
    &.choiceyes {
      border-right: 3px solid #f38225;
      background-color: #f1f2f3;
      color: #0d0d0e;
      font-weight: bold;
      margin-left: 30px;
      font-size: 15px;
      padding-left: 15px;
    }

    .reactIcon {
      margin-right: 5px;
    }

    &:hover {
      color: #0d0d0e;
    }

    /* @media screen and (max-width: 800px) {
      display: none;
    } */
  }
`;

const SLink = styled(NavLink)`
  display: flex;
  align-items: center;
  height: 40px;
  margin-left: 15px;
  color: #525960;
  font-size: 15px;
  padding-left: 15px;
  display: flex;
  margin-left: 15px;
  ${props =>
    props.isHome === 'true' &&
    css`
      border-right: 3px solid #f38225;
      background-color: #f1f2f3;
      color: #0d0d0e;
      font-weight: bold;
      margin-left: 30px;
      font-size: 15px;
    `}
`;

const NavLayout = styled.div`
  border-right: solid var(--black-100) 1px;
  /* width: 162px; */
`;

function Nav() {
  const match = useMatch('/');
  const isHome = (match?.pathname === '/').toString();
  console.log(match);

  return (
    <NavLayout>
      <NavTap>
        <div>public</div>
        <SLink isHome={isHome} to="/">
          <FaGlobeAmericas className="reactIcon" />
          Question
        </SLink>
        <NavLink className={({ isActive }) => 'choice' + (isActive ? 'yes' : '')} to="tags">
          Tags
        </NavLink>
        <NavLink className={({ isActive }) => 'choice' + (isActive ? 'yes' : '')} to="users">
          Users
        </NavLink>
      </NavTap>
    </NavLayout>
  );
}

export { Nav };
