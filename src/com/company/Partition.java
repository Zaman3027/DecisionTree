package com.company;

import java.util.ArrayList;

 class Partition{
    private ArrayList<String[]> true_row = new ArrayList<>();
    private ArrayList<String[]> false_row = new ArrayList<>();
    private ArrayList<String[]> traningData;
    private Question question;

    public Partition(ArrayList<String[]> traningData, Question question) {
        this.traningData = traningData;
        this.question = question;
        partition();
    }

    public ArrayList<String[]> getTrue_row() {
        return true_row;
    }

    public ArrayList<String[]> getFalse_row() {
        return false_row;
    }

    private void partition(){
        for(int i =0; i<this.traningData.size(); i++){
            String row[] = traningData.get(i);
            if (question.match(row))
                this.true_row.add(row);
            else
                this.false_row.add(row);
        }


    }

    public void print(ArrayList<String[]> row){
        for (int i = 0; i<row.size(); i++){
            System.out.print("{" );
            for (int j =0; j<row.get(i).length; j++){
                System.out.print(row.get(i)[j]+ ",");
            }
            System.out.print("} \n");


        }
    }
}
