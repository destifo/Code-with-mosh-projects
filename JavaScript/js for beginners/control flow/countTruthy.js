const falsies = [undefined, null, '', false, 0, NaN];

let countTruthies = array => {
    let count = 0;
    for (let elt of array){
        if (falsies.includes(elt))
            continue;
        count++;
    }

    return count;
}

let countTruthies2 = array => {
    let count = 0;
    for (let elt of array)
        if (elt)
            count++;
    
    return count;
}

array = [0, 1, '']
console.log(countTruthies(array));