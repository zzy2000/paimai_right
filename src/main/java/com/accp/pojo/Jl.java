package com.accp.pojo;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
@TableName("jl")
public class Jl {
	@TableId(value = "jlid",type = IdType.AUTO)
    private Integer jlid;

    private Integer userid;

    private Integer pmpid;

    private Date jpsj;

    private Integer jpjg;

    public Integer getJlid() {
        return jlid;
    }

    public void setJlid(Integer jlid) {
        this.jlid = jlid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getPmpid() {
        return pmpid;
    }

    public void setPmpid(Integer pmpid) {
        this.pmpid = pmpid;
    }

    public Date getJpsj() {
        return jpsj;
    }

    public void setJpsj(Date jpsj) {
        this.jpsj = jpsj;
    }

	public int getJpjg() {
		return jpjg;
	}

	public void setJpjg(int jpjg) {
		this.jpjg = jpjg;
	}

    
}