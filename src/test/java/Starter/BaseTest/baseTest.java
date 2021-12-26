package Starter.BaseTest;

import Starter.Booking.bookingSteps;
import Starter.Checkout.checkoutSteps;
import Starter.Login.loginSteps;
import Starter.Product.createProductSteps;
import Starter.Product.deleteProductSteps;
import Starter.Product.getProductSteps;
import Starter.Register.registerSteps;
import Starter.Users.users;

public class baseTest {
    public registerSteps regSteps = new registerSteps();
    public loginSteps logSteps = new loginSteps();
    public getProductSteps getProdSteps = new getProductSteps();
    public users Users = new users();
    public createProductSteps createProductSteps = new createProductSteps();
    public deleteProductSteps deleteProductSteps = new deleteProductSteps();
    public bookingSteps bookingSteps = new bookingSteps();
    public checkoutSteps checkoutSteps = new checkoutSteps();
}
