import React from 'react'

const Restaurant = (props) => {
  const wrapperClassName = `grid-x grid-margin-x grid-padding-y${props.selected}`
  return(
    <div className={wrapperClassName} onClick={props.handleClick}>
      <h3></h3>
      <div className="cell">
        <img src={props.restaurantData.image} alt={props.restaurantData.name} />
      </div>

      <div className="cell">
        <p>
          <a href="#">
            <strong>{props.restaurantData.name}</strong>
          </a>
        </p>

        <p>{props.restaurantData.location}</p>
      </div>

    </div>
  )
}

export default Restaurant
