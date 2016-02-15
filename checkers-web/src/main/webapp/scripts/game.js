$(document).ready(function() {
	sessionStorage.setItem("isSelected",false);
	$('#emptyCell').hide();
	$('#sameColor').hide();

});

function selectCell(col,row,color){

	// Can change cell selected if clicked on same color
	if(color == sessionStorage.getItem("selectedColor") && sessionStorage.getItem("isSelected")== "true") {
		changeSameColorCell(color);
		setCellToGreen(col,row,color);
		setSessionForFirstClick(col,row,color);

	}else {
		// If first click is on an empty cell
		if(color == "null" && sessionStorage.getItem("isSelected")== "false"){
			emptyCell();

		}else{
			// If first click correctly play
			if(sessionStorage.getItem("isSelected")== "false"){
				setSessionForFirstClick(col,row,color);
				setCellToGreen(col,row,color)

			}else {
				// If second click, we send information into URL
				sendURL(col,row);
			}
		}
	}

}

function sendURL(col,row)
{
	sessionStorage.setItem("isSelected",false);
	window.location.href='?selectedCol='+sessionStorage.getItem('selectedCol')+'&selectedRow='
		+sessionStorage.getItem('selectedRow')+'&targetedCol='+col+'&targetedRow='+row;
}

function setSessionForFirstClick(col,row,color)
{
	sessionStorage.setItem("isSelected",true);
	sessionStorage.setItem("selectedCol",col);
	sessionStorage.setItem("selectedRow",row);
	sessionStorage.setItem("selectedColor",color);
}

function changeSameColorCell(color)
{
	$('#sameColor').show();
	$('.green').removeClass('green').addClass(color);
}

function setCellToGreen(col,row,color)
{
	var id = '[id="' + col + ',' +row + '"]';
	var cell = $(id);
	cell.removeClass(color).addClass('green');
}

function emptyCell()
{
	$('#emptyCell').show();
}