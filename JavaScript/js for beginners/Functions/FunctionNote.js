//Hoisting: when the js engine moves all function declarations to the top of the file.
run(); //works, as upon running the run function is moved to the top of the file

function run() {
    console.log('Run');  
}

walk()//doesn't work as this function is not created using the function declaration method.

let walk = () => console.log("walk");


//Arguments: arguments object inside functions
function sum() {
    let tot = 0;
    console.log(arguments) //arguments object holds all the arguments passed upon call no matter the number of parameters specified.arguments is an iterable obj not an array.
    for (let value of arguments)
        tot += value;

    return tot;
}


//Rest Operator
function sum(...args){
    return args.reduce((a, b) => a + b);
}

let calculateCart = (dicount, ...prices) => {
    let tot = prices.reduce((a, b) => a + b);
    return tot * (1 - dicount);
};


//Default parameters
function calculateInterest(principal, years, rate = 4.5) {
    return principal * rate * years;
}//after we set the default parameter, all the next parameters should also be set to a defalut value.

const interest = calculateInterest(10000, 5);


//Getters and setters
const person = {
    firstName: "Yeabsira",
    lastName: "Bireda",
    get fullName() {
        return (`${this.firstName} ${this.lastName}`);
    },
    set fullName(value) {
        let name = value.split(' ');
        this.firstName = name[0];
        this.lastName = name[1];
    }
}

console.log(person.fullName);

person.fullName = "Ezra Bireda";
console.log(person.fullName);


//Try and catch, report an error
const person = {
    firstName: "Bireda",
    lastName: "Maru",
    get fullName() {
        return (`${this.firstName} ${this.lastName}`);
    },
    set fullName(value) {
        if (typeof value !== 'string')
            throw new Error("Input isn't a string");

        let name = value.split(' ');
        if(name.length !== 2)
            throw new Error("Please enter both first and last name");

        this.firstName = name[0];
        this.lastName = name[1];
    }
}

try{
    person.fullName = "Meseret Engdawork";
}catch(ex){
    console.log(ex);
}