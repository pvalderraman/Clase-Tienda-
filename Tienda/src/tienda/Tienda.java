/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author josevalderrama
 */
public class Tienda {

    
    private ArrayList<Producto> productos;

    private int totalPagar = 0;

    public Tienda() {

    }

    public Tienda(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }


    
    public int getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(int totalPagar) {
        this.totalPagar = totalPagar;
    }    

    public void mostrarProductos(){
        int i = 1;
        for(Producto producto: productos){
            System.out.println( i++ + " - " + producto.nombre + ": " + producto.valor);
        }
    }
    
    public boolean agregarProducto(Producto producto){
        return productos.add(producto);
    }
    
    
   
    public void menu() {
        int opcion = 0;
        Scanner sc= new Scanner(System.in);
        
        // menu principal
        do {
            System.out.println("");
            System.out.println("1. Entrar a tienda");
            System.out.println("2. Salir");
            do{
                opcion = sc.nextInt();
            } while (opcion != 1 && opcion != 2);
            
            int opcionProducto = 0;
            
            
            //en tienda
            while (opcion == 1) {
                System.out.println("");
                mostrarProductos();
                System.out.println("Seleccione producto y cantidad a comprar: ");
                System.out.println("0. Salir");
                //seleccion de producto
                do {
                    opcionProducto = sc.nextInt();    
                } while (opcionProducto < 0 || opcionProducto > productos.size());
                
                if (opcionProducto == 0) {
                    break;
                }
                
                Producto producto = productos.get(opcionProducto-1);
                
                System.out.println("producto: " + producto.nombre + " " + producto.valor);
                
                System.out.println("");
                System.out.println("Cantidad a comprar: ");
                int cantidadCompra = 0;
                // cantidad de compra del producto
                do {
                    cantidadCompra = sc.nextInt();    
                } while (cantidadCompra < 0);
            
                if (cantidadCompra == 0) {
                    break;
                }
                
                totalPagar += producto.valor * cantidadCompra;
            
            }
            
        } while (opcion != 2);    
        
        System.out.println("el total a pagar es: " + totalPagar);
    }

    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();
        
        Tienda tienda = new Tienda(productos);
//        inventario.mostrarProductos();

           tienda.agregarProducto(new Producto("Burger", 20)); 
           tienda.agregarProducto(new Producto("Gaseosa", 10));
           tienda.menu();
    }

}

class Producto {

        String nombre;
        int valor;  


        public Producto(String nombre, int valor) {
            this.nombre = nombre;
            this.valor = valor;
        }

}

class ProductoStock extends Producto{
    
    public ProductoStock(String nombre, int valor) {
        super(nombre, valor);
    }
    
}
