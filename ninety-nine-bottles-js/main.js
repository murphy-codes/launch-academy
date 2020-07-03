function singBottles(remaining){
  let lyrics;
  if (remaining === 0) {
    // 0 bottles remaining
    lyrics = `No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.`;
  } else if (remaining === 1) {
    // 1 bottle remaining
    lyrics = `${bottles} bottle of beer on the wall, ${bottles} bottle of beer.\nTake one down and pass it around, no more bottles of beer on the wall.\n\n`;
  } else if (remaining === 2) {
    // 2 bottles remaining
    lyrics = `${bottles} bottles of beer on the wall, ${bottles} bottles of beer.\nTake one down and pass it around, ${bottles-1} bottle of beer on the wall.\n\n`;
  } else if (remaining % 10 === 0) {
    // 10th bottle!
    lyrics = `${bottles} bottles of beer on the wall, ${bottles} bottles of beer!\nTake one down and pass it around, ${bottles-1} bottles of beer on the wall.\n\n`;
  } else {
    lyrics = `${bottles} bottles of beer on the wall, ${bottles} bottles of beer.\nTake one down and pass it around, ${bottles-1} bottles of beer on the wall.\n\n`;
  }
  return lyrics;
}

let bottles = 99;

while (bottles >= 0) {
  console.log(singBottles(bottles));
  bottles--;
}