Feature: Security framework test

  Scenario: Password Reset for a lab admin
    When Launch application using link: "http://bmtechsol.com:8080/easytox/"
    Then Easytox Login screen should be displayed.

    When Click "Click here" link on Forgot Password.
    Then Forgot Password screen should be displayed.

    When Enter Username as "SNLabAdmin", valid email address and click "Send my Password" button.
    Then "Forgot Password Request Submitted" message should be displayed on the page.

    When Login to Easytox with "superadmin" and "admin" credentials.
    Then User login should be successful.

    When Click "Pending Password Requests" link.
    Then Following should be displayed:1 Password Requests
    And Forgot Password   "SNLabAdmin" <link>
    And See All Requests <Link>

    When Select Forgot Password   "SNLabAdmin".
    Then Reset Password screen with following fields should be displayed: Request by: SNLabAdmin
    And Request Email: <entered valid email ID>
    And New Password <Input Box>

    When Enter a new password "Welcome@123" in the "New Password" field and click Save.
    Then "SNLabAdmin password reset successfully" message should be displayed.

    When Login to the Easytox with login "SNLabAdmin" and password "Welcome@123" credentials.
    Then "Change Password" screen with following fields should be displayed: Username
    And Old Password
    And New Password
    And Confirm Password

    When Verify username "SNLabAdmin" populated in "Username" field.
    Then "SPhyTwo" should be autopopulated in "username" field and it should NOT be editable.

    When Enter "Welcome@123" in the Old Password field.
    Then User old password should be successful.

    When Enter "Test@1234" in the New Password field.
    Then User new password should be successful.

    When Enter "Test@1234" in the Confirm Password field.
    Then User entry should be successful.

    When Click save.
    Then Login screen with message "Password changed successfully, you can now login" should be displayed.

    When Enter "SNLabAdmin" and "Test@1234" as user credentials and login.
    Then User login should be successful with reset password.