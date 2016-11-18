<html>
<head>
    <title>Welcome!</title>
    <style>
        .wrapper {
            width: 500px;
            height: 200px;
            border: 1px solid black;
            overflow: hidden; /* will contain if #first is longer than #second */
        }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://cdn.rawgit.com/nnattawat/flip/master/dist/jquery.flip.min.js"></script>
    <script>
        $(document).ready(function () {
            $("div[id^='card-']").flip();
        });
    </script>
</head>
<body>
<#list cards as card>
<div class="wrapper">
<div id="card-${card.id}">
    <div class="front">
    ${card.word}
    </div>
    <div class="back">
    ${card.meaning}
    </div>
</div>
</div>
</#list>
</body>
</html>