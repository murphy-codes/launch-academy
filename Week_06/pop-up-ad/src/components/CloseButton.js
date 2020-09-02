// src/components/Popup.js
import React from "react"

const CloseButton = props => {
  // const hideElement = elementId => {
  //   document.getElementById(elementId).style.display = "none"
  // };

  return (
    <button type="button"><i className="fas fa-times"></i></button>
    // <button onClick={hideElement(props.buttonClick)} type="button"><i className="fas fa-times"></i></button>
  );
};

export default CloseButton;