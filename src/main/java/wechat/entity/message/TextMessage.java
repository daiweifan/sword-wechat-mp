package wechat.entity.message;

import java.util.Map;

import wechat.entity.event.BaseEvent;


public class TextMessage extends BaseMessage {

	/**
	 * 文本内容
	 */
	private String Content;

	public TextMessage() {
		super();
		this.MsgType = "text";
	}

	public TextMessage(BaseEvent event) {
		super(event);
		this.MsgType = "text";
	}

	public TextMessage(BaseMessage msg) {
		super(msg);
		this.MsgType = "text";
	}

	public TextMessage(Map<String, String> values) {
		super(values);
		this.Content = values.get("content");
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		this.Content = content;
	}

	@Override
	public String toString() {
		return "TextMsg [toUserName=" + ToUserName + ", fromUserName=" + FromUserName + ", createTime=" + CreateTime
				+ ", msgType=" + MsgType + ", content=" + Content + ", msgId=" + MsgId + "]";
	}

}