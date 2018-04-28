<#assign contentBody>  
 <div class="weui-pull-to-refresh__layer">
      <div class='weui-pull-to-refresh__arrow'></div>
      <div class='weui-pull-to-refresh__preloader'></div>
      <div class="down">下拉刷新</div>
      <div class="up">释放刷新</div>
      <div class="refresh">正在刷新</div>
    </div>

    <h1 class="demos-title">下拉刷新&滚动加载</h1>
    <p>Time: <span id="time">下拉我试试</span></p>
    <div id="list" class='demos-content-padded'>
      <p>《世界著名计算机教材精选·人工智能:一种现代的方法(第3版)》是最权威、最经典的人工智能教材，已被全世界100多个国家的1200多所大学用作教材。《世界著名计算机教材精选·人工智能:一种现代的方法(第3版)》的最新版全面而系统地介绍了人工智能的理论和实践，阐述了人工智能领域的核心内容，并深入介绍了各个主要的研究方向。全书分为七大部分：第Ⅰ部分“人工智能”，第Ⅱ部分“问题求解”，第Ⅲ部分“知识、推理与规划”，第Ⅳ部分“不确定知识与推理”，第Ⅴ部分“学习”，第Ⅵ部分“通信、感知与行动”，第Ⅶ部分“结论”。《世界著名计算机教材精选·人工智能:一种现代的方法(第3版)》既详细介绍了人工智能的基本概念、思想和算法，还描述了其各个研究方向最前沿的进展，同时收集整理了详实的历史文献与事件。《世界著名计算机教材精选·人工智能:一种现代的方法(第3版)》适合于不同层次和领域的研究人员及学生，是高等院校本科生和研究生人工智能课的首选教材，也是相关领域的科研与工程技术人员的重要参考书。</p>
    </div>
    <div class="weui-loadmore">
      <i class="weui-loading"></i>
      <span class="weui-loadmore__tips">正在加载</span>
    </div>
    <script>
      $(document.body).pullToRefresh().on("pull-to-refresh", function() {
        setTimeout(function() {
          $("#time").text(new Date);
          $(document.body).pullToRefreshDone();
        }, 2000);
      });
      // infinite
      var loading = false;
      $(document.body).infinite().on("infinite", function() {
        if(loading) return;
        loading = true;
        setTimeout(function() {
          $("#list").append("<p>《世界著名计算机教材精选·人工智能:一种现代的方法(第3版)》英文版有1100多页，教学内容非常丰富，不但涵盖了人工智能基础、问题求解、知识推理与规划等经典内容，而且还包括不确定知识与推理、机器学习、通讯感知与行动等专门知识的介绍。目前我们为本科生开设的学科基础必修课“人工智能导论”主要介绍其中的经典内容，而研究生必修的核心课程“人工智能原理”主要关注其中的专门知识。其实《世界著名计算机教材精选·人工智能:一种现代的方法(第3版)》也适合希望提高自身计算系统设计水平的广大应用计算技术的社会公众，对参加信息学奥林匹克竞赛和ACM程序设计竞赛的选手及其教练员也有一定的参考作用。</p>");
          loading = false;
        }, 2000);
      });
    </script>
</#assign>  
<#include "/shared/layout.ftl" />  