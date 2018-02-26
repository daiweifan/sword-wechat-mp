<div class="page">
    <div class="page__hd">
        <h1 class="page__title">Dialog</h1>
        <p class="page__desc">对话框</p>
    </div>
    <div class="page__bd page__bd_spacing">
        <a href="javascript:;" class="weui-btn weui-btn_default" id="showIOSDialog1">iOS Dialog样式一</a>
        <a href="javascript:;" class="weui-btn weui-btn_default" id="showIOSDialog2">iOS Dialog样式二</a>
        <a href="javascript:;" class="weui-btn weui-btn_default" id="showAndroidDialog1">Android Dialog样式一</a>
        <a href="javascript:;" class="weui-btn weui-btn_default" id="showAndroidDialog2">Android Dialog样式二</a>
    </div>
    <div class="page__ft">
        <a href="javascript:home()"><img src="/images/icon_footer_link.png" /></a>
    </div>

    <div id="dialogs">
        <!--BEGIN dialog1-->
        <div class="js_dialog" id="iosDialog1" style="display: none;">
            <div class="weui-mask"></div>
            <div class="weui-dialog">
                <div class="weui-dialog__hd"><strong class="weui-dialog__title">弹窗标题</strong></div>
                <div class="weui-dialog__bd">弹窗内容，告知当前状态、信息和解决方法，描述文字尽量控制在三行内</div>
                <div class="weui-dialog__ft">
                    <a href="javascript:;" class="weui-dialog__btn weui-dialog__btn_default">辅助操作</a>
                    <a href="javascript:;" class="weui-dialog__btn weui-dialog__btn_primary">主操作</a>
                </div>
            </div>
        </div>
        <!--END dialog1-->
        <!--BEGIN dialog2-->
        <div class="js_dialog" id="iosDialog2" style="display: none;">
            <div class="weui-mask"></div>
            <div class="weui-dialog">
                <div class="weui-dialog__bd">弹窗内容，告知当前状态、信息和解决方法，描述文字尽量控制在三行内</div>
                <div class="weui-dialog__ft">
                    <a href="javascript:;" class="weui-dialog__btn weui-dialog__btn_primary">知道了</a>
                </div>
            </div>
        </div>
        <!--END dialog2-->
        <!--BEGIN dialog3-->
        <div class="js_dialog" id="androidDialog1" style="display: none;">
            <div class="weui-mask"></div>
            <div class="weui-dialog weui-skin_android">
                <div class="weui-dialog__hd"><strong class="weui-dialog__title">弹窗标题</strong></div>
                <div class="weui-dialog__bd">
                    弹窗内容，告知当前状态、信息和解决方法，描述文字尽量控制在三行内
                </div>
                <div class="weui-dialog__ft">
                    <a href="javascript:;" class="weui-dialog__btn weui-dialog__btn_default">辅助操作</a>
                    <a href="javascript:;" class="weui-dialog__btn weui-dialog__btn_primary">主操作</a>
                </div>
            </div>
        </div>
        <!--END dialog3-->
        <!--BEGIN dialog4-->
        <div class="js_dialog" id="androidDialog2" style="display: none;">
            <div class="weui-mask"></div>
            <div class="weui-dialog weui-skin_android">
                <div class="weui-dialog__bd">
                    弹窗内容，告知当前状态、信息和解决方法，描述文字尽量控制在三行内
                </div>
                <div class="weui-dialog__ft">
                    <a href="javascript:;" class="weui-dialog__btn weui-dialog__btn_default">辅助操作</a>
                    <a href="javascript:;" class="weui-dialog__btn weui-dialog__btn_primary">主操作</a>
                </div>
            </div>
        </div>
        <!--END dialog4-->
    </div>
</div>
<script type="text/javascript">
    $(function(){
        var $iosDialog1 = $('#iosDialog1'),
            $iosDialog2 = $('#iosDialog2'),
            $androidDialog1 = $('#androidDialog1'),
            $androidDialog2 = $('#androidDialog2');

        $('#dialogs').on('click', '.weui-dialog__btn', function(){
            $(this).parents('.js_dialog').fadeOut(200);
        });

        $('#showIOSDialog1').on('click', function(){
            $iosDialog1.fadeIn(200);
        });
        $('#showIOSDialog2').on('click', function(){
            $iosDialog2.fadeIn(200);
        });
        $('#showAndroidDialog1').on('click', function(){
            $androidDialog1.fadeIn(200);
        });
        $('#showAndroidDialog2').on('click', function(){
            $androidDialog2.fadeIn(200);
        });
    });
</script>