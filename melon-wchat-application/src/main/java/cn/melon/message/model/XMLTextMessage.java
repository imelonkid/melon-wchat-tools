package cn.melon.message.model;

import cn.melon.message.Message;
import cn.melon.message.enums.TypeEnum;
import lombok.Builder;


@Builder
public class XMLTextMessage extends XMLMessage {

    private String content;

    @Override
    public String subXML() {
        return "<Content><![CDATA[" + content + "]]></Content>";
    }

    @Override
    public Message convert() {
        return Message.builder()
                .msgtype(TypeEnum.TEXT)
                .touser(toUserName)
                .customservice(null)
                .content(content).build();
    }
}
