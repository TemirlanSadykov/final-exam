<#import "partials/main.ftlh" as main>
<@main.renderWith>

    <div class="container flex flex-col align-center">
        <h1>All places</h1>
        <main class="flex flex-wrap align-evenly">
            <#list places as pl>
                <div class="card">
                        <img src="/images/${pl.photo}">
                        <p>${pl.name}</p>
                </div>
            </#list>
        </main>
    </div>
    <#include "partials/pagination.ftlh">
</@main.renderWith>