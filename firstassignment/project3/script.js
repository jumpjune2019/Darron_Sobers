window.onload = init;

function init() {
    var name = prompt( "Enter your name?");
    name();

    function resetFunc() {
        document.getElementById("myForm").reset();
        
    }

}