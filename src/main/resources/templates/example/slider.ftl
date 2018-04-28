<#assign contentBody>  
  <header class='demos-header'>
      <h1 class="demos-title">Slider</h1>
    </header>
    <div class='demos-content-padded'>
      <div class="weui-slider" id='slider1'>
        <div class="weui-slider__inner">
          <div style="width: 0;" class="weui-slider__track"></div>
          <div style="left: 0;" class="weui-slider__handler"></div>
        </div>
      </div>
      <br>
      <div class="weui-slider-box" id='slider2'>
        <div class="weui-slider">
          <div id="sliderInner" class="weui-slider__inner">
            <div id="sliderTrack" style="width: 75%;" class="weui-slider__track"></div>
            <div id="sliderHandler" style="left: 75%;" class="weui-slider__handler"></div>
          </div>
        </div>
        <div id="sliderValue" class="weui-slider-box__value">75</div>
      </div>
    </div>

    <script>
      $('#slider1').slider();
      $('#slider2').slider(function (per) {
        console.log(per);
      });
    </script>
</#assign>  
<#include "/shared/layout.ftl" />  