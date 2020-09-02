// src/components/App.js
import React from "react"
import GroceryList from "./GroceryList"

const App = props => {
  const groceryData = [
    { id: 1, name: "Oranges" },
    { id: 2, name: "Bananas" },
    { id: 3, name: "Bread" }
  ]

  return (
    <>
      <h1>Grocery List</h1>

      <GroceryList
        groceries={groceryData}
      />
    </>
  )
}

export default App