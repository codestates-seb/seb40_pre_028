import styled from "styled-components";

const NavTap = styled.div`
  display: inline-block;
  padding-top: 100px;
  padding-left: 20px;
  height: 100vh;
  color: #6a737c;
  font-size: 11px;

  li {
    margin-top: 10px;
    color: #525960;
    font-size: 13px;
    width: 130px;
    height: 20px;
    display: inline-block;
  }
  a {
  }
`;

const NavLayout = styled.div`
  height: 100vh;
  width: 170px;
  border-right: solid gray 0.1rem;
  overflow: scroll;
  position: sticky;
`;

function Nav() {
  return (
    <NavLayout>
      <NavTap>
        <ul>
          <div>PUBLIC</div>
          <li>
            <a href="/">Questions</a>
          </li>
          <li>
            <a href="/">Tags</a>
          </li>
          <li>
            <a href="/">Users</a>
          </li>
          <li>
            <a href="/">Companies</a>
          </li>
        </ul>
      </NavTap>
    </NavLayout>
  );
}

export { Nav };
