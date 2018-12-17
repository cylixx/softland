/**
 * https://devexperto.com/principio-de-inversion-de-dependencias/
 * Principio de Inversión de Dependencias (SOLID 5ª parte)
 * 
 * ¿Cómo lo solucionamos?
 * Primer paso, dejar de depender de concreciones. Vamos a crear interfaces que definan el comportamiento 
 * que debe dar una clase para poder funcionar como mecanismo de persistencia o como método de pago:
 * 
 * ¿Ves la diferencia? 
 * Ahora ya no dependemos de la implementación particular que decidamos. 
 * Pero aún tenemos que seguir instanciándolo en ShoppingBasket.
 * Nuestro segundo paso es invertir las dependencias. Vamos a hacer que estos objetos se pasen por constructor:
 * 
 * ¿Y si ahora queremos pagar por Paypal y guardarlo en servidor? 
 * Definimos las concreciones específicas para este caso, y se las pasamos por constructor a la cesta de la compra:
 * 
 */
package com.softland.example.solid.dependencyInversion.ok;

import com.softland.example.solid.dependencyInversion.error.Shopping;

public class ShoppingBasket {
	private final Persistence persistence;
    private final PaymentMethod paymentMethod;
 
    public ShoppingBasket(Persistence persistence, PaymentMethod paymentMethod) {
        this.persistence = persistence;
        this.paymentMethod = paymentMethod;
    }
 
    public void buy(Shopping shopping) {
        persistence.save(shopping);
        paymentMethod.pay(shopping);
    }
    
    
    public static void main(String[] args) {
    	Shopping shopping = new Shopping(); 
//    	ShoppingBasket shoppingBasket = new ShoppingBasket(new SqlDatabase(), new CreditCard()); 
    	ShoppingBasket shoppingBasket = new ShoppingBasket(new Server(), new Paypal());
    	shoppingBasket.buy(shopping);
	}
}
