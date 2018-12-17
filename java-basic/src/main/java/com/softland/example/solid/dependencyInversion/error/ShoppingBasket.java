/**
 * https://devexperto.com/principio-de-inversion-de-dependencias/
 * Principio de Inversión de Dependencias (SOLID 5ª parte)
 * 
 * Ejemplo:
 * Imaginemos que tenemos una cesta de la compra que lo que hace es almacenar la información y llamar al 
 * método de pago para que ejecute la operación. Nuestro código sería algo así:
 * 
 * Aquí estamos incumpliendo todas las reglas que impusimos al principio. 
 * Una clase de más alto nivel, como es la cesta de la compra, está dependiendo de otras de alto nivel, 
 * como cuál es el mecanismo para almacenar la información o para realizar el método de pago. 
 * Se encarga de crear instancias de esos objetos y después utilizarlas.
 * 
 * Piensa ahora qué pasa si quieres añadir métodos de pago, o enviar la información a un servidor en vez 
 * de guardarla en una base de datos local. No hay forma de hacer todo esto sin desmontar toda la lógica.
 * 
 * 
 */
package com.softland.example.solid.dependencyInversion.error;

public class ShoppingBasket {
	 
	public static void main(String[] args) {
		Shopping shopping = new Shopping(); 
		buy(shopping);
	}
	
	
    public static void buy(Shopping shopping) {
 
        SqlDatabase db = new SqlDatabase();
        db.save(shopping);
         
        CreditCard creditCard = new CreditCard();
        creditCard.pay(shopping);
    }
}
 
class SqlDatabase {
    public void save(Shopping shopping){
        // Saves data in SQL database
    	System.out.println("Saves data in SQL database");
    }
}
 
class CreditCard {
    public void pay(Shopping shopping){
        // Performs payment using a credit card
    	System.out.println("Performs payment using a credit card");
    }
}
