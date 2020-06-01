
 /*
  *  Parts 1-4  &  Bonus A completed 
  *  Bonus B, C started
  */



import java.util.Scanner;

public class BlackJack2 {

	public static void main(String[] args) {
		
		
    	int x = (int)(Math.random()*13)+1;	
    	int y = (int)(Math.random()*13)+1;
    	
    	
    	int td = 0;
    	if(x == 11 || x == 12 || x == 13){
    		td += 10;
    	}  else {
    		td += x;
    	}
    	
    	if(y == 11 || y == 12 || y == 13){
    		td += 10;
    	} else {
    		td += y;
    	}
    	
    	
    	if (x == 1){
    		if((td + 11) < 21){
    			td += 11;
    		}else{
    			td += 1;
    		}
    	}	
    	
    	if (y == 1){
    		if((td + 11) < 21){
    			td += 11;
    		}else{
    			td += 1;
    		}
    	}
    	
    	if( x != 11 && x != 12 && x != 13 && x != 1 && y != 11 && y != 12 && y != 13 && y != 1){
    	System.out.println("Dealer:   " + x + "  "+ y + "  Total: " + td);
    	} else {
    		
    		System.out.print("Dealer:   ");
    		if ( x == 11 ){
    			System.out.print(" J ");
    		} else if ( x == 12 ){
    			System.out.print(" Q ");
    		} else if ( x == 13 ){
    			System.out.print(" K ");
    		} else if ( x == 1 ){
    			System.out.print(" A ");
    		} else {
    			System.out.print(" " + x + " ");
    		}
    		
    		if ( y == 11 ){
    			System.out.print(" J ");
    		} else if ( y == 12 ){
    			System.out.print(" Q ");
    		} else if ( y == 13 ){
    			System.out.print(" K ");
    		} else if ( y == 1 ){
    			System.out.print(" A ");
    		} else {
    			System.out.print(" " + y + " ");
    		}
    		
    		System.out.println("  Total: " + td);
    	}
    	
    	
    	
    	int a = (int)(Math.random()*13)+1;	
    	int b = (int)(Math.random()*13)+1;	
    	
    	
    	int tp = 0;
    	if(a == 11 || a == 12 || a == 13){
    		tp += 10;
    	} else {
    		tp += a;
    	}
    	
    	if(b == 11 || b == 12 || b == 13){
    		tp += 10;
    	} else {
    		tp += b;
    	}
    	
    	if (x == 1){
    		if((td + 11) < 21){
    			td += 11;
    		}else{
    			td += 1;
    		}
    	}	
    	
    	if (y == 1){
    		if((td + 11) < 21){
    			td += 11;
    		}else{
    			td += 1;
    		}
    	}
    	
    	
    	if( x != 11 && x != 12 && x != 13 && x != 1 && y != 11 && y != 12 && y != 13 && y != 1){
        	System.out.println("Player:   " + a + "  "+ b + "  Total: " + tp);
        	} else {
        		
        		System.out.print("Player:   ");
        		if ( a == 11 ){
        			System.out.print(" J ");
        		} else if ( a == 12 ){
        			System.out.print(" Q ");
        		} else if ( a == 13 ){
        			System.out.print(" K ");
        		} else if ( a == 1 ){
        			System.out.print(" A ");
        		} else {
        			System.out.print(" " + a + " ");
        		}
        		
        		if ( b == 11 ){
        			System.out.print(" J ");
        		} else if ( b == 12 ){
        			System.out.print(" Q ");
        		} else if ( b == 13 ){
        			System.out.print(" K ");
        		} else if ( b == 1 ){
        			System.out.print(" A ");
        		} else {
        			System.out.print(" " + b + " ");
        		}
        		
        		System.out.println("  Total: " + tp);
        	}
    	
    	
    	
    	
    	System.out.println("Hit or Stay?");
    	Scanner kboard = new Scanner(System.in);
  	    
  	    String action = kboard.next( );
  	    
  	    while(action.equalsIgnoreCase("hit")){
  	    
  	    	int n = (int)(Math.random()*13)+1;	
  	    	if(n == 11 || n == 12 || n == 13){
  	    		tp += 10;
  	    	} else {
  	    		tp += n;
  	    	}
  	    	System.out.println("Player hits! " + n + "  Total: " + tp);
  	    	
  	    	if( x != 11 && x != 12 && x != 13 && x != 1 && y != 11 && y != 12 && y != 13 && y != 1){
	        	System.out.println("Player hits! " + n + "  Total: " + tp); 
	        	} else {
	        		
	        		System.out.print("Player hits! ");
	        		if ( x == 11 ){
	        			System.out.print(" J ");
	        		} else if ( x == 12 ){
	        			System.out.print(" Q ");
	        		} else if ( x == 13 ){
	        			System.out.print(" K ");
	        		} else if ( x == 1 ){
	        			System.out.print(" A ");
	        		} else {
	        			System.out.print( x );
	        		}
	        		
	        		System.out.println("  Total: " + tp);
	        	}
	    	
	    } 
  	    	
  	    	System.out.print("--> ");
  	  	    action = kboard.next( );  
  	     
  	    
  	    if(tp <= 21 && (tp > td || td > 21)){
    		System.out.println("Player wins");
    	} else if(tp <= 21 && tp == td){
    		System.out.println("Draw");
    	} else {
    		System.out.println("Dealer wins.");
    	}
  	    
	}

}
