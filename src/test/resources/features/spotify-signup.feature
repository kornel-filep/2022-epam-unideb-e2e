Feature: Spotify sign up page

  Background:
    Given the home page is opened
      And the Cookie disclaimer is closed
      And the Regisztráció header button is clicked

  Scenario: Check required fields
    Given it is scrolled down
    When the Regisztráció button is clicked
    Then the 'You need to enter your email.' error message of the 'Enter your email.' field should be shown
      And the 'You need to confirm your email.' error message of the 'Enter your email again.' field should be shown
      And the 'You need to enter a password.' error message of the 'Create password.' field should be shown
      And the 'Enter a name for your profile.' error message of the 'Enter a profile name.' field should be shown
      And the 'Select your birth month.' error message of the 'Month' field should be shown
      And the 'Enter a valid day of the month.' error message of the 'DD' dropdown should be shown
      And the 'Enter a valid year.' error message of the 'YYYY' dropdown should be shown
      And the 'Select your gender.' error message of the 'Male, Female, Non-binary' radio buttons should be shown
      And the 'Please accept the terms and conditions to continue.' error message of the 'privacy policy' checkbox should be shown
      And the 'Confirm you're not a robot.' error message of the 'captcha' field should be shown

#  Scenario Outline: Check the fields with invalid parameters
#    When the '<field>' is filled in with '<parameter>'
#      And the Tab button is pressed
#    Then the '<errorMessage>' error message of the '<field>' field should be shown
#
#    Examples:
#      | field                    | parameter | errorMessage                                                           |
#      | Add meg az e-mail címed. | asd       | Érvénytelen e-mail-cím. Érvényes e-mail-cím formátuma: pelda@email.com |
#      | Add meg az e-mail címed. | 123       | Érvénytelen e-mail-cím. Érvényes e-mail-cím formátuma: pelda@email.com |
#      | Adj meg egy jelszót.     | aaa       | A jelszavad túl rövid.                                                 |
#
#  Scenario: Check email field with valid, but already existing email
#    When the 'Add meg az e-mail címed.' is filled in with 'spotifytest@asd.com'
#      And the Tab button is pressed
#    Then the 'Ezt az e-mail-címet már egy másik fiók használja. ' error message of the 'Add meg az e-mail címed.' field should be shown
#
#  Scenario: Fill email fields with valid but not equal values
#    When the 'Add meg az e-mail címed.' is filled in with 'teszt_elek@epam.com'
#      And the 'Írd be újra az e-mail-címed.' is filled in with 'teszt_anna@epam.com'
#      And the Tab button is pressed
#    Then the 'A két e-mail-cím nem egyezik.' error message of the 'Írd be újra az e-mail-címed.' field should be shown
