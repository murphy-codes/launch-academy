import React, { useState } from "react";
import PlaceTile from "./PlaceTile";

const PlacesContainer = props => {
  const [favoritePlaceVisited, setFavoritePlaceVisited] = useState(false);
  const flipFavoritePlaceVisited = () => {
    console.log(`favoritePlaceVisited has been set to ${!favoritePlaceVisited}`)
    setFavoritePlaceVisited(!favoritePlaceVisited)
  };

  const placesCollection = props.places.map(place => {
    return (
      <PlaceTile 
        key={place.id}
        id={place.id}
        name={place.name}
        favoritePlaceId={props.favoritePlaceId}
        flipFavoritePlaceVisited={flipFavoritePlaceVisited}
      />
    );
  });
  let favoritePlaceSelected = (favoritePlaceVisited) ? "What a beauty!" : "";

  return(
    <div className="columns small-6">
      <h2>Places</h2>
      {placesCollection}  
      <div className="italic bold">{favoritePlaceSelected}</div>
    </div>
  );
};

export default PlacesContainer;