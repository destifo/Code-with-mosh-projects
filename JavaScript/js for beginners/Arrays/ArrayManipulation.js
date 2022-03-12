//Adding Elements
const numbers = [4];

numbers.push(5, 6);

console.log(numbers);

console.log("======");

numbers.unshift(2, 3);

console.log(numbers);
console.log("======");

numbers.splice(2, 0, 'c', 'd');

console.log(numbers)


//Finding Elements(primitives)
const arr1 = [1, 2, 3, 1];

console.log(arr1.indexOf(1));
console.log(arr1.indexOf(1, 1));
console.log(arr1.lastIndexOf(1));
console.log(arr1.includes(1));


//Finding Elements(Reference Types)
const courses = [
    {id:1, name: 'a'},
    {id:2, name: 'b'}
];

console.log(courses.find(function(course){
    return course.name === 'a';
}));

let courseIndex = courses.findIndex(function(course){//predicate function
    return course.name === 'a';
})

let otherCourseIndex = courses.findIndex(course => course.name === 'a');//arrow function


//Removing elements
arr1.pop();//delete last
arr1.shift();//delete first
arr1.splice(2, 1);//delete at the middle


//Emptying array
arr2 = [1, 2, 3];

arr2.length = 0;//solution 1

arr2.splice(0, arr2.length);//solution 2


//Combining and Slicing arrays
const combd = arr1.concat(arr2);

const slcd = arr1.slice(1, 2);

const combd2 = [...arr1, 'a', ...arr2];
const copy = [...combd2];


//Iterating Array using foreach
arr1.forEach((number, index) => {
    console.log(index, ':', number);
});


//joining Arrays
const joined = arr1.join('-');// '-' is a separator


//Spliting Strings
let sentence = "Time flows differently for those who try";
const splitted = sentence.split(' '); //split using white space as a separator


//Sorting reference type arrays
courses.sort((a, b) => {
    let nameA = a.name.toUpperCase();
    let nameB = b.name.toUpperCase();

    if (nameA < nameB)  return -1 ;
    if (nameA > nameB)  return 1;
    if (nameA === nameB)    return 0;
});


//testing elements of an array
let nums = [1, 2, -3, 4, 6];

let isAllPositive = nums.every(function(value){
    return value >= 0;
});//terminates if it finds one negative value

let isOnePositive = nums.some(value => value >= 0);//terminates if it finds one positive value


//Filtering an Array
let filtered = nums.filter(value => value >= 0);//elements satisfying the condition are copied to the filtered array


//Mapping an array
let mappedItems = nums.map(function(value) {
    return '<li>' + value + '</li>';
});
const html = "<ul>" +  mappedItems.join('') + '</ul>';

let mappedObj = nums.map(value => ({value}));//when returning an obj in an arrowed functions, use brackets just like ({value}) or the arrow function will inteprate the curly braces as block of code and we will have a non working code.