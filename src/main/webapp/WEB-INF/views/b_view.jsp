<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html >



<jsp:include page="index.jsp" />

<article>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
<script type="text/javascript">
	/*레이어 밖 누르면 감추기*/
	$(document).ready(function(){
		$(document).mousedown(function(e){
		$('._popup').each(function(){
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

	
	
	

// 레이어 보이기
	
	var whichButton;
	
	function show_popup(obj)
	{
		whichButton = $('#'+obj).attr("id");
		
		if(whichButton == "b_modi" || whichButton == "b_del")
	    	$('#b_popup').show("fast");
		else
			$('#c_popup').show("fast");
			
	    $("._popup").html("비밀번호 입력 & enter<br>");
	    $("._popup").append("<input type='text' size='6' id='password' onkeypress='checkPW(event)' />");
	    $("#password").focus();
	}

		
		
	function checkPW(event){
	    var keyCode = event.keyCode ? event.keyCode : event.which;
	    
	    // keyCode가 0이면 which 리턴
	    
	    // 혹은
	    keyCode = event.keyCode || which;
	 
	    //console.log(keyCode);
	    if (keyCode==13){
	    	var pw = $("#password").val(); 
	    	alert(pw)
	    	var idx = "${vo.idx}";
			//alert(pw);	    	    	
	    	
	    	$.ajax({
	    		type : 'GET',
	    		url :'b_checkPW',
	    		data:
	    		{
	    			"pw": pw ,
	    			"idx":idx,
	    			"whichButton":whichButton
	    			
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
	

	
	function comments(){
		var name = $(".comment_W input[name='name']").val();
		var pw = $(".comment_W input[name='pw']").val();
		var content = $(".comment_W input[name='content']").val();
		var ref = ${vo.idx};
		
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
	
	
</script>
	

	name : <c:out value="${vo.name }" /> ,
	ip : <c:out value="${vo.ip }" /> , 
	likes : <c:out value="${vo.hit }" /><br>
	title : <c:out value="${vo.title }" /> ,
	Date : <fmt:formatDate value="${vo.regdate }"/>   ->
	<hr>
	
	<c:set var ="content1" value="${vo.content } "/>
				<c:set var="content1" value="${fn:replace(content1,'<','&lt;') }"/>
				<c:set var="content1" value="${fn:replace(content1,newLine,br) }"/>
				${content1 } =>${p }
	<hr>
	<div align="right">	
		<input type="button" value="수정" id ="b_modi" onclick="show_popup('b_modi')">
		<input type="button" value="삭제" id ="b_del" onclick="show_popup('b_del')">
		<input type="button" value=" 돌아가기 " onclick="location.href='board?p=${p}&s=${s}&b=${b}'" />
		<div align="center" class="_popup"  id="b_popup" style="width:200px;
			height:60px; border:2px solid #777;display:none;">	 	 
		</div>
	</div>
	
	
	
	<hr>
	<br>
	<div class="comment_V">
		<c:if test="${empty clist }">
			등록된 댓글이 없습니다.
		</c:if>
		<c:if test="${!empty clist }">
			<c:forEach var="c" items="${clist }" varStatus="s">
				글쓴이 :<c:out value="${c.name }" /> /
				등록일: <fmt:formatDate value="${c.regdate }"/> 
				<input type="button" value="수정"  id="${c.idx }" onclick="show_popup('${c.idx}')">
				<input type="button" value="삭제"  id="${c.idx }" onclick="show_popup('${c.idx}')"><br>
				댓글 :<c:set var ="content" value="${c.content } "/>
				<c:set var="content" value="${fn:replace(content,'<','&lt;') }"/>
				<c:set var="content" value="${fn:replace(content,newLine,br) }"/>
				${content }<br>
				
			</c:forEach>
		</c:if>
	</div>

	<div align="center" class="_popup" id="c_popup" style="width:200px;
	height:60px; border:2px solid #777;display:none;">	 	 
	</div>
	<hr>
			${idx }
	<div class="comment_W">
		name : <input type="text" name="name" size="7">  pw : <input type="text" name="pw" size="7"> <br>
		댓글 : <input type="text" name="content" size="20px"><hr>
		<input type="button" value="전송" onclick="comments()">
		<input type="button" value="삭제" onclick="comments()">
	
	</div>
	
</article>

