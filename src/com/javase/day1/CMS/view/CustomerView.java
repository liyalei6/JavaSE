package com.javase.day1.CMS.view;/**
 * @author liyalei
 * @description TODO
 * @date 2022-03-29 4:06 下午
 */

import com.javase.day1.CMS.bean.Customer;
import com.javase.day1.CMS.utils.CMSUtils;

/**
 @ClassName CustomerView
 @Description TODO
 @Author liyalei
 @Date 2022/3/29  4:06 下午
 @Version 1.0
 **/
public class CustomerView {
    private CustomerList customers = new CustomerList(10);

    // 初始建立一个用户
    public CustomerView() {
        Customer cust = new Customer("张三", '男', 30, "1151511215", "abs@163.com");
        customers.addCustomer(cust);
    }

    /**
     *
     * @Description 软件主界面，显示功能
     * @author Bruce void
     */
    public void enterMainMenu() {
        boolean loopFlag = true;
        do {
            System.out.println("\n-----------------客户信息管理软件-----------------\n");
            System.out.println("                   1 添 加 客 户");
            System.out.println("                   2 修 改 客 户");
            System.out.println("                   3 删 除 客 户");
            System.out.println("                   4 客 户 列 表");
            System.out.println("                   5 退       出\n");
            System.out.print("                   请选择(1-5)：");

            char key = CMSUtils.readMenuSelection();
            System.out.println();

            switch (key) {
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomer();
                    break;
                case '5':
                    System.out.println("是否退出(Y/N):");
                    char yn = CMSUtils.readConfirmSelection();
                    if (yn == 'Y') {
                        loopFlag = false;
                    }
                    break;

                default:
                    break;
            }

        } while (loopFlag);
    }

    /**
     *
     * @Description 显示添加用户界面
     * @author Bruce void
     */
    private void addNewCustomer() {
        System.out.println("---------------------添加客户---------------------");
        System.out.print("姓名：");
        String name = CMSUtils.readString(4);
        System.out.println("性别");
        char gender = CMSUtils.readChar();
        System.out.println("年龄");
        int age = CMSUtils.readInt();
        System.out.println("电话");
        String phone = CMSUtils.readString(15);
        System.out.println("邮箱");
        String email = CMSUtils.readString(15);

        Customer cust = new Customer(name, gender, age, phone, email);
        boolean flag = customers.addCustomer(cust);
        if (flag) {
            System.out.println("---------------------添加完成---------------------");
        } else {
            System.out.println("----------------记录已满,无法添加-----------------");
        }

    }

    /**
     *
     * @Description 显示修改用户信息界面
     * @author Bruce void
     */
    private void modifyCustomer() {
        System.out.println("---------------------修改客户---------------------");
        int index = 0;
        Customer cust = null;
        for (;;) {
            System.out.print("请选择待修改客户编号(-1退出)：");
            index = CMSUtils.readInt();
            if (index == -1) {
                return;
            }

            cust = customers.getCustomer(index - 1);
            if (cust == null) {
                System.out.println("无法找到该用户");
            } else
                break;
        }

        System.out.println("姓名(" + cust.getName() + "):");
        String name = CMSUtils.readString(4, cust.getName());

        System.out.println("性别(" + cust.getGender() + "):");
        char gender = CMSUtils.readChar(cust.getGender());

        System.out.println("年龄(" + cust.getAge() + "):");
        int age = CMSUtils.readInt(cust.getAge());

        System.out.println("电话(" + cust.getPhone() + "):");
        String phone = CMSUtils.readString(15, cust.getPhone());

        System.out.println("邮箱(" + cust.getEmail() + "):");
        String email = CMSUtils.readString(15, cust.getEmail());

        cust = new Customer(name, gender, age, phone, email);

        boolean flag = customers.replaceCustomer(index - 1, cust);
        if (flag) {
            System.out.println("---------------------修改完成---------------------");
        } else {
            System.out.println("----------无法找到指定客户,修改失败--------------");
        }

    }

    /**
     *
     * @Description 删除用户界面
     * @author Bruce void
     */
    private void deleteCustomer() {
        System.out.println("---------------------删除客户---------------------");
        int index = 0;
        Customer cust = null;
        for (;;) {
            System.out.println("选择待删除客户的编号(-1退出)");
            index = CMSUtils.readInt();
            if (index == -1) {
                return;
            }

            cust = customers.getCustomer(index - 1);
            if (cust == null) {
                System.out.println("无法找到指定客户");
            } else
                break;

        }
        // 跳出循环是否删除
        System.out.println("是否删除客户(Y/N)");
        char yn = CMSUtils.readChar();
        if (yn == 'N')
            return;

        boolean flag = customers.deleteCustomer(index - 1);
        if (flag) {
            System.out.println("---------------------删除完成---------------------");
        } else {
            System.out.println("----------无法找到指定客户,删除失败--------------");
        }
    }

    /**
     *
     * @Description 列出客户列表
     * @author Bruce void
     */
    private void listAllCustomer() {
        System.out.println("---------------------------客户列表---------------------------");
        Customer[] custs = customers.getAllCustomers();
        if (custs.length == 0) {
            System.out.println("没有客户编号！");

        } else {
            System.out.println("编号\t姓名\t性别\t年龄\t\t电话\t\t邮箱");
            for (int i = 0; i < custs.length; i++) {
                System.out.println((i + 1) + "\t" + custs[i].toString());
            }
        }

        System.out.println("-------------------------客户列表完成-------------------------");

    }
}
