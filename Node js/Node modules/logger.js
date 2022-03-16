let EventEmitter = require('events');


class Logger extends EventEmitter {
    log(message) {
        //send an http request
        console.log(message);
        
        let name = 'Yabu';
        this.emit("Logging", {message: `${name} has logged in`})
    }

}


//adding a log function to the module.exports object
module.exports = Logger;
