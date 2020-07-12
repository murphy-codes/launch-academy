import createNewMusical from './createNewMusical.js';
import createNewSong from './createNewSong.js';

let phantom = createNewMusical('The Phantom of the Opera', 'Andrew Lloyd Webber', 7);
let hamilton = createNewMusical('Hamilton', 'Lin Manuel Miranda', 11);
console.log(phantom);
console.log(hamilton);

let allIAsk = createNewSong('All I Ask of You', ['Raoul', 'Christine'], '4:11');
let masquerade = createNewSong('Masquerade', ['Andre', 'Firmin', 'Company'], '5:32');

phantom.addSong(allIAsk);
phantom.addSong(masquerade);
console.log(phantom.songs);