// import { Link } from 'react-router-dom';
import styled from 'styled-components';

import { ReactComponent as Achievement } from '../../assets/img/nav-achievement.svg';
import { ReactComponent as Help } from '../../assets/img/nav-help.svg';
import { ReactComponent as Inbox } from '../../assets/img/nav-inbox.svg';
import { ReactComponent as Switch } from '../../assets/img/nav-switch.svg';

export const SUserProfile = styled.div`
  width: 25px;
  height: 25px;
  display: flex;
  justify-content: center;
  align-items: center;
  cursor: pointer;
  border-radius: 10px;
  background-color: var(--black-075);
  position: relative;
  margin: 0 25px 0 20px;
  :hover {
    background-color: var(--black-100);
  }

  > div {
    font-size: 10px;
    position: absolute;
    right: -10px;
  }
`;

export const UserMenusBox = styled.div`
  flex: 0 0 220px;
  display: flex;
  align-items: center;
  height: 100%;
`;

export const MenuUList = styled.ul`
  display: flex;
  flex-flow: row nowrap;
  align-items: center;
  column-gap: 5px;
`;

export const List = styled.li`
  width: 30px;
  height: 30px;
  display: flex;
  justify-content: center;
  align-items: center;
`;

// export const CustomLink = styled(Link)`
//   display: flex;
//   justify-content: center;
//   align-items: center;
//   width: 100%;
//   height: 100%;
// `;

export const InboxSVG = styled(Inbox)`
  fill: var(--black-600);
  width: 60%;
  height: 60%;
  cursor: pointer;
  :hover {
    fill: var(--orange-400);
  }
`;
export const AchievementSVG = styled(Achievement)`
  fill: var(--black-600);
  width: 60%;
  height: 60%;
  cursor: pointer;
  :hover {
    fill: var(--orange-400);
  }
`;
export const HelpSVG = styled(Help)`
  fill: var(--black-600);
  width: 60%;
  height: 60%;
  cursor: pointer;
  :hover {
    fill: var(--orange-400);
  }
`;
export const SwitchSVG = styled(Switch)`
  fill: var(--black-600);
  width: 60%;
  height: 60%;
  cursor: pointer;
  :hover {
    fill: var(--orange-400);
  }
`;

export const UserInfo = styled.div`
  cursor: default;
  position: absolute;
  top: 26px;
  left: 16px;
  width: 80px;
  height: 80px;
  background-color: var(--black-075);
  border-radius: 10px;
  border-top-left-radius: 0;
  padding: 2px 0;

  display: flex;
  flex-direction: column;
  justify-content: space-around;
  align-items: center;
`;
