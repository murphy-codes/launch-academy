import React, { useState } from "react";
import PlaylistTile from "./PlaylistTile";

const PlaylistContainer = props => {
  const playlistCollection = props.playlists.map(playlist => {
    const handleClick = () => {
      if (props.selectedPlaylist === playlist.id) {
        return props.setSelectedPlaylist  (null);
      }
      return props.setSelectedPlaylist(playlist.id);
    }
    let className = (props.selectedPlaylist === playlist.id) ? "selected" : "";
    return (
      <PlaylistTile 
        key={playlist.id}
        playlist={playlist}
        handleClick={handleClick}
        className={className}
      />
    );
  });

  return(
    <div className="columns small-6">
      <h2>Playlists</h2>
      {playlistCollection}  
    </div>
  );
};

export default PlaylistContainer;