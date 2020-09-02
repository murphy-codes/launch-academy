// import { ProgressPlugin } from 'webpack';
import React from 'react';

// const Tweet = props => {
//   return (
//     <li id={props.id}>
//       {props.tweet.user.name}
//     </li>
//   );
// };

const Tweet = props => {
  return (
  <li>test {props.tweetData.tweet.user.name}</li>
  );
};

export default Tweet;