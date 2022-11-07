// export const BASE_URL = process.env.REACT_APP_HOST;
export const BASE_URL = 'http://ec2-3-38-97-170.ap-northeast-2.compute.amazonaws.com:8080';

export const fetchCreateLogin = (url, payload) => {
  return fetch(BASE_URL + url, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: payload,
  })
    .then(res => {
      return res.json();
    })
    .catch(err => console.error('LOGIN FETCH ERROR: ', err));
};

export const fetchCreateSignup = (url, payload) => {
  return fetch(BASE_URL + url, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: payload,
  })
    .then(res => {
      return res.json();
    })
    .catch(err => console.error('LOGIN FETCH ERROR: ', err));
};

export const fetchCreateQuestion = (url, payload) => {
  return fetch(BASE_URL + url, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: payload,
  })
    .then(res => res.json())
    .catch(err => console.error('LOGIN FETCH ERROR: ', err));
};

export const fetchQuestion = async url => {
  const res = await fetch(BASE_URL + url);
  const data = await res.json();
  return data;
};

export const fetchCreateAnswer = async (url, payload) => {
  try {
    const res = await fetch(BASE_URL + url, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: payload,
    });
    return res;
  } catch (error) {
    console.error(error);
  }
};

export const fetchDelete = url => {
  return fetch(BASE_URL + url, {
    method: 'DELETE',
  }).catch(error => {
    console.error('Error', error);
  });
};

export const fetchUpdateVote = (url, payload) => {
  return fetch(BASE_URL + url, {
    method: 'PATCH',
    headers: { 'Content-Type': 'Application/json' },
    body: payload,
  })
    .then(res => res.json())
    .catch(error => {
      console.error('Error', error);
    });
};

export const fetchQuestionList = url => {
  return fetch(BASE_URL + url).then(res => res.json());
};
