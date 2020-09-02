import React, { useState } from 'react';
import PlaylistContainer  from "./PlaylistContainer";
import SongListContainer  from "./SongListContainer";

const App = (props) => {
  const [selectedPlaylist, setSelectedPlaylist] = useState(null)
  let activePlaylist = null;
  if(selectedPlaylist) activePlaylist = props.data.playlists.find(playlist => playlist.id === selectedPlaylist);
  // turn into ternary later
  return (
    // <div className="centered">
      <div className="grid-container app">
        <h1 className="title">React Music Player</h1>
        <div id="main">
          <PlaylistContainer 
            selectedPlaylist={selectedPlaylist}
            setSelectedPlaylist={setSelectedPlaylist}
            playlists={props.data.playlists}
          />
          <SongListContainer
            activePlaylist={activePlaylist}
            songs={props.data.songs} 
          />
        </div>
      </div>
    // </div>
  );
};

export default App;