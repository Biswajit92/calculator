package com.example.calculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	public String str="";
	Character op='q';
	double nm,num,numtemp,rm;
	int i;
	EditText showresult;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
	showresult=(EditText)findViewById(R.id.result_id);
	
	}
	
	
	public void btn1Clicked(View v)
	{
		insert(1);
	}
	
	public void btn2Clicked(View v)
	{
		insert(2);
	}
	
	public void btn3Clicked(View v)
	{
		insert(3);
	}
	
	public void btn4Clicked(View v)
	{
		insert(4);
	}
	
	public void btn5Clicked(View v)
	{
		insert(5);
	}
	
	public void btn6Clicked(View v)
	{
		insert(6);
	}
	
	public void btn7Clicked(View v)
	{
		insert(7);
	}
	
	public void btn8Clicked(View v)
	{
		insert(8);
	}
	
	public void btn9Clicked(View v)
	{
		insert(9);
	}
	
	public void btn0Clicked(View v)
	{
		insert(0);
	}
	
	public void btnplusClicked(View v)
	{
		perform();
		op='+';
	}
	
	public void btnminusClicked(View v)
	{
		perform();
		op='-';
	}
	
	public void btndivideClicked(View v)
	{
		perform();
		op='/';
	}
	
	public void btnmultClicked(View v)
	{
		perform();
		op='*';
	}
	
	public void btnpowerClicked(View v)
	{
		perform();
		op='^';
	}
	
	public void btnmodClicked(View v)
	{
		perform();
		op='%';
	}
	
	public void btnperClicked(View v)
	{
		perform();
		op='.';
	}
	
	public void btnfactClicked(View v)
	{
		perform();
		op='!';
	}
	
	public void btnsqrtClicked(View v)
	{
		perform();
		op='@';
	}
	
	
	public void btnequalClicked(View v)
	{
		calculate();
	}
	
	public void btnclearClicked(View v)
	{
		reset();
	}
	
	public void reset()
	{
		str="";
		op='q';
		num=0.0;
		nm=0;
		numtemp=0.0;
		showresult.setText("");
	}
	
	public void insert(int j)
	{
		str=str+Integer.toString(j);
		num=Integer.valueOf(str).intValue();
		showresult.setText(str);
	}
	
	public void perform()
	{
		str="";
		numtemp=num;
	}
	
	public void calculate()
	{
		if(op=='+')
			num=numtemp+num;
		else if (op=='-')
			num=numtemp-num;
		else if (op=='/')
			num=numtemp/num;
		else if (op=='*')
			num=numtemp*num;
		else if (op=='^')
		{
			nm=numtemp;
			for(i=1;i<num;i++)
				numtemp=nm*numtemp;
			num=numtemp;
		}
		else if (op=='%')
		{
			 nm= ((int)(numtemp/num));
			 rm= numtemp/num;
			 double n= rm-nm;
			 num=((int)(n*num));
			
		}
		
		else if (op=='!')
		{
			rm=1;
			for(nm=1;nm<=num;nm++)
				rm=rm*nm;
			num=rm;
		}
		

		else if (op=='@')
		{
			num=(numtemp/2);
			do
			{
				nm=num;
				rm=nm+(numtemp/nm);
				num=rm/2;
			}
			while ((nm-num)!=0);
			
		}
		else if (op=='.')
			num=numtemp*(num/100.0);
			
		showresult.setText(""+num);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
