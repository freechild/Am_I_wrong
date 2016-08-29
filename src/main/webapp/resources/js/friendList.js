function search(){
	if($('#search').val().length>1){
		$.ajax({
    		url :'/searchFriend',
    		data:{
    			'search' : $('#search').val()
    		}	
    	}).done(function(data){
    		$('.searchFriend').empty();
    		if(data=="false"){
    			$('.searchFriend').append("<tr class='even'>")
    			$('.searchFriend').append("<td></td>")
    			$('.searchFriend').append("<td>존재하지않는 유저입니다.</td>")
    			$('.searchFriend').append("<td></td>")
    			$('.searchFriend').append("</tr>")
    		}
    		else{	
	    	
	    		data = eval("(" + data + ")");
	    		val = data.friendList;
	    		$.each(data.friendList,function(index,value){
	    			$('.searchFriend').append("<tr class='even'>")
	    			$('.searchFriend').append("<td>" + value.email + "</td>")
	    			$('.searchFriend').append("<td>" + value.name + "</td>")
	    			$('.searchFriend').append("<td><input type='button' value='ADD' onclick='javascript:addfriend(\""+value.idx+"\")'></td>")
	    			$('.searchFriend').append("</tr>")
	    		})
    		}
    	})
	}
}


function addfriend(i){
	$.ajax({
		url:'/addFriend',
		data:{
			"recipient_idx" : i,
			"sender_idx" : $('#scope_idx').val()
		}
	}).done(function(){
		alert("메시지를 보내셨습니다.")
	})
}

