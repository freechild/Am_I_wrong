<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html >



<jsp:include page="index.jsp" />

<article>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
<script type="text/javascript">
	/*���̾� �� ������ ���߱�*/
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
		$(".comment_V").html("<c:if test='${empty clist }'>");
		$(".comment_V").append("����� �����ϴ�.");
		$(".comment_V").append("</c:if>");
		$(".comment_V").append("<c:if test='${! empty clist }'>");
		$(".comment_V").append("<c:forEach var='c' items='clist'>");
		$(".comment_V").append("<c:out value='${c.name }' />");
		$(".comment_V").append("<fmt:formatDate value='${c.regdate }' /> <br>");
		$(".comment_V").append("<c:set var ='content2' value='${c.content } '/>");
		$(".comment_V").append("<c:set var='content2' value='${fn:replace(content2,'<','&lt;') }'/>");
		$(".comment_V").append("<c:set var='content2' value='${fn:replace(content2,newLine,br) }'/>");
		$(".comment_V").append("${content2 }");
		$(".comment_V").append("</c:forEach>");
		$(".comment_V").append("</c:if>	");
		
		
	})

	
	
	

/* ���̾� ���̱�*/
	
	var whichButton;
	
	function show_popup(obj)
	{
		whichButton = $('#'+obj).attr("id");
		
	    $('._popup').show("fast");
	    $("._popup").html("��й�ȣ �Է� & enter<br>");
	    $("._popup").append("<input type='text' size='6' id='password' onkeypress='checkPW(event)' />");
	    $("#password").focus();
	}

	function checkPW(event){
	    var keyCode = event.keyCode ? event.keyCode : event.which;
	    
	    // keyCode�� 0�̸� which ����
	    
	    // Ȥ��
	    keyCode = event.keyCode || which;
	 
	    //console.log(keyCode);
	    if (keyCode==13){
	    	var pw = $("#password ").val(); 
	    	var idx = "${vo.idx}";
			//alert(pw);	    	    	
	    	
	    	$.ajax({
	    		type : "GET",
	    		url :'b_checkPW',
	    		data:
	    		{
	    			"pw": pw ,
	    			"idx":idx,
	    			"whichButton":whichButton
	    			
	    		}
	    	}).done(function(data){
    			if (data=="false"){
	    			$("._popup").html("��ȣ����ġ<br>");
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
		});
		
		
	}
	
	
</script>
	

	name : <c:out value="${vo.name }" /> ,
	ip : <c:out value="${vo.ip }" /> , 
	likes : <c:out value="${vo.hit }" /><br>
	title : <c:out value="${vo.title }" /> ,
	Date : <fmt:formatDate value="${vo.regdate }"/>   ->
	${category }<hr>
	
	<c:set var ="content1" value="${vo.content } "/>
				<c:set var="content1" value="${fn:replace(content1,'<','&lt;') }"/>
				<c:set var="content1" value="${fn:replace(content1,newLine,br) }"/>
				${content1 }
	<hr>
	<div align="right">	
		<input type="button" value="����" id ="modi" onclick="show_popup('modi')">
		<input type="button" value="����" id ="del" onclick="show_popup('del')">
		<input type="button" value=" ���ư��� " onclick="history.back()" />
		<div align="center" class="_popup" style="width:200px;
			height:60px; border:2px solid #777;display:none;">	 	 
		</div>
	</div>
	
	
	
	<hr>
	<br>
	<div class="comment_V">
		
	</div>
	<hr>
	<div class="comment_W">
		name : <input type="text" name="name" size="7">  pw : <input type="text" name="pw" size="7"> <br>
		��� : <input type="text" name="content" size="20px"><hr>
		<input type="button" value="����" onclick="comments()">
	
	</div>
	
</article>

