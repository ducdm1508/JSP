<%@ page contentType="text/html;charset=UTF-8" %>
<form method="post" action="../exam">
Name:<input name="name"/><span>${nameErr}</span><br/>
Duration:<input name="duration"/><span>${durErr}</span><br/>
Description:<input name="description"/><span>${desErr}</span><br/>
<button type="submit">Submit</button>
<a href="../exam">Cancel</a>
</form>