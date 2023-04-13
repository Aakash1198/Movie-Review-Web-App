<<<<<<< HEAD

// Get the form element
const form = document.querySelector('#login-form');

// Create a new FormData object
const formData = new FormData(form);

// Use the FormData object to construct the request body
const body = JSON.stringify(Object.fromEntries(formData.entries()));


fetch('http://16.170.110.9:8081/login', {
  method: 'POST',
  headers: {
    'Content-Type': 'application/json'
  },
  body: body
})
.then(response => response.json())
.then(data => {
  // Process the response data here
  console.log(data);
})
.catch(error => {
  // Handle any errors that may occur
  console.error(error);
});



=======
>>>>>>> 36932d09032847498a8d8008e9d093601c2bfe0b
function validateLoginForm() {
    const emailInput = document.getElementById("email");
    const emailError = document.getElementById("emailError");
    const passwordInput = document.getElementById("password");
    const passwordError = document.getElementById("passwordError");
    let isValid = true;
  
    // Validate email
    if (emailInput.value.trim() === "") {
      emailError.innerText = "Email is required";
      isValid = false;
    } else if (!isValidEmail(emailInput.value.trim())) {
      emailError.innerText = "Please enter a valid email";
      isValid = false;
    } else {
      emailError.innerText = "";
    }
  
    // Validate password
    if (passwordInput.value.trim() === "") {
      passwordError.innerText = "Password is required";
      isValid = false;
    } else {
      passwordError.innerText = "";
    }
  
    return isValid;
  }
  
  function isValidEmail(email) {
    // Regular expression to validate email format
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
  }