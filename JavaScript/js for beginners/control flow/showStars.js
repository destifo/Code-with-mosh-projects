let showStars = rows => {
    let pattern = '*';
    for (let i = 1; i <= rows; i++){
        console.log(pattern);
        pattern += '*';
    }
}

showStars(5)