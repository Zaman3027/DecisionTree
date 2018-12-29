package com.company;

import java.util.*;

public class Main {

    static ArrayList<String[]> traningData = new ArrayList<>();
    static String header[] = {"Colour","Diameter","Label"};

    public static void main(String[] args) {
        //Traning Data List
        traningData.add(new String[]{"Green", "3", "Apple"});
        traningData.add(new String[]{"Yellow", "3", "Apple"});
        traningData.add(new String[]{"Red", "1", "Grape"});
        traningData.add(new String[]{"Red", "1", "Grape"});
        traningData.add(new String[]{"Yellow", "3", "Lemon"});

        //demo of class_count.
        System.out.println(class_count(traningData).entrySet());

        //demo of unique_val.
        System.out.println(unique_val(traningData,2));

        //demo of is value is numeric.
        System.out.println(is_numeric("hello"));

        //demo of class question.
        Question question = new Question(0,"Green");
        question.printQuestion();

        //demo of match method of class Question.
        System.out.println(question.match(traningData.get(0)));
        Partition partition = new Partition(traningData,new Question(0,"Red"));
        System.out.println("\nTrue Row");
        partition.print(partition.getTrue_row());

        System.out.println("\nFalse Row");
        partition.print(partition.getFalse_row());
        

        System.out.println(info_gain(partition.getFalse_row(),partition.getTrue_row(),gini(traningData)));

    }

    private static double info_gain(ArrayList<String[]> false_row, ArrayList<String[]> true_row, double gini) {
        double p = (double)(false_row.size())/((double)(false_row.size()) + (double)(true_row.size()));
        return gini - p*gini(false_row) - (1-p)*gini(true_row);
    }

    //Find the unique values for a column in a dataSet.
    public static ArrayList<String> unique_val(ArrayList<String[]> traningData, int row){
        ArrayList<String> unique_val = new ArrayList<>();
        for (int i =0; i<traningData.size(); i++){
            String key = traningData.get(i)[row];
            if (unique_val.isEmpty())
                unique_val.add(key);
            else if (!unique_val.contains(key))
                unique_val.add(key);
        }
        return unique_val;

    }

    //a dictionary of label -> count. always use label in last entry.
    public static HashMap<String,Integer > class_count(ArrayList<String[]> traningData){
        int row  = traningData.get(0).length-1;
        HashMap<String ,Integer> class_count_list = new HashMap<String, Integer>();
        for (int i =0; i<traningData.size(); i++){
            String key = traningData.get(i)[row];
            if (class_count_list.isEmpty()){
                class_count_list.put(key,1);
            }else {
                for (int j = 0; j<class_count_list.size(); j++){
                    if (class_count_list.containsKey(key)) {
                        class_count_list.replace(key,class_count_list.get(key),class_count_list.get(key)+1);
                        break;
                    }
                    else{
                        class_count_list.put(key,1);
                        break;
                    }

                }
            }
        }


        return  class_count_list;
    }

    //Check is value is numeric or string
    public static boolean is_numeric(String value){
        try {
            float check = Float.parseFloat(value);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public static double gini(ArrayList<String []> rows){
        HashMap<String ,Integer> count = class_count(rows);
        double impurity = 1.0;
        for (Map.Entry<String,Integer> entry : count.entrySet()){
            double prob_of_lbl = (double)entry.getValue()/(double)rows.size();
            //System.out.println(Math.pow(prob_of_lbl,2.0));
            impurity =  impurity -  Math.pow(prob_of_lbl,2);
        }

        return impurity;
    }





}
