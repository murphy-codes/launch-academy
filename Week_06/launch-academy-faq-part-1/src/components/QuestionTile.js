import React from 'react';

const QuestionTile = (props) => {
  return (
    <div className="small-12 columns tile" onClick={props.handleClick}>
      <i className={`fa fa-${props.visible ? "minus-square green" :"plus-square"} icon`} aria-hidden="true"></i>
      <span className={`question${props.visible ? " green" : ""}`}>{props.question}</span>
      {props.visible ? <p>{props.answer}</p> : null}
    </div>
  )
}

export default QuestionTile;