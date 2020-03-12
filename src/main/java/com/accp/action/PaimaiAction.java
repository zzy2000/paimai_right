package com.accp.action;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.accp.biz.JlBiz;
import com.accp.biz.PmpBiz;
import com.accp.biz.UserBiz;
import com.accp.pojo.Jl;
import com.accp.pojo.Pmp;
import com.accp.pojo.User;
import com.accp.vo.jieshupmpvo;
import com.accp.vo.jingpaivo;
import com.accp.vo.jingpaizhongpmpvo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/api/paimai")
public class PaimaiAction {
	@Autowired
	private UserBiz userbiz;
	@Autowired
	private PmpBiz pmpbiz;
	@Autowired
	private JlBiz jlbiz;
	//登录
	@GetMapping("denglu/{username}/{usermm}")
	public Map<String, Object> denglu(@PathVariable String username, @PathVariable String usermm,HttpSession session) {
		Map<String, Object> message = new HashMap<String, Object>();
		User u=userbiz.denglu(username,usermm);
		if(u!=null) {
			session.setAttribute("user", u);
			message.put("code", "200");
			message.put("msg", "登录成功");
			message.put("data", u);
			message.put("token", session.getId());
		}else {
			message.put("code", "300");
			message.put("msg", "用户名或密码错误");
		}
		return message;
	}
	//注册
	@PostMapping("zhuce")
	public Map<String, Object> zhuce(@RequestBody User u) {
		int count=userbiz.zhuce(u);
		Map<String, Object> message = new HashMap<String, Object>();
		if(count!=0) {
			message.put("code", "200");
			message.put("msg", "注册成功");
		}else {
			message.put("code", "300");
			message.put("msg", "注册失败");
		}
		return message;
	}
	//用户
	@GetMapping("user")
	public Object user(HttpSession session) {
		return session.getAttribute("user");
	}
	//拍卖首页
	@GetMapping("shouye/{n}/{s}/{pmpname}/{pmpms}/{pmpkssj}/{pmpjssj}/{pmpqpj}")
	public PageInfo<Pmp> shouye(@PathVariable int n,@PathVariable int s,
			@PathVariable String pmpname,@PathVariable String pmpms,
			@PathVariable String pmpkssj,@PathVariable String pmpjssj,
			@PathVariable String pmpqpj) {
		return pmpbiz.shouye(n,s,pmpname,pmpms,pmpkssj,pmpjssj,pmpqpj);
	}
	//竞拍物
	@GetMapping("jingpaiwu/{id}")
	public Pmp jingpaiwu(@PathVariable int id) {
		return pmpbiz.jingpai(id);
	}
	//竞拍人
	@GetMapping("jingpairen/{id}")
	public List<jingpaivo> jingpairen(@PathVariable int id) {
		return jlbiz.chajl(id);
	}
	//竞拍价
	@GetMapping("jingpaijia/{id}")
	public jingpaivo jingpaijia(@PathVariable int id) {
		return jlbiz.chajia(id);
	}
	//新增记录
	@PostMapping("addjl")
	public Map<String, Object> addjl(@RequestBody Jl jl) {
		int count=jlbiz.addjl(jl);
		Map<String, Object> message = new HashMap<String, Object>();
		if(count!=0) {
			message.put("code", "200");
			message.put("msg", "竞价成功");
		}else {
			message.put("code", "300");
			message.put("msg", "竞价失败");
		}
		return message;
	}
	//判断是否正在竞拍
	@GetMapping("aaa/{kssj}/{jssj}")
	public Map<String, Object> jingpai(@PathVariable String kssj,@PathVariable String jssj) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Map<String, Object> message = new HashMap<String, Object>();
		try {
			Date kssj1 = sdf.parse(kssj);
			Date jssj1 = sdf.parse(jssj);
			Date dqsj=new Date();
			/*
			 * String jqsj1=dqsj.toString(); Date dqsj2 = sdf.parse(jqsj1);
			 */
			if(dqsj.getTime()>jssj1.getTime()) {
				message.put("code", "100");
				message.put("msg", "该拍卖品竞拍已结束");
			}else if(dqsj.getTime()<kssj1.getTime()) {
				message.put("code", "200");
				message.put("msg", "敬请期待");
			}else {
				message.put("code", "300");
				message.put("msg", "溜了溜了");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}
	//竞拍结束的拍卖详情
	@GetMapping("jieshupmp")
	public List<jieshupmpvo> jieshupmp() {
		return jlbiz.jieshupmp();
	}
	//正在拍卖的详情
	@GetMapping("jingpaizhongpmp")
	public List<jingpaizhongpmpvo> jingpaizhongpmp() {
		return jlbiz.jingpaizhongpmp();
	}
	//新增修改拍卖品
	@PostMapping("addpmp")
	public Map<String, Object> addpmp(@RequestBody Pmp pmp) {
		Map<String, Object> message = new HashMap<String, Object>();
			if(pmp.getPmpid()==0) {
				int count = pmpbiz.addpmp(pmp);
				if(count>0) {
					message.put("code", "200");
					message.put("msg", "拍卖品添加成功");
				}else{
					message.put("code", "300");
					message.put("msg", "拍卖品添加失败");
				}
			}else {
				int count=pmpbiz.xiugaipmp(pmp);
				if(count>0) {
					message.put("code", "200");
					message.put("msg", "拍卖品修改成功");
				}else{
					message.put("code", "300");
					message.put("msg", "拍卖品修改失败");
				}
			}
			
		return message;
	}
	@DeleteMapping("shangchu/{pmpid}/{kssj}/{jssj}")
	public Map<String, Object> shangchu(@PathVariable int pmpid,@PathVariable String kssj,@PathVariable String jssj) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Map<String, Object> message = new HashMap<String, Object>();
		try {
			Date kssj1 = sdf.parse(kssj);
			Date jssj1 = sdf.parse(jssj);
			Date dqsj=new Date();
			if(dqsj.getTime()>kssj1.getTime()&&dqsj.getTime()<jssj1.getTime()) {
				message.put("code", "100");
				message.put("msg", "该拍卖品正在竞拍不可操作");
			}else{
				pmpbiz.shangchu(pmpid);
				message.put("code", "200");
				message.put("msg", "溜了溜了");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}
}
