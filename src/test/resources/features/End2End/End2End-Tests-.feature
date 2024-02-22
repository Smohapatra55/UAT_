Feature: FireLight_End2End_Tests

  This feature will verify UAT Application End2End Tests

  @End2EndTest
  Scenario: TC_01_Complete UAT application Data Entry for client Fidelity Automation
    Given User is on FireLight login page for TestCase "End2End_TC_01"
    Then User on Login Page enters valid username as "Ashwani_FBW" and password and clicks Login button
    Then User clicks "Application" Tab
    Then User verifies "Create New Application" window showing
    Then User Verifies "Jurisdiction" field is present
    Then User Verifies "ProductType" field is present
    Then User Verifies Default Option is "Select Jurisdiction" for dropdown "Jurisdiction"
      | Field        | Id           | data-dataitemid | Locator Type |
      | Jurisdiction | Jurisdiction |                 | Select       |
    Then User Verifies Default Option is "All" for dropdown "Product Type"
      | Field        | Id          | data-dataitemid | Locator Type |
      | Product Type | ProductType |                 | Select       |
    Then User selects Jurisdiction "Alabama"
    Then User verifies the list of products is displayed
    Then User selects Product Type Dropdown "Variable Annuity"
    Then User opens Given Product "Variable Annuity" for application
    Then User Verifies Heading "Variable Annuity"
    Then User clicks "Create" button
    Then User Verifies heading as Create Activity
    Then User verifies "Create" Button
    Then User verifies "Cancel" Button
    Then User enters new Application name
    Then User clicks on Create button on Rename window
    Then User verifies New Application gets created
    Then User verifies Page heading "Annuity Owner Module" with form name "Client Data" for data entry flow
    Then User Verifies Blank option present for Dropdown
      | Field      | Id        | data-dataitemid | Locator Type |
      | Owner Type | OwnerType | Owner_Type      | Select       |
    Then User Verifies options present for Dropdown
      | Field      | Id        | data-dataitemid | Locator Type | Option      |
      | Owner Type | OwnerType | Owner_Type      | Select       | Individual  |
      | Owner Type | OwnerType | Owner_Type      | Select       | Joint       |
      | Owner Type | OwnerType | Owner_Type      | Select       | Trust       |
      | Owner Type | OwnerType | Owner_Type      | Select       | Custodian   |
      | Owner Type | OwnerType | Owner_Type      | Select       | Corporation |
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
    Then User verifies fields Present in UI
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
      | Field      | Id        | data-dataitemid | Locator Type | Validation Error        |
      | First Name | FirstName | Owner_FirstName | Input        | First Name is required. |
    Then User verifies Validation Message for
      | Field     | Id       | data-dataitemid | Locator Type | Validation Error       |
      | Last Name | LastName | Owner_LastName  | Input        | Last Name is required. |
    Then User sets data for the field
      | Field             | Value  | Id | data-dataitemid  | Locator Type |
      | Owner First Name  | John |    | Owner_FirstName  | Input        |
      | Owner Middle Name | D      |    | Owner_MiddleName | Input        |
      | Owner Last Name   | Luffy  |    | Owner_LastName   | Input        |
    Then User clicks red bubble icon
    Then User verifies Validation Message for
      | Field         | Id          | data-dataitemid | Locator Type | Validation Error        |
      | Date of Birth | DateofBirth | Owner_DOB       | Input        | Birth Date is required. |
    Then User clicks red bubble icon
    Then User select start date in future from date picker
    Then User sets data for the field
      | Field         | Value      | Id          | data-dataitemid | Locator Type |
      | Date of Birth | 10/11/2065 | DateofBirth | Owner_DOB       | Input        |
    Then User verifies Validation Message for
      | Field         | Id          | data-dataitemid | Locator Type | Validation Error               |
      | Date of Birth | DateofBirth | Owner_DOB       | Input        | Owner DOB must be in the past. |
    Then User sets data for the field
      | Field         | Value      | Id          | data-dataitemid | Locator Type |
      | Date of Birth | 10/11/1965 | DateofBirth | Owner_DOB       | Input        |
    Then User verifies Validation Message for
      | Field | Id  | data-dataitemid | Locator Type | Validation Error       |
      | SSN   | SSN | Owner_SSN       | Input        | Owner SSN is required. |
    Then User sets data for the field
      | Field | Value | Id  | data-dataitemid | Locator Type |
      | SSN   | SSN   | SSN | Owner_SSN       | Input        |
    Then User verifies prefilled data Form input text fields should be blank
      | Field | Id  | data-dataitemid | Locator Type |
      | SSN   | SSN | Owner_SSN       | Input        |
    Then User sets data for the field
      | Field | Value     | Id  | data-dataitemid | Locator Type |
      | SSN   | 545017855 | SSN | Owner_SSN       | Input        |
    Then User Verifies Blank option present for Dropdown
      | Field        | Id     | data-dataitemid | Locator Type |
      | Owner Gender | Gender | Owner_Gender    | Select       |
    Then User Verifies options present for Dropdown
      | Field        | Id     | data-dataitemid | Locator Type | Option |
      | Owner Gender | Gender | Owner_Gender    | Select       | Male   |
      | Owner Gender | Gender | Owner_Gender    | Select       | Female |
    Then User Chooses Blank option for Dropdown "Owner Gender" having id "Gender" or DataItemId "Owner_Gender"
    Then User verifies Validation Message for
      | Field        | Id     | data-dataitemid | Locator Type | Validation Error    |
      | Owner Gender | Gender | Owner_Gender    | Select       | Gender is required. |
    Then User Chooses option for Dropdown
      | Field        | Id     | data-dataitemid | Locator Type | Option |
      | Owner Gender | Gender | Owner_Gender    | Select       | Male   |
    Then User verifies Validation Message for
      | Field                  | Id                   | data-dataitemid       | Locator Type | Validation Error                  |
      | Mailing Address Street | MailingAddressStreet | Owner_MailingAddress1 | Input        | Owner Street Address is required. |
    Then User sets data for the field
      | Field                  | Value                   | Id                    | data-dataitemid       | Locator Type |
      | Mailing Address Street | Enetai Avenue Northeast | MMailingAddressStreet | Owner_MailingAddress1 | Input        |
    Then User verifies Validation Message for
      | Field | Id   | data-dataitemid           | Locator Type | Validation Error        |
      | City  | City | Owner_MailingAddress_City | Input        | Owner City is required. |
    Then User sets data for the field
      | Field | Value  | Id   | data-dataitemid           | Locator Type |
      | City  | Tacoma | City | Owner_MailingAddress_City | Input        |
    Then User Chooses Blank option for Dropdown "State" having id "State" or DataItemId "Owner_MailingAddress_State"
    Then User verifies Validation Message for
      | Field | Id    | data-dataitemid            | Locator Type | Validation Error         |
      | State | State | Owner_MailingAddress_State | Select       | Owner State is required. |
    Then User Chooses option for Dropdown
      | Field | Id    | data-dataitemid            | Locator Type | Option |
      | State | State | Owner_MailingAddress_State | Select       | WA     |
    Then User verifies Validation Message for
      | Field       | Id         | data-dataitemid              | Locator Type | Validation Error               |
      | Postal Code | PostalCode | Owner_MailingAddress_Zipcode | Input        | Owner Postal Code is required. |
    Then User sets data for the field
      | Field       | Value | Id         | data-dataitemid              | Locator Type |
      | Postal Code | 98422 | PostalCode | Owner_MailingAddress_Zipcode | Input        |
    Then User "check" checkbox "Mailing Address is different than Residential Address"
    Then User verifies fields Present in UI
      | Field                      | Id                       | data-item-id                     | Locator Type |
      | Residential Address Lookup |                          | Owner_ResidentialAddress_Lookup  | Input        |
      | Residential Address Street |  | Owner_ResidentialAddress1        | Input        |
      | City                       |                          | Owner_ResidentialAddress_City    | Input        |
      | Postal Code                |                          | Owner_ResidentialAddress_Zipcode | Input        |
      | State                      |                          | Owner_ResidentialAddress_State   | Select       |
    Then User "Uncheck" checkbox "Mailing Address is different than Residential Address"
    Then User Verifies checkbox "Mailing Address is different than Residential Address" is "unchecked"
    Then User verifies fields is not Present in UI
      | Field                      | Id                       | data-item-id                     | Locator Type |
      | Residential Address Lookup |                          | Owner_ResidentialAddress_Lookup  | Input        |
      | Residential Address Street |  | Owner_ResidentialAddress1        | Input        |
      | City                       |                          | Owner_ResidentialAddress_City    | Input        |
      | Postal Code                |                          | Owner_ResidentialAddress_Zipcode | Input        |
      | State                      |                          | Owner_ResidentialAddress_State   | Select       |
    Then User "check" checkbox "Mailing Address is different than Residential Address"
    Then User verifies Validation Message for
      | Field                      | Id                       | data-dataitemid           | Locator Type | Validation Error                  |
      | Residential Address Street | ResidentialAddressStreet | Owner_ResidentialAddress1 | Input        | Owner Street Address is required. |
    Then User sets data for the field
      | Field                      | Value               | Id                       | data-dataitemid           | Locator Type |
      | Residential Address Street | ENorth Allen Avenue | ResidentialAddressStreet | Owner_ResidentialAddress1 | Input        |
    Then User verifies Validation Message for
      | Field | Id | data-dataitemid               | Locator Type | Validation Error        |
      | City  |    | Owner_ResidentialAddress_City | Input        | Owner City is required. |
    Then User sets data for the field
      | Field | Value   | Id | data-dataitemid               | Locator Type |
      | City  | Chicago |    | Owner_ResidentialAddress_City | Input        |
    Then User Chooses Blank option for Dropdown "State" having id "" or DataItemId "Owner_ResidentialAddress_State"
    Then User verifies Validation Message for
      | Field | Id | data-dataitemid                | Locator Type | Validation Error         |
      | State |    | Owner_ResidentialAddress_State | Select       | Owner State is required. |
    Then User Chooses option for Dropdown
      | Field | Id | data-dataitemid                | Locator Type | Option |
      | State |    | Owner_ResidentialAddress_State | Select       | IL     |
    Then User verifies Validation Message for
      | Field       | Id | data-dataitemid                  | Locator Type | Validation Error               |
      | Postal Code |    | Owner_ResidentialAddress_Zipcode | Input        | Owner Postal Code is required. |
    Then User sets data for the field
      | Field       | Value      | Id | data-dataitemid                  | Locator Type |
      | Postal Code | 606184464  |    | Owner_ResidentialAddress_Zipcode | Input        |
    Then User verifies Validation Message for
      | Field                | Id                 | data-dataitemid           | Locator Type | Validation Error                |
      | Primary Phone Number | PrimaryPhoneNumber | Owner_Primary_PhoneNumber | Input        | Owner Phone Number is required. |
    Then User sets data for the field
      | Field                | Value  | Id                 | data-dataitemid           | Locator Type |
      | Primary Phone Number | 678453 | PrimaryPhoneNumber | Owner_Primary_PhoneNumber | Input        |
    Then User verifies prefilled data Form input text fields should be blank
      | Field                | Id                 | data-dataitemid           | Locator Type |
      | Primary Phone Number | PrimaryPhoneNumber | Owner_Primary_PhoneNumber | Input        |
    Then User sets data for the field
      | Field                | Value | Id                 | data-dataitemid           | Locator Type |
      | Primary Phone Number | Shiba | PrimaryPhoneNumber | Owner_Primary_PhoneNumber | Input        |
    Then User verifies prefilled data Form input text fields should be blank
      | Field                | Id                 | data-dataitemid           | Locator Type |
      | Primary Phone Number | PrimaryPhoneNumber | Owner_Primary_PhoneNumber | Input        |
    Then User sets data for the field
      | Field                | Value      | Id                 | data-dataitemid           | Locator Type |
      | Primary Phone Number | 4646464464 | PrimaryPhoneNumber | Owner_Primary_PhoneNumber | Input        |
    Then User sets data for the field
      | Field         | Value | Id           | data-dataitemid            | Locator Type |
      | Email Address | Shiba | EmailAddress | Owner_Primary_EmailAddress | Input        |
    Then User verifies Validation Message for
      | Field         | Id           | data-dataitemid            | Locator Type | Validation Error                    |
      | Email Address | EmailAddress | Owner_Primary_EmailAddress | Input        | Please enter a valid Email address. |
    Then User sets data for the field
      | Field         | Value            | Id           | data-dataitemid            | Locator Type |
      | Email Address | testdata@fbw.com | EmailAddress | Owner_Primary_EmailAddress | Input        |
    Then User Verifies "Yes" Radio Button for Field "U.S. Citizen"
      | data-dataitemid  |
      | Owner_Citizen_US |
    Then User Verifies "No" Radio Button for Field "U.S. Citizen"
      | data-dataitemid  |
      | Owner_Citizen_US |
    Then User verifies Validation Message for Radio Button
      | Field        | Id | data-dataitemid  | Locator Type | RadioButtonType | Validation Error                 |
      | U.S. Citizen |    | Owner_Citizen_US | Div          | Yes             | U.S. Citizen answer is required. |
    Then User Selects "Yes" Radio Button for Field "U.S. Citizen"
      | data-dataitemid  |
      | Owner_Citizen_US |
    Then User Clicks on Button "Previous"
    Then User verifies Page heading "Annuity Owner Module" with form name "Client Data" for data entry flow
    Then User verifies prefilled form
      | Field      | Value         | data-dataitemid          | Locator Type |
      | Owner Type | Individual    | Owner_Type               | Select       |
      | Plan Type  | Non-Qualified | Annuity_TaxQualification | Select       |
    Then User Verifies "No" Radio Button for Field "Is the annuitant the same as the owner?" is "Selected"
      | data-dataitemid       |
      | Annuitant_SameAsOwner |
    Then User Verifies "Yes" Radio Button for Field "Is there a joint annuitant?" is "Selected"
      | data-dataitemid    |
      | JointAnnuitant_Add |
    Then User Clicks on Button "Next"
    Then User verifies Page heading "Annuity Owner Module" with form name "Owner(s)" for data entry flow
    Then User verifies prefilled form
      | Field                      | Value                   | data-dataitemid                | Locator Type |
      | Owner First Name           | John                  | Owner_FirstName                | Input        |
      | Owner Middle Name          | D                       | Owner_MiddleName               | Input        |
      | Owner Last Name            | Luffy                   | Owner_LastName                 | Input        |
      | Owner Dob                  | 10/11/1965              | Owner_DOB                      | Input        |
      | Owner SSN                  | 545-01-7855             | Owner_SSN                      | Input        |
      | Owner Gender               | Male                    | Owner_Gender                   | Select       |
      | Mailing Address Street     | Enetai Avenue Northeast | Owner_MailingAddress1          | Input        |
      | City                       | Tacoma                  | Owner_MailingAddress_City      | Input        |
      | State                      | WA                      | Owner_MailingAddress_State     | Select       |
      | Residential Address Street | ENorth Allen Avenue     | Owner_ResidentialAddress1      | Input        |
      | City                       | Chicago                 | Owner_ResidentialAddress_City  | Input        |
      | State                      | IL                      | Owner_ResidentialAddress_State | Select       |
      | Primary Phone Number       | (464) 646-4464          | Owner_Primary_PhoneNumber      | Input        |
      | Email Address              | testdata@fbw.com        | Owner_Primary_EmailAddress     | Input        |
    Then User Verifies "Yes" Radio Button for Field "U.S. Citizen" is "Selected"
      | data-dataitemid  |
      | Owner_Citizen_US |
    Then User Clicks on Button "Next"
    Then User verifies Page heading "Annuitant Module" with form name "Annuitant(s)" for data entry flow
    Then User verifies Validation Message for
      | Field      | Id        | data-dataitemid     | Locator Type | Validation Error                  |
      | First Name | FirstName | Annuitant_FirstName | Input        | Annuitant First Name is required. |
    Then User verifies Validation Message for
      | Field     | Id       | data-dataitemid    | Locator Type | Validation Error                 |
      | Last Name | LastName | Annuitant_LastName | Input        | Annuitant Last Name is required. |
    Then User sets data for the field
      | Field       | Value  | Id | data-dataitemid      | Locator Type |
      | First Name  | Steven |    | Annuitant_FirstName  | Input        |
      | Middle Name | K      |    | Annuitant_MiddleName | Input        |
      | Last Name   | Smith  |    | Annuitant_LastName   | Input        |
    Then User clicks red bubble icon
    Then User verifies Validation Message for
      | Field         | Id          | data-dataitemid | Locator Type | Validation Error           |
      | Date of Birth | DateofBirth | Annuitant_DOB   | Input        | Annuitant DOB is required. |
    Then User clicks red bubble icon
    Then User select start date in future from date picker
    Then User sets data for the field
      | Field         | Value      | Id          | data-dataitemid | Locator Type |
      | Date of Birth | 10/11/2095 | DateofBirth | Annuitant_DOB   | Input        |
    Then User verifies Validation Message for
      | Field         | Id          | data-dataitemid | Locator Type | Validation Error                   |
      | Date of Birth | DateofBirth | Annuitant_DOB   | Input        | Annuitant DOB must be in the past. |
    Then User sets data for the field
      | Field         | Value      | Id          | data-dataitemid | Locator Type |
      | Date of Birth | 10/11/1995 | DateofBirth | Annuitant_DOB   | Input        |
    Then User verifies Validation Message for
      | Field | Id  | data-dataitemid | Locator Type | Validation Error           |
      | SSN   | SSN | Annuitant_SSN   | Input        | Annuitant SSN is required. |
    Then User sets data for the field
      | Field | Value | Id  | data-dataitemid | Locator Type |
      | SSN   | SSN   | SSN | Annuitant_SSN   | Input        |
    Then User verifies prefilled data Form input text fields should be blank
      | Field | Id  | data-dataitemid | Locator Type |
      | SSN   | SSN | Annuitant_SSN   | Input        |
    Then User sets data for the field
      | Field | Value     | Id  | data-dataitemid | Locator Type |
      | SSN   | 787664646 | SSN | Annuitant_SSN   | Input        |
    Then User Verifies Blank option present for Dropdown
      | Field        | Id     | data-dataitemid  | Locator Type |
      | Owner Gender | Gender | Annuitant_Gender | Select       |
    Then User Verifies options present for Dropdown
      | Field        | Id     | data-dataitemid  | Locator Type | Option |
      | Owner Gender | Gender | Annuitant_Gender | Select       | Male   |
      | Owner Gender | Gender | Annuitant_Gender | Select       | Female |
    Then User Chooses Blank option for Dropdown "Gender" having id "Gender" or DataItemId "Annuitant_Gender"
    Then User verifies Validation Message for
      | Field        | Id     | data-dataitemid  | Locator Type | Validation Error              |
      | Owner Gender | Gender | Annuitant_Gender | Select       | Annuitant Gender is required. |
    Then User Chooses option for Dropdown
      | Field        | Id     | data-dataitemid  | Locator Type | Option |
      | Owner Gender | Gender | Annuitant_Gender | Select       | Male   |
    Then User Verifies Blank option present for Dropdown
      | Field                 | Id                  | data-dataitemid        | Locator Type |
      | Relationship to Owner | RelationshiptoOwner | Annuitant_Relationship | Select       |
    Then User Verifies options present for Dropdown
      | Field                 | Id                  | data-dataitemid        | Locator Type | Option       |
      | Relationship to Owner | RelationshiptoOwner | Annuitant_Relationship | Select       | Spouse       |
      | Relationship to Owner | RelationshiptoOwner | Annuitant_Relationship | Select       | Child        |
      | Relationship to Owner | RelationshiptoOwner | Annuitant_Relationship | Select       | Parent       |
      | Relationship to Owner | RelationshiptoOwner | Annuitant_Relationship | Select       | Sibling      |
      | Relationship to Owner | RelationshiptoOwner | Annuitant_Relationship | Select       | Other        |
      | Relationship to Owner | RelationshiptoOwner | Annuitant_Relationship | Select       | Other Family |
    Then User Chooses Blank option for Dropdown "Relationship to Owner" having id "RelationshiptoOwner" or DataItemId "Annuitant_Relationship"
    Then User verifies Validation Message for
      | Field                 | Id                  | data-dataitemid        | Locator Type | Validation Error                             |
      | Relationship to Owner | RelationshiptoOwner | Annuitant_Relationship | Select       | Annuitant Relationship to Owner is required. |
    Then User Chooses option for Dropdown
      | Field                 | Id                  | data-dataitemid        | Locator Type | Option |
      | Relationship to Owner | RelationshiptoOwner | Annuitant_Relationship | Select       | Child  |
    Then User "check" checkbox "Same address as Owner" with data item Id "Annuitant_SameAsOwnerAddress"
    Then User verifies fields is not Present in UI
      | Field                  | Id | data-item-id                     | Locator Type |
      | Mailing Address Lookup |    | Annuitant_Address_Lookup         | Input        |
      | Mailing Address Street |    | Annuitant_MailingAddress1        | Input        |
      | City                   |    | Annuitant_MailingAddress_City    | Input        |
      | State                  |    | Annuitant_MailingAddress_State   | Select       |
      | Postal Code            |    | Annuitant_MailingAddress_Zipcode | Input        |
    Then User verifies Validation Message for
      | Field                | Id                 | data-dataitemid               | Locator Type | Validation Error                    |
      | Primary Phone Number | PrimaryPhoneNumber | Annuitant_Primary_PhoneNumber | Input        | Annuitant Phone Number is required. |
    Then User sets data for the field
      | Field                | Value  | Id                 | data-dataitemid               | Locator Type |
      | Primary Phone Number | 678453 | PrimaryPhoneNumber | Annuitant_Primary_PhoneNumber | Input        |
    Then User verifies prefilled data Form input text fields should be blank
      | Field                | Id                 | data-dataitemid               | Locator Type |
      | Primary Phone Number | PrimaryPhoneNumber | Annuitant_Primary_PhoneNumber | Input        |
    Then User sets data for the field
      | Field                | Value | Id                 | data-dataitemid               | Locator Type |
      | Primary Phone Number | Shiba | PrimaryPhoneNumber | Annuitant_Primary_PhoneNumber | Input        |
    Then User verifies prefilled data Form input text fields should be blank
      | Field                | Id                 | data-dataitemid               | Locator Type |
      | Primary Phone Number | PrimaryPhoneNumber | Annuitant_Primary_PhoneNumber | Input        |
    Then User sets data for the field
      | Field                | Value      | Id                 | data-dataitemid               | Locator Type |
      | Primary Phone Number | 4646464465 | PrimaryPhoneNumber | Annuitant_Primary_PhoneNumber | Input        |
    Then User sets data for the field
      | Field         | Value | Id           | data-dataitemid                | Locator Type |
      | Email Address | Shiba | EmailAddress | Annuitant_Primary_EmailAddress | Input        |
    Then User verifies Validation Message for
      | Field         | Id           | data-dataitemid                | Locator Type | Validation Error                                  |
      | Email Address | EmailAddress | Annuitant_Primary_EmailAddress | Input        | Please enter a valid Email address for Annuitant. |
    Then User sets data for the field
      | Field         | Value            | Id           | data-dataitemid                | Locator Type |
      | Email Address | testdata@fbw.com | EmailAddress | Annuitant_Primary_EmailAddress | Input        |
    Then User verifies Validation Message for
      | Field      | Id | data-dataitemid          | Locator Type | Validation Error                        |
      | First Name |    | JointAnnuitant_FirstName | Input        | Joint Annuitant First Name is required. |
    Then User verifies Validation Message for
      | Field     | Id | data-dataitemid         | Locator Type | Validation Error                       |
      | Last Name |    | JointAnnuitant_LastName | Input        | Joint Annuitant Last Name is required. |
    Then User sets data for the field
      | Field       | Value  | Id | data-dataitemid           | Locator Type |
      | First Name  | Cyborg |    | JointAnnuitant_FirstName  | Input        |
      | Middle Name | KIng   |    | JointAnnuitant_MiddleName | Input        |
      | Last Name   | Franky |    | JointAnnuitant_LastName   | Input        |
    Then User clicks red bubble icon
    Then User verifies Validation Message for
      | Field         | Id | data-dataitemid    | Locator Type | Validation Error                 |
      | Date of Birth |    | JointAnnuitant_DOB | Input        | Joint Annuitant DOB is required. |
    Then User clicks red bubble icon
    Then User select start date in future from date picker
    Then User sets data for the field
      | Field         | Value      | Id | data-dataitemid    | Locator Type |
      | Date of Birth | 10/11/2070 |    | JointAnnuitant_DOB | Input        |
    Then User verifies Validation Message for
      | Field         | Id | data-dataitemid    | Locator Type | Validation Error                         |
      | Date of Birth |    | JointAnnuitant_DOB | Input        | Joint Annuitant DOB must be in the past. |
    Then User sets data for the field
      | Field         | Value      | Id | data-dataitemid    | Locator Type |
      | Date of Birth | 10/11/1970 |    | JointAnnuitant_DOB | Input        |
    Then User verifies Validation Message for
      | Field | Id | data-dataitemid    | Locator Type | Validation Error                 |
      | SSN   |    | JointAnnuitant_SSN | Input        | Joint Annuitant SSN is required. |
    Then User sets data for the field
      | Field | Value | Id | data-dataitemid    | Locator Type |
      | SSN   | SSN   |    | JointAnnuitant_SSN | Input        |
    Then User verifies prefilled data Form input text fields should be blank
      | Field | Id | data-dataitemid    | Locator Type |
      | SSN   |    | JointAnnuitant_SSN | Input        |
    Then User sets data for the field
      | Field | Value     | Id | data-dataitemid    | Locator Type |
      | SSN   | 644597855 |    | JointAnnuitant_SSN | Input        |
    Then User Verifies Blank option present for Dropdown
      | Field  | Id | data-dataitemid       | Locator Type |
      | Gender |    | JointAnnuitant_Gender | Select       |
    Then User Verifies options present for Dropdown
      | Field  | Id | data-dataitemid       | Locator Type | Option |
      | Gender |    | JointAnnuitant_Gender | Select       | Male   |
      | Gender |    | JointAnnuitant_Gender | Select       | Female |
    Then User Chooses Blank option for Dropdown "Gender" having id "" or DataItemId "JointAnnuitant_Gender"
    Then User verifies Validation Message for
      | Field  | Id | data-dataitemid       | Locator Type | Validation Error                    |
      | Gender |    | JointAnnuitant_Gender | Select       | Joint Annuitant Gender is required. |
    Then User Chooses option for Dropdown
      | Field  | Id | data-dataitemid       | Locator Type | Option |
      | Gender |    | JointAnnuitant_Gender | Select       | Female |
    Then User Verifies Blank option present for Dropdown
      | Field                 | Id | data-dataitemid             | Locator Type |
      | Relationship to Owner |    | JointAnnuitant_Relationship | Select       |
    Then User Verifies options present for Dropdown
      | Field                 | Id | data-dataitemid             | Locator Type | Option       |
      | Relationship to Owner |    | JointAnnuitant_Relationship | Select       | Spouse       |
      | Relationship to Owner |    | JointAnnuitant_Relationship | Select       | Child        |
      | Relationship to Owner |    | JointAnnuitant_Relationship | Select       | Parent       |
      | Relationship to Owner |    | JointAnnuitant_Relationship | Select       | Sibling      |
      | Relationship to Owner |    | JointAnnuitant_Relationship | Select       | Other        |
      | Relationship to Owner |    | JointAnnuitant_Relationship | Select       | Other Family |
    Then User Chooses Blank option for Dropdown "Relationship to Owner" having id "" or DataItemId "JointAnnuitant_Relationship"
    Then User verifies Validation Message for
      | Field                 | Id | data-dataitemid             | Locator Type | Validation Error                                   |
      | Relationship to Owner |    | JointAnnuitant_Relationship | Select       | Joint Annuitant Relationship to Owner is required. |
    Then User Chooses option for Dropdown
      | Field                 | Id | data-dataitemid             | Locator Type | Option |
      | Relationship to Owner |    | JointAnnuitant_Relationship | Select       | Spouse |

    Then User "check" checkbox "Same address as owner" with data item Id "JointAnnuitant_SameAsOwnerAddress"
    Then User verifies fields is not Present in UI
      | Field                  | Id | data-item-id                          | Locator Type |
      | Mailing Address Lookup |    | JointAnnuitant_Address_Lookup         | Input        |
      | Mailing Address Street |    | JointAnnuitant_MailingAddress1        | Input        |
      | City                   |    | JointAnnuitant_MailingAddress_City    | Input        |
      | State                  |    | JointAnnuitant_MailingAddress_State   | Select       |
      | Postal Code            |    | JointAnnuitant_MailingAddress_Zipcode | Input        |
    Then User "uncheck" checkbox "Same address as owner" with data item Id "JointAnnuitant_SameAsOwnerAddress"
    Then User verifies fields Present in UI
      | Field                  | Id | data-item-id                          | Locator Type |
      | Mailing Address Lookup |    | JointAnnuitant_Address_Lookup         | Input        |
      | Mailing Address Street |    | JointAnnuitant_MailingAddress1        | Input        |
      | City                   |    | JointAnnuitant_MailingAddress_City    | Input        |
      | State                  |    | JointAnnuitant_MailingAddress_State   | Select       |
      | Postal Code            |    | JointAnnuitant_MailingAddress_Zipcode | Input        |
    Then User verifies Validation Message for
      | Field                  | Id | data-dataitemid                | Locator Type | Validation Error                            |
      | Mailing Address Street |    | JointAnnuitant_MailingAddress1 | Input        | Joint Annuitant Street Address is required. |
    Then User sets data for the field
      | Field                  | Value                  | Id | data-dataitemid                    | Locator Type |
      | Mailing Address Street | Carolina Place Parkway |    | JointAnnuitant_MailingAddress1 | Input        |
    Then User verifies Validation Message for
      | Field | Id | data-dataitemid                    | Locator Type | Validation Error                  |
      | City  |    | JointAnnuitant_MailingAddress_City | Input        | Joint Annuitant City is required. |
    Then User sets data for the field
      | Field | Value  | Id | data-dataitemid                    | Locator Type |
      | City  | Tacoma |    | JointAnnuitant_MailingAddress_City | Input        |
    Then User Chooses Blank option for Dropdown "State" having id "" or DataItemId "JointAnnuitant_MailingAddress_State"
    Then User verifies Validation Message for
      | Field | Id | data-dataitemid                     | Locator Type | Validation Error                   |
      | State |    | JointAnnuitant_MailingAddress_State | Select       | Joint Annuitant State is required. |
    Then User Chooses option for Dropdown
      | Field | Id | data-dataitemid                     | Locator Type | Option |
      | State |    | JointAnnuitant_MailingAddress_State | Select       | NC     |
    Then User verifies Validation Message for
      | Field       | Id | data-dataitemid                       | Locator Type | Validation Error                         |
      | Postal Code |    | JointAnnuitant_MailingAddress_Zipcode | Input        | Joint Annuitant Postal Code is required. |
    Then User sets data for the field
      | Field       | Value | Id | data-dataitemid                       | Locator Type |
      | Postal Code | 28134 |    | JointAnnuitant_MailingAddress_Zipcode | Input        |
    Then User "check" checkbox "Mailing Address is different than Residential Address" with data item Id "JointAnnuitant_MailingAddress_Different"
    Then User verifies fields Present in UI
      | Field                      | Id | data-item-id                              | Locator Type |
      | Residential Address Lookup |    | JointAnnuitant_ResidentialAddress_Lookup  | Input        |
      | Residential Address Street |    | JointAnnuitant_ResidentialAddress1        | Input        |
      | City                       |    | JointAnnuitant_ResidentialAddress_City    | Input        |
      | Postal Code                |    | JointAnnuitant_ResidentialAddress_Zipcode | Input        |
      | State                      |    | JointAnnuitant_ResidentialAddress_State   | Select       |
    Then User "Uncheck" checkbox "Mailing Address is different than Residential Address" with data item Id "JointAnnuitant_MailingAddress_Different"
    Then User verifies fields is not Present in UI
      | Field                      | Id | data-item-id                              | Locator Type |
      | Residential Address Lookup |    | JointAnnuitant_ResidentialAddress_Lookup  | Input        |
      | Residential Address Street |    | JointAnnuitant_ResidentialAddress1        | Input        |
      | City                       |    | JointAnnuitant_ResidentialAddress_City    | Input        |
      | Postal Code                |    | JointAnnuitant_ResidentialAddress_Zipcode | Input        |
      | State                      |    | JointAnnuitant_ResidentialAddress_State   | Select       |
    Then User "check" checkbox "Mailing Address is different than Residential Address" with data item Id "JointAnnuitant_MailingAddress_Different"
    Then User verifies Validation Message for
      | Field                      | Id | data-dataitemid                    | Locator Type | Validation Error                     |
      | Residential Address Street |    | JointAnnuitant_ResidentialAddress1 | Input        | Joint Annuitant Address is required. |
    Then User sets data for the field
      | Field                      | Value               | Id | data-dataitemid                    | Locator Type |
      | Residential Address Street | North Garland Court |    | JointAnnuitant_ResidentialAddress1 | Input        |
    Then User verifies Validation Message for
      | Field | Id | data-dataitemid                        | Locator Type | Validation Error                  |
      | City  |    | JointAnnuitant_ResidentialAddress_City | Input        | Joint Annuitant City is required. |
    Then User sets data for the field
      | Field | Value    | Id | data-dataitemid                        | Locator Type |
      | City  | Oak Park |    | JointAnnuitant_ResidentialAddress_City | Input        |
    Then User Chooses option for Dropdown
      | Field | Id | data-dataitemid                         | Locator Type | Option  |
      | State |    | JointAnnuitant_ResidentialAddress_State | Select       | IL |
    Then User Chooses Blank option for Dropdown "State" having id "" or DataItemId "JointAnnuitant_ResidentialAddress_State"
    Then User verifies Validation Message for
      | Field | Id | data-dataitemid                         | Locator Type | Validation Error                   |
      | State |    | JointAnnuitant_ResidentialAddress_State | Select       | Joint Annuitant State is required. |
    Then User Chooses option for Dropdown
      | Field | Id | data-dataitemid                         | Locator Type | Option  |
      | State |    | JointAnnuitant_ResidentialAddress_State | Select       | IL |
    Then User verifies Validation Message for
      | Field       | Id | data-dataitemid                           | Locator Type | Validation Error                         |
      | Postal Code |    | JointAnnuitant_ResidentialAddress_Zipcode | Input        | Joint Annuitant Postal Code is required. |
    Then User sets data for the field
      | Field       | Value | Id | data-dataitemid                           | Locator Type |
      | Postal Code | 28134 |    | JointAnnuitant_ResidentialAddress_Zipcode | Input        |
    Then User verifies Validation Message for
      | Field                | Id | data-dataitemid                    | Locator Type | Validation Error                          |
      | Primary Phone Number |    | JointAnnuitant_Primary_PhoneNumber | Input        | Joint Annuitant Phone Number is required. |
    Then User sets data for the field
      | Field                | Value  | Id | data-dataitemid                    | Locator Type |
      | Primary Phone Number | 678453 |    | JointAnnuitant_Primary_PhoneNumber | Input        |
    Then User verifies prefilled data Form input text fields should be blank
      | Field                | Id | data-dataitemid                    | Locator Type |
      | Primary Phone Number |    | JointAnnuitant_Primary_PhoneNumber | Input        |
    Then User sets data for the field
      | Field                | Value | Id | data-dataitemid                    | Locator Type |
      | Primary Phone Number | Shiba |    | JointAnnuitant_Primary_PhoneNumber | Input        |
    Then User verifies prefilled data Form input text fields should be blank
      | Field                | Id | data-dataitemid                    | Locator Type |
      | Primary Phone Number |    | JointAnnuitant_Primary_PhoneNumber | Input        |
    Then User sets data for the field
      | Field                | Value      | Id | data-dataitemid                    | Locator Type |
      | Primary Phone Number | 7864564464 |    | JointAnnuitant_Primary_PhoneNumber | Input        |
    Then User sets data for the field
      | Field         | Value | Id | data-dataitemid                     | Locator Type |
      | Email Address | Shiba |    | JointAnnuitant_Primary_EmailAddress | Input        |
    Then User verifies Validation Message for
      | Field         | Id | data-dataitemid                     | Locator Type | Validation Error                                        |
      | Email Address |    | JointAnnuitant_Primary_EmailAddress | Input        | Please enter a valid Email address for Joint Annuitant. |
    Then User sets data for the field
      | Field         | Value            | Id | data-dataitemid                     | Locator Type |
      | Email Address | testdata@jointann.com |    | JointAnnuitant_Primary_EmailAddress | Input        |
    Then User Clicks on Button "Previous"
    Then User verifies Page heading "Annuity Owner Module" with form name "Owner(s)" for data entry flow
    Then User verifies prefilled form
      | Field                      | Value                   | data-dataitemid                | Locator Type |
      | Owner First Name           | John                  | Owner_FirstName                | Input        |
      | Owner Middle Name          | D                       | Owner_MiddleName               | Input        |
      | Owner Last Name            | Luffy                   | Owner_LastName                 | Input        |
      | Owner Dob                  | 10/11/1965              | Owner_DOB                      | Input        |
      | Owner SSN                  | 545-01-7855             | Owner_SSN                      | Input        |
      | Owner Gender               | Male                    | Owner_Gender                   | Select       |
      | Mailing Address Street     | Enetai Avenue Northeast | Owner_MailingAddress1          | Input        |
      | City                       | Tacoma                  | Owner_MailingAddress_City      | Input        |
      | zip                        | 98422                   | Owner_MailingAddress_Zipcode   | Input        |
      | State                      | WA                      | Owner_MailingAddress_State     | Select       |
      | Residential Address Street | ENorth Allen Avenue     | Owner_ResidentialAddress1      | Input        |
      | City                       | Chicago                 | Owner_ResidentialAddress_City  | Input        |
      | State                      | IL                      | Owner_ResidentialAddress_State | Select       |
      | Primary Phone Number       | (464) 646-4464          | Owner_Primary_PhoneNumber      | Input        |
      | Email Address              | testdata@fbw.com        | Owner_Primary_EmailAddress     | Input        |
    Then User Clicks on Button "Next"
    Then User verifies Page heading "Annuitant Module" with form name "Annuitant(s)" for data entry flow
    Then User verifies prefilled form
      | Field                       | Value                 | data-dataitemid                           | Locator Type |
      | Annuitant First Name        | Steven                | Annuitant_FirstName                       | Input        |
      | Annuitant Middle Name       | K                     | Annuitant_MiddleName                      | Input        |
      | Annuitant Last Name         | Smith                 | Annuitant_LastName                        | Input        |
      | Annuitant Dob               | 10/11/1995            | Annuitant_DOB                             | Input        |
      | Annuitant SSN               | 787-66-4646           | Annuitant_SSN                             | Input        |
      | Annuitant Gender            | Male                  | Annuitant_Gender                          | Select       |
      | Joint Annuitant First Name  | Cyborg                | JointAnnuitant_FirstName                  | Input        |
      | Joint Annuitant Middle Name | KIng                  | JointAnnuitant_MiddleName                 | Input        |
      | Joint Annuitant Last Name   | Franky                | JointAnnuitant_LastName                   | Input        |
      | Joint Annuitant Dob         | 10/11/1970            | JointAnnuitant_DOB                        | Input        |
      | Joint Annuitant SSN         | 644-59-7855           | JointAnnuitant_SSN                        | Input        |
      | Joint Annuitant Gender      | Female                | JointAnnuitant_Gender                     | Select       |
      | Mailing Address Street      | Carolina Place Parkway   | JointAnnuitant_MailingAddress1            | Input        |
      | City                        | Tacoma               | JointAnnuitant_MailingAddress_City        | Input        |
      | zip                         | 28134                 | JointAnnuitant_MailingAddress_Zipcode     | Input        |
      | State                       | NC                    | JointAnnuitant_MailingAddress_State       | Select       |
      | Residential Address Street  | North Garland Court   | JointAnnuitant_ResidentialAddress1        | Input        |
      | City                        | Oak Park              | JointAnnuitant_ResidentialAddress_City    | Input        |
      | ZipCode                     | 28134                 | JointAnnuitant_ResidentialAddress_Zipcode | Input        |
      | State                       | IL               | JointAnnuitant_ResidentialAddress_State   | Select       |
      | Primary Phone Number        | (786) 456-4464        | JointAnnuitant_Primary_PhoneNumber        | Input        |
      | Email Address               | testdata@jointann.com | JointAnnuitant_Primary_EmailAddress       | Input        |
    Then User Clicks on Button "Next"
    Then User verifies Page heading "Beneficiary Module: Separate" with form name "Beneficiary" for data entry flow
    Then User Verifies Blank option present for Dropdown
      | Field                           | Id | data-dataitemid                          | Locator Type |
      | Number of Primary Beneficiaries |    | PrimaryBeneficiary_NumberofBeneficiaries | Select       |
    Then User Verifies options present for Dropdown
      | Field                           | Id                           | data-dataitemid                          | Locator Type | Option |
      | Number of Primary Beneficiaries | NumberofPrimaryBeneficiaries | PrimaryBeneficiary_NumberofBeneficiaries | Select       | 1      |
      | Number of Primary Beneficiaries | NumberofPrimaryBeneficiaries | PrimaryBeneficiary_NumberofBeneficiaries | Select       | 2      |
      | Number of Primary Beneficiaries | NumberofPrimaryBeneficiaries | PrimaryBeneficiary_NumberofBeneficiaries | Select       | 3      |
      | Number of Primary Beneficiaries | NumberofPrimaryBeneficiaries | PrimaryBeneficiary_NumberofBeneficiaries | Select       | 4      |
      | Number of Primary Beneficiaries | NumberofPrimaryBeneficiaries | PrimaryBeneficiary_NumberofBeneficiaries | Select       | 5      |
    Then User Chooses Blank option for Dropdown "Number of Primary Beneficiaries" having id "NumberofPrimaryBeneficiaries" or DataItemId "PrimaryBeneficiary_NumberofBeneficiaries"
    Then User verifies Validation Message for
      | Field                           | Id                           | data-dataitemid                          | Locator Type | Validation Error                             |
      | Number of Primary Beneficiaries | NumberofPrimaryBeneficiaries | PrimaryBeneficiary_NumberofBeneficiaries | Select       | Number of Primary Beneficiaries is required. |
    Then User Chooses option for Dropdown
      | Field                           | Id                           | data-dataitemid                          | Locator Type | Option |
      | Number of Primary Beneficiaries | NumberofPrimaryBeneficiaries | PrimaryBeneficiary_NumberofBeneficiaries | Select       | 2      |
    Then User Verifies "Primary Beneficiary 1" field should be displayed on UI
    Then User Verifies "Primary Beneficiary 2" field should be displayed on UI
    Then User Verifies Blank option present for Dropdown
      | Field          | Id | data-dataitemid            | Locator Type |
      | Living Person? |    | PrimaryBeneficiary_Natural | Select       |
    Then User Verifies options present for Dropdown
      | Field          | Id            | data-dataitemid            | Locator Type | Option |
      | Living Person? | LivingPerson? | PrimaryBeneficiary_Natural | Select       | Yes    |
      | Living Person? | LivingPerson? | PrimaryBeneficiary_Natural | Select       | No     |
    Then User Chooses Blank option for Dropdown "Living Person?" having id "LivingPerson?" or DataItemId "PrimaryBeneficiary_Natural"
    Then User verifies Validation Message for
      | Field          | Id            | data-dataitemid            | Locator Type | Validation Error                       |
      | Living Person? | LivingPerson? | PrimaryBeneficiary_Natural | Select       | Beneficiary Living Person is required. |
    Then User Chooses option for Dropdown
      | Field          | Id            | data-dataitemid            | Locator Type | Option |
      | Living Person? | LivingPerson? | PrimaryBeneficiary_Natural | Select       | Yes    |
    Then User verifies fields Present in UI
      | Field                  | Id | data-item-id                      | Locator Type |
      | First Name             |    | PrimaryBeneficiary_FirstName      | Input        |
      | Middle Name            |    | PrimaryBeneficiary_MiddleName     | Input        |
      | Last Name              |    | PrimaryBeneficiary_LastName       | Input        |
      | Date of Birth          |    | PrimaryBeneficiary_DOB            | Input        |
      | SSN                    |    | PrimaryBeneficiary_SSN            | Input        |
      | Gender                 |    | PrimaryBeneficiary_Gender         | Select       |
      | Mailing Address Lookup |    | PrimaryBeneficiary_Address_Lookup | Input        |
    Then User Verifies Blank option present for Dropdown
      | Field        | Id | data-dataitemid                 | Locator Type |
      | Relationship |    | PrimaryBeneficiary_Relationship | Select       |
    Then User Verifies options present for Dropdown
      | Field        | Id | data-dataitemid                 | Locator Type | Option                       |
      | Relationship |    | PrimaryBeneficiary_Relationship | Select       | Spouse                       |
      | Relationship |    | PrimaryBeneficiary_Relationship | Select       | Child                        |
      | Relationship |    | PrimaryBeneficiary_Relationship | Select       | Parent                       |
      | Relationship |    | PrimaryBeneficiary_Relationship | Select       | Sibling                      |
      | Relationship |    | PrimaryBeneficiary_Relationship | Select       | Other Family                 |
      | Relationship |    | PrimaryBeneficiary_Relationship | Select       | Other (Non-Natural Entities) |
    Then User Chooses Blank option for Dropdown "Relationship" having id "" or DataItemId "PrimaryBeneficiary_Relationship"
    Then User verifies Validation Message for
      | Field        | Id | data-dataitemid                 | Locator Type | Validation Error                      |
      | Relationship |    | PrimaryBeneficiary_Relationship | Select       | Beneficiary Relationship is required. |
    Then User Chooses option for Dropdown
      | Field        | Id | data-dataitemid                 | Locator Type | Option |
      | Relationship |    | PrimaryBeneficiary_Relationship | Select       | Parent |
    Then User verifies placeholder value for field
      | Field           | Placeholder | Id | data-item-id                  | Locator Type |
      | Primary Percent | 0.00%       |    | PrimaryBeneficiary_Percentage | Input        |
    Then User verifies Validation Message for
      | Field           | Id | data-dataitemid               | Locator Type | Validation Error                 |
      | Primary Percent |    | PrimaryBeneficiary_Percentage | Input        | Beneficiary Percent is required. |
    Then User sets data for the field
      | Field           | Value | Id | data-dataitemid               | Locator Type |
      | Primary Percent | 65    |    | PrimaryBeneficiary_Percentage | Input        |
    Then User verifies field accept decimal values upto two digits
      | Field           | Id | data-dataitemid               |
      | Primary Percent |    | PrimaryBeneficiary_Percentage |
    Then User verifies field accept only values between 1 to 100
      | Field           | Id | data-dataitemid               |
      | Primary Percent |    | PrimaryBeneficiary_Percentage |
    Then User verifies field becomes yellow in color if the entered value is below 100 percentage
      | Field           | Id | data-dataitemid               | Locator Type |
      | Primary Percent |    | PrimaryBeneficiary_Percentage | Input        |
    Then User verifies Validation Message for
      | Field      | Id | data-dataitemid              | Locator Type | Validation Error                    |
      | First Name |    | PrimaryBeneficiary_FirstName | Input        | Beneficiary First Name is required. |
      | Last Name  |    | PrimaryBeneficiary_LastName  | Input        | Beneficiary Last Name is required.  |
    Then User sets data for the field
      | Field       | Value  | Id | data-dataitemid               | Locator Type |
      | First Name  | Johns  |    | PrimaryBeneficiary_FirstName  | Input        |
      | Middle Name | N      |    | PrimaryBeneficiary_MiddleName | Input        |
      | Last Name   | Taylor |    | PrimaryBeneficiary_LastName   | Input        |
    Then User verifies fields Present in UI
      | Field         | Id | data-item-id           | Locator Type |
      | Date of Birth |    | PrimaryBeneficiary_DOB | Input        |
    Then User sets data for the field
      | Field         | Value      | Id | data-dataitemid        | Locator Type |
      | Date of Birth | 10/11/2070 |    | PrimaryBeneficiary_DOB | Input        |
    Then User verifies Validation Message for
      | Field         | Id | data-dataitemid        | Locator Type | Validation Error                         |
      | Date of Birth |    | PrimaryBeneficiary_DOB | Input        | Beneficiary DOB cannot be in the future. |
    Then User sets data for the field
      | Field         | Value      | Id | data-dataitemid        | Locator Type |
      | Date of Birth | 10/11/1960 |    | PrimaryBeneficiary_DOB | Input        |
    Then User sets data for the field
      | Field | Value | Id | data-dataitemid        | Locator Type |
      | SSN   | 45    |    | PrimaryBeneficiary_SSN | Input        |
    Then User verifies prefilled data Form input text fields should be blank
      | Field | Id | data-dataitemid        | Locator Type |
      | SSN   |    | PrimaryBeneficiary_SSN | Input        |
    Then User sets data for the field
      | Field | Value     | Id | data-dataitemid        | Locator Type |
      | SSN   | 545013243 |    | PrimaryBeneficiary_SSN | Input        |
    Then User Verifies Blank option present for Dropdown
      | Field  | Id | data-dataitemid           | Locator Type |
      | Gender |    | PrimaryBeneficiary_Gender | Select       |
    Then User Verifies options present for Dropdown
      | Field  | Id | data-dataitemid           | Locator Type | Option |
      | Gender |    | PrimaryBeneficiary_Gender | Select       | Male   |
      | Gender |    | PrimaryBeneficiary_Gender | Select       | Female |
    Then User Chooses Blank option for Dropdown "Gender" having id "" or DataItemId "PrimaryBeneficiary_Gender"
    Then User Chooses option for Dropdown
      | Field  | Id | data-dataitemid           | Locator Type | Option |
      | Gender |    | PrimaryBeneficiary_Gender | Select       | Female |
    Then User sets data for the field
      | Field                  | Value    | Id | data-dataitemid                   | Locator Type |
      | Mailing Address Lookup | carolina |    | PrimaryBeneficiary_Address_Lookup | Input        |
    Then User Selects Option for Lookup "Mailing Address Lookup"
      | Option                                     |
      | Carolina Place Parkway, Pineville, NC, USA |
    Then User sets data for the field
      | Field        | Value  | Id | data-dataitemid                        | Locator Type |
      | Phone Number | 422342 |    | PrimaryBeneficiary_Primary_PhoneNumber | Input        |
    Then User verifies prefilled data Form input text fields should be blank
      | Field        | Id | data-dataitemid                        | Locator Type |
      | Phone Number |    | PrimaryBeneficiary_Primary_PhoneNumber | Input        |
    Then User sets data for the field
      | Field        | Value | Id | data-dataitemid                        | Locator Type |
      | Phone Number | Jay   |    | PrimaryBeneficiary_Primary_PhoneNumber | Input        |
    Then User verifies prefilled data Form input text fields should be blank
      | Field        | Id | data-dataitemid                        | Locator Type |
      | Phone Number |    | PrimaryBeneficiary_Primary_PhoneNumber | Input        |
    Then User sets data for the field
      | Field        | Value      | Id | data-dataitemid                        | Locator Type |
      | Phone Number | 7864568752 |    | PrimaryBeneficiary_Primary_PhoneNumber | Input        |
    Then User sets data for the field
      | Field         | Value   | Id | data-dataitemid                         | Locator Type |
      | Email Address | JayTest |    | PrimaryBeneficiary_Primary_EmailAddress | Input        |
    Then User verifies Validation Message for
      | Field         | Id | data-dataitemid                         | Locator Type | Validation Error                    |
      | Email Address |    | PrimaryBeneficiary_Primary_EmailAddress | Input        | Please enter a valid Email Address. |
    Then User sets data for the field
      | Field         | Value                 | Id | data-dataitemid                         | Locator Type |
      | Email Address | testdata@primbene.com |    | PrimaryBeneficiary_Primary_EmailAddress | Input        |
    Then User Verifies Blank option present for Dropdown
      | Field          | Id | data-dataitemid             | Locator Type |
      | Living Person? |    | PrimaryBeneficiary2_Natural | Select       |
    Then User Verifies options present for Dropdown
      | Field          | Id | data-dataitemid             | Locator Type | Option |
      | Living Person? |    | PrimaryBeneficiary2_Natural | Select       | Yes    |
      | Living Person? |    | PrimaryBeneficiary2_Natural | Select       | No     |
    Then User Chooses Blank option for Dropdown "Living Person?" having id "" or DataItemId "PrimaryBeneficiary2_Natural"
    Then User verifies Validation Message for
      | Field          | Id | data-dataitemid             | Locator Type | Validation Error           |
      | Living Person? |    | PrimaryBeneficiary2_Natural | Select       | Living Person is required. |
    Then User Chooses option for Dropdown
      | Field          | Id | data-dataitemid             | Locator Type | Option |
      | Living Person? |    | PrimaryBeneficiary2_Natural | Select       | No     |
    Then User verifies fields Present in UI
      | Field      | Id | data-item-id                       | Locator Type |
      | Name       |    | PrimaryBeneficiary2_NonNaturalName | Input        |
      | Trust Date |    | PrimaryBeneficiary2_TrustDate      | Input        |
      | Tax ID     |    | PrimaryBeneficiary2_TIN            | Input        |
    Then User verifies prefilled form
      | Field        | Value                        | data-dataitemid                  | Locator Type |
      | Relationship | Other (Non-Natural Entities) | PrimaryBeneficiary2_Relationship | Select       |
    Then User verifies field is read only
      | Field        | data-dataitemid                  | Locator Type |
      | Relationship | PrimaryBeneficiary2_Relationship | Select       |
    Then User verifies placeholder value for field
      | Field           | Placeholder | Id | data-item-id                   | Locator Type |
      | Primary Percent | 0.00%       |    | PrimaryBeneficiary2_Percentage | Input        |
    Then User verifies Validation Message for
      | Field           | Id | data-dataitemid                | Locator Type | Validation Error                 |
      | Primary Percent |    | PrimaryBeneficiary2_Percentage | Input        | Beneficiary Percent is required. |
    Then User sets data for the field
      | Field           | Value | Id | data-dataitemid                | Locator Type |
      | Primary Percent | 35    |    | PrimaryBeneficiary2_Percentage | Input        |
    Then User verifies field accept decimal values upto two digits
      | Field           | Id | data-dataitemid                |
      | Primary Percent |    | PrimaryBeneficiary2_Percentage |
    Then User verifies field accept only values between 1 to 100
      | Field           | Id | data-dataitemid                |
      | Primary Percent |    | PrimaryBeneficiary2_Percentage |
    Then User verifies field becomes yellow in color if the entered value is below 100 percentage
      | Field           | Id | data-dataitemid                | Locator Type |
      | Primary Percent |    | PrimaryBeneficiary2_Percentage | Input        |
    Then User verifies Validation Message for
      | Field | Id | data-dataitemid                    | Locator Type | Validation Error              |
      | Name  |    | PrimaryBeneficiary2_NonNaturalName | Input        | Beneficiary Name is required. |
    Then User sets data for the field
      | Field | Value | Id | data-dataitemid                    | Locator Type |
      | Name  | Bruno |    | PrimaryBeneficiary2_NonNaturalName | Input        |
    Then User verifies Date Picker is Displayed for
      | Field      | Id | data-dataitemid               | Locator Type |
      | Trust Date |    | PrimaryBeneficiary2_TrustDate | Input        |
    Then User sets data for the field
      | Field      | Value      | Id | data-dataitemid               | Locator Type |
      | Trust Date | 10/11/2030 |    | PrimaryBeneficiary2_TrustDate | Input        |
    Then User verifies Validation Message for
      | Field      | Id | data-dataitemid               | Locator Type | Validation Error                                |
      | Trust Date |    | PrimaryBeneficiary2_TrustDate | Input        | Beneficiary Trust Date cannot be in the future. |
    Then User sets data for the field
      | Field      | Value      | Id | data-dataitemid               | Locator Type |
      | Trust Date | 10/11/1988 |    | PrimaryBeneficiary2_TrustDate | Input        |
    Then User sets data for the field
      | Field  | Value | Id | data-dataitemid         | Locator Type |
      | Tax ID | 4543  |    | PrimaryBeneficiary2_TIN | Input        |
    Then User verifies prefilled data Form input text fields should be blank
      | Field  | Id | data-dataitemid         | Locator Type |
      | Tax ID |    | PrimaryBeneficiary2_TIN | Input        |
    Then User sets data for the field
      | Field  | Value      | Id | data-dataitemid         | Locator Type |
      | Tax ID | 67-5757788 |    | PrimaryBeneficiary2_TIN | Input        |
    Then User sets data for the field
      | Field                  | Value    | Id | data-dataitemid                    | Locator Type |
      | Mailing Address Lookup | carolina |    | PrimaryBeneficiary2_Address_Lookup | Input        |
    Then User Selects Option for Lookup "Mailing Address Lookup"
      | Option                                     |
      | Carolina Place Parkway, Pineville, NC, USA |
    Then User sets data for the field
      | Field        | Value | Id | data-dataitemid                         | Locator Type |
      | Phone Number | 95839 |    | PrimaryBeneficiary2_Primary_PhoneNumber | Input        |
    Then User verifies prefilled data Form input text fields should be blank
      | Field        | Id | data-dataitemid                         | Locator Type |
      | Phone Number |    | PrimaryBeneficiary2_Primary_PhoneNumber | Input        |
    Then User sets data for the field
      | Field        | Value    | Id | data-dataitemid                         | Locator Type |
      | Phone Number | JayPhone |    | PrimaryBeneficiary2_Primary_PhoneNumber | Input        |
    Then User verifies prefilled data Form input text fields should be blank
      | Field        | Id | data-dataitemid                         | Locator Type |
      | Phone Number |    | PrimaryBeneficiary2_Primary_PhoneNumber | Input        |
    Then User sets data for the field
      | Field        | Value      | Id | data-dataitemid                         | Locator Type |
      | Phone Number | 6543789464 |    | PrimaryBeneficiary2_Primary_PhoneNumber | Input        |
    Then User sets data for the field
      | Field         | Value   | Id | data-dataitemid                          | Locator Type |
      | Email Address | JayTest |    | PrimaryBeneficiary2_Primary_EmailAddress | Input        |
    Then User verifies Validation Message for
      | Field         | Id | data-dataitemid                          | Locator Type | Validation Error                    |
      | Email Address |    | PrimaryBeneficiary2_Primary_EmailAddress | Input        | Please enter a valid Email Address. |
    Then User sets data for the field
      | Field         | Value       | Id | data-dataitemid                          | Locator Type |
      | Email Address | pb2@ann.com |    | PrimaryBeneficiary2_Primary_EmailAddress | Input        |
    Then User Verifies Blank option present for Dropdown
      | Field                              | Id | data-dataitemid                             | Locator Type |
      | Number of Contingent Beneficiaries |    | ContingentBeneficiary_NumberofBeneficiaries | Select       |
    Then User Verifies options present for Dropdown
      | Field                              | Id | data-dataitemid                             | Locator Type | Option |
      | Number of Contingent Beneficiaries |    | ContingentBeneficiary_NumberofBeneficiaries | Select       | 1      |
      | Number of Contingent Beneficiaries |    | ContingentBeneficiary_NumberofBeneficiaries | Select       | 2      |
      | Number of Contingent Beneficiaries |    | ContingentBeneficiary_NumberofBeneficiaries | Select       | 3      |
      | Number of Contingent Beneficiaries |    | ContingentBeneficiary_NumberofBeneficiaries | Select       | 4      |
      | Number of Contingent Beneficiaries |    | ContingentBeneficiary_NumberofBeneficiaries | Select       | 5      |
    Then User Verifies Default Option is "0" for dropdown "Number of Contingent Beneficiaries"
      | Field                              | Id | data-dataitemid                             | Locator Type |
      | Number of Contingent Beneficiaries |    | ContingentBeneficiary_NumberofBeneficiaries | Select       |
    Then User Chooses Blank option for Dropdown "Number of Contingent Beneficiaries" having id "" or DataItemId "ContingentBeneficiary_NumberofBeneficiaries"
    Then User Verifies Blank option present for Dropdown
      | Field                              | Id | data-dataitemid                             | Locator Type |
      | Number of Contingent Beneficiaries |    | ContingentBeneficiary_NumberofBeneficiaries | Select       |
    Then User Chooses option for Dropdown
      | Field                              | Id | data-dataitemid                             | Locator Type | Option |
      | Number of Contingent Beneficiaries |    | ContingentBeneficiary_NumberofBeneficiaries | Select       | 1      |
    Then User Verifies "Contingent Beneficiary 1" field should be displayed on UI

    Then User Verifies Blank option present for Dropdown
      | Field          | Id | data-dataitemid                | Locator Type |
      | Living Person? |    | ContingentBeneficiary1_Natural | Select       |
    Then User Verifies options present for Dropdown
      | Field          | Id | data-dataitemid                | Locator Type | Option |
      | Living Person? |    | ContingentBeneficiary1_Natural | Select       | Yes    |
      | Living Person? |    | ContingentBeneficiary1_Natural | Select       | No     |
    Then User Chooses Blank option for Dropdown "Living Person?" having id "" or DataItemId "ContingentBeneficiary1_Natural"
    Then User verifies Validation Message for
      | Field          | Id | data-dataitemid                | Locator Type | Validation Error                 |
      | Living Person? |    | ContingentBeneficiary1_Natural | Select       | Living Person must be Yes or No. |
    Then User Chooses option for Dropdown
      | Field          | Id | data-dataitemid                | Locator Type | Option |
      | Living Person? |    | ContingentBeneficiary1_Natural | Select       | Yes    |
    Then User verifies fields Present in UI
      | Field                  | Id | data-item-id                          | Locator Type |
      | First Name             |    | ContingentBeneficiary1_FirstName      | Input        |
      | Middle Name            |    | ContingentBeneficiary1_MiddleName     | Input        |
      | Last Name              |    | ContingentBeneficiary1_LastName       | Input        |
      | Date of Birth          |    | ContingentBeneficiary1_DOB            | Input        |
      | SSN                    |    | ContingentBeneficiary1_SSN            | Input        |
      | Gender                 |    | ContingentBeneficiary1_Gender         | Select       |
      | Mailing Address Lookup |    | ContingentBeneficiary1_Address_Lookup | Input        |
    Then User Verifies Blank option present for Dropdown
      | Field        | Id | data-dataitemid                     | Locator Type |
      | Relationship |    | ContingentBeneficiary1_Relationship | Select       |
    Then User Verifies options present for Dropdown
      | Field        | Id | data-dataitemid                     | Locator Type | Option                       |
      | Relationship |    | ContingentBeneficiary1_Relationship | Select       | Spouse                       |
      | Relationship |    | ContingentBeneficiary1_Relationship | Select       | Child                        |
      | Relationship |    | ContingentBeneficiary1_Relationship | Select       | Parent                       |
      | Relationship |    | ContingentBeneficiary1_Relationship | Select       | Sibling                      |
      | Relationship |    | ContingentBeneficiary1_Relationship | Select       | Other Family                 |
      | Relationship |    | ContingentBeneficiary1_Relationship | Select       | Other (Non-Natural Entities) |
    Then User Chooses Blank option for Dropdown "Relationship" having id "" or DataItemId "ContingentBeneficiary1_Relationship"
    Then User verifies Validation Message for
      | Field        | Id | data-dataitemid                     | Locator Type | Validation Error                      |
      | Relationship |    | ContingentBeneficiary1_Relationship | Select       | Beneficiary Relationship is required. |
    Then User Chooses option for Dropdown
      | Field        | Id | data-dataitemid                     | Locator Type | Option       |
      | Relationship |    | ContingentBeneficiary1_Relationship | Select       | Other Family |
    Then User verifies placeholder value for field
      | Field              | Placeholder | Id | data-item-id                      | Locator Type |
      | Contingent Percent | 0.00%       |    | ContingentBeneficiary1_Percentage | Input        |
    Then User verifies Validation Message for
      | Field              | Id | data-dataitemid                   | Locator Type | Validation Error                 |
      | Contingent Percent |    | ContingentBeneficiary1_Percentage | Input        | Beneficiary Percent is required. |
    Then User sets data for the field
      | Field              | Value | Id | data-dataitemid                   | Locator Type |
      | Contingent Percent | 65    |    | ContingentBeneficiary1_Percentage | Input        |
    Then User verifies field accept decimal values upto two digits
      | Field              | Id | data-dataitemid                   |
      | Contingent Percent |    | ContingentBeneficiary1_Percentage |
    Then User verifies field accept only values between 1 to 100
      | Field              | Id | data-dataitemid                   |
      | Contingent Percent |    | ContingentBeneficiary1_Percentage |
    Then User verifies field becomes yellow in color if the entered value is below 100 percentage
      | Field              | Id | data-dataitemid                   | Locator Type |
      | Contingent Percent |    | ContingentBeneficiary1_Percentage | Input        |
    Then User sets data for the field
      | Field              | Value | Id | data-dataitemid                   | Locator Type |
      | Contingent Percent | 100   |    | ContingentBeneficiary1_Percentage | Input        |
    Then User verifies Validation Message for
      | Field      | Id | data-dataitemid                  | Locator Type | Validation Error                    |
      | First Name |    | ContingentBeneficiary1_FirstName | Input        | Beneficiary First Name is required. |
      | Last Name  |    | ContingentBeneficiary1_LastName  | Input        | Beneficiary Last Name is required.  |
    Then User sets data for the field
      | Field       | Value | Id | data-dataitemid                   | Locator Type |
      | First Name  | Test  |    | ContingentBeneficiary1_FirstName  | Input        |
      | Middle Name | Ram   |    | ContingentBeneficiary1_MiddleName | Input        |
      | Last Name   | Dev   |    | ContingentBeneficiary1_LastName   | Input        |
    Then User verifies fields Present in UI
      | Field         | Id | data-item-id               | Locator Type |
      | Date of Birth |    | ContingentBeneficiary1_DOB | Input        |
    Then User verifies Date Picker is Displayed for
      | Field      | Id | data-dataitemid            | Locator Type |
      | Trust Date |    | ContingentBeneficiary1_DOB | Input        |
    Then User sets data for the field
      | Field         | Value      | Id | data-dataitemid            | Locator Type |
      | Date of Birth | 10/11/2040 |    | ContingentBeneficiary1_DOB | Input        |
    Then User verifies Validation Message for
      | Field         | Id | data-dataitemid            | Locator Type | Validation Error                         |
      | Date of Birth |    | ContingentBeneficiary1_DOB | Input        | Beneficiary DOB cannot be in the future. |
    Then User sets data for the field
      | Field         | Value      | Id | data-dataitemid            | Locator Type |
      | Date of Birth | 10/11/1980 |    | ContingentBeneficiary1_DOB | Input        |
    Then User sets data for the field
      | Field | Value | Id | data-dataitemid            | Locator Type |
      | SSN   | 567   |    | ContingentBeneficiary1_SSN | Input        |
    Then User verifies prefilled data Form input text fields should be blank
      | Field | Id | data-dataitemid            | Locator Type |
      | SSN   |    | ContingentBeneficiary1_SSN | Input        |
    Then User sets data for the field
      | Field | Value     | Id | data-dataitemid            | Locator Type |
      | SSN   | 546577855 |    | ContingentBeneficiary1_SSN | Input        |
    Then User Verifies Blank option present for Dropdown
      | Field  | Id | data-dataitemid               | Locator Type |
      | Gender |    | ContingentBeneficiary1_Gender | Select       |
    Then User Verifies options present for Dropdown
      | Field  | Id | data-dataitemid               | Locator Type | Option |
      | Gender |    | ContingentBeneficiary1_Gender | Select       | Male   |
      | Gender |    | ContingentBeneficiary1_Gender | Select       | Female |
    Then User Chooses Blank option for Dropdown "Gender" having id "" or DataItemId "ContingentBeneficiary1_Gender"
    Then User Chooses option for Dropdown
      | Field  | Id | data-dataitemid               | Locator Type | Option |
      | Gender |    | ContingentBeneficiary1_Gender | Select       | Female |
    Then User sets data for the field
      | Field                  | Value    | Id | data-dataitemid                       | Locator Type |
      | Mailing Address Lookup | carolina |    | ContingentBeneficiary1_Address_Lookup | Input        |
    Then User Selects Option for Lookup "Mailing Address Lookup"
      | Option                                     |
      | Carolina Place Parkway, Pineville, NC, USA |
    Then User sets data for the field
      | Field        | Value  | Id | data-dataitemid                            | Locator Type |
      | Phone Number | 324234 |    | ContingentBeneficiary1_Primary_PhoneNumber | Input        |
    Then User verifies prefilled data Form input text fields should be blank
      | Field        | Id | data-dataitemid                            | Locator Type |
      | Phone Number |    | ContingentBeneficiary1_Primary_PhoneNumber | Input        |
    Then User sets data for the field
      | Field        | Value | Id | data-dataitemid                            | Locator Type |
      | Phone Number | Jay   |    | ContingentBeneficiary1_Primary_PhoneNumber | Input        |
    Then User verifies prefilled data Form input text fields should be blank
      | Field        | Id | data-dataitemid                            | Locator Type |
      | Phone Number |    | ContingentBeneficiary1_Primary_PhoneNumber | Input        |
    Then User sets data for the field
      | Field        | Value      | Id | data-dataitemid                            | Locator Type |
      | Phone Number | 7864587264 |    | ContingentBeneficiary1_Primary_PhoneNumber | Input        |
    Then User sets data for the field
      | Field         | Value   | Id | data-dataitemid                             | Locator Type |
      | Email Address | JayTest |    | ContingentBeneficiary1_Primary_EmailAddress | Input        |
    Then User verifies Validation Message for
      | Field         | Id | data-dataitemid                             | Locator Type | Validation Error                    |
      | Email Address |    | ContingentBeneficiary1_Primary_EmailAddress | Input        | Please enter a valid Email Address. |
    Then User sets data for the field
      | Field         | Value             | Id | data-dataitemid                             | Locator Type |
      | Email Address | contbene@data.com |    | ContingentBeneficiary1_Primary_EmailAddress | Input        |
    Then User verifies field is read only
      | Field         | data-dataitemid                     | Locator Type |
      | Primary Total | PrimaryBeneficiary_Percentage_Total | Input        |
    Then User sets data for the field
      | Field           | Value | Id | data-dataitemid               | Locator Type |
      | Primary Percent | 60    |    | PrimaryBeneficiary_Percentage | Input        |
    Then User verifies Validation Message for
      | Field         | Id | data-dataitemid                     | Locator Type | Validation Error                           |
      | Primary Total |    | PrimaryBeneficiary_Percentage_Total | Input        | Primary Beneficiary Total must equal 100%. |
    Then User sets data for the field
      | Field           | Value | Id | data-dataitemid               | Locator Type |
      | Primary Percent | 65    |    | PrimaryBeneficiary_Percentage | Input        |
    Then User verifies field is read only
      | Field            | data-dataitemid                        | Locator Type |
      | Contingent Total | ContingentBeneficiary_Percentage_Total | Input        |
    Then User sets data for the field
      | Field              | Value | Id | data-dataitemid                   | Locator Type |
      | Contingent Percent | 95    |    | ContingentBeneficiary1_Percentage | Input        |
    Then User verifies Validation Message for
      | Field            | Id | data-dataitemid                        | Locator Type | Validation Error                                    |
      | Contingent Total |    | ContingentBeneficiary_Percentage_Total | Input        | Contingent Beneficiary Total must equal 0% or 100%. |
    Then User sets data for the field
      | Field              | Value | Id | data-dataitemid                   | Locator Type |
      | Contingent Percent | 100   |    | ContingentBeneficiary1_Percentage | Input        |
    Then User Clicks on Button "Previous"
    Then User verifies prefilled form
      | Field                       | Value                 | data-dataitemid                           | Locator Type |
      | Annuitant First Name        | Steven                | Annuitant_FirstName                       | Input        |
      | Annuitant Middle Name       | K                     | Annuitant_MiddleName                      | Input        |
      | Annuitant Last Name         | Smith                 | Annuitant_LastName                        | Input        |
      | Annuitant Gender            | Male                  | Annuitant_Gender                          | Select       |
      | Joint Annuitant First Name  | Cyborg                | JointAnnuitant_FirstName                  | Input        |
      | Joint Annuitant Middle Name | KIng                  | JointAnnuitant_MiddleName                 | Input        |
      | Joint Annuitant Last Name   | Franky                | JointAnnuitant_LastName                   | Input        |
      | Joint Annuitant Gender      | Female                | JointAnnuitant_Gender                     | Select       |
      | Mailing Address Street      | Carolina Place Parkway   | JointAnnuitant_MailingAddress1            | Input        |
      | City                        | Tacoma               | JointAnnuitant_MailingAddress_City        | Input        |
      | zip                         | 28134                 | JointAnnuitant_MailingAddress_Zipcode     | Input        |
      | State                       | NC                    | JointAnnuitant_MailingAddress_State       | Select       |
      | Residential Address Street  | North Garland Court   | JointAnnuitant_ResidentialAddress1        | Input        |
      | City                        | Oak Park              | JointAnnuitant_ResidentialAddress_City    | Input        |
      | ZipCode                     | 28134                 | JointAnnuitant_ResidentialAddress_Zipcode | Input        |
      | State                       | IL                    | JointAnnuitant_ResidentialAddress_State   | Select       |
    Then User clicks on Next buttons
    Then User verifies prefilled form
      | Field                              | Value                        | data-dataitemid                             | Locator Type |
      | Number of Primary Beneficiaries    | 2                            | PrimaryBeneficiary_NumberofBeneficiaries    | Select       |
      | Living Person?                     | Yes                          | PrimaryBeneficiary_Natural                  | Select       |
      | Relationship                       | Parent                       | PrimaryBeneficiary_Relationship             | Select       |
      | Primary Percent                    | 65.00%                       | PrimaryBeneficiary_Percentage               | Input        |
      | First Name                         | Johns                        | PrimaryBeneficiary_FirstName                | Input        |
      | Middle Name                        | N                            | PrimaryBeneficiary_MiddleName               | Input        |
      | Last Name                          | Taylor                       | PrimaryBeneficiary_LastName                 | Input        |
      | Primary Percent                    | 35.00%                       | PrimaryBeneficiary2_Percentage              | Input        |
      | Name                               | Bruno                        | PrimaryBeneficiary2_NonNaturalName          | Input        |
      | First Name                         | Test                         | ContingentBeneficiary1_FirstName            | Input        |
      | Middle Name                        | Ram                          | ContingentBeneficiary1_MiddleName           | Input        |
      | Last Name                          | Dev                          | ContingentBeneficiary1_LastName             | Input        |
    Then User Clicks on Button "Next"
    Then User verifies Page heading "Suitability Module" with form name "Financial Information" for data entry flow
    Then User Verifies page heading "Financial Profile"
    Then User verifies Validation Message for
      | Field              | Id               | data-dataitemid                      | Locator Type | Validation Error                                                 |
      | Checking Account $ | CheckingAccount$ | FinInfo_Assets_BankAccounts_Checking | Input        | Checking Account amount is required, enter $0 if not applicable. |
    Then User sets data for the field
      | Field              | Value | data-dataitemid                      | Locator Type |
      | Checking Account $ | 98765 | FinInfo_Assets_BankAccounts_Checking | Input        |
    Then User Verifies input value for field is getting converted into Currency Value
      | Field              | Id               |
      | Checking Account $ | CheckingAccount$ |
    Then User verifies Validation Message for
      | Field             | Id              | data-dataitemid                    | Locator Type | Validation Error                    |
      | Savings Account $ | SavingsAccount$ | FinInfo_Assets_BankAccounts_Saving | Input        | Savings Account amount is required. |
    Then User sets data for the field
      | Field             | Value  | data-dataitemid                    | Locator Type |
      | Savings Account $ | 456789 | FinInfo_Assets_BankAccounts_Saving | Input        |
    Then User Verifies input value for field is getting converted into Currency Value
      | Field             | Id              |
      | Savings Account $ | SavingsAccount$ |
    Then User verifies Validation Message for
      | Field                     | Id                     | data-dataitemid    | Locator Type | Validation Error                            |
      | Certificates of Deposit $ | CertificatesofDeposit$ | FinInfo_Assets_CDs | Input        | Certificates of Deposit Amount is required. |
    Then User sets data for the field
      | Field                     | Value | data-dataitemid    | Locator Type |
      | Certificates of Deposit $ | 23456 | FinInfo_Assets_CDs | Input        |
    Then User Verifies input value for field is getting converted into Currency Value
      | Field                     | Id                     |
      | Certificates of Deposit $ | CertificatesofDeposit$ |
    Then User verifies Validation Message for
      | Field                                         | Id                                       | data-dataitemid                            | Locator Type | Validation Error                                        |
      | Annuities Without Current Surrender Charges $ | AnnuitiesWithoutCurrentSurrenderCharges$ | FinInfo_LiquidAssets_Annuities_SurrCharges | Input        | Annuities amount without surrender charges is required. |
    Then User sets data for the field
      | Field                                         | Value | data-dataitemid                            | Locator Type |
      | Annuities Without Current Surrender Charges $ | 56475 | FinInfo_LiquidAssets_Annuities_SurrCharges | Input        |
    Then User Verifies input value for field is getting converted into Currency Value
      | Field                                         | Id                                       |
      | Annuities Without Current Surrender Charges $ | AnnuitiesWithoutCurrentSurrenderCharges$ |
    Then User verifies Validation Message for
      | Field                        | Id                        | data-dataitemid                          | Locator Type | Validation Error                        |
      | Annuities free withdrawals $ | Annuitiesfreewithdrawals$ | FinInfo_Assets_Annuities_FreeWithdrawals | Input        | Annuities free withdrawals is required. |
    Then User sets data for the field
      | Field                        | Value | data-dataitemid                          | Locator Type |
      | Annuities free withdrawals $ | 75467 | FinInfo_Assets_Annuities_FreeWithdrawals | Input        |
    Then User Verifies input value for field is getting converted into Currency Value
      | Field                        | Id                        |
      | Annuities free withdrawals $ | Annuitiesfreewithdrawals$ |
    Then User verifies Validation Message for
      | Field                       | Id                        | data-dataitemid            | Locator Type | Validation Error                |
      | Stocks/Bonds/Mutual Funds $ | Stocks/Bonds/MutualFunds$ | FinInfo_Income_Investments | Input        | Stock/Bonds Amount is required. |
    Then User sets data for the field
      | Field                       | Value  | data-dataitemid            | Locator Type |
      | Stocks/Bonds/Mutual Funds $ | 645764 | FinInfo_Income_Investments | Input        |
    Then User Verifies input value for field is getting converted into Currency Value
      | Field                       | Id                        |
      | Stocks/Bonds/Mutual Funds $ | Stocks/Bonds/MutualFunds$ |
    Then User sets data for the field
      | Field   | Value | data-dataitemid            | Locator Type |
      | Other $ | 56734 | FinInfo_LiquidAssets_Other | Input        |
    Then User Verifies input value for field is getting converted into Currency Value
      | Field   | Id     |
      | Other $ | Other$ |
    Then User Verifies input value for field is getting converted into Currency Value
      | Field  | data-dataitemid            |
      | Total$ | FinInfo_LiquidAssets_Total |
    Then User verifies field should display sum of all above fields
      | Field  | Id     | data-dataitemid            | Value   | Locator Type |
      | Total$ | Total$ | FinInfo_LiquidAssets_Total | 1413450 | Input        |
    Then User verifies Validation Message for
      | Field              | Id               | data-dataitemid                | Locator Type | Validation Error                     |
      | Monthly Expenses $ | MonthlyExpenses$ | FinInfo_Expenses_Total_Monthly | Input        | Monthly Expenses amount is required. |
    Then User sets data for the field
      | Field              | Value | data-dataitemid                | Locator Type |
      | Monthly Expenses $ | 45634 | FinInfo_Expenses_Total_Monthly | Input        |
    Then User Verifies input value for field is getting converted into Currency Value without currency symbol
      | Field              | Id               |
      | Monthly Expenses $ | MonthlyExpenses$ |
    Then User verifies Validation Message for
      | Field                           | Id                          | data-dataitemid                              | Locator Type | Validation Error                                  |
      | Annuities in Surrender Period $ | AnnuitiesinSurrenderPeriod$ | FinInfo_NonLiquidAssets_Annuities_SurrPeriod | Input        | Annuities amount in Surrender Period is required. |
    Then User sets data for the field
      | Field                           | Value | data-dataitemid                              | Locator Type |
      | Annuities in Surrender Period $ | 67887 | FinInfo_NonLiquidAssets_Annuities_SurrPeriod | Input        |
    Then User Verifies input value for field is getting converted into Currency Value
      | Field                           | Id                          |
      | Annuities in Surrender Period $ | AnnuitiesinSurrenderPeriod$ |
    Then User verifies Validation Message for
      | Field                                   | Id                                 | data-dataitemid                   | Locator Type | Validation Error                    |
      | Retirement Plan (401K, Pension, etc.) $ | RetirementPlan(401K,Pension,etc.)$ | FinInfo_Income_RetirementAccounts | Input        | Retirement Plan amount is required. |
    Then User sets data for the field
      | Field                                   | Value | data-dataitemid                   | Locator Type |
      | Retirement Plan (401K, Pension, etc.) $ | 64563 | FinInfo_Income_RetirementAccounts | Input        |
    Then User Verifies input value for field is getting converted into Currency Value
      | Field                                   | Id                                 |
      | Retirement Plan (401K, Pension, etc.) $ | RetirementPlan(401K,Pension,etc.)$ |
    Then User verifies Validation Message for
      | Field                       | data-dataitemid                     | Locator Type | Validation Error                              |
      | Stocks/Bonds/Mutual Funds $ | FinInfo_NonLiquidAssets_Investments | Input        | Stocks/Bonds/Mutual Funds amount is required. |
    Then User sets data for the field
      | Field                       | Value  | data-dataitemid                     | Locator Type |
      | Stocks/Bonds/Mutual Funds $ | 947342 | FinInfo_NonLiquidAssets_Investments | Input        |
    Then User Verifies input value for field is getting converted into Currency Value
      | Field                       | Id                        |
      | Stocks/Bonds/Mutual Funds $ | Stocks/Bonds/MutualFunds$ |
    Then User verifies Validation Message for
      | Field                                        | Id                                     | data-dataitemid                    | Locator Type | Validation Error                |
      | Real Estate (other than primary residence) $ | RealEstate(otherthanprimaryresidence)$ | FinInfo_NonLiquidAssets_RealEstate | Input        | Real Estate amount is required. |
    Then User sets data for the field
      | Field                                        | Value | data-dataitemid                    | Locator Type |
      | Real Estate (other than primary residence) $ | 74854 | FinInfo_NonLiquidAssets_RealEstate | Input        |
    Then User Verifies input value for field is getting converted into Currency Value
      | Field                                        | Id                                     |
      | Real Estate (other than primary residence) $ | RealEstate(otherthanprimaryresidence)$ |
    Then User verifies Validation Message for
      | Field                       | Id                      | data-dataitemid                       | Locator Type | Validation Error                              |
      | Life Insurance Cash Value $ | LifeInsuranceCashValue$ | FinInfo_NonLiquidAssets_LifeInsurance | Input        | Life Insurance Cash Value amount is required. |
    Then User sets data for the field
      | Field                       | Value | data-dataitemid                       | Locator Type |
      | Life Insurance Cash Value $ | 4535  | FinInfo_NonLiquidAssets_LifeInsurance | Input        |
    Then User Verifies input value for field is getting converted into Currency Value
      | Field                       | Id                      |
      | Life Insurance Cash Value $ | LifeInsuranceCashValue$ |
    Then User sets data for the field
      | Field   | Value | data-dataitemid               | Locator Type |
      | Other $ | 3245  | FinInfo_NonLiquidAssets_Other | Input        |
    Then User Verifies input value for field is getting converted into Currency Value
      | Field   | Id     |
      | Other $ | Other$ |
    Then User Verifies input value for field is getting converted into Currency Value
      | Field  | data-dataitemid               |
      | Total$ | FinInfo_NonLiquidAssets_Total |
    Then User verifies field should display sum of all above fields
      | Field  | Id | data-dataitemid               | Value   | Locator Type |
      | Total$ |    | FinInfo_NonLiquidAssets_Total | 1162426 | Input        |
    Then User verifies Validation Message for
      | Field                                 | data-dataitemid         | Locator Type | Validation Error             |
      | What is the Client's Total Net Worth? | FinInfo_Assets_NetWorth | Input        | Total Net Worth is required. |
    Then User sets data for the field
      | Field                                 | Value  | data-dataitemid         | Locator Type |
      | What is the Client's Total Net Worth? | 546434 | FinInfo_Assets_NetWorth | Input        |
    Then User Verifies input value for field is getting converted into Currency Value without currency symbol
      | Field                                 | data-dataitemid         |
      | What is the Client's Total Net Worth? | FinInfo_Assets_NetWorth |
    Then User verifies Validation Message for Radio Button
      | Field                                                       | Id | data-dataitemid             | Locator Type | RadioButtonType | Validation Error                   |
      | Does your current income cover expenses, including medical? |    | FinInfo_Expenses_HealthCare | Div          | Yes             | Either Yes or No must be selected. |
    Then User Selects "Yes" Radio Button for Field "Does your current income cover expenses, including medical?"
      | data-dataitemid             |
      | FinInfo_Expenses_HealthCare |
    Then User clicks red bubble icon
    Then User verifies Validation Message for Radio Button
      | Field                                                          | Id | data-dataitemid                  | Locator Type | RadioButtonType | Validation Error                   |
      | Do you expect any changes in your out-of-pocket medical costs? |    | FinInfo_Expenses_ExpectedChanges | Div          | Yes             | Either Yes or No must be selected. |
    Then User Selects "Yes" Radio Button for Field "Do you expect any changes in your out-of-pocket medical costs?"
      | data-dataitemid                  |
      | FinInfo_Expenses_ExpectedChanges |
    Then User verifies Validation Message for Radio Button
      | Field                          | Id | data-dataitemid   | Locator Type | RadioButtonType | Validation Error                 |
      | Do you have an emergency fund? |    | FinInfo_Emergency | Div          | Yes             | FinInfo_Expenses_ExpectedChanges |
    Then User Selects "Yes" Radio Button for Field "Do you have an emergency fund?"
      | data-dataitemid   |
      | FinInfo_Emergency |
    Then User verifies Validation Message for Radio Button
      | Field                           | Id | data-dataitemid         | Locator Type | RadioButtonType | Validation Error                   |
      | Do you have a reverse mortgage? |    | FinInfo_ReverseMortgage | Div          | Yes             | Either Yes or No must be selected. |
    Then User Selects "Yes" Radio Button for Field "Do you have a reverse mortgage?"
      | data-dataitemid         |
      | FinInfo_ReverseMortgage |
    Then User verifies fields Present in UI
      | Field                                                                         | Title | data-item-id                            | Locator Type |
      | If Yes, is any premium intended to fund this annuity from a reverse mortgage? | Yes   | FinInfo_ReverseMortgage_PremiumIntended | Div          |
    Then User verifies Validation Message for Radio Button
      | Field                                                                         | Id | data-dataitemid                         | Locator Type | RadioButtonType | Validation Error                   |
      | If Yes, is any premium intended to fund this annuity from a reverse mortgage? |    | FinInfo_ReverseMortgage_PremiumIntended | Div          | Yes             | Either Yes or No must be selected. |
    Then User Selects "Yes" Radio Button for Field "If Yes, is any premium intended to fund this annuity from a reverse mortgage?"
      | data-dataitemid                         |
      | FinInfo_ReverseMortgage_PremiumIntended |
    Then User verifies Validation Message for Radio Button
      | Field                                                                                                                                           | Id | data-dataitemid                | Locator Type | RadioButtonType | Validation Error              |
      | Do you anticipate a significant decrease in your future income or increase in your future expenses during the proposed annuity Guarantee Period |    | FinInfo_Assets_ExpectedChanges | Div          | Yes             | Either Yes or No is required. |
    Then User Selects "Yes" Radio Button for Field "Do you anticipate a significant decrease in your future income or increase in your future expenses during the proposed annuity Guarantee Period"
      | data-dataitemid                |
      | FinInfo_Assets_ExpectedChanges |
    Then User verifies Validation Message for
      | Field                  | Id                  | data-dataitemid                        | Locator Type | Validation Error    |
      | If Yes, please explain | IfYes,pleaseexplain | FinInfo_Assets_ExpectedChanges_Explain | Input        | Detail is required. |
    Then User sets data for the field
      | Field                  | Value                                                 | data-dataitemid                        | Locator Type |
      | If Yes, please explain | explanation for significant decrease in future income | FinInfo_Assets_ExpectedChanges_Explain | Input        |
    Then User clicks on Next buttons
    Then User Verifies page heading "Investment Profile Questionnaire"
    Then User Verifies options present for Dropdown
      | Field            | Id            | data-dataitemid   | Locator Type | Option      |
      | How old are you? | Howoldareyou? | Customer_AgeRange | Select       | 18-24       |
      | How old are you? | Howoldareyou? | Customer_AgeRange | Select       | 25-35       |
      | How old are you? | Howoldareyou? | Customer_AgeRange | Select       | 36-45       |
      | How old are you? | Howoldareyou? | Customer_AgeRange | Select       | 46-54       |
      | How old are you? | Howoldareyou? | Customer_AgeRange | Select       | 55-65       |
      | How old are you? | Howoldareyou? | Customer_AgeRange | Select       | 65-75       |
      | How old are you? | Howoldareyou? | Customer_AgeRange | Select       | 76 or older |
    Then User Chooses Blank option for Dropdown "How old are you?" having id "Howoldareyou?" or DataItemId "Customer_AgeRange"
    Then User verifies Validation Message for
      | Field            | Id            | data-dataitemid   | Locator Type | Validation Error        |
      | How old are you? | Howoldareyou? | Customer_AgeRange | Select       | Client Age is required. |
    Then User Chooses option for Dropdown
      | Field            | Id            | data-dataitemid   | Locator Type | Option |
      | How old are you? | Howoldareyou? | Customer_AgeRange | Select       | 25-35  |
    Then User Verifies options present for Dropdown
      | Field                                          | Id                                      | data-dataitemid | Locator Type | Option |
      | What is your Federal Tax Bracket? (Select One) | WhatisyourFederalTaxBracket?(SelectOne) | Owner_TaxRate   | Select       | 10%    |
      | What is your Federal Tax Bracket? (Select One) | WhatisyourFederalTaxBracket?(SelectOne) | Owner_TaxRate   | Select       | 15%    |
      | What is your Federal Tax Bracket? (Select One) | WhatisyourFederalTaxBracket?(SelectOne) | Owner_TaxRate   | Select       | 25%    |
      | What is your Federal Tax Bracket? (Select One) | WhatisyourFederalTaxBracket?(SelectOne) | Owner_TaxRate   | Select       | 28%    |
      | What is your Federal Tax Bracket? (Select One) | WhatisyourFederalTaxBracket?(SelectOne) | Owner_TaxRate   | Select       | 33%    |
      | What is your Federal Tax Bracket? (Select One) | WhatisyourFederalTaxBracket?(SelectOne) | Owner_TaxRate   | Select       | 35%    |
    Then User Chooses Blank option for Dropdown "What is your Federal Tax Bracket? (Select One)" having id "WhatisyourFederalTaxBracket?(SelectOne)" or DataItemId "Owner_TaxRate"
    Then User verifies Validation Message for
      | Field                                          | Id                                      | data-dataitemid | Locator Type | Validation Error        |
      | What is your Federal Tax Bracket? (Select One) | WhatisyourFederalTaxBracket?(SelectOne) | Owner_TaxRate   | Select       | This field is required. |
    Then User Chooses option for Dropdown
      | Field                                          | Id                                      | data-dataitemid | Locator Type | Option |
      | What is your Federal Tax Bracket? (Select One) | WhatisyourFederalTaxBracket?(SelectOne) | Owner_TaxRate   | Select       | 10%    |
    Then User Verifies options present for Dropdown
      | Field                                                        | Id                                                | data-dataitemid    | Locator Type | Option                                   |
      | 1.  I plan to begin withdrawing money from my investment in: | 1.Iplantobeginwithdrawingmoneyfrommyinvestmentin: | FinObj_TimeHorizon | Select       | 1 year or less                           |
      | 1.  I plan to begin withdrawing money from my investment in: | 1.Iplantobeginwithdrawingmoneyfrommyinvestmentin: | FinObj_TimeHorizon | Select       | 1-3 years                                |
      | 1.  I plan to begin withdrawing money from my investment in: | 1.Iplantobeginwithdrawingmoneyfrommyinvestmentin: | FinObj_TimeHorizon | Select       | 3-7 years                                |
      | 1.  I plan to begin withdrawing money from my investment in: | 1.Iplantobeginwithdrawingmoneyfrommyinvestmentin: | FinObj_TimeHorizon | Select       | 7-10 years                               |
      | 1.  I plan to begin withdrawing money from my investment in: | 1.Iplantobeginwithdrawingmoneyfrommyinvestmentin: | FinObj_TimeHorizon | Select       | 10 years or more                         |
      | 1.  I plan to begin withdrawing money from my investment in: | 1.Iplantobeginwithdrawingmoneyfrommyinvestmentin: | FinObj_TimeHorizon | Select       | Never (money is for charity/inheritence) |
    Then User Chooses Blank option for Dropdown "1.  I plan to begin withdrawing money from my investment in:" having id "1.Iplantobeginwithdrawingmoneyfrommyinvestmentin:" or DataItemId "FinObj_TimeHorizon"
    Then User verifies Validation Message for
      | Field                                                        | Id                                                | data-dataitemid    | Locator Type | Validation Error                                         |
      | 1.  I plan to begin withdrawing money from my investment in: | 1.Iplantobeginwithdrawingmoneyfrommyinvestmentin: | FinObj_TimeHorizon | Select       | Plan for withdrawing money from Investments is required. |
    Then User Chooses option for Dropdown
      | Field                                                        | Id                                                | data-dataitemid    | Locator Type | Option    |
      | 1.  I plan to begin withdrawing money from my investment in: | 1.Iplantobeginwithdrawingmoneyfrommyinvestmentin: | FinObj_TimeHorizon | Select       | 1-3 years |
    Then User Verifies options present for Dropdown
      | Field                                  | Id                                | data-dataitemid            | Locator Type | Option                                |
      | 2. My primary Investment Objective is: | 2.MyprimaryInvestmentObjectiveis: | FinObj_InvestmentObjective | Select       | Income                                |
      | 2. My primary Investment Objective is: | 2.MyprimaryInvestmentObjectiveis: | FinObj_InvestmentObjective | Select       | Growth                                |
      | 2. My primary Investment Objective is: | 2.MyprimaryInvestmentObjectiveis: | FinObj_InvestmentObjective | Select       | Safety of Principal and Income        |
      | 2. My primary Investment Objective is: | 2.MyprimaryInvestmentObjectiveis: | FinObj_InvestmentObjective | Select       | Safety of Principal and Growth        |
      | 2. My primary Investment Objective is: | 2.MyprimaryInvestmentObjectiveis: | FinObj_InvestmentObjective | Select       | Pass Assets to Beneficiaries at Death |
    Then User Chooses Blank option for Dropdown "2. My primary Investment Objective is:" having id "2.MyprimaryInvestmentObjectiveis:" or DataItemId "FinObj_InvestmentObjective"
    Then User verifies Validation Message for
      | Field                                  | Id                                | data-dataitemid            | Locator Type | Validation Error                          |
      | 2. My primary Investment Objective is: | 2.MyprimaryInvestmentObjectiveis: | FinObj_InvestmentObjective | Select       | Primary Investment Objective is required. |
    Then User Chooses option for Dropdown
      | Field                                  | Id                                | data-dataitemid            | Locator Type | Option |
      | 2. My primary Investment Objective is: | 2.MyprimaryInvestmentObjectiveis: | FinObj_InvestmentObjective | Select       | Growth |
    Then User Verifies options present for Dropdown
      | Field                                     | Id                                 | data-dataitemid       | Locator Type | Option                  |
      | 3. I would describe my Risk Tolerance as: | 3.IwoulddescribemyRiskToleranceas: | FinInfo_RiskTolerance | Select       | Conservative            |
      | 3. I would describe my Risk Tolerance as: | 3.IwoulddescribemyRiskToleranceas: | FinInfo_RiskTolerance | Select       | Moderately Conservative |
      | 3. I would describe my Risk Tolerance as: | 3.IwoulddescribemyRiskToleranceas: | FinInfo_RiskTolerance | Select       | Moderate                |
      | 3. I would describe my Risk Tolerance as: | 3.IwoulddescribemyRiskToleranceas: | FinInfo_RiskTolerance | Select       | Moderately Aggressive   |
      | 3. I would describe my Risk Tolerance as: | 3.IwoulddescribemyRiskToleranceas: | FinInfo_RiskTolerance | Select       | Aggressive              |
    Then User Chooses Blank option for Dropdown "3. I would describe my Risk Tolerance as:" having id "3.IwoulddescribemyRiskToleranceas:" or DataItemId "FinInfo_RiskTolerance"
    Then User verifies Validation Message for
      | Field                                     | Id                                 | data-dataitemid       | Locator Type | Validation Error            |
      | 3. I would describe my Risk Tolerance as: | 3.IwoulddescribemyRiskToleranceas: | FinInfo_RiskTolerance | Select       | Risk Tolerance is required. |
    Then User Chooses option for Dropdown
      | Field                                     | Id                                 | data-dataitemid       | Locator Type | Option       |
      | 3. I would describe my Risk Tolerance as: | 3.IwoulddescribemyRiskToleranceas: | FinInfo_RiskTolerance | Select       | Conservative |
    Then User verifies Validation Message for Radio Button
      | Field                                               | Id | data-dataitemid        | Locator Type | RadioButtonType | Validation Error                      |
      | 4. I would describe my knowledge of Investments as: |    | FinObj_InvestKnowledge | Div          | Limited         | Knowledge of Investments is required. |
    Then User Selects "Limited" Radio Button for Field "4. I would describe my knowledge of Investments as:"
      | data-dataitemid        |
      | FinObj_InvestKnowledge |
    Then User verifies Validation Message for Radio Button
      | Field                            | Id | data-dataitemid | Locator Type | RadioButtonType                                               | Validation Error                |
      | 5. When I invest my money, I am: |    | FinObj_Ranking  | Div          | Equally concerned about my investment losing or gaining value | Investment concern is required. |
    Then User Selects "Equally concerned about my investment losing or gaining value" Radio Button for Field "5. When I invest my money, I am:"
      | data-dataitemid |
      | FinObj_Ranking  |
    Then User verifies Validation Message for Radio Button
      | Field                                            | Id | data-dataitemid | Locator Type | RadioButtonType                      | Validation Error             |
      | 6. For this investment, I am most interested in: |    | FinObj_Goal     | Div          | A product that offers death benefits | Investment goal is required. |
    Then User Selects "A product that offers death benefits" Radio Button for Field "6. For this investment, I am most interested in:"
      | data-dataitemid |
      | FinObj_Goal     |
    Then User clicks on Next buttons
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
    Then User Enters "abc" in TextBox "CashAmount"
    Then User verifies Validation Message for
      | Field       | Id         | data-dataitemid           | Locator Type | Validation Error                       |
      | Cash Amount | CashAmount | SourceOfFunds_Cash_Amount | Input        | Cash Amount must be a positive number. |
    Then User Enters "-123" in TextBox "CashAmount"
    Then User verifies Validation Message for
      | Field       | Id         | data-dataitemid           | Locator Type | Validation Error                       |
      | Cash Amount | CashAmount | SourceOfFunds_Cash_Amount | Input        | Cash Amount must be a positive number. |
    Then User Enters "123.512" in TextBox "CashAmount"
    Then User verifies "CashAmount" TextBox has Prefilled Value "$123.51"
    Then User verify "maxlength" of field "CashAmount" is "100"
    Then User clears value in field "CashAmount"
    Then User verifies "TotalSinglePremiumAmount" is "readOnly" field
    Then User verifies "TotalSinglePremiumAmount" TextBox has Prefilled Value "$0.00"
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
    Then User verifies "TotalSinglePremiumAmount" is "readOnly" field
    Then User Verifies radiobutton "Yes" is "readOnly" for "Will this contract replace or change any of your existing life insurance policies or annuity contracts?"
    Then User Verifies radiobutton "No" is "readOnly" for "Will this contract replace or change any of your existing life insurance policies or annuity contracts?"
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
    Then User verifies Page heading "Fund Allocation Variable Module" with form name "Fund Allocation" for data entry flow
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
    Then User Enters "2.4" in field "Large Cap Value Fund 1"
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
    Then User verifies "Total_Initial_Investment_Allocation_Percentage" is "readOnly" field
    Then User verifies "Total_Initial_Investment_Allocation_Percentage" TextBox has Prefilled Value "97.00%"
    Then User verifies Validation Message for
      | Field                 | Id                   | data-dataitemid                                | Locator Type | Validation Error                                      |
      | Investment Allocation | InvestmentAllocation | Total_Initial_Investment_Allocation_Percentage | Input        | The total initial allocation must equal 100%. |
    Then User Enters "14" in field "Small Cap Value Fund 5"
    Then User verifies "Total_Initial_Investment_Allocation_Percentage" TextBox has Prefilled Value "101.00%"
    Then User verifies Validation Message for
      | Field          | Id              | data-dataitemid        | Locator Type | Validation Error                        |
      | Investment Allocation | InvestmentAllocation | Total_Initial_Investment_Allocation_Percentage | Input        | The total initial allocation must equal 100%. |
    Then User Enters "13" in field "Small Cap Value Fund 5"
    Then User verifies "Total_Initial_Investment_Allocation_Percentage" TextBox has Prefilled Value "100.00%"
    Then User clicks "Next" button
    Then User verifies Page heading "Agent Module" with form name "Agent/Advisor" for data entry flow
    Then User verifies Agent Information is displayed on Agent Module Header
    Then User Verifies options present for Dropdown
      | Field                  | Id                  | data-dataitemid     | Locator Type | Option |
      | Total Number of Agents | TotalNumberofAgents | Total_Agents_Number | Select       | 1      |
      | Total Number of Agents | TotalNumberofAgents | Total_Agents_Number | Select       | 2      |
    Then User Chooses Blank option for Dropdown "Total Number of Agents" having id "TotalNumberofAgents" or DataItemId "Total_Agents_Number"
    Then User verifies Validation Message for
      | Field                  | Id                  | data-dataitemid     | Locator Type | Validation Error                    |
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
      | Field             | Value | Id               | data-dataitemid        | Locator Type |
      | Commission Option | C     | CommissionOption | Agent_CommissionOption | Select       |
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
      | Field      | Value  | Id        | data-dataitemid | Locator Type |
      | First Name | Arnold | FirstName | Agent_FirstName | Input        |
    Then User sets data for the field
      | Field       | Value | Id         | data-dataitemid  | Locator Type |
      | Middle Name | SHIV  | MiddleName | Agent_MiddleName | Input        |
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
      | Field      | Value | Id        | data-dataitemid | Locator Type |
      | CRD Number | 34523 | CRDNumber | Agent_CRDNumber | Input        |
    Then User verifies prefilled form
      | Field      | Value | data-dataitemid | Locator Type |
      | CRD Number | 34523 | Agent_CRDNumber | Input        |
    Then User verifies Validation Message for
      | Field                | Value | Id        | data-dataitemid | Locator Type | Validation Error              |
      | Agent License Number |       | NPNNumber | Agent_NPNNumber | Input        | Agent NPN Number is required. |
    Then User sets data for the field
      | Field                | Value | Id        | data-dataitemid | Locator Type |
      | Agent License Number | 57687 | NPNNumber | Agent_NPNNumber | Input        |
    Then User verifies Validation Message for
      | Field     | Value | Id       | data-dataitemid | Locator Type | Validation Error             |
      | Firm Name |       | FirmName | Agent_FirmName  | Input        | Agent Firm Name is required. |
    Then User sets data for the field
      | Field     | Value  | Id       | data-dataitemid | Locator Type |
      | Firm Name | Hexure | FirmName | Agent_FirmName  | Input        |
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
      | Field         | Value   | Id           | data-dataitemid            | Locator Type |
      | Email Address | shiv777 | EmailAddress | Agent_Primary_EmailAddress | Input        |
    Then User verifies Validation Message for
      | Field         | Value | Id           | data-dataitemid            | Locator Type | Validation Error                    |
      | Email Address |       | EmailAddress | Agent_Primary_EmailAddress | Input        | Please enter a valid Email address. |
    Then User sets data for the field
      | Field         | Value          | Id           | data-dataitemid            | Locator Type |
      | Email Address | abcd@gmail.com | EmailAddress | Agent_Primary_EmailAddress | Input        |
    Then User Clears data for the field
      | Field      | Id         | data-dataitemid       | Locator Type |
      | Percentage | Percentage | Agent_CommissionSplit | Input        |
    Then User verifies Validation Message for
      | Field      | Value | Id         | data-dataitemid       | Locator Type | Validation Error                   |
      | Percentage |       | Percentage | Agent_CommissionSplit | Input        | Commission Percentage is required. |
    Then User sets data for the field
      | Field      | Value | Id         | data-dataitemid       | Locator Type |
      | Percentage | 56    | Percentage | Agent_CommissionSplit | Input        |
    Then User verifies Validation Message for
      | Field      | Value | Id         | data-dataitemid       | Locator Type | Validation Error                        |
      | Percentage |       | Percentage | Agent_CommissionSplit | Input        | Agent Commission Total must equal 100%. |
    Then User sets data for the field
      | Field      | Value | Id         | data-dataitemid       | Locator Type |
      | Percentage | 105   | Percentage | Agent_CommissionSplit | Input        |
    Then User verifies Validation Message for
      | Field      | Value | Id         | data-dataitemid       | Locator Type | Validation Error                        |
      | Percentage |       | Percentage | Agent_CommissionSplit | Input        | Agent Commission Total must equal 100%. |
    Then User sets data for the field
      | Field      | Value | Id         | data-dataitemid       | Locator Type |
      | Percentage | 100   | Percentage | Agent_CommissionSplit | Input        |
    Then User verifies Validation Message for Radio Button
      | Field                                                                        | Id | data-dataitemid        | Locator Type | RadioButtonType | Validation Error              |
      | Are you aware of any existing annuities or insurance owned by the applicant? |    | Agent_ExistingPolicies | Div          | Yes             | Either Yes or No is required. |
    Then User Selects "Yes" Radio Button for Field "Are you aware of any existing annuities or insurance owned by the applicant?"
      | data-dataitemid        |
      | Agent_ExistingPolicies |
     Then User Selects "Yes" Radio Button for Field "Will the applied for contract replace, discontinue or change any existing life insurance or annuity contract?"
      | data-dataitemid      |
      | Agent_ChangePolicies |
    Then User Unchecks "Yes" Radio Button for Field "Will the applied for contract replace, discontinue or change any existing life insurance or annuity contract?"
      | data-dataitemid      |
      | Agent_ChangePolicies |
    Then User verifies Validation Message for Radio Button
      | Field                                                                                                         | Id | data-dataitemid      | Locator Type | RadioButtonType | Validation Error              |
      | Will the applied for contract replace, discontinue or change any existing life insurance or annuity contract? |    | Agent_ChangePolicies | Div          | Yes             | Either Yes or No is required. |
    Then User Selects "Yes" Radio Button for Field "Will the applied for contract replace, discontinue or change any existing life insurance or annuity contract?"
      | data-dataitemid      |
      | Agent_ChangePolicies |
    Then User Verifies Data Entry Met Toast popup is show
    Then User clicks on Close icon on Toast Popup
