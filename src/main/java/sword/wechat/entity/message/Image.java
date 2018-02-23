package sword.wechat.entity.message;

public class Image {
	
	private String MediaId;
	
    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        this.MediaId = mediaId;
    }
    
    public Image()
    {
    	
    }
    
	public Image(String MediaId) {

		this.MediaId = MediaId;
	}
}
