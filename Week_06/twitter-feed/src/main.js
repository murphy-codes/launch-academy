import "./main.scss"
import React from "react"
import ReactDOM from "react-dom"
import TwitterFeed from "./containers/TwitterFeed"
import data from "./constants/data"

// ReactDOM.render(<TwitterFeed data={data} />, document.getElementById("app"))

// alert("test");
// alert(data.length); // = 5

// const tweetData = data.map(tweet, index => {
//   return { id: index, tweet: tweet};
//   // I could probably clean this up to use tweet.id_str as the id
// });

// const numbers = [1, 2, 3, 4, 5];
// const listItems = numbers.map((numbers) =>
//   <li>{numbers}</li>
// );

// ReactDOM.render(
//   <ul>{listItems}</ul>,
//   document.getElementById('app')
// );

// const Tweet = props => {
//   const tweetDataList = props.tweetData.map() => {
//     //
//   };
// };

ReactDOM.render(<TwitterFeed data={data} />, document.getElementById("app"))