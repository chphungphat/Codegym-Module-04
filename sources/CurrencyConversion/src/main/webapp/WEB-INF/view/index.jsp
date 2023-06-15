<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Currency Conversion</title>
    <style>
        .block-container {
            display: block;
            justify-content: center;
            text-align: center;
        }

        h2 {
            display: block;
            justify-content: center;
            text-align: center;
        }
    </style>
</head>
<body>
<h2>
    USD TO VND:
</h2>
<div class="block-container">
    <div>
        <form action="/currency1" id="usdExchange" name="usdExchange" method="post">
            <input name="usdValue" type="text" id="usdValue">
            <button type="submit">exchange</button>
        </form>
    </div>
    <div>
        <p id="resultVND"><c:out value="${resultVND}"/></p>
    </div>

</div>
<h2>
    VND TO USD:
</h2>
<div class="block-container">
    <div>
        <form action="/currency2" id="vndExchange" name="vndExchange" method="post">
            <input name="vndValue" type="text" id="vndValue">
            <button type="submit">exchange</button>
        </form>

    </div>
    <div>
        <p id="resultUSD"><c:out value="${resultUSD}"/></p>
    </div>
</div>
</body>
</html>