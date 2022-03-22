function authnr(req, res, next) {
    console.log("Authenticating...");
    next();
}

module.exports = authnr;