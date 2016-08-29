function search(event){
    var keyCode = event.keyCode ? event.keyCode : event.which;
    
    // keyCode가 0이면 which 리턴
    
    keyCode = event.keyCode || which;
    var i = $('#search').val();
    //var d = $('#scope_idx').val();
    //console.log(keyCode);
    if (keyCode==13){
    	$.ajax({
    		url :'/searchFriend',
    		data:{
    			'search' : $('#search').val()
    		}	
    	}).done(function(data){
    		alert("data");
    	})
	}
}