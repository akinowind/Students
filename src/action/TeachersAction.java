package action;

import java.text.SimpleDateFormat;
import java.util.List;

import model.Students;
import model.Teachers;


import service.StudentsDAO;
import service.TeachersDAO;
import serviceImpl.StudentsDAOImpl;
import serviceImpl.TeachersDAOImpl;

public class TeachersAction extends SuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//��ѯ���н�ʦ�Ķ���
	public String query(){
		TeachersDAO tdao = new TeachersDAOImpl();
		List<Teachers> list = tdao.queryAllTeachers();
		//�Ž�session��
		if(list!=null &&list.size()>0){
			session.setAttribute("teachers_list", list);
			
		}
		return "query_success";
	}
	
	//ɾ����ʦ�Ķ���
	public String delete(){
		TeachersDAO tdao = new TeachersDAOImpl();
		String tid = request.getParameter("tid");
		tdao.deleteTeachers(tid);
		return "delete_success";
	}
	
	public String add() throws Exception{
		Teachers t = new Teachers();
		t.setTname(request.getParameter("tname"));
		t.setGender(request.getParameter("gender"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		t.setBirth(sdf.parse(request.getParameter("birthday")));
		t.setAddress(request.getParameter("address"));
		TeachersDAO tdao = new TeachersDAOImpl();
		tdao.addTeachers(t);
		return "add_success";
	}
	
	//�޸�ѧ�����϶���
	public String modify(){
		//��ô��ݹ�����ѧ�����
		String tid = request.getParameter("tid");
		TeachersDAO tdao = new TeachersDAOImpl();
		Teachers t = tdao.queryTeachersByTid(tid);
		//�����ڻỰ��
		session.setAttribute("modify_teachers", t);
		return "modify_success";
	}
	
	//�����޸ĺ��ѧ�����϶���
	public String save() throws Exception{
		Teachers t = new Teachers();
		t.setTid(request.getParameter("tid"));
		t.setTname(request.getParameter("tname"));
		t.setGender(request.getParameter("gender"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		t.setBirth(sdf.parse(request.getParameter("birthday")));
		t.setAddress(request.getParameter("address"));
		TeachersDAO tdao = new TeachersDAOImpl();
		tdao.updateTeachers(t);
		return "save_success";
	}
}
