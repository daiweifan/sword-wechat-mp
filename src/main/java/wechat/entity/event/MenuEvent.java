package wechat.entity.event;

import java.util.Map;

/**
 * 菜单事件类型
 * @author dongwei
 *
 */
public class MenuEvent extends BaseEvent {
	public MenuEvent() {
		super();
	}

	public MenuEvent(Map<String, String> values) {
		super(values);
	}

	@Override
	public String toString() {
		return "MenuEvent [toUserName=" + toUserName + ", fromUserName=" + fromUserName + ", createTime=" + createTime
				+ ", msgType=" + msgType + ", event=" + event + ", eventKey=" + eventKey + "]";
	}
}
