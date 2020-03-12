package com.accp.pojo;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
@TableName("pmp")
public class Pmp {
	@TableId(value = "pmpid",type = IdType.AUTO)
    private Integer pmpid;

    private String pmpname;

    private String pmpqpj;

    private String pmpdj;

    private Date pmpkssj;

    private Date pmpjssj;

    private String pmptplj;

    private String pmptpkzm;

    private String pmpms;

    public Integer getPmpid() {
        return pmpid;
    }

    public void setPmpid(Integer pmpid) {
        this.pmpid = pmpid;
    }

    public String getPmpname() {
        return pmpname;
    }

    public void setPmpname(String pmpname) {
        this.pmpname = pmpname == null ? null : pmpname.trim();
    }

    public String getPmpqpj() {
        return pmpqpj;
    }

    public void setPmpqpj(String pmpqpj) {
        this.pmpqpj = pmpqpj == null ? null : pmpqpj.trim();
    }

    public String getPmpdj() {
        return pmpdj;
    }

    public void setPmpdj(String pmpdj) {
        this.pmpdj = pmpdj == null ? null : pmpdj.trim();
    }

    public Date getPmpkssj() {
        return pmpkssj;
    }

    public void setPmpkssj(Date pmpkssj) {
        this.pmpkssj = pmpkssj;
    }

    public Date getPmpjssj() {
        return pmpjssj;
    }

    public void setPmpjssj(Date pmpjssj) {
        this.pmpjssj = pmpjssj;
    }

    public String getPmptplj() {
        return pmptplj;
    }

    public void setPmptplj(String pmptplj) {
        this.pmptplj = pmptplj == null ? null : pmptplj.trim();
    }

    public String getPmptpkzm() {
        return pmptpkzm;
    }

    public void setPmptpkzm(String pmptpkzm) {
        this.pmptpkzm = pmptpkzm == null ? null : pmptpkzm.trim();
    }

    public String getPmpms() {
        return pmpms;
    }

    public void setPmpms(String pmpms) {
        this.pmpms = pmpms == null ? null : pmpms.trim();
    }
}