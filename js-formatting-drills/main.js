/* 
  Launch Academy
  Assignment: JS Formatting
  Author: Tom Murphy
  Last Edited: 2020-06-15 16:39 PT
*/

var thiefOfTime = `"Some humans would do anything to see if it was possible to do it.<br>
If you put a large switch in some cave somewhere, with a sign on it saying <br>
'End-of-the-World Switch. PLEASE DO NOT TOUCH',<br>
the paint wouldn't even have time to dry"`;

var sourcery = `"I meant," said Ipslore bitterly, "what is there in this world that truly makes living worthwhile?"<br>
<br>
Death thought about it.<br>
<br>
"CATS," he said eventually. "CATS ARE NICE."`;

var mort = `“Albert grunted. "Do you know what happens to lads who ask too many questions?"<br>
Mort thought for a moment.<br>
"No," he said eventually, "what?"<br>
<br>
There was silence.<br>
<br>
Then Albert straightened up and said, "Damned if I know. Probably they get answers, and serve 'em right.”`;

var theWeeFreeMen = `“The stories never said why she was wicked. It was enough to be an old woman, enough to be all alone, enough to look strange because you have no teeth. <br>
<br>
It was enough to be called a witch.<br>
<br>
If it came to that, the book never gave you the evidence of anything.<br>
<br>
It talked about "a handsome prince"...was he really, or was it just because he was a prince that people called handsome? <br>
<br>
As for "a girl who was as beautiful as the day was long"...well, which day? In midwinter it hardly ever got light! <br>
<br>
The stories don't want you to think, they just wanted you to believe what you were told...”`;

var currentQuote = 1;

function previousQuote(event) {
    event.preventDefault();
    currentQuote = wrapQuote(--currentQuote);
    setQuote();
}

function nextQuote(event) {
    event.preventDefault();
    currentQuote = wrapQuote(++currentQuote);
    setQuote();
}

function wrapQuote(qNum) {
    if (qNum < 1) {
        return 4;
    } else if (qNum > 4) {
        return 1;
    } else {
        return qNum;
    }
}

function setQuote() {
    if (currentQuote == 1) {
        $("#quote").html(thiefOfTime);
    } else if (currentQuote == 2) {
        $("#quote").html(sourcery);
    } else if (currentQuote == 3) {
        $("#quote").html(mort);
    } else if (currentQuote == 4) {
        $("#quote").html(theWeeFreeMen);
    } else {
        $("#quote").text("Error. Quote out of bounds.");
    }
    $("#q_num").text(currentQuote);
}

setQuote();
$("#left").on("click", previousQuote);
$("#right").on("click", nextQuote);