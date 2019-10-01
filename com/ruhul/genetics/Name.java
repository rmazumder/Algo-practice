package com.ruhul.genetics;

public class Name{

    private String name = "ruhul";


    public int getLength(){
        return name.length();
    }

    public int checkResult(String predictedName){

        float successCount = 0;
        for(int i=0 ; i< name.length(); i++ ) {
            if(name.charAt(i) == predictedName.charAt(i)){
                successCount ++;
            }
        }

        float score = successCount/getLength()  * 100;
        return (int)score;

    }


    public static void main(String r[]){

        Name name = new Name();
        System.out.println(name.getLength());
        System.out.println(name.checkResult("rzzzzzz"));
    }

}
