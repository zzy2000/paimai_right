package com.accp.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("user")
public class User {
	@TableId(value = "userid",type = IdType.AUTO)
    private Integer userid;

    private String username;

    private String usermm;

    private String usersfz;

    private String userdh;

    private String userdz;

    private String useryzbh;

    private Integer usersf;

    private String userwt;

    private String userda;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUsermm() {
        return usermm;
    }

    public void setUsermm(String usermm) {
        this.usermm = usermm == null ? null : usermm.trim();
    }

    public String getUsersfz() {
        return usersfz;
    }

    public void setUsersfz(String usersfz) {
        this.usersfz = usersfz == null ? null : usersfz.trim();
    }

    public String getUserdh() {
        return userdh;
    }

    public void setUserdh(String userdh) {
        this.userdh = userdh == null ? null : userdh.trim();
    }

    public String getUserdz() {
        return userdz;
    }

    public void setUserdz(String userdz) {
        this.userdz = userdz == null ? null : userdz.trim();
    }

    public String getUseryzbh() {
        return useryzbh;
    }

    public void setUseryzbh(String useryzbh) {
        this.useryzbh = useryzbh == null ? null : useryzbh.trim();
    }

    public Integer getUsersf() {
        return usersf;
    }

    public void setUsersf(Integer usersf) {
        this.usersf = usersf;
    }

    public String getUserwt() {
        return userwt;
    }

    public void setUserwt(String userwt) {
        this.userwt = userwt == null ? null : userwt.trim();
    }

    public String getUserda() {
        return userda;
    }

    public void setUserda(String userda) {
        this.userda = userda == null ? null : userda.trim();
    }
}