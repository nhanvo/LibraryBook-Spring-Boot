<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="books" type="java.util.List<org.nhanvo.librarybook.domain.Book>" -->
<#-- @ftlvariable name="form" type="org.nhanvo.librarybook.domain.BookCreateForm" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>List of Books</title>
</head>
<body>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>        
    </ul>
</nav>

<h1>List of Books</h1>

<table>
    <thead>
    <tr>
        <th>Title</th>
        <th>Author</th>
        <th>Description</th>
        <th>CreateAt</th>
        <th>UpdateAt</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <#list books as book>
    <tr>
        <td><a href="/book/${book.id}">${book.title}</td>
        <td>${book.author}</td>
        <td>${book.description}</td>
        <td>${book.createdAt}</td>
        <td>${book.updateAt}</td>
        <td><a href="/book/edit/${book.id}">Edit</a></td>
        <td>
            <form role="form" name="form" action="/book/delete/${book.id}">
                <button type="submit">Delete</button>
            </form>
        </td>
    </tr>
    </#list>
    </tbody>
</table>
</body>
</html>