import React, { useState } from 'react';

const ChocolateList = (props) => {
  const [chocolateVisibility, setChocolateVisibility] = useState(true);
  const chocolateClick = () => {
    setChocolateVisibility(!chocolateVisibility);
  };

  const chocolateData = [
    "Cadbury Chocolate Bar",
    "Lindt 90% Dark Chocolate",
    "Hershey's Special Dark",
    "Lily's Sugar Free Chocolate",
    "Crunch",
    "Toblerone"
  ];

  let chocolateListItems;
  if (chocolateVisibility) {
    chocolateListItems = chocolateData.map((chocolate, index) => {
      return(
        <li key={index}>
          {chocolate}
        </li>
      );
    });
  };

  return(
    <div id="chocolate-app">
      <h1 onClick={chocolateClick} id="chocolate-header">CHOCOLATE ONLY CABINET</h1>
      <ul>
        {chocolateListItems}
      </ul>
    </div>
  );
};

export default ChocolateList;
