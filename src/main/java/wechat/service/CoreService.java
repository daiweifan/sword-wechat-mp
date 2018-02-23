package wechat.service;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import sun.misc.BASE64Encoder;
import wechat.common.WxConsts;
import wechat.entity.api.Follower;
import wechat.entity.message.Article;
import wechat.entity.message.BaseMessage;
import wechat.entity.message.Image;
import wechat.entity.message.ImageMessage;
import wechat.entity.message.NewsMessage;
import wechat.entity.message.TextMessage;
import wechat.utils.MapCacheManager;
import wechat.utils.MessageUtil;
import wechat.utils.WechatAPI;

@SuppressWarnings("restriction")
@Service
public class CoreService  {
	

	
	private static Logger log = LoggerFactory.getLogger(CoreService.class);

	/**
	 * 处理微信发来的请求
	 * 
	 * @param request
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "unused", "deprecation" })
	public  String processRequest(HttpServletRequest request) {
		
		String resMsg = null;
		try {
			// 默认返回的文本消息内容
			String respContent = "请求处理异常，请稍候尝试！";
			
			// xml请求解析
			Map<String, String> requestMap = MessageUtil.parseXml(request);

			// 发送方账号（open_id）
			String fromUserName = requestMap.get("FromUserName");
			
			// 公众账号
			String toUserName = requestMap.get("ToUserName");
			
			// 消息类型
			String msgType = requestMap.get("MsgType");


			
			// 文本消息
			if (msgType.equals(WxConsts.XML_MSG_TEXT)) {
				
				Map<String, Object> headMap = new HashMap<String, Object>();
				
				Map<String, Object> paramMap = new HashMap<String, Object>();
				headMap.put("openid", fromUserName);
			

				// 回复文本消息
				TextMessage textMessage = new TextMessage(requestMap);
				
				String content = requestMap.get("Content");
				
				if(null == content || "".equals(content))
				{
					textMessage.setContent("");
				}
				
				 MapCacheManager cache = MapCacheManager.getInstance();  
			        Map<String, Object> cacheMap = new ConcurrentHashMap<String, Object>();  
                    cacheMap = cache.getMapCache(); 
                  List<Map<String,Object>>  list =  (List<Map<String,Object>>)cacheMap.get("zdyd"); 
                  String titlenull = "";
                  String ydnrnull="";
                  String mediaidnull="";
                  String flag = "0";
                  for (Map<String,Object> map:list){
                	  
                	String title = map.get("title").toString();
                	String ydnr = map.get("nrnew").toString();
					String mediaid = map.get("mediaid")==null?"":map.get("mediaid").toString();
					if(title.equals("-1")){
						 titlenull = map.get("title").toString();
	                	 ydnrnull = map.get("nrnew").toString();
						 mediaidnull = map.get("mediaid")==null?"":map.get("mediaid").toString();
						
					}
                	
                	String[] titlemx = title.split("/");
                	for(String s:titlemx){
                		if(s.equals(content)){
                			flag = "1";
                			if(null !=ydnr && !"".equals(ydnr))
            					{
            						ydnr = ydnr.replaceAll("&amp;", "&");
            						ydnr = ydnr.replaceAll("&quot;", "\"");
            						ydnr = ydnr.replace("&nbsp;", "");
            						ydnr = ydnr.replaceAll("&lt;", "<");
            						ydnr = ydnr.replaceAll("&gt;", ">");
            						ydnr = ydnr.replaceAll("<(?!a|/a)[^>]*>","");
            						textMessage.setContent(ydnr);
            						
            						resMsg = MessageUtil.textMessageToXml(textMessage);
            					}else
            					{
            						ImageMessage imageMessage = new ImageMessage(requestMap);
            						imageMessage.setMsgType("image");
            						Image image = new Image();
            						image.setMediaId(mediaid);
            						imageMessage.setImage(image);
            
            						resMsg = MessageUtil.imageMessageToXml(imageMessage);
            					}
                			
                			
                		 break;
                		}
                		
                		
                	}
                	
                	
                  }
                  
                  if (flag.equals("0")){
                	  if(null !=ydnrnull && !"".equals(ydnrnull))
  					{
  						ydnrnull = ydnrnull.replaceAll("&amp;", "&");
  						ydnrnull = ydnrnull.replaceAll("&quot;", "\"");
  						ydnrnull = ydnrnull.replace("&nbsp;", "");
  						ydnrnull = ydnrnull.replaceAll("&lt;", "<");
  						ydnrnull = ydnrnull.replaceAll("&gt;", ">");
  						ydnrnull = ydnrnull.replaceAll("<(?!a|/a)[^>]*>","");
  						textMessage.setContent(ydnrnull);
  						
  						resMsg = MessageUtil.textMessageToXml(textMessage);
  					}else
  					{
  						ImageMessage imageMessage = new ImageMessage(requestMap);
  						imageMessage.setMsgType("image");
  						Image image = new Image();
  						image.setMediaId(mediaidnull);
  						imageMessage.setImage(image);
  
  						resMsg = MessageUtil.imageMessageToXml(imageMessage);
  					}
                	  
                	  
                  }					
			}else if (msgType.equals(WxConsts.XML_MSG_EVENT)) {
				
				//获取事件类型
				String eventType = requestMap.get("Event");
				
				// 订阅事件 
				if (eventType.equals(WxConsts.EVT_SUBSCRIBE)) {
					String hrefUrl = String.format(WxConsts.WX_OAUTH2_URL, WxConsts.APPID,
							URLEncoder.encode(WxConsts.APPDOMAIN + "/wx_oauth2_qinghai.do?action=ywcx"));
					respContent = "嗨，你终于来找我啦！我是您的\"金管家\"，既然来了，就和我擦擦老空吧！点击下方菜单查询或切换右下角小键盘“输入文字”，我马上去办哦！别忘了先和我绑定！";
					respContent += "\n<a href=\""+hrefUrl;
					respContent += "\">轻轻点一下，立刻和我做朋友！</a>";
						
					requestMap.put("content", respContent);
					TextMessage textMsg=new TextMessage(requestMap);
					textMsg.setMsgType("text");
					resMsg = MessageUtil.textMessageToXml(textMsg);
					
					
				}else if (eventType.equals(WxConsts.EVT_UNSUBSCRIBE)) {
					// TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
					log.info("用户【"+fromUserName+"】取消关注公众号！");
					
				}else if (eventType.equals(WxConsts.EVT_CLICK)) {
					
					String eventKey = requestMap.get("EventKey");
					
					if (eventKey.equals("10")) {
						
						NewsMessage newsMsg=new NewsMessage(new BaseMessage(requestMap));
						
						
						List<Article> lstArticle=new ArrayList<Article>();
						Article article1=new Article();
						article1.setTitle("账号绑定与解除");
						article1.setDescription("");
						article1.setPicUrl("");
						article1.setUrl("");
						lstArticle.add(article1);
						
						//已绑定
						if(true){
							Article article2=new Article();
							article2.setTitle("【解除用户绑定页面】 通过个人的账号或身份证或单位账号以及密码进行绑定解除！");
							article2.setDescription("");
							article2.setPicUrl(WxConsts.APPDOMAIN+"/images/gjj/logout.png");
							article2.setUrl(WxConsts.APPDOMAIN+"/gjj_logout_qinghai.do?openid="+fromUserName);
							//article2.setUrl(String.format(WxConsts.WX_OAUTH2_URL,new Object[]{WxConsts.APPID,URLEncoder.encode(WxConsts.APPDOMAIN+"/gjj_logout.do?openid="+fromUserName)}));
							lstArticle.add(article2);
							
						}else{
							Article article2=new Article();
							article2.setTitle("【绑定账号】 通过个人的账号或身份证或单位账号以及密码进行绑定！");
							article2.setDescription("用户绑定，用户需通过网站的登陆名密码绑定之后才可以查询公积金的相关信息");
							article2.setPicUrl(WxConsts.APPDOMAIN+"/images/gjj/6.jpg");
							article2.setUrl(WxConsts.APPDOMAIN+"/gjj_logon_qinghai.do?openid="+fromUserName);
							//article2.setUrl(String.format(WxConsts.WX_OAUTH2_URL,new Object[]{WxConsts.APPID,URLEncoder.encode(WxConsts.APPDOMAIN+"/gjj_logon.do?zhlx=1")}));
							lstArticle.add(article2);
						}

						
						
						newsMsg.setArticles(lstArticle);
						newsMsg.setCount(lstArticle.size());
						resMsg = MessageUtil.newsMessageToXml(newsMsg);
						
						
					} else if (eventKey.equals("11")) {
						
						NewsMessage newsMsg=new NewsMessage(new BaseMessage(requestMap));
						List<Article> lstArticle=new ArrayList<Article>();

						Article article = new Article();

						article.setTitle("密码设置");
						article.setDescription("通过账号及原密码进行新密码的设置");
						article.setUrl(WxConsts.APPDOMAIN+"/gjj_change.do");

						lstArticle.add(article);
		

						newsMsg.setArticles(lstArticle);
						newsMsg.setCount(lstArticle.size());
						resMsg = MessageUtil.newsMessageToXml(newsMsg);
						

					} else if (eventKey.equals("12")) {
						
						NewsMessage newsMsg=new NewsMessage(new BaseMessage(requestMap));
	
						List<Article> lstArticle=new ArrayList<Article>();
						Article article = new Article();

						article.setTitle("使用帮助");
						article.setDescription(getzn());
						article.setUrl(null);

						lstArticle.add(article);

						newsMsg.setArticles(lstArticle);
						newsMsg.setCount(lstArticle.size());
						resMsg = MessageUtil.newsMessageToXml(newsMsg);

					}else if (eventKey.equals("99")) {
						
						
						String content = "用户等待接入。。。";
						//获取微信用户信息
						Follower follower=WechatAPI.getFollower(fromUserName);

						if(true){
							requestMap.put("content", "请稍后，正在为您转接人工服务。。。");
							TextMessage textMsg=new TextMessage(requestMap);
							textMsg.setMsgType("text");
							resMsg = MessageUtil.textMessageToXml(textMsg);
						}else{
							requestMap.put("content", "服务器繁忙，请稍候再试！");
							TextMessage textMsg=new TextMessage(requestMap);
							textMsg.setMsgType("text");
							resMsg = MessageUtil.textMessageToXml(textMsg);
					}
						
						
						
						

					}

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("微信被动回复消息："+resMsg);
		return resMsg;
	}

	/**
	 * emoji表情转换(hex -> utf-16)
	 * 
	 * @param hexEmoji
	 * @return
	 */
	public static String emoji(int hexEmoji) {
		return String.valueOf(Character.toChars(hexEmoji));
	}

	/**
	 * 歌曲点播使用指南
	 * 
	 * @return
	 */
	public static String getUsage() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("歌曲点播操作指南").append("\n\n");
		buffer.append("回复：歌曲+歌名").append("\n");
		buffer.append("例如：歌曲存在").append("\n");
		buffer.append("或者：歌曲存在@汪峰").append("\n\n");
		buffer.append("回复“?”显示主菜单");
		return buffer.toString();
	}

	/**
	 * 人脸检测帮助菜单
	 */
	public static String getUspic() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("人脸检测使用指南").append("\n\n");
		buffer.append("发送一张清晰的照片，就能帮你分析出种族、年龄、性别等信息").append("\n");
		buffer.append("快来试试你是不是长得太着急");
		return buffer.toString();
	}

	// 主菜单
	public static String getTopmenu() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("1、语音查询:路电049-(37501、37502、37503、37504、37505)；\n");
		buffer.append("2、铁路内网站点:10.132.30.66；\n");
		buffer.append("3、客户服务电话：049-21231；\n");
		buffer.append("4、微信技术支持电话:049-21221；\n");
		buffer.append("5、回复“？”可获得相关问题的序号。（例如查看“首次绑定的密码和类型问题？”，则回复“001”）；\n");
		buffer.append("6、本公众微信服务平台不接受语音；\n");
		buffer.append("感谢您与我们的互动交流，我们将尽快对您的问题予以回复。\n");
		return buffer.toString();
	}

	// 公积金查询使用指南
	public static String getgjjye() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("公积金查询使用指南").append("\n\n");
		buffer.append("发送公积金+身份证").append("\n");
		buffer.append("例如：公积金320404191111111111").append("\n\n");
		buffer.append("回复“?”显示主菜单");
		return buffer.toString();
	}

	// 公积金查询使用指南

	public String getzn() {
		StringBuffer buffer = new StringBuffer();
		buffer
				.append("益阳市住房公积金管理中心公众微信服务平台使用指南：\n1、点击“便民服务”中的“账号绑定”后可在弹出页面中选择“绑定个人用户”,单位经办人还可选择“绑定单位用户”;\n");
		buffer
				.append("2、绑定完成后,可分别查询个人或单位的相关信息,有公积金贷款的职工,只需绑定一次就能分别查询贷款和公积金的信息;\n");

		//buffer.append(getreply());

		return buffer.toString();
	}

	


	
	@SuppressWarnings({ "unused" })
	private String getImageFromUrl(String url){	
		String strBase64="";
		HttpURLConnection connection=null;
		InputStream in= null;
		try {
			// 建立连接
			//URL url = new URL(request);
			URL reqUrl = new URL(null,url,new sun.net.www.protocol.https.Handler());
			connection = (HttpURLConnection) reqUrl.openConnection();
			
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setUseCaches(false);
			connection.setRequestMethod("GET");
			
			// 流处理
			in = connection.getInputStream();
			byte[] bytes=new byte[in.available()];
        	in.read(bytes);
        	strBase64=new BASE64Encoder().encode(bytes);
        	in.close();

			connection.disconnect();
	

		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}finally{
			
			
			if(connection!=null){
				connection.disconnect();
			}
		}
		return strBase64;
		
	}

}
