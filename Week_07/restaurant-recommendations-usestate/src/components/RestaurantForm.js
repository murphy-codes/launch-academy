import React, { useState } from 'react';

const ReviewForm = (props) => {
  let [newRestaurant, setNewRestaurant] = useState({
    name: "",
    image: "",
    location: "",
    website: "",
    categories: ""
  });

  const handleInputChange = (event) => {
    setNewRestaurant({
      ...newRestaurant,
      [event.currentTarget.name]: event.currentTarget.value
    });
  };
  const handleSubmit = (event) => {
    event.preventDefault();
    newRestaurant["id"] = newRestaurant.name.toLowerCase().replace(/\s/g, "-")
    props.handleFormSubmission(newRestaurant);
    setNewRestaurant({
      name: "",
      image: "",
      location: "",
      website: "",
      categories: ""
    })
  }
  return(
    <form onSubmit={handleSubmit}>
      <label htmlFor="name">Enter restaurant name: </label>
      <input 
        name="name"
        value={newRestaurant.name} 
        type="text" 
        onChange={handleInputChange}
      />
      
      <label htmlFor="image">Enter restaurant image URL: </label>
      <input 
        name="image"
        value={newRestaurant.image} 
        type="text" 
        onChange={handleInputChange}
      />
      
      <label htmlFor="location">Enter restaurant location: </label>
      <input 
        name="location" 
        value={newRestaurant.location} 
        type="text" 
        onChange={handleInputChange}
      />
      
      <label htmlFor="website">Enter restaurant website: </label>
      <input 
        name="website" 
        value={newRestaurant.website} 
        type="text" 
        onChange={handleInputChange}
      />
        
      <label htmlFor="categories">Enter restaurant categories: </label>
      <input 
        name="categories" 
        value={newRestaurant.categories} 
        type="text" 
        onChange={handleInputChange}
      />

      <input type="submit" value="Add your restaurant!" />
    </form>
  )
}

export default ReviewForm