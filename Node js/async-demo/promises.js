
const p = new Promise((resolve, reject) => {
    // async operations here
    setTimeout(() => {
        //resolve(1);
        reject(new Error('error message'));
    }, 2000);
});

p
    .then(result => console.log(result))
    .catch(err => console.log('Failure:', err.message));