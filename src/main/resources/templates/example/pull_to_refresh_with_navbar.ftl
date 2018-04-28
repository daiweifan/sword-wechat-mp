<#assign contentBody>  
<div class="weui-tab">
      <div class="weui-navbar">
        <div class="weui-navbar__item weui-navbar__item--on" href="#tab1">
          选项一
        </div>
        <div class="weui-navbar__item" href="#tab2">
          选项二
        </div>
        <div class="weui-navbar__item" href="#tab3">
          选项三
        </div>
      </div>
      <div class="weui-tab__bd">
        <div id="tab1" class="weui-tab__bd-item weui-tab__bd-item--active weui-pull-to-refresh">
          <div class="weui-pull-to-refresh__layer">
            <div class='weui-pull-to-refresh__arrow'></div>
            <div class='weui-pull-to-refresh__preloader'></div>
            <div class="down">下拉刷新</div>
            <div class="up">释放刷新</div>
            <div class="refresh">正在刷新</div>
          </div>
          <h1 class="doc-head">页面一</h1>
          <div class="content-padded">
            <p>jQuery API - jQuery is a fast, small, and feature-rich JavaScript library. It makes things like HTML document traversal and manipulation, event handling, animation, and Ajax much simpler with an easy-to-use API that works across a multitude of browsers. If you're new to jQuery, we recommend that you check out the jQuery Learning Center.</p>
            <p>jQuery API - jQuery is a fast, small, and feature-rich JavaScript library. It makes things like HTML document traversal and manipulation, event handling, animation, and Ajax much simpler with an easy-to-use API that works across a multitude of browsers. If you're new to jQuery, we recommend that you check out the jQuery Learning Center.</p>
            <p>jQuery API - jQuery is a fast, small, and feature-rich JavaScript library. It makes things like HTML document traversal and manipulation, event handling, animation, and Ajax much simpler with an easy-to-use API that works across a multitude of browsers. If you're new to jQuery, we recommend that you check out the jQuery Learning Center.</p>
          </div>
        </div>
        <div id="tab2" class="weui-tab__bd-item weui-pull-to-refresh">
          <div class="weui-pull-to-refresh__layer">
            <div class='weui-pull-to-refresh__arrow'></div>
            <div class='weui-pull-to-refresh__preloader'></div>
            <div class="down">下拉刷新</div>
            <div class="up">释放刷新</div>
            <div class="refresh">正在刷新</div>
          </div>
          <h1 class="doc-head">页面二</h1>
          <div class="content-padded">
            <p>A great way to get introduced to AngularJS is to work through this tutorial, which walks you through the construction of an AngularJS web app. The app you will build is a catalog that displays a list of Android devices, lets you filter the list to see only devices that interest you, and then view details for any device.</p>
            <p>A great way to get introduced to AngularJS is to work through this tutorial, which walks you through the construction of an AngularJS web app. The app you will build is a catalog that displays a list of Android devices, lets you filter the list to see only devices that interest you, and then view details for any device.</p>
            <p>A great way to get introduced to AngularJS is to work through this tutorial, which walks you through the construction of an AngularJS web app. The app you will build is a catalog that displays a list of Android devices, lets you filter the list to see only devices that interest you, and then view details for any device.</p>
            <p>A great way to get introduced to AngularJS is to work through this tutorial, which walks you through the construction of an AngularJS web app. The app you will build is a catalog that displays a list of Android devices, lets you filter the list to see only devices that interest you, and then view details for any device.</p>
          </div>
        </div>
        <div id="tab3" class="weui-tab__bd-item weui-pull-to-refresh">
          <div class="weui-pull-to-refresh__layer">
            <div class='weui-pull-to-refresh__arrow'></div>
            <div class='weui-pull-to-refresh__preloader'></div>
            <div class="down">下拉刷新</div>
            <div class="up">释放刷新</div>
            <div class="refresh">正在刷新</div>
          </div>
          <div class="content-padded">
            <h1 class="doc-head">页面三</h1>
            <p>Lots of people use React as the V in MVC. Since React makes no assumptions about the rest of your technology stack, it's easy to try it out on a small feature in an existing project.</p>
            <p>Lots of people use React as the V in MVC. Since React makes no assumptions about the rest of your technology stack, it's easy to try it out on a small feature in an existing project.</p>
            <p>Lots of people use React as the V in MVC. Since React makes no assumptions about the rest of your technology stack, it's easy to try it out on a small feature in an existing project.</p>
          </div>
        </div>
      </div>
    </div>
    <script>
      $('.weui-tab__bd-item').pullToRefresh().on('pull-to-refresh', function (done) {
        var self = this
        setTimeout(function() {
          $(self).pullToRefreshDone();
        }, 2000)
      })
    </script>
</#assign>  
<#include "/shared/layout.ftl" />  