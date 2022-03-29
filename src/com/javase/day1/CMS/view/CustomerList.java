package com.javase.day1.CMS.view;/**
 * @author liyalei
 * @description TODO
 * @date 2022-03-29 4:06 下午
 */

import com.javase.day1.CMS.bean.Customer;

/**
 @ClassName CustomerList
 @Description TODO
 @Author liyalei
 @Date 2022/3/29  4:06 下午
 @Version 1.0
 **/
public class CustomerList {
    private Customer[] customers;
    private int total = 0;

    public CustomerList(int totalCustomer) {
        customers = new Customer[totalCustomer];
    }

    public boolean addCustomer(Customer customer){
        if(total >= customers.length){
            return false;
        }
        customers[total++] = customer;
        return true;
    }

    public boolean replaceCustomer(int index, Customer customer){
        if(index < 0 || index >= total){
            return false;
        }
        customers[index] = customer;
        return true;
    }

    public boolean deleteCustomer(int index){
        if(index < 0 || index >= total){
            return false;
        }
        //customers[index] = null;
        for(int i = index; i < total-1; i++){
            customers[i] = customers[i+1];
        }
        customers[total] = null;
        return true;
    }

    public Customer[] getAllCustomers(){
        Customer[] res = new Customer[total];
        for(int i = 0; i < total; i++){
            res[i] = customers[i];
        }
        return res;
    }

    public Customer getCustomer(int index){
        if(index < 0 || index >= total){
            return null;
        }
        return customers[index];
    }

    public int getTotal() {
        return total;
    }
}
