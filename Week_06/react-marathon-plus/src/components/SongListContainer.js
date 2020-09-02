import React, { useState } from "react";
import SongTile from "./SongTile";

const SongListContainer = (props) => {
  const [selectedSong, setSelectedSong] = useState(null)
  const songListCollection = props.songs.map(song => {
    const handleClick = () => {
      if (selectedSong === song.id) {
        setSelectedSong(null);
      } else {
        setSelectedSong(song.id);
      }
    }
    let className = (selectedSong === song.id) ? "selected" : "";
    if (props.activePlaylist === null || props.activePlaylist.songs.includes(song.id)) {
      return (
        <SongTile
        key={song.id}
        album={song.album}
        artist={song.artist}
        name={song.name}
        handleClick={handleClick}
        className={className}
        />
      );
    }
  });
  
  return (
    <div className="columns small-6">
      <h2>Songs</h2>
      {songListCollection}
    </div>
  );
};

export default SongListContainer;

// key={playlist.id}
// playlist={playlist}
// handleClick={handleClick}
// className={className}