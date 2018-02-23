package sword.wechat.common;

/**
 * 微信使用常量
 * @author 
 *
 */
public class WxConsts {
	
	public static int connectTimeout = 3000;
	public static int readTimeout = 30000;
	public static int hessianConnectTimeout = 5000;
	public static int hessianReadTimeout = 60000;
	
	public static String APPID="wx8110a8b1450afc40";
	public static String APPSECRET="bb3e7c8a0644bd3eb62a9859faba9a5d";
	public static String APPDOMAIN="https://david0303.tunnel.qydev.com";
	public static String token ="david";
	
		
	//微信OAUTH2URL
	public static String WX_OAUTH2_URL="https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect";
	
	//微信公众号API入口
	//正式的
//	public static String WECHATAPI="http://192.168.1.1/cgi-bin";
	
	public static String WECHATAPI="https://api.weixin.qq.com/cgi-bin";
		
    /**
     * 获取OPENID
     */
    public static String GET_OPENID = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";
    
	
	/**
	 * 获取TOKEN地址
	 */
	public static String GET_TOKEN="/token?grant_type=client_credential&appid=%s&secret=%s";
	
	/**
	 * 创建菜单地址
	 */
	public static String CREATE_MENU="/menu/create?access_token=";
	
	/**
	 * 获取用户信息
	 */
	public static String USER_INFO="/user/info?access_token=%s&openid=%s&lang=zh_CN";
	
	/**
	 * 发送模板消息URL
	 */
	public static String SEND_TEMPLATE= "/message/template/send?access_token=%s";
	
	
	/**
	 * 发送客服消息URL
	 */
	public static String SEND_MSG_URL = "/message/custom/send?access_token=%s";
	
	/**
	 * 新增临时素材URL
	 */
	public static String UPLOAD_MEDIA_URL = "/media/upload?access_token=%s&type=%s";
	
	
	/**
	 * 上传图文素材图片
	 */
	public static String UPLOAD_IMAGE_URL="/media/uploadimg?access_token=%s";
	
	/**
	 * 上传图文素材
	 */
	public static String UPLOAD_NEWS_URL="/media/uploadnews?access_token=%s";
	
	
	/**
	 * 群发接口
	 */
	public static String SEND_MASS_MSG= "/message/mass/sendall?access_token=%s";
	
	/**
	 * 新增永久素材
	 */
	public static String NEW_IMAGE_URL = "/material/add_material?access_token=%s&type=%s";
	
	/**
	 * 删除永久素材
	 */
	public static String DELETE_IMAGE_URL ="/material/del_material?access_token=%s";
	
	public static String MASS_MSG_PREVIEW="/message/mass/preview?access_token=%s";
	

    
    ///////////////////////
    // 微信推送过来的消息的类型，和发送给微信xml格式消息的消息类型
    ///////////////////////
    public static final String XML_MSG_TEXT = "text";
    public static final String XML_MSG_IMAGE = "image";
    public static final String XML_MSG_VOICE = "voice";
    public static final String XML_MSG_VIDEO = "video";
    public static final String XML_MSG_NEWS = "news";
    public static final String XML_MSG_MUSIC = "music";
    public static final String XML_MSG_LOCATION = "location";
    public static final String XML_MSG_LINK = "link";
    public static final String XML_MSG_EVENT = "event";
    public static final String XML_TRANSFER_CUSTOMER_SERVICE = "transfer_customer_service";
    
    ///////////////////////
    // 主动发送消息的消息类型
    ///////////////////////
    public static final String CUSTOM_MSG_TEXT = "text";
    public static final String CUSTOM_MSG_IMAGE = "image";
    public static final String CUSTOM_MSG_VOICE = "voice";
    public static final String CUSTOM_MSG_VIDEO = "video";
    public static final String CUSTOM_MSG_MUSIC = "music";
    public static final String CUSTOM_MSG_NEWS = "news";
    public static final String CUSTOM_MSG_FILE = "file";
    public static final String CUSTOM_MSG_TRANSFER_CUSTOMER_SERVICE = "transfer_customer_service";
    public static final String CUSTOM_MSG_SAFE_NO = "0";
    public static final String CUSTOM_MSG_SAFE_YES = "1";
    
    ///////////////////////
    // 群发消息的消息类型
    ///////////////////////
    public static final String MASS_MSG_NEWS = "mpnews";
    public static final String MASS_MSG_TEXT = "text";
    public static final String MASS_MSG_VOICE = "voice";
    public static final String MASS_MSG_IMAGE = "image";
    public static final String MASS_MSG_VIDEO = "mpvideo";
    
    ///////////////////////
    // 微信端推送过来的事件类型
    ///////////////////////
    public static final String EVT_SUBSCRIBE = "subscribe";
    public static final String EVT_UNSUBSCRIBE = "unsubscribe";
    public static final String EVT_SCAN = "SCAN";
    public static final String EVT_LOCATION = "LOCATION";
    public static final String EVT_CLICK = "CLICK";
    public static final String EVT_VIEW = "VIEW";
    public static final String EVT_MASS_SEND_JOB_FINISH = "MASSSENDJOBFINISH";
    public static final String EVT_SCANCODE_PUSH = "scancode_push";
    public static final String EVT_SCANCODE_WAITMSG = "scancode_waitmsg";
    public static final String EVT_PIC_SYSPHOTO = "pic_sysphoto";
    public static final String EVT_PIC_PHOTO_OR_ALBUM = "pic_photo_or_album";
    public static final String EVT_PIC_WEIXIN = "pic_weixin";
    public static final String EVT_LOCATION_SELECT = "location_select";
    public static final String EVT_TEMPLATESENDJOBFINISH = "TEMPLATESENDJOBFINISH";
    public static final String EVT_ENTER_AGENT = "enter_agent";
    
    
    ///////////////////////
    // 上传多媒体文件的类型
    ///////////////////////
    public static final String MEDIA_IMAGE = "image";
    public static final String MEDIA_VOICE = "voice";
    public static final String MEDIA_VIDEO = "video";
    public static final String MEDIA_THUMB = "thumb";
    public static final String MEDIA_FILE = "file";
    
    ///////////////////////
    // 文件类型
    ///////////////////////
    public static final String FILE_JPG = "jpeg";
    public static final String FILE_MP3 = "mp3";
    public static final String FILE_AMR = "amr";
    public static final String FILE_MP4 = "mp4";

	

}
