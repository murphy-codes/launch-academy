import React, { useState } from 'react';

const ReviewForm = (props) => {
  const emptyReview = {
    restaurant_id: "",
    name: "",
    rating: "",
    content: ""
  }

  let [newReview, setNewReview] = useState(emptyReview);

  const handleInputChange = (event) => {
    setNewReview({
      ...newReview,
      [event.currentTarget.name]: event.currentTarget.value
    });
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    newReview["id"] = props.latestReviewId+1
    if (props.activeRestaurantId) { newReview["restaurant_id"] = props.activeRestaurantId }
    props.handleFormSubmission(newReview);
    setNewReview(emptyReview)
  }

  let restaurantSelection;
  if (props.activeRestaurantId) {
    restaurantSelection = (
      <input 
        className="greyed-out"
        name="restaurant_id" 
        value={props.restaurantNames.find(restaurant => restaurant.id === props.activeRestaurantId).name} 
        type="text"
        readonly
      />
    )
  } else {
    const restaurants = (
      <>
        <option value="" disabled defaultValue>Select your option</option>
        {
          props.restaurantNames.map(restaurant => {
            return (
              <option key={restaurant.id} value={restaurant.id}>
                {restaurant.name}
              </option>
            )
          })
        }
      </>
    )
    restaurantSelection = (
      <select name="restaurant_id" onChange={handleInputChange} value={newReview.restaurant_id}>{restaurants}</select>
    )
  }

  return(
    <form onSubmit={handleSubmit}>
      <label>
        Restaurant:
        {restaurantSelection}
      </label>
      <label htmlFor="name">Enter your name: </label>
      <input 
        name="name"
        value={newReview.name} 
        type="text" 
        onChange={handleInputChange}
      />
      
      <label htmlFor="rating">Enter your rating: </label>
      <input 
        name="rating" 
        value={newReview.rating} 
        type="number" 
        min="0"
        max="100"
        onChange={handleInputChange}
      />
      
      <label htmlFor="content">Enter your review: </label>
      <input 
        name="content" 
        value={newReview.content} 
        type="text" 
        onChange={handleInputChange}
      />

      <input type="submit" value="Submit your review!" />
    </form>
  )
}

export default ReviewForm