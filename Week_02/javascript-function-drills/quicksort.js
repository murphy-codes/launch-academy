/* 
Launch Academy
File: Quicksort
Author: Tom Murphy
Last Edited: 2020-06-26 20:54 PT
*/

//from https://www.guru99.com/quicksort-in-javascript.html
let swap = (items, leftIndex=0, rightIndex=1) => {
  let temp = items[leftIndex];
  items[leftIndex] = items[rightIndex];
  items[rightIndex] = temp;
  return items;
};

let partition = (items, left, right) => {
  let pivot = items[Math.floor((left+right)/2)], //middle element
          i = left, //left pointer
          j = right; //right pointer
  while (i <= j) {
    while (items[i] < pivot) {
      i++;
    };
    while (items[j] > pivot) {
      j--;
    };
    if (i <= j) {
      swap(items, i, j); //swapping two elements
      i++;
      j--;
    };
  };
  return i;
};

let quickSort = (items, left=0, right=items.length-1) => {
  let index;
  if (items.length > 1) {
    index = partition(items, left, right); //index returned from partition
    if (left < index - 1) {//more elements on the left side of the pivot
      quickSort(items, left, index-1);
    };
    if (index < right) {//more elements on the right side of the pivot
      quickSort(items, index, right);
    };
  };
  return items;
};

export {swap, partition, quickSort};