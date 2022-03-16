let EventEmitter = require('events');
const emitter = new EventEmitter();

//Add event Listener, listener needs to be specified before the event is emiited, or it won't be recorded. eventArgs are the args from the event raised
emitter.on("New Message Logged", (eventArg) => { console.log("New Message Registered", eventArg)});


//Raise an event, we can also add event arguments, but it's a good practice to use an object as argument and must use it most of the time. can help with description.
emitter.emit("New Message Logged", {id: 1, name: "mom"});
