package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.lang.model.util.Elements;
import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;

import po.Image;
import po.ImageMessage;
import po.Music;
import po.MusicMessage;
import po.News;
import po.NewsMessage;
import po.TextMessage;

public class MessageUtil {
	
	public static final String MESSAGE_TEXT="text";
	public static final String MESSAGE_IMAGE="image";
	public static final String MESSAGE_VOICE="voice";
	public static final String MESSAGE_VEDIO="vedio";
	public static final String MESSAGE_LINK="link";
	public static final String MESSAGE_LOCATION="loacation";
	public static final String MESSAGE_EVENT="event";
	public static final String MESSAGE_SUBSCRIBE="subscribe";
	public static final String MESSAGE_UNSUBSCRIBE="unsubscribe";
	public static final String MESSAGE_CLICK="CLICK";
	public static final String MESSAGE_VIEW="VIEW";
	public static final String MESSAGE_NEWS="news";
	public static final String MESSAGE_MUSIC="music";
	public static final String MESSAGE_SCANCODE="scancode";
	
	
	public static Map<String,String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException{
		Map<String,String> map=new HashMap<String,String>();
		SAXReader reader=new SAXReader();
		
		InputStream ins=request.getInputStream();
		Document doc=reader.read(ins);
		
		Element root=doc.getRootElement();
		List<Element> list=root.elements();
		
		for(Element e:list) {
			map.put(e.getName(),e.getText());
		}
		ins.close();
		return map;
	}
	
	/*
	 * text消息转换为xml
	 */
	public static String textMessageToXml(TextMessage textMessage) {
		XStream xstream=new  XStream();
		xstream.alias("xml", textMessage.getClass());
		return xstream.toXML(textMessage);
	}
	
	public static String initText(String toUserName,String fromUserName,String content) {
	
		TextMessage text=new TextMessage();
		text.setFromUserName(toUserName);
		text.setToUserName(fromUserName);
		text.setMsgType(MessageUtil.MESSAGE_TEXT);
		text.setCreateTime(new Date().getTime());
		text.setContent(content);
		return textMessageToXml(text);
	}
	
	public static String menuText() {
		StringBuffer sb=new StringBuffer();
		sb.append("欢迎您的关注,请按照菜单提示操作:\n\n");
		sb.append("1、订单管理系统介绍\n");
		sb.append("2、订单管理图文消息\n");
		sb.append("3、订单管理系统二维码图片\n");
		//sb.append("4、听首歌\n");
		sb.append("\n回复？ 调出主菜单\n");
		
		return sb.toString();
	}
	
	public static String firstMenu() {
		StringBuffer sb=new StringBuffer();
		sb.append("订单管理系统基于微信公众号开发，http://huayra.s1.natapp.cc/weixin/");
		
		return sb.toString();
	}
	
	public static String secondMenu() {
		StringBuffer sb=new StringBuffer();
		sb.append("订单管理体统图文消息");
		
		return sb.toString();
	}
	
	/*
	 * 图文消息转换为xml
	 */
	public static String newsMessageToXml(NewsMessage newsMessage) {
		XStream xstream=new  XStream();
		xstream.alias("xml", newsMessage.getClass());
		xstream.alias("item",new News().getClass());
		return xstream.toXML(newsMessage);
	}
	
	public static String initNewsMessage(String toUserName,String fromUserName) {
		String message=null;
		List<News> newsList=new ArrayList<News>();
		NewsMessage newsMessage=new NewsMessage();
		
		News news=new News();
		news.setTitle("山屿网络介绍");
		news.setDescription("初次学习公众号开发");
		news.setPicUrl("http://huayra.s1.natapp.cc/weixin/image/shanyu.jpg");
		news.setUrl("http://huayra.s1.natapp.cc/weixin/");
		
		newsList.add(news);
		
		newsMessage.setFromUserName(toUserName);
		newsMessage.setToUserName(fromUserName);
		newsMessage.setCreateTime(new Date().getTime());
		newsMessage.setMsgType(MESSAGE_NEWS);
		newsMessage.setArticleCount(newsList.size());
		newsMessage.setArticles(newsList);
		
		message=newsMessageToXml(newsMessage);
		return message;
	}

	
	public static String imageMessageToXml(ImageMessage imageMessage) {
			XStream xstream=new  XStream();
			xstream.alias("xml", imageMessage.getClass());
			//xstream.alias("item",new News().getClass());
			return xstream.toXML(imageMessage);
		}
	
	public static String initImageMessage(String toUserName,String fromUserName) {
		String message=null;
		Image image=new Image();
		//shanyou.jpg
		//image.setMediaId("2_r0p_Xo6T26qnbYonsD1C70smPxJXg3KYUFvzOAwftOjQ2LVDrq1TcglO2oMy2b");
		//shanyu.png
		image.setMediaId("x-YyzzqLMe4JmnsKjC0rWynSLz95EL1i_t0XWfCvBrAsCU0I6UFT8CNX1bFkLtrA");
		ImageMessage imageMessage=new ImageMessage();
		imageMessage.setFromUserName(toUserName);
		imageMessage.setToUserName(fromUserName);
		imageMessage.setMsgType(MESSAGE_IMAGE);
		imageMessage.setCreateTime(new Date().getTime());
		imageMessage.setImage(image);
		
		message=imageMessageToXml(imageMessage);
		return message;
	}
	
	public static String musicMessageToXml(MusicMessage musicMessage) {
		XStream xstream=new  XStream();
		xstream.alias("xml", musicMessage.getClass());
		//xstream.alias("item",new News().getClass());
		return xstream.toXML(musicMessage);
	}
	
	public static String initMusicMessage(String toUserName,String fromUserName) {
		String message=null;
		Music music=new Music();
		music.setThumbMediaId("daEQyRQGjknxDkaqYR6fAGgtrJE2ese4vPeffsyL4cgeThMc9uJpim0q_2_zPwCf");
		music.setTitle("see you again");
		music.setDescription("给钟阳");
		music.setMusicUrl("http://huayra.s1.natapp.cc/weixin/resource/SeeYouAgain.mp3");
		music.setHQMusicUrl("http://huayra.s1.natapp.cc/weixin/resource/SeeYouAgain.mp3");
		
		MusicMessage musicMessage=new MusicMessage();
		musicMessage.setFromUserName(toUserName);
		musicMessage.setToUserName(fromUserName);
		musicMessage.setMsgType(MESSAGE_MUSIC);
		musicMessage.setCreateTime(new Date().getTime());
		musicMessage.setMusic(music);
		message=musicMessageToXml(musicMessage);
		return message;
	}
	
}
