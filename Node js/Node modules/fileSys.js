const fs = require("fs");

//Sync functions
//const files = fs.readdirSync('./Node modules');
//console.log(files);

//Async functions
const filesAsync = fs.readdir('*', (err, files) =>{
    if (err)    console.log('Error', err);
    else console.log('Result', files);
})