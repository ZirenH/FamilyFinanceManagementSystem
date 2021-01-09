package com.zirong.unit;

import static org.junit.Assert.*;
import com.zirong.DAO.*;
import org.junit.Test;

import com.zirong.DAO.ExpenditureShow;

public class UnitTest {

	@Test
	public void test() {
		new IncomeShow().showIncome("1");
	}
	
	@Test
	public void test2() {
		new ExpenditureShow().showExpenditure("1");
	}
	@Test
	public void test3() {
		new OtherIncomeShow().showIncome("1");
	}

}
