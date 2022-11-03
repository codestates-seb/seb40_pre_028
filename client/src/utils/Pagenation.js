import styled from 'styled-components';

function Pagenation({ total, size, page, setPage, setSize }) {
  const numPages = Math.ceil(total / size);

  return (
    <PagenationContainer>
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
      <Nav>
        <Button onClick={() => setSize(10)} aria-current={size === 10 ? true : null}>
          10
        </Button>
        <Button onClick={() => setSize(20)} aria-current={size === 20 ? true : null}>
          20
        </Button>
        <Button onClick={() => setSize(30)} aria-current={size === 30 ? true : null}>
          30
        </Button>
        <span>per page</span>
      </Nav>
    </PagenationContainer>
  );
}

const PagenationContainer = styled.div`
  display: flex;
  justify-content: space-between;
`;

const Nav = styled.nav`
  display: flex;
  justify-content: flex-end;
  align-items: center;
  gap: 5px;
  margin: 70px 16px 16px 16px;
  > span {
    font-size: 13px;
    color: var(--black-700);
    padding: 8px;
  }
`;

const Button = styled.button`
  min-width: 30px;
  height: 30px;
  border: 1px solid var(--black-100);
  border-radius: 3px;
  padding: 8px;
  display: flex;
  justify-content: center;
  align-items: center;
  color: var(--black-700);
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
    color: white;
    background: var(--orange-400);
    cursor: revert;
    transform: revert;
  }
`;

export { Pagenation };
