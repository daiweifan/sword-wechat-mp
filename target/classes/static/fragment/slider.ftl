<div class="page">
    <div class="page__hd">
        <h1 class="page__title">Slider</h1>
        <p class="page__desc">滑块</p>
    </div>
    <div class="page__bd page__bd_spacing">
        <div class="weui-slider">
            <div class="weui-slider__inner">
                <div style="width: 0;" class="weui-slider__track"></div>
                <div style="left: 0;" class="weui-slider__handler"></div>
            </div>
        </div>
        <br>
        <div class="weui-slider-box">
            <div class="weui-slider">
                <div id="sliderInner" class="weui-slider__inner">
                    <div id="sliderTrack" style="width: 50%;" class="weui-slider__track"></div>
                    <div id="sliderHandler" style="left: 50%;" class="weui-slider__handler"></div>
                </div>
            </div>
            <div id="sliderValue" class="weui-slider-box__value">50</div>
        </div>
    </div>
    <div class="page__ft">
        <a href="javascript:home()"><img src="/images/icon_footer_link.png" /></a>
    </div>
</div>
<script type="text/javascript">
    $(function(){
        var $sliderTrack = $('#sliderTrack'),
            $sliderHandler = $('#sliderHandler'),
            $sliderValue = $('#sliderValue');

        var totalLen = $('#sliderInner').width(),
            startLeft = 0,
            startX = 0;

        $sliderHandler
            .on('touchstart', function (e) {
                startLeft = parseInt($sliderHandler.css('left')) * totalLen / 100;
                startX = e.changedTouches[0].clientX;
            })
            .on('touchmove', function(e){
                var dist = startLeft + e.changedTouches[0].clientX - startX,
                    percent;
                dist = dist < 0 ? 0 : dist > totalLen ? totalLen : dist;
                percent =  parseInt(dist / totalLen * 100);
                $sliderTrack.css('width', percent + '%');
                $sliderHandler.css('left', percent + '%');
                $sliderValue.text(percent);

                e.preventDefault();
            })
        ;
    });
</script>