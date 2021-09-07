<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리 - Do IT</title>
<!-- 외부 스타일 시트 -->
	<link href='<%= request.getContextPath() %>/resources/css/all.css' rel='stylesheet'>
	<link href='<%= request.getContextPath() %>/resources/css/admin-Refund.css?afters' rel='stylesheet'>
</head>
<body>
	<!-- 모든 페이지에 include할 menubar.jsp 생성 -->
	<%@ include file='/WEB-INF/views/common/menubar.jsp' %>
	<!-- 관리자 nav -->
		<div class="admin-wrap">
			<nav id="admin-nav">
				<ul>
					<li>
						<a href="<%= request.getContextPath() %>/admin/home">회원관리</a>
					</li>
					<li>
						<a href="<%= request.getContextPath() %>/admin/study">스터디관리</a>
					</li>
					<li class="current">
						<a href="<%= request.getContextPath() %>/admin/refund">환불내역</a>
					</li>
					<li class="report">
						<a href="<%= request.getContextPath() %>/admin/reportMember">신고내역</a>
						<ul class="report-ul">
							<li><a href="<%= request.getContextPath() %>/admin/reportMember">-&ensp;회원</a></li>
							<li><a href="<%= request.getContextPath() %>/admin/reportStudy">-&ensp;스터디</a></li>
						</ul>
					</li>
				</ul>
			</nav>

        <!-- 관리자 content -->    
			<content class="content">
				<div id="board-list-wrap">
					<h1>환불 내역</h1>
					<div class="board-header">
						<div class="btn">
							<button type="button">환불</button>
						</div>
					</div>
					<table class="board-list">
						<caption>게시판 목록</caption>
						<thead>
							<tr>
                                <th>번호</th>
								<th>환불 신청 코인</th>
								<th>닉네임</th>
								<th>신청일</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><input type="checkbox">1</td>
								<td>30</td>
								<td>닉네임</td>
								<td>2021-09-10</td>
							</tr>

						</tbody>
					</table>
					<div class="paging">
						<a href="#" class="bt">&lt;&lt;</a>
						<a href="#" class="bt">&lt;</a>
						<a href="#" class="num on">1</a>
						<a href="#" class="num">2</a>
						<a href="#" class="num">3</a>
						<a href="#" class="num">4</a>
						<a href="#" class="num">5</a>
						<a href="#" class="num">6</a>
						<a href="#" class="num">7</a>
						<a href="#" class="num">8</a>
						<a href="#" class="num">9</a>
						<a href="#" class="num">10</a>
						<a href="#" class="bt">&gt;</a>
						<a href="#" class="bt">&gt;&gt;</a>
					</div>
				</div>
			</content>
		</div>

	<footer>
	<%@ include file='/WEB-INF/views/common/footer.jsp' %>
	</footer>
</body>
</html>