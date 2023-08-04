package utilities;

public class Config {
    public static final String TestCase_ID = "TC03-01";

    //Common TestCases Column numbers
    public static final int col_Sno=0;
    public static final int col_TestId=1;
    public static final int col_TestName=2;
    public static final int col_TestDescription=3;
    public static final int col_UserName=4;
    public static final int col_Password=5;
    public static final int col_Status=4;
    public static final int col_reason=5;

    //Add Employee testcase Column numbers
    public static final int col_AddEmployee_FirstName=6;
    public static final int col_AddEmployee_LastName=7;
    public static final int col_AddEmployee_Location=8;
    public static final int col_AddEmployee_MaritalStatus=9;
    public static final int col_AddEmployee_Gender=10;
    public static final int col_AddEmployee_Region=11;
    public static final int col_AddEmployee_FTE=12;
    public static final int col_AddEmployee_TempDepartment=13;
    public static final int col_AddEmployee_EmployeeId=14;

    //Add User testcase Column numbers
    public static final int col_AddUser_EmployeeName=6;
    public static final int col_AddUser_NewUser=7;
    public static final int col_AddUser_Password=8;
    public static final int col_AddUser_ConfirmPassword=9;

    //Edit Employee testcase Column numbers
    public static final int col_EditEmployee_LastName=6;
    public static final int col_EditEmployee_DOB=7;
    public static final int col_EditEmployee_Nationality=8;
    public static final int col_EditEmployee_Allergies=9;
    public static final int col_EditEmployee_DietaryRequirement_1=10;
    public static final int col_EditEmployee_DietaryRequirement_2=11;

    //DemoWebshop Create address testcases column numbers
    public static final int col_createAddress_FirstName=6;
    public static final int col_createAddress_LastName=7;
    public static final int col_createAddress_Email=8;
    public static final int col_createAddress_Company=9;
    public static final int col_createAddress_City=10;
    public static final int col_createAddress_Address1=11;
    public static final int col_createAddress_Address2=12;
    public static final int col_createAddress_ZipCode=13;
    public static final int col_createAddress_PhoneNumber=14;
    public static final int col_createAddress_FaxNumber=15;

    //DemoWebshop Reorder testcases column numbers
    public static final int col_Reorder_OrderNumber=6;

    //DemoWebshop TotalOrders testcases
    public static final int col_TotalOrders_NumberOfOrders=7;
    public static final int col_TotalOrders_SumOfAllOrders=8;

    //DemoWebshop Update Shopping order testcases column numbers
    public static final int col_UpdateCart_Length=6;
    public static final int col_UpdateCart_Quantity=7;
    public static final int col_UpdateCart_OrderNumber=8;

    //DemoWebshop Apply Discount testcases column numbers
    public static final int col_ApplyDiscount_Coupon=6;
    public static final int col_ApplyDiscount_OrderNumber=7;
}
