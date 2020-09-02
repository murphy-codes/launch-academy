// src/components/Popup.js
import React from "react"
import CloseButton from "./CloseButton"

const Popup = props => {
  const hideElement = elementId => {
    document.getElementById(elementId).style.display = "none"
  };

  return (
    <>
    {/* ... <i className="fas fa-times"></i> */}
    <div className="popup-box">
      {/* <CloseButton buttonClick={targetId: popup-box}/> */}
      <button type="button" className="close-button"><i className="fas fa-times"></i></button>
      {/* <button onClick={hideElement(props.buttonClick)} type="button"><i className="fas fa-times"></i></button> */}
      <h1>You have won tickets to see Taylor Swift!!</h1>
      <p>Please enter your email so we can send you the tickets</p>
      <form action="./index.html">
        <input type="text" id="email" name="email" placeholder="Your email here" />
        <input type="submit" value="CLAIM YOUR PRIZE!" />
      </form> 
    </div>
    </>
  );
};

export default Popup;