// import React from "react"
import React, { useState } from "react";

const PlaceTile = (props) => {
  const [placeVisited, setPlaceVisited] = useState(false);
  console.log(props)

  const handleClick = () => {
    if (props.id === props.favoritePlaceId) props.flipFavoritePlaceVisited();
    setPlaceVisited(!placeVisited);
  };

  let className;
  if (placeVisited) {
    className = "done";
  }

  return (
    <p className={className} onClick={handleClick}>{props.name}</p>
  );
};

export default PlaceTile;