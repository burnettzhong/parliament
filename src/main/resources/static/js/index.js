$(function () {
    $.ajax({
        url: 'api/',
        datatype: 'json',
        type: "get",
        contentType: "application/json",
        success: function (data) {
            apiresource = data;
            $.each(data, function(i, v){
                app4.apis.push(v);

            });
        },
        error: function () {
            alert("An error during data retrieving. Please, try again later");
        }
    });
});

// Vue
var apiresource = {};
var app4 = new Vue({
    el: '#app-4',
    data: {
        apis: []
    }
});
