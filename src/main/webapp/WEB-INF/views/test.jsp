<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js"></script>


<script>


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
    $('._popup').show("fast");
}


</script>
</head>
<body>
<input type="button" value="button" onclick="show_popup()">
<a href="javascript:show_popup();">팝업창 열기</a>

<br>
<hr>
<br>
<div class="_popup" style="width:100px;height:150px; border:2px solid #777;display:none;">
    저는 팝업창 입니다.
 <input type="text" id="test"> 
</div>
</body>
</html>