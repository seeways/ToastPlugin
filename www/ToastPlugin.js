
var exec = require("cordova/exec");
module.exports = {
    show: function(content){
        exec(
        function(message){//成功回调function
            console.log(message);
        },
        function(message){//失败回调function
            console.log(message);
        },
        "MyToast",//feature name
        "show",//action
        [content]//要传递的参数，json格式
        );
    },
    dialog: function(content){
        exec(
        function(message){
            console.log(message);
        },
        function(message){
            console.log(message);
        },
        "MyToast",
        "dialog",
        [content]
        );
    }
}