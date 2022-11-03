import { useEffect, useState } from 'react';
import styled from 'styled-components';
import { AiOutlineSearch } from 'react-icons/ai';

function UserPage() {
  let [users, setUsers] = useState([]);

  useEffect(() => {
    fetch('https://api.stackexchange.com/2.3/users?order=desc&sort=reputation&site=stackoverflow')
      .then(res => res.json())
      .then(data => {
        console.log(data);
        setUsers(data.items);
      })
      .catch(error => console.error(error));
  }, []);
  return (
    <UserLayout>
      <h1>Users</h1>
      <FilterBar>
        <div className="searchBar">
          <AiOutlineSearch className="search" />
          <input placeholder="Filter by tag name" />
        </div>
        <FilterBtn>
          <button className="filterBtLeft">Requtation</button>
          <button className="filterBtCenter">Voters</button>
          <button className="filterBtCenter">Editors</button>
          <button className="filterBtRight">Moderators</button>
        </FilterBtn>
      </FilterBar>
      <UserList>
        {users.map(user => (
          <UserItem key={user.user_id}>
            <UserName onChange={() => console.log(users)}>{user.display_name}</UserName>
            <UserLocation onChange={() => console.log(users)}>{user.location}</UserLocation>
            <UserReputation onChange={() => console.log(users)}>{user.reputation}</UserReputation>
          </UserItem>
        ))}
      </UserList>
    </UserLayout>
  );
}

const UserLayout = styled.div`
  h1 {
    font-size: 27px;
    margin: 0px 0px 27px;
  }
`;

const FilterBar = styled.div`
  display: flex;
  justify-content: space-between;
  margin-bottom: 50px;

  .searchBar {
    border: 1px solid gray;
    display: flex;
    justify-content: center;
    height: 40px;
  }
  input {
    border: none;
  }
  .search {
    color: gray;
    font-size: 20px;
    margin-top: 5px;
    margin-left: 3px;
  }
`;

const FilterBtn = styled.div`
  .filterBtLeft {
    font-size: 13px;
    color: #3b4045;
    height: 40px;
  }
  .filterBtCenter {
    font-size: 13px;
    color: #3b4045;
    height: 40px;
  }
  .filterBtRight {
    font-size: 13px;
    color: #3b4045;
    height: 40px;
  }
`;

const UserList = styled.div`
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(150px, 1fr));
  grid-gap: 15px;
`;

const UserItem = styled.div`
  border: 1px solid blue;
  grid-template-columns: 1fr 2fr 100px;
  display: inline-block;
`;

const UserName = styled.div`
  font-size: 13px;
  color: #0074cc;
`;

const UserLocation = styled.div`
  font-size: 13px;
  color: #6a737c;
`;

const UserReputation = styled.div`
  font-size: 13px;
  color: #6a737c;
  font-weight: bold;
`;
export default UserPage;
