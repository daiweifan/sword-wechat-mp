<#assign contentBody>  
 <header class='demos-header'>
      <h1 class="demos-title">购物车</h1>
    </header>

    <div class='demos-content-padded'>
      <article class="weui-article">
        <p>这是一个购物车的模板，可以参考这个模板完成你自己的购物车。支持：</p>
        <ul>
          <li>可以加减数量</li>
          <li>可以滑动删除</li>
        </ul>
        <a href="javascript:;" class="weui-btn weui-btn_primary open-popup" data-target="#cart">打开购物车</a>
      </article>
    </div>

    <div id="cart" class='weui-popup__container popup-bottom'>
      <div class="weui-popup__overlay"></div>
      <div class="weui-popup__modal">
        <div class="toolbar">
          <div class="toolbar-inner">
            <a href="javascript:;" class="picker-button close-popup">关闭</a>
            <h1 class="title">我的购物车</h1>
          </div>
        </div>
        <div class="modal-content">
          <div class="weui-cells">
            <div class="weui-cell weui-cell_swiped">
              <div class="weui-cell__bd">
                <div class="weui-cell">
                  <div class="weui-cell__hd"><img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAC4AAAAuCAMAAABgZ9sFAAAAVFBMVEXx8fHMzMzr6+vn5+fv7+/t7e3d3d2+vr7W1tbHx8eysrKdnZ3p6enk5OTR0dG7u7u3t7ejo6PY2Njh4eHf39/T09PExMSvr6+goKCqqqqnp6e4uLgcLY/OAAAAnklEQVRIx+3RSRLDIAxE0QYhAbGZPNu5/z0zrXHiqiz5W72FqhqtVuuXAl3iOV7iPV/iSsAqZa9BS7YOmMXnNNX4TWGxRMn3R6SxRNgy0bzXOW8EBO8SAClsPdB3psqlvG+Lw7ONXg/pTld52BjgSSkA3PV2OOemjIDcZQWgVvONw60q7sIpR38EnHPSMDQ4MjDjLPozhAkGrVbr/z0ANjAF4AcbXmYAAAAASUVORK5CYII=" alt="" style="width:20px;margin-right:5px;display:block"></div>
                  <div class="weui-cell__bd">
                    <p>清风纸巾12包装</p>
                  </div>
                  <div class="weui-cell__ft">
                    <span class="price">￥24.00</span>
                    <div class="weui-count">
                      <a class="weui-count__btn weui-count__decrease"></a>
                      <input class="weui-count__number" type="number" value="1" />
                      <a class="weui-count__btn weui-count__increase"></a>
                    </div>
                  </div>
                </div>
              </div>
              <div class="weui-cell__ft">
                <a class="weui-swiped-btn weui-swiped-btn_warn delete-swipeout" href="javascript:">删除</a>
                <a class="weui-swiped-btn weui-swiped-btn_default close-swipeout" href="javascript:">关闭</a>
              </div>
            </div>
            <div class="weui-cell weui-cell_swiped">
              <div class="weui-cell__bd">
                <div class="weui-cell">
                  <div class="weui-cell__hd"><img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAC4AAAAuCAMAAABgZ9sFAAAAVFBMVEXx8fHMzMzr6+vn5+fv7+/t7e3d3d2+vr7W1tbHx8eysrKdnZ3p6enk5OTR0dG7u7u3t7ejo6PY2Njh4eHf39/T09PExMSvr6+goKCqqqqnp6e4uLgcLY/OAAAAnklEQVRIx+3RSRLDIAxE0QYhAbGZPNu5/z0zrXHiqiz5W72FqhqtVuuXAl3iOV7iPV/iSsAqZa9BS7YOmMXnNNX4TWGxRMn3R6SxRNgy0bzXOW8EBO8SAClsPdB3psqlvG+Lw7ONXg/pTld52BjgSSkA3PV2OOemjIDcZQWgVvONw60q7sIpR38EnHPSMDQ4MjDjLPozhAkGrVbr/z0ANjAF4AcbXmYAAAAASUVORK5CYII=" alt="" style="width:20px;margin-right:5px;display:block"></div>
                  <div class="weui-cell__bd">
                    <p>七匹狼男士长筒袜</p>
                  </div>
                  <div class="weui-cell__ft">
                    <span class="price">￥35.00</span>
                    <div class="weui-count">
                      <a class="weui-count__btn weui-count__decrease"></a>
                      <input class="weui-count__number" type="number" value="1" />
                      <a class="weui-count__btn weui-count__increase"></a>
                    </div>
                  </div>
                </div>
              </div>
              <div class="weui-cell__ft">
                <a class="weui-swiped-btn weui-swiped-btn_warn delete-swipeout" href="javascript:">删除</a>
                <a class="weui-swiped-btn weui-swiped-btn_default close-swipeout" href="javascript:">关闭</a>
              </div>
            </div>
          </div>
        </div>
        <p class="summary">
          2 件商品, 共计 <strong>123.5</strong> 元
        </p>
      </div>
    </div>
    <style>
      .summary {
        padding: 8px;
        text-align: right;
        background-color: white;
      }
      .price {
        font-size: .9em;
        margin-right: 6px;
      }
    </style>

    <script>
      var MAX = 99, MIN = 1;
      $('.weui-count__decrease').click(function (e) {
        var $input = $(e.currentTarget).parent().find('.weui-count__number');
        var number = parseInt($input.val() || "0") - 1
        if (number < MIN) number = MIN;
        $input.val(number)
      })
      $('.weui-count__increase').click(function (e) {
        var $input = $(e.currentTarget).parent().find('.weui-count__number');
        var number = parseInt($input.val() || "0") + 1
        if (number > MAX) number = MAX;
        $input.val(number)
      })
    </script>
</#assign>  
<#include "/shared/layout.ftl" />  