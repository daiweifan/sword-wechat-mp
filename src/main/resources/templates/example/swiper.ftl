<#assign contentBody>  
 <div class="swiper-container">
      <!-- Additional required wrapper -->
      <div class="swiper-wrapper">
        <!-- Slides -->
        <div class="swiper-slide"><img src="${u.ctx}/images/swiper-1.jpg" /></div>
        <div class="swiper-slide"><img src="${u.ctx}/images/swiper-2.jpg" /></div>
        <div class="swiper-slide"><img src="${u.ctx}/images/swiper-3.jpg" /></div>
      </div>
      <!-- If we need pagination -->
      <div class="swiper-pagination"></div>
    </div>


    <script>
      $(".swiper-container").swiper({
        loop: true,
        autoplay: 3000
      });
    </script>
</#assign>  
<#include "/shared/layout.ftl" />  