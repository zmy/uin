package grabber.weibo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import sdk.weibo4j.Account;
import sdk.weibo4j.Oauth;
import sdk.weibo4j.Weibo;
import sdk.weibo4j.http.AccessToken;
import sdk.weibo4j.model.WeiboException;
import sdk.weibo4j.org.json.JSONException;
import sdk.weibo4j.org.json.JSONObject;
import sdk.weibo4j.util.BareBonesBrowserLaunch;

public class WeiboLogin {
	private String accesstoken;
	private String uid;
	public void weiboLogin() throws WeiboException, IOException{
		Oauth oauth = new Oauth();
		BareBonesBrowserLaunch.openURL(oauth.authorize("code",""));
		System.out.println("Please enter the code after redirect URL");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String code = br.readLine();
		Weibo weibo=new Weibo();
		
		try{
			AccessToken accesstoken=oauth.getAccessTokenByCode(code);
			this.accesstoken=accesstoken.getAccessToken();
			Account am = new Account();
			am.client.setToken(this.accesstoken);
			try {
				JSONObject uid = am.getUid();
				this.uid=uid.getString("uid");
				System.out.println(uid+"!!!!!"+this.uid);
			} catch (WeiboException e) {
				e.printStackTrace();
			}
			catch(JSONException p)
			{
				p.printStackTrace();
			}
		} catch (WeiboException e) {
			if(401 == e.getStatusCode()){
				System.out.println("Unable to get the access token.");
			}else{
				e.printStackTrace();
			}
		}
	}
	public String getUid()
	{
		return uid;
	}
	public String getAccesstoken()
	{
		return accesstoken;
	}
}
