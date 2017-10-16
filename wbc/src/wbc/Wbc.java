package wbc;

import java.math.BigInteger;

import javax.security.auth.kerberos.KerberosKey;

public class Wbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        double[] p = {0.25,0.25,0.20,0.15,0.10,0.05};
       //降序排序 
        for (int i = 0; i < p.length;i++){
            for(int j = i; j < p.length;j++){
                if (p[i] < p[j]){
                    double temp = p[i];
                    p[i] = p[j];
                    p[i] = temp;
                }
            }
        }
        
        int n = p.length;
        double[] pa = new double[n];
        double[] newp = new double[n];
        double[] k = new double[n];
        for(int i = 1 ; i < n ; i++)
        	pa[i] = pa[i-1] + p[i-1];
        //存码计算
        for(int i = 0 ; i < n ; i++) {
            newp[i] = -Math.log(p[i])/Math.log(2);
            k[i] = Math.ceil(newp[i]);
        }
        //创建一个二维数组作为“元胞数组”
        double [][] c;
        c = new double[1][n];
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < n; i++) {
        	double tmp = pa[i];
        	for(int j = 0; j < k[i] ; j++) {
        		tmp = tmp*2;
        		if( tmp >= 1){
        			tmp = tmp - 1;
        			stringBuilder.append(1);
        		}
        		else {
        			stringBuilder.append(0);
        		}
        	}
        	stringBuilder.append(";");
        	
        } 
        System .out.println(stringBuilder);
//        for(int i = 1; i < n; i++) {
//        	BigInteger c[i] = new BigInteger(k[i]);
//        }
	}

}
