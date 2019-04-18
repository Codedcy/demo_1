package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.bean.Spot;

@Mapper
public interface SpotInfoMapper {
	
	@Select("select * from spotInfo where graId=#{graId} order by spotId ")
	public List<Spot> getSpotBygraId(int graId);
	
	@Select("select * from spotInfo where graId=#{graId} and spotId=#{spotId} ")
	public List<Spot> getSpotBygraIdAndSpotId(int graId, int spotId);
	
	@Insert("insert into spotInfo (graId,spotId,lng,lat,content,spotName) values(#{graId},#{spotId},#{lng},#{lat},#{content},#{spotName})")  
	public int addSpotInfo(Spot spot);
}
