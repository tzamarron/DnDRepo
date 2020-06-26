$(document).ready(function () {

    let onlineData = function (search) {
        // console.log("calling API...")
        $.get("https://api.open5e.com/" + search + "/").done(function (data) {
            let array = data.results;
            // console.log("Found results: ");
            // console.log(array);
            array.forEach((item) => {
                if (item.name === "Warlock") {
                    console.log("Name:");
                    console.log(item.name);
                    console.log("")
                    console.log(item.desc);
                    console.log(item.equipment);
                    console.log(item.hit_dice);
                    console.log(item.hp_at_1st_level);
                    console.log(item.prof_armor);
                    console.log(item.prof_saving_throws);
                    console.log(item.prof_skills);
                    console.log(item.prof_tools);
                    console.log(item.prof_weapons);
                    console.log(item.spellcasting_ability);
                    console.log(item.subtypes_names);
                    console.log(item.table);
                }
            });
        });
    };
    onlineData("classes");
})