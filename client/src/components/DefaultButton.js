import styled, { css } from 'styled-components';

export const DefaultButton = styled.button`
  display: flex;
  justify-content: center;
  align-items: center;
  border-radius: 3px;
  padding: 2px 9px;
  transition: 0.4s all;
  font-size: 0.85rem;
  width: max-content;
  height: 32px;
  box-shadow: inset 0 1px 0 0 hsl(0deg 0% 100% / 70%);
  ${({ color, colorCode, borderCode, activeBorderCode, bgCode, hoverBgCode, activeBgCode, width, height }) => css`
    border: 1px solid ${`var(--${color}-${borderCode})`};
    color: ${`var(--${color}-${colorCode})`};
    background-color: ${`var(--${color}-${bgCode})`};
    width: ${width};
    height: ${height};
    &:hover {
      background-color: ${`var(--${color}-${hoverBgCode})`};
      transition: 0.4s all;
      cursor: pointer;
    }
    &:active {
      box-shadow: none;
      border-color: ${`var(--${color}-${activeBorderCode})`};
      background-color: ${`var(--${color}-${activeBgCode})`};
    }
  `}
`;

export const PowderButton = ({ children, width, height }) => {
  return (
    <DefaultButton
      color="powder"
      colorCode="700"
      borderCode="500"
      activeBorderCode="600"
      bgCode="100"
      hoverBgCode="300"
      activeBgCode="400"
      width={width}
      height={height}
    >
      {children}
    </DefaultButton>
  );
};

export const BlueButton = ({ children, width, height }) => {
  return (
    <DefaultButton
      color="blue"
      colorCode="050"
      borderCode="500"
      activeBorderCode="600"
      bgCode="500"
      hoverBgCode="600"
      activeBgCode="700"
      width={width}
      height={height}
    >
      {children}
    </DefaultButton>
  );
};
