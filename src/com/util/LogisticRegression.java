package com.util;

	import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Math;


	public class LogisticRegression {

	    private double [][] trainData;//ѵ�����ݣ�һ��һ�����ݣ�ÿһ�����һ������Ϊ y
	    private int row;//ѵ������  ����
	    private int column;//ѵ������ ����
	    
	    private double [] theta;//����theta
	    
	    private double alpha;//ѵ������
	    private int iteration;//��������
	    
	    public LogisticRegression(String fileName)
	    {   
	        int rowoffile=getRowNumber(fileName);//��ȡ����ѵ�������ı���   ����
	        int columnoffile = getColumnNumber(fileName);//��ȡ����ѵ�������ı���   ����
	        
	        trainData = new double[rowoffile][columnoffile+1];//������Ҫע�⣬ΪʲôҪ+1����ΪΪ��ʹ�ù�ʽ���룬���Ǽ���һ������x0��x0�����1
	        this.row=rowoffile;
	        this.column=columnoffile+1;
	        
	        this.alpha = 0.001;//����Ĭ��Ϊ0.001
	        this.iteration=100000;//��������Ĭ��Ϊ 100000
	        
	        theta = new double [column-1];
	        initialize_theta();
	        
	        loadTrainDataFromFile(fileName,rowoffile,columnoffile);
	    }
	    public LogisticRegression(String fileName,double alpha,int iteration)
	    {   
	        int rowoffile=getRowNumber(fileName);//��ȡ����ѵ�������ı���   ����
	        int columnoffile = getColumnNumber(fileName);//��ȡ����ѵ�������ı���   ����
	        
	        trainData = new double[rowoffile][columnoffile+1];//������Ҫע�⣬ΪʲôҪ+1����ΪΪ��ʹ�ù�ʽ���룬���Ǽ���һ������x0��x0�����1
	        this.row=rowoffile;
	        this.column=columnoffile+1;
	        
	        this.alpha = alpha;
	        this.iteration=iteration;
	        
	        theta = new double [column-1];
	        initialize_theta();//��theta��������ȫ����ʼ��Ϊ1.0
	        
	        loadTrainDataFromFile(fileName,rowoffile,columnoffile);
	    }
	    
	    
	    private int getRowNumber(String fileName)
	    {
	        int count =0;
	        File file = new File(fileName);
	        BufferedReader reader = null;
	        try {
	            reader = new BufferedReader(new FileReader(file));
	            while ( reader.readLine() != null) 
	                count++;
	            reader.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (reader != null) {
	                try {
	                    reader.close();
	                } catch (IOException e1) {
	                }
	            }
	        }
	        return count;
	        
	    }
	    
	    private int getColumnNumber(String fileName)
	    {
	        int count =0;
	        File file = new File(fileName);
	        BufferedReader reader = null;
	        try {
	            reader = new BufferedReader(new FileReader(file));
	            String tempString = reader.readLine();
	            
	            if(tempString!=null)
	            {
	                String [] temp = tempString.split(" ");
	                for(String s : temp)
	                    if(!s.equals("") && s!=null)
	                        count++;
	            }
	           
	            reader.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (reader != null) {
	                try {
	                    reader.close();
	                } catch (IOException e1) {
	                }
	            }
	        }
	        return count;
	    }
	    
	    private void initialize_theta()//��theta��������ȫ����ʼ��Ϊ1.0
	    {
	        for(int i=0;i<theta.length;i++)
	            theta[i]=1.0;
	    }
	    
	    public double[] trainTheta()
	    {
	        int count = 0;
	        int iteration = this.iteration;
	        while( (count++) < iteration)
	        {
	           // System.out.print(count);
	          //  printTheta();
	            //��ÿ��theta i �� ƫ����
	            double [] partial_derivative = compute_partial_derivative();//ƫ����
	                //����ÿ��theta
	            for(int i =0; i< theta.length;i++)
	                theta[i]-= alpha * partial_derivative[i];
	        }
	        return theta;
	    }
	    
	    private double [] compute_partial_derivative()
	    {
	        double [] partial_derivative = new double[theta.length];
	        for(int j =0;j<theta.length;j++)//��������ÿ��theta��ƫ����
	        {
	            partial_derivative[j]= compute_partial_derivative_for_theta(j);//�� theta j �� ƫ��
	        }
	        return partial_derivative;
	    }
	    private double compute_partial_derivative_for_theta(int j)
	    {
	        double sum=0.0;
	        for(int i=0;i<row;i++)//���� ÿһ������
	        {
	            sum+=h_theta_x_i_minus_y_i_times_x_j_i(i,j);
	        }
	        return sum/row;
	    }
	    private double h_theta_x_i_minus_y_i_times_x_j_i(int i,int j)
	    {
	        double[] oneRow = getRow(i);//ȡһ�����ݣ�ǰ����feature�����һ����y
	        double result = 0.0;
	        
	        result += h_thera_x_i(oneRow);
	        result-=oneRow[oneRow.length-1];
	        result*=oneRow[j];
	        
	        return result;
	    }
	    private double h_thera_x_i(double [] oneRow)
	    {
	        double theta_T_x = 0.0;
	        for(int k=0;k< (oneRow.length-1);k++)
	            theta_T_x += theta[k]*oneRow[k];
	        
	        return 1/(1+(Math.exp(0-theta_T_x)));
	    }
	    
	    private double [] getRow(int i)//��ѵ��������ȡ����i�У�i=0��1��2������������row-1��
	    {
	        return trainData[i];
	    }
	    
	    
	    //���ļ��е����ݴ浽trainData��trainData�ĵ�һ�к�Ϊ1.0
	    private void loadTrainDataFromFile(String fileName,int row, int column)
	    {   
	        for(int i=0;i< row;i++)//trainData�ĵ�һ��ȫ����Ϊ1.0��feature x0��
	            trainData[i][0]=1.0;
	        
	        File file = new File(fileName);
	        BufferedReader reader = null;
	        try {
	            reader = new BufferedReader(new FileReader(file));
	            String tempString = null;
	            int counter = 0;
	            while ( (counter<row) && (tempString = reader.readLine()) != null) {
	                String [] tempData = tempString.split(" ");
	                int numOfTrainData = 0;
	                for(int i=0;i<column;i++)
	                {
	                    while(tempData[numOfTrainData] == null || tempData[numOfTrainData].equals(""))
	                        numOfTrainData++;
	                                 
	                    trainData[counter][i+1]=Double.parseDouble(tempData[numOfTrainData]);
	                    numOfTrainData ++;
	                }
	                    
	                counter++;
	            }
	            reader.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (reader != null) {
	                try {
	                    reader.close();
	                } catch (IOException e1) {
	                }
	            }
	        }
	    }
	    
	    public void printTrainData()
	    {
	        System.out.println("Train Data:\n");
	        for(int i=0;i<column-1;i++)
	            System.out.printf("%10s","x"+i+" ");
	        System.out.printf("%10s","y"+" \n");
	        for(int i=0;i<row;i++)
	        {
	            for(int j=0;j<column;j++)
	            {
	                System.out.printf("%10s",trainData[i][j]+" ");
	            }
	            System.out.println();
	        }
	        System.out.println();
	    }
	    
	    public void printTheta()
	    {    
	        System.out.print("theta: ");
	        for(double a:theta)
	            System.out.print(a+" ");
	        System.out.println();
	    }
	    
	  
	}

