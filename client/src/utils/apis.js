export const BASE_URL = 'https://8996-14-39-204-244.jp.ngrok.io';
export const fetchCreateLogin = (url, payload) => {
  return fetch(BASE_URL + url, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      'ngrok-skip-browser-warning': 'skip',
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
      'ngrok-skip-browser-warning': 'skip',
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
