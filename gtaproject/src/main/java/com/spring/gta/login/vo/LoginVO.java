package com.spring.gta.login.vo;

public class LoginVO {
    private String username;  // 사용자 아이디
    private String password;  // 사용자 비밀번호
    private String bId;
    private String bPwd;
    private String bName;
    private String bAddr;
    private String bHp;

    public LoginVO(String bId, String bPwd, String bName, String bAddr, String bHp) {
        this.bId = bId;
        this.bPwd = bPwd;
        this.bName = bName;
        this.bAddr = bAddr;
        this.bHp = bHp;
    }

    public LoginVO() {}

    public String getbId() {
        return bId;
    }


    public void setbId(String bId) {
        this.bId = bId;
    }

    public String getbPwd() {
        return bPwd;
    }

    public void setbPwd(String bPwd) {
        this.bPwd = bPwd;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getbAddr() {
        return bAddr;
    }

    public void setbAddr(String bAddr) {
        this.bAddr = bAddr;
    }

    public String getbHp() {
        return bHp;
    }

    public void setbHp(String bHp) {
        this.bHp = bHp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginVO [username=" + username + ", password=" + password + ", bId=" + bId + ", bPwd=" + bPwd +
                ", bName=" + bName + ", bAddr=" + bAddr + ", bHp=" + bHp + "]";
    }
}
