package wechat.exception;

public class WechatApiException extends Exception {

	private static final long serialVersionUID = 0L;

	public WechatApiException() {
		super();
	}

	public WechatApiException(String message, Throwable cause) {
		super(message, cause);
	}

	public WechatApiException(String message) {
		super(message);
	}

	public WechatApiException(Throwable cause) {
		super(cause);
	}

}
