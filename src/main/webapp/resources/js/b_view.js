
/*레이어 밖 누르면 감추기*/
/*$(document).ready(function(){
		$(document).mousedown(function(e){
			
		$('_popup').each(function(){
		        if ( $(this).css('display') == 'block' )
		        {
		            var l_position = $(this).offset();
		            l_position.right = parseInt(l_position.left) + ($(this).width());
		            l_position.bottom = parseInt(l_position.top) + parseInt($(this).height());
	
	
		            if ( ( l_position.left <= e.pageX && e.pageX <= l_position.right )
		                && ( l_position.top <= e.pageY && e.pageY <= l_position.bottom ) )
		            {
		                //alert( 'popup in click' );
		            }
		            else
		            {
		                //alert( 'popup out click' );
		                $(this).hide("fast");
		            }
		        }
		           
		    });
		});
	})

var whichBtn;

//레이어 보이기

function view_popup(obj)
{
	whichBtn = $('#'+obj).attr('id');
	
    $('._popup').show("fast");
    $('._popup').center();	
    $("._popup").html("비밀번호 입력 & enter<br>");
    $("._popup").append("<input type='text' size='6' id='password' onkeypress='checkPW(event)' />");
    $("#password").focus();
}

//ajax 동기화로 암호 체크
function checkPW(event){
    var keyCode = event.keyCode ? event.keyCode : event.which;
    
    // keyCode가 0이면 which 리턴
    
    keyCode = event.keyCode || which;
 
    //console.log(keyCode);
    if (keyCode==13){
    	var pw = $("#password").val(); 
    	//alert(pw)
    	 //alert(idx);
    	if(whichBtn == 'b_modi' || whichBtn =='b_del'){
    		var idx = $("#idx").val();
	    	$.ajax({
	    		type : 'GET',
	    		url :'b_checkPW',
	    		data:
	    		{
	    			"pw": pw ,
	    			"idx":idx,
	    			"whichBtn":whichBtn	
	    		}
	    	}).done(function(data){
				if (data=="false"){
	    			$("._popup").html("암호불일치<br>");
	    			$("._popup").append("<input type='text' size='6' id='password' onkeypress='checkPW(event)' />");
				 	$("#password").focus();
				} else {
					var url = data;    
					$(location).attr('href',url);
				}
	    	});
    	}
    	
    	else{
    		
    		var b_idx = $("#idx").val();
    		$.ajax({
	    		type : 'GET',
	    		url :'c_checkPW',
	    		data:
	    		{
	    			"pw": pw ,
	    			"idx":whichBtn,
	    			"b_idx":b_idx
	    		}
	    	}).done(function(data){
				if (data=="false"){
	    			$("._popup").html("암호불일치<br>");
	    			$("._popup").append("<input type='text' size='6' id='password' onkeypress='checkPW(event)' />");
				 	$("#password").focus();
				} else {
					var url = data;    
					$(location).attr('href',url);
				}
	    	});
    	}
    }
}
*/

function board_modi(){
	$('.joinForm').html("<h1>Modify</h1>");
	$('.joinForm').append("<span id='img_tag'><a href='javascript:pop_hide()'><img src='/resources/Image/ic_clear.png'></a></span>");
	$('.joinForm').append("<hr>");
//	 modify from who writing something
	$.ajax({
		url : 'b_modi',
		data:{
			'mem_ref' : $('#scope_idx').val(),
			'idx' : $('#idx').val()
		}
	}).done(function(data){
		
		if(data == 'false')
			$('.joinForm').append('<label>잘못된 접근입니다.</label>');		
		else{
//			$.each(data,function(key, val) {
//				alert(val.key);
//	        });
			data = eval("("+data+")");
			$('.joinForm').append('<textarea rows="1" cols="60" id="b_modiTitle">'+data.title+'</textarea>');
			$('.joinForm').append('<textarea rows="8" cols="60" id="b_modiContent">'+data.content+'</textarea>');
			$('.joinForm').append('<span id="img_tag"><a href="javascript:b_modiView('+ $('#idx').val() +')"><img src="/resources/Image/ic_done.png"></a></span>');
		}
	});
}


function b_modiView(i){
	
	$.ajax({
		url: 'b_modiView',
		data:{
			'idx' : i,
			'title' : $('#b_modiTitle').val(),
			'content' : $('#b_modiContent').val()
		}	
	}).done(function(){
		location.reload();
//		popup_hide;
	});
}


function board_del(){
	$('.joinForm').html('<h1>Delete</h1>');
	$('.joinForm').append('<span id="img_tag"><a href="javascript:pop_hide()"><img src="/resources/Image/ic_clear.png"></a></span>');
	$('.joinForm').append('<hr>');	
	$.ajax({
		url : 'b_del',
		data:{
			'mem_ref' : $('#scope_idx').val(),
			'idx' : $('#idx').val()
		}
	}).done(function(data){
		if(data == 'false')
			$('.joinForm').append('<label>잘못된 접근입니다.</label>');		
		else{
			$('.joinForm').append('<label>삭제하겠습니까?</label>');
			$('.joinForm').append('<br><br><br>');
			$('.joinForm').append('<label class="findthing"><a href="javascript:b_del('+ $('#idx').val() +')"><img src="/resources/Image/ic_done_2x.png"></a></label>');
			$('.joinForm').append('<label class="findthing"><a href="javascript:pop_hide()"><img src="/resources/Image/ic_clear_2x.png"></a></label>');
		}	
	})
}
function b_del(i){
	$.ajax({
		url: 'b_delOk',
		data :{
			'idx' : i
		}
	}).done(function(data){
		$(location).attr('href','board');
	});
}


function comments(){
	
	$.ajax({
		url: '/b_comment',
		data :
		{
			'b_ref' : 	$('#idx').val(),
			'mem_ref' : $('#scope_idx').val(),
			'content' : $('.comment_W input[name="content"]').val()
		}
	}).done(function(data){		
		var url = data;    
		$(location).attr('href',url);
	});	
}

function comment_del(i){
	$.ajax({
		url : '/c_del',
		data:{
			'idx' : i,
			'mem_ref' : $('#scope_idx').val()
		}
	}).done(function(data){
		$('.joinForm').html('<h1>Delete</h1>');
		$('.joinForm').append('<span id="img_tag"><a href="javascript:pop_hide()"><img src="/resources/Image/ic_clear.png"></a></span>');
		$('.joinForm').append('<hr>');	
		if(data == 'true'){
			$('.joinForm').append('<label>처리중.......</label>');			
			location.reload();
		}
		else{
			$('.joinForm').append('<label>잘못된 접근입니다.</label>');
		}
			
	})
}

