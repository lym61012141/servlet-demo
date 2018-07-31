import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.smart4j.customer.helper.DataBaseHelper;
import org.smart4j.customer.model.Customer;
import org.smart4j.customer.service.CustomerService;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Yuming-Liu
 * 日期： 2018-07-30
 * 时间： 22:52
 */
public class CustomerServiceTest {

    private final CustomerService customerService = CustomerService.getCustomerService();

    @Before
    public void init() throws IOException{
        String filePath = "sql/customer_init.sql";
        DataBaseHelper.executeSqlFile(filePath);
    }

    @Test
    public void getCustomerListTest() throws Exception {
        List<Customer> customerList = customerService.getCustomerList();
        System.out.println();
        Assert.assertEquals(2,customerList.size());
    }

    @Test
    public void getCustomerTest() throws Exception {
        long id = 1;
        Customer customer = customerService.getCustomer(id);
        Assert.assertNotNull(customer);
    }

    @Test
    public void createCustomerTest() throws Exception {
        Map<String, Object> fieldMap = new HashMap<String, Object>();
        fieldMap.put("name", "customer100");
        fieldMap.put("contact", "john");
        fieldMap.put("telephone", "13245697845");
        fieldMap.put("email", "john@163.com");
        boolean result = customerService.createCustomer(fieldMap);
        Assert.assertTrue(result);
    }
}
