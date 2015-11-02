<#-- @ftlvariable name="book" type="org.nhanvo.librarybook.domain.Book" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Book details</title>
</head>
<body>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
        <li><a href="/books/">Back</a></li>
    </ul>
</nav>

<h1>Book details</h1>

<p>Title: ${book.title}</p>

<p>Author: ${book.author} </p>

<p>Description: ${book.description} </p>

<p>Create At: ${book.createdAt}</p>

<p>Update At: ${book.updateAt}</p>

</body>
</html>