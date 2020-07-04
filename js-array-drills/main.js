/* 
Launch Academy
Assignment: JS Array Drills
Author: Tom Murphy
Last Edited: 2020-06-23 18:52 PT
*/


let teachers = ["Arrington", "Kincart", "Alberts", "Pickett"]

let rooms = [
  ["Andy", "Rodolfo", "Lynn", "Talia"],
  ["Al", "Ross", "Jorge", "Dante"],
  ["Nick", "Kim", "Jasmine", "Dorothy"],
  ["Adam", "Grayson", "Aliyah", "Alexa"]
]

//List all the teachers with an even index number (including 0)
let evenIndex = (faculty = teachers) => {
  let evenIndexTeachers = []
  for (i = 0; i < faculty.length; i+=2) {
    evenIndexTeachers.push(faculty[i]);
  }
  return evenIndexTeachers.join(", ");
}
console.log(`The even-index teachers are: ${evenIndex(teachers)}.`);

//List all of the teachers with the letter i in their name
let iInName = (faculty = teachers) => {
  let iInNameTeachers = [];
  for (i = 0; i < faculty.length; i++) {
    if (faculty[i].includes("i")) {iInNameTeachers.push(faculty[i]);}
  }
  return iInNameTeachers.join(", ");
}
console.log(`The even-index teachers are: ${iInName(teachers)}.`);

//Return the number of teachers
let teacherCount = (faculty = teachers) => {
  return faculty.length;
}
console.log(`The current number of teachers is: ${teacherCount(teachers)}.`)

//Return the number of rooms of students
let roomCount = (classes = rooms) => {
  return classes.length;
}
console.log(`There are currently ${roomCount(rooms)} classes.`)

//Return the number of students in all the rooms
let studentCount = (classes = rooms) => {
  let pupilCount = 0;
  classes.forEach(classroom => {
    pupilCount+=classroom.length;
  });
  return pupilCount;
}
console.log(`There are currently ${studentCount(rooms)} total students enrolled among all classes.`)

//Return the students who have an i in their names
let whichStudents = (classes = rooms) => {
  let iInNameStudents = [];
  classes.forEach(roster => {
    roster.forEach(student => {
      if (student.includes("i")) {iInNameStudents.push(student);}
    });
  });
  return iInNameStudents.join(", ");
}
console.log(`The students who have an 'i' in their name are  ${whichStudents(rooms)}.`)

//Return the teacher who has the given student in their room
let whichTeacher = (student, faculty = teachers, classes = rooms) => {
  for (i = 0; i < classes.length; i++) {
    if (classes[i].includes(student)) {return faculty[i];}
  }
  return "unknown";
}
console.log(`The teacher who has Jorge is ${whichTeacher("Jorge")}.`)
console.log(`The teacher who has Alexa is ${whichTeacher("Alexa")}.`)