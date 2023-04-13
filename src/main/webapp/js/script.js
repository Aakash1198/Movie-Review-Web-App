


// Function which opens the side nav on click

function openNav() {
	document.getElementById("mySidebar").style.width = "300px";
	document.getElementByClassName("logo").style.marginLeft = "300px";
	logo.style.display = 'none';
  }
  
//   Function which closes side nav onclick
  function closeNav() {
	document.getElementById("mySidebar").style.width = "0";
	document.getElementByClassName("logo").style.marginLeft= "0";
  }
  
//   Function to display the dropdown content in CATEGORIES on moving mouse over it
   function myFunction2(){
	var y = document.getElementById("dropdown-content");
	if (y.style.display === "block") {
	  y.style.display = "none";
	} else {
	  y.style.display = "block";
	}
  }
  //   Function to display the dropdown content in SERVICES on moving mouse over it
  function myFunction3(){
	var y = document.getElementById("dropdown-content1");
	if (y.style.display === "block") {
	  y.style.display = "none";
	} else {
	  y.style.display = "block";
	}
  }

// Carousel Script
document.addEventListener("DOMContentLoaded", () => {
	  const carousel_1 = document.getElementById("carousel_1"),
	  content_1 = document.getElementById("content_1");
	  const carousel_2 = document.getElementById("carousel_2"),
	  content_2 = document.getElementById("content_2");
	  next_1 = document.getElementById("next_1"),
	  prev_1 = document.getElementById("prev_1"),
	  next_2 = document.getElementById("next_2"),
	  prev_2 = document.getElementById("prev_2");
	
	let width_1 = carousel_1.offsetWidth;
	let width_2 = carousel_2.offsetWidth;
	const gap = 16;
  
	next_1.addEventListener("click", e1 => {
	  carousel_1.scrollBy(width_1 + gap, 0);
	  if (carousel_1.scrollWidth !== 0) {
		prev_1.style.display = "flex";
	  }
	  if (content_1.scrollWidth - width_1 - gap < carousel_1.scrollLeft + width_1) {
		next_1.style.display = "none";
	  }
	
	});
	prev_1.addEventListener("click", e1 => {
	  carousel_1.scrollBy(-(width_1 + gap), 0);
	  if (carousel_1.scrollLeft - width_1 - gap <= 0) {
		prev_1.style.display = "none";
	  }
	  if (content_1.scrollWidth - width_1 - gap > 0) {
		next_1.style.display = "flex";
	  }
	});

	next_2.addEventListener("click", e2 => {
		carousel_2.scrollBy(width_2 + gap, 0);
		if (carousel_2.scrollWidth !== 0) {
		  prev_2.style.display = "flex";
		}
		if (content_2.scrollWidth - width_2 - gap < carousel_2.scrollLeft + width_2) {
		  next_2.style.display = "none";
		}
	  
	  });
	  prev_2.addEventListener("click", e2 => {
		carousel_2.scrollBy(-(width_2 + gap), 0);
		if (carousel_2.scrollLeft - width_2 - gap <= 0) {
		  prev_2.style.display = "none";
		}
		if (content_2.scrollWidth - width_2 - gap > 0) {
		  next_2.style.display = "flex";
		}
	  });

  
	window.addEventListener("resize", e1 => (width_1 = carousel_1.offsetWidth));
	window.addEventListener("resize", e2 => (width_2 = carousel_2.offsetWidth));
  });
  

  

