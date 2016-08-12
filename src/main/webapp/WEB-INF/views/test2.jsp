<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script>
  function keycheck(event){
    var keyCode = event.keyCode ? event.keyCode : event.which;
    // keyCode가 0이면 which 리턴
    
    // 혹은
    keyCode = event.keyCode || which;
 
    console.log(keyCode);
    if(keyCode==13)
    	alert("ok");
  }
  $('input').on('keydown', function(event) {
	    console.log(event.keyCode);
	});

</script>
<!-- 키보드 액션 -->
<input type="text" onkeypress="keycheck(event)"/>