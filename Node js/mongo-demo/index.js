
const mongoose = require('mongoose');

mongoose.connect('mongodb://localhost/playground').then(
    () => console.log("Connected to Mongodb...")
).catch(err => console.error("Could not connect to MongoDb", err));


const courseSchema = mongoose.Schema({
    name: String,
    author: String,
    tags: [ String ],
    date: { type: Date, default: Date.now },
    isPublished: Boolean
});


const Course = mongoose.model('Course', courseSchema);

async function createCourse() {
    const course = new Course({
        name: "Angular Course",
        author: "Mosh Hamedani",
        tags: ["angular", "frontend"],
        isPublished: true,
    });
    const result = await course.save();
    console.log(result);
}


async function getCourses() {
    const courses = await Course.find({author: "Mosh Hamedani", isPublished: true})
    .limit(10)
    .sort({name: 1})
    .select({name: 1, tags: 1});
    console.log(courses);
}

// Comparison query operators, check for others when u need them.
async function getCoursesWithFilters() {
    const courses = await Course
        // .find({price: {$gt: 10, $lte: 20} })
        .find({price: {$in: [10 ,15, 20]}});
}

// extract data using logical operators
async function getCoursesWithLogcalOperators() {
    const courses = await Course
        .find()
        .or([{author: "mosh"}, {isPublished: true}])
        .and([]);
}

async function getCoursesWithRegex() {
    const pageNumber = 2;
    const pageSize = 10;

    const courses = await Course
        // starts with Mosh
        .find({author: /^Mosh/ })
        // ends with hamedani
        .find({author: /hamedani$/ })
        //contains mosh anywhere, i for the case sensetive
        .find({author: /.*mosh*./i })
        //count() returns the number of documents that was found by the search
        .count()
        //for pagination we can use skip() and limit() together, to skip previous page content
        .skip((pageNumber - 1) * pageSize)
        .limit(pageSize)
        ;
}

getCourses();

