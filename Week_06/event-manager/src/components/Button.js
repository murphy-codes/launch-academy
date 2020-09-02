import React from 'react';

const Button = props => {
  return (
    <div>
      <i className={props.className} onClick={props.handleClick}></i>
    </div>
  );
};

export default Button;