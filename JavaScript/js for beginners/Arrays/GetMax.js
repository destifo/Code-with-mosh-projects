let getMax = (array) => array.reduce((max, value) =>{
    max = (max === undefined || value > max)?value:max;
    return max;
}, undefined);

let getMax2 = (array) => array.reduce((a, b) => (a > b)?a:b);

let max = getMax2([1, 2, 5, 7, 6]);
console.log(max);