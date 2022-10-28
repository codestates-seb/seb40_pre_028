import { IoPencilSharp } from 'react-icons/io5';
import { FaRegCommentAlt } from 'react-icons/fa';
import { BsStackOverflow } from 'react-icons/bs';

import styled from 'styled-components';

export const SidebarContainer = styled.aside`
  display: flex;
  flex-direction: column;
  width: 298px;

  & > a {
    width: 100%;

    & > img {
      width: 100%;
    }
  }

  @media screen and (max-width: 1100px) {
    display: none;
  }
`;

export const Sidebar = styled.div`
  border: 1px solid hsl(47, 65%, 84%);
  background-color: hsl(47, 83%, 91%);
  color: #525960;
  box-shadow: 0 1px 2px hsla(0, 0%, 0%, 0.05), 0 1px 4px hsla(0, 0%, 0%, 0.05), 0 2px 8px hsla(0, 0%, 0%, 0.05);

  header {
    padding: 12px 15px;
    border-bottom: 1px solid hsl(47, 65%, 84%);
    font-size: 13px;
    font-weight: 700;
  }

  & > header:nth-child(3) {
    border-top: 1px solid hsl(47, 65%, 84%);
  }

  ul {
    padding: 4px 15px;
    background-color: #faf5e6;
  }

  li {
    margin: 12px 0;
    font-size: 13px;
    line-height: 18px;
    display: flex;
    cursor: pointer;
    > div:nth-child(1) {
      margin-right: 10px;
    }
    .meta {
      color: var(--blue-300);
    }
  }
`;

const Aside = ({ className }) => {
  return (
    <SidebarContainer className={className}>
      <Sidebar>
        <header>The Overflow Blog</header>
        <ul>
          <li>
            <div>
              <IoPencilSharp />
            </div>
            CEO update: Breaking down barriers to unlock innovation
          </li>
          <li>
            <div>
              <IoPencilSharp />
            </div>
            Introducing the Ask Wizard: Your guide to crafting high-quality questions
          </li>
        </ul>
        <header>Featured on Meta</header>
        <ul>
          <li>
            <div className="meta">
              <FaRegCommentAlt />
            </div>
            The 2022 Community-a-thon has begun!
          </li>
          <li>
            <div className="meta">
              <FaRegCommentAlt />
            </div>
            Mobile app infrastructure being decommissioned
          </li>
          <li>
            <div className="stackOverIcon">
              <BsStackOverflow />
            </div>
            Staging Ground Workflow: Canned Comments
          </li>
          <li>
            <div className="stackOverIcon">
              <BsStackOverflow />
            </div>
            The Ask Wizard (2022) has graduated
          </li>
        </ul>
      </Sidebar>
    </SidebarContainer>
  );
};

export { Aside };
