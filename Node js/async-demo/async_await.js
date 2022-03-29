async function displayCommits(){
    try{
        const user = await getUser(1);
        const repos = await getRepos(user.username);
        const commits = await getCommits(repos[0]);
        console.log(commits);
    }
    catch (err){
        console.log("Error:", err);
    }
}

displayCommits();


function getUser(id) {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            console.log('Reading from the database...');
            resolve({ id, username: 'destifo'});
        }, 2000);
    });
}

function getRepos(username) {
    return new Promise((resolve, reject) => {
        setTimeout( () => {
            console.log(`Getting the repos of username: ${username}`);
            resolve(['repo1', 'repo2', 'repo3']);
        }, 2500);
    });
}

function getCommits(repo) {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            console.log(`Acessing commits inside the repo: ${repo}`);
            resolve(['commit1', 'commit2', 'commit3']);
        }, 2500);
    });
}