import { useEffect, useState } from 'react';
import styled from 'styled-components';

import { Loading } from '../components/Loading';
import { User } from '../components/User';

const Bg = styled.div`
  background-color: #f1f2f3;
  padding: 20px 0;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
`;

export default function UserInfoPage({ isLoading, userData }) {
  return (
    <>
      <Bg>{isLoading ? <Loading /> : <User userData={userData} />}</Bg>
    </>
  );
}
