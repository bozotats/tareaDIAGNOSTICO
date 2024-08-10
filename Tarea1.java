import java.io.*;
import java.util.ArrayList;
import java.lang.Math;

public class Tarea1 {
    
    static ArrayList<Float> listMinusItsAverage(ArrayList<Float> inList , Float listAverage) {

        ArrayList<Float> outList = new ArrayList<Float>();
        
        for (int i = 0; i<inList.size(); i++) {
            outList.add(inList.get(i) - listAverage);    
        }

        return outList;

    }

    static ArrayList<Float> listElementsSquared(ArrayList<Float> inList) {

        ArrayList<Float> outList = new ArrayList<Float>();

        for (int i = 0; i<inList.size(); i++){
            outList.add(inList.get(i) * inList.get(i));
        }

        return outList;

    }

    static float SDfromsum(ArrayList<Float> inList) {
        double outFloat = 0;

        for (int i = 0; i<inList.size(); i++) {
        outFloat = outFloat + inList.get(i);
        }

        outFloat = outFloat / inList.size();

        outFloat = Math.sqrt(outFloat);
        
        return (float) outFloat;

    }

    static ArrayList<Float> divideElementsbySD(ArrayList<Float> inList, float StndDeviValue) {
        ArrayList<Float> dividedlist = new ArrayList<Float>();
        for (int i = 0; i < inList.size(); i++) {
            dividedlist.add(inList.get(i) / StndDeviValue);
        }

        return dividedlist;

    }

    static float covariance(ArrayList<Float> inList1,ArrayList<Float> inList2) {
        float result = 0;
        for (int i = 0; i<inList1.size(); i++) {
            result = result + (inList1.get(i) * inList2.get(i));
        }

        result = result /(inList1.size() - 1);

        return result;
    }

    public static void main(String[] args) throws Exception{   
        File csv = new File("./startup-profit.csv");
        BufferedReader reader = new BufferedReader(new FileReader(csv));
        String currentline;
        int columnNumber;
        boolean flag = true;
        float tempnumber = 0;
        
        ArrayList<Float> rdSpend = new ArrayList<Float>();
        float totalRND = 0;
        float avgRND = 0;
        

        ArrayList<Float> marketingSpend = new ArrayList<Float>();
        float totalmarketing = 0;
        float avgMarketing = 0;

        ArrayList<Float> profit = new ArrayList<Float>();
        float totalprofit = 0;
        float avgProfit = 0;
        
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
                    totalRND = totalRND + tempnumber;

                        break;
                    case 3:
                        
                            tempnumber = Float.valueOf(
                                currentline.substring(
                                    commaPlacement.get(1)+1,commaPlacement.get(2)
                                )
                            );

                            marketingSpend.add(tempnumber);
                            totalmarketing = totalmarketing + tempnumber;
                        
                        break;
                        
                    case 4:
                        
                            tempnumber = Float.valueOf(
                                currentline.substring(
                                    commaPlacement.get(3)+1,currentline.length()
                                )
                            );
                            profit.add(tempnumber);
                            totalprofit = totalprofit + tempnumber;

                        break;
                    default:
                        break;
                    }

                }
                
                
                

            }
 
        }

         

        avgRND = totalRND / rdSpend.size();
        avgMarketing = totalmarketing / marketingSpend.size();
        avgProfit = totalprofit / profit.size();

        
        

        System.out.println(rdSpend.toString());
        System.out.println(marketingSpend.toString());
        System.out.println(profit.toString());

    }
}