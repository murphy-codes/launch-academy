import React from 'react';
import QuestionContainer from "./QuestionContainer";

const App = (props) => {
  return(
    <div className="app row">
      <h1 className="header">We're here to help</h1>
      <QuestionContainer data={props.data} />
    </div>
  )
}

export default App;