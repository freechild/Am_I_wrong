jQuery.fn.center = function () {
    this.css("position","absolute");
    this.css("top", Math.max(0, (($(window).height() - $(this).outerHeight()) / 2) + $(window).scrollTop()) + "px");
    this.css("left", Math.max(0, (($(window).width() - $(this).outerWidth()) / 2) + $(window).scrollLeft()) + "px");
    return this;
}

function pop_hide(){
	$('#joinUs').hide();
	$('#overlay').hide();
}


$(document).ready(function(){
	showPopup = function() {

		var i = "<p>암호확인구문</p>";
		//여기서부터 로그인박스 만듬			
		$("#overlay").fadeTo(100, .3);
		$('.joinform').html("<form id='form' name='form' method='post' action='board'>");						
		$('.joinform').append("<h1>회원가입</h1>");					
		$('.joinform').append("<span id='img_tag'><a href='javascript:pop_hide()'><img src='/resources/Image/ic_clear_white.png'></a></span>");					
		$('.joinform').append(i);					
		$('.joinform').append("<label>Name<span class='small'>이름 입력</span></label><input type='text'>");			
		$('.joinform').append("<label>Email<span class='small'>이메일주소</span></label><input type='text' name='email' id='email' />");			
		$('.joinform').append("<label>Password<span class='small'>패스워드 6자 이상</span></label><input type='text' name='password' id='password' />");			
		$('.joinform').append("<button type='submit'>SIGN UP</button><div class='spacer'></div></form>");			
		$('#joinUs').show();
		$('#joinUs').center();
			
	
		}
});