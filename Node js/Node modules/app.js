var Logger = require('./logger');

const logger = new Logger();//need to use the custom defined emitter class to register events and raise a listener.

logger.on("Logging", eventArgs => console.log(eventArgs.message));

logger.log("New Message");