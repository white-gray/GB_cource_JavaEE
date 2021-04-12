<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <title>PageCatalog</title>
    </head>
    <body style="background-color:#2DEC7A;">
		<table align=center>
			<tr>
				<th style="text-align:center;border: 1px solid #2DEC7A;border-bottom: 3px solid #999;padding: 5px 12px;">Название</th>
				<th style="text-align:center;border: 1px solid #2DEC7A;border-bottom: 3px solid #999;padding: 5px 12px;">Стоимость</th>
				<th style="text-align:center;border: 1px solid #2DEC7A;border-bottom: 3px solid #999;padding: 5px 12px;">Количество</th>
				<th style="text-align:center;border: 1px solid #2DEC7A;border-bottom: 3px solid #999;padding: 5px 12px;">Описание</th>
			</tr>
			<tr>
				<td>
				<c:url value="${pageContext.request.contextPath}/PageItem1.jsp" var="item1"/>
                    <a href="${item1}">вещь1</a></td>
				<td style="text-align:center;">33р</td>
				<td style="text-align:center;">4</td>
				<td>прекрасная вещь!</td>
			</tr>
			<tr>
				<td>вещь2</td>
				<td style="text-align:center;">12р</td>
				<td style="text-align:center;">1</td>
				<td>так себе...</td>
			</tr>
			<tr>
				<td>вещь3</td>
				<td style="text-align:center;">123р</td>
				<td style="text-align:center;">44</td>
				<td>впечатляет!</td>
			</tr>
			<tr>
				<td>вещь4</td>
				<td style="text-align:center;">1234р</td>
				<td style="text-align:center;">445</td>
				<td>их много</td>
			</tr>
			<tr>
				<td>вещь5</td>
				<td style="text-align:center;">1р</td>
				<td style="text-align:center;">132</td>
				<td>преКраснс она! Т.е. именно красная!</td>
			</tr>
			<tr>
				<td>вещь6</td>
				<td style="text-align:center;">126р</td>
				<td style="text-align:center;">66</td>
				<td>оно того стоит</td>
			</tr>
			<tr>
				<td>вещь7</td>
				<td style="text-align:center;">22р</td>
				<td style="text-align:center;">4</td>
				<td>пригодится</td>
			</tr>
			<tr>
				<td>вещь8</td>
				<td style="text-align:center;">67р</td>
				<td style="text-align:center;">56</td>
				<td>неясно зачем нужна</td>
			</tr>
			<tr>
				<td>вещь9</td>
				<td style="text-align:center;">93р</td>
				<td style="text-align:center;">2</td>
				<td>отлично лежит!</td>
			</tr>

    </body>
</html>
