package sword.wechat.entity.message;

import java.util.Map;

import sword.wechat.entity.event.BaseEvent;






/** 
 * 消息基类（普通用户 -> 公众帐号） 
 *  
 * @author xuewj 
 */  
public class BaseMessage {  
    
    /**
     * 微信公众号id/openid
     */
	protected String ToUserName;  
 
    /**
     * openid/微信公众号id
     */

	protected String FromUserName;  
    // 消息创建时间 （整型）  

	protected long CreateTime;  
    // 消息类型（text/image/location/link）  

	protected String MsgType;  
    // 消息id，64位整型  

	protected long MsgId;
	// 位0x0001被标志时，星标刚收到的消息  
    private int FuncFlag=0;  
    /**
     * 默认构造方法
     */
    public BaseMessage() {
       
    }
    
    public BaseMessage(BaseMessage msg) {
        this();
        this.FromUserName = msg.getFromUserName();
        this.ToUserName = msg.getToUserName();
    }

    public BaseMessage(BaseEvent event) {
        this();
        this.FromUserName = event.getFromUserName();
        this.ToUserName = event.getToUserName();
    }
    
    /**
     * 带XML解析值构造方法
     * 
     * @param values
     *            XML值
     */
    public BaseMessage(Map<String, String> values) {
    	
        this.ToUserName = values.get("FromUserName");
        this.FromUserName = values.get("ToUserName");
        this.CreateTime = Integer.parseInt(values.get("CreateTime"));
        this.MsgType = values.get("MsgType");
        //this.msgId = Long.valueOf(values.get("MsgId"));
    }
    
    
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		this.ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		this.FromUserName = fromUserName;
	}
	public long getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(long createTime) {
		this.CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		this.MsgType = msgType;
	}
	public long getMsgId() {
		return MsgId;
	}
	public void setMsgId(long msgId) {
		this.MsgId = msgId;
	}

	public int getFuncFlag() {
		return FuncFlag;
	}

	public void setFuncFlag(int funcFlag) {
		FuncFlag = funcFlag;
	}  
  
  
  
}  