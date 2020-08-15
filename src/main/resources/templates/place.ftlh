<#import "partials/main.ftlh" as main>
<@main.renderWith>
    <div class="mx-auto mt-3 w-50">
        <form id="login-form" action="/place/new" method="post" enctype="multipart/form-data">

            <#if _csrf??>
                <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
            </#if>

            <h3 class="text-center">Add new place</h3>
            <div class="form-group">
                <label>Введите Название</label>
                <input type="text" name="name" class="form-control" placeholder="Название" autofocus>
                <#if errors??>
                    <#list errors as fieldError>
                        <#if fieldError.field == 'name'>
                            <div class="alert alert-warning mt-1" role="alert">${fieldError.defaultMessage!'-- no message --'}</div>
                        </#if>
                    </#list>
                </#if>
            </div>
            <div class="form-group">
                <label>Введите Описание</label>
                <textarea name="description" class="form-control" placeholder="Описание"></textarea>
                <#if errors??>
                    <#list errors as fieldError>
                        <#if fieldError.field == 'description'>
                            <div class="alert alert-warning mt-1" role="alert">${fieldError.defaultMessage!'-- no message --'}</div>
                        </#if>
                    </#list>
                </#if>
            </div>
            <div class="form-group">
                <label>Выберите фото</label>
                <input type="file" name="photo" class="form-control">
                <#if errors??>
                    <#list errors as fieldError>
                        <#if fieldError.field == 'photo'>
                            <div class="alert alert-warning mt-1" role="alert">${fieldError.defaultMessage!'-- no message --'}</div>
                        </#if>
                    </#list>
                </#if>
            </div>
            <button class="btn btn-primary btn-block">Создать</button>
        </form>
    </div>
</@main.renderWith>