package sword.wechat.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



/**
 * @author david
 */
@RestController
@RequestMapping("/wechat/weui")
public class WechatController {
	
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  public static final String viewPath = "weui/";
  
	@RequestMapping("/index")
	public ModelAndView index(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了首页",new Date());
		mav.setViewName(viewPath+"index");
		return mav;
	}



}
