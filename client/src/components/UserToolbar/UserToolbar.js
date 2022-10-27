import { AchievementSVG, HelpSVG, InboxSVG, List, MenuUList, SwitchSVG, UserMenusBox } from './style';
// import UserProfile from './UserProfile/UserProfile';

export const UserMenus = () => {
  return (
    <UserMenusBox>
      {/* <UserProfile /> */}
      <div></div>
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
