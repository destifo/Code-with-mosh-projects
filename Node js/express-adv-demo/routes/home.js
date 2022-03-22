const Express = require('express');
const router = Express.Router();

router.get('/', (req, res) => {
    res.render('home', {
        title: "My dum app",
        message: "Yokoso"
    });
});

module.exports = router