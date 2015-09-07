package cn.openstreet.wx.handler;


import cn.openstreet.wx.bean.MsgRequest;

public class EventHandler extends BaseHandler {
	@Override
	public String doHandleMsg(MsgRequest msgRequest) {
		if(!"event".equals(msgRequest.getMsgType()))
			return null;
		else
			if("subscribe".equals(msgRequest.getEvent())){
				return getResponseStringByContent("欢迎您关注大早教，我将定期为您推荐一些经典育儿心得。欢迎您加入大早教。", msgRequest);
			}else if("CLICK".equals(msgRequest.getEvent())){
				String eventKey = msgRequest.getEventKey();
				String content = "";
				content = "Click Menu"+msgRequest.getEventKey();
				return getResponseStringByContent(content, msgRequest);
			}
			else{ 
				return getResponseStringByContent("暂时无法处您的请求，请稍后再试。", msgRequest);
			}

	}
}
