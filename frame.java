import java.util.ArrayList;

public class frame {
	ArrayList<Integer> frameList=new ArrayList<Integer>();
	int frameSize ;
	boolean isFull ;
	boolean secondChanceBit ; 
	public frame(int size ) {
		this.frameSize = size ; 
	}
	public int currentLocation()
	{
		if(frameList.size()==0 ) {return 0 ;}
		for(int i =0 ; i < frameList.size() ; i++ )
		{
			
			if(frameList.get(i)== null)	return i ;
				
			
		}
		
		
		return -1 ;
	}
	
	
	public boolean isFull()
	{
		if(frameList.size() ==frameSize )
		{
			isFull = true ; 
			return true ;
			}
		return false ; 
		
	}
	public void addToFrame (int ref )
	{
	
		frameList.add(ref) ; 
		isFull() ; 
	}

	
	public void replacePage ( int location ,int ref   )
	{
		frameList.set(location, ref) ; 
		
	}
	
}
