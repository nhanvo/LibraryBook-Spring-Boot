<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="book" type="org.nhanvo.librarybook.domain.Book" -->
<#-- @ftlvariable name="form" type="org.nhanvo.librarybook.domain.BookCreateForm" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Edit book</title>
</head>
<body>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
    </ul>
</nav>

<h1>Edit book</h1>

<form role="form" name="form" action="/book/edit/${book.id}" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <div>
        <label for="title">Title</label>
        <input type="text" name="title" id="title" value="${book.title}" required autofocus/>
    </div>
    <div>
        <label for="author">Author</label>
        <input type="text" name="author" id="author" value = "${book.author}" required/>
    </div>
    <div>
        <label for="description">Description</label>
        <input type="text" name="description" id="description" value = "${book.description}" required/>
    </div>
    <div>
        <label for="createdat">Create At</label>
        <input type="text" name="createdat" id="createdat" value = "${book.createdAt}" required/>
    </div>

    <div>
        <label for="updateat">Update At</label>
        <input type="text" name="updateat" id="updateat" value = "${book.updateAt}" required/>
    </div>

    <button type="submit">Save</button>
</form>

</body>
</html>