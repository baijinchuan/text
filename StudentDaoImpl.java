package cn.bjc.dao.impl;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import cn.bjc.dao.IStudentDao;
import cn.bjc.domain.Student;
import cn.bjc.util.MybatisUtil;

public class StudentDaoImpl implements IStudentDao{
	
	//通过ID查询
	@Override
	public Student findById(Integer id) {
		SqlSession sqlSession = null;
		
		try {
			//调用工具类,读取核心文件,获取sql对象
			sqlSession = MybatisUtil.getSqlSession();
			
			//进行查询语句
			Student student = sqlSession.selectOne("cn.bjc.dao.IStudentDao.findById", id);
			
			//返回数据
			return student;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//关流
			MybatisUtil.close(sqlSession);
			
		}
		return null;
	}
	
	//查询所有
	@Override
	public List<Student> queryAll() {
		
		SqlSession sqlSession = null;
		
		try {
			sqlSession = MybatisUtil.getSqlSession();
			
			List<Student> list = sqlSession.selectList("cn.bjc.dao.IStudentDao.queryAll");
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MybatisUtil.close(sqlSession);
			
		}
		return null;
	}
	
	//增加
	@Override
	public void add(Student student) {
		
		SqlSession sqlSession = null;
		
		try {
			sqlSession = MybatisUtil.getSqlSession();
			
			sqlSession.insert("cn.bjc.dao.IStudentDao.add", student);
			
			//增删改要有commit执行语句
			sqlSession.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MybatisUtil.close(sqlSession);
		}
		
	}
	
	//修改
	@Override
	public void update(Student student) {
		
		SqlSession sqlSession = null;

		try {
			sqlSession = MybatisUtil.getSqlSession();
			
			sqlSession.insert("cn.bjc.dao.IStudentDao.update", student);
			
			//增删改要有commit执行语句
			sqlSession.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MybatisUtil.close(sqlSession);
		}
		
	}
	
	//删除
	@Override
	public void delete(Integer id) {
		
		SqlSession sqlSession = null;
		
		try {
			sqlSession = MybatisUtil.getSqlSession();
			
			sqlSession.delete("cn.bjc.dao.IStudentDao.delete", id);
			
			//增删改要有commit执行语句
			sqlSession.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MybatisUtil.close(sqlSession);
		}
	}

}
