function Circle(radius) {
    this.radius = radius;
    this.draw = function() {
        console.log('draw');
    }
}

let circle1 = new Function(1, `
this.radius = radius;
    this.draw = function() {
        console.log('draw');
    }
`)

let circle2 = Circle.call({}, 1);
let circle3 = Circle.apply({}, [args, 1, 2]);

// N.B: Functions are Objects.