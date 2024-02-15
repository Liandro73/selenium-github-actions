#language:en

  @login
  Feature: Login Swag Labs

    @login  @login_successfully
    Scenario Template:  Login Swag Labs successfully
      Given that I go to the do Swag Labs login page
      When fill user and password fields <username> <password>
      And click on Login button
      Then I should be redirected to Swag Labs products page

      Examples:
        | username      | password     |
        | standard_user | secret_sauce |

    @login  @login_failed
    Scenario Template:  Login Swag Labs failed - <scenario>
      Given that I go to the do Swag Labs login page
      When fill user and password fields <username> <password>
      And click on Login button
      Then I should see the following error msg: <error_msg>

      Examples:
        | scenario        | username        |  | password     | error_msg                                           |
        | username empty  |                 |  | secret_sauce | Epic sadface: Username is required                  |
        | password empty  | standard_user   |  |              | Epic sadface: Password is required                  |
        | locked out user | locked_out_user |  | secret_sauce | Epic sadface: Sorry, this user has been locked out. |