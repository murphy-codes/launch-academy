/*
    Team 1 - JustJavaScript
    Rami: 88
    Natoya: 92
    Max: 68
    Lynn: 100

    Team 2 - We Are Ruby
    Sasha: 82
    Mohammed: 98
    Jennifer: 94
    Denise: 92

    calculate the average score for each team and for both teams together
    round the averages to the nearest integer for display
    calculate the number of explorers passing the quiz (grade >= 70%)

    output the results to the console in a readable format.
*/


//establish team names and scores
let Team_1 = 'JustJavaScript';
let Rami = 88;
let Natoya = 92;
let Max = 68;
let Lynn = 100;

let Team_2 = 'We Are Ruby';
let Sasha = 82;
let Mohammed = 98;
let Jennifer = 94;
let Denise = 92;

//put team scores into an array
let team_1_scores = [Rami, Natoya, Max, Lynn];
let team_2_scores = [Sasha, Mohammed, Jennifer, Denise];

//loop through the arrays to sum scors, then divide by the number of explorers on that team
var total1 = 0;
for(var i = 0; i < team_1_scores.length; i++) {
    total1 += team_1_scores[i];
}
var team_1_avg = total1 / team_1_scores.length;

var total2 = 0;
for(var i = 0; i < team_2_scores.length; i++) {
    total2 += team_2_scores[i];
}
var team_2_avg = total2 / team_2_scores.length;

total_avg = (total1 + total2) / (team_1_scores.length + team_2_scores.length);

console.log("The average score for '" + Team_1 + "' is: " + team_1_avg);
console.log("The average score for '" + Team_2 + "' is: " + team_2_avg);
console.log("The average score for both teams is: " + total_avg);

console.log("\nRounding these scores to the nearest integer, we get:");

console.log("'" + Team_1 + "': " + Math.round(team_1_avg)); //rounding isn't actually necessary on this value, but I feel it's still good practice in this situation
console.log("'" + Team_2 + "': " + Math.round(team_2_avg));
console.log("Both teams: " + Math.round(total_avg));

function passingScore(score) {
    if (score >= 70) {
        return true;
    } else {
        return false;
    }
}

let passing = team_1_scores.concat(team_2_scores).filter(passingScore);
console.log("\nThe number of explorers passing the quiz is " + passing.length);