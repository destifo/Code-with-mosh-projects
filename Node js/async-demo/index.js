console.log('Before');
//getUser(1, (user) => {
//    console.log(user);
//
//    getRepos(user.username, (repos) => {
//        console.log(repos);
//        getCommits(repos[0], (commits) => {
//            console.log(commits);
//        })
//    });
//});

// consuming promises by chaining then
//getUser(1)
//    .then(user => getRepos(user.username)
//        .then(repos => getCommits(repos[0])
//            .then(commits => console.log(commits))));

// the same as the one above
getUser(1)
    .then(user => getRepos(user.username))
    .then(repos => getCommits(repos[0]))
    .then(commit => console.log(commit))
    .catch(err => console.log('Error:', err.message));

//callbacks
//getUser(1, displayUser);

console.log('After');

// using callbacks
function getUser(id, callback) {
    setTimeout(() => {
        console.log('Reading from the database...');
        callback({ id, username: 'destifo'});
    }, 2000);
}

// using promises
function getUser(id) {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            console.log('Reading from the database...');
            resolve({ id, username: 'destifo'});
        }, 2000);
    });
}


function getRepos(username, callback) {
    setTimeout( () => {
        console.log(`Getting the repos of username: ${username}`);
        callback(['repo1', 'repo2', 'repo3']);
    }, 2500);
}

function getRepos(username) {
    return new Promise((resolve, reject) => {
        setTimeout( () => {
            console.log(`Getting the repos of username: ${username}`);
            resolve(['repo1', 'repo2', 'repo3']);
        }, 2500);
    });
}

function getCommits(repo, callback) {
    setTimeout(() => {
        console.log(`Acessing commits inside the repo: ${repo}`);
        callback(['commit1', 'commit2', 'commit3']);
    }, 2500);
}

function getCommits(repo) {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            console.log(`Acessing commits inside the repo: ${repo}`);
            resolve(['commit1', 'commit2', 'commit3']);
        }, 2500);
    });
}

function displayCommits(commits) {
    console.log(commits);
}

function displayRepos(repos) {
    console.log(repos);
    getCommits(repos[0], displayCommits);
}

function displayUser(user) {
    console.log(user);
    getRepos(user.username, displayRepos);
}