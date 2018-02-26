package sword;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sword.wechat.entity.ApiResult;
import sword.wechat.utils.WechatAPI;





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

	/**
	 * 测试例子
	* @Title: main 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param args    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public static void main(String[] args) {
		ApiResult ar=null;
		String jsonbody="{\"touser\": \"%s\",\"template_id\": \"%s\",\"data\":%s}";
	    
		String openid="ohqTZ0d8zD2IB6VcxUcojiqkwvFo";
		//模板内容
		String mbnr ="{\"first\": {"+
                       "\"value\":\"测试业务\","+
                       "\"color\":\"#173177\""+
                   "},"+
                   "\"keyword1\":{"+
                       "\"value\":\"戴先生\","+
                       "\"color\":\"#173177\""+
                   "},"+
                   "\"keyword2\": {"+
                       "\"value\":\"39.8元\","+
                       "\"color\":\"#173177\""+
                   "},"+
                   "\"remark\":{"+
                       "\"value\":\""+new Date()+"\","+
                       "\"color\":\"#173177\""+
                   "}"+
           "}";
		String mbid ="-sw3z8Rn-hYVF9pozGzHBb_XdmyduBxqqYfvuPKnSpI";//模板id
		jsonbody=String.format(jsonbody, new Object[]{openid,mbid,mbnr});
		ar = WechatAPI.sendTemplateMsg(jsonbody);
		System.out.println(ar.getErrMsg());
	}


}
