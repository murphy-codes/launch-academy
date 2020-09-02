import React from "react";

const SongTile = (props) => {
  return (
    <p className={props.className} onClick={props.handleClick}>{props.artist} - {props.name}</p>
  );
};

export default SongTile;