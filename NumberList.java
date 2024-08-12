import java.util.ArrayList;
import java.lang.Math;

public class NumberList {

    float pearsonDenominator;
    ArrayList<Float> mainList = new ArrayList<Float>();

    float sum = 0;
    

    public NumberList(ArrayList<Float> inList) {
        this.mainList = inList;

        float squaredSum = 0;
        float sqelements = 0;

        for (int i = 0; i<inList.size(); i++) {
            this.sum = this.sum + inList.get(i);
            sqelements = sqelements + (inList.get(i) * inList.get(i));
        
        }

        squaredSum = sum * sum;
        pearsonDenominator = (inList.size() * sqelements) - squaredSum;

    }

    
    public double getpearsonCorrelation(NumberList inList) {
        double result = 0;
        for (int i = 0; i<inList.mainList.size(); i++) {
            result = result + (inList.mainList.get(i) * mainList.get(i));
        }

        result = (result * mainList.size()) - (this.sum * inList.sum);

        double denominator = Math.sqrt(this.pearsonDenominator * inList.pearsonDenominator);

        result = result / denominator;

        return result;
    }

}