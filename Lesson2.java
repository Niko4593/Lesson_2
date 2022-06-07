package Lesson_2;


public class Lesson2 {
    static String[][] badArray = {{"*", "b", "5", "d"}, {"g", "7", "z", "+"}};
    static String[][] goodArray = {
            {"1", "2", "3", "4"},
            {"5", "6", "7", "8"},
            {"9", "10", "11", "12"},
            {"13", "14", "15", "16"}
    };
    static int size1 = 4;
    static int size2 = 4;


    public static void main(String[] args) {

        try {
            System.out.println("Missive amount: " + getSumm(goodArray));
        } catch (MyArraySizeException | MyArrayDataException ex){
            System.out.println(ex.getMessage());
        }

        try {
            System.out.println("Missive amount: " + getSumm(badArray));
        } catch (MyArraySizeException | MyArrayDataException ex){
            System.out.println(ex.getMessage());
        }
    }

    static void lengthСheck(String[][] goodArray) throws MyArraySizeException{
        if (goodArray.length!=size1 || goodArray[0].length!=size2) throw new MyArraySizeException();
    }

    static Integer getSumm(String[][] goodArray) throws MyArrayDataException,MyArraySizeException{
        lengthСheck(goodArray);
        Integer result = 0;
        int i =0;
        int j =0;
        try {
            for (; i < goodArray.length; i++) {
                j =0;
                for (; j < goodArray.length; j++) {
                    result = result + Integer.parseInt(goodArray[i][j]);
                }
            }
        } catch (NumberFormatException ex){
            throw new  MyArrayDataException("Error in position: " + i+","+j);
        }

        return result;
    }

    public static class MyArraySizeException extends Exception {
        public MyArraySizeException(){
            super("Size error");
        }
    }
    public static class MyArrayDataException extends Exception {
        public MyArrayDataException(String message){
            super(message);
        }
    }

}




