let findOccurrence = (array, searchElement) => array.reduce((count, value) => {
    const occurrence = (searchElement === value)?1:0; 
    return count + occurrence;
}, 0);

let occurrenceCount = findOccurrence([1, 1, 1, 2, 2, 3], 1);
console.log(occurrenceCount);   