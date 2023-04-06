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