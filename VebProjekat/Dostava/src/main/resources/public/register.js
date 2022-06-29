var attempts = 3
function validate(){

    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var  name= document.getElementById("name").value;
    var surname = document.getElementById("surname").value;
    var sex = document.getElementById("sex").value;
    var date = document.getElementById("date").value;
    fetch('/api/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
            // 'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: `{
      "korisnicko_ime":"${username}",
      "lozinka":"${password}",
      "ime":"${name}",
      "prezime":"${surname}",
      "pol":"${sex}",
      "datum":"${date}"
}`
    }).then((response) => {
        console.log(response)
    }).catch((err) => {
        console.log(err)
    });
}