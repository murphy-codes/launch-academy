// import React, { useState } from 'react';
import React from 'react';
import PlacesContainer from './PlacesContainer'

const App = (props) => {

  return (
    <div id="wishlist-div">
      <div className="grid-container">
        <div className="small-12 text-center">
          <h3>Wanderlust Wishlist</h3>
          <PlacesContainer
            places={props.data.places}
            favoritePlaceId={props.data.favoritePlaceId}
          />
        </div>
      </div>
    </div>
  )
}

export default App;
