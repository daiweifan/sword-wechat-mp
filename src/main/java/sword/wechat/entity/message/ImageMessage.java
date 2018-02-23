package sword.wechat.entity.message;

import java.util.Map;

import sword.wechat.entity.event.BaseEvent;



public class ImageMessage extends BaseMessage{
	 /**
     * 图片内容
     */

    public ImageMessage() {
        super();
        this.MsgType = "image";
    }

    public ImageMessage(BaseEvent event) {
        super(event);
        this.MsgType = "image";
    }

    public ImageMessage(BaseMessage msg) {
        super(msg);
        this.MsgType = "image";
    }

    public ImageMessage(Map<String, String> values) {
    	super(values);
    }

    private Image Image;


    public Image getImage() {
		return Image;
	}

	public void setImage(Image Image) {
		this.Image = Image;
	}

	@Override
    public String toString() {
        return "ImageMsg [toUserName="
               + ToUserName
               + ", fromUserName="
               + FromUserName
               + ", createTime="
               + CreateTime
               + ", msgType="
               + MsgType
               + ", msgId="
               + MsgId
               + Image
               + "]";
    }
}
