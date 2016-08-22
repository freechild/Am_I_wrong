jQuery.fn.center = function () {
    this.css("position","absolute");
    this.css("top", Math.max(0, (($(window).height() - $(this).outerHeight()) / 2) + $(window).scrollTop()) + "px");
    this.css("left", Math.max(0, (($(window).width() - $(this).outerWidth()) / 2) + $(window).scrollLeft()) + "px");
    return this;
}

//function pop_hide(){
//	$('.joinForm').hide();
//	$('#overlay').hide();
//}
//
//
//function showPopup(obj)  {
//	
//	whichBtn = $('#'+obj).attr('id')
//	var i = "<p>환영합니다!</p>";
//	//여기서부터 로그인박스 만듬			
//	$("#overlay").fadeTo(100, .3);
//	$('.joinForm').show();
//	$('.joinForm').center();
//	//alert(whichBtn);
//	message(whichBtn);		
//	
//	
//
//}

//message
function message(whichBtn){
	
	if (whichBtn =='join'){
		var i = "<p>환영합니다!</p>";		
		$('.joinForm').html("<h1>회원가입</h1>");					
		$('.joinForm').append("<span id='img_tag'><a href='javascript:pop_hide()'><img src='/resources/Image/ic_clear_white.png'></a></span>");					
		$('.joinForm').append(i);					
		$('.joinForm').append("<label>Name<span class='small'>이름 입력</span></label><input type='text' name='name' id='j_name'>");			
		$('.joinForm').append("<label>Email<span class='small'>이메일주소</span></label><input type='text' name='email' id='j_email' />");			
		$('.joinForm').append("<label>Password<span class='small'>패스워드 6자 이상</span></label><input type='text' name='pw' id='j_pw' />");			
		$('.joinForm').append("<button type='button' onclick='signUp()'>SIGN UP</button><div class='spacer'></div></form>");
		$('#j_name').focus();		
	}
	else{
		
		$('.joinForm').html("<h1>아이콘 클릭<h1><br>");
		$('.joinForm').append("<h1>ID찾기<h1>");
		$('.joinForm').append("<a href='javascript:find(\"id\")'><img src='/resources/Image/ic_email_white.png'></a>&nbsp;");		
		$('.joinForm').append("&nbsp;&nbsp;&nbsp;<h1>PW찾기<h1>");
		$('.joinForm').append("<a href='javascript:find(\"pw\")'><img src='/resources/Image/ic_key_white.png'></a>");		
		$('.joinForm').append("<span id='img_tag'><a href='javascript:pop_hide()'><img src='/resources/Image/ic_clear_white.png'></a></span>");
		$('.joinForm').append("<p></p>");	
	}
}
//패스워드 찾기 폼
function find(i){
	$('.joinForm').append("<div id='findForm'>");
	if(i=="id"){
		$('#findForm').html("<label>Name<span class='small'>이름 입력</span></label><input type='text' name='name' id='j_name'>");
		$('#findForm').append("<label>Hint<span class='small'>힌트답입력</span></label><input type='text' name='hint' id='j_hint'>");
	}else{
		$('#findForm').html("<label>Name<span class='small'>이름 입력</span></label><input type='text' name='name' id='j_name'>");
		$('#findForm').append("<label>Hint<span class='small'>email 입력</span></label><input type='text' name='email' id='j_email'>");		
	}
	$('#findForm').append("<span id='img_tag'><a href='javascript:pop_hide()'><img src='/resources/Image/ic_done_white.png'></a></span>");
	
}


function signUp(){
	var name = $('#j_name').val();
	var email = $('#j_email').val();
	var pw = $('#j_pw').val();
	$.ajax({
		url: 'joinUs',
		data:{
			"name" : name,
			"email": email,
			"pw" : pw
		}
	}).done(function(data){
		if(data=="true"){
			$('.joinForm').html("<h1>회원가입완료</h1>");
			$('.joinForm').append("이메일 인증 확인 후 사용해주세요.");
			$('.joinForm').append("<span id='img_tag'><a href='javascript:pop_hide()'><img src='/resources/Image/ic_done_white.png'></a></span>");
		}
		else{}
	});
}
$(document).ready(function(){
	
});

