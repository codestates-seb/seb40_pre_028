import { useEffect, useRef } from 'react';
import styled from 'styled-components';

const Modal = styled.div`
  /* 모달창 크기 */
  width: calc(100% - 20px);
  min-width: 395px;
  height: 200px;
  /* 최상단 위치 */
  z-index: 999;
  position: absolute;
  top: 145px;
  left: 50%;
  transform: translate(-50%, -50%);
  /* 모달창 디자인 */
  background-color: white;
  border-radius: 5px;
  border: 1px solid var(--black-100);
  /* 모달창 내부 요소 디자인 */
  display: flex;
  flex-direction: column;
  & button {
    height: 2rem;
    border: none;
    font-size: 0.5rem;
    background-color: var(--black-100);
    color: white;
    border-radius: 15px;
    cursor: pointer;
  }
`;

const HintsBox = styled.div`
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  row-gap: 5px;
  column-gap: 5px;
  width: 100%;
  height: 70%;
  padding: 10px;
`;
const FontSmall = styled.span`
  font-size: 0.85rem;
`;
const HintSpan = styled(FontSmall)`
  margin-right: 5px;
`;

const ExplanationSpan = styled(FontSmall)`
  color: var(--black-400);
`;

const Hints = [
  { hint: '[tag]', explanation: 'search within a tag' },
  { hint: 'answers:0', explanation: 'unanswered questions' },
  { hint: 'user:1234', explanation: 'search by author' },
  { hint: 'score:3', explanation: 'posts with a 3+ score' },
  { hint: '"words here"', explanation: 'exact phrase' },
  { hint: 'is:question', explanation: 'type of post' },
  { hint: 'collective:"Name"', explanation: 'collective content' },
  { hint: 'isaccepted:yes', explanation: 'search within status' },
];

const Hint = ({ hint, explanation }) => {
  return (
    <div>
      <HintSpan>{hint}</HintSpan>
      <ExplanationSpan>{explanation}</ExplanationSpan>
    </div>
  );
};

function SearchModal({ setIsSearchModalOpen }) {
  // 모달 외부 클릭시 끄기 처리
  // Modal 창을 useRef로 취득
  const modalRef = useRef(null);

  useEffect(() => {
    // 이벤트 핸들러 함수
    const handler = () => {
      // mousedown 이벤트가 발생한 영역이 모달창이 아닐 때, 모달창 제거 처리
      // eslint-disable-next-line no-restricted-globals
      if (modalRef.current && !modalRef.current.contains(event.target)) {
        setIsSearchModalOpen(false);
      }
    };

    // 이벤트 핸들러 등록
    document.addEventListener('mousedown', handler);
    // document.addEventListener('touchstart', handler); // 모바일 대응

    return () => {
      // 이벤트 핸들러 해제
      document.removeEventListener('mousedown', handler);
      // document.removeEventListener('touchstart', handler); // 모바일 대응
    };
  });

  return (
    <Modal ref={modalRef}>
      <HintsBox>
        {Hints.map(hint => (
          <Hint key={hint.hint} hint={hint.hint} explanation={hint.explanation} />
        ))}
      </HintsBox>
      <button>Ask a question</button>
    </Modal>
  );
}
export { SearchModal };
