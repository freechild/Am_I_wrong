
/*레이어 밖 누르면 감추기*/
$(document).ready(function(){
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
function comments(){
	var name = $(".comment_W input[name='name']").val();
	var pw = $(".comment_W input[name='pw']").val();
	var content = $(".comment_W input[name='content']").val();
	var ref = $("#idx").val();
	$.ajax({
		url: "b_comment",
		data :
		{
			"name" : name,
			"ref" : ref,
			"pw" : pw,
			"content" : content
		}
	}).done(function(data){		
		var url = data;    
		$(location).attr('href',url);
		//$(".comment_V").html(data);
	});
	
	
}



