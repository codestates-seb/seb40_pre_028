import { useEffect, useRef } from 'react';
import styled from 'styled-components';
import { PowderButton } from './DefaultButton';

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
`;

const HintsBox = styled.div`
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: 5px;
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

export const MiscBox = styled.div`
  display: flex;
  align-items: center;
  padding: 10px;
  border-top: 1px solid var(--black-100);
`;

export const AskLink = styled.a`
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;

  &:link,
  &:visited {
    color: inherit;
  }
`;

export const SearchHelpBox = styled.div`
  width: 80px;
  margin-left: auto;
`;

export const SearchHelpLink = styled.a`
  font-size: 0.8rem;

  &:link,
  &:visited {
    color: var(--powder-500);
  }
`;

const Hint = ({ hint, explanation }) => {
  return (
    <div>
      <HintSpan>{hint}</HintSpan>
      <ExplanationSpan>{explanation}</ExplanationSpan>
    </div>
  );
};

const SearchMisc = () => {
  return (
    <MiscBox>
      <PowderButton>
        <AskLink to="/ask">Ask a question</AskLink>
      </PowderButton>
      <SearchHelpBox>
        <SearchHelpLink href="https://stackoverflow.com/help/searching" target="_blank">
          Search help
        </SearchHelpLink>
      </SearchHelpBox>
    </MiscBox>
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
      if (modalRef.current && !modalRef.current.contains(event.target)) {
        setIsSearchModalOpen(false);
      }
    };

    // 이벤트 핸들러 등록
    document.addEventListener('mousedown', handler);

    return () => {
      // 이벤트 핸들러 해제
      document.removeEventListener('mousedown', handler);
    };
  });

  return (
    <Modal ref={modalRef}>
      <HintsBox>
        {Hints.map(hint => (
          <Hint key={hint.hint} hint={hint.hint} explanation={hint.explanation} />
        ))}
      </HintsBox>
      <SearchMisc />
    </Modal>
  );
}
export { SearchModal };
