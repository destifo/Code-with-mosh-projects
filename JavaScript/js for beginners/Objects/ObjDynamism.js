const circle = {//const means can't reassign the cicle variable, like circle = {}
    radius: 1
}

circle.color = 'yellow';
circle.draw = function() {
    console.log('draw');
};

circle.draw();
delete circle.draw;
console.log(circle);