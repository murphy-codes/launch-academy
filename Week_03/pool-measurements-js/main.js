import Pool from './Pool.js'

let pool1 = new Pool(10, 15)
console.log(`Pool 1 has a width of ${pool1.width}, a length of ${pool1.length},` + 
  ` an area of ${pool1.area()}, and a volume of ${pool1.volume()}.`)

let pool2 = new Pool(12)
console.log(`Pool 1 has a width of ${pool2.width}, a length of ${pool2.length},` + 
  ` an area of ${pool2.area()}, and a volume of ${pool2.volume()}.`)