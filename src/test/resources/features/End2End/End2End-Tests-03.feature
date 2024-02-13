Feature: FireLight_End2End_Tests

  This feature will verify UAT Application End2End Tests

  @End2EndTest3
  Scenario: TC_01_Complete the REACT application with Pre Signature Review with Signature Then Submit
    Given User is on FireLight login page for TestCase "End2End_TC_01"
    Then User on Login Page enters valid username as "Ashwani_FBW" and password and clicks Login button
    Then User clicks "Application" Tab
    Then User verifies "Create New Application" window showing
    Then User selects Jurisdiction "Alabama"
    Then User selects Product Type Dropdown "Variable Annuity"
    Then User opens Given Product "Variable Annuity" for application
    Then User Verifies Heading "Variable Annuity"
    Then User clicks "Create" button
    Then User Verifies heading as Create Activity
    Then User enters new Application name
    Then User clicks on Create button on Rename window
    Then User verifies Page heading "Annuity Owner Module" with form name "Client Data" for data entry flow
    Then User opens "Riders" Required for Form "Rider Module"
    Then User Verifies "Guaranteed Lifetime Withdrawal Benefit" is "displayed" under "Living Benefit Rider" on page
    Then User Verifies "No Living Benefit" is "displayed" under "Living Benefit Rider" on page
    Then User "check" checkbox "Guaranteed Lifetime Withdrawal Benefit"
    Then User "uncheck" checkbox "Guaranteed Lifetime Withdrawal Benefit"
    Then User verify error message "A Living Benefit Rider selection is required." for "Guaranteed Lifetime Withdrawal Benefit" on page
    Then User "check" checkbox "No Living Benefit"
    Then User "uncheck" checkbox "No Living Benefit"
    Then User verify error message "A Living Benefit Rider selection is required." for "No Living Benefit" on page
    Then User Verifies "Guarantee of Principal" is "displayed" under "Death Benefit Rider" on page
    Then User Verifies "Enhanced Guaranteed Minimum Death Benefit" is "displayed" under "Death Benefit Rider" on page
    Then User Verifies "No Guaranteed Death Benefit" is "displayed" under "Death Benefit Rider" on page
    Then User "check" checkbox "Guarantee of Principal"
    Then User "uncheck" checkbox "Guarantee of Principal"
    Then User verify error message "A Death Benefit Rider selection is required." for "Guarantee of Principal" on page
    Then User "check" checkbox "Enhanced Guaranteed Minimum Death Benefit"
    Then User "uncheck" checkbox "Enhanced Guaranteed Minimum Death Benefit"
    Then User verify error message "A Death Benefit Rider selection is required." for "Enhanced Guaranteed Minimum Death Benefit" on page
    Then User "check" checkbox "No Guaranteed Death Benefit"
    Then User "uncheck" checkbox "No Guaranteed Death Benefit"
    Then User verify error message "A Death Benefit Rider selection is required." for "No Guaranteed Death Benefit" on page
    Then User "check" checkbox "No Living Benefit"
    Then User "check" checkbox "Guaranteed Lifetime Withdrawal Benefit"
    Then User Verifies checkbox "No Living Benefit" is "unchecked"
    Then User "check" checkbox "No Living Benefit"
    Then User Verifies checkbox "Guaranteed Lifetime Withdrawal Benefit" is "unchecked"
    Then User "check" checkbox "Enhanced Guaranteed Minimum Death Benefit"
    Then User "check" checkbox "Guarantee of Principal"
    Then User Verifies checkbox "Enhanced Guaranteed Minimum Death Benefit" is "unchecked"
    Then User "check" checkbox "Enhanced Guaranteed Minimum Death Benefit"
    Then User Verifies checkbox "Guarantee of Principal" is "unchecked"
    Then User "check" checkbox "No Guaranteed Death Benefit"
    Then User Verifies checkbox "Enhanced Guaranteed Minimum Death Benefit" is "unchecked"
    Then User "check" checkbox "Enhanced Guaranteed Minimum Death Benefit"
    Then User Verifies checkbox "No Guaranteed Death Benefit" is "unchecked"
    Then User clicks "Previous" button
    Then User verifies Page heading "Suitability Module" with form name "Customer Profile and Objectives" for data entry flow
    Then User clicks "Next" button
    Then User verifies Page heading "Rider Module" with form name "Riders" for data entry flow
    Then User Verifies checkbox "Enhanced Guaranteed Minimum Death Benefit" is "checked"
    Then User Verifies checkbox "No Living Benefit" is "checked"
    Then User clicks "Next" button
    Then User verifies Page heading "Premium Module" with form name "Premium" for data entry flow
    Then User "check" checkbox "New Money – Checking/Savings (ACH)"
    Then User "uncheck" checkbox "New Money – Checking/Savings (ACH)"
    Then User verify error message "At least one payment method is required." for "New Money – Checking/Savings (ACH)" on page
    Then User "check" checkbox "New Money – Checking/Savings (ACH)"
    Then User Verifies "Cash Amount" is "displayed" under "Purchase Payment" on page
    Then User verifies Validation Message for
      | Field       | Id         | data-dataitemid           | Locator Type | Validation Error         |
      | Cash Amount | CashAmount | SourceOfFunds_Cash_Amount | Input        | Cash Amount is required. |
    Then User verifies "TotalSinglePremiumAmount" is "readonly" field
    Then User verifies "TotalSinglePremiumAmount" TextBox has Prefilled Value "$0.00"
    Then User Enters "12452.55" in TextBox "CashAmount"
    Then User verifies "TotalSinglePremiumAmount" TextBox has Prefilled Value "$12,452.55"
    Then User verifies Validation Message for
      | Field          | Id                       | data-dataitemid | Locator Type | Validation Error                        |
      | Premium Amount | TotalSinglePremiumAmount | Premium_Amount  | Input        | Total Premium must be at least $25,000. |
    Then User Verifies "Check if Total Single Premium amount is estimated or a transfer is requested." is "displayed" under "Purchase Payment" on page
    Then User "check" checkbox "Check if Total Single Premium amount is estimated or a transfer is requested."
    Then User Enters "30145" in TextBox "CashAmount"
    Then User verifies "TotalSinglePremiumAmount" TextBox has Prefilled Value "$30,145.00"
    Then User Verifies "Do you have any existing life insurance or annuity contracts?" is "displayed" under "Existing Insurance" on page
    Then User "check" radiobutton "Yes" for "Do you have any existing life insurance or annuity contracts?"
    Then User Verifies radiobutton "No" is "unchecked" for "Do you have any existing life insurance or annuity contracts?"
    Then User "check" radiobutton "No" for "Do you have any existing life insurance or annuity contracts?"
    Then User Verifies radiobutton "Yes" is "unchecked" for "Do you have any existing life insurance or annuity contracts?"
    Then User "uncheck" radiobutton "No" for "Do you have any existing life insurance or annuity contracts?"
    Then User verify error message "Either Yes or No is required." for "No" on page
    Then User "check" radiobutton "Yes" for "Do you have any existing life insurance or annuity contracts?"
    Then User Verifies "Will this contract replace or change any of your existing life insurance policies or annuity contracts?" is "displayed" under "Existing Insurance" on page
    Then User verifies "TotalSinglePremiumAmount" is "readonly" field
    Then User Verifies radiobutton "Yes" is "readonly" for "Will this contract replace or change any of your existing life insurance policies or annuity contracts?"
    Then User Verifies radiobutton "No" is "readonly" for "Will this contract replace or change any of your existing life insurance policies or annuity contracts?"
    Then User Verifies radiobutton "No" is "checked" for "Will this contract replace or change any of your existing life insurance policies or annuity contracts?"
    Then User clicks "Previous" button
    Then User verifies Page heading "Rider Module" with form name "Riders" for data entry flow
    Then User clicks "Next" button
    Then User verifies Page heading "Premium Module" with form name "Premium" for data entry flow
    Then User Verifies checkbox "New Money – Checking/Savings (ACH)" is "checked"
    Then User Verifies checkbox "Check if Total Single Premium amount is estimated or a transfer is requested." is "checked"
    Then User verifies "TotalSinglePremiumAmount" TextBox has Prefilled Value "$30,145.00"
    Then User verifies "CashAmount" TextBox has Prefilled Value "$30,145.00"
    Then User Verifies radiobutton "No" is "checked" for "Will this contract replace or change any of your existing life insurance policies or annuity contracts?"
    Then User Verifies radiobutton "Yes" is "checked" for "Do you have any existing life insurance or annuity contracts?"
    Then User clicks "Next" button
    Then User verifies Page heading "Annuity ACH Module" with form name "ACH Payment" for data entry flow
    Then User verifies Validation Message for
      | Field                      | Id                       | data-dataitemid                         | Locator Type | Validation Error                        |
      | Financial Institution Name | FinancialInstitutionName | AccountHolder_FinancialInstitution_Name | Input        | Financial Institution Name is required. |
    Then User Enters "A2B corporation!" in TextBox "FinancialInstitutionName"
    Then User verifies Validation Message for
      | Field                     | Id                     | data-dataitemid         | Locator Type | Validation Error                       |
      | Account Holder First Name | AccountHolderFirstName | AccountHolder_FirstName | Input        | Account Holder First Name is required. |
    Then User Enters "Jemimah" in TextBox "AccountHolderFirstName"
    Then User Enters "M" in TextBox "MiddleName"
    Then User verifies Validation Message for
      | Field                    | Id       | data-dataitemid        | Locator Type | Validation Error                      |
      | Account Holder Last Name | LastName | AccountHolder_LastName | Input        | Account Holder Last Name is required. |
    Then User Enters "Rodrigues" in TextBox "LastName"
    Then User verifies Validation Message for
      | Field                         | Id                     | data-dataitemid             | Locator Type | Validation Error            |
      | Account Holder Routing Number | RoutingNumber(9digits) | AccountHolder_RoutingNumber | Input        | Routing Number is required. |
    Then User Enters "abcd" in TextBox "RoutingNumber(9digits)"
    Then User verifies Validation Message for
      | Field                         | Id                     | data-dataitemid             | Locator Type | Validation Error            |
      | Account Holder Routing Number | RoutingNumber(9digits) | AccountHolder_RoutingNumber | Input        | Routing Number is invalid. |
    Then User Enters "$#$%" in TextBox "RoutingNumber(9digits)"
    Then User verifies Validation Message for
      | Field                         | Id                     | data-dataitemid             | Locator Type | Validation Error            |
      | Account Holder Routing Number | RoutingNumber(9digits) | AccountHolder_RoutingNumber | Input        | Routing Number is invalid. |
    Then User Enters "1234" in TextBox "RoutingNumber(9digits)"
    Then User verifies Validation Message for
      | Field                         | Id                     | data-dataitemid             | Locator Type | Validation Error            |
      | Account Holder Routing Number | RoutingNumber(9digits) | AccountHolder_RoutingNumber | Input        | Routing Number is invalid. |
    Then User Enters "1234567890" in TextBox "RoutingNumber(9digits)"
    Then User verifies Validation Message for
      | Field                         | Id                     | data-dataitemid             | Locator Type | Validation Error            |
      | Account Holder Routing Number | RoutingNumber(9digits) | AccountHolder_RoutingNumber | Input        | Routing Number is invalid. |
    Then User verifies "RoutingNumber(9digits)" TextBox has Prefilled Value "123456789"
    Then User verify "maxlength" of field "RoutingNumber(9digits)" is "9"
    Then User Enters "051000017" in TextBox "RoutingNumber(9digits)"
    Then User verifies Validation Message for
      | Field                         | Id            | data-dataitemid             | Locator Type | Validation Error            |
      | Account Holder Account Number | AccountNumber | AccountHolder_AccountNumber | Input        | Account Number is required. |
    Then User Enters "456789123456789" in TextBox "AccountNumber"
    Then User Verifies options present for "Pleaseindicatetheaccounttype" dropdown
      | options       |
      |               |
      | Checking      |
      | Savings       |
    Then User Chooses Blank option for Dropdown "Account Type" having id "Pleaseindicatetheaccounttype" or DataItemId "AccountHolder_Account_Type"
    Then User verifies Validation Message for
      | Field                       | Id                           | data-dataitemid            | Locator Type | Validation Error          |
      | Account Holder Account Type | Pleaseindicatetheaccounttype | AccountHolder_Account_Type | Select       | Account Type is required. |
    Then User selects value "Savings" for field "AccountHolder_Account_Type"
    Then User verifies Validation Message for
      | Field                         | Id                          | data-dataitemid                                    | Locator Type | Validation Error                           |
      | Financial Institution Address | FinancialInstitutionAddress | AccountHolder_FinancialInstitution_MailingAddress1 | Input        | Financial Institution Address is required. |
    Then User Enters "National park road" in TextBox "FinancialInstitutionAddress"
    Then User verifies Validation Message for
      | Field | Id   | data-dataitemid                                        | Locator Type | Validation Error                        |
      | City  | City | AccountHolder_FinancialInstitution_MailingAddress_City | Input        | Financial Institution City is required. |
    Then User Enters "Laugh town" in TextBox "City"
    Then User Verifies options present for "State" dropdown
      | options       |
      |    |
      | AL |
      | AK |
      | AZ |
      | AR |
      | CA |
      | CO |
      | CT |
      | DE |
      | DC |
      | FL |
      | GA |
      | GU |
      | HI |
      | ID |
      | IL |
      | IN |
      | IA |
      | KS |
      | KY |
      | LA |
      | ME |
      | MD |
      | MA |
      | MI |
      | MN |
      | MS |
      | MO |
      | MT |
      | NE |
      | NV |
      | NH |
      | NJ |
      | NM |
      | NY |
      | NC |
      | ND |
      | OH |
      | OK |
      | OR |
      | PA |
      | PR |
      | RI |
      | SC |
      | SD |
      | TN |
      | TX |
      | UT |
      | VT |
      | VI |
      | VA |
      | WA |
      | WV |
      | WI |
      | WY |
    Then User Chooses Blank option for Dropdown "State" having id "State" or DataItemId "AccountHolder_FinancialInstitution_MailingAddress_State"
    Then User verifies Validation Message for
      | Field | Id    | data-dataitemid                                         | Locator Type | Validation Error                         |
      | State | State | AccountHolder_FinancialInstitution_MailingAddress_State | Select       | Financial Institution State is required. |
    Then User selects value "CA" for field "State"
    Then User verifies Validation Message for
      | Field       | Id         | data-dataitemid                                           | Locator Type | Validation Error                               |
      | Postal Code | PostalCode | AccountHolder_FinancialInstitution_MailingAddress_Zipcode | Input       | Financial Institution Postal Code is required. |
    Then User Enters "646846846" in TextBox "PostalCode"
    Then User clicks "Previous" button
    Then User verifies Page heading "Premium Module" with form name "Premium" for data entry flow
    Then User Verifies checkbox "New Money – Checking/Savings (ACH)" is "checked"
    Then User Verifies checkbox "Check if Total Single Premium amount is estimated or a transfer is requested." is "checked"
    Then User verifies "TotalSinglePremiumAmount" TextBox has Prefilled Value "$30,145.00"
    Then User verifies "CashAmount" TextBox has Prefilled Value "$30,145.00"
    Then User Verifies radiobutton "No" is "checked" for "Will this contract replace or change any of your existing life insurance policies or annuity contracts?"
    Then User Verifies radiobutton "Yes" is "checked" for "Do you have any existing life insurance or annuity contracts?"
    Then User clicks "Next" button
    Then User verifies Page heading "Annuity ACH Module" with form name "ACH Payment" for data entry flow
    Then User verifies "FinancialInstitutionName" TextBox has Prefilled Value "A2B corporation!"
    Then User verifies "AccountHolderFirstName" TextBox has Prefilled Value "Jemimah"
    Then User verifies "MiddleName" TextBox has Prefilled Value "M"
    Then User verifies "LastName" TextBox has Prefilled Value "Rodrigues"
    Then User verifies "RoutingNumber(9digits)" TextBox has Prefilled Value "051000017"
    Then User verifies "AccountNumber" TextBox has Prefilled Value "456789123456789"
    Then User verifies "FinancialInstitutionAddress" TextBox has Prefilled Value "National park road"
    Then User verifies "City" TextBox has Prefilled Value "Laugh town"
    Then User verifies "PostalCode" TextBox has Prefilled Value "64684-6846"
    Then User Verifies value "CA" for field "State"
    Then User Verifies value "Savings" for field "Please indicate the account type"
    Then User clicks "Next" button
#    Then User verifies Page heading "Fund Allocation Module" with form name "Fund Allocation" for data entry flow
    Then User verifies Page heading "Fund Allocation Variable Module" with form name "Fund Allocation" for data entry flow
    Then User verifies "Bond Fund 1" field has "placeholder" Value "0.00%"
    Then User Enters "abcd" in field "Bond Fund 1"
    Then User verifies "Bond Fund 1" field has "placeholder" Value "0.00%"
    Then User Enters "!@#$" in field "Bond Fund 1"
    Then User verifies "Bond Fund 1" field has "placeholder" Value "0.00%"
    Then User verify max length of field "Bond Fund 1" is "100"
    Then User Enters ".11" in field "Bond Fund 1"
    Then User verifies "Bond Fund 1" field has Prefilled Value "0.11%"
    Then User Enters "1.01" in field "Bond Fund 1"
    Then User verifies "Bond Fund 1" field has Prefilled Value "1.01%"
    Then User verifies "Bond Fund 2" field has "placeholder" Value "0.00%"
    Then User Enters "abcd" in field "Bond Fund 2"
    Then User verifies "Bond Fund 2" field has "placeholder" Value "0.00%"
    Then User Enters "!@#$" in field "Bond Fund 2"
    Then User verifies "Bond Fund 2" field has "placeholder" Value "0.00%"
    Then User verify max length of field "Bond Fund 2" is "100"
    Then User Enters ".11" in field "Bond Fund 2"
    Then User verifies "Bond Fund 2" field has Prefilled Value "0.11%"
    Then User Enters "1.01" in field "Bond Fund 2"
    Then User verifies "Bond Fund 2" field has Prefilled Value "1.01%"
    Then User verifies "Bond Fund 3" field has "placeholder" Value "0.00%"
    Then User Enters "abcd" in field "Bond Fund 3"
    Then User verifies "Bond Fund 3" field has "placeholder" Value "0.00%"
    Then User Enters "!@#$" in field "Bond Fund 3"
    Then User verifies "Bond Fund 3" field has "placeholder" Value "0.00%"
    Then User verify max length of field "Bond Fund 3" is "100"
    Then User Enters ".11" in field "Bond Fund 3"
    Then User verifies "Bond Fund 3" field has Prefilled Value "0.11%"
    Then User Enters "1.01" in field "Bond Fund 3"
    Then User verifies "Bond Fund 3" field has Prefilled Value "1.01%"
    Then User verifies "Bond Fund 4" field has "placeholder" Value "0.00%"
    Then User Enters "abcd" in field "Bond Fund 4"
    Then User verifies "Bond Fund 4" field has "placeholder" Value "0.00%"
    Then User Enters "!@#$" in field "Bond Fund 4"
    Then User verifies "Bond Fund 4" field has "placeholder" Value "0.00%"
    Then User verify max length of field "Bond Fund 4" is "100"
    Then User Enters ".11" in field "Bond Fund 4"
    Then User verifies "Bond Fund 4" field has Prefilled Value "0.11%"
    Then User Enters "1.01" in field "Bond Fund 4"
    Then User verifies "Bond Fund 4" field has Prefilled Value "1.01%"
    Then User verifies "Bond Fund 5" field has "placeholder" Value "0.00%"
    Then User Enters "abcd" in field "Bond Fund 5"
    Then User verifies "Bond Fund 5" field has "placeholder" Value "0.00%"
    Then User Enters "!@#$" in field "Bond Fund 5"
    Then User verifies "Bond Fund 5" field has "placeholder" Value "0.00%"
    Then User verify max length of field "Bond Fund 5" is "100"
    Then User Enters ".11" in field "Bond Fund 5"
    Then User verifies "Bond Fund 5" field has Prefilled Value "0.11%"
    Then User Enters "1.01" in field "Bond Fund 5"
    Then User verifies "Bond Fund 5" field has Prefilled Value "1.01%"
    Then User verifies "International Fund 1" field has "placeholder" Value "0.00%"
    Then User Enters "abcd" in field "International Fund 1"
    Then User verifies "International Fund 1" field has "placeholder" Value "0.00%"
    Then User Enters "!@#$" in field "International Fund 1"
    Then User verifies "International Fund 1" field has "placeholder" Value "0.00%"
    Then User verify max length of field "International Fund 1" is "100"
    Then User Enters ".11" in field "International Fund 1"
    Then User verifies "International Fund 1" field has Prefilled Value "0.11%"
    Then User Enters "1.01" in field "International Fund 1"
    Then User verifies "International Fund 1" field has Prefilled Value "1.01%"
    Then User verifies "International Fund 2" field has "placeholder" Value "0.00%"
    Then User Enters "abcd" in field "International Fund 2"
    Then User verifies "International Fund 2" field has "placeholder" Value "0.00%"
    Then User Enters "!@#$" in field "International Fund 2"
    Then User verifies "International Fund 2" field has "placeholder" Value "0.00%"
    Then User verify max length of field "International Fund 2" is "100"
    Then User Enters ".11" in field "International Fund 2"
    Then User verifies "International Fund 2" field has Prefilled Value "0.11%"
    Then User Enters "1.01" in field "International Fund 2"
    Then User verifies "International Fund 2" field has Prefilled Value "1.01%"
    Then User verifies "International Fund 3" field has "placeholder" Value "0.00%"
    Then User Enters "abcd" in field "International Fund 3"
    Then User verifies "International Fund 3" field has "placeholder" Value "0.00%"
    Then User Enters "!@#$" in field "International Fund 3"
    Then User verifies "International Fund 3" field has "placeholder" Value "0.00%"
    Then User verify max length of field "International Fund 3" is "100"
    Then User Enters ".11" in field "International Fund 3"
    Then User verifies "International Fund 3" field has Prefilled Value "0.11%"
    Then User Enters "1.01" in field "International Fund 3"
    Then User verifies "International Fund 3" field has Prefilled Value "1.01%"
    Then User verifies "International Fund 4" field has "placeholder" Value "0.00%"
    Then User Enters "abcd" in field "International Fund 4"
    Then User verifies "International Fund 4" field has "placeholder" Value "0.00%"
    Then User Enters "!@#$" in field "International Fund 4"
    Then User verifies "International Fund 4" field has "placeholder" Value "0.00%"
    Then User verify max length of field "International Fund 4" is "100"
    Then User Enters ".11" in field "International Fund 4"
    Then User verifies "International Fund 4" field has Prefilled Value "0.11%"
    Then User Enters "1.01" in field "International Fund 4"
    Then User verifies "International Fund 4" field has Prefilled Value "1.01%"
    Then User verifies "International Fund 5" field has "placeholder" Value "0.00%"
    Then User Enters "abcd" in field "International Fund 5"
    Then User verifies "International Fund 5" field has "placeholder" Value "0.00%"
    Then User Enters "!@#$" in field "International Fund 5"
    Then User verifies "International Fund 5" field has "placeholder" Value "0.00%"
    Then User verify max length of field "International Fund 5" is "100"
    Then User Enters ".11" in field "International Fund 5"
    Then User verifies "International Fund 5" field has Prefilled Value "0.11%"
    Then User Enters "1.01" in field "International Fund 5"
    Then User verifies "International Fund 5" field has Prefilled Value "1.01%"
    Then User verifies "Large Cap Value Fund 1" field has "placeholder" Value "0.00%"
    Then User Enters "abcd" in field "Large Cap Value Fund 1"
    Then User verifies "Large Cap Value Fund 1" field has "placeholder" Value "0.00%"
    Then User Enters "!@#$" in field "Large Cap Value Fund 1"
    Then User verifies "Large Cap Value Fund 1" field has "placeholder" Value "0.00%"
    Then User verify max length of field "Large Cap Value Fund 1" is "100"
    Then User Enters ".11" in field "Large Cap Value Fund 1"
    Then User verifies "Large Cap Value Fund 1" field has Prefilled Value "0.11%"
    Then User Enters "1.01" in field "Large Cap Value Fund 1"
    Then User verifies "Large Cap Value Fund 1" field has Prefilled Value "1.01%"
    Then User verifies "Large Cap Value Fund 2" field has "placeholder" Value "0.00%"
    Then User Enters "abcd" in field "Large Cap Value Fund 2"
    Then User verifies "Large Cap Value Fund 2" field has "placeholder" Value "0.00%"
    Then User Enters "!@#$" in field "Large Cap Value Fund 2"
    Then User verifies "Large Cap Value Fund 2" field has "placeholder" Value "0.00%"
    Then User verify max length of field "Large Cap Value Fund 2" is "100"
    Then User Enters ".11" in field "Large Cap Value Fund 2"
    Then User verifies "Large Cap Value Fund 2" field has Prefilled Value "0.11%"
    Then User Enters "1.01" in field "Large Cap Value Fund 2"
    Then User verifies "Large Cap Value Fund 2" field has Prefilled Value "1.01%"
    Then User verifies "Large Cap Value Fund 3" field has "placeholder" Value "0.00%"
    Then User Enters "abcd" in field "Large Cap Value Fund 3"
    Then User verifies "Large Cap Value Fund 3" field has "placeholder" Value "0.00%"
    Then User Enters "!@#$" in field "Large Cap Value Fund 3"
    Then User verifies "Large Cap Value Fund 3" field has "placeholder" Value "0.00%"
    Then User verify max length of field "Large Cap Value Fund 3" is "100"
    Then User Enters ".11" in field "Large Cap Value Fund 3"
    Then User verifies "Large Cap Value Fund 3" field has Prefilled Value "0.11%"
    Then User Enters "1.01" in field "Large Cap Value Fund 3"
    Then User verifies "Large Cap Value Fund 3" field has Prefilled Value "1.01%"
    Then User verifies "Large Cap Value Fund 4" field has "placeholder" Value "0.00%"
    Then User Enters "abcd" in field "Large Cap Value Fund 4"
    Then User verifies "Large Cap Value Fund 4" field has "placeholder" Value "0.00%"
    Then User Enters "!@#$" in field "Large Cap Value Fund 4"
    Then User verifies "Large Cap Value Fund 4" field has "placeholder" Value "0.00%"
    Then User verify max length of field "Large Cap Value Fund 4" is "100"
    Then User Enters ".11" in field "Large Cap Value Fund 4"
    Then User verifies "Large Cap Value Fund 4" field has Prefilled Value "0.11%"
    Then User Enters "1.01" in field "Large Cap Value Fund 4"
    Then User verifies "Large Cap Value Fund 4" field has Prefilled Value "1.01%"
    Then User verifies "Large Cap Value Fund 5" field has "placeholder" Value "0.00%"
    Then User Enters "abcd" in field "Large Cap Value Fund 5"
    Then User verifies "Large Cap Value Fund 5" field has "placeholder" Value "0.00%"
    Then User Enters "!@#$" in field "Large Cap Value Fund 5"
    Then User verifies "Large Cap Value Fund 5" field has "placeholder" Value "0.00%"
    Then User verify max length of field "Large Cap Value Fund 5" is "100"
    Then User Enters ".11" in field "Large Cap Value Fund 5"
    Then User verifies "Large Cap Value Fund 5" field has Prefilled Value "0.11%"
    Then User Enters "1.01" in field "Large Cap Value Fund 5"
    Then User verifies "Large Cap Value Fund 5" field has Prefilled Value "1.01%"
    Then User verifies "Mid Cap Value Fund 1" field has "placeholder" Value "0.00%"
    Then User Enters "abcd" in field "Mid Cap Value Fund 1"
    Then User verifies "Mid Cap Value Fund 1" field has "placeholder" Value "0.00%"
    Then User Enters "!@#$" in field "Mid Cap Value Fund 1"
    Then User verifies "Mid Cap Value Fund 1" field has "placeholder" Value "0.00%"
    Then User verify max length of field "Mid Cap Value Fund 1" is "100"
    Then User Enters ".11" in field "Mid Cap Value Fund 1"
    Then User verifies "Mid Cap Value Fund 1" field has Prefilled Value "0.11%"
    Then User Enters "1.01" in field "Mid Cap Value Fund 1"
    Then User verifies "Mid Cap Value Fund 1" field has Prefilled Value "1.01%"
    Then User verifies "Mid Cap Value Fund 2" field has "placeholder" Value "0.00%"
    Then User Enters "abcd" in field "Mid Cap Value Fund 2"
    Then User verifies "Mid Cap Value Fund 2" field has "placeholder" Value "0.00%"
    Then User Enters "!@#$" in field "Mid Cap Value Fund 2"
    Then User verifies "Mid Cap Value Fund 2" field has "placeholder" Value "0.00%"
    Then User verify max length of field "Mid Cap Value Fund 2" is "100"
    Then User Enters ".11" in field "Mid Cap Value Fund 2"
    Then User verifies "Mid Cap Value Fund 2" field has Prefilled Value "0.11%"
    Then User Enters "1.01" in field "Mid Cap Value Fund 2"
    Then User verifies "Mid Cap Value Fund 2" field has Prefilled Value "1.01%"
    Then User verifies "Mid Cap Value Fund 3" field has "placeholder" Value "0.00%"
    Then User Enters "abcd" in field "Mid Cap Value Fund 3"
    Then User verifies "Mid Cap Value Fund 3" field has "placeholder" Value "0.00%"
    Then User Enters "!@#$" in field "Mid Cap Value Fund 3"
    Then User verifies "Mid Cap Value Fund 3" field has "placeholder" Value "0.00%"
    Then User verify max length of field "Mid Cap Value Fund 3" is "100"
    Then User Enters ".11" in field "Mid Cap Value Fund 3"
    Then User verifies "Mid Cap Value Fund 3" field has Prefilled Value "0.11%"
    Then User Enters "1.01" in field "Mid Cap Value Fund 3"
    Then User verifies "Mid Cap Value Fund 3" field has Prefilled Value "1.01%"
    Then User verifies "Mid Cap Value Fund 4" field has "placeholder" Value "0.00%"
    Then User Enters "abcd" in field "Mid Cap Value Fund 4"
    Then User verifies "Mid Cap Value Fund 4" field has "placeholder" Value "0.00%"
    Then User Enters "!@#$" in field "Mid Cap Value Fund 4"
    Then User verifies "Mid Cap Value Fund 4" field has "placeholder" Value "0.00%"
    Then User verify max length of field "Mid Cap Value Fund 4" is "100"
    Then User Enters ".11" in field "Mid Cap Value Fund 4"
    Then User verifies "Mid Cap Value Fund 4" field has Prefilled Value "0.11%"
    Then User Enters "1.01" in field "Mid Cap Value Fund 4"
    Then User verifies "Mid Cap Value Fund 4" field has Prefilled Value "1.01%"
    Then User verifies "Mid Cap Value Fund 5" field has "placeholder" Value "0.00%"
    Then User Enters "abcd" in field "Mid Cap Value Fund 5"
    Then User verifies "Mid Cap Value Fund 5" field has "placeholder" Value "0.00%"
    Then User Enters "!@#$" in field "Mid Cap Value Fund 5"
    Then User verifies "Mid Cap Value Fund 5" field has "placeholder" Value "0.00%"
    Then User verify max length of field "Mid Cap Value Fund 5" is "100"
    Then User Enters ".11" in field "Mid Cap Value Fund 5"
    Then User verifies "Mid Cap Value Fund 5" field has Prefilled Value "0.11%"
    Then User Enters "1.01" in field "Mid Cap Value Fund 5"
    Then User verifies "Mid Cap Value Fund 5" field has Prefilled Value "1.01%"
    Then User verifies "Small Cap Value Fund 1" field has "placeholder" Value "0.00%"
    Then User Enters "abcd" in field "Small Cap Value Fund 1"
    Then User verifies "Small Cap Value Fund 1" field has "placeholder" Value "0.00%"
    Then User Enters "!@#$" in field "Small Cap Value Fund 1"
    Then User verifies "Small Cap Value Fund 1" field has "placeholder" Value "0.00%"
    Then User verify max length of field "Small Cap Value Fund 1" is "100"
    Then User Enters ".11" in field "Small Cap Value Fund 1"
    Then User verifies "Small Cap Value Fund 1" field has Prefilled Value "0.11%"
    Then User Enters "1.01" in field "Small Cap Value Fund 1"
    Then User verifies "Small Cap Value Fund 1" field has Prefilled Value "1.01%"
    Then User verifies "Small Cap Value Fund 2" field has "placeholder" Value "0.00%"
    Then User Enters "abcd" in field "Small Cap Value Fund 2"
    Then User verifies "Small Cap Value Fund 2" field has "placeholder" Value "0.00%"
    Then User Enters "!@#$" in field "Small Cap Value Fund 2"
    Then User verifies "Small Cap Value Fund 2" field has "placeholder" Value "0.00%"
    Then User verify max length of field "Small Cap Value Fund 2" is "100"
    Then User Enters ".11" in field "Small Cap Value Fund 2"
    Then User verifies "Small Cap Value Fund 2" field has Prefilled Value "0.11%"
    Then User Enters "1.01" in field "Small Cap Value Fund 2"
    Then User verifies "Small Cap Value Fund 2" field has Prefilled Value "1.01%"
    Then User verifies "Small Cap Value Fund 3" field has "placeholder" Value "0.00%"
    Then User Enters "abcd" in field "Small Cap Value Fund 3"
    Then User verifies "Small Cap Value Fund 3" field has "placeholder" Value "0.00%"
    Then User Enters "!@#$" in field "Small Cap Value Fund 3"
    Then User verifies "Small Cap Value Fund 3" field has "placeholder" Value "0.00%"
    Then User verify max length of field "Small Cap Value Fund 3" is "100"
    Then User Enters ".11" in field "Small Cap Value Fund 3"
    Then User verifies "Small Cap Value Fund 3" field has Prefilled Value "0.11%"
    Then User Enters "1.01" in field "Small Cap Value Fund 3"
    Then User verifies "Small Cap Value Fund 3" field has Prefilled Value "1.01%"
    Then User verifies "Small Cap Value Fund 4" field has "placeholder" Value "0.00%"
    Then User Enters "abcd" in field "Small Cap Value Fund 4"
    Then User verifies "Small Cap Value Fund 4" field has "placeholder" Value "0.00%"
    Then User Enters "!@#$" in field "Small Cap Value Fund 4"
    Then User verifies "Small Cap Value Fund 4" field has "placeholder" Value "0.00%"
    Then User verify max length of field "Small Cap Value Fund 4" is "100"
    Then User Enters ".11" in field "Small Cap Value Fund 4"
    Then User verifies "Small Cap Value Fund 4" field has Prefilled Value "0.11%"
    Then User Enters "1.01" in field "Small Cap Value Fund 4"
    Then User verifies "Small Cap Value Fund 4" field has Prefilled Value "1.01%"
    Then User verifies "Small Cap Value Fund 5" field has "placeholder" Value "0.00%"
    Then User Enters "abcd" in field "Small Cap Value Fund 5"
    Then User verifies "Small Cap Value Fund 5" field has "placeholder" Value "0.00%"
    Then User Enters "!@#$" in field "Small Cap Value Fund 5"
    Then User verifies "Small Cap Value Fund 5" field has "placeholder" Value "0.00%"
    Then User verify max length of field "Small Cap Value Fund 5" is "100"
    Then User Enters ".11" in field "Small Cap Value Fund 5"
    Then User verifies "Small Cap Value Fund 5" field has Prefilled Value "0.11%"
    Then User Enters "1.01" in field "Small Cap Value Fund 5"
    Then User verifies "Small Cap Value Fund 5" field has Prefilled Value "1.01%"
    Then User Enters "6" in field "Bond Fund 1"
    Then User Enters "1" in field "Bond Fund 2"
    Then User Enters "2" in field "Bond Fund 3"
    Then User Enters "3" in field "Bond Fund 4"
    Then User Enters "4" in field "Bond Fund 5"
    Then User Enters "2" in field "International Fund 1"
    Then User Enters "3" in field "International Fund 2"
    Then User Enters "1" in field "International Fund 3"
    Then User Enters "5" in field "International Fund 4"
    Then User Enters "7" in field "International Fund 5"
    Then User Enters "2.2" in field "Large Cap Value Fund 1"
    Then User Enters "5.6" in field "Large Cap Value Fund 2"
    Then User Enters "3" in field "Large Cap Value Fund 3"
    Then User Enters "6" in field "Large Cap Value Fund 4"
    Then User Enters "9" in field "Large Cap Value Fund 5"
    Then User Enters "1" in field "Mid Cap Value Fund 1"
    Then User Enters "2" in field "Mid Cap Value Fund 2"
    Then User Enters "1" in field "Mid Cap Value Fund 3"
    Then User Enters "2" in field "Mid Cap Value Fund 4"
    Then User Enters "1" in field "Mid Cap Value Fund 5"
    Then User Enters "2" in field "Small Cap Value Fund 1"
    Then User Enters "4" in field "Small Cap Value Fund 2"
    Then User Enters "6" in field "Small Cap Value Fund 3"
    Then User Enters "8" in field "Small Cap Value Fund 4"
    Then User Enters "10" in field "Small Cap Value Fund 5"
#    Then User verifies "Total_Initial_Investment_Allocation_Percentage" is "readonly" field
#    Then User verifies "Total_Initial_Investment_Allocation_Percentage" TextBox has Prefilled Value "97%"
#    Then User verifies Validation Message for
#      | Field                 | Id                   | data-dataitemid                                | Locator Type | Validation Error                                      |
#      | Investment Allocation | InvestmentAllocation | Total_Initial_Investment_Allocation_Percentage | Input        | The total initial allocation must equal 100%. |
#    Then User Enters "14" in field "Small Cap Value Fund 5"
#    Then User verifies "Total_Initial_Investment_Allocation_Percentage" TextBox has Prefilled Value "101%"
#    Then User verifies Validation Message for
#      | Field          | Id              | data-dataitemid        | Locator Type | Validation Error                        |
#      | Investment Allocation | InvestmentAllocation | Total_Initial_Investment_Allocation_Percentage | Input        | The total initial allocation must equal 100%. |
#    Then User Enters "13" in field "Small Cap Value Fund 5"
#    Then User verifies "Total_Initial_Investment_Allocation_Percentage" TextBox has Prefilled Value "100%"
#    Then User "check" checkbox "I elect Automatic Asset Rebalancing"
#    Then User Verifies "Frequency" is "displayed" under "Automatic Asset Rebalancing" on page
#    Then User Verifies "Start Date" is "displayed" under "Automatic Asset Rebalancing" on page
#    Then User Verifies options present for "Frequency" dropdown
#      | options     |
#      |             |
#      | Annual      |
#      | Semi-Annual |
#      | Quarterly   |
#      | Monthly     |
#    Then User Chooses Blank option for Dropdown "Frequency" having id "Frequency" or DataItemId "Rebalancing_Frequency"
#    Then User verifies Validation Message for
#      | Field     | Id        | data-dataitemid       | Locator Type | Validation Error                      |
#      | Frequency | Frequency | Rebalancing_Frequency | Select       | Auto Rebalance frequency is required. |
#    Then User selects value "Semi-Annual" for field "Frequency"
#    Then User verifies Validation Message for
#      | Field     | Id        | data-dataitemid       | Locator Type | Validation Error                       |
#      | StartDate | StartDate | Rebalancing_StartDate | Input        | Auto Rebalance start date is required. |
#    Then User verifies data picker is displayed
#    Then User select start date in past from date picker
#    Then User verifies Validation Message for
#      | Field     | Id        | data-dataitemid       | Locator Type | Validation Error                                 |
#      | StartDate | StartDate | Rebalancing_StartDate | Input        | Auto Rebalance Start Date must be in the future. |
#    Then User Enters "03122024" in TextBox "StartDate"
#    Then User "check" checkbox "I elect Dollar Cost Averaging"
#    Then User Verifies "Frequency" is "displayed" under "Dollar Cost Averaging (DCA)" on page
#    Then User Verifies "Duration" is "displayed" under "Dollar Cost Averaging (DCA)" on page
#    Then User Verifies "Percent" is "displayed" under "Dollar Cost Averaging (DCA)" on page
#    Then User Verifies "Amount" is "displayed" under "Dollar Cost Averaging (DCA)" on page
#    Then User Verifies options present for "DollarCostAverage_Frequency" dropdown
#      | options     |
#      |             |
#      | Annual      |
#      | Semi-Annual |
#      | Quarterly   |
#      | Monthly     |
#    Then User Chooses Blank option for Dropdown "Frequency" having DataItemId "DollarCostAverage_Frequency"
#    Then User verifies Validation Message for
#      | Field      | Id        | data-dataitemid | Locator Type | Validation Error        |
#      | Frequency      |         | DollarCostAverage_Frequency | Select | Dollar Cost Averaging Frequency is required.        |
#    Then User selects value "Quarterly" for field "DollarCostAverage_Frequency"
#    Then User Verifies options present for "Duration" dropdown
#      | options   |
#      |           |
#      | 3 Months  |
#      | 6 Months  |
#      | 9 Months  |
#      | 12 Months |
#      | 15 Months |
#      | 18 Months |
#      | 21 Months |
#      | 24 Months |
#    Then User Chooses Blank option for Dropdown "Duration" having id "Duration" or DataItemId "DollarCostAverage_Duration"
##    Then User verifies Validation Message for
##      | Field    | Id       | data-dataitemid            | Locator Type | Validation Error                            |
##      | Duration | Duration | DollarCostAverage_Duration | Select       | Dollat Cost Averaging Duration is required. |
#    Then User selects value "15 Months" for field "Duration"
#    Then User verifies Validation Message for
#      | Field  | Id     | data-dataitemid          | Locator Type | Validation Error                                        |
#      | Amount | Amount | DollarCostAverage_Amount | Input        | A Dollar Cost Average Amount or Percentage is required. |
#    Then User verify "placeholder" of field "Amount" is "Whole Dollar Amount"
#    Then User verifies Validation Message for
#      | Field   | Id      | data-dataitemid              | Locator Type | Validation Error                                        |
#      | Percent | Percent | DollarCostAverage_Percentage | Input        | A Dollar Cost Average Amount or Percentage is required. |
#    Then User verify "placeholder" of field "Percent" is "Whole Percentage"
#    Then User Enters "1" in TextBox "Amount"
#    Then User Verifies "Percent" is "not displayed" under "Dollar Cost Averaging (DCA)" on page
#    Then User Enters "25.351" in TextBox "Amount"
#    Then User verifies "Amount" TextBox has Prefilled Value "$25.35"
#    Then User clears value in field "Amount"
#    Then User Verifies "Percent" is "displayed" under "Dollar Cost Averaging (DCA)" on page
#    Then User Verifies "Amount" is "displayed" under "Dollar Cost Averaging (DCA)" on page
#    Then User Enters "1" in TextBox "Percent"
#    Then User Verifies "Amount" is "not displayed" under "Dollar Cost Averaging (DCA)" on page
#    Then User Enters "25.351" in TextBox "Percent"
#    Then User verifies "Percent" TextBox has Prefilled Value "25%"
#    Then User clears value in field "Percent"
#    Then User Verifies "Percent" is "displayed" under "Dollar Cost Averaging (DCA)" on page
#    Then User Verifies "Amount" is "displayed" under "Dollar Cost Averaging (DCA)" on page
#    Then User Enters "254531" in TextBox "Amount"
#    Then User clicks "Previous" button
#    Then User verifies Page heading "Annuity ACH Module" with form name "ACH Payment" for data entry flow
#    Then User verifies "FinancialInstitutionName" TextBox has Prefilled Value "A2B corporation!"
#    Then User verifies "AccountHolderFirstName" TextBox has Prefilled Value "Jemimah"
#    Then User verifies "MiddleName" TextBox has Prefilled Value "M"
#    Then User verifies "LastName" TextBox has Prefilled Value "Rodrigues"
#    Then User verifies "RoutingNumber(9digits)" TextBox has Prefilled Value "051000017"
#    Then User verifies "AccountNumber" TextBox has Prefilled Value "456789123456789"
#    Then User verifies "FinancialInstitutionAddress" TextBox has Prefilled Value "National park road"
#    Then User verifies "City" TextBox has Prefilled Value "Laugh town"
#    Then User verifies "PostalCode" TextBox has Prefilled Value "64684-6846"
#    Then User Verifies value "CA" for field "State"
#    Then User Verifies value "Savings" for field "Please indicate the account type"
#    Then User clicks "Next" button
#    Then User verifies Page heading "Fund Allocation Module" with form name "Fund Allocation" for data entry flow
#    Then User verifies "Bond Fund 1" field has Prefilled Value "6"
#    Then User verifies "Bond Fund 2" field has Prefilled Value "1"
#    Then User verifies "Bond Fund 3" field has Prefilled Value "2"
#    Then User verifies "Bond Fund 4" field has Prefilled Value "3"
#    Then User verifies "Bond Fund 5" field has Prefilled Value "4"
#    Then User verifies "International Fund 1" field has Prefilled Value "2"
#    Then User verifies "International Fund 2" field has Prefilled Value "3"
#    Then User verifies "International Fund 3" field has Prefilled Value "1"
#    Then User verifies "International Fund 4" field has Prefilled Value "5"
#    Then User verifies "International Fund 5" field has Prefilled Value "7"
#    Then User verifies "Large Cap Value Fund 1" field has Prefilled Value "2.2"
#    Then User verifies "Large Cap Value Fund 2" field has Prefilled Value "5.6"
#    Then User verifies "Large Cap Value Fund 3" field has Prefilled Value "3"
#    Then User verifies "Large Cap Value Fund 4" field has Prefilled Value "6"
#    Then User verifies "Large Cap Value Fund 5" field has Prefilled Value "9"
#    Then User verifies "Mid Cap Value Fund 1" field has Prefilled Value "1"
#    Then User verifies "Mid Cap Value Fund 2" field has Prefilled Value "2"
#    Then User verifies "Mid Cap Value Fund 3" field has Prefilled Value "1"
#    Then User verifies "Mid Cap Value Fund 4" field has Prefilled Value "2"
#    Then User verifies "Mid Cap Value Fund 5" field has Prefilled Value "1"
#    Then User verifies "Small Cap Value Fund 1" field has Prefilled Value "2"
#    Then User verifies "Small Cap Value Fund 2" field has Prefilled Value "4"
#    Then User verifies "Small Cap Value Fund 3" field has Prefilled Value "6"
#    Then User verifies "Small Cap Value Fund 4" field has Prefilled Value "8"
#    Then User verifies "Small Cap Value Fund 5" field has Prefilled Value "13"
#    Then User verifies "Total_Initial_Investment_Allocation_Percentage" TextBox has Prefilled Value "100%"
#    Then User Verifies checkbox "I elect Automatic Asset Rebalancing" is "checked"
#    Then User Verifies value "Semi-Annual" for field "Frequency"
#    Then User verifies "StartDate" TextBox has Prefilled Value "03/12/2024"
#    Then User Verifies checkbox "I elect Dollar Cost Averaging" is "checked"
#    Then User Verifies value "Quarterly" for field "DollarCostAverage_Frequency"
#    Then User Verifies value "15 Months" for field "Duration"
#    Then User verifies "Amount" TextBox has Prefilled Value "$254,531.00"
#    Then User clicks "Next" button
#    Then User verifies Page heading "Fund Allocation Module" with form name "Fund Allocation" for data entry flow
#    Then User verifies "Bond Fund 1" field has "placeholder" Value "0.00%"
#    Then User Enters "abc" in field "Bond Fund 1"
#    Then User verifies "Bond Fund 1" field has "placeholder" Value "0.00%"
#    Then User Enters "!@#$" in field "Bond Fund 1"
#    Then User verifies "Bond Fund 1" field has "placeholder" Value "0.00%"
#    Then User Enters "100.25" in field "Bond Fund 1"
#    Then User verifies "Bond Fund 1" field has Prefilled Value "100.25%"
#    Then User verify max length of field "Bond Fund 1" is "100"
#    Then User Enters "98.012" in field "Bond Fund 1"
#    Then User verifies "Bond Fund 1" field has Prefilled Value "98.01%"
#    Then User verifies "Bond Fund 2" field has "placeholder" Value "0.00%"
#    Then User Enters "abc" in field "Bond Fund 2"
#    Then User verifies "Bond Fund 2" field has "placeholder" Value "0.00%"
#    Then User Enters "!@#$" in field "Bond Fund 2"
#    Then User verifies "Bond Fund 2" field has "placeholder" Value "0.00%"
#    Then User Enters "100.25" in field "Bond Fund 2"
#    Then User verifies "Bond Fund 2" field has Prefilled Value "100.25%"
#    Then User verify max length of field "Bond Fund 2" is "100"
#    Then User Enters "98.012" in field "Bond Fund 2"
#    Then User verifies "Bond Fund 2" field has Prefilled Value "98.01%"
#    Then User verifies "Bond Fund 3" field has "placeholder" Value "0.00%"
#    Then User Enters "abc" in field "Bond Fund 3"
#    Then User verifies "Bond Fund 3" field has "placeholder" Value "0.00%"
#    Then User Enters "!@#$" in field "Bond Fund 3"
#    Then User verifies "Bond Fund 3" field has "placeholder" Value "0.00%"
#    Then User Enters "100.25" in field "Bond Fund 3"
#    Then User verifies "Bond Fund 3" field has Prefilled Value "100.25%"
#    Then User verify max length of field "Bond Fund 3" is "100"
#    Then User Enters "98.012" in field "Bond Fund 3"
#    Then User verifies "Bond Fund 3" field has Prefilled Value "98.01%"
#    Then User verifies "Bond Fund 4" field has "placeholder" Value "0.00%"
#    Then User Enters "abc" in field "Bond Fund 4"
#    Then User verifies "Bond Fund 4" field has "placeholder" Value "0.00%"
#    Then User Enters "!@#$" in field "Bond Fund 4"
#    Then User verifies "Bond Fund 4" field has "placeholder" Value "0.00%"
#    Then User Enters "100.25" in field "Bond Fund 4"
#    Then User verifies "Bond Fund 4" field has Prefilled Value "100.25%"
#    Then User verify max length of field "Bond Fund 4" is "100"
#    Then User Enters "98.012" in field "Bond Fund 4"
#    Then User verifies "Bond Fund 4" field has Prefilled Value "98.01%"
#    Then User verifies "Bond Fund 5" field has "placeholder" Value "0.00%"
#    Then User Enters "abc" in field "Bond Fund 5"
#    Then User verifies "Bond Fund 5" field has "placeholder" Value "0.00%"
#    Then User Enters "!@#$" in field "Bond Fund 5"
#    Then User verifies "Bond Fund 5" field has "placeholder" Value "0.00%"
#    Then User Enters "100.25" in field "Bond Fund 5"
#    Then User verifies "Bond Fund 5" field has Prefilled Value "100.25%"
#    Then User verify max length of field "Bond Fund 5" is "100"
#    Then User Enters "98.012" in field "Bond Fund 5"
#    Then User verifies "Bond Fund 5" field has Prefilled Value "98.01%"
#    Then User verifies "International Fund 1" field has "placeholder" Value "0.00%"
#    Then User Enters "abc" in field "International Fund 1"
#    Then User verifies "International Fund 1" field has "placeholder" Value "0.00%"
#    Then User Enters "!@#$" in field "International Fund 1"
#    Then User verifies "International Fund 1" field has "placeholder" Value "0.00%"
#    Then User Enters "100.25" in field "International Fund 1"
#    Then User verifies "International Fund 1" field has Prefilled Value "100.25%"
#    Then User verify max length of field "International Fund 1" is "100"
#    Then User Enters "98.012" in field "International Fund 1"
#    Then User verifies "International Fund 1" field has Prefilled Value "98.01%"
#    Then User verifies "International Fund 2" field has "placeholder" Value "0.00%"
#    Then User Enters "abc" in field "International Fund 2"
#    Then User verifies "International Fund 2" field has "placeholder" Value "0.00%"
#    Then User Enters "!@#$" in field "International Fund 2"
#    Then User verifies "International Fund 2" field has "placeholder" Value "0.00%"
#    Then User Enters "100.25" in field "International Fund 2"
#    Then User verifies "International Fund 2" field has Prefilled Value "100.25%"
#    Then User verify max length of field "International Fund 2" is "100"
#    Then User Enters "98.012" in field "International Fund 2"
#    Then User verifies "International Fund 2" field has Prefilled Value "98.01%"
#    Then User verifies "International Fund 3" field has "placeholder" Value "0.00%"
#    Then User Enters "abc" in field "International Fund 3"
#    Then User verifies "International Fund 3" field has "placeholder" Value "0.00%"
#    Then User Enters "!@#$" in field "International Fund 3"
#    Then User verifies "International Fund 3" field has "placeholder" Value "0.00%"
#    Then User Enters "100.25" in field "International Fund 3"
#    Then User verifies "International Fund 3" field has Prefilled Value "100.25%"
#    Then User verify max length of field "International Fund 3" is "100"
#    Then User Enters "98.012" in field "International Fund 3"
#    Then User verifies "International Fund 3" field has Prefilled Value "98.01%"
#    Then User verifies "International Fund 4" field has "placeholder" Value "0.00%"
#    Then User Enters "abc" in field "International Fund 4"
#    Then User verifies "International Fund 4" field has "placeholder" Value "0.00%"
#    Then User Enters "!@#$" in field "International Fund 4"
#    Then User verifies "International Fund 4" field has "placeholder" Value "0.00%"
#    Then User Enters "100.25" in field "International Fund 4"
#    Then User verifies "International Fund 4" field has Prefilled Value "100.25%"
#    Then User verify max length of field "International Fund 4" is "100"
#    Then User Enters "98.012" in field "International Fund 4"
#    Then User verifies "International Fund 4" field has Prefilled Value "98.01%"
#    Then User verifies "International Fund 5" field has "placeholder" Value "0.00%"
#    Then User Enters "abc" in field "International Fund 5"
#    Then User verifies "International Fund 5" field has "placeholder" Value "0.00%"
#    Then User Enters "!@#$" in field "International Fund 5"
#    Then User verifies "International Fund 5" field has "placeholder" Value "0.00%"
#    Then User Enters "100.25" in field "International Fund 5"
#    Then User verifies "International Fund 5" field has Prefilled Value "100.25%"
#    Then User verify max length of field "International Fund 5" is "100"
#    Then User Enters "98.012" in field "International Fund 5"
#    Then User verifies "International Fund 5" field has Prefilled Value "98.01%"
#    Then User verifies "Large Cap Value Fund 1" field has "placeholder" Value "0.00%"
#    Then User Enters "abc" in field "Large Cap Value Fund 1"
#    Then User verifies "Large Cap Value Fund 1" field has "placeholder" Value "0.00%"
#    Then User Enters "!@#$" in field "Large Cap Value Fund 1"
#    Then User verifies "Large Cap Value Fund 1" field has "placeholder" Value "0.00%"
#    Then User Enters "100.25" in field "Large Cap Value Fund 1"
#    Then User verifies "Large Cap Value Fund 1" field has Prefilled Value "100.25%"
#    Then User verify max length of field "Large Cap Value Fund 1" is "100"
#    Then User Enters "98.012" in field "Large Cap Value Fund 1"
#    Then User verifies "Large Cap Value Fund 1" field has Prefilled Value "98.01%"
#    Then User verifies "Large Cap Value Fund 2" field has "placeholder" Value "0.00%"
#    Then User Enters "abc" in field "Large Cap Value Fund 2"
#    Then User verifies "Large Cap Value Fund 2" field has "placeholder" Value "0.00%"
#    Then User Enters "!@#$" in field "Large Cap Value Fund 2"
#    Then User verifies "Large Cap Value Fund 2" field has "placeholder" Value "0.00%"
#    Then User Enters "100.25" in field "Large Cap Value Fund 2"
#    Then User verifies "Large Cap Value Fund 2" field has Prefilled Value "100.25%"
#    Then User verify max length of field "Large Cap Value Fund 2" is "100"
#    Then User Enters "98.012" in field "Large Cap Value Fund 2"
#    Then User verifies "Large Cap Value Fund 2" field has Prefilled Value "98.01%"
#    Then User verifies "Large Cap Value Fund 3" field has "placeholder" Value "0.00%"
#    Then User Enters "abc" in field "Large Cap Value Fund 3"
#    Then User verifies "Large Cap Value Fund 3" field has "placeholder" Value "0.00%"
#    Then User Enters "!@#$" in field "Large Cap Value Fund 3"
#    Then User verifies "Large Cap Value Fund 3" field has "placeholder" Value "0.00%"
#    Then User Enters "100.25" in field "Large Cap Value Fund 3"
#    Then User verifies "Large Cap Value Fund 3" field has Prefilled Value "100.25%"
#    Then User verify max length of field "Large Cap Value Fund 3" is "100"
#    Then User Enters "98.012" in field "Large Cap Value Fund 3"
#    Then User verifies "Large Cap Value Fund 3" field has Prefilled Value "98.01%"
#    Then User verifies "Large Cap Value Fund 4" field has "placeholder" Value "0.00%"
#    Then User Enters "abc" in field "Large Cap Value Fund 4"
#    Then User verifies "Large Cap Value Fund 4" field has "placeholder" Value "0.00%"
#    Then User Enters "!@#$" in field "Large Cap Value Fund 4"
#    Then User verifies "Large Cap Value Fund 4" field has "placeholder" Value "0.00%"
#    Then User Enters "100.25" in field "Large Cap Value Fund 4"
#    Then User verifies "Large Cap Value Fund 4" field has Prefilled Value "100.25%"
#    Then User verify max length of field "Large Cap Value Fund 4" is "100"
#    Then User Enters "98.012" in field "Large Cap Value Fund 4"
#    Then User verifies "Large Cap Value Fund 4" field has Prefilled Value "98.01%"
#    Then User verifies "Large Cap Value Fund 5" field has "placeholder" Value "0.00%"
#    Then User Enters "abc" in field "Large Cap Value Fund 5"
#    Then User verifies "Large Cap Value Fund 5" field has "placeholder" Value "0.00%"
#    Then User Enters "!@#$" in field "Large Cap Value Fund 5"
#    Then User verifies "Large Cap Value Fund 5" field has "placeholder" Value "0.00%"
#    Then User Enters "100.25" in field "Large Cap Value Fund 5"
#    Then User verifies "Large Cap Value Fund 5" field has Prefilled Value "100.25%"
#    Then User verify max length of field "Large Cap Value Fund 5" is "100"
#    Then User Enters "98.012" in field "Large Cap Value Fund 5"
#    Then User verifies "Large Cap Value Fund 5" field has Prefilled Value "98.01%"
#    Then User verifies "Mid Cap Value Fund 1" field has "placeholder" Value "0.00%"
#    Then User Enters "abc" in field "Mid Cap Value Fund 1"
#    Then User verifies "Mid Cap Value Fund 1" field has "placeholder" Value "0.00%"
#    Then User Enters "!@#$" in field "Mid Cap Value Fund 1"
#    Then User verifies "Mid Cap Value Fund 1" field has "placeholder" Value "0.00%"
#    Then User Enters "100.25" in field "Mid Cap Value Fund 1"
#    Then User verifies "Mid Cap Value Fund 1" field has Prefilled Value "100.25%"
#    Then User verify max length of field "Mid Cap Value Fund 1" is "100"
#    Then User Enters "98.012" in field "Mid Cap Value Fund 1"
#    Then User verifies "Mid Cap Value Fund 1" field has Prefilled Value "98.01%"
#    Then User verifies "Mid Cap Value Fund 2" field has "placeholder" Value "0.00%"
#    Then User Enters "abc" in field "Mid Cap Value Fund 2"
#    Then User verifies "Mid Cap Value Fund 2" field has "placeholder" Value "0.00%"
#    Then User Enters "!@#$" in field "Mid Cap Value Fund 2"
#    Then User verifies "Mid Cap Value Fund 2" field has "placeholder" Value "0.00%"
#    Then User Enters "100.25" in field "Mid Cap Value Fund 2"
#    Then User verifies "Mid Cap Value Fund 2" field has Prefilled Value "100.25%"
#    Then User verify max length of field "Mid Cap Value Fund 2" is "100"
#    Then User Enters "98.012" in field "Mid Cap Value Fund 2"
#    Then User verifies "Mid Cap Value Fund 2" field has Prefilled Value "98.01%"
#    Then User verifies "Mid Cap Value Fund 3" field has "placeholder" Value "0.00%"
#    Then User Enters "abc" in field "Mid Cap Value Fund 3"
#    Then User verifies "Mid Cap Value Fund 3" field has "placeholder" Value "0.00%"
#    Then User Enters "!@#$" in field "Mid Cap Value Fund 3"
#    Then User verifies "Mid Cap Value Fund 3" field has "placeholder" Value "0.00%"
#    Then User Enters "100.25" in field "Mid Cap Value Fund 3"
#    Then User verifies "Mid Cap Value Fund 3" field has Prefilled Value "100.25%"
#    Then User verify max length of field "Mid Cap Value Fund 3" is "100"
#    Then User Enters "98.012" in field "Mid Cap Value Fund 3"
#    Then User verifies "Mid Cap Value Fund 3" field has Prefilled Value "98.01%"
#    Then User verifies "Mid Cap Value Fund 4" field has "placeholder" Value "0.00%"
#    Then User Enters "abc" in field "Mid Cap Value Fund 4"
#    Then User verifies "Mid Cap Value Fund 4" field has "placeholder" Value "0.00%"
#    Then User Enters "!@#$" in field "Mid Cap Value Fund 4"
#    Then User verifies "Mid Cap Value Fund 4" field has "placeholder" Value "0.00%"
#    Then User Enters "100.25" in field "Mid Cap Value Fund 4"
#    Then User verifies "Mid Cap Value Fund 4" field has Prefilled Value "100.25%"
#    Then User verify max length of field "Mid Cap Value Fund 4" is "100"
#    Then User Enters "98.012" in field "Mid Cap Value Fund 4"
#    Then User verifies "Mid Cap Value Fund 4" field has Prefilled Value "98.01%"
#    Then User verifies "Mid Cap Value Fund 5" field has "placeholder" Value "0.00%"
#    Then User Enters "abc" in field "Mid Cap Value Fund 5"
#    Then User verifies "Mid Cap Value Fund 5" field has "placeholder" Value "0.00%"
#    Then User Enters "!@#$" in field "Mid Cap Value Fund 5"
#    Then User verifies "Mid Cap Value Fund 5" field has "placeholder" Value "0.00%"
#    Then User Enters "100.25" in field "Mid Cap Value Fund 5"
#    Then User verifies "Mid Cap Value Fund 5" field has Prefilled Value "100.25%"
#    Then User verify max length of field "Mid Cap Value Fund 5" is "100"
#    Then User Enters "98.012" in field "Mid Cap Value Fund 5"
#    Then User verifies "Mid Cap Value Fund 5" field has Prefilled Value "98.01%"
#    Then User verifies "Small Cap Value Fund 1" field has "placeholder" Value "0.00%"
#    Then User Enters "abc" in field "Small Cap Value Fund 1"
#    Then User verifies "Small Cap Value Fund 1" field has "placeholder" Value "0.00%"
#    Then User Enters "!@#$" in field "Small Cap Value Fund 1"
#    Then User verifies "Small Cap Value Fund 1" field has "placeholder" Value "0.00%"
#    Then User Enters "100.25" in field "Small Cap Value Fund 1"
#    Then User verifies "Small Cap Value Fund 1" field has Prefilled Value "100.25%"
#    Then User verify max length of field "Small Cap Value Fund 1" is "100"
#    Then User Enters "98.012" in field "Small Cap Value Fund 1"
#    Then User verifies "Small Cap Value Fund 1" field has Prefilled Value "98.01%"
#    Then User verifies "Small Cap Value Fund 2" field has "placeholder" Value "0.00%"
#    Then User Enters "abc" in field "Small Cap Value Fund 2"
#    Then User verifies "Small Cap Value Fund 2" field has "placeholder" Value "0.00%"
#    Then User Enters "!@#$" in field "Small Cap Value Fund 2"
#    Then User verifies "Small Cap Value Fund 2" field has "placeholder" Value "0.00%"
#    Then User Enters "100.25" in field "Small Cap Value Fund 2"
#    Then User verifies "Small Cap Value Fund 2" field has Prefilled Value "100.25%"
#    Then User verify max length of field "Small Cap Value Fund 2" is "100"
#    Then User Enters "98.012" in field "Small Cap Value Fund 2"
#    Then User verifies "Small Cap Value Fund 2" field has Prefilled Value "98.01%"
#    Then User verifies "Small Cap Value Fund 3" field has "placeholder" Value "0.00%"
#    Then User Enters "abc" in field "Small Cap Value Fund 3"
#    Then User verifies "Small Cap Value Fund 3" field has "placeholder" Value "0.00%"
#    Then User Enters "!@#$" in field "Small Cap Value Fund 3"
#    Then User verifies "Small Cap Value Fund 3" field has "placeholder" Value "0.00%"
#    Then User Enters "100.25" in field "Small Cap Value Fund 3"
#    Then User verifies "Small Cap Value Fund 3" field has Prefilled Value "100.25%"
#    Then User verify max length of field "Small Cap Value Fund 3" is "100"
#    Then User Enters "98.012" in field "Small Cap Value Fund 3"
#    Then User verifies "Small Cap Value Fund 3" field has Prefilled Value "98.01%"
#    Then User verifies "Small Cap Value Fund 4" field has "placeholder" Value "0.00%"
#    Then User Enters "abc" in field "Small Cap Value Fund 4"
#    Then User verifies "Small Cap Value Fund 4" field has "placeholder" Value "0.00%"
#    Then User Enters "!@#$" in field "Small Cap Value Fund 4"
#    Then User verifies "Small Cap Value Fund 4" field has "placeholder" Value "0.00%"
#    Then User Enters "100.25" in field "Small Cap Value Fund 4"
#    Then User verifies "Small Cap Value Fund 4" field has Prefilled Value "100.25%"
#    Then User verify max length of field "Small Cap Value Fund 4" is "100"
#    Then User Enters "98.012" in field "Small Cap Value Fund 4"
#    Then User verifies "Small Cap Value Fund 4" field has Prefilled Value "98.01%"
#    Then User verifies "Small Cap Value Fund 5" field has "placeholder" Value "0.00%"
#    Then User Enters "abc" in field "Small Cap Value Fund 5"
#    Then User verifies "Small Cap Value Fund 5" field has "placeholder" Value "0.00%"
#    Then User Enters "!@#$" in field "Small Cap Value Fund 5"
#    Then User verifies "Small Cap Value Fund 5" field has "placeholder" Value "0.00%"
#    Then User Enters "100.25" in field "Small Cap Value Fund 5"
#    Then User verifies "Small Cap Value Fund 5" field has Prefilled Value "100.25%"
#    Then User verify max length of field "Small Cap Value Fund 5" is "100"
#    Then User Enters "98.012" in field "Small Cap Value Fund 5"
#    Then User verifies "Small Cap Value Fund 5" field has Prefilled Value "98.01%"
#    Then User Enters "5" in field "Bond Fund 1"
#    Then User Enters "2.45" in field "Bond Fund 2"
#    Then User Enters "0.00" in field "Bond Fund 3"
#    Then User Enters "6.68" in field "Bond Fund 4"
#    Then User Enters "0.00" in field "Bond Fund 5"
#    Then User Enters "2.99" in field "International Fund 1"
#    Then User Enters "0.00" in field "International Fund 2"
#    Then User Enters "4.96" in field "International Fund 3"
#    Then User Enters "0.00" in field "International Fund 4"
#    Then User Enters "6.88" in field "International Fund 5"
#    Then User Enters "8.86" in field "Large Cap Value Fund 1"
#    Then User Enters "0.00" in field "Large Cap Value Fund 2"
#    Then User Enters "5.89" in field "Large Cap Value Fund 3"
#    Then User Enters "7.00" in field "Large Cap Value Fund 4"
#    Then User Enters "0.00" in field "Large Cap Value Fund 5"
#    Then User Enters "0.00" in field "Mid Cap Value Fund 1"
#    Then User Enters "9.69" in field "Mid Cap Value Fund 2"
#    Then User Enters "5.68" in field "Mid Cap Value Fund 3"
#    Then User Enters "6.89" in field "Mid Cap Value Fund 4"
#    Then User Enters "6.99" in field "Mid Cap Value Fund 5"
#    Then User Enters "0.00" in field "Small Cap Value Fund 1"
#    Then User Enters "5.88" in field "Small Cap Value Fund 2"
#    Then User Enters "8.89" in field "Small Cap Value Fund 3"
#    Then User Enters "2.99" in field "Small Cap Value Fund 4"
#    Then User Enters "0.84" in field "Small Cap Value Fund 5"
#    Then User verifies "Fund_Allocation_Total" is "readonly" field
#    Then User verifies "Fund_Allocation_Total" TextBox has Prefilled Value "98.56%"
#    Then User verifies Validation Message for
#      | Field          | Id              | data-dataitemid        | Locator Type | Validation Error                        |
#      | Fund Allocation | FundAllocation | Fund_Allocation_Total  | Input        | Allocations must total 100% but are currently 98.56%. |
#    Then User Enters "2.84" in field "Small Cap Value Fund 5"
#    Then User verifies "Fund_Allocation_Total" TextBox has Prefilled Value "100.56%"
#    Then User verifies Validation Message for
#      | Field          | Id              | data-dataitemid        | Locator Type | Validation Error                        |
#      | Fund Allocation | FundAllocation | Fund_Allocation_Total  | Input        | Allocations must total 100% but are currently 100.56%. |
#    Then User Enters "2.28" in field "Small Cap Value Fund 5"
#    Then User verifies "Fund_Allocation_Total" TextBox has Prefilled Value "100.00%"
#    Then User clicks "Previous" button
#    Then User verifies Page heading "Fund Allocation Module" with form name "Fund Allocation" for data entry flow
#    Then User verifies "Bond Fund 1" field has Prefilled Value "6"
#    Then User verifies "Bond Fund 2" field has Prefilled Value "1"
#    Then User verifies "Bond Fund 3" field has Prefilled Value "2"
#    Then User verifies "Bond Fund 4" field has Prefilled Value "3"
#    Then User verifies "Bond Fund 5" field has Prefilled Value "4"
#    Then User verifies "International Fund 1" field has Prefilled Value "2"
#    Then User verifies "International Fund 2" field has Prefilled Value "3"
#    Then User verifies "International Fund 3" field has Prefilled Value "1"
#    Then User verifies "International Fund 4" field has Prefilled Value "5"
#    Then User verifies "International Fund 5" field has Prefilled Value "7"
#    Then User verifies "Large Cap Value Fund 1" field has Prefilled Value "2.2"
#    Then User verifies "Large Cap Value Fund 2" field has Prefilled Value "5.6"
#    Then User verifies "Large Cap Value Fund 3" field has Prefilled Value "3"
#    Then User verifies "Large Cap Value Fund 4" field has Prefilled Value "6"
#    Then User verifies "Large Cap Value Fund 5" field has Prefilled Value "9"
#    Then User verifies "Mid Cap Value Fund 1" field has Prefilled Value "1"
#    Then User verifies "Mid Cap Value Fund 2" field has Prefilled Value "2"
#    Then User verifies "Mid Cap Value Fund 3" field has Prefilled Value "1"
#    Then User verifies "Mid Cap Value Fund 4" field has Prefilled Value "2"
#    Then User verifies "Mid Cap Value Fund 5" field has Prefilled Value "1"
#    Then User verifies "Small Cap Value Fund 1" field has Prefilled Value "2"
#    Then User verifies "Small Cap Value Fund 2" field has Prefilled Value "4"
#    Then User verifies "Small Cap Value Fund 3" field has Prefilled Value "6"
#    Then User verifies "Small Cap Value Fund 4" field has Prefilled Value "8"
#    Then User verifies "Small Cap Value Fund 5" field has Prefilled Value "13"
#    Then User verifies "Total_Initial_Investment_Allocation_Percentage" TextBox has Prefilled Value "100%"
#    Then User Verifies checkbox "I elect Automatic Asset Rebalancing" is "checked"
#    Then User Verifies value "Semi-Annual" for field "Frequency"
#    Then User verifies "StartDate" TextBox has Prefilled Value "03/12/2024"
#    Then User Verifies checkbox "I elect Dollar Cost Averaging" is "checked"
#    Then User Verifies value "Quarterly" for field "DollarCostAverage_Frequency"
#    Then User Verifies value "15 Months" for field "Duration"
#    Then User verifies "Amount" TextBox has Prefilled Value "$254,531.00"
#    Then User clicks "Next" button
#    Then User verifies Page heading "Fund Allocation Module" with form name "Fund Allocation" for data entry flow
#    Then User verifies "Bond Fund 1" field has Prefilled Value "5.00%"
#    Then User verifies "Bond Fund 2" field has Prefilled Value "2.45%"
#    Then User verifies "Bond Fund 3" field has "placeholder" Value "0.00%"
#    Then User verifies "Bond Fund 4" field has Prefilled Value "6.68%"
#    Then User verifies "Bond Fund 5" field has "placeholder" Value "0.00%"
#    Then User verifies "International Fund 1" field has Prefilled Value "2.99%"
#    Then User verifies "International Fund 2" field has "placeholder" Value "0.00%"
#    Then User verifies "International Fund 3" field has Prefilled Value "4.96%"
#    Then User verifies "International Fund 4" field has "placeholder" Value "0.00%"
#    Then User verifies "International Fund 5" field has Prefilled Value "6.88%"
#    Then User verifies "Large Cap Value Fund 1" field has Prefilled Value "8.86%"
#    Then User verifies "Large Cap Value Fund 2" field has "placeholder" Value "0.00%"
#    Then User verifies "Large Cap Value Fund 3" field has Prefilled Value "5.89%"
#    Then User verifies "Large Cap Value Fund 4" field has Prefilled Value "7.00%"
#    Then User verifies "Large Cap Value Fund 5" field has "placeholder" Value "0.00%"
#    Then User verifies "Mid Cap Value Fund 1" field has "placeholder" Value "0.00%"
#    Then User verifies "Mid Cap Value Fund 2" field has Prefilled Value "9.69%"
#    Then User verifies "Mid Cap Value Fund 3" field has Prefilled Value "5.68%"
#    Then User verifies "Mid Cap Value Fund 4" field has Prefilled Value "6.89%"
#    Then User verifies "Mid Cap Value Fund 5" field has Prefilled Value "6.99%"
#    Then User verifies "Small Cap Value Fund 1" field has "placeholder" Value "0.00%"
#    Then User verifies "Small Cap Value Fund 2" field has Prefilled Value "5.88%"
#    Then User verifies "Small Cap Value Fund 3" field has Prefilled Value "8.89%"
#    Then User verifies "Small Cap Value Fund 4" field has Prefilled Value "2.99%"
#    Then User verifies "Small Cap Value Fund 5" field has Prefilled Value "2.28%"
#    Then User verifies "Fund_Allocation_Total" TextBox has Prefilled Value "100.00%"
#    Then User clicks "Next" button
#    Then User verifies Page heading "Fund Allocation Module" with form name "Product Features" for data entry flow
#    Then User Verifies "I elect Automatic Asset Rebalancing" is "displayed" under "Automatic Asset Rebalancing" on page
#    Then User Verifies "Frequency" is "displayed" under "Automatic Asset Rebalancing" on page
#    Then User Verifies "Start Date" is "displayed" under "Automatic Asset Rebalancing" on page
#    Then User Verifies "I elect Dollar Cost Averaging" is "displayed" under "Dollar Cost Averaging (DCA)" on page
#    Then User Verifies "Frequency" is "displayed" under "Dollar Cost Averaging (DCA)" on page
#    Then User Verifies "Duration" is "displayed" under "Dollar Cost Averaging (DCA)" on page
#    Then User Verifies "Percent" is "not displayed" under "Dollar Cost Averaging (DCA)" on page
#    Then User Verifies "Amount" is "displayed" under "Dollar Cost Averaging (DCA)" on page
#    Then User Verifies checkbox "I elect Automatic Asset Rebalancing" is "checked"
#    Then User Verifies value "Semi-Annual" for field "Frequency"
#    Then User verifies "StartDate" TextBox has Prefilled Value "03/12/2024"
#    Then User Verifies checkbox "I elect Dollar Cost Averaging" is "checked"
#    Then User Verifies value "Quarterly" for field "DollarCostAverage_Frequency"
#    Then User Verifies value "15 Months" for field "Duration"
#    Then User verifies "Amount" TextBox has Prefilled Value "$254,531.00"
#    Then User clicks "Previous" button
#    Then User verifies Page heading "Fund Allocation Module" with form name "Fund Allocation" for data entry flow
#    Then User verifies "Bond Fund 1" field has Prefilled Value "5.00%"
#    Then User verifies "Bond Fund 2" field has Prefilled Value "2.45%"
#    Then User verifies "Bond Fund 3" field has "placeholder" Value "0.00%"
#    Then User verifies "Bond Fund 4" field has Prefilled Value "6.68%"
#    Then User verifies "Bond Fund 5" field has "placeholder" Value "0.00%"
#    Then User verifies "International Fund 1" field has Prefilled Value "2.99%"
#    Then User verifies "International Fund 2" field has "placeholder" Value "0.00%"
#    Then User verifies "International Fund 3" field has Prefilled Value "4.96%"
#    Then User verifies "International Fund 4" field has "placeholder" Value "0.00%"
#    Then User verifies "International Fund 5" field has Prefilled Value "6.88%"
#    Then User verifies "Large Cap Value Fund 1" field has Prefilled Value "8.86%"
#    Then User verifies "Large Cap Value Fund 2" field has "placeholder" Value "0.00%"
#    Then User verifies "Large Cap Value Fund 3" field has Prefilled Value "5.89%"
#    Then User verifies "Large Cap Value Fund 4" field has Prefilled Value "7.00%"
#    Then User verifies "Large Cap Value Fund 5" field has "placeholder" Value "0.00%"
#    Then User verifies "Mid Cap Value Fund 1" field has "placeholder" Value "0.00%"
#    Then User verifies "Mid Cap Value Fund 2" field has Prefilled Value "9.69%"
#    Then User verifies "Mid Cap Value Fund 3" field has Prefilled Value "5.68%"
#    Then User verifies "Mid Cap Value Fund 4" field has Prefilled Value "6.89%"
#    Then User verifies "Mid Cap Value Fund 5" field has Prefilled Value "6.99%"
#    Then User verifies "Small Cap Value Fund 1" field has "placeholder" Value "0.00%"
#    Then User verifies "Small Cap Value Fund 2" field has Prefilled Value "5.88%"
#    Then User verifies "Small Cap Value Fund 3" field has Prefilled Value "8.89%"
#    Then User verifies "Small Cap Value Fund 4" field has Prefilled Value "2.99%"
#    Then User verifies "Small Cap Value Fund 5" field has Prefilled Value "2.28%"
#    Then User verifies "Fund_Allocation_Total" TextBox has Prefilled Value "100.00%"
#    Then User clicks "Next" button
#    Then User verifies Page heading "Fund Allocation Module" with form name "Product Features" for data entry flow
#    Then User Verifies "I elect Automatic Asset Rebalancing" is "displayed" under "Automatic Asset Rebalancing" on page
#    Then User Verifies "Frequency" is "displayed" under "Automatic Asset Rebalancing" on page
#    Then User Verifies "Start Date" is "displayed" under "Automatic Asset Rebalancing" on page
#    Then User Verifies "I elect Dollar Cost Averaging" is "displayed" under "Dollar Cost Averaging (DCA)" on page
#    Then User Verifies "Frequency" is "displayed" under "Dollar Cost Averaging (DCA)" on page
#    Then User Verifies "Duration" is "displayed" under "Dollar Cost Averaging (DCA)" on page
#    Then User Verifies "Percent" is "not displayed" under "Dollar Cost Averaging (DCA)" on page
#    Then User Verifies "Amount" is "displayed" under "Dollar Cost Averaging (DCA)" on page
#    Then User Verifies checkbox "I elect Automatic Asset Rebalancing" is "checked"
#    Then User Verifies value "Semi-Annual" for field "Frequency"
#    Then User verifies "StartDate" TextBox has Prefilled Value "03/12/2024"
#    Then User Verifies checkbox "I elect Dollar Cost Averaging" is "checked"
#    Then User Verifies value "Quarterly" for field "DollarCostAverage_Frequency"
#    Then User Verifies value "15 Months" for field "Duration"
#    Then User verifies "Amount" TextBox has Prefilled Value "$254,531.00"
    Then User clicks "Next" button
    Then User verifies Page heading "Agent Module" with form name "Agent/Advisor" for data entry flow















