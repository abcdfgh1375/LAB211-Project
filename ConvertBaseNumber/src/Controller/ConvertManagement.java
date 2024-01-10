
package Controller;

import View.Menu;
import java.util.*;
public class ConvertManagement extends Menu{
    ConvertFromDecimal convertDec = new ConvertFromDecimal();
    ConvertFromBinary convertBin = new ConvertFromBinary();
    ConvertFromHexa convertHexa = new ConvertFromHexa();

    public ConvertManagement() {
       super("Choose input base system", Arrays.asList(new String[]{"Decimal numeral system","Binary number system",
           "Hexadecimal number system","Exit"}));
    }
    
    @Override
    public void execute(int choice) {
   switch(choice){
        case 1:
            convertDec.run();
            break;
        case 2:
            convertBin.run();
            break;
        case 3:
            convertHexa.run();
            break;
        case 4:
            System.err.println("Exited.Bye bye!");
            break;
        default:
            System.err.println("Invalid choice!");
    }
}
    
}
