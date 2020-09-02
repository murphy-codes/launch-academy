import React from 'react'

import Review from "./Review"

const ReviewList = (props) => {
  const reviews = props.reviews.map(review => {
    return <Review reviewData={review} key={review.id} />
  });
  if (reviews.length === 0) {
    return(
      <p>This restaurant has no reviews yet. Be the first to add one!</p>
    )
  }
  return(
    <div>
      {reviews}
    </div>
  )
}

export default ReviewList
