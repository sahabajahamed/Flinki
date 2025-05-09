package com.flinki;

import java.awt.AWTException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.flinki.Base.base;
import com.flinki.Pages.ProfileCreation;
import com.flinki.Pages.ProfilePage;
import com.flinki.Pages.SignUp;
@Listeners(TestListener.class)
public class ProfileTest extends base {
    
     private SignUp signup;
    private ProfileCreation profilecreation;
    private ProfilePage profilePage;
    
    

    @BeforeMethod
public void testSetup()
{
    signup = new SignUp(driver);
    profilecreation = new ProfileCreation(driver);
    profilePage = new ProfilePage(driver);

}


@Test(priority = 1,groups="Functional")
    public void VerifyUserCanEditName() throws InterruptedException
    {
        signup.SignIn().clickProfile().clickEditButton();
        Thread.sleep(3000);
        profilePage.editPersonalNameInformation();

    }
    
    @Test(priority = 2,groups="Functional")
    public void VerifyUserCanEditSports() throws InterruptedException
    {
        signup.SignIn().clickProfile();
        try {
            profilePage.editPersonalSportsInformation();
        } catch (AWTException | InterruptedException e) { 
        }

    }

    @Test(priority = 3,groups="Functional")
    public void VerifyUsercanEditContactDetails() throws InterruptedException
    {
        signup.SignIn().clickProfile();
        profilePage.EditContactDetails();

    }

    @Test(priority=4,groups="Functional")
    public void VerifyUploadCoverPhoto() throws InterruptedException
    
    {
        signup.SignIn().clickProfile();
        profilePage.coverImageUpload();
        Thread.sleep(3000);
     

    
    }

    @Test(priority = 5,groups="Functional")
    public void VerifyUploadProfilePhoto() throws InterruptedException
    {
        signup.SignIn().clickProfile();
        profilePage.profileImageUpload();
        Thread.sleep(3000);

    }

    @Test(priority=6,groups="Functional")
    public void verifyUserCanAddSports() throws InterruptedException, AWTException
    {

        signup.SignIn().clickProfile();
        Thread.sleep(3000);
        profilePage.addNewSports();
    }



    
    @Test(dependsOnMethods="verifyUserCanAddSports")
    public void verifyUserCanDeleteSports() throws InterruptedException
    {

        signup.SignIn().clickProfile();
        Thread.sleep(3000);
        profilePage.deleteSportsQulifications();
    }

    


    
    
    
}
