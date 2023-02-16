package dbServices;

import dao.CustomerDao;
import models.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CustomerService {
    Logger logger = LoggerFactory.getLogger(CustomerService.class);

    private CustomerDao customerDao = new CustomerDao();

    public CustomerService() {
    }

    public Customer findUser(int id) {
        logger.info("Начиная искать пользователя по id =" + id);
        return customerDao.findById(id);
    }

    public void saveUser(Customer customer) {
        customerDao.save(customer);
    }

    public List<Customer> findAllUsers() {
        return customerDao.finAll();
    }
}
