package com.accp.vo;

import java.util.Date;
import java.util.List;

public class jingpaizhongpmpvo {
	private Integer pmpid;
	private String pmpname;
	private Date pmpkssj;
	private Date pmpjssj;
	private String pmpqpj;
	private List<listvo> list;
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
		this.pmpname = pmpname;
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
	public String getPmpqpj() {
		return pmpqpj;
	}
	public void setPmpqpj(String pmpqpj) {
		this.pmpqpj = pmpqpj;
	}
	public List<listvo> getList() {
		return list;
	}
	public void setList(List<listvo> list) {
		this.list = list;
	}
	
}
