package com.hexure.firelight.libraies;

public enum  EnumsCommon {
    TOVISIBLE("ToVisible"),
    TOINVISIBLE("ToInvisible"),
    ATTRIBUTENOTEMPTY("AttributeNotEmpty"),
    ATTRIBUTECONTAINSPERCENTAGE("AttributeContainsPercentage"),
    SELECT("select"),
    UNCHECK("uncheck"),
    TOCLICKABLE("ToClickable"),
    CLICK("click"),
    UITYPE_REACT("react"),
    UITYPE_MVC("mvc"),
    RELATIVE_DOWNLOADFILES_PATH("./src/test/resources/testdata/downloadedFiles/"),
    ABSOLUTE_DOWNLOADFILES_PATH(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\downloadedFiles\\"),
    CHROMEBROWSER("Chrome"),
    EDGEBROWSER("Edge"),
    FIREFOXBROWSER("Firefox")
    ;

    private final String text;

    EnumsCommon(String text){ this.text = text;}

    public String getText(){ return  text;}
}