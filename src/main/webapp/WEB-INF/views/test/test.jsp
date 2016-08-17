<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js"></script>


<script>
jQuery.fn.center = function () {
    this.css("position","absolute");
    this.css("top", Math.max(0, (($(window).height() - $(this).outerHeight()) / 2) + $(window).scrollTop()) + "px");
    this.css("left", Math.max(0, (($(window).width() - $(this).outerWidth()) / 2) + $(window).scrollLeft()) + "px");
    return this;
}


/* 마우스 다운 이벤트 시에
* 사이트에서 뛰워놓은 팝업을 닫는다.
*/
$(document).ready(function(){
$(document).mousedown(function(e){
$('._popup').each(function(){
        if( $(this).css('display') == 'block' )
        {
            var l_position = $(this).offset();
            l_position.right = parseInt(l_position.left) + ($(this).width());
            l_position.bottom = parseInt(l_position.top) + parseInt($(this).height());


            if( ( l_position.left <= e.pageX && e.pageX <= l_position.right )
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


/*
* 레이어 팝업창 보이기
*/
function show_popup()
{
	$('.layer').show("fast");
    $('._popup').show("fast");
    $('._popup').center();
}


</script>
</head>
<body>
<input type="button" value="button" onclick="show_popup()">
<a href="javascript:show_popup();">팝업창 열기</a>

<br>
<hr>
<br>
<div class="layer"
		style="position: absolute; z-index: 9; width: 100%; height: 100%; left: 0px; top: 0px; display: none; background-color:red ; filter: alpha(opacity = 60); opacity: .6;">
		<!-- 페이지전체영역입니다. -->
</div>
dsadsadsadsadsadsadasd
<div class="_popup" style="position: absolute; z-index: 10; width: 200px; height: 200px; left: 50px; top: 50px; display: none; background-color: green">
    저는 팝업창 입니다.
 <input type="text" id="test"> 
</div>
</body>
</html>