function createCircle(radius){
    return {
        radius,
        draw() {
            console.log('draw')
        }
    };
}

function Circle(radius) {
    this.radius = radius;
    this.draw = function() {
        console.log('draw');
    }
}

const circle = createCircle(1);
const another = new Circle(2);


console.log(circle.constructor);//returns the function that created this object
console.log(another.constructor);