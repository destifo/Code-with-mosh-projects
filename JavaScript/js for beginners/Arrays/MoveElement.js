let move = (array, index, offset) => {
    if (index + offset < 0 || index + offset >= array.length)
        return console.error("Invalid Offset");
    if (index < 0 || index >= array.length)
        return console.error("Invalid Index");
    

    if (offset > 0){
        let current = array[index];
        for (let i = index; i < index + offset; i++)
            array[i] = array[i + 1];
        array[index + offset] = current;
    }
    else{
        let current = array[index];
        for (let i = index - 1; i >= index + offset; i--)
            array[i + 1] = array[i];
        array[index + offset] = current;
    }
}

function move2(index, offset, array){//using splice
    const position = index + offset;
    if (position < 0 || position >= array.length){
        console.log("Invalid offset")
        return;
    }

    let output = [...array];
    const element = output.splice(index, 1)[0];
    output.splice(position, 0, element);
    
    return output;
}

const nums = [1, 2, 3, 4];
move(nums, 2, -1);

console.log(nums);