<#import "partials/main.ftlh" as main>
<@main.renderWith styles=["style.css"]>

        <div class="content row" style="white-space: pre-wrap">
                <div style="display: inline-block" class="col-md-6">
                    <h1>${place.name}</h1>
                    <p>${place.description}</p>
                </div>
                <div style="display: inline-block" class="col-md-6">
                    <img src="/images/${place.photo}">
                </div>
        </div>
    <hr>
        <div>
            <h3>Галлерея</h3>
            <#list review as rw >
                <div class="imageGallery1" style="display: inline">
                    <img src="/images/${rw.image}">
                </div>
            </#list>
        </div>
    <hr>
        <div>
            <h3>Рейтинг</h3>
                <#if stars == 1>
                <div class="rating-result" >
                    <span class="active"></span>
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                </div>
                <#elseif stars == 2>
                <div class="rating-result" >
                    <span class="active"></span>
                    <span class="active"></span>
                    <span></span>
                    <span></span>
                    <span></span>
                </div>
                <#elseif stars == 3>
                <div class="rating-result" >
                    <span class="active"></span>
                    <span class="active"></span>
                    <span class="active"></span>
                    <span></span>
                    <span></span>
                </div>
                <#elseif stars == 4>
                <div class="rating-result" >
                    <span class="active"></span>
                    <span class="active"></span>
                    <span class="active"></span>
                    <span class="active"></span>
                    <span></span>
                </div>
                <#elseif stars == 5>
                <div class="rating-result" >
                    <span class="active"></span>
                    <span class="active"></span>
                    <span class="active"></span>
                    <span class="active"></span>
                    <span class="active"></span>
                </div>
                <#elseif stars == 0>
                    <div class="rating-result" >
                        <span></span>
                        <span></span>
                        <span></span>
                        <span></span>
                        <span></span>
                    </div>
            </#if>
        </div>
    <hr>
        <div>
            <h3>Комментарии</h3>
            <#list review as rw>
                <div>
                    <p style="color: darkgray;">Число ${rw.date?date}, автор ${rw.user.login}, сказал:</p>
                    <p>${rw.comment}</p>
                </div>
            </#list>
        </div>
    <hr>
        <form id="login-form" action="/place/review" method="post" enctype="multipart/form-data" style="margin-top: 20px">

            <#if _csrf??>
                <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
            </#if>

            <input type="hidden" name="placeId" value="${place.id}"/>
            <h3 class="text-center">Оставьте комментарий</h3>
            <div class="form-group">
                <label>Введите комментарий</label>
                <textarea type="text" name="comment" class="form-control" placeholder="Комментарий" autofocus></textarea>
                <#if errors??>
                    <#list errors as fieldError>
                        <#if fieldError.field == 'comment'>
                            <div class="alert alert-warning mt-1" role="alert">${fieldError.defaultMessage!'-- no message --'}</div>
                        </#if>
                    </#list>
                </#if>
            </div>
            <div class="form-group">
                <label>Выберите рейтинг (по вашему мнению)</label>
                <div class="rating-area">
                    <input type="radio" id="star-5" name="stars" value="5">
                    <label for="star-5" title="Оценка «5»"></label>
                    <input type="radio" id="star-4" name="stars" value="4">
                    <label for="star-4" title="Оценка «4»"></label>
                    <input type="radio" id="star-3" name="stars" value="3">
                    <label for="star-3" title="Оценка «3»"></label>
                    <input type="radio" id="star-2" name="stars" value="2">
                    <label for="star-2" title="Оценка «2»"></label>
                    <input type="radio" id="star-1" name="stars" value="1">
                    <label for="star-1" title="Оценка «1»"></label>
                </div>
                <#if errors??>
                    <#list errors as fieldError>
                        <#if fieldError.field == 'stars'>
                            <div class="alert alert-warning mt-1" role="alert">${fieldError.defaultMessage!'-- no message --'}</div>
                        </#if>
                    </#list>
                </#if>
            </div>
            <div class="form-group">
                <label>Выберите фото</label>
                <input type="file" name="image" class="form-control">
                <#if errors??>
                    <#list errors as fieldError>
                        <#if fieldError.field == 'image'>
                            <div class="alert alert-warning mt-1" role="alert">${fieldError.defaultMessage!'-- no message --'}</div>
                        </#if>
                    </#list>
                </#if>
            </div>
            <button class="btn btn-primary btn-block">Оставить комментарий</button>
        </form>
</@main.renderWith>