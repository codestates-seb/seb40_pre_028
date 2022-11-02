import { useEffect } from 'react';
import { json } from 'react-router-dom';

function UserPage() {
  useEffect(() => {
    fetch('https://api.stackexchange.com/2.3/users?order=desc&sort=reputation&site=stackoverflow')
      .then(res => res.json())
      .then(res => console.log(res));
  }, []);

  return (
    <div>
      <div>asd</div>
    </div>
  );
}

export default UserPage;
