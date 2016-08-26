<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../index.jsp"%>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
<script src="/resources/js/mainIn.js"></script>
<script src="/resources/js/front.js"></script>
<script src="/resources/js/invites.js"></script>
<link rel="stylesheet" type="text/css" href="/resources/css/friendList.css" />
<article>
	<div class="searchList" align="center">
		<table class="search_person" width="100%" cellspacing='0'>
			<!-- cellspacing='0' is important, must stay -->

			<!-- .search_person Header -->
			<thead>
				<tr>
					<th>검색어</th>
					<th><input type="search" id="search" onkeypress='search(event)'></th>
					<th><input type="button" value="seach"></th>
				</tr>
			</thead>
			<!-- .search_person Header -->

			<!-- .search_person Body -->
			<tbody>
				<tr>
					<td>Create pretty .search_person design</td>
					<td>100%</td>
					<td>Yes</td>
				</tr>
				<!-- .search_person Row -->
				<tr class="even">
					<td><a href="#yep-iit-doesnt-exist">Hyperlink Example</a></td>
					<td>80%</td>
					<td><a href="#inexistent-id">Another</a></td>
				</tr>
			</tbody>
			<!-- .search_person Body -->
		</table>
	</div>
</article>