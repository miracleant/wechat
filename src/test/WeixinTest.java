package test;

import net.sf.json.JSONObject;
import po.AccessToken;
import util.WeixinUtil;

public class WeixinTest {
	public static void main(String[] args) {
		try {
		AccessToken token=WeixinUtil.getAccessToken();
		System.out.println("票据:"+token.getToken());
		System.out.println("有效时间:"+token.getExpiresIn());
		
		//System.out.println("hello!");
		
//		String path="C:/webdev/Java/code/weixin/WebContent/image/shanyu.jpg";
//		String mediaId=WeixinUtil.upload(path, token.getToken(), "image");
//		System.out.println("id:"+mediaId);
//		String path="C:/webdev/Java/code/weixin/WebContent/image/thumb.jpg";
//		String mediaId=WeixinUtil.upload(path, token.getToken(), "thumb");
//		System.out.println("id:"+mediaId);
		
		String menu=JSONObject.fromObject(WeixinUtil.initMenu()).toString();
		int result=WeixinUtil.createMenu(token.getToken(), menu);
		if(result==0) {
			System.out.println("创建菜单成功");
		}else {
			System.out.println("错误码"+result);
		}
		
		JSONObject jsonObject=WeixinUtil.queryMenu(token.getToken());
		System.out.println(jsonObject);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

//cd /webdev/java
//natapp -authtoken 5b7346ee74e6613e
