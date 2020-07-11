let username = prompt("Please enter a username of 6 characters or more.")

while(!username || username.length < 6) {
  if(username === null) {
    username = prompt(`Please click "OK" after entering your username`)
  } else {
    if(username.length === 0) {
      username = prompt(`Please enter a username before clicking "OK"`)
    } else {
      username = prompt(`Please be sure to enter a username of 6 characters or more.`)
    }
  }
}

console.log(`Hi there, ${username}!`)