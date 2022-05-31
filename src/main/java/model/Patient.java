package model;

import java.time.LocalTime;
import java.util.Objects;

public class Patient implements Comparable<Patient>{

	public enum ColorCode{
		NEW,                          // in triage
		WHITE, YELLOW, RED, BLACK,    // in sala d'attesa
		TREATING,                     // dentro studio medico
		OUT                           // a casa (curato o abbandonato)
	};
	
	private LocalTime arrivalTime;
	private ColorCode color;
	private int num;
	
	public Patient(LocalTime arrivalTime, ColorCode color, int num) {
		super();
		this.num = num;
		this.arrivalTime = arrivalTime;
		this.color = color;
	}
	public LocalTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public ColorCode getColor() {
		return color;
	}
	public void setColor(ColorCode color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "Patient [arrivalTime=" + arrivalTime + ", color=" + color + ", num=" + num + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(num);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		return num == other.num;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public int compareTo(Patient other) {
		if(this.color.equals(other.color))
			return this.arrivalTime.compareTo(other.arrivalTime);
		else if(this.color.equals(Patient.ColorCode.RED))
			return -1;              // vince this, passa prima il negativo
		else if(other.color.equals(Patient.ColorCode.RED))
			return 1;
		else if(this.color.equals(Patient.ColorCode.YELLOW))
			return -1;
		else
			return 1;
	}
	
}
