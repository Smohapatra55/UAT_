Feature: FireLight_End2End_Tests

  This feature will verify UAT Application End2End Tests

  @End2EndTest
  Scenario: TC_01_Complete the REACT application with Pre Signature Review with Signature Then Submit
    Given User is on FireLight login page for TestCase "End2End_TC_01"
    Then User on Login Page enters valid username as "Ashwani_FBW" and password and clicks Login button
    Then User clicks "Application" Tab
    Then User selects Jurisdiction "Alabama"
    Then User selects Product Type Dropdown "Variable Annuity"
    Then User opens Given Product "Variable Annuity" for application
    Then User Verifies Heading "Variable Annuity"
    Then User clicks "Create" button
    Then User enters new Application name
    Then User clicks on Create button on Rename window
    Then User opens "Agent/Advisor" Required for Form "Agent Module"
    Then User verifies Page heading "Agent Module" with form name "Agent/Advisor" for data entry flow
    Then User verifies Agent Information is displayed on Agent Module Header
    Then User Verifies options present for Dropdown
      | Field                  | Id                  | data-dataitemid     | Locator Type | Option |
      | Total Number of Agents | TotalNumberofAgents | Total_Agents_Number | Select       | 1      |
      | Total Number of Agents | TotalNumberofAgents | Total_Agents_Number | Select       | 2      |
    Then User Chooses Blank option for Dropdown "Total Number of Agents" having id "TotalNumberofAgents" or DataItemId "Total_Agents_Number"
    Then User verifies Validation Message for
      | Field                  | Id                  | data-dataitemid     | Locator Type | Validation Error        |
      | Total Number of Agents | TotalNumberofAgents | Total_Agents_Number | Select       | Total Number of Agents is required. |
    Then User Chooses option for Dropdown
      | Field                  | Id                  | data-dataitemid     | Locator Type | Option |
      | Total Number of Agents | TotalNumberofAgents | Total_Agents_Number | Select       | 1      |
    Then User Verifies options present for Dropdown
      | Field             | Id               | data-dataitemid        | Locator Type | Option |
      | Commission Option | CommissionOption | Agent_CommissionOption | Select       | A      |
      | Commission Option | CommissionOption | Agent_CommissionOption | Select       | B      |
      | Commission Option | CommissionOption | Agent_CommissionOption | Select       | C      |
      | Commission Option | CommissionOption | Agent_CommissionOption | Select       | D      |
    Then User Chooses Blank option for Dropdown "Commission Option" having id "CommissionOption" or DataItemId "Agent_CommissionOption"
    Then User verifies Validation Message for
      | Field             | Id               | data-dataitemid        | Locator Type | Validation Error               |
      | Commission Option | CommissionOption | Agent_CommissionOption | Select       | Commission Option is required. |
    Then User sets data for the field
      | Field      | Value       | Id        | data-dataitemid | Locator Type |
      | Commission Option | C | CommissionOption | Agent_CommissionOption | Select       |
    Then User verifies prefilled form
      | Field      | Value       | data-dataitemid | Locator Type |
      | First Name | Ashwani_FBW | Agent_FirstName | Input        |
    Then User Clears data for the field
      | Field      | Id        | data-dataitemid | Locator Type |
      | First Name | FirstName | Agent_FirstName | Input        |
    Then User verifies Validation Message for
      | Field      | Id        | data-dataitemid | Locator Type | Validation Error              |
      | First Name | FirstName | Agent_FirstName | Input        | Agent First Name is required. |
    Then User sets data for the field
      | Field      | Value       | Id        | data-dataitemid | Locator Type |
      | First Name | Arnold | FirstName | Agent_FirstName | Input        |
    Then User sets data for the field
      | Field       | Value | Id         | data-dataitemid  | Locator Type |
      | Middle Name | SHIV     | MiddleName | Agent_MiddleName | Input        |
    Then User verifies "MiddleName" TextBox has Prefilled Value "S"
    Then User verify "maxlength" of field "MiddleName" is "1"
    Then User sets data for the field
      | Field       | Value | Id         | data-dataitemid  | Locator Type |
      | Middle Name | M     | MiddleName | Agent_MiddleName | Input        |
    Then User verifies Validation Message for
      | Field     | Id       | data-dataitemid | Locator Type | Validation Error             |
      | Last Name | LastName | Agent_LastName  | Input        | Agent Last Name is required. |
    Then User sets data for the field
      | Field     | Value           | Id       | data-dataitemid | Locator Type |
      | Last Name | Agent Last Name | LastName | Agent_LastName  | Input        |
    Then User verifies Validation Message for
      | Field                | Id                 | data-dataitemid | Locator Type | Validation Error                  |
      | Agent License Number | AgentLicenseNumber | Agent_IDNumber  | Input        | Agent License Number is required. |
    Then User sets data for the field
      | Field                | Value   | Id                 | data-dataitemid | Locator Type |
      | Agent License Number | 6478590 | AgentLicenseNumber | Agent_IDNumber  | Input        |
    Then User sets data for the field
      | Field                  | Value                   | Id                    | data-dataitemid       | Locator Type |
      | CRD Number             | 34523                   | CRDNumber             | Agent_CRDNumber       | Input        |
    Then User verifies prefilled form
      | Field      | Value | data-dataitemid | Locator Type |
      | CRD Number | 34523 | Agent_CRDNumber | Input        |
    Then User verifies Validation Message for
      | Field               | Value | Id        | data-dataitemid | Locator Type |Validation Error|
      | Agent License Number |       | NPNNumber | Agent_NPNNumber | Input        |  Agent NPN Number is required.|
    Then User sets data for the field
      | Field                | Value | Id        | data-dataitemid | Locator Type |
      | Agent License Number | 57687 | NPNNumber | Agent_NPNNumber | Input        |
    Then User verifies Validation Message for
      | Field    |Value | Id       | data-dataitemid | Locator Type |Validation Error|
      | Firm Name |     |FirmName | Agent_FirmName  | Input        |  Agent Firm Name is required.|
    Then User sets data for the field
      | Field    |Value | Id       | data-dataitemid | Locator Type |
      | Firm Name |  Hexure   |FirmName | Agent_FirmName  | Input        |
    Then User sets data for the field
      | Field        | Value          | Id          | data-dataitemid           | Locator Type |
      | Phone Number | (abc) def-abcd | PhoneNumber | Agent_Primary_PhoneNumber | Input        |
    Then User verifies "PhoneNumber" TextBox has Prefilled Value ""
    Then User sets data for the field
      | Field        | Value          | Id          | data-dataitemid           | Locator Type |
      | Phone Number | (645) 767-8686 | PhoneNumber | Agent_Primary_PhoneNumber | Input        |
    Then User verifies prefilled form
      | Field        | Value          | data-dataitemid           | Locator Type |
      | Phone Number | (645) 767-8686 | Agent_Primary_PhoneNumber | Input        |
    Then User sets data for the field
      | Field         | Value     | Id           | data-dataitemid            | Locator Type |
      | Email Address | shiv777 | EmailAddress | Agent_Primary_EmailAddress | Input        |
    Then User verifies Validation Message for
      | Field         | Value | Id           | data-dataitemid            | Locator Type | Validation Error                    |
      | Email Address |       | EmailAddress | Agent_Primary_EmailAddress | Input        | Please enter a valid Email address. |
    Then User sets data for the field
      | Field         | Value         | Id           | data-dataitemid            | Locator Type |
      | Email Address | abcd@gmail.com | EmailAddress | Agent_Primary_EmailAddress | Input        |
    Then User Clears data for the field
      | Field      | Id         | data-dataitemid       | Locator Type |
      | Percentage | Percentage | Agent_CommissionSplit | Input        |
    Then User verifies Validation Message for
      | Field      | Value | Id         | data-dataitemid       | Locator Type | Validation Error                   |
      | Percentage |       | Percentage | Agent_CommissionSplit | Input        | Commission Percentage is required. |
    Then User sets data for the field
      | Field      | Value | Id         | data-dataitemid       | Locator Type |
      | Percentage |  56     | Percentage | Agent_CommissionSplit | Input        |
    Then User verifies Validation Message for
      | Field      | Value | Id         | data-dataitemid       | Locator Type | Validation Error                   |
      | Percentage |       | Percentage | Agent_CommissionSplit | Input        | Agent Commission Total must equal 100%. |
    Then User sets data for the field
      | Field      | Value | Id         | data-dataitemid       | Locator Type |
      | Percentage |  105     | Percentage | Agent_CommissionSplit | Input        |
    Then User verifies Validation Message for
      | Field      | Value | Id         | data-dataitemid       | Locator Type | Validation Error                   |
      | Percentage |       | Percentage | Agent_CommissionSplit | Input        | Agent Commission Total must equal 100%. |
    Then User sets data for the field
      | Field      | Value | Id         | data-dataitemid       | Locator Type |
      | Percentage |  100     | Percentage | Agent_CommissionSplit | Input        |
    Then User clicks red bubble icon
    Then User verifies Validation Message for Radio Button
      | Field                                                                        | Id | data-dataitemid        | Locator Type | RadioButtonType | Validation Error              |
      | Are you aware of any existing annuities or insurance owned by the applicant? |    | Agent_ExistingPolicies | Div          | Yes             | Either Yes or No is required. |
    Then User verifies Validation Message for Radio Button
      | Field                                                                        | Id | data-dataitemid        | Locator Type | RadioButtonType | Validation Error              |
      | Are you aware of any existing annuities or insurance owned by the applicant? |    | Agent_ExistingPolicies | Div          | No              | Either Yes or No is required. |
    Then User Selects "Yes" Radio Button for Field "Are you aware of any existing annuities or insurance owned by the applicant?"
      | data-dataitemid        |
      | Agent_ExistingPolicies |
    Then User verifies Validation Message for Radio Button
      | Field                                                                                                         | Id | data-dataitemid      | Locator Type | RadioButtonType | Validation Error              |
      | Will the applied for contract replace, discontinue or change any existing life insurance or annuity contract? |    | Agent_ChangePolicies | Div          | Yes             | Either Yes or No is required. |
    Then User verifies Validation Message for Radio Button
      | Field                                                                                                         | Id | data-dataitemid      | Locator Type | RadioButtonType | Validation Error              |
      | Will the applied for contract replace, discontinue or change any existing life insurance or annuity contract? |    | Agent_ChangePolicies | Div          | No              | Either Yes or No is required. |
    Then User Selects "Yes" Radio Button for Field "Will the applied for contract replace, discontinue or change any existing life insurance or annuity contract?"
      | data-dataitemid      |
      | Agent_ChangePolicies |












