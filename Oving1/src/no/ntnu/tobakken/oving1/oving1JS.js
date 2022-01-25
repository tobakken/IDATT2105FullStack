function countNumberOfClicks() {
    let counter = parseInt(document.getElementById("counter").innerHTML);
    counter++;
    document.getElementById("counter").innerText = "" + counter;
}

function showSecret(){
    document.getElementById("secret").style.display = "block";
    document.getElementById("secretBtn").setAttribute("onClick", "javascript: hideSecret();");
    document.getElementById("secretBtn").innerHTML = "Hide secret";
}
function hideSecret() {
    document.getElementById("secret").style.display = "none"
    document.getElementById("secretBtn").setAttribute("onClick", "javascript: showSecret();");
    document.getElementById("secretBtn").innerHTML = "show secret";
}

function showListe() {
    const randomAr = ["rand1", "rand2", "rand3", "rand4"];
    let text = "";
    for (let i = 0; i < randomAr.length; i++){
        text += "<li>" + randomAr[i] + "</li>";
    }
    document.getElementById("list").innerHTML = text;
}