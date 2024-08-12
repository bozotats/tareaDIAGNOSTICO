import java.io.*;
import java.util.ArrayList;
import java.lang.Math;  

public class Tarea1 {

    public static void main(String[] args) throws Exception{   
        File csv = new File("./startup-profit.csv");
        BufferedReader reader = new BufferedReader(new FileReader(csv));
        String currentline;
        int columnNumber;
        boolean flag = true;
        float tempnumber = 0;
        
        ArrayList<Float> rdSpend = new ArrayList<Float>();
        ArrayList<Float> marketingSpend = new ArrayList<Float>();
        ArrayList<Float> profit = new ArrayList<Float>();
        
        
        ArrayList<Integer> commaPlacement = new ArrayList<Integer>();
        
        while ((currentline = reader.readLine()) != null) {
            if (flag) {
                flag = false;
                continue;
            }
            columnNumber = 0;
            commaPlacement.clear();
            for (int i = 0; i < currentline.length(); i++) {
                if (currentline.charAt(i) == ',') {
                    columnNumber++;
                    commaPlacement.add(i);
                    System.out.println(commaPlacement.toString());
                    switch(columnNumber) {
                    case 1:
                    tempnumber = Float.parseFloat(
                                currentline.substring(
                                    0,commaPlacement.get(0)
                                )
                            );
                    rdSpend.add(tempnumber);
                        break;
                    case 3:                        
                            tempnumber = Float.valueOf(
                                currentline.substring(
                                    commaPlacement.get(1)+1,commaPlacement.get(2)
                                )
                            );
                            marketingSpend.add(tempnumber);
                        break;
                    case 4:
                            tempnumber = Float.valueOf(
                                currentline.substring(
                                    commaPlacement.get(3)+1,currentline.length()
                                )
                            );
                            profit.add(tempnumber);
                        break;
                    default:
                        break;
                    }
                }
            }
        }

        NumberList rdSpendList = new NumberList(rdSpend);
        NumberList marketSpendList = new NumberList(marketingSpend);
        NumberList profitList = new NumberList(profit);

        System.out.println("la correlacion de pearson entre RD spent y profit es de: " + rdSpendList.getpearsonCorrelation(profitList));
        System.out.println("la correlacion de pearson entre Marketing spent y profit es de: " + marketSpendList.getpearsonCorrelation(profitList));

    }
}