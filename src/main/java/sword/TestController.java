package sword;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




/**
 * @author 
 */
@RestController
@RequestMapping("/test")
public class TestController {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(){
		logger.info(new Date()+"测试页面");
		return "测试页面";
	}




}
