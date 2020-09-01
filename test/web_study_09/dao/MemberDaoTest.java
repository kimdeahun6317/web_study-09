package web_study_09.dao;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import web_study_09.dao.impl.MemberDaoImpl;
import web_study_09.dto.Member;

public class MemberDaoTest {

	//@Test
	public void testSleectMemberByAll() {
		System.out.println("testSleectMemberByAll()");
		List<Member> list = MemberDaoImpl.getInstance().selectMemberByAll();
		Assert.assertNotNull(list);
		System.out.println(list);
	}

	//@Test
	public void testSelectMemberByUserId() {
		System.out.println("testSelectMemberByUserId()");
		Member selectMember = MemberDaoImpl.getInstance().selectMemberByUserId(new Member("somi"));
		Assert.assertNotNull(selectMember);
		System.out.println(selectMember);
	}

	//@Test
	public void testInsertMember() {
		System.out.println("testInsertMember()");
		Date day = new Date(2002, 12, 1);
		int res = MemberDaoImpl.getInstance().insertMember(new Member("이승은", "adfg", "1234", "asdf@naver.com", "010-1111-1111", 1, day));
		Assert.assertEquals(1, res);
		System.out.println(res);
	}

	//@Test
	public void testUpdateMember() {
		System.out.println("test2UpdateMember()");
		Member beforeUpdateMember = MemberDaoImpl.getInstance().selectMemberByUserId(new Member("xxaa"));
		System.out.println(beforeUpdateMember);
		beforeUpdateMember.setName("홍길동");
		beforeUpdateMember.setPhone("000-1111-2222");
		Date day = new Date(2002, 12, 1);
		beforeUpdateMember.setJoinDate(day);
		int res = MemberDaoImpl.getInstance().updateMember(beforeUpdateMember);
		Member afterUpdateMember = MemberDaoImpl.getInstance().selectMemberByUserId(new Member("xxaa"));
		System.out.println(afterUpdateMember);
		Assert.assertEquals(1, res);
	}

	//@Test
	public void testDeleteMember() {
		System.out.println("test3DeleteMember()");
		Member beforedeleteMember = MemberDaoImpl.getInstance().selectMemberByUserId(new Member("xxaa"));
		System.out.println(beforedeleteMember);
		int res = MemberDaoImpl.getInstance().deleteMember(beforedeleteMember);
		Member afterdeleteMember = MemberDaoImpl.getInstance().selectMemberByUserId(new Member("xxaa"));
		System.out.println(afterdeleteMember);
		Assert.assertEquals(1, res);
	}

}
