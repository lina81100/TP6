package ticketmachine;

public class TicketMachine {
	private final int price; // Le prix d'un ticket
	private int balance; // Balance en cours (montant inséré par l'utilisateur)
	private int total; // Total collecté depuis le démarrage

	/**
	 * Crée une machine qui délivre des tickets au prix spécifié
	 *
	 * @param ticketCost Le prix d'un ticket, doit être positif
	 */
	public TicketMachine(int ticketCost) {
		if (ticketCost <= 0) {
			throw new IllegalArgumentException("Le prix du ticket doit être positif");
		}
		this.price = ticketCost;
		this.balance = 0;
		this.total = 0;
	}

	/**
	 * Retourne le prix du ticket.
	 *
	 * @return Le prix du ticket
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * Retourne le montant total collecté par la machine.
	 *
	 * @return Le montant total collecté
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * Retourne le montant inséré pour le prochain ticket.
	 *
	 * @return Le montant inséré
	 */
	public int getBalance() {
		return balance;
	}

	/**
	 * Reçoit un montant d'argent en centimes.
	 *
	 * @param amount Le montant inséré, en centimes (doit être positif)
	 */
	public void insertMoney(int amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("Le montant inséré doit être positif");
		}
		balance += amount;
	}

	/**
	 * Rembourse le montant de la balance à l'utilisateur.
	 *
	 * @return Le montant de la balance
	 */
	public int refund() {
		int refundAmount = balance;
		balance = 0;
		return refundAmount;
	}

	/**
	 * Imprime un ticket si le montant inséré est suffisant.
	 * Met à jour le total et réduit la balance en conséquence.
	 *
	 * @return vrai si le ticket a été imprimé, faux sinon
	 */
	public boolean printTicket() {
		if (balance >= price) {
			System.out.println("##################");
			System.out.println("# The BlueJ Line");
			System.out.println("# Ticket");
			System.out.println("# " + price + " cents.");
			System.out.println("##################");
			System.out.println();

			balance -= price;
			total += price;
			return true;
		} else {
			return false;
		}
	}
}
