import express from "express"
import logger from "morgan"
import bodyParser from "body-parser"
import hbsMiddleware from "express-handlebars"
import fs from "fs"
import path from 'path'
import { fileURLToPath } from 'url'

const __filename = fileURLToPath(import.meta.url)
const __dirname = path.dirname(__filename)

const app = express()

// view engine setup
app.set('views', path.join(__dirname, '../views'))
app.engine(
  "hbs",
  hbsMiddleware({
    defaultLayout: "default",
    extname: ".hbs"
  })
)
app.set("view engine", "hbs")

app.use(logger("dev"))
app.use(express.json())

app.use(express.static(path.join(__dirname, '../public')))
app.use(bodyParser.urlencoded({ extended: true }))
app.use(bodyParser.json())

const productsPath = path.join(__dirname, '../products.json')

// read from the products.json file
const productsJson = () => {
  return JSON.parse(fs.readFileSync(productsPath));
};

// validate a new products object
function validateForm(jsonFormInput) {
  // let errors = [];
  const errors = {};
  if (jsonFormInput.featured === undefined) {
    errors.featured = "You must designate if the product is featured.";
  };
  Object.keys(jsonFormInput).forEach(input => {
    if (!jsonFormInput[input].trim()) {
      errors[input] = `You must include a ${input}.`;
    };
  });
  if (isNaN(jsonFormInput["price"])) {
    errors["price"] = "Please designate a numerical price.";
  };
  if (Object.keys(jsonFormInput).length < 4 || Object.keys(errors).length > 0) {
    errors.form = "Please fill out each field.";
  };
  console.log(`Object.keys(jsonFormInput).length = ${Object.keys(jsonFormInput).length}`);
  console.log(`Object.keys(errors).length = ${Object.keys(errors).length}`);
  return errors;
}

// add to the products.json file.
const updateProductsJsonData = (newProductObject) => {
  const products = productsJson();
  newProductObject.featured = newProductObject.featured === "true" ? true : false;
  newProductObject.price = parseFloat(newProductObject.price).toFixed(2);
  products.push(newProductObject);
  fs.writeFileSync(productsPath, JSON.stringify(products));
};

app.get("/", (req, res) => {
  let products = productsJson().filter(product => product.featured)
  res.render('index', { products : products })
})

app.get("/all", (req, res) => {
  res.render('all', { products : productsJson() })
})

app.get("/add", (req, res) => {
  res.render('add')
})

app.post("/add", (req, res) => {
  console.log(`Object.keys(req.body).length = ${Object.keys(req.body).length}`)
  const errors = validateForm(req.body);
  console.log(`Object.keys(req.body).length = ${Object.keys(req.body).length}`)
  if (!Object.keys(errors).length) {
    updateProductsJsonData(req.body);
    res.redirect("/");
  } else {
    let featured = req.body.featured === "true" ? "checked" : "";
    let notFeatured = req.body.featured === "false" ? "checked" : "";
    res.render('add', { errors: errors, product: req.body, featured: featured, notFeatured: notFeatured});
  };
})

app.get("/:productName", (req, res) => {
  const product = productsJson().find(product => product.name === req.params.productName);
  if (product){
    res.render("show", {product : product});
  } else {
    res.status(404).render('404', {error: `product "${req.params.productName}"`});
  }
})

app.get("/delete/:productName", (req, res) => {
  fs.writeFileSync(productsPath, JSON.stringify(productsJson().filter(product => product.name !== req.params.productName)));
  res.redirect("/");
})

app.get('*', async (req, res) => {
  res.status(404).render('404', {error: `Page`});
});

app.listen(3000, "0.0.0.0", () => {
  console.log("Server is listening...")
})

export default app
