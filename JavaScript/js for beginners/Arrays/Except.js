function except(numbers, excluded){
    return numbers.filter(value => !excluded.includes(value));
}

console.log(except([1, 2, 3, 1, 1, 4], [1, 2]));