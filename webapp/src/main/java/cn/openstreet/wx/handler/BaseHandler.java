package cn.openstreet.wx.handler;

import java.util.Date;

import cn.openstreet.wx.bean.MsgRequest;
import cn.openstreet.wx.util.MsgXmlUtil;
import cn.openstreet.wx.util.MsicUtil;
import cn.openstreet.wx.bean.MsgResponseText;


public abstract class BaseHandler<T extends MsgRequest> {

	
	public abstract String doHandleMsg(T msgRequest);
	
	protected String getResponseStringByContent(String content,MsgRequest msgRequest){
		MsgResponseText reponseText = new MsgResponseText();
		reponseText.setToUserName(msgRequest.getFromUserName());
		reponseText.setFromUserName(msgRequest.getToUserName());
		reponseText.setMsgType("text");
		reponseText.setCreateTime(new Date().getTime());
		reponseText.setContent(content);
		msgRequest.setMsgResponse(reponseText);
		return MsicUtil.formatString(MsgXmlUtil.textToXml(reponseText));
	}
	
}
