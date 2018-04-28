<#assign contentBody>  
 <header class='demos-header'>
      <h1 class="demos-title">Toast</h1>
    </header>

    <div class='demos-content-padded'>
      <a href="javascript:;" id='show-toast' class="weui-btn weui-btn_primary">显示 Toast 成功</a>
      <a href="javascript:;" id='show-toast-cancel' class="weui-btn weui-btn_primary">显示 Toast 取消</a>
      <a href="javascript:;" id='show-toast-forbidden' class="weui-btn weui-btn_primary">显示 Toast 禁止</a>
      <a href="javascript:;" id='show-toast-text' class="weui-btn weui-btn_primary">显示 Toast 纯文本</a>
      <a href="javascript:;" id='show-loading' class="weui-btn weui-btn_primary">显示 Loading</a>
    </div>
    <script>
      $(document).on("click", "#show-toast", function() {
        $.toast("操作成功", function() {
          console.log('close');
        });
      })
      .on("click", "#show-toast-cancel", function() {
        $.toast("取消操作", "cancel", function(toast) {
          console.log(toast);
        });
      })
      .on("click", "#show-toast-forbidden", function() {
        $.toast("禁止操作", "forbidden");
      })
      .on("click", "#show-toast-text", function() {
        $.toast("纯文本", "text");
      })
      .on("click", "#show-loading", function() {
        $.showLoading();

        setTimeout(function() {
          $.hideLoading();
        }, 3000)
      });
    </script>
</#assign>  
<#include "/shared/layout.ftl" />  