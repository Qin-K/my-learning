package qinkai.crm.service.impl;

import qinkai.crm.dao.CustomerDao;
import qinkai.crm.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
}
