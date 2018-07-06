(function(){
	
	var tool = {
		msg : function(str){
			alert(str);
		},
		show : (url) => {
			window.open(url);
		}
	}
	
	return tool;
	
})()