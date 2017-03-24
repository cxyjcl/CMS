package com.test.service;

import java.util.List;

import org.junit.Test;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringBean;

import com.dcs.constants.DataStatusEnum;
import com.dcs.pojo.User;
import com.dcs.service.UserService;
import com.test.BaseTestStarter;
import com.test.component.XlsDataSetBeanFactory;

public class ServiceTest extends BaseTestStarter {
	@SpringBean(value = "userService")
	private UserService userService;
	
	@Test
//	@DataSet("dataSetXls/BookReservationService/insertNewBookReservation.xls")
//	@ExpectedDataSet("dataSetXls/BookReservationService/insertNewBookReservation.expect.xls")
	public void addLabel(){
		try {
			List<User> users = XlsDataSetBeanFactory.createBeans(
					"/wtlib.testdatasource.xls", "t_user",
					User.class);
			for(User bbli : users){
				int id = userService.update(bbli);
				System.out.println(id);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}