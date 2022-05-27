package com.yjj.spring_029_1.Dao;

import java.util.ArrayList;

import com.yjj.spring_029_1.Dto.ContentDto;

public interface IDao {

	public ArrayList<ContentDto> listDao();
	
	public void writeDao(String mwriter, String mcontent);
	
	public void deleteDao(String mnum);
	
	public ContentDto mviewDao(String mnum);
	
}
