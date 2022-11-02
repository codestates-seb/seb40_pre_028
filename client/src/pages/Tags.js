import styled from 'styled-components';
import { AiOutlineSearch } from 'react-icons/ai';
import React from 'react';

function Tags() {
  return (
    <TagLayout>
      <TagFrom>
        <h1>Tags</h1>
        <p>
          A tag is a keyword or label that categorizes your question with other, similar questions. Using the right tags makes it easier for others to
          find and answer your question.
        </p>
        <div className="allTag">
          <a href="/#">Show all tag synonyms</a>
        </div>
        <FilterBar>
          <div className="searchBar">
            <AiOutlineSearch className="search" />
            <input placeholder="Filter by tag name" />
          </div>
          {/* <a className="aLeft" href="/#">
            Popular
          </a>
          <a className="aCenter" href="/#">
            Name
          </a>
          <a className="aRight" href="/#">
            New
          </a> */}
        </FilterBar>
        <TagsGrid>
          <div className="girdContainer">
            <div className="itemContainer">
              <span className="tagSpan">javascript</span>
              <div className="tagCount">293402 question</div>
            </div>
          </div>
          <div className="girdContainer">
            <div className="itemContainer">
              <span className="tagSpan">phython</span>
              <div className="tagCount">2050514 question</div>
            </div>
          </div>
          <div className="girdContainer">
            <div className="itemContainer">
              <span className="tagSpan">java</span>
              <div className="tagCount">2441408 question</div>
            </div>
          </div>
          <div className="girdContainer">
            <div className="itemContainer">
              <span className="tagSpan">c#</span>
              <div className="tagCount">1565798 question</div>
            </div>
          </div>
          <div className="girdContainer">
            <div className="itemContainer">
              <span className="tagSpan">php</span>
              <div className="tagCount">1448836 question</div>
            </div>
          </div>
          <div className="girdContainer">
            <div className="itemContainer">
              <span className="tagSpan">android</span>
              <div className="tagCount">1390187 question</div>
            </div>
          </div>
          <div className="girdContainer">
            <div className="itemContainer">
              <span className="tagSpan">html</span>
              <div className="tagCount">1151505 question</div>
            </div>
          </div>
          <div className="girdContainer">
            <div className="itemContainer">
              <span className="tagSpan">jquery</span>
              <div className="tagCount">1030573 question</div>
            </div>
          </div>
          <div className="girdContainer">
            <div className="itemContainer">
              <span className="tagSpan">c++</span>
              <div className="tagCount">780377 question</div>
            </div>
          </div>
          <div className="girdContainer">
            <div className="itemContainer">
              <span className="tagSpan">css</span>
              <div className="tagCount">775789 question</div>
            </div>
          </div>
        </TagsGrid>
      </TagFrom>
    </TagLayout>
  );
}
const TagLayout = styled.div`
  width: 100%;
  padding: 24px;
`;

const TagFrom = styled.div`
  h1 {
    font-size: 27px;
    margin: 0px 0px 16px;
  }
  p {
    overflow: auto;
    max-width: 650px;
    margin: 0px 0px 16px;
    font-size: 15px;
    height: 50px;
  }
  .allTag {
    margin: 2px;
    color: #0074cc;
    font-size: 13px;
    margin-bottom: 24px;
  }
`;

const FilterBar = styled.div`
  display: flex;
  justify-content: space-between;
  margin-bottom: 16px;

  .searchBar {
    border: 1px solid gray;
    display: flex;
    justify-content: center;
    height: 30px;
  }
  input {
    border: none;
  }
  .search {
    color: gray;
    font-size: 20px;
    margin-top: 5px;
    margin-left: 3px;
  }
`;

const TagsGrid = styled.div`
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(220px, 1fr));
  grid-gap: 10px;

  .girdContainer {
    grid-template-columns: 1fr 2fr 100px 25%;
    border: 0.5px solid gray;
    display: inline-block;
  }

  .itemContainer {
    margin: 15px;
  }

  .tagSpan {
    background-color: #e1ecf4;
    color: #39739d;
    padding: 4px;
    border-radius: 5px;
    font-size: 15px;
  }
  .tagCount {
    margin-top: 20px;
    font-size: 12px;
    color: #838c95;
  }
`;

export default Tags;
