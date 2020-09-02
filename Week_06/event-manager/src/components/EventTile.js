// src/components/EventTile.js
import React, { useState } from 'react';
import Button from './Button';

const EventTile = props => {
  const backgrounds = {
    "personal" : "green",
    "business-casual" : "pink",
    "business" : "blue"
  }
  let dressCode = backgrounds[props.eventType];

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
      <Button className={`fa ${iconType} icon`} handleClick={handleClick}/>
    </div>
  );
};

export default EventTile;