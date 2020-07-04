/* 
Launch Academy
Assignment: JavaScript Objects Marathon
Author: Tom Murphy
Last Edited: 2020-07-03 20:07 PT
*/

const createNewCrewMember = (name, trained = false) => {
  let jsonNewMember = {
      name,
      trained,
      setTrained: (training) => {
        jsonNewMember.trained = training;
      }
  };
  return jsonNewMember;
};

// export our function so it can be imported in other files
export default createNewCrewMember;