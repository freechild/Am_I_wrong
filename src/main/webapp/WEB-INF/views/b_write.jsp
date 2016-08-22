<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">

<%@ include file="include.jsp"%>
<jsp:include page="index.jsp" />

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
<script src="/resources/js/mainIn.js"></script>
<script src="/resources/js/b_write.js"></script>

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
					<td><input type="file" name="file" class="btn2" /></td>
				</tr>
				<tr>

					<td align="center">
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