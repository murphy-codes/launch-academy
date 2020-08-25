import Person from './Person.js';
import Car from './Car.js';
import Plane from './Plane.js';
import Card from './Card.js';
import Deck from './Deck.js';
import Author from './Author.js';
import Book from './Book.js';
import Company from './Company.js';
import Game from './Game.js';

let mario = new Person('Mario', 26);
console.log(mario);
console.log(`${mario.name} is ${mario.age}.`);
mario.celebrateBirthday();
console.log(`${mario.name} is ${mario.age}.\n`);

// add our "Toyota Camry" with a mileage of 5000
let car = new Car('Toyota', 'Camry', 5000);
console.log(car);
console.log(`Our car's mileage is ${car.mileage}.`);
car.drive(467);
console.log(`Our car's mileage is ${car.mileage}.\n`);

// add our "Launch 783" plane with a capacity of 2
let plane = new Plane('Launch', '783', 2);
console.log(plane);
plane.board();
plane.board();
plane.board();
console.log();

// create a "10 of diamonds" card and add it to a new deck
let card = new Card('10', 'diamonds');
console.log(card);
let deck = new Deck();
console.log(deck);
deck.addCard(card);
console.log(deck);
console.log(deck.cards);
console.log();

// create a new author and add some new books to their anthology
let author = new Author('Jim', 'Butchcode', 'Code Fantasy');
console.log(author);
console.log(author.anthology);
let book = new Book('The JavaScript Files', 404, 2020);
author.writeBook(book);
console.log(author.anthology);
console.log();

// create a new (gaming) company, hire some employees, and make a game
let company = new Company('', 'Palo Alto, CA', 25)
console.log(company);
console.log(company.employeeCount);
company.hire(10);
console.log(company.employeeCount);
let game = new Game('Pizza Puzzlers 3', 'Strategy', 'E')
console.log(game);
console.log(company.games);
company.makeGame(game);
console.log(company.games);