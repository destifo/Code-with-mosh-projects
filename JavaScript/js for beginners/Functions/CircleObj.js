let circle = {
    radius: 2,
    get area() {
        return (this.radius ** 2) * Math.PI;
    }
};
console.log(circle.area);
