var apiList = new Vue({
    el: '#api-list',
    data: {
        apis: []
    },
    mounted: function () {
        console.log("done");
        $.ajax({
            url: 'api/',
            datatype: 'json',
            type: "get",
            contentType: "application/json",
            success: function (data) {
                $.each(data, function(i, v){
                    apiList.apis.push(v);

                });
            },
            error: function () {
                alert("An error during data retrieving. Please, try again later");
            }
        });
    }
});
