const BASE_URL = 'http://localhost:3000';

export const fetchLogin = (url, payload) => {
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

export const fetchSignup = (url, payload) => {
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
