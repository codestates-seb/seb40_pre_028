import { useEffect, useState } from 'react';
import styled from 'styled-components';
import { AiOutlineSearch } from 'react-icons/ai';
import { LoadingSpinner } from '../components/LoadingSpinner';

function UserPage() {
  let [users, setUsers] = useState([]);
  let [click, setClick] = useState('reputation');
  const [isLoading, setIsLoading] = useState(true);
  useEffect(() => {
    fetch(`https://api.stackexchange.com/2.3/users?order=desc&sort=${click}&site=stackoverflow`)
      .then(res => res.json())
      .then(data => {
        setUsers(data.items);
        setIsLoading(false);
      })
      .catch(error => console.error(error));
  }, [click]);

  return (
    <UserLayout>
      <UserFrom>
        <h1>Users</h1>
        <FilterBar>
          <div className="searchBar">
            <AiOutlineSearch className="search" />
            <input placeholder="Filter by tag name" />
          </div>
          <FilterBtn>
            <button className="filterBtLeft" onClick={() => setClick('reputation')}>
              Requtation
            </button>
            <button className="filterBtCenter" onClick={() => setClick('creation')}>
              creation
            </button>
            <button className="filterBtCenter" onClick={() => setClick('name')}>
              name
            </button>
            <button className="filterBtRight" onClick={() => setClick('modified')}>
              modified
            </button>
          </FilterBtn>
        </FilterBar>
        <UserList>
          {isLoading ? (
            <LoadingSpinnerContainer>
              <LoadingSpinner />
            </LoadingSpinnerContainer>
          ) : (
            users.map(user => (
              <UserItem key={user.user_id}>
                <Profile src={user.profile_image} alt="profile_image" />
                <div className="userItem">
                  <UserName onClick={() => window.open(user.link)}>{user.display_name}</UserName>
                  <UserLocation onChange={() => console.log(users)}>{user.location}</UserLocation>
                  <UserReputation onChange={() => console.log(users)}>{user.reputation}</UserReputation>
                </div>
              </UserItem>
            ))
          )}
        </UserList>
      </UserFrom>
    </UserLayout>
  );
}

const LoadingSpinnerContainer = styled.div`
  width: 110vh;
  height: 60vh;
  display: flex;
  justify-content: center;
  align-items: center;
`;

const UserLayout = styled.div`
  width: 100%;
  padding: 24px;
`;

const UserFrom = styled.div`
  h1 {
    font-size: 27px;
    margin: 0px 0px 27px;
  }
`;
const Profile = styled.img`
  width: 50px;
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
  grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
  grid-gap: 15px;
`;

const UserItem = styled.div`
  grid-template-columns: 1fr 2fr 100px;
  display: flex;
`;

const UserName = styled.button`
  font-size: 13px;
  color: #0074cc;
  border: none;
  background-color: white;
  cursor: pointer;
`;

const UserLocation = styled.div`
  font-size: 13px;
  color: #6a737c;
  width: 200px;
  margin-left: 5px;
`;

const UserReputation = styled.div`
  font-size: 13px;
  color: #6a737c;
  font-weight: bold;
  margin-left: 5px;
`;
export default UserPage;
