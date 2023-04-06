function changePassword() {
	let newPassword = document.getElementById('new-password').value;
	let confirmPassword = document.getElementById('confirm-password').value;

	if (newPassword == '' || confirmPassword == '') {
		alert('Please enter both new password and confirm password');
	} else if (newPassword != confirmPassword) {
		alert('New password and confirm password do not match');
	} else {
		alert('Password changed successfully');
		document.getElementById('new-password').value = '';
		document.getElementById('confirm-password').value = '';
	}
}