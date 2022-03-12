let circle = {
    radius: 1,
    draw() {
        console.log('draw')
    }
};

for (let key in circle)
    console.log(key, circle[key]);

console.log('=======')

for (let key of Object.keys(circle))//only iterables work with for...of, so we make the object iterable
    console.log(key, circle[key]);

console.log('=======')

for (let entry of Object.entries(circle))
    console.log(entry);

//cloning objects
const another = {};
Object.assign(another, circle);//can add more source objects other than circle

const another2 = {...circle};//spreading operator '...' for cloning