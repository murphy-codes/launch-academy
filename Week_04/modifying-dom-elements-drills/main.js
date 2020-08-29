console.log("Step 01 ----------------------------------------");
// Print to the console the text of any elements with a class of oh-no
Array.from(document.getElementsByClassName("oh-no")).forEach(element => { console.log(element.innerText);});

//Alternate approach to iterating through the elements
// var list = document.getElementsByClassName("oh-no");
// for (let item of list) {
//     console.log(item.innerText);
// }

console.log("\nStep 02 ----------------------------------------");
// Print to the console the tag name of the element with an id of hashtag-inspiration
let hashtagInspirationId = document.getElementById("hashtag-inspiration");
let hashtagInspirationClass = document.getElementsByClassName("hashtag-inspiration");
console.log(hashtagInspirationId ? hashtagInspirationId.tagName : `There is no element w/ the ` + 
  `ID "hashtag-inspiration", but there is/are ` + 
  `${hashtagInspirationClass.length} element(s) with a class of "hashtag-inspiration". ` + 
  `The tag name of the first element is <${hashtagInspirationClass[0].tagName}>.`);

console.log("\nStep 03 ----------------------------------------");
// Print to the console the HTML contained within any elements with a class of tv
Array.from(document.getElementsByClassName("tv")).forEach(element => { console.log(element.innerHTML);});

console.log("\nStep 04 ----------------------------------------");
// Reluctantly fix the typo "Never gonna run around and dessert you" to "Never gonna run around and desert you", where "desert" has one s
document.getElementsByClassName("intentional-misspelling-of-desert")[0].innerHTML = "Never gonna run around and desert you";
console.log("        See index.html within the browser.");

console.log("\nStep 05 ----------------------------------------");
// Replace the text in the fourth child of the element with an id of purple-jaguar-eye with lyrics of your choosing
document.getElementById("purple-jaguar-eye").children[3].innerText = "And you're free, free inside your own hell";
console.log("        See index.html within the browser.");

console.log("\nStep 06 ----------------------------------------");
// Turn each <h2> into an <h3>
document.querySelectorAll("h2").forEach(element => {
  let newElement = document.createElement("h3");
  newElement.innerHTML = element.innerHTML;
  element.id ? newElement.id = element.id : '';
  element.className ? newElement.className = element.className : '';
  element.parentElement.replaceChild(newElement, element);
});
console.log("        See index.html within the browser.");

console.log("\nStep 07 ----------------------------------------");
// Add a class of scary-thoughts to the element with an id of woof
document.getElementById("woof").className = "scary-thoughts";
// It would be better to check if there are already classes associated with this element, before changing adding to
console.log("        See index.html within the browser.");

console.log("\nStep 08 ----------------------------------------");
// Add an image of a fish as the last child of the element with an id of she's-the-one-for-me
let fishImg = document.createElement('img');
fishImg.alt = "ADA compliant fish des";
fishImg.src = "https://upload.wikimedia.org/wikipedia/commons/thumb/1/10/" + 
  "Pictograms-nps-water-fish_hatchery.svg/240px-Pictograms-nps-water-fish_hatchery.svg.png";
fishImg.height = fishImg.width = "72";
document.getElementById("shes-the-one-for-me").appendChild(fishImg);
console.log("        See index.html within the browser.");

console.log("\nStep 09 ----------------------------------------");
// Delete the class rickroll from the div that also contains the class limerickroll
document.getElementsByClassName("rickroll limerickroll")[0].className = "limerickroll";
// This approach doesn't take into consideration the possibility of a third associated class
console.log("        See index.html within the browser.");

console.log("\nStep 10 ----------------------------------------");
// Add your own lyrics as the last child of the element with an id of lyrics
let newLyrics = document.createElement('p');
newLyrics.innerText = "Where is my mind?";
document.getElementById("lyrics").appendChild(newLyrics);
console.log("        See index.html within the browser.");

console.log("\nStep 11 ----------------------------------------");
// Add a new paragraph explaining what your favorite song is as the last child of <body>
let favoriteSongs = document.createElement('p');
favoriteSongs.innerHTML = `I'm not sure I have a singular favorite song. <br>But, off the top ` + 
  `of my head, I have some favorites that I can think of:<br><a href="https://www.youtube.com/` + 
  `watch?v=49FB9hhoO6c">The Pixies - Where is my Mind?</a><br><a href="https://www.youtube.com/` + 
  `watch?v=4N3N1MlvVc4">Gary Jules - Mad World (Tears for Fears cover)</a><br><a href="https://` + 
  `www.youtube.com/watch?v=X_ERojefULE">Worlds Away - Summer at Shatter Creek<a><br><a href="` + 
  `https://www.youtube.com/watch?v=Z3MDtACX3-s">Aesop Rock - Daylight</a><br><a href="https://` + 
  `www.youtube.com/watch?v=-rwd8S1UNA0">Aesop Rock - 9-5ers Anthem</a></br><a href="https://www` + 
  `.youtube.com/watch?v=3pshmKlWWjs">Immortal Technique - Harlem Streets</a><br></br>`;
document.getElementsByTagName("body")[0].appendChild(favoriteSongs);
console.log("        See index.html within the browser.");


console.log("\nStep 12 ----------------------------------------");
// Add an attribute called foo, with a value of bar, to each child of the element with a class of rickroll
Array.from(document.getElementsByClassName("rickroll")[0].children).forEach(element => { element.setAttribute("foo", "bar");});
console.log("        See index.html within the browser.");