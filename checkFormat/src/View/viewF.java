
package View;

public class viewF {
    public String getInput(String msg){
        InputterF in = new InputterF();
        return in.getStringFromInput(msg);
    }
    
    public void displayMsg(String res){
        if(res!= null){System.out.println(res);}
    }
}
