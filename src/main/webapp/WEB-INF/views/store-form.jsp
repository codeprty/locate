<%-- JSP form for adding or editing a store. Submits store details to "/stores/save". --%>
<html>
<head>
    <title>Add/Edit Store</title>
</head>
<body>
    <h2>${store.id == null ? "Add Store" : "Edit Store"}</h2>
    <form action="/stores/save" method="post">
        <input type="hidden" name="id" value="${store.id}">
        <label>Name:</label>
        <input type="text" name="name" value="${store.name}" required>
        <br>
        <label>Phone Number:</label>
        <input type="text" name="phoneNumber" value="${store.phoneNumber}" required>
        <br>
        <label>Localities:</label>
        <input type="text" name="localities" value="${store.localities}" required>
        <br>
        <button type="submit">Save</button>
    </form>
    <br>
    <a href="/stores">Back to List</a>
</body>
</html>
