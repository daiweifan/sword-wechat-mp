package sword.wechat.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.nutz.json.Json;
import org.nutz.lang.Lang;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;
import sun.misc.BASE64Decoder;
import sword.wechat.common.EventType;
import sword.wechat.common.WxConsts;
import sword.wechat.entity.ApiResult;
import sword.wechat.entity.api.AccessToken;
import sword.wechat.entity.api.Follower;
import sword.wechat.entity.api.Menu;
import sword.wechat.exception.WechatApiException;


@SuppressWarnings("restriction")
public class WechatAPI {

	private static Logger log = LoggerFactory.getLogger(WechatAPI.class);

	private static String mergeUrl(String url, Object... values) {
		if (values.length > 0) {
			return WxConsts.WECHATAPI + String.format(url, values);
		}
		return WxConsts.WECHATAPI + url;
	}
	
	
	

	/**
	 * 强制刷新微信服务凭证
	 */
	@SuppressWarnings("unused")
	private static synchronized void refreshAccessToken() {

		String url = mergeUrl(WxConsts.GET_TOKEN, WxConsts.APPID, WxConsts.APPSECRET);

		AccessToken at = null;
		ApiResult ar = null;

		ar = ApiResult.create(httpRequest(url,"GET", null));

		if (ar.isSuccess()) {
			at = Json.fromJson(AccessToken.class, ar.getJson());
			WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
			webApplicationContext.getServletContext().setAttribute(WxConsts.APPID, at);
		}

		if (ar != null) {
			log.info("刷新Token成功");
			return;
		}

		log.error("刷新Token失败,错误代码[{}]", ar.getErrCode());

		throw Lang.wrapThrow(new WechatApiException(ar.getJson()));
	}

	/**
	 * 获取AccessToken
	 * 
	 * @return
	 */
	public static String getAccessToken() {
		
		   
		  System.out.println("====================获取token开始==============================");
		 
			String url = mergeUrl(WxConsts.GET_TOKEN, WxConsts.APPID, WxConsts.APPSECRET);
		 
		    String accessToken = null;
		    String expiresIn = null;
		 
		    try {
		 
		      URL urlGet = new URL(url);
		 
		      HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();
		 
		      http.setRequestMethod("GET"); // 必须是get方式请求
		 
		      http.setRequestProperty("Content-Type",
		 
		          "application/x-www-form-urlencoded");
		 
		      http.setDoOutput(true);
		 
		      http.setDoInput(true);
		 
		      http.connect();
		 
		      InputStream is = http.getInputStream();
		 
		      int size = is.available();
		 
		      byte[] jsonBytes = new byte[size];
		 
		      is.read(jsonBytes);
		 
		      String message = new String(jsonBytes, "UTF-8");
		 
		      JSONObject demoJson = JSONObject.fromObject(message);
		 
		      accessToken = demoJson.getString("access_token");
		      expiresIn = demoJson.getString("expires_in");
		 
		      System.out.println("accessToken===="+accessToken);
		      System.out.println("expiresIn==="+expiresIn);
		      System.out.println("====================获取token结束==============================");
		 
		      is.close();
		 
		    } catch (Exception e) {
		 
		      e.printStackTrace();
		 
		    }
		 
		    return accessToken;
	}

	/**
	 * 创建菜单
	 * 
	 * @param menu
	 * @return
	 */
	public static boolean createMenu(Menu... menu) {

		String url = mergeUrl(WxConsts.CREATE_MENU + getAccessToken());
		Map<String, Object> body = new HashMap<String, Object>();
		body.put("button", menu);
		
		JsonConfig config = new JsonConfig();
	    config.setJsonPropertyFilter(new PropertyFilter()
	    {
	        @Override
	        public boolean apply(Object source, String name, Object value)
	        {
	            return value == null;
	        }
	    });
        
		JSONObject jsonObject = JSONObject.fromObject( body,config );  

		ApiResult ar =ApiResult.create(httpRequest(url, "POST", jsonObject.toString()));

		if (ar.isSuccess()) {
			log.info("创建菜单成功！");
			return true;
		}

		log.error("创建菜单失败,错误代码[{}]", ar.getErrCode());

		throw Lang.wrapThrow(new WechatApiException(ar.getJson()));
	}

	@SuppressWarnings("deprecation")
	public static void initMenu() {
		
		Menu wdzh = new Menu("账户查询");
	

		Menu djsj = new Menu("点击事件", EventType.CLICK.name(), "11");
		Menu dwzhbd = new Menu("单位账户绑定", EventType.VIEW.name(), String.format(WxConsts.WX_OAUTH2_URL, WxConsts.APPID,
				URLEncoder.encode(WxConsts.APPDOMAIN + "/gjj_logon_dw.do")));
		Menu ywcx = new Menu("个人公积金查询", EventType.VIEW.name(), String.format(WxConsts.WX_OAUTH2_URL, WxConsts.APPID,
				URLEncoder.encode(WxConsts.APPDOMAIN + "/wx_oauth2.do")));
		Menu ywbl = new Menu("个人业务办理", EventType.VIEW.name(), String.format(WxConsts.WX_OAUTH2_URL, WxConsts.APPID,
				URLEncoder.encode(WxConsts.APPDOMAIN + "/wx_oauth2_qinghai.do")));
		Menu zhjb = new Menu("账户解绑", EventType.VIEW.name(), String.format(WxConsts.WX_OAUTH2_URL, WxConsts.APPID,
				URLEncoder.encode(WxConsts.APPDOMAIN + "/gjj_logout.do")));
		wdzh.setSub_button(Arrays.asList(djsj,dwzhbd,ywcx,ywbl,zhjb));
		
		
		Menu wgjj = new Menu("业务指南"); 
		Menu zxzc = new Menu("最新政策", EventType.VIEW.name(), WxConsts.APPDOMAIN + "/gjj_ywzn_zxzc.do");
		Menu ywzc = new Menu("业务政策", EventType.VIEW.name(), WxConsts.APPDOMAIN + "/gjj_ywzn_first.do?id=369&type=业务政策&top=1");
		Menu bslc = new Menu("办事流程", EventType.VIEW.name(), WxConsts.APPDOMAIN + "/gjj_ywzn_first.do?id=370&type=办事流程&top=1");
		Menu wdcx = new Menu("网点查询", EventType.VIEW.name(), WxConsts.APPDOMAIN + "/gjj_ywzn_first.do?id=371&type=网点查询&top=1");
		wgjj.setSub_button(Arrays.asList(zxzc, ywzc, bslc, wdcx)); 
		

		
		Menu bmfw = new Menu("便民服务");
		Menu llb = new Menu("利率表", EventType.VIEW.name(), WxConsts.APPDOMAIN + "/gjj_llb.do");
		Menu wyb = new Menu("万元表",  EventType.VIEW.name(), WxConsts.APPDOMAIN + "/gjj_wyb.do");
		Menu hkjess = new Menu("还款金额试算", EventType.VIEW.name(), WxConsts.APPDOMAIN + "/gjj_yhje.do");
		Menu appxz = new Menu("APP下载", EventType.VIEW.name(), WxConsts.APPDOMAIN + "/wx_lyhf.do");
		bmfw.setSub_button(Arrays.asList(llb,wyb,hkjess,appxz));
		
		createMenu(wdzh, wgjj, bmfw);

	}

	/**
	 * 获取用户oepnid
	 * 
	 * @param code
	 * @return
	 */
	public static String getOpenId(String code) {

		String url = String.format(WxConsts.GET_OPENID, new Object[] { WxConsts.APPID, WxConsts.APPSECRET, code });
		ApiResult ar = ApiResult.create(httpRequest(url, "GET", null));

		if (ar.isSuccess()) {
			log.info("获取OPENID成功！");
			return String.valueOf(ar.getContent().get("openid"));
		}

		log.error("获取OPENID失败,错误代码[{}]", ar.getErrCode());

		return "";

	}
	
	/**
	 * 发送客服消息文本
	 * @param openid
	 * @param content
	 * @return
	 */
	public static ApiResult sendCustomerTextMsg(RequestEntityDTO reqDTO){
		
		String url = mergeUrl(WxConsts.SEND_MSG_URL,getAccessToken());
		String body = "{\"touser\" :\"%s\",";
		body += "\"msgtype\":\"text\",";
		body += "\"text\":{";
		body += "\"content\":\"%s\"";
		body += "}}";
		
		Map<String,Object> paramMap=(Map<String,Object>)reqDTO.getAccInfoList().get(0);
		body=String.format(body, new Object[]{String.valueOf(paramMap.get("openid")),String.valueOf(paramMap.get("hfnr"))});
		
		ApiResult ar =ApiResult.create(httpRequest(url, "POST", body));
		
		return ar;
		
	}
	
	/**
	 * 发送模板消息
	 * @param openid
	 * @param content
	 * @return
	 */
	public static ApiResult sendTemplateMsg(String body){
		
		String url = mergeUrl(WxConsts.SEND_TEMPLATE,getAccessToken());

		ApiResult ar =ApiResult.create(httpRequest(url, "POST", body,60000));
		
		return ar;
		
	}
	
	public static ApiResult uploadMedia(String wxurl,String base64string){
		
		String uploadUrl=mergeUrl(wxurl,getAccessToken(),"image");
		
		log.info(String.format(">>>>>微信【POST】请求>>>>>url: %s", uploadUrl));
		
		String boundary="---------------"+System.currentTimeMillis();
		try{
			
			URL url = new URL(null,uploadUrl,new sun.net.www.protocol.https.Handler());
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setUseCaches(false);
			connection.setRequestMethod("POST");
			
		    // 设置请求头信息
			connection.setRequestProperty("Connection", "Keep-Alive");
			connection.setRequestProperty("Charset", "UTF-8");
			// 设置请求头Content-Type
			connection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
			
			// 获取媒体文件上传的输出流（往微信服务器写数据）
			OutputStream outputStream = connection.getOutputStream();
			// 从请求头中获取内容类型
			String contentType = "image/jpeg";
			// 根据内容类型判断文件扩展名
			String fileExt =".jpg";
			// 请求体开始
			outputStream.write(("--" + boundary + "\r\n").getBytes());
			outputStream.write(String.format("Content-Disposition: form-data; name=\"media\"; filename=\"file1%s\"\r\n", fileExt).getBytes());
			outputStream.write(String.format("Content-Type: %s\r\n\r\n", contentType).getBytes());
			
			
			byte[] bytes=new BASE64Decoder().decodeBuffer(base64string);
			ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
			// 获取媒体文件的输入流（读取文件）
			//BufferedInputStream bis = new BufferedInputStream(fileInputStream);
			byte[] buf = new byte[1024];
			int size = 0;
			while ((size = bis.read(buf)) != -1) {
				// 将媒体文件写到输出流（往微信服务器写数据）
				outputStream.write(buf, 0, size);
			}
			// 请求体结束
			outputStream.write(("\r\n--" + boundary + "--\r\n").getBytes());
			outputStream.close();
			bis.close();
			
			// 获取媒体文件上传的输入流（从微信服务器读数据）
			InputStream inputStream = connection.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			StringBuffer buffer = new StringBuffer();
			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			connection.disconnect();
			
			String json=buffer.toString();
			
			log.info(String.format(">>>>>微信【POST】请求返回>>>>>url: %s", json));
			// 使用JSON-lib解析返回结果
			return ApiResult.create(json);
			
		}catch(Exception e){
			
			throw new RuntimeException(e.getMessage());
		}
		
	
	}
	
	

	/**
	 * 群发客服消息
	 * @param type
	 * @param mediaId
	 * @return
	 */
	public static ApiResult sendMPNews(String type, String mediaId){
		
		String url = mergeUrl(WxConsts.SEND_MASS_MSG,getAccessToken());
		String body="{";
			   body+="\"filter\":{";
			   body+="\"is_to_all\":true,";
			   body+="\"group_id\":2";
			   body+="},";
			   body+="\"%s\":{";
			   body+="\"media_id\":\"%s\"";
			   body+="},";
			   body+="\"msgtype\":\"%s\"";
			   body+="}";

		body=String.format(body, new Object[]{type,mediaId,type});
		
		ApiResult ar =ApiResult.create(httpRequest(url, "POST", body));
		
		return ar;
		
	}

	/**
	 * 获取用户信息
	 * 
	 * @param openId
	 * @return
	 */
	public static Follower getFollower(String openId) {

		String url = mergeUrl(WxConsts.USER_INFO, getAccessToken(), openId);
		ApiResult ar = ApiResult.create(httpRequest(url, "GET", null));
		if (ar.isSuccess()) {
			return Json.fromJson(Follower.class, ar.getJson());
		}
		log.error("获取用户信息失败,错误代码[{}]", ar.getErrCode());
		return null;

	}
	
public static String httpRequest(String url, String method, String body) {
		
		return httpRequest( url,  method,  body, 0,null);
	}
	
   public static String httpRequest(String url, String method, String body,Map<String,String> headMap) {
		
		return httpRequest( url,  method,  body, 0,headMap);
	}
   
   public static String httpRequest(String url, String method, String body,int time) {
	   
	   return httpRequest( url,  method,  body, time,null);
   }
	
	public static String httpRequest(String url, String method, String body,int time,Map<String,String> headMap) {

		StringBuffer buffer = new StringBuffer();
		
		if (log.isInfoEnabled()) {
			log.info(String.format(">>>>>微信【%s】请求>>>>>url: %s,body: %s", method, url,body));
		}

		try {
			// 建立连接
			//URL reqUrl = new URL(url);
			URL reqUrl = new URL(null,url,new sun.net.www.protocol.https.Handler());
			HttpURLConnection connection = (HttpURLConnection) reqUrl.openConnection();
			connection.setConnectTimeout(WxConsts.connectTimeout);
			
			if(time==0){
				connection.setReadTimeout(WxConsts.readTimeout);
			}else{				
				connection.setReadTimeout(time);
			}
			
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setUseCaches(false);
			connection.setRequestMethod(method);
			if (headMap!=null){
				for (Map.Entry<String,String> entry : headMap.entrySet()) {  
					connection.setRequestProperty(entry.getKey(),entry.getValue() );	 
					//Signature.getSignature("4412fe50e0ee6203ca9aae0f81fc8ac3", "a=4474&m=preauth&t="+System.currentTimeMillis()/1000+"&e=600")
				   // System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());  
				  
				}  
				
			}
			//connection.setRequestProperty("signature",Signature.getSignature("4412fe50e0ee6203ca9aae0f81fc8ac3", "a=4474&m=preauth&t="+System.currentTimeMillis()/1000+"&e=600") );	 
			
			if (body != null) {
				OutputStream out = connection.getOutputStream();
				out.write(body.getBytes("UTF-8"));
				out.close();
			}
			// 流处理
			InputStream input = connection.getInputStream();
			InputStreamReader inputReader = new InputStreamReader(input, "UTF-8");
			BufferedReader reader = new BufferedReader(inputReader);
			String line;
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			// 关闭连接、释放资源
			reader.close();
			inputReader.close();
			input.close();
			input = null;
			
			connection.disconnect();
			if (log.isInfoEnabled()) {
				log.info(">>>>>微信【{}】返回>>>>>: {}",method, buffer.toString());
				if(headMap!=null){
				System.out.println("httpRequest请求："+body+">>>>>>>>>>httpRequest返回:"+buffer.toString());
				}
			}
			return buffer.toString();

		} catch (Exception e) {
			return "";
		}
		
	}
	
	
	/**
	 * 发送客服消息文本
	 * @param openid
	 * @param content
	 * @return
	 */
	public static ApiResult newsPreview(String openid,String mediaid){
		
		String url = mergeUrl(WxConsts.MASS_MSG_PREVIEW,getAccessToken());
		String body = "{\"touser\" :\"%s\",";
		body += "\"msgtype\":\"mpnews\",";
		body += "\"mpnews\":{";
		body += "\"media_id\":\"%s\"";
		body += "}}";
		
		body=String.format(body, new Object[]{openid,mediaid});
		
		ApiResult ar =ApiResult.create(httpRequest(url, "POST", body));
		
		return ar;
		
	}
	
	
	public static Map<String,Object> processReq(RequestEntityDTO reqDTO) {
		
		Map<String,Object> resultMap=new HashMap<String, Object>();
		resultMap.put("transcode", reqDTO.getTranscode());
		resultMap.put("iseqno", reqDTO.getIseqno());
		
		return resultMap;
		
	}

	public static void deleteMedia(String mediaid){
		
		String url = mergeUrl(WxConsts.DELETE_IMAGE_URL,getAccessToken());
		String body = "{\"media_id\":\"%s\"}}";
		
		body=String.format(body, new Object[]{mediaid});
		
		ApiResult.create(httpRequest(url, "POST", body));
		
	}


	

}
