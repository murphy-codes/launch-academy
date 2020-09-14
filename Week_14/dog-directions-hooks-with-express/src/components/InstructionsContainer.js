import React, { useState } from "react"
import StepTile from "./StepTile"
import ItemTile from "./ItemTile"
import FetchButton from "./FetchButton"

const InstructionsContainer = props => {
  const [activity, setActivity] = useState(null); // props.data.activity
  const [supplies, setSupplies] = useState([]); // const supplies = props.data.supplies
  const [directions, setDirections] = useState([]); // const directions = props.data.directions
  const [selectedStepId, setSelectedStepId] = useState(null);

  const fetchData = () => {
    fetch(`/api/v1/favoriteThings.json`)
      .then(response => {
        if (response.ok) {
          return response;
        } else {
          let errorMessage = `${response.status} (${response.statusText})`,
            error = new Error(errorMessage);
          throw (error);
        }
      })
      .then(response => response.json())
      .then(data => {
        setActivity(data.activity);
        setSupplies(data.supplies);
        setDirections(data.directions);
      })
      .catch(error => console.error(`Error in fetch: ${error.message}`));
  }

  const items = supplies.map(supply => {
    return (
      <ItemTile
        item={supply.item}
        key={supply.id}
        id={supply.id}
      />
    )
  })

  const steps = directions.map(direction => {
    let className;
    if (direction.id === selectedStepId) { className = "selected"; }
    const handleClick = () => { setSelectedStepId(direction.id); }
    return (
      <StepTile
        step={direction.step}
        key={direction.id}
        id={direction.id}
        className={className}
        handleClick={handleClick}
      />
    )
  })

  if (activity===null) { return <FetchButton handleClick={fetchData}/> }
  else {
    return (
      <div>
        <h1>How To {activity}</h1>
        <h3>Supplies:</h3>
        <ul>{items}</ul>
        <h3>Instructions:</h3>
        <ol>{steps}</ol>
      </div>
    )
  }
}

export default InstructionsContainer
