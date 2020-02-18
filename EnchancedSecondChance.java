import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class EnchancedSecondChance {
	int hit =0 ; 
	int pageFault =0 ; 
	Random rand = new Random() ;
	
	public EnchancedSecondChance(int size , ArrayList<Integer> referenceString) {
		ArrayList<Integer> modifyReflist = new ArrayList<Integer>();
		for(int i =0 ; i<referenceString.size();i++)
		{
			
			modifyReflist.add (rand.nextInt(2));
			
		}
		
		
		frame Frame = new frame(size ) ;
		ArrayList<Integer> useBitlist = new ArrayList<Integer>(Collections.nCopies(size, 0));
		ArrayList<Integer> modifyBitlist = new ArrayList<Integer>(Collections.nCopies(size, 0));

		for(int i=0 ; i<referenceString.size() ; i++)
		{
			if(!Frame.isFull&&!Frame.frameList.contains(referenceString.get(i)))
			{
				Frame.addToFrame(referenceString.get(i));
				pageFault++ ;
				useBitlist.set(Frame.frameList.indexOf(referenceString.get(i)), 1) ; 
				modifyBitlist.set(Frame.frameList.indexOf(referenceString.get(i)), modifyReflist.get(i)) ;
			}
	

			else if ( Frame.frameList.contains(referenceString.get(i)))
			{
				hit ++ ; 
			}
		
			
			else 
			{
				
				
				boolean Stop = false ;
				while(!Stop) 
			{
				
					
					
						for(int M=0 ; M<Frame.frameList.size() ; M++) {
					if(useBitlist.get(M)==0&&modifyBitlist.get(M)==0)
					{
						Frame.frameList.set(M, referenceString.get(i)) ;
						pageFault++ ;
						useBitlist.set(Frame.frameList.indexOf(referenceString.get(i)), 1) ; 
						modifyBitlist.set(Frame.frameList.indexOf(referenceString.get(i)), modifyReflist.get(i)) ;
						Stop = true  ;
						break ;
					}
						}
						if(!Stop) {
						for(int M=0 ; M<Frame.frameList.size() ; M++) {
					 if (useBitlist.get(M)==0&&modifyBitlist.get(M)==1)
					{
						Frame.frameList.set(M, referenceString.get(i)) ;
						pageFault++ ;
						useBitlist.set(Frame.frameList.indexOf(referenceString.get(i)), 1) ; 
						modifyBitlist.set(Frame.frameList.indexOf(referenceString.get(i)), modifyReflist.get(i)) ;
						Stop = true  ;
						break ;
					}
						else
						{
							useBitlist.set(M, 0) ;
						}
						
						}
					
				
					 }
					
					
					
				
				
				
				
				}
			
			
			}
			
			System.out.print("\t");
			for(int Z =0 ; Z<Frame.frameList.size() ; Z++)
			{
				System.out.print(Frame.frameList.get(Z)+"\t");
				
			}
			System.out.println();
			System.out.print("bits state: " );
			for(int Z =0 ; Z<Frame.frameList.size() ; Z++)
			{
			System.out.print("("+useBitlist.get(Z)+","+modifyBitlist.get(Z) +")"+"\t") ; 
			}
			
			System.out.println();
		
		}
		
		
		
	}


public static void main(String[] args) {
	ArrayList<Integer> ref = new ArrayList<Integer>();  
	Random rand = new Random() ;
	ref.add(2) ; 
	ref.add(3) ;
	ref.add(4) ;
	ref.add(2) ;
	ref.add(1) ;
	ref.add(6) ;
	ref.add(8) ;
	ref.add(12) ;
	ref.add(4) ;
	ref.add(3) ;
	ref.add(10) ;
	ref.add(9) ;
	ref.add(8) ;
	EnchancedSecondChance ec = new EnchancedSecondChance(5,ref);
	System.out.println("there is " +ec.pageFault+" page faults ");
}


}
