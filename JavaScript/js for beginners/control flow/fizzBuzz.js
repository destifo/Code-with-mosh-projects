let fizzBuzz = (input) => {
    if (typeof input !== 'number')  return NaN;

    if (input % 15 === 0)    return 'FizzBuzz';
    else if (input % 5 === 0)    return 'Buzz';
    else if (input % 3 === 0)    return 'Fizz';
    else    return input;
}

console.log(fizzBuzz(31))