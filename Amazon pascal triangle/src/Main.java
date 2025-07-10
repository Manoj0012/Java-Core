import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Integer> data= Arrays.asList(1,2,3,4);
        pascal(data);
    }
    public static void pascal(List<Integer> data){
        Queue<Integer> q=new LinkedList<>(data);
        while(q.size()>2){
            int len=q.size();
            System.out.println(q);
            for(int i=1;i<len;i++){
                int sum=(q.poll()+q.peek())%10;
                q.add(sum);
            }
            q.poll();
        }
        System.out.println(q.poll()+""+q.peek());
    }
}