let arrayFromRange = (min, max) => {
    let result = [];
    let i = min;
    while (i <= max){
        result.push(i);
        i++;
    }
    return result;
};

console.log(arrayFromRange(3, 7));