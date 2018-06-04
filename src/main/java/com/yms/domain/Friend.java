package com.yms.domain;

/**这是一个Friend类,继承Person
 *
 * @author created by yangminsen on 2018/6/3
 *
 */
public class Friend extends Person {

    private String email;
    private String qq;
    private String weChat;

    public Friend(String phone, String name, String address, String email, String qq, String weChat) {
        super(phone, name, address);
        this.email = email;
        this.qq = qq;
        this.weChat = weChat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    @Override
    public String toString() {

        return "Friend{" +
                "email='" + email + '\'' +
                ", qq='" + qq + '\'' +
                ", weChat='" + weChat + '\'' +
                '}';
    }
}
