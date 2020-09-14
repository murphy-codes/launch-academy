import React from "react"

const StepTile = props => {
  return <li onClick={props.handleClick} className={props.className}>{props.step}</li>
}

export default StepTile