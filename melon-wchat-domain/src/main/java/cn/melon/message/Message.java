package cn.melon.message;

import cn.melon.message.enums.TypeEnum;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Builder
@NoArgsConstructor
public class Message<T> {


    /**
     * 账号
     */
    private String touser;


    /**
     * 消息类型
     */
    private TypeEnum msgtype;

    /**
     * 如果需要以某个客服帐号来发消息（在微信6.0.2及以上版本中显示自定义头像），
     * 则需在JSON数据包的后半部分加入customservice参数，例如发送文本消息则改为：
     */
    private Customservice customservice;

    /**
     * 消息内容
     */
    private T content;


    public static class Customservice{

        private String kf_account;

        public String getKf_account() {
            return kf_account;
        }

        public void setKf_account(String kf_account) {
            this.kf_account = kf_account;
        }

    }
}
