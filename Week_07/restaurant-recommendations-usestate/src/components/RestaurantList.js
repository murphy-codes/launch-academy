import React from 'react'

import Restaurant from "./Restaurant"

const RestaurantList = (props) => {
  const restaurant = props.restaurants.map(restaurant => {
    const handleClick = () => {
      if (props.activeRestaurantId === restaurant.id) {
        props.setActiveRestaurantId (null);
      } else {
        props.setActiveRestaurantId(restaurant.id);
      }
    }
    let selected = ""
    if (props.activeRestaurantId === restaurant.id) {selected = " selected";}
    return <Restaurant 
      restaurantData={restaurant} 
      key={restaurant.id} 
      handleClick={handleClick} 
      selected={selected} 
    />
  });
  return(
    <div>
      {restaurant}
    </div>
  )
}

export default RestaurantList