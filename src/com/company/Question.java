package com.company;/*A Question is used to partition a dataset.
    This class just records a 'column number' (e.g., 0 for Color) and a
    'column value' (e.g., Green). The 'match' method is used to compare
    the feature value in an example to the feature value stored in the
    question. See the demo main Class.*/

import static com.company.Main.header;
import static com.company.Main.is_numeric;
 class Question{
    private String value;
    private int column;
    private String condition = "==";

    public Question(int column, String value) {
        this.column = column;
        this.value = value;

    }

    boolean match(String[] example ){
        String val = example[this.column];
        if (is_numeric(val)){
            return Float.parseFloat(val) >= Float.parseFloat(this.value);
        }else
            return val.equals(this.value);
    }

    public void printQuestion(){
        if (is_numeric(this.value))
            condition = ">=";

        System.out.println("Is "+header[this.column]+" "+condition+" " + value + "?" );
    }
}