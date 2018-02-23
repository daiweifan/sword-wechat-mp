package sword.wechat.entity.message;

import java.util.Map;

import sword.wechat.entity.event.BaseEvent;



public class VoiceMessage extends BaseMessage {
	 /**
     * 语音消息媒体id,可以调用多媒体文件下载接口拉取数据
     */
    private String mediaId;
    /**
     * 语音格式,如amr,speex等
     */
    private String format;
    /**
     * 语音识别结果,UTF8编码
     */
    private String recognition;

    public VoiceMessage() {
        super();
        this.MsgType = "voice";
    }

    public VoiceMessage(BaseEvent event) {
        super(event);
        this.MsgType = "voice";
    }

    public VoiceMessage(BaseMessage msg) {
        super(msg);
        this.MsgType = "voice";
    }

    public VoiceMessage(Map<String, String> values) {
        super(values);
        this.mediaId = values.get("mediaId");
        this.format = values.get("format");
        this.recognition = values.get("recognition");
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getRecognition() {
        return recognition;
    }

    public void setRecognition(String recognition) {
        this.recognition = recognition;
    }

    @Override
    public String toString() {
        return "VoiceMsg [toUserName="
               + ToUserName
               + ", fromUserName="
               + FromUserName
               + ", createTime="
               + CreateTime
               + ", msgType="
               + MsgType
               + ", msgId="
               + MsgId
               + ", mediaId="
               + mediaId
               + ", format="
               + format
               + ", recognition="
               + recognition
               + "]";
    }
}
