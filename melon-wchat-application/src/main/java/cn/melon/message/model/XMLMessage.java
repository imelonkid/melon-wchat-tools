package cn.melon.message.model;

import cn.melon.message.Message;
import lombok.Getter;

@Getter
public abstract class XMLMessage {

    protected String toUserName;
    protected String fromUserName;
    protected String msgType;

    /**
     * 子类自定义XML
     * @return XML
     */
    public abstract String subXML();

    /**
     * 转换为  Message 对象
     * @return Message
     */
    public abstract Message convert();

    public String toXML(){
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA["+toUserName+"]]></ToUserName>");
        sb.append("<FromUserName><![CDATA["+fromUserName+"]]></FromUserName>");
        sb.append("<CreateTime>"+System.currentTimeMillis()/1000+"</CreateTime>");
        sb.append("<MsgType><![CDATA["+msgType+"]]></MsgType>");
        sb.append(subXML());
        sb.append("</xml>");
        return sb.toString();
    }
}
