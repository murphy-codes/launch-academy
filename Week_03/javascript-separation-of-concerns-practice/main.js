import Team from './Team.js'
import Player from './Player.js'
import Coach from './Coach.js'

let drogba = new Player(
  'Didier Drogba',
  11,
  'Striker'
)
let alonso = new Player(
  'Marcos Alonso',
  3,
  'Left back'
)
let messi = new Player(
  'Lionel Messi',
  10,
  'Forward'
)
let ronaldo = new Player(
  'Cristiano Ronaldo',
  7,
  'Forward'
)

let lampard = new Coach('Frank Lampard', 2019)
let setién = new Coach('Quique Setién', 2000)
let sarri = new Coach('Maurizio Sarri', 2000)

let chelsea = new Team('Chelsea', lampard, [drogba, alonso])
let barcelona = new Team('Barcelona', setién, [messi])
let juventus = new Team('Juventus', sarri)
juventus.signPlayer(ronaldo)

lampard.gameOver("w")
setién.gameOver("d")
sarri.gameOver("l")

drogba.score();
drogba.score();
drogba.assist();
alonso.score();
messi.assist();
messi.score();
ronaldo.assist();
ronaldo.redCard();

console.log(`\n${drogba.name}'s stats:\n  `, drogba.stats);
console.log(`${alonso.name}'s stats:\n  `, alonso.stats);
console.log(`${messi.name}'s stats:\n  `, messi.stats);
console.log(`${ronaldo.name}'s stats:\n  `, ronaldo.stats);

console.log(`\n${chelsea.coach.name} is the head coach for ${chelsea.name}.`)
console.log(`${lampard.name.split(" ")[0]}'s stats:\n  `, lampard.stats)
console.log(`${barcelona.coach.name} is the head coach for ${barcelona.name}.`)
console.log(`${setién.name.split(" ")[0]}'s stats:\n  `, setién.stats)
console.log(`${juventus.coach.name} is the head coach for ${juventus.name}.`)
console.log(`${sarri.name.split(" ")[0]}'s stats:\n  `, sarri.stats)