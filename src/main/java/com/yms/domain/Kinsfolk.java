package com.yms.domain;

import javax.xml.ws.Action;

/**这是一个Kinsfolk类,继承Person
 *
 * @author created by yangminsen on 2018/6/3
 *
 */
public class Kinsfolk extends Person {
    private String call;
    private String profession;
    private String weChat;

    public Kinsfolk(String phone, String name, String address, String call, String profession, String weChat) {
        super(phone, name, address);
        this.call = call;
        this.profession = profession;
        this.weChat = weChat;
    }

    public String getCall() {
        return call;
    }

    public void setCall(String call) {
        this.call = call;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    @Override
    public String toString() {
        return "Kinsfolk{" +
                "call='" + call + '\'' +
                ", profession='" + profession + '\'' +
                ", weChat='" + weChat + '\'' +
                '}';
    }
}
