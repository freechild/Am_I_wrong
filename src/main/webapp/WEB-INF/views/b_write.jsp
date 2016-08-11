<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/form/top.jsp"%>

<div class="pagewidth" align="center">
	<div class="page-wrap">
		<div class="content">
			<form action="board?p=1&s=?&b=?" method="post">
				<table>

					<tr>
						<th>제&nbsp;&nbsp;&nbsp;&nbsp;목</th>
						<td><input type="text" name="subject" size="74"
							maxlength="100" class="boxTF" /></td>
					</tr>
					<tr>

							<th>작성자</th>
							<td><input type="text" name="name" size="35" maxlength="20"
								class="boxTF" /></td>
					</tr>
					<tr>
						
							<th>E-Mail</th>
							<td><input type="text" name="email" size="35" maxlength="50"
								class="boxTF" /></td>
					
					</tr>

					<tr>
					
							<th>내&nbsp;&nbsp;&nbsp;&nbsp;용</th>
							<td><textarea name="content" cols="63" rows="12"
									class="boxTA"></textarea></td>
						
					</tr>
					<tr>
						
							<th>패스워드</th>
							<td><input type="password" name="pwd" size="35"
								maxlength="7" class="boxTF" />&nbsp;(게시물 수정 및 삭제시 필요 !!!)</td>
					
					</tr>
					<tr>
							<td><input type="file" name="file" class="btn2"/></td>
					</tr>		
					<tr>
					
							<td><input type="submit" value=" 등록하기 " class="btn2"/>
							<input type="button" value=" 돌아가기 " class="btn2"
							onclick="history.back()"/>
							<input type="reset" value=" 다시입력 " class="btn2"
								onclick="document.myForm.subject.focus();" /></td>
					
					</tr>
				</table>
			</form>
		</div>
		<div class="clear"></div>
	</div>
</div>					


<%@ include file="/WEB-INF/views/form/bottom.jsp"%>