$(document).ready(function() {
	sessionStorage.setItem("isSelected",false);

	$('#emptyCell').hide();
	$('#sameColor').hide();

});

function test(col,row,color){

	// Can change cell selected if clicked on same color
	if(color == sessionStorage.getItem("selectedColor") && sessionStorage.getItem("isSelected")== "true") {
		$('#sameColor').show();
		sessionStorage.setItem("isSelected",false);

	}else {
		// If first click is on an empty cell
		if(color == "null" && sessionStorage.getItem("isSelected")== "false"){
			//alert("Please select a block with a piece on it");
			$('#emptyCell').show();

		}else{
			// If first click correctly play
			if(sessionStorage.getItem("isSelected")== "false"){
				sessionStorage.setItem("isSelected",true);
				sessionStorage.setItem("selectedCol",col);
				sessionStorage.setItem("selectedRow",row);
				sessionStorage.setItem("selectedColor",color);

			}else {
				// On second click we send information into servlet
				sessionStorage.setItem("isSelected",false);
				window.location.href='?selectedCol='+sessionStorage.selectedCol+'&selectedRow='+sessionStorage.selectedRow+'&targetedCol='+col+'&targetedRow='+row;
			}
		}
	}

}