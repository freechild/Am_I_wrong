<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="index.jsp" />
<script type="text/javascript">
	function formCheck(obj){
		if(!obj.name.value){
			alert('이름은 반드시 입력해야 합니다.');
			obj.name.focus();
			return false;
		}
		
		if(!obj.pw.value){
			alert('암호는 반드시 입력해야 합니다.');
			obj.pw.focus();
			return false;
		}
		
		if(!obj.title.value){
			alert('제목은 반드시 입력해야 합니다.');
			obj.title.focus();
			return false;
		}
		
		if(!obj.content.value){
			alert('내용은 반드시 입력해야 합니다.');
			obj.content.focus();
			return false;
		}
		return true;
	}
</script>


<article>
	<div align="center">
		<c:if test="${!empty modi }">
		<form action="b_modiView" onsubmit="return formCheck(this);">
		<input type="hidden" value="${modi }" name="modi">
		<input type="hidden" value="${vo.idx }" name="idx">
		</c:if>
		<c:if test="${empty modi }">
		<form action="b_writeOk?p=1&s=${p }&b=${b}" onsubmit="return formCheck(this);">
		<input type="hidden" value="${p }" name="s">
		<input type="hidden" value="${b }" name="b">
		</c:if>
			<table>

				<tr>
					<th>제&nbsp;&nbsp;&nbsp;&nbsp;목</th>
					<td>
						<c:if test="${!empty modi}">
							<input type="text" name="title" size="50" maxlength="100" class="boxTF"
							value="${vo.title }" />
						</c:if>
						
						<c:if test="${empty modi }">
							<input type="text" name="title" size="50" maxlength="100" class="boxTF" />
						</c:if>
					</td>
				</tr>
				<tr>
					<th align="center">카테고리 선택</th>
					<td colspan="3" style="border: none;">
						<select id="${cid }" name="categoryid">
							<c:forEach var="c" items="${categories }">
								<option value="${c.idx}"
									${c.idx==cid?" selected='selected' ":"" }>
									${c.item }
								</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>

					<th>작성자</th>
					<td>
						<c:if test="${!empty modi}">
							<input type="text" name="name" size="35" maxlength="20" class="boxTF" 
							value="${vo.name }" readonly="readonly"/>
						</c:if>
						<c:if test="${empty modi }">
							<input type="text" name="name" size="35" maxlength="20" class="boxTF" />
						</c:if>
					
					</td>
				
				</tr>
				<tr>

					<th>E-Mail</th>
					<td>
						<c:if test="${!empty modi }">
							<input type="text" name="email" size="35" maxlength="50"
							 	value="${vo.email }" class="boxTF" />						
						</c:if>
						<c:if test="${empty modi }">
							<input type="text" name="email" size="35" maxlength="50"
								class="boxTF" />						
						</c:if>
					</td>

				</tr>

				<tr>

					<th>내&nbsp;&nbsp;&nbsp;&nbsp;용</th>
					<td>
						<c:if test="${!empty modi }">
							<textarea name="content" cols="63" rows="12" class="boxTA" >${vo.content }</textarea>
						</c:if>
						<c:if test="${empty modi }">
							<textarea name="content" cols="63" rows="12" class="boxTA"></textarea>
						</c:if>	
					</td>

				</tr>
				<tr>

					<th>패스워드</th>
					<td><input type="password" name="pw" size="35" maxlength="7"
						class="boxTF" />&nbsp;(게시물 수정 및 삭제시 필요 !!!)</td>

				</tr>
				<tr>
					<td><input type="file" name="file" class="btn2" /></td>
				</tr>
				<tr>

					<td>
						<input type="submit" value=" 등록하기 "  /> 
						<input type="button" value=" 돌아가기 " onclick="history.back()" />
						<input type="reset" value=" 다시입력 " onclick="document.myForm.subject.focus();" />
					</td>

				</tr>
			</table>
		</form>
		<div class="clear"></div>
	</div>
</article>