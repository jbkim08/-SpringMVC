package com.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.demo.beans.BoardInfoBean;

public interface MenuMapper {

	@Select("select board_info_idx, board_info_name " +
			"from board_info_table " + 
			"order by board_info_idx")
	List<BoardInfoBean> getMenuList();
}
