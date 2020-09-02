import React, { useState } from 'react';
import RandomSprout from './RandomSprout';
import SproutsIndex from './SproutsIndex';

const SproutsContainer = (props) => {
  const [recipe, setRecipe] = useState("")
  const [recipes, setRecipes] = useState([])

  const getRandomRecipe = () => {
    // YOUR FETCH CALL HERE
  }

  const getAllRecipes = () => {
    // YOUR FETCH CALL HERE
  }

  const handleRandomClick = () => {
    getRandomRecipe();
  }

  const handleIndexClick = () => {
    getAllRecipes();
  }

  return(
    <div className="container">
      <h1>Sprout Fetcher</h1>
      <RandomSprout
        recipe={recipe}
      />
      <SproutsIndex
        recipes={recipes}
      />

      <div className="buttons">
        <button onClick={handleRandomClick} className="btn">Get Random Recipe</button>

        <button onClick={handleIndexClick} className="btn">See All Recipes</button>
      </div>
    </div>
  )
}

export default SproutsContainer;
