package cn.edu.bjtu.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.BaseDao;
import cn.edu.bjtu.dao.ClientSecurityDao;
import cn.edu.bjtu.vo.Clientinfo;
import cn.edu.bjtu.vo.Userinfo;

@Repository
public class ClientSecurityDaoImpl implements ClientSecurityDao {

	@Autowired
	private HibernateTemplate ht;

	@Autowired
	private BaseDao baseDao;

	@Override
	/**
	 * ��������
	 */
	public boolean checkOldPassword(String oldPassword, String userId) {
		// TODO Auto-generated method stub
		Userinfo user = ht.get(Userinfo.class, userId);

		if (user.getPassword().equals(oldPassword))
			return true;
		return false;
	}

	@Override
	/**
	 * �޸�����
	 */
	public boolean changePassword(String newPassword, String userId) {
		// TODO Auto-generated method stub
		Userinfo user = ht.get(Userinfo.class, userId);
		user.setPassword(newPassword);
		baseDao.update(user);
		return true;
	}

	@Override
	/**
	 * ������
	 */
	public boolean bindEmail(String email, String userId) {
		// TODO Auto-generated method stub
		Userinfo user = ht.get(Userinfo.class, userId);
		user.setEmail(email);
		user.setEmailStatus("�Ѱ�");// �޸�״̬
		Clientinfo clientinfo = ht.get(Clientinfo.class, userId);
		clientinfo.setEmail(email);

		baseDao.update(user);
		baseDao.update(clientinfo);
		return true;
	}

	@Override
	/**
	 * �����û���Ϣ
	 */
	public Userinfo getUserById(String userId) {
		// TODO Auto-generated method stub
		return ht.get(Userinfo.class, userId);
	}

	@Override
	/**
	 * �޸İ�����
	 */
	public boolean changeBindEmail(String newEmail, String userId) {
		// TODO Auto-generated method stub
		Userinfo userinfo = ht.get(Userinfo.class, userId);

		userinfo.setEmail(newEmail);

		Clientinfo clientinfo = ht.get(Clientinfo.class, userId);

		clientinfo.setEmail(newEmail);

		baseDao.update(userinfo);
		baseDao.update(clientinfo);
		return true;

	}

	@Override
	public boolean setSecurityQuestion(String q1, String q2, String q3,
			String a1, String a2, String a3, String uId) {
		// TODO Auto-generated method stub
		Userinfo userinfo = ht.get(Userinfo.class, uId);

		userinfo.setSecurityAnswerOne(a1.trim());
		userinfo.setSecurityAnswerTwo(a2.trim());
		userinfo.setSecurityAnswerThree(a3.trim());
		userinfo.setSecurityQuestionOne(q1.trim());
		userinfo.setSecurityQuestionTwo(q2.trim());
		userinfo.setSecurityQuestionThree(q3.trim());

		userinfo.setSecurityQuestionStatus("������");

		baseDao.update(userinfo);
		return true;
	}

	@Override
	/**
	 * ����ܱ������
	 * @param a1
	 * @param a2
	 * @param a3
	 * @param userId
	 * @return
	 */
	public boolean checkAnswer(String a1, String a2, String a3, String userId) {
		// TODO Auto-generated method stub
		Userinfo userinfo = ht.get(Userinfo.class, userId);

		if (a1.trim().endsWith(userinfo.getSecurityAnswerOne())
				&& a2.trim().equals(userinfo.getSecurityAnswerTwo())
				&& a3.trim().equals(userinfo.getSecurityAnswerThree()))
			return true;

		return false;

	}

}