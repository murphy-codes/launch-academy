const createNewSong = (title, characters, length) => {
  let jsonNewSong = {
    title, 
    characters, 
    length
  };
  return jsonNewSong;
};

// export our function so it can be imported in other files
export default createNewSong;

