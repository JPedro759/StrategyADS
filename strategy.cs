using System;

public class HelloWorld {
    public static void Main(string[] args) {
        Arithmetic calculation = new(); 
        
        Discipline discipline = new(calculation);
        discipline.P1 = 10;
        discipline.P2 = 5;
	discipline.CalculateAverage();
        
	Console.WriteLine($"P1: {discipline.P1:F2}; P2: {discipline.P2:F2}; Média: {discipline.Average:F2}; Situação: {discipline.Situation}");
    }
}

interface ICalcAverage {
    public double calcAverage(double p1, double p2);
    public string situation(double average);
}

class Arithmetic : ICalcAverage {
    public double calcAverage(double p1, double p2) {
        return (p1 + p2) / 2;
    }

    public string situation(double average) {
        return average > 5.0 ? "Aprovado!" : "Reprovado!";
    }
}

class Geometric : ICalcAverage {
    public double calcAverage(double p1, double p2) { 
        return Math.Sqrt(p1 * p2); 
    }

    public string situation(double average) { 
        return average > 7.0 ? "Aprovado!" : "Reprovado!"; 
    }
}

class Discipline {
    private ICalcAverage _calcAverage;
    private string _name;
    private double _p1;
    private double _p2;
    private double _average;
    private string _situation;
    
    public ICalcAverage CalcAverage { get => _calcAverage; set => _calcAverage = value; }
    public double Average { get => _average; set => _average = value; }
    public string Name { get => _name; set => _name = value; }
    public double P1 { get => _p1; set => _p1 = value; }
    public double P2 { get => _p2; set => _p2 = value; }
    public string Situation { get => _situation; set => _situation = value; }
	
    public void CalculateAverage() {
	Average = _calcAverage.calcAverage(P1, P2);
	Situation = _calcAverage.situation(Average);
    }
    
    public Discipline(ICalcAverage average) {
        _calcAverage = average;
    }
}
