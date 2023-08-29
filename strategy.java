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
    private ICalcAverage _calcAverage;
    private String _name;
    private double _p1;
    private double _p2;
    private double _average;
    private String _situation;
    
    public ICalcAverage getCalcAverage() {
        return _calcAverage;
    }
    public void setCalcAverage(ICalcAverage calcAverage) {
        this._calcAverage = calcAverage;
    }
    
    public double getAverage() {
        return _average;
    }
    public void setAverage(double average) {
        this._average = average;
    }
    
    public String getName() {
        return _name;
    }
    public void setName(String name) {
        this._name = name;
    }
    
    public double getP1() {
        return _p1;
    }
    public void setP1(double p1) {
        this._p1 = p1;
    }
    
    public double getP2() {
        return _p2;
    }
    public void setP2(double p2) {
        this._p2 = p2;
    }
    
    public String getSituation() {
        return _situation;
    }
    public void setSituation(String situation) {
        this._situation = situation;
    }
	
    public void calculateAverage() {
        _average = _calcAverage.calcAverage(_p1, _p2);
        _situation = _calcAverage.situation(_average);
    }
    public Discipline(ICalcAverage averageCalculator) {
        _calcAverage = averageCalculator;
    }
}
