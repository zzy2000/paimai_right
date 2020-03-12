package com.accp.biz;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.JlMapper;
import com.accp.pojo.Jl;
import com.accp.pojo.Pmp;
import com.accp.vo.jieshupmpvo;
import com.accp.vo.jingpaivo;
import com.accp.vo.jingpaizhongpmpvo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class JlBiz {
	@Autowired
	private JlMapper jldao;
	public List<jingpaivo> chajl(int pmpid) {
		return jldao.aaa(pmpid);
	}
	public jingpaivo chajia(int pmpid) {
		return jldao.jia(pmpid);
	}
	public int addjl(Jl jl) {
		jl.setJpsj(new Date());
		return jldao.insert(jl);
	}
	public List<jieshupmpvo> jieshupmp() {
		return jldao.jieshupmp();
	}
	public List<jingpaizhongpmpvo> jingpaizhongpmp() {
		return jldao.jingpaizhongpmp();
	}
}
