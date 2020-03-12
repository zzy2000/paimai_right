package com.accp.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.accp.dao.PmpMapper;
import com.accp.pojo.Pmp;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class PmpBiz {
	@Autowired
	private PmpMapper pmpdao;
	public PageInfo<Pmp> shouye(int n,int s, String pmpname, String pmpms,String pmpkssj, String pmpjssj,String pmpqpj) {
		QueryWrapper<Pmp> qw=Wrappers.query();
		if(!pmpname.equals("null")) {qw.like("pmpname", pmpname);};
		if(!pmpms.equals("null")) {qw.like("pmpms",pmpms);};
		if(!pmpkssj.equals("null")) {qw.ge("pmpkssj", pmpkssj);};
		if(!pmpjssj.equals("null")) {qw.le("pmpjssj",pmpjssj);};
		if(!pmpqpj.equals("null")) {qw.between("pmpqpj",(Integer.parseInt(pmpqpj)-1000),(Integer.parseInt(pmpqpj)+1000));};
		PageHelper.startPage(n, s);
		return new PageInfo<Pmp>(pmpdao.selectList(qw));
	}
	public Pmp jingpai(int id) {
		return pmpdao.selectById(id);
	}
	public int addpmp(Pmp pmp) {
		return pmpdao.insert(pmp);
	}
	public int shangchu(int pmpid) {
		return pmpdao.deleteById(pmpid);
	}
	public int xiugaipmp(Pmp pmp) {
		return pmpdao.updateById(pmp);
	}
}
