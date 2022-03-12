let person = {
    name : 'destifo',
    age : 21
};

for (let key in person)
    console.log(key, person[key])

console.log('=========')

colors = ['red', 'blue', 'green']

for (let key in colors)//key is the index in arrays
    console.log(key)

console.log('=========')
    
for (let element of colors)//for of iterates over the elts not indexes of the array
    console.log(element)