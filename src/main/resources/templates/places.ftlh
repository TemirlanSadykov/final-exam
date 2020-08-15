<#import "partials/main.ftlh" as main>
<@main.renderWith>

    <div class="container flex flex-col align-center">
    <h1>Все заведения</h1>
    <input class="form-control" id="Input" type="text" placeholder="Поиск" style="margin-top: 20px; margin-bottom: 20px">
    <div id="Table">
        <#list items as place>
           <div class="card" style=" display: inline-block; padding: 5px">
                <a href="/place/${place.id}"><img src="/images/${place.photo}"></a>
                <a href="/place/${place.id}"><p>${place.name}</p></a>
            </div>
        </#list>
    </div>
</div>
    <#include "partials/pagination.ftlh">
</@main.renderWith>
<script>
    $(document).ready(function(){
        $("#Input").on("keyup", function() {
            var value = $(this).val().toLowerCase();
            $("#Table div").filter(function() {
                $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
            });
        });
    });
</script>