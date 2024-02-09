Feature: FireLight_End2End_Tests

  This feature will verify UAT Application End2End Tests

  @End2EndTest1
  Scenario: TC_01_Complete the REACT application with Pre Signature Review with Signature Then Submit
    Given User is on FireLight login page for TestCase "End2End_TC_01"
    Then User on Login Page enters valid username as "Ashwani_FBW" and password and clicks Login button
    Then User clicks "Application" Tab
    Then User verifies "Create New Application" window showing
    Then User Verifies Default Option is "Select Jurisdiction" for dropdown "Jurisdiction"
      | Field        | Id           | data-dataitemid | Locator Type |
      | Jurisdiction | Jurisdiction |                 | Select       |
    Then User Verifies Default Option is "All" for dropdown "Product Type"
      | Field        | Id          | data-dataitemid | Locator Type |
      | Product Type | ProductType |                 | Select       |
    Then User selects Jurisdiction "Alabama"
    Then User verifies the list of products is displayed
    Then User selects Product Type Dropdown "Variable Annuity"
    Then User selects Given Product "Variable Annuity"
    Then User Verifies Heading "Variable Annuity"
    Then User clicks "Create" button
    Then User Verifies heading as Create Activity
    Then User enters new Application name
    Then User clicks on Create button on Rename window
    Then User verifies Page heading "Annuity Owner Module" with form name "Client Data" for data entry flow
#    Then User opens "Client Data" Required for Form "Annuity Owner Module"
#    Then User verifies Page heading "Annuity Owner Module" with form name "Client Data" for data entry flow
    Then User Verifies options present for Dropdown
      | Field      | Id        | data-dataitemid | Locator Type | Option      |
      | Owner Type | OwnerType | Owner_Type      | Select       | Individual  |
      | Owner Type | OwnerType | Owner_Type      | Select       | Joint       |
      | Owner Type | OwnerType | Owner_Type      | Select       | Trust       |
      | Owner Type | OwnerType | Owner_Type      | Select       | Custodian   |
      | Owner Type | OwnerType | Owner_Type      | Select       | Corporation |
#    Then User verifies Validation Message for
#      | Field     | Id        | data-dataitemid | Locator Type | Validation Error        |
#      | OwnerType | OwnerType | Owner_Type      | Select       | Owner Type is required. |
    Then User Chooses Blank option for Dropdown "Owner Type" having id "OwnerType" or DataItemId "Owner_Type"
    Then User verifies Validation Message for
      | Field      | Id        | data-dataitemid | Locator Type | Validation Error        |
      | Owner Type | OwnerType | Owner_Type      | Select       | Owner Type is required. |
    Then User Chooses option for Dropdown
      | Field      | Id        | data-dataitemid | Locator Type | Option     |
      | Owner Type | OwnerType | Owner_Type      | Select       | Individual |
    Then User Verifies options present for Dropdown
      | Field     | Id       | data-dataitemid          | Locator Type | Option          |
      | Plan Type | PlanType | Annuity_TaxQualification | Select       | Non-Qualified   |
      | Plan Type | PlanType | Annuity_TaxQualification | Select       | Traditional IRA |
      | Plan Type | PlanType | Annuity_TaxQualification | Select       | Roth IRA        |
      | Plan Type | PlanType | Annuity_TaxQualification | Select       | SEP IRA         |
    Then User Chooses Blank option for Dropdown "Plan Type" having id "PlanType" or DataItemId "Annuity_TaxQualification"
    Then User verifies Validation Message for
      | Field     | Id       | data-dataitemid          | Locator Type | Validation Error       |
      | Plan Type | PlanType | Annuity_TaxQualification | Select       | Plan Type is required. |
    Then User Chooses option for Dropdown
      | Field     | Id       | data-dataitemid          | Locator Type | Option        |
      | Plan Type | PlanType | Annuity_TaxQualification | Select       | Non-Qualified |
    Then User Selects "Yes" Radio Button for Field "Is the annuitant the same as the owner?"
      | data-dataitemid       |
      | Annuitant_SameAsOwner |
    Then User Unchecks "Yes" Radio Button for Field "Is the annuitant the same as the owner?"
      | data-dataitemid       |
      | Annuitant_SameAsOwner |
    Then User verifies Validation Message for Radio Button
      | Field                                   | Id | data-dataitemid       | Locator Type | RadioButtonType | Validation Error                     |
      | Is the annuitant the same as the owner? |    | Annuitant_SameAsOwner | Div          | Yes             | Annuitant same as Owner is required. |
    Then User Selects "No" Radio Button for Field "Is the annuitant the same as the owner?"
      | data-dataitemid       |
      | Annuitant_SameAsOwner |
    Then User Selects "No" Radio Button for Field "Is there a joint annuitant?"
      | data-dataitemid    |
      | JointAnnuitant_Add |
    Then User opens "Annuitant(s)" Required for Form "Annuitant Module"
    Then User Verifies Joint Annuitant field is not displayed
    Then User opens "Client Data" Optional for Form "Annuity Owner Module"
    Then User Unchecks "No" Radio Button for Field "Is there a joint annuitant?"
      | data-dataitemid    |
      | JointAnnuitant_Add |
    Then User verifies Validation Message for Radio Button
      | Field                       | Id | data-dataitemid    | Locator Type | RadioButtonType | Validation Error                        |
      | Is there a joint annuitant? |    | JointAnnuitant_Add | Div          | No              | Is there a Joint Annuitant is required. |
    Then User Selects "Yes" Radio Button for Field "Is there a joint annuitant?"
      | data-dataitemid    |
      | JointAnnuitant_Add |
    Then User opens "Annuitant(s)" Required for Form "Annuitant Module"
    Then User Verifies Joint Annuitant field is displayed
    Then User verifies text fields Present in UI
      | Field         | Id | data-item-id                | Locator Type |
      | First Name    |    | JointAnnuitant_FirstName    | Input        |
      | Middle Name   |    | JointAnnuitant_MiddleName   | Input        |
      | Last Name     |    | JointAnnuitant_LastName     | Input        |
      | Date of Birth |    | JointAnnuitant_DOB          | Input        |
      | SSN           |    | JointAnnuitant_SSN          | Input        |
      | Gender        |    | JointAnnuitant_Gender       | Select       |
      | Relationship  |    | JointAnnuitant_Relationship | Select       |
    Then User opens "Owner(s)" Required for Form "Annuity Owner Module"
    Then User verifies Page heading "Annuity Owner Module" with form name "Owner(s)" for data entry flow
    Then User verifies Validation Message for
      | Field     | Id        | data-dataitemid | Locator Type | Validation Error        |
      | First Name | FirstName | Owner_FirstName | Input        | First Name is required. |
    Then User verifies Validation Message for
      | Field     | Id        | data-dataitemid | Locator Type | Validation Error        |
      | Last Name | LastName | Owner_LastName | Input        | Last Name is required. |
    Then User sets data for the field
      | Field              | Value        |Id| data-dataitemid   | Locator Type |
      | Owner First Name   | OwnerFName   |  |Owner_FirstName   | Input        |
      | Owner Last Name    | OwnerLName   |  |Owner_LastName    | Input        |