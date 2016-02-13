function init() {
  sessionStorage.setItem("isSelected",false);
}

init();

function test(col,row,color){
	if(color == "null" && sessionStorage.getItem("isSelected")== "false"){
		alert("Please select a block with a piece on it");
	}else{
		if(sessionStorage.getItem("isSelected")== "false"){
			sessionStorage.setItem("isSelected",true);
			sessionStorage.setItem("selectedCol",col);
			sessionStorage.setItem("selectedRow",row);
		}else {
			sessionStorage.setItem("isSelected",false);
			window.location.href='?selectedCol='+sessionStorage.selectedCol+'&selectedRow='+sessionStorage.selectedRow+'&targetedCol='+col+'&targetedRow='+row;
		}
	}
}