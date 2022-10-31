import styled from 'styled-components';
import { ReactComponent as spotPencil } from '../../assets/img/spotPencil.svg';

const AlertMsgContainer = styled.div`
  /* width: 300px;
  height: 200px; */
  background-color: white;

  border: 1px solid var(--black-100);
  border-radius: 2px;
  box-shadow: 0 0 10px var(--black-150);
`;
const AlertMsgTitle = styled.div`
  width: 100%;
  height: 26%;
  background-color: #f1f2f3;
  border-bottom: 1px solid var(--black-100);
  display: flex;
  align-items: center;
  padding: 10px 16px;
`;
const AlertMsgContents = styled.div`
  height: 74%;
  font-family: 'sans-serif';
  font-size: 14px;
  display: flex;
  padding: 14px 0;
  div {
    margin: 0 10px;
    span {
      color: var(--black-700);
      display: block;
      margin-bottom: 10px;
      width: 260px;
    }
  }
`;
const PencilIcon = styled(spotPencil)`
  width: 50px;
  height: 50px;
`;

export function AlertMsg({ title, content1, content2 }) {
  return (
    <div>
      <AlertMsgContainer>
        <AlertMsgTitle>
          <span>{title}</span>
        </AlertMsgTitle>
        <AlertMsgContents>
          <div>
            <PencilIcon />
          </div>
          <div>
            <span>{content1}</span>
            <span>{content2}</span>
          </div>
        </AlertMsgContents>
      </AlertMsgContainer>
    </div>
  );
}
