
// getCustomer(1, (customer) => {
//   console.log('Customer: ', customer);
//   if (customer.isGold) {
//     getTopMovies((movies) => {
//       console.log('Top movies: ', movies);
//       sendEmail(customer.email, movies, () => {
//         console.log('Email sent...')
//       });
//     });
//   }
// });

async function sendEmailToCustomer() {
  const customer = await getCustomer(1);
  console.log('Customer: ', customer);
  if (customer.isGold){
    let topMovies = await getTopMovies();
    console.log("Top Movies: ", topMovies);
    await sendEmail(customer.email, topMovies);
  }
}

sendEmailToCustomer();

function getCustomer(id) {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve(
        {
          name: "destifo",
          id: 1, 
          isGold:true
        }
      );
    }, 4000);
  });  
}

function getTopMovies() {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve(['movie1', 'movie2']);
    }, 4000);
  });
}

function sendEmail(email, movies) {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      console.log("Email sent...");
    });
  });
}


// function getTopMovies() {
//   setTimeout(() => {
//     callback(['movie1', 'movie2']);
//   }, 4000);
// }

// function sendEmail(email, movies, callback) {
//   setTimeout(() => {
//     callback();
//   }, 4000);
// }