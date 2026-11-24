<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="model.Body" %>
<%
// リクエストスコープに保存されたBodyを取得
Body body = (Body) request.getAttribute("body");
boolean isMale = "male".equals(body.getGender());
%>
<!DOCTYPE html>
<html>

<style>
	body {
	    margin: 0;
	    min-height: 100vh;
	    display: flex;
	    flex-direction: column;
	    justify-content: center;
	    align-items: center;
	    text-align: center;
	  }
</style>

<head>
<meta charset="UTF-8">
<title>Navy式 体脂肪率診断</title>
</head>
<body>
<h1>結果は。。。。？</h1>
<p>
性別：<%= isMale ? "男性" : "女性" %><br>
身長：<%= body.getHeight() %> cm<br>
首回り：<%= body.getNeck() %> cm<br>
腹囲：<%= body.getWaist() %> cm<br>
<% if (!isMale) { %>
ヒップ：<%= body.getHip() %> cm<br>
<% } %>
体脂肪率：<%= body.getFatPercent() %> %<br>
判定：<%= body.getCategory() %>
</p>
<img src="images/<%= body.getImage() %>" alt="<%= body.getCategory() %>" width="200">
<a href="FatCheck">戻る</a>
</body>
</html>
