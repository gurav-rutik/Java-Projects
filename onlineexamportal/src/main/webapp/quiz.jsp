<%@ page import="java.util.List" %>
<%@ page import="com.exam.model.Question" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quiz</title>
</head>
<body>
    <h1>Quiz</h1>
    <form action="ResultServlet" method="post">
        <%
            List<Question> questions = (List<Question>) request.getAttribute("questions");
            if (questions != null) {
                for (Question q : questions) {
        %>
        <p><%= q.getQuestion() %></p>
        <input type="radio" name="question<%= q.getId() %>" value="<%= q.getOption1() %>"> <%= q.getOption1() %><br>
        <input type="radio" name="question<%= q.getId() %>" value="<%= q.getOption2() %>"> <%= q.getOption2() %><br>
        <input type="radio" name="question<%= q.getId() %>" value="<%= q.getOption3() %>"> <%= q.getOption3() %><br>
        <input type="radio" name="question<%= q.getId() %>" value="<%= q.getOption4() %>"> <%= q.getOption4() %><br>
        <%
                }
            }
        %>
        <input type="submit" value="Submit Quiz">
    </form>
</body>
</html>