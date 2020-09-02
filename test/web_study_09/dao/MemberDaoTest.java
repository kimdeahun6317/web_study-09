package web_study_09.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import web_study_09.dto.Member;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MemberDaoTest {

	@Test
	public void test04SelectMemberByAll() {
		System.out.println("testSelectMemberByAll()");
		List<Member> mList = MemberDaoImpl.getInstance().selectMemberByAll();
		Assert.assertNotNull(mList);
		mList.stream().forEach(System.out::println);
	}

	@Test
	public void test05SelectMemberByUserId() {
		System.out.println("testSelectMemberByUserId()");
		Member mem = MemberDaoImpl.getInstance().selectMemberByUserId(new Member("somi"));
		Assert.assertNotNull(mem);
		System.out.println(mem);
	}

	@Test
	public void test01InsertMember() {
		System.out.println("testInsertMember()");
		int res = MemberDaoImpl.getInstance()
				.insertMember(new Member("박규영", "parkgy", "1234", "pgy@gmail.com", "010-1111-2222", 0));
		Assert.assertEquals(1, res);
	}

	@Test
	public void test02UpdateMember() {
		System.out.println("testUpdateMember()");
		
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(2020, 7, 20);
		
		int res = MemberDaoImpl.getInstance()
				.updateMember(new Member("문채원", "parkgy", "5678", "mcw@gmail.com", "010-3333-4444", 1, cal.getTime()));
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void test03DeleteMember() {
		System.out.println("testDeleteMember()");
		int res = MemberDaoImpl.getInstance().deleteMember(new Member("parkgy"));
		Assert.assertEquals(1, res);
	}

}
