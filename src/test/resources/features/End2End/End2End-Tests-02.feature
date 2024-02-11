Feature: FireLight_End2End_Tests

  This feature will verify UAT Application End2End Tests

  @End2EndTest
  Scenario: TC_02_Complete the REACT application with Pre Signature Review with Signature Then Submit
    Given User is on FireLight login page for TestCase "End2End_TC_02"
    Then User on Login Page enters valid username as "Ashwani_FBW" and password and clicks Login button
    Then User clicks "Application" Tab
    Then User Verifies "Jurisdiction" field is present
    Then User Verifies "ProductType" field is present
    Then User selects Jurisdiction "Alabama"
    Then User selects Product Type Dropdown "Variable Annuity"
    Then User opens Given Product "Variable Annuity" for application
    Then User clicks "Create" button
    Then User enters new Application name
    Then User clicks on Create button on Rename window
    Then User verifies New Application gets created
    Then User opens "Financials" Required for Form "Suitability Module"
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
      | Field                       | Value | data-dataitemid                     | Locator Type |
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
      | Life Insurance Cash Value $ | 74854 | FinInfo_NonLiquidAssets_LifeInsurance | Input        |
    Then User Verifies input value for field is getting converted into Currency Value
      | Field                       | Id                      |
      | Life Insurance Cash Value $ | LifeInsuranceCashValue$ |
    Then User sets data for the field
      | Field   | Value | data-dataitemid               | Locator Type |
      | Other $ | 56734 | FinInfo_NonLiquidAssets_Other | Input        |
    Then User Verifies input value for field is getting converted into Currency Value
      | Field   | Id     |
      | Other $ | Other$ |
    Then User Verifies input value for field is getting converted into Currency Value
      | Field  | data-dataitemid               |
      | Total$ | FinInfo_NonLiquidAssets_Total |
    Then User verifies field should display sum of all above fields
      | Field  | Id | data-dataitemid               | Value   | Locator Type |
      | Total$ |    | FinInfo_NonLiquidAssets_Total | 1286234 | Input        |
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
    Then User verifies text fields Present in UI
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
      | Field                                          | Id                                      | data-dataitemid   | Locator Type | Option      |
      | What is your Federal Tax Bracket? (Select One) | WhatisyourFederalTaxBracket?(SelectOne) | Owner_TaxRate     | Select       | 10%         |
      | What is your Federal Tax Bracket? (Select One) | WhatisyourFederalTaxBracket?(SelectOne) | Owner_TaxRate     | Select       | 15%         |
      | What is your Federal Tax Bracket? (Select One) | WhatisyourFederalTaxBracket?(SelectOne) | Owner_TaxRate     | Select       | 25%         |
      | What is your Federal Tax Bracket? (Select One) | WhatisyourFederalTaxBracket?(SelectOne) | Owner_TaxRate     | Select       | 28%         |
      | What is your Federal Tax Bracket? (Select One) | WhatisyourFederalTaxBracket?(SelectOne) | Owner_TaxRate     | Select       | 33%         |
      | What is your Federal Tax Bracket? (Select One) | WhatisyourFederalTaxBracket?(SelectOne) | Owner_TaxRate     | Select       | 35%         |
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
