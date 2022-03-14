const movies = [
    {title: 'a', year: 2018, rating: 4.5 },
    {title: 'b', year: 2018, rating: 4.7 },
    {title: 'c', year: 2018, rating: 3 },
    {title: 'c', year: 2017, rating: 4.5 }

];

let filterMovies = (year, rating, movies) => 
    movies.filter(movie => movie.year === year)
    .filter(movie => movie.rating > rating)
    .sort((a, b) => a.rating - b.rating)
    .reverse()
    .map(m => m.title);

let filterd = filterMovies(2018, 4, movies);
console.log(filterd);
