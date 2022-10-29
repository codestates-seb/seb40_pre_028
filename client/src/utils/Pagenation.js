import styled from 'styled-components';

function Pagenation({ total, limit, page, setPage }) {
  const numPages = Math.ceil(total / limit);

  return (
    <>
      <Nav>
        <Button onClick={() => setPage(page - 1)} disabled={page === 1}>
          Prev
        </Button>
        {Array(numPages)
          .fill()
          .map((_, i) => (
            <Button key={i + 1} onClick={() => setPage(i + 1)} aria-current={page === i + 1 ? 'page' : null}>
              {i + 1}
            </Button>
          ))}
        <Button onClick={() => setPage(page + 1)} disabled={page === numPages}>
          Next
        </Button>
      </Nav>
    </>
  );
}

const Nav = styled.nav`
  display: flex;
  justify-content: flex-end;
  align-items: center;
  gap: 5px;
  margin: 70px 16px 16px 16px;
  border-top: 3px solid var(--gray-300);
`;

const Button = styled.button`
  min-width: 30px;
  height: 30px;
  border: 1px solid var(--black-100);
  border-radius: 3px;
  display: flex;
  justify-content: center;
  align-items: center;
  color: #3b4045;
  font-size: 13px;
  background-color: white;

  &:hover {
    background-color: #cecbcb;
    cursor: pointer;
  }

  &[disabled] {
    display: none;
    background: grey;
    cursor: revert;
    transform: revert;
  }

  &[aria-current] {
    background: var(--orange-400);
    font-weight: bold;
    cursor: revert;
    transform: revert;
  }
`;

export { Pagenation };
