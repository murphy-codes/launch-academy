// src/components/EventManagementApp.js
import React from 'react';
import EventTile from './EventTile';
import Button from './Button';

const EventManagementApp = props => {
  const events = props.events.map((event, i) => {
    return (
      <EventTile
        key={i+1}
        title={event.title}
        timePeriod={event.timePeriod}
        description={event.description}
        eventType={event.eventType}
      />
    );
  });

  const handleClick = () => {
    alert(`Take one dose of the red pills, two doses of the purple pills. Take one half of your vitamin D supplement (don't take the whole thing!)`);
  };

  return(
    <div className="event-management-app">
    <Button className="fa fa-exclamation-circle icon-dark fa-3x" handleClick={handleClick}/>
      <h1>Now viewing your upcoming events</h1>
      <ul>
        {events}
      </ul>
      <div className="centered">
        <img src="/img/event-manager-dogs.jpg" alt="Three undead doggos" width="504" height="283"></img>
        <p id="inspirational">"The day may be ruff, but we are here for you in spirit!"</p>
      </div>
    </div>
  );
};

export default EventManagementApp;