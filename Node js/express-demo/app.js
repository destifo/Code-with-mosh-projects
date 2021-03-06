const Joi = require('joi');//input validation
const Express = require('express');
const app = Express();

app.use(Express.json());

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

//handling http get requests
app.get('/api/courses/:id', (req, res) => {
    //res.send(req.query);
    //res.send(req.params);//won't be executed
    let courseId = parseInt(req.params.id);
    let course = courses.find( course => course.id === courseId).name;

    if (!course)    return res.status(404).send('The course with the given id was not found.');
    res.send(course);
});

//handling http post 
app.post('/api/courses', (req, res) => {
    const { error } = validateCourse(req.body);//object ditructring
    if (error)
        return res.status(400).send(error.details[0].message);


    const course = {
        id: courses.length + 1,
        name: req.body.name
    };
    courses.push(course);

    res.send(course);
});

//handling http put requests
app.put('/api/courses/:id', (req, res) => {
    const { error } = validateCourse(req.body);//object ditructring
    if (error)
        return res.status(400).send(error.details[0].message);

    const courseId = parseInt(req.params.id);
    const course = courses.find(course => course.id === courseId);

    if (!course){
        //const newCourse = {
        //    id: courses.length + 1,
        //    name: req.body.name
        //};
        //courses.push(newCourse);
        return res.status(404).send("Course Not Found");
    }
    course.name = req.body.name;
    res.status(200).send(course);

});

function validateCourse(course){
    const schema = {
        name: Joi.string().min(3).required()
    };

    return Joi.validate(course, schema);
}

app.delete('/api/courses/:id', (req, res) => {
    const courseId = parseInt(req.params.id);
    let deletedCourse;
    let courseIndex;
    for (let i in courses){
        const course = courses[i];
        if (course.id === courseId){
            courseIndex = i;
            deletedCourse = courses[courseIndex];
            break; 
        }
    }

    if (!deletedCourse)
        return res.status(404).send("Course not found");
    
    courses.splice(courseIndex, 1);
    res.send(deletedCourse);
});


const port = process.env.PORT || 8001;
app.listen(port, () => console.log(`Listening on port ${port}...`));
