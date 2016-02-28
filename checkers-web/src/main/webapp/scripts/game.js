$(document).ready(function() {
	sessionStorage.setItem("isSelected", false);
});

function selectCell(col, row, color, turnColor) {
	// If first click is on an empty cell
	if (color == "null" && sessionStorage.getItem("isSelected") == "false") {
		emptyCell();
		
	} else {
		// Must select color of the current turn
		if (color == turnColor || sessionStorage.getItem('isSelected') == "true") {
			// If first click correctly played
			if (sessionStorage.getItem("isSelected") == "false") {
				setSessionForFirstClick(col, row, color);
				setCellToGreen(col, row, color);

			} else {
				// If click on the same color
				if (color == sessionStorage.getItem("selectedColor") && sessionStorage.getItem("isSelected") == "true") {
					changeSameColorCell(color);
					setCellToGreen(col, row, color);
					setSessionForFirstClick(col, row, color);

				} else {
					// If it's the second click, we send information into URL
					sendURL(col, row);
				}
			}
		}
	}
}

function sendURL(col, row) {
	sessionStorage.setItem("isSelected", false);
	window.location.href = '?selectedCol='
			+ sessionStorage.getItem('selectedCol') + '&selectedRow='
			+ sessionStorage.getItem('selectedRow') + '&targetedCol=' + col
			+ '&targetedRow=' + row;
}

function setSessionForFirstClick(col, row, color) {
	sessionStorage.setItem("isSelected", true);
	sessionStorage.setItem("selectedCol", col);
	sessionStorage.setItem("selectedRow", row);
	sessionStorage.setItem("selectedColor", color);
}

function changeSameColorCell(color) {
	$('.green').removeClass('green').addClass(color);
}

function setCellToGreen(col, row, color) {
	var id = '[id="' + col + ',' + row + '"]';
	var cell = $(id);
	cell.removeClass(color).addClass('green');
}

function emptyCell() {
	document.getElementById('emptyCell').style.display = 'inherit';
}
