package baseballGame;

import java.util.ArrayList;

public class BaseballGameSolution {
	public static void main(String[] args) {
		String[] test1 = {"5", "2", "C", "D", "+"};
		String[] test2 = {"5","-2","4","C","D","9","+","+"};
		System.out.println("test1: " + calPoints(test1));
		System.out.println("test2: " + calPoints(test2));
	}
	
	public static int calPoints(String[] ops) {
        ArrayList<Integer> record = new ArrayList<Integer>();
        for(String op : ops){
            if(Character.isDigit(op.charAt(0)) || op.length() > 1){
                record.add(Integer.parseInt(op));
                continue;
            }
            if(op.equals("C")){
                record.remove(record.size() - 1);
                continue;
            }
            if(op.equals("D")){
                int lastDigit = (record.get(record.size() - 1));
                record.add(lastDigit * 2);
                continue;
            }
            if(op.equals("+")){
                int num1 = (record.get(record.size() - 1));
                int num2 = (record.get(record.size() - 2));
                record.add(num1 + num2);
            }
        }
        int sum = 0;
        for(int i = 0; i < record.size(); i++){
            sum += record.get(i);
        }
        return sum;
    }
}
