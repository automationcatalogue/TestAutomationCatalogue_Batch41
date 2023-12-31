package utilities;

public class Config {

    public static final String browserName = "Chrome";
    public static final String demoWebshop_URL = "https://demowebshop.tricentis.com/";
    public static final String orangeHRM_URL = " https://automationdata-trials710.orangehrmlive.com";

    public static final String LoginTestCase_ID = "TC01-01";
    public static final String AddEmployeeTestCase_ID = "TC02-04";
    public static final String AddUserTestCase_ID = "TC03-03";
    public static final String EditEmployeeTestCase_ID = "TC04-02";
    public static final String GoalsRequestTestCase_ID = "TC05-01";
    public static final String CreateAddressRequestTestCase_ID = "TC06-02";
    public static final String ReOrderRequestTestCase_ID = "TC07-01";
    public static final String TotalOrdersRequestTestCase_ID = "TC08-01";
    public static final String UpdateShoppingCartRequestTestCase_ID = "TC09-02";
    public static final String ApplyDiscountRequestTestCase_ID = "TC10-02";

    //Common TestCases Column numbers
    public static final int col_Sno = 0;
    public static final int col_TestId = 1;
    public static final int col_TestName = 2;
    public static final int col_TestDescription = 3;
    public static final int col_UserName = 4;
    public static final int col_Password = 5;
    public static final int col_RunMode = 4;
    public static final int col_Status = 5;
    public static final int col_reason = 6;

    //Add Employee testcase Column numbers
    public static final int col_AddEmployee_FirstName = 6;
    public static final int col_AddEmployee_LastName = 7;
    public static final int col_AddEmployee_Location = 8;
    public static final int col_AddEmployee_MaritalStatus = 9;
    public static final int col_AddEmployee_Gender = 10;
    public static final int col_AddEmployee_Region = 11;
    public static final int col_AddEmployee_FTE = 12;
    public static final int col_AddEmployee_TempDepartment = 13;
    public static final int col_AddEmployee_EmployeeId = 14;

    //Add User testcase Column numbers
    public static final int col_AddUser_EmployeeName = 6;
    public static final int col_AddUser_NewUser = 7;
    public static final int col_AddUser_Password = 8;
    public static final int col_AddUser_ConfirmPassword = 9;

    //Edit Employee testcase Column numbers
    public static final int col_EditEmployee_EmpName = 6;
    public static final int col_EditEmployee_DOB = 7;
    public static final int col_EditEmployee_Nationality = 8;
    public static final int col_EditEmployee_Allergies = 9;
    public static final int col_EditEmployee_DietaryRequirement_1 = 10;
    public static final int col_EditEmployee_DietaryRequirement_2 = 11;
    public static final int col_EditEmployee_MobileNumber = 12;

    //DemoWebshop Create address testcases column numbers
    public static final int col_createAddress_FirstName = 6;
    public static final int col_createAddress_LastName = 7;
    public static final int col_createAddress_Email = 8;
    public static final int col_createAddress_Company = 9;
    public static final int col_createAddress_Country = 10;
    public static final int col_createAddress_State = 11;
    public static final int col_createAddress_City = 12;
    public static final int col_createAddress_Address1 = 13;
    public static final int col_createAddress_Address2 = 14;
    public static final int col_createAddress_ZipCode = 15;
    public static final int col_createAddress_PhoneNumber = 16;
    public static final int col_createAddress_FaxNumber = 17;

    //DemoWebshop Reorder testcases column numbers
    public static final int col_Reorder_OrderNumber = 6;

    //DemoWebshop TotalOrders testcases
    public static final int col_TotalOrders_NumberOfOrders = 6;
    public static final int col_TotalOrders_SumOfAllOrders = 7;

    //DemoWebshop Update Shopping order testcases column numbers
    public static final int col_UpdateCart_Length = 6;
    public static final int col_UpdateCart_Quantity = 7;
    public static final int col_UpdateCart_OrderNumber = 8;

    //DemoWebshop Apply Discount testcases column numbers
    public static final int col_ApplyDiscount_Coupon = 6;
    public static final int col_ApplyDiscount_OrderNumber = 7;

    //OrangeHRM Goals testcases column numbers
    public static final int col_OrangeHRMGoals_empName = 6;
    public static final int col_OrangeHRMGoals_firstGoalPriority = 7;
    public static final int col_OrangeHRMGoals_firstGoalDate = 8;
    public static final int col_OrangeHRMGoals_firstGoalName = 9;
    public static final int col_OrangeHRMGoals_firstGoalDescription = 10;
    public static final int col_OrangeHRMGoals_secondGoalPriority = 11;
    public static final int col_OrangeHRMGoals_secondGoalDate = 12;
    public static final int col_OrangeHRMGoals_secondGoalGoalName = 13;
    public static final int col_OrangeHRMGoals_secondGoalGoalDescription = 14;
    public static final int col_OrangeHRMGoals_thirdGoalPriority = 15;
    public static final int col_OrangeHRMGoals_thirdGoalDate = 16;
    public static final int col_OrangeHRMGoals_thirdGoalName = 17;
    public static final int col_OrangeHRMGoals_thirdGoalDescription = 18;
    public static final int col_OrangeHRMGoals_approveGoalNote = 19;
    public static final int col_OrangeHRMGoals_updateFirstGoalPercentage = 20;
    public static final int col_OrangeHRMGoals_updateSecondGoalPercentage = 21;
    public static final int col_OrangeHRMGoals_firstGoalStatus = 22;
    public static final int col_OrangeHRMGoals_secondGoalStatus = 23;
    public static final int col_OrangeHRMGoals_thirdGoalStatus = 24;
}
