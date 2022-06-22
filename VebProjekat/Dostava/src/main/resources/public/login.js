var attempts = 3
function validate(){

    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    fetch('/api/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
            // 'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: `{
      "korisnicko_ime":"${username}",
      "lozinka":"${password}"
}`
    }).then((response) => {
        console.log(response)
    }).catch((err) => {
        console.log(err)
    });
}