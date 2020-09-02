// src/components/Grocery.js
import React from 'react';

const Grocery = props => {
  return(
    <li className="grocery-item">
      {props.name}<button onClick={props.handleClick}>Delete</button>
    </li>
  );
};

export default Grocery;