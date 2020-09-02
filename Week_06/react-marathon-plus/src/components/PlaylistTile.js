import React from "react"

const PlaylistTile = (props) => {
  return (
    <p className={props.className} onClick={props.handleClick}>{props.playlist.name}</p>
  );
};

export default PlaylistTile