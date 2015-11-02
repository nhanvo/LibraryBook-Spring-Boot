<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="form" type="org.nhanvo.librarybook.domain.BookCreateForm" -->
<#import "/spring.ftl" as spring>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Create a new book</title>
</head>
<body>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
    </ul>
</nav>

<h1>Create a new book</h1>

<form role="form" name="form" action="" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <div>
        <label for="title">Title</label>
        <input type="text" name="title" id="title" required autofocus/>
    </div>
    <div>
        <label for="author">Author</label>
        <input type="text" name="author" id="author" required/>
    </div>
    <div>
        <label for="description">Description</label>
        <input type="text" name="description" id="description" required/>
    </div>
    <div>
        <label for="createdat">Create At</label>
        <input type="text" name="createdat" id="createdat" required/>
    </div>

    <div>
        <label for="updateat">Update At</label>
        <input type="text" name="updateat" id="updateat" required/>
    </div>

    <button type="submit">Save</button>
</form>

<@spring.bind "form" />
<#if spring.status.error>
<ul>
    <#list spring.status.errorMessages as error>
        <li>${error}</li>
    </#list>
</ul>
</#if>

</body>
</html>