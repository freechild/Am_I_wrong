<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<%@ include file="include.jsp" %>
<%@ include file="index.jsp" %>

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
<script src="/resources/mainIn.js"></script>
<script src="/resources/board.js"></script>
<script>
</script>
<article class="pagewidth" >
	<div align="center">
		<table class="board"  border="1" style="border:none;" >

			<tr>
				<th colspan="5" style="border: none;">
					<span style="font-size: 20pt;"> 
						자유게시판   &nbsp;&nbsp;&nbsp;&nbsp;
					</span>
				</th>
			</tr>
			<tr>
				<td style="border: none;" align="right" colspan="5">
					<!-- 카테고리와 페이징 정보 -->  
			<select id="category" onchange="categoryChange(this.value);">
				<option value="0">전체보기</option>
				
				<c:forEach var="c" items="${categories }">
					<option value="${c.idx}" ${c.idx==cid?" selected='selected' ":"" }>
					${c.item }
					</option>
				</c:forEach>
			</select>
			
			&nbsp;&nbsp;&nbsp;${board.totalCount }개
			<c:if test="${board.totalCount>0 }">
				(${board.currentPage }/${board.totalPage }Page)
			</c:if>
		</td>
	</tr>
	
			<!-- 색상 결정 -->
			<tr bgcolor="white">
				<th>No</th>
				<th width="58%">제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			
	<c:if test="${board.totalCount==0 }">
		<tr bgcolor="white">
			<th colspan="5">
			등록된 글이 없습니다.
			</th>
		</tr>
	</c:if>
	<c:if test="${board.totalCount>0 }">
		<c:forEach var="v" items="${board.list }" varStatus="s">
		
			<tr>
				<td align="center">
				<!-- 글번호는 계산을해서 찍자! -->
				${board.totalCount-(board.currentPage-1)*board.pageSize-s.index }
				</td>
				<td>
					&nbsp;
					<a href="b_view?idx=${v.idx }&p=${board.currentPage }&s=${board.pageSize }&b=${board.blockSize }&cid=${cid}">
					<c:out value="${v.title }"/>
					</a>
		

					<!-- 댓글의 개수를 출력한다. -->
			
					<c:if test="${countList[s.index]>0 }">
						- (${countList[s.index] })
					</c:if>
		
				</td>
				<td align="center">
					<c:out value="${v.name }"/>
				</td>
				<td align="center">
					<fmt:formatDate value="${v.regdate }"/>
				</td>
				<td align="center">${v.hit }</td>
			</tr>
		</c:forEach>
	</c:if>
	

			<tr>
				<td align="center" colspan="5" style="border: none;">
					<!-- 페이지이동 처리 --> <!-- 이전 -->
			<c:if test="${board.startPage>1 }">
				[<a href="?p=${board.startPage-1 }&s=${board.pageSize }&b=${board.blockSize}&cid=${cid}">이전</a>] 
			</c:if>
			  <!-- 페이지리스트  -->
			<c:forEach var="i" begin="${board.startPage }" end="${board.endPage }">
				<c:if test="${board.currentPage==i }">
					[${i }] 
				</c:if>
				<c:if test="${board.currentPage!=i }">
					[<a href="?p=${i }&s=${board.pageSize }&b=${board.blockSize}&cid=${cid}">${i }</a>] 
				</c:if>
			</c:forEach>
			 <!-- 다음  -->
			<c:if test="${board.endPage<board.totalPage }">
				[<a href="?p=${board.endPage+1 }&s=${board.pageSize }&b=${board.blockSize}&cid=${cid}">다음</a>] 
			</c:if>
		</td>
	</tr>
	
			
			<tr>
				<td align="center" colspan="5" style="border: none;">
					<form action="b_search" method="get">
						<input type="hidden" name="s" value="${pageSize }"> 
						<input type="hidden" name="b" value="${blockSize }"> 
						<input type="hidden" name="c" value="${cid }"> 
						<select id="search" name="search">
							<option value="all">전체</option>
							<option value="name">이름</option>
							<option value="title">제목</option>
							<option value="content">내용</option>
						</select> 
						<input type="text" name="searchContent" > 
						<input type="submit" value="검색">
					</form>
				</td>
			</tr>
			<tr>
				<td align="right" colspan="5" style="border: none;"><c:if
						test="${!empty search }">
						<input type="button" value="전체보기"
							onclick="location.href='index.jsp?p=1&s=${board.pageSize }&b=${board.blockSize}&cid=${cid}'">
					</c:if> <input type="button" value="글쓰기"
					onclick="location.href='b_write?p=1&s=${p }&b=${b}&cid=${cid}'">
				</td>
			</tr>
		</table>
					
	</div>
</article>		



