package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.bean.Gra;

@Mapper
public interface RouteMapper {
	@Select("select * from gra")
	public List<Gra> getGra();
	@Select("select * from gra where graId=#{graId}")
	public Gra getGraByGraId(int graId);
	@Select("select * from gra where graClass=#{graClass}")
	public List<Gra> getGraByClass(String graClass);
	@Select("select DISTINCT graClass from gra")
	public List<String> getGraClass();
	@Select("select * from gra where graId=#{graId} ")
	public Gra getGraNameByGraId(int graId);
}
