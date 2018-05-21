package soft;
/*import java.sql.*;
import java.io.*;
import java.util.*;
public class Test 
	{
	 public static void main(String str[]) {
	 //public static Connection getConnection()
		//{
			Connection con=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","system");
			   System.out.println("connection success") ;  
			   String query1="CREATE TABLE mytable(name VARCHAR(20), sex CHAR(1))";
			   Statement stmt=con.createStatement();
			      stmt.executeUpdate(query1);
			      System.out.println(" table created");
			      
			      
			      
			    
			    
			}
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//return con;
		     }
	 }*/
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Test 
  {
	public static void main (String[] args)
	  {
	    
	    int t;
	    Scanner sc=new Scanner(System.in);
	    t=sc.nextInt();    
	    int i=0,ch;
	    int a[]=new int [t];   
	    while(t!=0)
	    {
	         //for(int i=0;i<t;i++)
	        ch=sc.nextInt();
	        
	        if(i==0) {
	            a[0]=ch;
	            System.out.println(a[0]);
	            ++i;
	            --t;
	        }
	        else{
	        for(int k=i ;k>=0;k--)
	        {
	            
	            if(a[k]<=ch)
	            {
	                a[k+1]=ch;
	                 break;
	                }
	             
	            else
	            {
	               a[k+1]=a[k];
	               
	               }
	        }
	        if((i&1) ==0)
	        {
	            System.out.println(a[i/2]);
	        }
	        else {
	            System.out.println((a[i/2]+a[(i/2)+1])/2);
	        }}
	        
	        ++i;--t;
	        }
	    
	    
	}
}