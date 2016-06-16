package serviceImpl;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import model.Students;

import org.junit.Test;

import service.StudentsDAO;

public class TestStudentsDAOImpl {
	
	@Test
	public void testQueryAllStudents(){
		StudentsDAO sdao = new StudentsDAOImpl();
		List<Students> list = sdao.queryAllStudents();
		
		for(int i =0; i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
	/*
	@Test
	public void testGetNewSid(){
		StudentsDAOImpl sdao = new StudentsDAOImpl();
		System.out.println(sdao.getNewSid());
	}
	//测试完成后将getNewSid()方法改成私有化方法，则本页中无法调用
	*/
	
	@Test
	public void testAddStudents(){
		Students s = new Students();
		s.setSname("肖星");
		s.setGender("女");
		s.setBirth(new Date());
		s.setAddress("大冶");
		StudentsDAO sdao = new StudentsDAOImpl();
		Assert.assertEquals(true, sdao.addStudents(s));
	}
}
