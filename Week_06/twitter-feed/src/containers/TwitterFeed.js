import React, { useLayoutEffect } from 'react';
import Tweet from "../components/Tweet"

const TwitterFeed = (props) => {

  // let data = props.data[0]

  // return(
  //   <div>
  //     <Tweet
  //       tweet = {data}
  //     />
  //   </div>
  // );

  // return(
  //   <ul>
  //     <Tweet
  //       tweet = {data}
  //     />
  //   </ul>
  // );

  const tweetData = props.data.map(tweet, index => {
    return <Tweet
      tweet = { {id: index, tweet: tweet} }
    />
  });

  return(
    <ul>
      {tweetData}
    </ul>
  );

  // const numbers = [1, 2, 3, 4, 5];
  // const listItems = numbers.map((number) =>
  //   <li>{number}</li>
  // );

  // return(
  //   <ul id="twitter-feed">
  //     {listItems}
  //   </ul>
  // )

  // return(
  //   <>
  //     <p>test</p>
  //     <ul id="twitter-feed">
  //       <li>1</li>
  //       <li>1</li>
  //     </ul>
  //   </>
  // )

  // const numbers = [1, 2, 3, 4, 5];
  // const listItems = numbers.map((number) =>
  //   <li>{number}</li>
  // );

  // return(
  //   <ul id="twitter-feed">
  //     {listItems}
  //   </ul>
  // );

  // return(
  //   <ul id="twitter-feed">
  //     <Tweet
  //       tweet = {data}
  //     />
  //   </ul>
  // );
};

export default TwitterFeed;

{/* <>
    <p>test</p>
    <u id="twitter-feed">
      {tweetData.map(tweet => {
        return <Tweet tweet={tweet} />
      }}
    </ul>
    </> */}