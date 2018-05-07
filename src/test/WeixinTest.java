package test;

import net.sf.json.JSONObject;
import po.AccessToken;
import util.WeixinUtil;

public class WeixinTest {
	public static void main(String[] args) {
		try {
		AccessToken token=WeixinUtil.getAccessToken();
		System.out.println("Ʊ��:"+token.getToken());
		System.out.println("��Чʱ��:"+token.getExpiresIn());
		
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
			System.out.println("�����˵��ɹ�");
		}else {
			System.out.println("������"+result);
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
