function msgPopup(){
	$('.joinForm').show();
	$('.joinForm').center();
}

function sendMsg(){
	msgPopup();
	$('.joinForm').html("<h1>Send Message</h1>");					
	$('.joinForm').append("<span id='img_tag'><a href='javascript:pop_hide()'><img src='/resources/Image/ic_clear.png'></a></span>");
	$('.joinForm').append("<hr>");
	$('.joinForm').append('<textarea rows="8" cols="60"></textarea>');
}



function msgDetail(i){
	
	msgPopup();
	$('.joinForm').html("<h1>Detail</h1>");					
	$('.joinForm').append("<span id='img_tag'><a href='javascript:pop_hide()'><img src='/resources/Image/ic_clear.png'></a></span>");
	
	$.ajax({
		url:"/msgDetail",
		data:{
			"idx":i
		}
	}).done(function(data){
		data = eval("(" + data + ")");
		var i = $('#scope_idx').val()
			
		$('.joinForm').append("<p>"+data.sender +"님이 보내신 글</p>");
		$('.joinForm').append('<textarea rows="8" cols="60" onfocus="javascrpt:blur()">'+data.message+'</textarea>');
		if(data.add_status==1){
			if(data.sender_idx == i){
				$('.joinForm').append("<br>");				
				$('.joinForm').append("<label class='addFriend'><a href='javascript:status(\"deny/"+data.idx+"\")'><img src='/resources/Image/ic_clear_2x.png'></a><span class='small'>Deny Friend</span></label>");				
			}
			else{
			$('.joinForm').append("<br>");
			$('.joinForm').append("<label class='addFriend'><a href='javascript:status(\"add/"+data.idx+"\")'><img src='/resources/Image/ic_done_2x.png'></a><span class='small'>ADD Friend</span></label>");
			$('.joinForm').append("<label class='addFriend'><a href='javascript:status(\"deny/"+data.idx+"\")'><img src='/resources/Image/ic_clear_2x.png'></a><span class='small'>Deny Friend</span></label>");				
			}
		}
		
	})
}

function status(i){
	var substr=i.split('/');	
	$.ajax({
		url: "/status_friend",
		data:{
			"status" :substr[0],
			"idx" : substr[1]
		}
	}).done(function(){
		location.reload();
		pop_hide();
	})
}

