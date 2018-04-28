<#assign contentBody>  
<header class='demos-header'>
      <h1 class="demos-title">Photo Browser</h1>
    </header>

    <div class='demos-content-padded'>
      <a href="javascript:;" class="weui-btn weui-btn_primary" id="pb1">只有图片</a>
      <a href="javascript:;" class="weui-btn weui-btn_primary" id="pb2">带说明文案</a>
    </div>


    <script>

      var pb1 = $.photoBrowser({
        items: [
          ctx+"/images/swiper-1.jpg",
          ctx+"/images/swiper-2.jpg",
          ctx+"/images/swiper-3.jpg",
          ctx+"/images/swiper-4.jpg"
        ],

        onSlideChange: function(index) {
          console.log(this, index);
        },

        onOpen: function() {
          console.log("onOpen", this);
        },
        onClose: function() {
          console.log("onClose", this);
        }
      });
      $("#pb1").click(function() {
        pb1.open();
      });
      var pb2 = $.photoBrowser({
        items: [
          {
            image: ctx+"/images/swiper-1.jpg",
            caption: "尝试 Vue.js 最简单的方法是使用 JSFiddle Hello World 例子。在浏览器新标签页中打开它，跟着我们查看一些基础示例。如果你喜欢用包管理器下载/安装，查看安装教程。"
          },
          {
            image: ctx+"/images/swiper-2.jpg",
            caption: "组件（Component）是 Vue.js 最强大的功能之一。"
          },
          {
            image: ctx+"/images/swiper-3.jpg",
            caption: "组件可以扩展 HTML 元素，封装可重用的代码"
          },
          {
            image: ctx+"/images/swiper-4.jpg",
            caption: "在较高层面上，组件是自定义元素，Vue.js 的编译器为它添加特殊功能。在有些情况下，组件也可以是原生 HTML 元素的形式，以 is 特性扩展。"
          }
        ],
        initIndex: 2
      });
      $("#pb2").click(function() {
        pb2.open();
      });
    </script>
</#assign>  
<#include "/shared/layout.ftl" />  