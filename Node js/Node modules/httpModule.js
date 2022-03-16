const http = require('http');

const server = http.createServer((req, res) => {
    if (req.url === '/') {
        res.write("Hello world");
        res.end();
    }
    if (req.url === '/api/courses'){
        res.write(JSON.stringify([1, 2, 3, 4]));
        res.end();
    }
});

//server.on('connection', (socket) => console.log("New Connection"));

server.listen(8001);

console.log('Listening on port 8001...');