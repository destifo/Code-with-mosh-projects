const Express = require('express');
const app = Express();

const courses = [        
    {
        id: 1,
        name: 'Express',
        hours: '10',
        skillLevel: 'Intermediate'
    },
    {
        id: 2,
        name: 'Django',
        hours: 11,
        skillLevel: 'Intermediate'
    }
];

app.get('/', (req, res) => {
    res.send('Hello World');
});

app.get('/api/courses', (req, res) => {
    res.send(courses);
});

app.get('/api/courses/:id', (req, res) => {
    //res.send(req.query);
    //res.send(req.params);//won't be executed
    let courseId = parseInt(req.params.id);
    let course = courses.filter((course) => course.id === courseId).map((course) => course.name)[0];

    if (!course)    res.status(404).send('The course with the given id was not found.');
    res.send(course);
})

const port = process.env.PORT || 8001;
app.listen(port, () => console.log(`Listening on port ${port}...`));
