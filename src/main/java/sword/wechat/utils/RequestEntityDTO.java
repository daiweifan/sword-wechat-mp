package sword.wechat.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RequestEntityDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1581256226125946783L;
	
	private String sender;
	private String receiver;
	private String appid;
	private String transcode;
	private String trantime;
	private String iseqno;
	
	private List<Map<String,Object>> accInfoList=new ArrayList<Map<String,Object>>();

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getTranscode() {
		return transcode;
	}

	public void setTranscode(String transcode) {
		this.transcode = transcode;
	}

	public String getTrantime() {
		return trantime;
	}

	public void setTrantime(String trantime) {
		this.trantime = trantime;
	}

	public List<Map<String, Object>> getAccInfoList() {
		return accInfoList;
	}

	public void setAccInfoList(List<Map<String, Object>> accInfoList) {
		this.accInfoList = accInfoList;
	}

	public String getIseqno() {
		return iseqno;
	}

	public void setIseqno(String iseqno) {
		this.iseqno = iseqno;
	}

}
