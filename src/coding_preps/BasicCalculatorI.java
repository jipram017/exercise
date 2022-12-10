package coding_preps;

import java.util.ArrayList;
import java.util.Stack;

public class BasicCalculatorI {
    public static int calculate(String s) {
        s = s.replaceAll(" ", "");
        Stack<String> stack = new Stack<String>();
        char[] arr = s.toCharArray();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length; i++){
            if(arr[i] == ' ') continue;
            if(arr[i] >= '0' && arr[i] <= '9'){
                sb.append(arr[i]);
                if(i == arr.length - 1){
                    stack.push(sb.toString());
                }
            }
            else{
                if(sb.length() > 0){
                    stack.push(sb.toString());
                    sb = new StringBuilder();
                }
                if(arr[i] != ')'){
                    stack.push(new String(new char[] {arr[i]}));
                }
                else{
                    ArrayList<String> l = new ArrayList<String>();
                    while(!stack.isEmpty()){
                        String ele = stack.pop();
                        if(ele.equals("(")) break;
                        l.add(0, ele);
                    }
                    int temp = 0;
                    if(l.size() == 1){
                        temp = Integer.valueOf(l.get(0));
                    } else {
                        for(int j=l.size()-1; j>0; j=j-2){
                            if(l.get(j-1).equals("-")){
                                temp += 0 - Integer.valueOf(l.get(j));
                            } else {
                                temp += Integer.valueOf(l.get(j));
                            }
                        }
                        if(!l.get(0).equals("-") && !l.get(0).equals("+")){
                            temp += Integer.valueOf(l.get(0));
                        }
                    }
                    stack.push(String.valueOf(temp));
                }
            }
        }

        ArrayList<String> m = new ArrayList<String>();
        while(!stack.isEmpty()){
            String top = stack.pop();
            m.add(0, top);
        }
        int result = 0;
        for(int j=m.size()-1; j>0; j = j-2){
            if(m.get(j-1).equals("-")){
                result += 0 - Integer.valueOf(m.get(j));
            } else{
                result += Integer.valueOf(m.get(j));
            }
        }
        if(!m.get(0).equals("-") && !m.get(0).equals("+")){
            result += Integer.valueOf(m.get(0));
        }
        return result;
    }

    public static void main(String[] args){
        String s = "(1-(4-5))";
        System.out.println(calculate(s));
    }
}
