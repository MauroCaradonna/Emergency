package model;

public class TestSimulator {

	public static void main(String[] args) {

		Simulator sim = new Simulator();
		
		// Possiamo impostare i paramtri
		
		sim.init();
		sim.run();
		
		// leggere gli output
		System.out.println("trattati: " + sim.getPatientsTreated());
		System.out.println("abbandonati: " + sim.getPatientsAbandoned());
		System.out.println("morti: " + sim.getPatientsDead());
	}

}
