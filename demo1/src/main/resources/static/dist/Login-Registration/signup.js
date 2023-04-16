fetch('http://127.0.0.1:8081/swagger/register')
  .then(response => response.json())
  .then(data => {
    // Process the response data here
    console.log(data);
  })
  .catch(error => {
    // Handle any errors that may occur
    console.error(error);
  });


function validateName() {
    const nameInput = document.getElementById("name");
    const nameError = document.getElementById("nameError");
    
    if (nameInput.value.trim() === "") {
      nameError.innerHTML = "Name is required";
      return false;
    }
    
    nameError.innerHTML = ""; // clear any previous error message
    return true;
  }

function validateEmail() {
    const email = document.getElementById("email").value;
    const emailError = document.getElementById("emailError");
    const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!regex.test(email)) {
        emailError.innerHTML = "Please enter a valid email address.";
        return false;
    } else {
        emailError.innerHTML = "";
        return true;
    }
}

function validatePhone() {
    const phone = document.getElementById("phone").value;
    const phoneError = document.getElementById("phoneError");
    const regex = /^\d{10}$/;
    if (!regex.test(phone)) {
        phoneError.innerHTML = "Please enter a valid 10-digit phone number.";
        return false;
    } else {
        phoneError.innerHTML = "";
        return true;
    }
}

function validatePassword() {
    const password = document.getElementById("password").value;
    const passwordError = document.getElementById("passwordError");
    const regex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$/;
    if (!regex.test(password)) {
        passwordError.innerHTML = "Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, and one number.";
        return false;
    } else {
        passwordError.innerHTML = "";
        return true;
    }
}

function validateConfirmPassword() {
    const passwordInput = document.getElementById('password');
    const confirmPasswordInput = document.getElementById('confirm-password');
    const confirmPasswordError = document.getElementById('confirmPasswordError');
  
    if (passwordInput.value !== confirmPasswordInput.value || confirmPasswordInput.value ==="") {
      confirmPasswordError.innerHTML = 'Passwords do not match';
      return false;
    } else {
      confirmPasswordError.innerHTML = '';
      return true;
    }
  }

 