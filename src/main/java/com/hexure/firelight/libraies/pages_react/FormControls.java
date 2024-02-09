package com.hexure.firelight.libraies.pages_react;

public enum FormControls {

    TEXTBOX("Text Box"),
    CHECKBOX("CheckBox"),
    CALENDAR("Calendar"),
    RADIOBUTTON("Radio Button"),
    COMBOBOX("Combo Box"),
    LABEL("Label"),
    SIGNATURE_BOX("Signature Box"),
    SIGNATURE_INITIALS("Signature Initials"),
    BARCODE("BarCode"),
    BUTTON("Button"),
    ADDRESS_AUTOCOMPLETE("Address_Autocomplete");

    private final String text;

    FormControls(String text){ this.text = text;}

    public String getText(){ return  text;}
}
