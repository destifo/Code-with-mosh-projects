const mongoose = require('mongoose');


mongoose.connect('mongodb://localhost/mongo-exercises').then(() => console.log("Connected to MongoDB...")).catch(err => console.log("Error connecting", err));

const courseSchema = mongoose.Schema({
    name: String,
    tags: [ String ],
    author: String,
    date: {type: Date, default:Date.now},
    isPublished: Boolean,
    price: Number
});

const Course = mongoose.model("courses", courseSchema);

async function getCoursesByFilter() {
    const courses = await Course
        .find()
        .and([{tags: { $in: ['backend']}}, {isPublished: true}])
        .sort({name: 1})
        .select({name: 1, author: 1});

    return courses;
}

async function run() {
    const courses = await getCoursesByFilter3();
    console.log(courses);
}

async function getCoursesByFilter2() {
    const courses = await Course
        .find({tags: { $in: ['backend', 'frontend']}})
        .sort({price: -1})
        .select({name: 1, author: 1});

    return courses;
}

async function getCoursesByFilter3() {
    const courses = await Course
        .find({isPublished: true})
        .or([{name: /.*by.*/i}, {price: { $gte: 15}}])
        .select({name: 1});
    
    return courses;
}


run();

