public class HelloWorld {
    public static void main(String[] args) {
        ICalcAverage calculation = new Arithmetic();
        
        Discipline discipline = new Discipline(calculation);
        discipline.setP1(10);
        discipline.setP2(5);
        discipline.calculateAverage();
        
        System.out.printf("P1: %.2f; P2: %.2f; Média: %.2f; Situação: %s%n", discipline.getP1(), discipline.getP2(), discipline.getAverage(), discipline.getSituation());
    }
}

interface ICalcAverage {
    double calcAverage(double p1, double p2);
    String situation(double average);
}

class Arithmetic implements ICalcAverage {
    public double calcAverage(double p1, double p2) {
        return (p1 + p2) / 2;
    }

    public String situation(double average) {
        return average > 5.0 ? "Aprovado!" : "Reprovado!";
    }
}

class Geometric implements ICalcAverage {
    public double calcAverage(double p1, double p2) { 
        return Math.sqrt(p1 * p2); 
    }

    public String situation(double average) { 
        return average > 7.0 ? "Aprovado!" : "Reprovado!"; 
    }
}

class Discipline {
    private ICalcAverage calcAverage;
    private String name;
    private double p1;
    private double p2;
    private double average;
    private String situation;
    
    public ICalcAverage getCalcAverage() {
        return calcAverage;
    }
    public void setCalcAverage(ICalcAverage calcAverage) {
        this.calcAverage = calcAverage;
    }
    
    public double getAverage() {
        return average;
    }
    public void setAverage(double average) {
        this.average = average;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public double getP1() {
        return p1;
    }
    public void setP1(double p1) {
        this.p1 = p1;
    }
    
    public double getP2() {
        return p2;
    }
    public void setP2(double p2) {
        this.p2 = p2;
    }
    
    public String getSituation() {
        return situation;
    }
    public void setSituation(String situation) {
        this.situation = situation;
    }
	
    public void calculateAverage() {
        average = calcAverage.calcAverage(p1, p2);
        situation = calcAverage.situation(average);
    }
	
    public Discipline(ICalcAverage averageCalculator) {
        calcAverage = averageCalculator;
    }
}
