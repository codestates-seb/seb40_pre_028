import { SUserProfile, AchievementSVG, HelpSVG, InboxSVG, List, MenuUList, SwitchSVG, UserMenusBox, UserInfo } from './style';
import { AiOutlineUser } from 'react-icons/ai';
import { PowderButton } from '../DefaultButton';
import { useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { authSlice } from '../../App';

export const UserMenus = () => {
  const [userInfoClick, setUserInfoClick] = useState(false);

  // redux
  const user = useSelector(state => state.user);
  const dispatch = useDispatch();
  const logoutBtnHandler = e => {
    e.preventDefault();
    dispatch(authSlice.actions.logout());
  };

  return (
    <UserMenusBox>
      <SUserProfile
        onClick={() => {
          setUserInfoClick(!userInfoClick);
        }}
      >
        {userInfoClick ? (
          <UserInfo>
            <span>안녕하세요</span>
            <span>{user.name} 님</span>
            <PowderButton width={'70%'} height={'35%'} onclick={logoutBtnHandler}>
              logout
            </PowderButton>
          </UserInfo>
        ) : (
          ''
        )}
        <AiOutlineUser />
        <div>1</div>
      </SUserProfile>
      <MenuUList>
        <List>
          <InboxSVG />
        </List>
        <List>
          <AchievementSVG />
        </List>
        <List>
          <HelpSVG />
        </List>
        <List>
          <SwitchSVG />
        </List>
      </MenuUList>
    </UserMenusBox>
  );
};
