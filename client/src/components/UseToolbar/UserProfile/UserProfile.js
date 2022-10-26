// import { useState } from 'react';
// import { userIcon } from '../../../assets/img/userIcon.png';
// import { useAppSelector } from '../../../../../redux';
import {
  UserIconBox,
  UserIconButton,
  UserProfileBox,
  // UserRepSpan,
} from './style';
// import ProfileCard from './UserProfileCard';

const UserProfile = () => {
  // const [openCard, setOpencard] = useState(false);
  // const { image } = useAppSelector((state) => state.user.user) || {};

  return (
    <UserProfileBox>
      <UserIconBox>
        <UserIconButton
          // userImg={userIcon}
          className="user-button"
          // onClick={() => setOpencard((prev) => !prev)}
        />
      </UserIconBox>
      {/* {openCard && <ProfileCard setOpencard={setOpencard} />}
      <UserRepSpan>{userRep}</UserRepSpan> */}
    </UserProfileBox>
  );
};

export default UserProfile;
