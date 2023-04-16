function filteritemByClass(className) {
  var item = document.querySelectorAll(".tile");
  item.forEach(function(tile) {
    if (tile.classList.contains(className)) {
      tile.style.display = "block";
    } else {
      tile.style.display = "none";
    }
  });
}

function showAllitem() {
  var item = document.querySelectorAll(".tile");
  item.forEach(function(tile) {
    tile.style.display = "block";
  });
}

function clickButton(button) {
  var allBtn = document.getElementById("show");
  var latestBtn = document.getElementById("hide1");
  var topRatedBtn = document.getElementById("hide2");

  if (button === allBtn) {
    showAllitem();
    window.history.replaceState(null, null, window.location.pathname);
  } else if (button === latestBtn) {
    filteritemByClass("latest");
    window.history.replaceState(null, null, "?latest");
  } else if (button === topRatedBtn) {
    filteritemByClass("top-rated");
    window.history.replaceState(null, null, "?top-rated");
  }

  // Remove the active class from all buttons
  allBtn.classList.remove("active");
  latestBtn.classList.remove("active");
  topRatedBtn.classList.remove("active");

  // Add the active class to the clicked button
  button.classList.add("active");
}

