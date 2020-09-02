import React, { useState } from "react"

import RestaurantForm from "./RestaurantForm"
import RestaurantList from "./RestaurantList"
import ReviewForm from "./ReviewForm"
import ReviewList from "./ReviewList"

import restaurants from "../constants/restaurants"
import reviews from "../constants/reviews"

const App = props => {
  const [reviews, setReviews] = useState(reviews)
  const [restaurants, setRestaurants] = useState(restaurants)
  let [activeRestaurantId, setActiveRestaurantId] = useState(null);

  const handleReviewFormSubmission = payload => {
    setReviews([...reviews, payload]);
  }
  const handleRestaurantFormSubmission = payload => {
    setRestaurants([...restaurants, payload]);
  }

  let activeReviews;
  if (activeRestaurantId) {
    activeReviews = reviews.filter(review => review.restaurant_id === activeRestaurantId)
  } else {
    activeReviews = reviews;
  }

  const restaurantNames = restaurants.map(restaurant => {
    return { id: restaurant.id, name: restaurant.name, }
  });

  return (
    <div className="grid-container">
      <div className="grid-x">
        <div className="restaurants cell small-3">
          <div className="cell">
            <h3>Restaurant Form</h3>
            <RestaurantForm
              handleFormSubmission={handleRestaurantFormSubmission}
            />
          </div>

          <div className="cell below">
            <h3>Restaurants</h3>
            <RestaurantList
              restaurants={restaurants}
              activeRestaurantId={activeRestaurantId}
              setActiveRestaurantId={setActiveRestaurantId}
            />
          </div>
        </div>

        <div className="reviews cell auto">
          <div className="cell">
            <h3>Review Form</h3>
            <ReviewForm 
              handleFormSubmission={handleReviewFormSubmission}
              latestReviewId={reviews[reviews.length-1].id}
              activeRestaurantId={activeRestaurantId}
              restaurantNames={restaurantNames}
            />
          </div>

          <div className="cell below">
            <h3>Reviews</h3>
            <ReviewList
              reviews={activeReviews}
            />
          </div>
        </div>
      </div>
    </div>
  )
}

export default App