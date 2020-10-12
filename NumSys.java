import java.io.*;

public class NumSys{
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        String x = br.readLine();
        StringBuilder res = new StringBuilder();
        int len = x.length();
        long sum = 0;

        if(a != 10){
            for(int i = 0; i < len; i++){ 
                long val = 0;
                int temp = (int) x.charAt(i);
                
                if(temp > 47 && temp < 58)
                    val += temp - 48;
                else
                    val += temp - 87;

                for(int j = len - i - 2; j >= 0 ; j--)
                    val *= a;

                sum += val;
            }   
        }
        else
            sum = Long.parseLong(x); 

        if(b != 10){
            while(sum > 0){
                long val = 0;
                char temp;

                val = sum % b;
                sum /= b;

                if(val > 9)
                    val += 87;
                else
                    val += 48;

                res.insert(0, (char) val);
            }   
        }
        else
            res.append(sum);
        
        System.out.println(res);
    }
}