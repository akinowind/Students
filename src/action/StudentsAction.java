package action;


import java.text.SimpleDateFormat;
import java.util.List;

import model.Students;

import service.StudentsDAO;
import serviceImpl.StudentsDAOImpl;

//学生action类
public class StudentsAction extends SuperAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//查询所有学生的动作
	public String query(){
		StudentsDAO sdao = new StudentsDAOImpl();
		List<Students> list = sdao.queryAllStudents();
		System.out.println("queryStudents2-----");
		//放进session中
		if(list!=null &&list.size()>0){
			session.setAttribute("students_list", list);
			
		}
		return "query_success";
	}
	//根据id查询学生
	public String queryById(){
		String sid = request.getParameter("sid");
		System.out.println(sid);
		StudentsDAO sdao = new StudentsDAOImpl();
		List<Students> list = sdao.queryStudents(sid);
		System.out.println("========queryById==========="+list.size());
		//放进session中
		if(list!=null &&list.size()>0){
			session.setAttribute("students_list", list);
			System.out.println("========queryById2===========");
		}
		return "queryId_success";
	}
	
	//删除学生的动作
	public String delete(){
		StudentsDAO sdao = new StudentsDAOImpl();
		String sid = request.getParameter("sid");
		sdao.deleteStudents(sid);
		return "delete_success";
	}
	public String add() throws Exception{
		Students s = new Students();
		s.setSname(request.getParameter("sname"));
		s.setGender(request.getParameter("gender"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		s.setBirth(sdf.parse(request.getParameter("birthday")));
		s.setAddress(request.getParameter("address"));
		StudentsDAO sdao = new StudentsDAOImpl();
		sdao.addStudents(s);
		return "add_success";
	}
	
	//修改学生资料动作
	public String modify(){
		//获得传递过来的学生编号
		String sid = request.getParameter("sid");
		StudentsDAO sdao = new StudentsDAOImpl();
		Students s = sdao.queryStudentsBySid(sid);
		//保存在会话中
		session.setAttribute("modify_students", s);
		return "modify_success";
	}
	//保存修改后的学生资料动作
	public String save() throws Exception{
		Students s = new Students();
		s.setSid(request.getParameter("sid"));
		s.setSname(request.getParameter("sname"));
		s.setGender(request.getParameter("gender"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		s.setBirth(sdf.parse(request.getParameter("birthday")));
		s.setAddress(request.getParameter("address"));
		StudentsDAO sdao = new StudentsDAOImpl();
		sdao.updateStudents(s);
		return "save_success";
	}
}
