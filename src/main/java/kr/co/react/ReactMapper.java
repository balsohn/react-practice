package kr.co.react;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReactMapper {

	boolean write(Map<String, String> content);
	
}
