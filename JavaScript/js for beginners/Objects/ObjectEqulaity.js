function Address(street, city, zipcode){
    this.street = street;
    this.city = city;
    this.zipcode = zipcode;
}

let address1 = new Address('a', 'b', 'c');
let address2 = new Address('a', 'b', 'c');


let isEqual = (address1, address2) => {
    for (let key in address1)
        if (address1[key] !== address2[key])
            return false;
    
    return true;
};

function isSame(address1, address2){
    return address1 === address2;
}

console.log(isEqual(address1, address2));