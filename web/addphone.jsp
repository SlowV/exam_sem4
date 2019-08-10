<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    HashMap<String, String> errors = (HashMap<String, String>) request.getAttribute("errors");
    StringBuilder strBuilder = new StringBuilder();
    if (errors != null  || errors.size() != 0) {
        for (Map.Entry<String, String> entry : errors.entrySet()) {
            strBuilder.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
    }
%>
<html>
<head>
    <title>Add phone</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-6 offset-md-3">
            <h2 class="text-primary">Form create phone</h2>
            <%
                if (strBuilder.length() > 0) {
            %>
            <div class="text-danger">
                <%= strBuilder.toString()%>
            </div>
            <%
            }
            %>
            <form action="/phone/create" method="post">
                <div>Name</div>
                <input type="text" name="name" class="form-control">
                <div>Price</div>
                <input type="number" name="price" class="form-control">
                <div>Brand</div>
                <select name="brand" class="form-control">
                    <option value="Apple" selected>Apple</option>
                    <option value="Samsung">Samsung</option>
                    <option value="Nokia">Nokia</option>
                    <option value="Others">Others</option>
                </select>
                <div>Description</div>
                <textarea name="description" cols="30" rows="10" class="form-control"></textarea>
                <div class="form-group mt-3">
                    <button class="btn btn-outline-success" type="submit">Submit</button>
                    <button class="btn btn-outline-secondary" type="reset">Reset</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script
        src="https://code.jquery.com/jquery-3.4.1.js"
        integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
        crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
