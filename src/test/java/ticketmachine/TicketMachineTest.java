package ticketmachine;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class TicketMachineTest {
	private static final int PRICE = 50; // Une constante

	private TicketMachine machine; // l'objet à tester

	@BeforeEach
	public void setUp() {
		machine = new TicketMachine(PRICE); // On initialise l'objet à tester
	}

	@Test
	// On vérifie que le prix affiché correspond au paramètre passé lors de
	// l'initialisation
	// S1 : le prix affiché correspond à l’initialisation.
	void priceIsCorrectlyInitialized() {
		// Paramètres : valeur attendue, valeur effective, message si erreur
		assertEquals(PRICE, machine.getPrice(), "Initialisation incorrecte du prix");
	}

	@Test
	// S2 : la balance change quand on insère de l’argent
	void insertMoneyChangesBalance() {
		machine.insertMoney(10);
		machine.insertMoney(20);
		assertEquals(10 + 20, machine.getBalance(), "La balance n'est pas correctement mise à jour");
	}

	@Test
		// S3 : on n’imprime pas le ticket si le montant inséré est insuffisant

	void insertMoneyChangesPrice(){
		machine.insertMoney(10);
		machine.insertMoney(20);
		assertEquals(10 + 20, machine.getBalance(), "La balance n'est pas correctement mise à jour.");


	}
	@Test
		// S4 : on imprime le ticket si le montant inséré est suffisant

	void nImprimePasSiBalanceInsuffisante(){
		machine.insertMoney(PRICE -1);
		assertFalse(machine.printTicket(), "Pas assez d'argent, on ne doit pas imprimer.");
	}

	@Test

	void imprimeSiBalanceSuffisante() {
		machine.insertMoney(PRICE);
		assertTrue(machine.printTicket(), "Assez d'argent, on devrait imprimer");
	}

	// S5 :  après impression la balance est décrémentée du prix du ticket
	@Test
	void balanceDecrementeeApresImpression() {
		machine.insertMoney(PRICE);
		machine.printTicket();
		assertEquals(0, machine.getBalance(), "La balance n'a pas été correctement décrémentée");
	}

	// S6 : montant collecté mis à jour lors de l'impression d'un ticket
	@Test
	void montantMajApresImpression() {
		machine.insertMoney(PRICE);
		machine.printTicket();
		assertEquals(PRICE, machine.getTotal(), "Le total collecté n'est pas mis à jour");
	}

	// S7 : rend correctement la monnaie
	@Test
	void rendBienLaMonnaie() {
		machine.insertMoney(30);
		assertEquals(30, machine.refund(), "Le remboursement n'est pas correct");
	}

	// S8 : refund() remet la balance à zéro
	@Test
	void remetBalanceAZero() {
		machine.insertMoney(30);
		machine.refund();
		assertEquals(0, machine.getBalance(), "La balance n'est pas remise à zéro après remboursement");
	}

	// S9 : on ne peut pas insérer un montant négatif
	@Test
	void nAcceptePasMontantNegatif() {
		assertThrows(IllegalArgumentException.class, () -> machine.insertMoney(-10), "Montant négatif accepté");
	}

	// S10 : on ne peut pas créer une machine avec un prix de ticket négatif
	@Test
	void nePasCreerTicketPrixNegatif() {
		assertThrows(IllegalArgumentException.class, () -> new TicketMachine(-50), "Prix de ticket négatif accepté");
	}
}




