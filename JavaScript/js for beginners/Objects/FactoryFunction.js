function createCircle(radius, location){
    return {
        radius,
        location: location,
        draw() {
            console.log('draw')
        }
    };
}

let circle1 = createCircle(1);