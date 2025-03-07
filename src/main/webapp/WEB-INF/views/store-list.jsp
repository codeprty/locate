<%-- JSP page to display a list of stores with options to edit or delete. --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Store List</title>
    <link rel="stylesheet" type="text/css" href="/css/styles.css">
</head>
<body>
    <h2>All Grocery Stores</h2>
    <table>
        <tr>
            <th>Name</th>
            <th>Phone Number</th>
            <th>Localities</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="store" items="${stores}">
            <tr>
                <td>${store.name}</td>
                <td>${store.phoneNumber}</td>
                <td><input type="text" name="localities" value="${store.localities}" readonly></td>
                <td>
                    <a href="/stores/edit/${store.id}">Edit</a>
                    <a href="/stores/delete/${store.id}" class="delete" onclick="return confirm('Are you sure?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href="/stores">Back to List</a> | <a href="/stores/add">Add Store</a>
</body>
</html>
