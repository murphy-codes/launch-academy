/* 
Launch Academy
Assignment: High Card Dealer JS
Author: Tom Murphy
Last Edited: 2020-07-02 13:57 PT

The game class takes in the following arguments with these default values: 
  players = 2, handSize = 4, numberOfDecks = 1

It then generates cards to fill the deck(s), shuffles, 
and deals cards to each player. 

The player with the highest hand total value wins.
Ties are announced, listing all players who tied for the highest value.

Face card values are: 
  Jack = 11, Queen = 12, King = 13, Ace = 14
*/

import Game from './Game.js'

const game = new Game(4, 7, 3);
game.play();