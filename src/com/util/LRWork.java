package com.util;

public class LRWork {
	  public double calAbility(double b,String file){
	    	 LogisticRegression m = new LogisticRegression(file,0.001,2000000);
	        double[] theta= m.trainTheta();
	        System.out.println("b的值是:"+b);
	        System.out.println("theta的值："+theta[0]+" "+theta[1]);
	        double theta0=theta[0];
	    	double theta1=theta[1];
	    	double z=(-1)*theta0-theta1*b;
	    	double h=(1/(1+Math.pow(Math.E, z)));
	    	System.out.println("h="+h);
	    	return h;
	    	
	    }

}
