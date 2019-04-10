*** Settings ***
Documentation                    This is test for registration
Library                          Selenium2Library

*** Variables ***
${Browser}                      firefox
${URL}                          https://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html

*** Test Cases ***
User registration
    [Documentation]                 Should be "Successfully submitted!"
    open browser                    ${URL}   ${Browser}
    maximize browser window
    clear element text              id=first-name
    input text                      id=first-name       Stanisław
    clear element text              id=last-name
    input text                      id=last-name        Światłowski
    click element                   xpath=//label[2]
    clear element text              id=dob
    input text                      id=dob              07/27/1984
    clear element text              id=address
    input text                      id=address          Mazowiecka 14/8
    clear element text              id=email
    input password                  id=email            swiatlowski.s@gmail.com
    clear element text              id=password
    input text                      id=password         swiat!2@
    clear element text              id=company
    input text                      id=company          Network System
    Select From List By Label       id=role             QA
    Select From List By Label       id=expectation      Excellent colleagues
    Select from list By Label       id=expectation      Good teamwork
    click element                   xpath=/html/body/div/div/form/div[11]/div/div[1]/label/input
    click element                   xpath=/html/body/div/div/form/div[11]/div/div[4]/label
    input text                      id=comment          Cool !!!!
    click element                   id=submit
    Element Should Contain          id=submit-msg       Successfully submitted!
    close browser

Empty "First name"
    [Documentation]                 Should be "This field is required."
    open browser                    ${URL}   ${Browser}
    maximize browser window
    clear element text              id=first-name
    click element                   id=submit
    element should be visible       id=first-name-error

Empty "Last name"
    [Documentation]                 Should be "This field is required."
    clear element text              id=last-name
    click element                   id=submit
    element should be visible       id=last-name-error

Empty "Gender"
    [Documentation]                 Should be "This field is required."
    click element                   id=submit
    element should be visible       id=gender-error

Empty "Date of birth"
    [Documentation]                 Should be "This field is required."
    clear element text              id=dob
    click element                   id=submit
    element should be visible       id=dob-error

Empty fields for "Address"
    [Documentation]                 Should be "This field is required."
    clear element text              id=address
    click element                   id=submit
    element should be visible       id=address-error

Empty "Email"
    [Documentation]                 Should be "This field is required."
    clear element text              id=email
    click element                   id=submit
    element should be visible       id=email-error

Empty "Password"
    [Documentation]                 Should be "This field is required."
    clear element text              id=password
    click element                   id=submit
    element should be visible       id=password-error

Empty "Company"
    [Documentation]                 Should be "This field is required."
    clear element text              id=company
    click element                   id=submit
    element should be visible       id=company-error
    close browser

