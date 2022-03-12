function showProperties(obj){
    for (let key in obj)
        if (typeof obj[key] === 'string')
            console.log(key, obj[key]);
}

const movie = {
    title: 'a',
    rating: 7.9,
    director: 'me'
};

showProperties(movie)