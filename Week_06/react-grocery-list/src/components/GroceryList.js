// src/components/GroceryList.js
import React, { useState } from 'react';
import Grocery from './Grocery';

const GroceryList = props => {
  const [deletedGroceryIds, setDeletedGroceryIds] = useState([]);

  const groceryList = props.groceries.map(grocery => {
    if(!deletedGroceryIds.includes(grocery.id)) {
      const handleClick = () => {
        setDeletedGroceryIds(deletedGroceryIds => [...deletedGroceryIds, grocery.id])
      };
      return (
        <Grocery
          key={grocery.id}
          name={grocery.name}
          handleClick={handleClick}
        />
      );
    };
  });

  return (
    <ul>
      {groceryList}
    </ul>
  );
};

export default GroceryList;