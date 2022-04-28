
const mongoose = require('mongoose');

mongoose.connect('mongodb://localhost/playground').then(
    () => console.log("Connected to Mongodb...")
).catch(err => console.error("Could not connect to MongoDb", err));


const courseSchema = mongoose.Schema({
    name: String,
    author: {
        type: mongoose.Schema.Types.ObjectId,
        ref: 'Author'
    },
});


const Course = mongoose.model('Course', courseSchema);

async function createCourse(name, author) {
    const course = new Course({
        name,
        author,
    });
    const result = await course.save();
    console.log(result);
}

const Author = mongoose.model('Author', new mongoose.Schema({
    name: {
        type: String,
        required: true,
    },
    bio: {
        type: String,
        min: 5,
        lowercase: true,
    }
}));


async function createAuthor(name, bio='Hellow'){
    const author = new Author({
        name,
        bio,
    });

    const result = await author.save();
    console.log(result);
}


async function listCourses() {
    const courses = await Course
        .find()
        .populate('author', 'bio -_id')
        .select('name author');
        console.log(courses);
}

// createAuthor('destifo', 'in and out ops');
// createCourse('node', "626a808ac3e40d881a5db27f")

listCourses(); 