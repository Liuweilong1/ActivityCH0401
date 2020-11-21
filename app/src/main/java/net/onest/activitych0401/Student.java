package net.onest.activitych0401;

import java.io.Serializable;

//使用Intent传递该类型对象时，需要让该类实现Serializable接口
public class Student  implements Serializable {
    private String name;
    private String phone;
    private String email;

    public Student() {
    }

    public Student(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
