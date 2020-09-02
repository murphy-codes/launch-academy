// src/components/EventTile.js
import React, { useState } from 'react';

const EventTile = props => {
  let dressCode;
  // might be cleaner to use case here
  if (props.eventType === "business") {
    dressCode = "blue";
  } else if (props.eventType === "business-casual") {
    dressCode = "pink";
  } else { // (props.eventType === "personal")
  dressCode = "green";
  }

  const [completed, setCompleted] = useState(false);
  const handleClick = () => {
    setCompleted(!completed);
  }

  let eventTextClassName = "event-text";
  let iconType = "fa-check-square";
  if(completed) {
    dressCode = "grey";
    eventTextClassName += " greyed-out";
    iconType = "fa-window-close";
  };

  return(
    <div className={`event-tile  ${dressCode}-bg`}>
      <h2 className={eventTextClassName}>{props.title}</h2>
      <p className={eventTextClassName}>{props.timePeriod}</p>
      <p className={eventTextClassName}>{props.description}</p>
      <i className={`fa ${iconType} icon`} onClick={handleClick}></i>
    </div>
  );
};

export default EventTile;