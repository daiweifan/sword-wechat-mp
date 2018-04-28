package sword.wechat.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



/**
 * 
* @ClassName: WebController 
* @Description: TODO
* @author daiwei
* @date 2018年4月21日 下午3:53:54 
* 
* @version V2.0
 */
@RestController
@RequestMapping("/example")
public class WebController {
	
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  public static final String viewPath = "example/";
  
	@RequestMapping("/login")
	public ModelAndView login(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了登录页面",new Date());
		mav.setViewName(viewPath+"login");
		return mav;
	}

	@RequestMapping("/register")
	public ModelAndView register(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了注册",new Date());
		mav.setViewName(viewPath+"register");
		return mav;
	}
	
	@RequestMapping("/home")
	public ModelAndView home(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了主页",new Date());
		mav.setViewName(viewPath+"home");
		return mav;
	}
	
	@RequestMapping("/actionSheet")
	public ModelAndView actionSheet(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了actionSheet",new Date());
		mav.setViewName(viewPath+"action_sheet");
		return mav;
	}
	
	@RequestMapping("/uploader")
	public ModelAndView uploader(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了uploader",new Date());
		mav.setViewName(viewPath+"uploader");
		return mav;
	}
	
	@RequestMapping("/article")
	public ModelAndView article(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了article",new Date());
		mav.setViewName(viewPath+"article");
		return mav;
	}
	
	
	@RequestMapping("/badge")
	public ModelAndView badge(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了badge",new Date());
		mav.setViewName(viewPath+"badge");
		return mav;
	}
	
	@RequestMapping("/buttons")
	public ModelAndView buttons(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了buttons",new Date());
		mav.setViewName(viewPath+"buttons");
		return mav;
	}
	
	
	@RequestMapping("/calendar")
	public ModelAndView calendar(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了calendar",new Date());
		mav.setViewName(viewPath+"calendar");
		return mav;
	}
	
	@RequestMapping("/cell")
	public ModelAndView cell(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了cell",new Date());
		mav.setViewName(viewPath+"cell");
		return mav;
	}
	
	@RequestMapping("/cityPicker")
	public ModelAndView cityPicker(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了city-picker",new Date());
		mav.setViewName(viewPath+"city_picker");
		return mav;
	}
	
	@RequestMapping("/contacts")
	public ModelAndView contacts(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了contacts",new Date());
		mav.setViewName(viewPath+"contacts");
		return mav;
	}
	
	@RequestMapping("/count")
	public ModelAndView count(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了count",new Date());
		mav.setViewName(viewPath+"count");
		return mav;
	}
	
	@RequestMapping("/datetimePicker")
	public ModelAndView datetimePicker(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了datetimePicker",new Date());
		mav.setViewName(viewPath+"datetime_picker");
		return mav;
	}
	
	@RequestMapping("/dialog")
	public ModelAndView dialog(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了dialog",new Date());
		mav.setViewName(viewPath+"dialog");
		return mav;
	}
	
	@RequestMapping("/flex")
	public ModelAndView flex(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了flex",new Date());
		mav.setViewName(viewPath+"flex");
		return mav;
	}
	
	@RequestMapping("/form")
	public ModelAndView form(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了form",new Date());
		mav.setViewName(viewPath+"form");
		return mav;
	}
	
	@RequestMapping("/gallery")
	public ModelAndView gallery(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了gallery",new Date());
		mav.setViewName(viewPath+"gallery");
		return mav;
	}
	
	@RequestMapping("/gesture")
	public ModelAndView gesture(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了gesture",new Date());
		mav.setViewName(viewPath+"gesture");
		return mav;
	}
	
	@RequestMapping("/grid")
	public ModelAndView grid(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了grid",new Date());
		mav.setViewName(viewPath+"grid");
		return mav;
	}
	
	@RequestMapping("/icons")
	public ModelAndView icons(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了icons",new Date());
		mav.setViewName(viewPath+"icons");
		return mav;
	}
	
	@RequestMapping("/infinite")
	public ModelAndView infinite(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了infinite",new Date());
		mav.setViewName(viewPath+"infinite");
		return mav;
	}
	
	@RequestMapping("/loadmore")
	public ModelAndView loadmore(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了loadmore",new Date());
		mav.setViewName(viewPath+"loadmore");
		return mav;
	}
	
	@RequestMapping("/msg")
	public ModelAndView msg(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了msg",new Date());
		mav.setViewName(viewPath+"msg");
		return mav;
	}
	
	@RequestMapping("/navbar")
	public ModelAndView navbar(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了navbar",new Date());
		mav.setViewName(viewPath+"navbar");
		return mav;
	}
	
	@RequestMapping("/noti")
	public ModelAndView noti(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了noti",new Date());
		mav.setViewName(viewPath+"noti");
		return mav;
	}
	
	@RequestMapping("/panel")
	public ModelAndView panel(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了panel",new Date());
		mav.setViewName(viewPath+"panel");
		return mav;
	}
	
	@RequestMapping("/photoBrowser")
	public ModelAndView photoBrowser(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了photoBrowser",new Date());
		mav.setViewName(viewPath+"photo_browser");
		return mav;
	}
	
	@RequestMapping("/picker")
	public ModelAndView picker(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了picker",new Date());
		mav.setViewName(viewPath+"picker");
		return mav;
	}
	
	@RequestMapping("/popup")
	public ModelAndView popup(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了popup",new Date());
		mav.setViewName(viewPath+"popup");
		return mav;
	}
	
	@RequestMapping("/preview")
	public ModelAndView preview(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了preview",new Date());
		mav.setViewName(viewPath+"preview");
		return mav;
	}
	
	@RequestMapping("/progress")
	public ModelAndView progress(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了progress",new Date());
		mav.setViewName(viewPath+"progress");
		return mav;
	}
	
	@RequestMapping("/ptrCustom")
	public ModelAndView ptrCustom(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了ptrCustom",new Date());
		mav.setViewName(viewPath+"ptr_custom");
		return mav;
	}
	
	@RequestMapping("/ptrWithInfinite")
	public ModelAndView ptrWithInfinite(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了ptrWithInfinite",new Date());
		mav.setViewName(viewPath+"ptr_with_infinite");
		return mav;
	}
	
	@RequestMapping("/ptr")
	public ModelAndView ptr(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了ptr",new Date());
		mav.setViewName(viewPath+"ptr");
		return mav;
	}
	
	@RequestMapping("/pullToRefreshWithNavbar")
	public ModelAndView pullToRefreshWithNavbar(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了pullToRefreshWithNavbar",new Date());
		mav.setViewName(viewPath+"pull_to_refresh_with_navbar");
		return mav;
	}
	
	@RequestMapping("/searchbar")
	public ModelAndView searchbar(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了searchbar",new Date());
		mav.setViewName(viewPath+"searchbar");
		return mav;
	}
	
	@RequestMapping("/select")
	public ModelAndView select(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了select",new Date());
		mav.setViewName(viewPath+"select");
		return mav;
	}

	@RequestMapping("/slider")
	public ModelAndView slider(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了slider",new Date());
		mav.setViewName(viewPath+"slider");
		return mav;
	}
	
	@RequestMapping("/swipeoutWithPtr")
	public ModelAndView swipeoutWithPtr(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了swipeoutWithPtr",new Date());
		mav.setViewName(viewPath+"swipeout_with_ptr");
		return mav;
	}
	
	@RequestMapping("/swipeout")
	public ModelAndView swipeout(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了swipeout",new Date());
		mav.setViewName(viewPath+"swipeout");
		return mav;
	}
	
	@RequestMapping("/swiper")
	public ModelAndView swiper(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了swiper",new Date());
		mav.setViewName(viewPath+"swiper");
		return mav;
	}
	
	@RequestMapping("/tabbar")
	public ModelAndView tabbar(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了tabbar",new Date());
		mav.setViewName(viewPath+"tabbar");
		return mav;
	}
	
	@RequestMapping("/toast")
	public ModelAndView toast(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了toast",new Date());
		mav.setViewName(viewPath+"toast");
		return mav;
	}
	
	@RequestMapping("/toptip")
	public ModelAndView toptip(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了toptip",new Date());
		mav.setViewName(viewPath+"toptip");
		return mav;
	}
	
	@RequestMapping("/tplChat")
	public ModelAndView tplChat(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了tplChat",new Date());
		mav.setViewName(viewPath+"tpl_chat");
		return mav;
	}
	
	@RequestMapping("/tplShoppingCart")
	public ModelAndView tplShoppingCart(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了tplShoppingCart",new Date());
		mav.setViewName(viewPath+"tpl_shopping_cart");
		return mav;
	}
	
	@RequestMapping("/footer")
	public ModelAndView footer(){
		ModelAndView mav = new ModelAndView();
		logger.info("\n 时间 {} 访问了footer",new Date());
		mav.setViewName(viewPath+"footer");
		return mav;
	}
	
}
