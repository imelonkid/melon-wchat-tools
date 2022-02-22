package cn.melon.auth;

import lombok.Builder;
import lombok.Getter;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Arrays;

/**
 * 微信鉴权
 */
@Getter
@Builder
public class Auth {

    /**
     * 签名
     */
    private String signature;

    /**
     * 时间戳
     */
    private String timestamp;

    /**
     * 随机数
     */
    private String nonce;

    /**
     * 随机字符串
     */
    private String echostr;

    //从官方获取
    private String token = "test";


    /**
     * 校验签名
     *
     * @return 校验结果
     */
    public boolean checkSignature() {
        return signature.equals(generateSignature(token,timestamp,nonce));
    }


    /**
     * 校验签名 加密常见
     *
     * @return
     */
    public boolean checkSignatureWithEncrypt(){
        return true;
    }



    /**
     * 生成事件消息接收签名
     * @param token token
     * @param timestamp timestamp
     * @param nonce nonce
     * @return str
     */
    private String generateSignature(String token, String timestamp,String nonce) {
        String[] array = new String[]{token,timestamp,nonce};
        Arrays.sort(array);
        String s = arrayToDelimitedString(array, "");
        return DigestUtils.shaHex(s);
    }


    private String arrayToDelimitedString(Object[] arr, String delim) {
        if (arr == null || arr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                sb.append(delim);
            }
            sb.append(arr[i]);
        }
        return sb.toString();
    }
    


}