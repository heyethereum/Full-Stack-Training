const promise = new Promise((success, failure) => {
  const pass = 50;
  pass >= 50 ? success("success") : failure("failure");
});

promise
  .then((message) => {
    console.log(message);
  })
  .catch((error) => {
    console.log(error);
  });
