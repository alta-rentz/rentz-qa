package Starter.BaseTest;

import Starter.Login.loginSteps;
import Starter.Product.createProductSteps;
import Starter.Product.getProductSteps;
import Starter.Register.registerSteps;
import Starter.Users.users;

public class baseTest {
    public registerSteps regSteps = new registerSteps();
    public loginSteps logSteps = new loginSteps();
    public getProductSteps getProdSteps = new getProductSteps();
    public users Users = new users();
    public createProductSteps createProductSteps = new createProductSteps();
}
