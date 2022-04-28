const mongoose = require('mongoose');

mongoose.connect('mongodb://localhost/playgroundEmbedding')
  .then(() => console.log('Connected to MongoDB...'))
  .catch(err => console.error('Could not connect to MongoDB...', err));

const authorSchema = new mongoose.Schema({
  name: String,
  bio: String,
});

const Author = mongoose.model('Author', authorSchema);

const Course = mongoose.model('Course', new mongoose.Schema({
  name: String,
  authors: {
    type: [authorSchema],
    required: true,
  },
}));

async function createCourse(name, authors) {
  const course = new Course({
    name, 
    authors,
  }); 
  
  const result = await course.save();
  console.log(result);
}

async function addAuthor(courseid, author) {
  const course = await Course.findById(courseid);
  if (course == null)
    throw Error('Course with the given id was not found');

  course.authors.push(author);
  const result = await course.save();
  console.log(result);
}

async function listCourses() { 
  const courses = await Course.find();
  console.log(courses);
}

async function removeAuthor(courseid, authorid){
  const course = await Course.findById(courseid);
  if (!course)
    throw new Error('Course with the given id was not found');

  const author = course.authors.id(authorid);
  author.remove();
  course.save();
}

// createCourse('Node Course', [
//   new Author({ name: 'Mosh' }),
//   new Author({ name: 'destifo'})
// ]);
removeAuthor('626a896cac3bf05cd07e5567', '626a896cac3bf05cd07e5566');
