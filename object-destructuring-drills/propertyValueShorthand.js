// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// PROPERTY VALUE SHORTHAND
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~

// 1. Create a `browserAwesomeness` object with the below variables as keys, then
// comment in the `console.log` to see the object successfully appear in your console.
let safari = "bad";
let chromeBrowser = "good";
let firefox = "good";
let vivaldi = "awesome to the max";

// your code, here 
let browserAwesomeness = {
  safari,
  chromeBrowser,
  firefox,
  vivaldi
};

// uncomment this next line to check your work!
console.log(browserAwesomeness);

// 2. Create `osAwesomeness` object from these variables; within the same object declaration, also
// add a `linux` key with a value of `"rad, man"`

let macOS = "cool beans";
let windows = "well, I guess not every OS can be MacOS";

// your code, here 
let osAwesomeness = {
  macOS, //can you tell this assignment's creator(s) had a preference for Mac > Linux > Windows (or Linux > Mac > Windows)
  windows,
  linux: "rad, man"
};

// uncomment this next line to check your work!
console.log(osAwesomeness);

// 3. Define the variables needed to create this object
let name = "murphy-codes";
let age = "29 winters";
let numberOfToes = 10;
let numberOfVinDieselMoviesSeen = 11;

// your code, here
let me = {
  name,
  age,
  numberOfToes,
  numberOfVinDieselMoviesSeen,
  isBadassCoder: true
};

console.log(me);

// I added this because I felt like playing with window.navigator and trying to identify the user's agent/browser
let userAgent = navigator.userAgent;
if (userAgent.includes("Chrome")) { 
  console.log("\nOh, sweet, you're on Chrome!\n\n")
} else if (userAgent.includes("Firefox")) {
  console.log("\nWhat does the Firefox say?\n\n")
} else {
  console.log("\nIf you can see this, what browser are you using? Safari? Internet Explorer or Edge? Something else?\n\n")
}