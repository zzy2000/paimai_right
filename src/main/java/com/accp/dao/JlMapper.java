package com.accp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.Jl;
import com.accp.vo.jieshupmpvo;
import com.accp.vo.jingpaivo;
import com.accp.vo.jingpaizhongpmpvo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface JlMapper extends BaseMapper<Jl>{
     List<jingpaivo> aaa(@Param("pmpid") Integer pmpid);
     jingpaivo jia(@Param("pmpid") Integer pmpid);
     List<jieshupmpvo> jieshupmp();
     List<jingpaizhongpmpvo> jingpaizhongpmp();
}