Feature: FireLight_End2End_Tests

  This feature will verify UAT Application End2End Tests

  @End2EndTest
  Scenario: TC_01_Complete the REACT application with Pre Signature Review with Signature Then Submit
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
#    Then User opens "Client Data" Required for Form "Annuity Owner Module"
#    Then User verifies Page heading "Annuity Owner Module" with form name "Client Data" for data entry flow
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
      | Owner First Name  | Monkey |    | Owner_FirstName  | Input        |
      | Owner Middle Name | D      |    | Owner_MiddleName | Input        |
      | Owner Last Name   | Luffy  |    | Owner_LastName   | Input        |
    Then User clicks red bubble icon
    Then User verifies Validation Message for
      | Field         | Id          | data-dataitemid | Locator Type | Validation Error        |
      | Date of Birth | DateofBirth | Owner_DOB       | Input        | Birth Date is required. |
    Then User clicks red bubble icon
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
    Then User sets data for the field
      | Field                  | Value | Id                   | data-dataitemid      | Locator Type |
      | Mailing Address Lookup | usa   | MailingAddressLookup | Owner_Address_Lookup | Input        |
    Then User Verifies Below Options Present for Lookup "Mailing Address Lookup"
      | Option                                    |
      | USA Parkway, Fishers, IN, USA             |
      | USA Medical Center Drive, Mobile, AL, USA |
      | USA Parkway, Sparks, NV, USA              |
      | USA Drive, Fishers, IN, USA               |
      | Usaa Boulevard, San Antonio, TX, USA      |
    Then User Selects Option for Lookup "Mailing Address Lookup"
      | Option                        |
      | USA Parkway, Fishers, IN, USA |
    Then User Clears data for the field
      | Field                  | Id                   | data-dataitemid       | Locator Type |
      | Mailing Address Street | MailingAddressStreet | Owner_MailingAddress1 | Input        |
    Then User verifies Validation Message for
      | Field                  | Id                   | data-dataitemid       | Locator Type | Validation Error                  |
      | Mailing Address Street | MailingAddressStreet | Owner_MailingAddress1 | Input        | Owner Street Address is required. |
    Then User sets data for the field
      | Field                  | Value                   | Id                    | data-dataitemid       | Locator Type |
      | Mailing Address Street | Enetai Avenue Northeast | MMailingAddressStreet | Owner_MailingAddress1 | Input        |
    Then User Clears data for the field
      | Field | Id   | data-dataitemid           | Locator Type |
      | City  | City | Owner_MailingAddress_City | Input        |
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
    Then User Clears data for the field
      | Field       | Id         | data-dataitemid              | Locator Type |
      | Postal Code | PostalCode | Owner_MailingAddress_Zipcode | Input        |
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
      | Residential Address Street | ResidentialAddressStreet | Owner_ResidentialAddress1        | Input        |
      | City                       |                          | Owner_ResidentialAddress_City    | Input        |
      | Postal Code                |                          | Owner_ResidentialAddress_Zipcode | Input        |
      | State                      |                          | Owner_ResidentialAddress_State   | Select       |
    Then User "Uncheck" checkbox "Mailing Address is different than Residential Address"
    Then User verifies fields is not Present in UI
      | Field                      | Id                       | data-item-id                     | Locator Type |
      | Residential Address Lookup |                          | Owner_ResidentialAddress_Lookup  | Input        |
      | Residential Address Street | ResidentialAddressStreet | Owner_ResidentialAddress1        | Input        |
      | City                       |                          | Owner_ResidentialAddress_City    | Input        |
      | Postal Code                |                          | Owner_ResidentialAddress_Zipcode | Input        |
      | State                      |                          | Owner_ResidentialAddress_State   | Select       |
    Then User "check" checkbox "Mailing Address is different than Residential Address"
    Then User sets data for the field
      | Field                      | Value   | Id                       | data-dataitemid                 | Locator Type |
      | Residential Address Lookup | Chicago | ResidentialAddressLookup | Owner_ResidentialAddress_Lookup | Input        |
    Then User Verifies Below Options Present for Lookup "Residential Address Lookup"
      | Option                                               |
      | Chicago Riverwalk, Chicago, IL, USA                  |
      | Chicago Pedway System, Chicago, IL, USA              |
      | Chicago Skyway, Chicago, IL, USA                     |
      | Chicago Transit Authority Red Line, Chicago, IL, USA |
      | West Chicago Avenue, Chicago, IL, USA                |
    Then User Selects Option for Lookup "Residential Address Lookup"
      | Option                              |
      | Chicago Riverwalk, Chicago, IL, USA |
    Then User Clears data for the field
      | Field                      | Id                       | data-dataitemid           | Locator Type |
      | Residential Address Street | ResidentialAddressStreet | Owner_ResidentialAddress1 | Input        |
    Then User verifies Validation Message for
      | Field                      | Id                       | data-dataitemid           | Locator Type | Validation Error                  |
      | Residential Address Street | ResidentialAddressStreet | Owner_ResidentialAddress1 | Input        | Owner Street Address is required. |
    Then User sets data for the field
      | Field                      | Value               | Id                       | data-dataitemid           | Locator Type |
      | Residential Address Street | ENorth Allen Avenue | ResidentialAddressStreet | Owner_ResidentialAddress1 | Input        |
    Then User Clears data for the field
      | Field | Id | data-dataitemid               | Locator Type |
      | City  |    | Owner_ResidentialAddress_City | Input        |
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
    Then User Clears data for the field
      | Field       | Id | data-dataitemid                  | Locator Type |
      | Postal Code |    | Owner_ResidentialAddress_Zipcode | Input        |
    Then User verifies Validation Message for
      | Field       | Id | data-dataitemid                  | Locator Type | Validation Error               |
      | Postal Code |    | Owner_ResidentialAddress_Zipcode | Input        | Owner Postal Code is required. |
    Then User sets data for the field
      | Field       | Value      | Id | data-dataitemid                  | Locator Type |
      | Postal Code | 606184464  |    | Owner_ResidentialAddress_Zipcode | Input        |
      | Postal Code | 60618-4464 |    | Owner_ResidentialAddress_Zipcode | Input        |
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
      | Owner First Name           | Monkey                  | Owner_FirstName                | Input        |
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
#    Then User opens "Annuitant(s)" Required for Form "Annuitant Module"
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
    Then User "check" checkbox "Same address as Owner"
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

    Then User "check" checkbox "Same address as Owner" with data item Id "JointAnnuitant_SameAsOwnerAddress"
    Then User verifies fields is not Present in UI
      | Field                  | Id | data-item-id                          | Locator Type |
      | Mailing Address Lookup |    | JointAnnuitant_Address_Lookup         | Input        |
      | Mailing Address Street |    | JointAnnuitant_MailingAddress1        | Input        |
      | City                   |    | JointAnnuitant_MailingAddress_City    | Input        |
      | State                  |    | JointAnnuitant_MailingAddress_State   | Select       |
      | Postal Code            |    | JointAnnuitant_MailingAddress_Zipcode | Input        |
    Then User "uncheck" checkbox "Same address as Owner" with data item Id "JointAnnuitant_SameAsOwnerAddress"
    Then User verifies fields Present in UI
      | Field                  | Id | data-item-id                          | Locator Type |
      | Mailing Address Lookup |    | JointAnnuitant_Address_Lookup         | Input        |
      | Mailing Address Street |    | JointAnnuitant_MailingAddress1        | Input        |
      | City                   |    | JointAnnuitant_MailingAddress_City    | Input        |
      | State                  |    | JointAnnuitant_MailingAddress_State   | Select       |
      | Postal Code            |    | JointAnnuitant_MailingAddress_Zipcode | Input        |

    Then User sets data for the field
      | Field                  | Value    | Id | data-dataitemid               | Locator Type |
      | Mailing Address Lookup | carolina |    | JointAnnuitant_Address_Lookup | Input        |
    Then User Verifies Below Options Present for Lookup "Mailing Address Lookup"
      | Option                                           |
      | Carolina Street, Gary, IN, USA                   |
      | Carolina Place Parkway, Pineville, NC, USA       |
      | Carolina MacGillavrylaan, Amsterdam, Netherlands |
      | Carolina Place, Fort Mill, SC, USA               |
      | Carolina Trace Road, Harrison, OH, USA           |
    Then User Selects Option for Lookup "Mailing Address Lookup"
      | Option                                     |
      | Carolina Place Parkway, Pineville, NC, USA |

    Then User Clears data for the field
      | Field                  | Id | data-dataitemid                | Locator Type |
      | Mailing Address Street |    | JointAnnuitant_MailingAddress1 | Input        |
    Then User verifies Validation Message for
      | Field                  | Id | data-dataitemid                    | Locator Type | Validation Error                            |
      | Mailing Address Street |    | JointAnnuitant_MailingAddress1 | Input        | Joint Annuitant Street Address is required. |
    Then User sets data for the field
      | Field                  | Value                  | Id | data-dataitemid                    | Locator Type |
      | Mailing Address Street | Carolina Place Parkway |    | JointAnnuitant_MailingAddress1 | Input        |
    Then User Clears data for the field
      | Field | Id | data-dataitemid                    | Locator Type |
      | City  |    | JointAnnuitant_MailingAddress_City | Input        |
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
    Then User Clears data for the field
      | Field       | Id | data-dataitemid                       | Locator Type |
      | Postal Code |    | JointAnnuitant_MailingAddress_Zipcode | Input        |
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
    Then User sets data for the field
      | Field                      | Value | Id | data-dataitemid                          | Locator Type |
      | Residential Address Lookup | Gar   |    | JointAnnuitant_ResidentialAddress_Lookup | Input        |
    Then User Verifies Below Options Present for Lookup "Residential Address Lookup"
      | Option                                    |
      | North Garland Court, Chicago, IL, USA     |
      | North Garvey Court, Chicago, IL, USA      |
      | West Garfield Boulevard, Chicago, IL, USA |
      | Garfield Square, Chicago, IL, USA         |
      | Garfield Street, Oak Park, IL, USA        |
    Then User Selects Option for Lookup "Residential Address Lookup"
      | Option                                |
      | North Garland Court, Chicago, IL, USA |
    Then User verifies prefilled form
      | Field                      | Value               | data-dataitemid                        | Locator Type |
      | Residential Address Street | North Garland Court | JointAnnuitant_ResidentialAddress1     | Input        |
      | City                       | Chicago             | JointAnnuitant_ResidentialAddress_City | Input        |
    Then User Clears data for the field
      | Field                      | Id | data-dataitemid                    | Locator Type |
      | Residential Address Street |    | JointAnnuitant_ResidentialAddress1 | Input        |
    Then User verifies Validation Message for
      | Field                      | Id | data-dataitemid                    | Locator Type | Validation Error                     |
      | Residential Address Street |    | JointAnnuitant_ResidentialAddress1 | Input        | Joint Annuitant Address is required. |
    Then User sets data for the field
      | Field                      | Value               | Id | data-dataitemid                    | Locator Type |
      | Residential Address Street | North Garland Court |    | JointAnnuitant_ResidentialAddress1 | Input        |
    Then User Clears data for the field
      | Field | Id | data-dataitemid                        | Locator Type |
      | City  |    | JointAnnuitant_ResidentialAddress_City | Input        |
    Then User verifies Validation Message for
      | Field | Id | data-dataitemid                        | Locator Type | Validation Error                  |
      | City  |    | JointAnnuitant_ResidentialAddress_City | Input        | Joint Annuitant City is required. |
    Then User sets data for the field
      | Field | Value    | Id | data-dataitemid                        | Locator Type |
      | City  | Oak Park |    | JointAnnuitant_ResidentialAddress_City | Input        |
    Then User Chooses option for Dropdown
      | Field | Id | data-dataitemid                         | Locator Type | Option  |
      | State |    | JointAnnuitant_ResidentialAddress_State | Select       | Alabama |
    Then User Chooses Blank option for Dropdown "State" having id "" or DataItemId "JointAnnuitant_ResidentialAddress_State"
    Then User verifies Validation Message for
      | Field | Id | data-dataitemid                         | Locator Type | Validation Error                   |
      | State |    | JointAnnuitant_ResidentialAddress_State | Select       | Joint Annuitant State is required. |
    Then User Chooses option for Dropdown
      | Field | Id | data-dataitemid                         | Locator Type | Option  |
      | State |    | JointAnnuitant_ResidentialAddress_State | Select       | Alabama |
    Then User Clears data for the field
      | Field       | Id | data-dataitemid                           | Locator Type |
      | Postal Code |    | JointAnnuitant_ResidentialAddress_Zipcode | Input        |
    Then User verifies Validation Message for
      | Field       | Id | data-dataitemid                           | Locator Type | Validation Error                         |
      | Postal Code |    | JointAnnuitant_ResidentialAddress_Zipcode | Input        | Joint Annuitant Postal Code is required. |
    Then User sets data for the field
      | Field       | Value | Id | data-dataitemid                           | Locator Type |
      | Postal Code | 28134 |    | JointAnnuitant_ResidentialAddress_Zipcode | Input        |
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
      | Owner First Name           | Monkey                  | Owner_FirstName                | Input        |
      | Owner Middle Name          | D                       | Owner_MiddleName               | Input        |
      | Owner Last Name            | Luffy                   | Owner_LastName                 | Input        |
      | Owner Dob                  | 10/11/1965              | Owner_DOB                      | Input        |
      | Owner SSN                  | 545-01-7855             | Owner_SSN                      | Input        |
      | Owner Gender               | Male                    | Owner_Gender                   | Select       |
      | Mailing Address Street     | Enetai Avenue Northeast | Owner_MailingAddress1          | Input        |
      | City                       | Tacoma                  | Owner_MailingAddress_City      | Input        |
      | zip                       | 98422                  | Owner_MailingAddress_Zipcode      | Input        |
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
      | Mailing Address Street      | North Garland Court   | JointAnnuitant_MailingAddress1            | Input        |
      | City                        | Chicago               | JointAnnuitant_MailingAddress_City        | Input        |
      | zip                         | 28134                 | JointAnnuitant_MailingAddress_Zipcode     | Input        |
      | State                       | IL                    | JointAnnuitant_MailingAddress_State       | Select       |
      | Residential Address Street  | North Garland Court   | JointAnnuitant_ResidentialAddress1        | Input        |
      | City                        | Oak Park              | JointAnnuitant_ResidentialAddress_City    | Input        |
      | ZipCode                     | 28134                 | JointAnnuitant_ResidentialAddress_Zipcode | Input        |
      | State                       | Alabama               | JointAnnuitant_ResidentialAddress_State   | Select       |
      | Primary Phone Number        | (786) 456-4464        | JointAnnuitant_Primary_PhoneNumber        | Input        |
      | Email Address               | testdata@jointann.com | JointAnnuitant_Primary_EmailAddress       | Input        |
    Then User Clicks on Button "Next"
    Then User verifies Page heading "Beneficiary Module: Separate" with form name "Beneficiary" for data entry flow