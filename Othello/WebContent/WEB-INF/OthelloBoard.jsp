<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "model.Board.Board" %>
    <% Board board = (Board)application.getAttribute("Board"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <!-- <meta http-equiv="refresh" content="1" > -->
<title>オセロ</title>
<style type="text/css">
#field td {
border: 1px solid black;
width: 50px;
height: 50px;
background-color: green;
text-align: center;
vertical-align: middle;
table-layout: fixed;
padding: 1px 1px 1px 1px;
font-size: 33px;
}
</style>

</head>
<body>


<table id = "field" name = "" >
<%for(int i=0;i<8;i++){%>
<tr>
<%for(int j=0;j<8;j++){
    String state = board.getPieceState(i,j);
%>
<td id = <%=j%>_<%=i%> ><%= state%></td>
<%}} %>
</tr>
</table>

<select id = "state">
<option value = "kuro">黒</option>
<option value = "siro">白</option>
</select>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type = "text/javascript">
 $('table').on('click','td',function(){
	  var url = "/Othello/OthelloMain?id=" + $(this).attr('id')+"&state="+$("#state").val();
	  location.href = url;
	})
</script>

</body>
</html>