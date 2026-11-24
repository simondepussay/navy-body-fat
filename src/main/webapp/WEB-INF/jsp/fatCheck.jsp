<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
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
<title>Simon's Navy式 体脂肪率診断</title>
</head>
<body>
<h1>Simon's Navy式 体脂肪率診断</h1>
<p>メジャーで首・お腹（・ヒップ）を測って入力してください。</p>
<form action="FatCheck" method="post">
性別：
<label>
	<input type="radio" name="gender" value="male" checked>男性
</label>


<label>
	<input type="radio" name="gender" value="female">女性
</label><br>
身長：<input type="number" step="0.1" name="height" required>(cm)<br>
首回り：<input type="number" step="0.1" name="neck" required>(cm)　喉仏のすぐ下<br>
腹囲：<input type="number" step="0.1" name="waist" required>(cm)　男性はおへその高さ、女性は一番細いところ<br>
ヒップ：<input type="number" step="0.1" name="hip">(cm)　女性のみ・一番太いところ<br>
<input type="submit" value="診断">
</form>
</body>
</html>
