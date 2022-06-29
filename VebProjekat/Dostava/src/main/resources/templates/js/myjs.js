const login = document.querySelector('#log');

const logi = async() => {
    let response = await fetch('http://localhost:8080/login/loginb');
    console.log(response);

}
login.addEventListener('click');