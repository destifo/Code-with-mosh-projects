function Address(street, city, zipcode){
    this.street = street;
    this.city = city;
    this.zipcode = zipcode;
}

let showAddress = address => {
    for (let key in address)
        console.log(key, address[key]);
};

const address = new Address('a', 'b', 'c');

console.log(address);
showAddress(address);