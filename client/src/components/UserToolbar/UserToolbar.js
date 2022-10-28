import { SUserProfile, AchievementSVG, HelpSVG, InboxSVG, List, MenuUList, SwitchSVG, UserMenusBox } from './style';
import { AiOutlineUser } from 'react-icons/ai';

export const UserMenus = () => {
  return (
    <UserMenusBox>
      <SUserProfile>
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
