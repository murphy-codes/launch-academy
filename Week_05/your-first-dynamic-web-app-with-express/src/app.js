import express from 'express';
import logger from 'morgan';
import bodyParser from 'body-parser';
import path from 'path';

const app = express();

const root = path.resolve() + "/src/public/";
app.use(logger('dev'));
app.use(bodyParser.urlencoded({ extended: false }));
app.use(express.static(new URL('../public', import.meta.url).pathname));

//your code here
app.get('/', (req, res) => {
  res.send(`<h1>Welcome One and All to My First Express Website!</h1><p>Express.js, ` +
  `or simply Express, is a web application framework for Node.js, released as free ` +
  `and open-source software under the MIT License. It is designed for building web ` +
  `applications and APIs. It has been called the de facto standard server framework ` +
  `for Node.js.<br><br>The original author, TJ Holowaychuk, described it as a Sinatra-` +
  `inspired server, meaning that it is relatively minimal with many features available ` +
  `as plugins. Express is the back-end component of the MEAN stack, together with the ` +
  `MongoDB database software and AngularJS front-end framework.<br><br>- ` +
  `<a href="https://en.wikipedia.org/wiki/Express.js">Wikipedia, Express.js</a></p>`);
});

app.get("/greeting/", (req, res) => {
    // res.status(404).send("Name Not Found");
    res.sendFile(`${root}404.html`);
});

app.get("/greeting/:name", (req, res) => {
  const name = req.params.name.toLowerCase();
  if (!req.query.lang || req.query.lang === "en") {
    res.send(`Hi, ${name}!`);
  } else if (req.query.lang === "es") {
    res.send(`Hola, ${name}!`); 
  } else if(req.query.lang === "fr") {
    res.send(`Salut, ${name}!`);
  } else {
    // res.status(404).send("Language Not Found");
    res.sendFile(`${root}404.html`);
  };
});

app.get("/until-next-time/:name", (req, res) => {
  const name = req.params.name.toLowerCase();
  if (!req.query.lang || req.query.lang === "en") {
    res.send(`Good Bye, ${name}!`);
  } else if (req.query.lang === "es") {
    res.send(`Adiós, ${name}!`); 
  } else if(req.query.lang === "fr") {
    res.send(`Au revoir, ${name}!`);
  } else {
    // res.status(404).send("Language Not Found");
    res.sendFile(`${root}404.html`);
  };
});

app.get("/favorite-colors/:name", (req, res) => {
  const favoriteColors = {
    Sam: "Red",
    John: "Green",
    Sally: "Blue",
    Nick: "Gray"
  };
  const name = req.params.name[0].toUpperCase() + req.params.name.slice(1).toLowerCase();
  if (favoriteColors.hasOwnProperty(name)) {
    res.send(`<span style="color: ${favoriteColors[name]};">${name}</span>'s favorite ` +
    `color is <span style="color: ${favoriteColors[name]};">${favoriteColors[name]}</span>.`);
  } else {
    // res.status(404).send("Friend Not Found");
    res.sendFile(`${root}404.html`);
  };

  if (!req.query.lang || req.query.lang === "en") {
    res.send(`Good Bye, ${name}!`);
  } else if (req.query.lang === "es") {
    res.send(`Adiós, ${name}!`); 
  } else if(req.query.lang === "fr") {
    res.send(`Au revoir, ${name}!`);
  } else {
    // res.status(404).send("Language Not Found");
    res.sendFile(`${root}404.html`);
  };
});

app.get('/404', function(req, res){
  res.sendFile(`${root}404.html`);
});

app.get('*', function(req, res){
  res.sendFile(`${root}404.html`);
});

app.listen(3000, '0.0.0.0', () => {
  console.log('Server is listening...');
});

export default app;