import styled from 'styled-components';
import { ReactComponent as Sprites } from '../assets/img/sprites.svg';
import { MdSearch } from 'react-icons/md';
import { BlueButton, PowderButton } from './DefaultButton';
import { UserMenus } from './UserToolbar/UserToolbar';
import { SearchModal } from '../components/SearchModal';
import { useState } from 'react';
import { Link } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import { authSlice } from '../redux/slice/authSlice';

export const SHeader = styled.header`
  display: flex;
  justify-content: center;
  position: sticky;
  top: 0;
  width: 100%;
  height: 50px;
  background-color: var(--black-025);
  box-shadow: 0px 1px 2px var(--black-100);
  z-index: 1;

  &::before {
    display: block;
    position: absolute;
    top: 0%;
    content: '';
    width: 100%;
    height: 3px;
    background-color: var(--orange-400);
    z-index: 2;
  }
`;

export const SNav = styled.nav`
  display: flex;
  align-items: center;
  width: 100%;
  max-width: 1264px;
  height: 50px;
  padding-top: 3px;
`;

export const MainLogoSVG = styled(Sprites)`
  width: 150px;
  position: relative;
  left: 1%;
  top: -1050%;
`;

export const LogoBox = styled.div`
  flex: 0 0 162px;
  position: relative;
  padding-left: 6px;
  padding-right: 6px;
  cursor: pointer;
  height: 100%;
  overflow: hidden;
  transition: background-color 0.4s;
  a {
    display: block;
    position: absolute;
    width: 100%;
    height: 100%;
    z-index: 2;
  }
  &:hover {
    background-color: var(--black-075);
  }
`;

export const HeaderButton = styled.button`
  display: flex;
  justify-content: center;
  align-items: center;
  color: var(--black-700);
  border-radius: 20px;
  width: 80px;
  height: 32px;
  font-size: 0.85rem;
  transition: background-color 0.4s;
  border: none;
  background-color: var(--black-025);
  cursor: pointer;
  &:hover {
    background-color: var(--black-075);
  }
`;

export const SearchContainer = styled.form`
  display: flex;
  justify-content: center;
  align-items: center;
  flex: 1 1 300px;
  height: 100%;
  padding: 0 10px;
  position: relative;
  // 돋보기 아이콘에 적용
  > *:first-child {
    position: absolute;
    left: 15px;
    color: var(--black-400);
    font-size: 1.5rem;
  }
`;

export const SearchBar = styled.input.attrs({
  type: 'text',
  placeholder: 'Search...',
})`
  width: 100%;
  height: 70%;
  padding: 10px 10px 10px 30px;
  border: 1px solid var(--black-200);
  border-radius: 3px;
  &:focus {
    outline: 4px solid var(--blue-100);
    border: 1px solid var(--blue-300);
  }
`;

export const AuthBtns = styled.div`
  display: flex;
  column-gap: 3px;
  margin-right: 20px;
`;

function Header() {
  let [isSearchModalOpen, setIsSearchModalOpen] = useState(false);

  //redux
  const isLogin = useSelector(state => state.auth.isLogin);
  const dispatch = useDispatch();
  return (
    <SHeader>
      <SNav>
        <LogoBox>
          <Link to="/" />
          <MainLogoSVG />
        </LogoBox>
        <HeaderButton
          onClick={() => {
            dispatch(authSlice.actions.login());
          }}
        >
          Products
        </HeaderButton>
        <SearchContainer onFocus={() => setIsSearchModalOpen(true)}>
          <MdSearch />
          <SearchBar />
          {!!isSearchModalOpen && <SearchModal setIsSearchModalOpen={setIsSearchModalOpen} />}
        </SearchContainer>
        {isLogin ? (
          <UserMenus />
        ) : (
          <AuthBtns>
            <Link to="/login">
              <PowderButton>Log in</PowderButton>
            </Link>
            <Link to="/signup">
              <BlueButton>Sign up</BlueButton>
            </Link>
          </AuthBtns>
        )}
      </SNav>
    </SHeader>
  );
}

export default Header;
