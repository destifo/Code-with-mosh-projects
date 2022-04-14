const mongoose = require('mongoose');


mongoose.connect("mongodb://localhost/playground").then(() => console.log("Connected to MongoDb...")).catch(err => console.log("Error found", err));

const courseSchema = mongoose.Schema({
    name: String, 
    author: String,
    tags: [String],
    price: Number,
    ispublished: Boolean, 
    date: { type: Date, default: Date.now}
});

const Course = mongoose.model('courses', courseSchema);

// Approach: Query first
async function updateCourse(id) {
    const course = await Course.findById(id);
    if (!course)
        return;

    // course.ispublished = true;
    // course.author = 'destifo';
    console.log("found the course");
    course.set({
        isPublished: true,
        author: 'destifo'
    });

    const result = await course.save();
    console.log(result);
}

// Approach: update first
async function updateCourse2(id) {
    const result = await Course.update({_id: id}, {
        $set: {
            name: 'Yabu',
        }
    });
    console.log("Update First");
    console.log(result);
}

// returns the original document
async function findAndUpdateCourse(id) {
    const course = await Course.findByIdAndUpdate(id, {
        $set: {
            name: "Ezra"
        }
    });
    console.log(course);
}

async function removeCourse(id) {
    const result = await Course.deleteOne({ _id: id });
    // const result = await Course.deleteMany({ _id: id });
    // const course = await Course.findByIdAndRemove(id);
    console.log(result);    
}

updateCourse2("62571e911d6da73878b60b18");