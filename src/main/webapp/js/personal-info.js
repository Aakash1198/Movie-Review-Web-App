function validatePassword() {
        var currentPassword = document.getElementById("current-password").value;
        var newPassword = document.getElementById("new-password").value;
        var confirmPassword = document.getElementById("confirm-password").value;
        var passwordError = document.getElementById("passwordError");
        if (newPassword != confirmPassword) {
          passwordError.innerHTML = "Passwords do not match";
          return false;
        } else {
          passwordError.innerHTML = "";
          // Code to save the new password goes here
          return true;
        }
      }
      function checkPasswordsMatch() {
        var newPassword = document.getElementById("new-password").value;
        var confirmPassword = document.getElementById("confirm-password").value;
        var passwordError = document.getElementById("passwordError");
        if (newPassword != confirmPassword) {
          passwordError.innerHTML = "Passwords do not match";
        } else {
          passwordError.innerHTML = "";
        }
      }