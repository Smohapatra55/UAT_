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

#    Then User Verifies data entry percentage is "95%"
#    Then User verifies "Continue" Button should be disable
#    Then User clicks date entry error count 16 and verify pages
#    Then User verifies Required for Form "Annuity Wizard"
#      | Client Data |
#      | Beneficiary |
#      | Agent       |
#    Then User verifies Optional for Form "Annuity Wizard"
#      | Payment Details |
#      | Riders          |
#      | Arrangements    |
#      | Allocations     |
#      | Suitability     |
#    Then User opens "Client Data" Required for Form "Annuity Wizard"
#    Then User verifies Page heading "Annuity Wizard" with form name "Client Data" for data entry flow
#    Then User selects radio button "Joint" for "Owner Type"
#    Then User selects radio button "Yes" for field "Does the owner have existing or pending life insurance or annuity policies?" from section "Replacement Questions"
#    Then User selects radio button "Yes" for field "Are there plans to discontinue, reduce, change or replace any existing life insurance or annuity contracts?" from section "Replacement Questions"
#    Then User clicks "Next" button
#    Then User verifies required fields should show error
#      | First Name    |
#      | Last Name     |
#      | Date of Birth |
#      | Zip Code      |
#    Then User fills required fields and verify fields error should not display "false"
#      | Field         | Value         |
#      | First Name    | UserFirstName |
#      | Last Name     | UserLastName  |
#      | Date of Birth | 21/09/2023    |
#      | Zip Code      | 12345         |
#    Then User clicks "Next" button
#    Then User fills required fields and verify fields error should not display "false"
#      | Field         | Value        |
#      | First Name    | JointOwnerFN |
#      | Date of Birth | 21/09/2023   |
#    Then User clicks "Next" button
#    Then User selects value "1" for field "How many Primary Beneficiaries do you have?"
#    Then User selects value "Spouse" for field "Relationship to Owner"
#    Then User verifies field error "This is a required field." for field "First Name"
#    Then User verifies field error "This is a required field." for field "Last Name"
#    Then User verifies Red bubble icon at top right corner should be display "True"
#    Then User set value "10" for field "Percentage of Proceeds"
#    Then User verifies field error "All beneficiary percentage fields must add up to 100%." for field "Percentage of Proceeds"
#    Then User verifies Red bubble icon at top right corner should be display "True"
#    Then User set value "100" for field "Percentage of Proceeds"
#    Then User set value "UFirstName" for field "First Name"
#    Then User set value "ULastName" for field "Last Name"
#    Then User clicks "Next" button
#    Then User verifies field error "This field is required. (OFFICE USE ONLY)" for field "First Name"
#    Then User verifies field error "This field is required. (OFFICE USE ONLY)" for field "Last Name"
#    Then User verifies Red bubble icon at top right corner should be display "True"
#    Then User fills required fields and verify fields error should not display "false"
#      | Field      | Value          |
#      | First Name | AgentFirstName |
#      | Last Name  | AgentLastName  |
#    Then User clicks "Next" button
#    Then User verifies Page heading "Annuity Wizard" with form name "Payment Details" for data entry flow
#    Then User selects value "Replacement/Transfer/Rollover" for field "Payment Method"
#    Then User clicks "Surrendering Company Lookup" button
#    Then User verifies dialog window "CRM"
#    Then User verifies CRM search output
#      | Search Value | Search link                                                               | Company                                       | Company Details                                                                                                             |
#      | VOYA         | Voya Retirement Insurance and Annuity Company » Fixed and Indexed Annuity | Voya Retirement Insurance and Annuity Company | \nCedingCarrierID : 17368\nLocationId : 19900\nUniversalLocationId : C000005618\nPhone : 8003695303\nFaxNumber : 5154462498 |
#    Then User clicks "Select" button
#    Then User opens "Page 1" Optional for Form "Replacement Instruction Page"
#    Then User verifies Page heading "Replacement Instruction Page" with form name "Page 1" for data entry flow
#    Then User opens "Page 1" Required for Form "Application222"
#    Then User verifies Page heading "Application222" with form name "Page 1" for data entry flow
#    Then User verifies prefilled form
#      | Field          | Value         | data-dataitemid                  | Locator Type | Validation Error                            |
#      | First Name     | UserFirstName | Owner_FirstName                  | Input        |                                             |
#      | Last Name      | UserLastName  | Owner_LastName                   | Input        |                                             |
#      | Zip Code       | 12345         | Owner_ResidentialAddress_Zipcode | Input        |                                             |
#      | Date of Birth  | 21/09/2023    | JointOwner_DOB                   | Input        |                                             |
#      | Contact Number |               | Contract_Number                  | Input        | This is a required field. (OFFICE USE ONLY) |
#    Then User verifies Red bubble icon at top right corner should be display "True"
#    Then User fills required fields and verify fields error should not display "false"
#      | Field           | Value          |
#      | Contract_Number | 1234567890     |
#    Then User verifies Red bubble icon at top right corner should be display "False"
#    Then User Verifies data entry percentage is "99%"
#    Then User opens Menu "Other Actions  ->Documents"
#    Then User verifies dialog window "Documents"
#    Then User selects value "Illustration" for field "Document Type"
#    Then User uploads Document "TestUpload"
#    Then User clicks "Upload" button
#    Then User verifies "Remove" and "View" link after uploading documents
#    Then User clicks "Close" button
#    Then User Verifies data entry percentage is "99%"
#    Then User opens "Page 4" Required for Form "Application222"
#    Then User verifies Page heading "Application222" with form name "Page 4" for data entry flow
#    Then User fills required fields and verify fields error should not display "false"
#      | Field            | Value          |
#      | Agent_FLIDNumber | 12345          |
#      | Agent_Commission | 100            |
#    Then User clicks "Next" button
#    Then User fills required fields and verify fields error should not display "false"
#      | Field            | Value          |
#      | Client_DOB       | 30/03/1990          |
#    Then User clicks "Next" button
#    Then User Verifies data entry percentage is "100%"
#    Then User verifies Optional for Form "Application222"
#      | Page 4|
#    Then User clicks "Next" button
#    Then User Verifies Data Entry Met Toast popup is showing
#    Then User clicks on "enter more data" link of data entry met Toast popup
#    Then User opens Menu "Other Actions  ->Display/Print PDF"
#    Then User selects check box "Report PDF"
#    Then User clicks "Print Selected Documents" button
#    Then User verifies pdf text in "PrintPdf" document
#      | Value         |
#      | UserFirstName |
#      | UserLastName  |
#      | 12345         |
#      | 21/09/2023    |
#    Then User clicks "Continue" button
#    Then User clicks "Send" E-Review
#    Then User clicks Link "Add Reviewer"
#    Then User sets value "Reviewer Deepak"  for field "Reviewer Name" for Send Email To Reviewer page
#    Then User selects check box "Reviewer" for Send Email To Reviewer page
#    Then User sets value "dbhati@hexure.com"  for field "Reviewer Email" for Send Email To Reviewer page
#    Then User clicks Send Email Request and verify Page Email Requests Sent with Message and Passcode
#      | Page Name     | Email Send To                                             | Passcode message                              |
#      | Email Requests Sent | An email was sent to Reviewer Deepak at dbhati@hexure.com | Please advise all recipients to use Passcode: |
#    Then User clicks button Back to app
#    Then User verifies toast message "Finished 1 of 4 Steps. Agent and Client signatures are needed."
#    Then User verifies dialog window "Pending Requests"
#    Then User verifies Pending Request dialog details
#      | Recipient       | Email Sent To     |
#      | Reviewer Deepak | dbhati@hexure.com |
#    Then User verifies Pending Request dialog links
#      | Send Reminder to Reviewer Deepak         |
#      | Send Passcode to Reviewer Deepak`s email |
#      | Cancel Request                           |
#    Then User clicks Send Reminder to "Send Reminder to" link, message template should show.
#    Then User Note down the URL for external link from Message template.
#    Then User clicks "Send" button
#    Then User opens Menu "Home"
#    Then User verifies Application status as "Pending Pre-Submit Review"
#    Then User opens Menu "Log Off"
#    Then User loads the External Reviewer URL noted in step 72 and login with passcode noted on step69.
#    Then User clicks "Review" button
#    Then User clicks Lock and Review Order
#    Then User verifies pdf text in "DisplayApplication" document
#      | Value         |
#      | UserFirstName |
#      | UserLastName  |
#      | 12345         |
#      | 21/09/2023    |
#    Then User verifies Approve, Reject, More Info Buttons are now enabled.
#    Then User clicks on Approve, Then on dialog window enter your own comment and click Approve
#    Then User verifies Application should be removed from current Queue DSB
#    Then User opens Menu "Log Off"
#    Given User is on FireLight login page for TestCase "End2End_TC_01"
#    Then User on Login Page enters valid username as "AUTOUser1_FLADEMO2" and password and clicks Login button
#    Then User verifies Application status as "Pre-Submit Review: Approved"
#    Then User open Application "Pre-Submit Review: Approved"
#    Then User verifies toast message "Finished 2 of 4 Steps. Please Continue."
#    Then User verifies "REVIEW" tab is green tick mark
#    Then User verifies "DATA ENTRY" tab is green tick mark
#    Then User opens Menu "Other Actions  ->History"
#    Then User verifies Audit History
#      | Status                        | Status Description                                                                                                                                                                                                                                              |
#      | Review Complete               | The review process has completed.                                                                                                                                                                                                                               |
#      | Review Approval Email Sent    | A review queue approval email was sent to AUTOUser1_FLADEMO2_AUTO.                                                                                                                                                                                              |
#      | Activity Approved             | This application has been processed and approved by the reviewer [Reviewer Deepak] and has been released to the carrier. Please contact the carrier if you have any further questions about the status of this application. Test Comment for AT Lifetime Income |
#      | Locked for Review             | Activity was locked to begin the review process.                                                                                                                                                                                                                |
#      | Login By External             | 'Reviewer Deepak' is logged in via an external page request for activity 'Pre Submit'.                                                                                                                                                                          |
#      | Agent Sent Email to Client    | Agent AutoUser1 sent email via Message Center to client Reviewer Deepak (dbhati@hexure.com) regarding activity AT Lifetime Income                                                                                                                               |
#      | E-Approval Request Sent       | 'AutoUser1' has sent e-Approval Request email to 'Reviewer Deepak' at 'dbhati@hexure.com'.                                                                                                                                                                      |
#      | Locked for Pre-Submit Review. | Activity locked. Pre-approval signature pending.                                                                                                                                                                                                                |
#      | Print Initiated               | Print action was initiated by 'AUTOUser1_FLADEMO2_AUTO'.                                                                                                                                                                                                        |
#      | Updates by Agent              | Activity updated by 'AUTOUser1_FLADEMO2_AUTO'                                                                                                                                                                                                                   |
#    Then User clicks "Continue" button
#    Then User selects "Use E-Signature" button on Signature Tab
#    Then User selects "Owner" button on Signature Tab
#    Then User selects "Payor" button on Signature Tab
#    Then User verifies "Agent : AutoUser1" button should be disabled
#    Then User selects "Proceed" button on Signature Tab
#    Then User selects "Sign Now" button on Signature Tab
#    Then User verifies Agent ID "FLADEMO2_AUTO001"
#    Then  User verifies Owner Payor - Client Identification Verification window should be present
#    Then User sets value "09876"  for field "ID Number" for To Signature tab
#    Then User sets value "OwnerName"  for field "Name" for To Signature tab
#    Then User sets value "9876"  for field "Last 4 Digits of SSN/Government ID" for To Signature tab
#    Then User sets value "12/31/1999"  for field "Birth Date" for To Signature tab
#    Then User sets value "abc@abc.com"  for field "Email Address" for To Signature tab
#    Then User selects "Verified" button on Signature Tab
#    Then User should be on Owner Initial page
#    Then User verifies Initials are required in this document set. message on Owner Initial page
#    Then User clicks "Next Page" button 3 times till last page
#    Then User clicks initials check box and enters "MR"
#    Then User clicks "Ok" on Confirmation Dialog
#    Then user clicks check box I have reviewed and agree with the terms expressed within this document. 3 times
#    Then User should be on page "Capture Electronic Signature"
#    Then User sets value "FullName Signer"  for field "Signer Full Name" for To Signature tab
#    Then User sets value "Pune"  for field "City" for To Signature tab
#    Then User perform Signature on Signature Pad
#    Then User selects "I Consent" button on Signature Tab
#    Then User verifies Completed signature
#      | Signature Type | Name            | State   |
#      | Owner / Payor: | FullName Signer | Arizona |
#    Then User selects "Re-Sign" button on Signature Tab
#    Then User clicks "Cancel" on Confirmation Dialog
#    Then User selects "Agent : AutoUser1" button on Signature Tab
#    Then User should be on page "Agent Signature Choice for Agent : AutoUser1"
#    Then User selects "Sign Now" button on Signature Tab
#    Then User clicks check box Confirm all documents without reviewing individually. 1 times
#    Then User clicks "OK" on Confirmation Dialog
#    Then User sets value "Pune"  for field "City" for To Signature tab
#    Then User perform Signature on Signature Pad
#    Then User selects "I Consent" button on Signature Tab
#    Then User verifies toast message "Finished 3 of 4 Steps. Please Continue."
#    Then User clicks "Continue" button
#    Then User clicks "Yes" button
#    Then User verifies toast message "Application is pending transmission." or "Application is finished." on Signature page
#    Then User verifies toast message "To print or view the application, history or documents, click on Other Actions." on Signature page
#    Then User verifies toast message "Thank you for your business!" on Signature page
#    Then User verifies "FINALIZE" tab is green tick mark
#    Then User verifies "SIGNATURES" tab is green tick mark
#    Then User clicks on "Other Action" link of data entry met Toast popup
#    Then User verifies menu "Unlock" should not be present
#    Then User opens Menu "Home"
#    Then User verifies Application Status on Recent Activity is "Pending Transmission" or "Complete" now

