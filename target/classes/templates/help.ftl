<#import "parts/common.ftl" as common>
<#import "parts/menus.ftl" as menus>

<@common.page>
    <@menus.adminNav/>
        <!-- Карусель -->
        <div class="row" style="text-align: center; margin-top: 3vh;">
            <div class="col-12">
                <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
                    <div class="carousel-inner">
                        <#if carouselImages??>
                            <#list carouselImages as image>
                                <div class="carousel-item<#if image_index == 0> active</#if>">
                                    <img class="d-block w-100" style="padding: 0 90px;" src="${image}" alt="Изображение ${image_index + 1}">
                                </div>
                            </#list>
                        <#else>
                            <div class="carousel-item active">
                                <img class="d-block w-100" src="placeholder.jpg" alt="Placeholder">
                            </div>
                        </#if>
                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" style = {{backgroundColor: green}} aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </div>
        </div>
    </div>
    <style>
        .carousel-control-prev-icon {
            background-image: url("data:image/svg+xml;charset=utf8,%3Csvg xmlns='http://www.w3.org/2000/svg' fill='%24a86d' viewBox='0 0 8 8'%3E%3Cpath d='M5.25 0l-4 4 4 4 1.5-1.5-2.5-2.5 2.5-2.5-1.5-1.5z'/%3E%3C/svg%3E") !important;
        }

        .carousel-control-next-icon {
            background-image: url("data:image/svg+xml;charset=utf8,%3Csvg xmlns='http://www.w3.org/2000/svg' fill='%24a86d' viewBox='0 0 8 8'%3E%3Cpath d='M2.75 0l-1.5 1.5 2.5 2.5-2.5 2.5 1.5 1.5 4-4-4-4z'/%3E%3C/svg%3E") !important;
        }
    </style>
    <script>
        document.addEventListener('DOMContentLoaded', function() {
            $('h2, h3').css('color', 'green');
            $('.featurette-heading, p').hide().fadeIn(2000);
            
            $('#carouselExampleControls').carousel();
        });
    </script>
</@common.page>
