package pageObjects;

import org.testng.annotations.Test;

public class CompareArray {
	@Test
	
	public void CompareArray()
	{
		int a[] = {1,2,3,4,5,6};
		
		for(int b = 0 ; b<=a.length;b++)
		{
			for(int c = 0;c<a.length;c++)
			if(a[b]>a[c])
			{
			System.out.println(b);
			break;
			}
			
			
		}
		
	}
	

}
