const createNewMusical = (title, composer, numberOfTonys, songs = []) => {
  let jsonNewMusical = {
    title, 
    composer, 
    numberOfTonys,
    songs,
    addSong: (song) => {
      jsonNewMusical.songs.push(song);
    }
  };
  return jsonNewMusical;
};

// export our function so it can be imported in other files
export default createNewMusical;