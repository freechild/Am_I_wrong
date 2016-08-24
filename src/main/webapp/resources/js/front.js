$(document).ready(function(){
	$('#button').click(function(){
		$(this).toggleClass('on');
	});
});

//align
jQuery.fn.center = function () {
    this.css("position","absolute");
    this.css("top", Math.max(0, (($(window).height() - $(this).outerHeight()) / 2) + $(window).scrollTop()) + "px");
    this.css("left", Math.max(0, (($(window).width() - $(this).outerWidth()) / 2) + $(window).scrollLeft()) + "px");
    return this;
}

function pop_hide(){
	$('.joinForm').hide();
	$('#overlay').hide();
}

function showPopup(obj){
	$("#overlay").show("slow");
	$("#overlay").fadeTo(100, .3);
	$('.joinForm').show();
	$('.joinForm').center();
	if(obj == 'f_btn')
		loginForm("Welcome Passenger");
	else if(obj =='b_modi') 
		board_modi();
	else if(obj =='b_del') 
		board_del();
}

function loginForm(i){
	$('.joinForm').html("<h1>Login</h1>");					
	$('.joinForm').append("<span id='img_tag'><a href='javascript:pop_hide()'><img src='/resources/Image/ic_clear.png'></a></span>");
	$('.joinForm').append("<p>" + i + "</p>")
	$('.joinForm').append("<label><img src='/resources/Image/ic_email.png'><span class='small'>E-Mail</span></label><input type='text' name='email' id='l_email'>");
	$('.joinForm').append("<label><img src='/resources/Image/ic_key.png'><span class='small'>password</span></label><input type='password' name='pw' id='l_pw'>");
	$('.joinForm').append("<button type='button' onclick='Login()'>LOG IN</button><div class='spacer'></div></form>");
	$('.joinForm').append("<hr>");
	$('.joinForm').append("<label class='findthing'><a href='javascript:find(\"id\")'><img src='/resources/Image/ic_email_2x.png'></a><span class='small'>Find E-Mail</span></label>");
	$('.joinForm').append("<label class='findthing'><a href='javascript:find(\"pw\")'><img src='/resources/Image/ic_key_2x.png'></a><span class='small'> Find Pw</span></label>");
	$('.joinForm').append("<label class='findthing'><a href='javascript:addPerson(\"Welcom\")'><img src='/resources/Image/ic_person_add_2x.png'></a><span class='small'>Create Acc</span></label>");
	$('#l_email').focus();
}

function addPerson(i){
	$('.joinForm').html("<h1>회원가입</h1>");					
	$('.joinForm').append("<span id='img_tag'><a href='javascript:loginForm()'><img src='/resources/Image/ic_reply.png'></a>"
			+"<a href='javascript:pop_hide()'><img src='/resources/Image/ic_clear.png'></a></span>");					
	$('.joinForm').append("<p>"+i+"</p>");					
	$('.joinForm').append("<label>Name<span class='small'>이름 입력</span></label><input type='text' name='name' id='add_name'>");			
	$('.joinForm').append("<label>Email<span class='small'>사용하는 이메일로 기입</span></label><input type='text' name='email' id='add_email' />");			
	$('.joinForm').append("<label>Password<span class='small'>패스워드 6자 이상</span></label><input type='password' name='pw' id='add_pw' />");
	$('.joinForm').append("<label>Spares Key<span class='small'>좋아하는색</span></label><input type='password' name='hint' id='add_hint' />");
	$('.joinForm').append("<button type='button' onclick='signUp()'>SIGN UP</button><div class='spacer'></div></form>");
	$('#add_name').focus();
}

function find(i){
	$('.joinForm').html("<h1>" + i +" 찾기</h1>");
	$('.joinForm').append("<span id='img_tag'><a href='javascript:loginForm()'><img src='/resources/Image/ic_reply.png'></a>"
			+"<a href='javascript:pop_hide()'><img src='/resources/Image/ic_clear.png'></a></span>");					
	$('.joinForm').append("<p>연동유저일시 연동홈피에서 찾을수있음</p>");
	if(i=="id"){
		$('.joinForm').append("<label>Name<span class='small'>이름 입력</span></label><input type='text' name='name' id='f_name'>");
		$('.joinForm').append("<label>Hint<span class='small'>힌트답입력</span></label><input type='text' name='hint' id='f_hint'>");
	}else if(i=="pw"){
		$('.joinForm').append("<label>Name<span class='small'>이름 입력</span></label><input type='text' name='name' id='f_name'>");
		$('.joinForm').append("<label>E-mail<span class='small'>email 입력</span></label><input type='text' name='email' id='f_email'>");		
	}
	$('.joinForm').append("<span id='img_tag'><a href='javascript:pop_hide()'><img src='/resources/Image/ic_done.png'></a></span>");
	
}

function signUp(){
	$.ajax({
		type : 'GET',
		url : 'add_person',
		data:{
			"name" : $('#add_name').val(),
			"email": $('#add_email').val(),
			"pw" : $('#add_pw').val(),
			"hint" : $('#add_hint').val()
		}
	}).done(function(data){
		if(data == "true"){
			$('.joinForm').html("<h1>가입이 완료되었습니다.</h1>");
			$('.joinForm').append("<p>이메일 인증 후 사용하세요!</p>")
			$('.joinForm').append("<span id='img_tag'><a href='javascript:loginForm()'><img src='/resources/Image/ic_done.png'></a></span>");
		}else{
			addPerson(data);
		}
	});	
}

function Login(){
	$.ajax({
		
		url : 'login',
		data :{
			"email" : $('#l_email').val(),
			"pw" : $('#l_pw').val()
		}	
	}).done(function(data){
		if(data=="true"){
			var url = $('#l_email').val();
			$(location).attr('href',url+"/main");
		}
		else
			loginForm(data);
	})
}


