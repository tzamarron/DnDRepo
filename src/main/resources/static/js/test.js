$(document).ready(function () {
    let onlineData = function (search) {
        console.log("calling API...")
        $.get("https://api.open5e.com/" + search + "/").done(function (data) {
            // console.log(data.results[0]);

        });
    };
    onlineData("classes");
})