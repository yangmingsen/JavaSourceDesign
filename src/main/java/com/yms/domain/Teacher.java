package com.yms.domain;

/**这是一个Teacher类,继承Person
 *
 * @author created by yangminsen on 2018/6/3
 *
 */
public class Teacher extends Person {
    private String call;
    private String tech;
    private String workSchool;
    private String email;

    public String getCall() {
        return call;
    }

    public void setCall(String call) {
        this.call = call;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public String getWorkSchool() {
        return workSchool;
    }

    public void setWorkSchool(String workSchool) {
        this.workSchool = workSchool;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Teacher(String phone, String name, String address, String call, String tech, String workSchool, String email) {
        super(phone, name, address);
        this.call = call;
        this.tech = tech;
        this.workSchool = workSchool;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "call='" + call + '\'' +
                ", tech='" + tech + '\'' +
                ", workSchool='" + workSchool + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
