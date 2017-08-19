package com.util;

	import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Math;


	public class LogisticRegression {

	    private double [][] trainData;//训练数据，一行一个数据，每一行最后一个数据为 y
	    private int row;//训练数据  行数
	    private int column;//训练数据 列数
	    
	    private double [] theta;//参数theta
	    
	    private double alpha;//训练步长
	    private int iteration;//迭代次数
	    
	    public LogisticRegression(String fileName)
	    {   
	        int rowoffile=getRowNumber(fileName);//获取输入训练数据文本的   行数
	        int columnoffile = getColumnNumber(fileName);//获取输入训练数据文本的   列数
	        
	        trainData = new double[rowoffile][columnoffile+1];//这里需要注意，为什么要+1，因为为了使得公式整齐，我们加了一个特征x0，x0恒等于1
	        this.row=rowoffile;
	        this.column=columnoffile+1;
	        
	        this.alpha = 0.001;//步长默认为0.001
	        this.iteration=100000;//迭代次数默认为 100000
	        
	        theta = new double [column-1];
	        initialize_theta();
	        
	        loadTrainDataFromFile(fileName,rowoffile,columnoffile);
	    }
	    public LogisticRegression(String fileName,double alpha,int iteration)
	    {   
	        int rowoffile=getRowNumber(fileName);//获取输入训练数据文本的   行数
	        int columnoffile = getColumnNumber(fileName);//获取输入训练数据文本的   列数
	        
	        trainData = new double[rowoffile][columnoffile+1];//这里需要注意，为什么要+1，因为为了使得公式整齐，我们加了一个特征x0，x0恒等于1
	        this.row=rowoffile;
	        this.column=columnoffile+1;
	        
	        this.alpha = alpha;
	        this.iteration=iteration;
	        
	        theta = new double [column-1];
	        initialize_theta();//将theta各个参数全部初始化为1.0
	        
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
	    
	    private void initialize_theta()//将theta各个参数全部初始化为1.0
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
	            //对每个theta i 求 偏导数
	            double [] partial_derivative = compute_partial_derivative();//偏导数
	                //更新每个theta
	            for(int i =0; i< theta.length;i++)
	                theta[i]-= alpha * partial_derivative[i];
	        }
	        return theta;
	    }
	    
	    private double [] compute_partial_derivative()
	    {
	        double [] partial_derivative = new double[theta.length];
	        for(int j =0;j<theta.length;j++)//遍历，对每个theta求偏导数
	        {
	            partial_derivative[j]= compute_partial_derivative_for_theta(j);//对 theta j 求 偏导
	        }
	        return partial_derivative;
	    }
	    private double compute_partial_derivative_for_theta(int j)
	    {
	        double sum=0.0;
	        for(int i=0;i<row;i++)//遍历 每一行数据
	        {
	            sum+=h_theta_x_i_minus_y_i_times_x_j_i(i,j);
	        }
	        return sum/row;
	    }
	    private double h_theta_x_i_minus_y_i_times_x_j_i(int i,int j)
	    {
	        double[] oneRow = getRow(i);//取一行数据，前面是feature，最后一个是y
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
	    
	    private double [] getRow(int i)//从训练数据中取出第i行，i=0，1，2，。。。，（row-1）
	    {
	        return trainData[i];
	    }
	    
	    
	    //把文件中的数据存到trainData，trainData的第一列恒为1.0
	    private void loadTrainDataFromFile(String fileName,int row, int column)
	    {   
	        for(int i=0;i< row;i++)//trainData的第一列全部置为1.0（feature x0）
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

