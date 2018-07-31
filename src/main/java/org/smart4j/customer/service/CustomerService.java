package org.smart4j.customer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.customer.helper.DataBaseHelper;
import org.smart4j.customer.model.Customer;

import java.util.List;
import java.util.Map;

/**
 * Created by Yuming-Liu
 * 日期： 2018-07-30
 * 时间： 22:48
 */
public class CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(Customer.class);

    private static CustomerService customerService;

    private CustomerService() {

    }

    public static CustomerService getCustomerService() {
        if (customerService == null) {
            customerService = new CustomerService();
        }
        return customerService;
    }

    public List<Customer> getCustomerList() {
        /*Connection conn = null;
        List<Customer> customerList= new ArrayList<Customer>();
        try {
            String sql = "select * from customer";
            conn = DataBaseHelper.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setId(resultSet.getLong("id"));
                customer.setName(resultSet.getString("name"));
                customer.setContact(resultSet.getString("name"));
                customer.setTelephone(resultSet.getString("telephone"));
                customer.setEmail(resultSet.getString("email"));
                customer.setRemark(resultSet.getString("remark"));
                customerList.add(customer);
            }
        } catch (SQLException e) {
            LOGGER.error("execute sql failture", e);
        }finally {
            DataBaseHelper.closeConnection();
        }
        return customerList;*/
        String sql = "select * from customer";
        return DataBaseHelper.queryEntityList(Customer.class, sql);
    }

    public List<Customer> getCustomerList(String keyword) {
        return null;
    }

    public Customer getCustomer(Long id) {
        String sql = "select * from customer where id=" + id;
        return DataBaseHelper.queryEntity(Customer.class, sql);
    }

    public boolean createCustomer(Map<String, Object> fieldMap) {
        return DataBaseHelper.insertEntity(Customer.class, fieldMap);
    }

    public boolean updateCustomer(Long id, Map<String, Object> fieldMap) {
        return DataBaseHelper.updateEntity(Customer.class, id, fieldMap);
    }

    public boolean deleteCustomer(Long id) {
        return DataBaseHelper.deleteEntity(Customer.class, id);
    }
}
