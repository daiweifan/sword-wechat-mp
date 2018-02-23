package sword.wechat.entity.api;

import org.nutz.json.JsonField;


public class AccessToken { 
	
   // 获取到的凭证
	@JsonField(value="access_token")
   private String token;  
   // 凭证有效时间，单位：秒  
	@JsonField(value="expires_in")
   private long expiresIn;  
 
   public String getToken() {  
       return token;  
   }  
 
   public void setToken(String token) {  
       this.token = token;  
   }  
 
   public long getExpiresIn() {  
       return expiresIn;  
   }  
 
   public void setExpiresIn(long expiresIn) {  
       this.expiresIn = System.currentTimeMillis()+(expiresIn-600)*1000;  
   } 
   
   public boolean isAvailable(){
	   if(token!=null&&!token.equals("")&&expiresIn>=System.currentTimeMillis()){
		   return true;
	   }
	   return false;
   }
   
   @Override
   public String toString(){
	   return "AccessToeken [accessToken="+token+",expiresIn="+expiresIn+"]";
   }
   
   
}  