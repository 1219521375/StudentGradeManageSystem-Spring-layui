package com.example.demo.bean.tool;

public class User {
    //Announcing、Chooseing、Teaching、Uploading和Checking,
    // 其中Announcing 表示正在发布，
    // Chooseing表示正在选课，
    // Teaching表示正在上课，
    // Uploading表示正在上传成绩，
    // Checking表示学生可以查看自己的成绩；
    /*用户登录名称*/
    private String userName;
    /* 用户登录密码 */
    private String password;

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
