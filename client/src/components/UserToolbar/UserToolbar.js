import { SUserProfile, AchievementSVG, HelpSVG, InboxSVG, List, MenuUList, SwitchSVG, UserMenusBox, UserInfo } from './style';
import { AiOutlineUser } from 'react-icons/ai';
import { PowderButton } from '../DefaultButton';

export const UserMenus = () => {
  return (
    <UserMenusBox>
      <SUserProfile>
        <UserInfo>
          {/* <span>안녕하세요</span> */}
          <span>___님</span>
          <PowderButton width={'70%'} height={'35%'}>
            logout
          </PowderButton>
        </UserInfo>
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
