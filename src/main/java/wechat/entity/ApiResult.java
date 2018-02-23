package wechat.entity;

import java.util.Map;

import org.nutz.json.Json;

public class ApiResult {


	private Map<String, Object> content;
	private String json;
	private Integer errCode;
	private String errMsg;

	@SuppressWarnings("unchecked")
	public ApiResult(String json) {
		this.json = json;
		this.content = Json.fromJson(Map.class, json);
		this.errCode = (Integer) this.content.get("errcode");
		this.errMsg = this.errCode == null ? "请求成功." : String.valueOf(this.errCode);
	}
	
	public ApiResult() {
		
	}
	
	@SuppressWarnings("unchecked")
	public static ApiResult create(String json){
		if("".equals(json)){
			json ="{\"errcode\":9999,\"errmsg\":\"服务器繁忙，请稍后再试！\"}";
			ApiResult re = new ApiResult();	
			re.setErrCode(-1);
			re.setErrMsg("服务器繁忙，请稍后再试！");
			re.setContent(Json.fromJson(Map.class, json));
			re.setJson(json);
			return re;
			
		}
		return new ApiResult(json);
	}

	public Map<String, Object> getContent() {
		return content;
	}

	public void setContent(Map<String, Object> content) {
		this.content = content;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public Integer getErrCode() {
		return errCode;
	}

	public void setErrCode(Integer errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
	public boolean isSuccess(){
		return (this.errCode==null||this.errCode.intValue()==0);
	}



}
