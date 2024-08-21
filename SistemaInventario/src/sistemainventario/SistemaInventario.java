/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemainventario;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author 50240
 */
public class SistemaInventario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // configuracion Inicial del sistema
        
        Scanner scan = new Scanner (System.in);
        
        //configuracion Inicial del Sistema de Gestion de Inventario 
        
        // verificar si el archivo de configuracion existe.
        
      File archivoConfiguracion = new File ("Admin.txt");
      
      if (archivoConfiguracion.exists()){ // abre 1er if
      
          // Si el archivo de configuración existe, cargar contraseña del administrador
          
          String administrador = cargarContraseñaAdmin(archivoConfiguracion);
           
          // Solicitar Inicio de sesion
          System.out.println("Ingrese la contraseña del administrador");
          String contraseñaIngresada= scan.nextLine();
          
          if (contraseñaIngresada.equals(administrador)){ // abre 2do if
          
              // inicio de secios exitoso, mostrar opciones del sistema
          MenuGeneral ();
          }// cierra 2do if
          
          else {// abre 1er else 
              System.out.println("constraseña incorrecta Saliendo del programa");
              
          }// cierra 1er else 
          }// cierra 1er if
      
      else {// abre 2do else
         // Solicitar una nueva contraseña para el administrador 
         System.out.println("configuracion inicial: ingrese una contraseña para el administrador");
         String administrador= scan.nextLine();
         
         // Guarda la contraseña en Archivo Creado de Configuracion
         guardarContraseñaAdmin(archivoConfiguracion, administrador);
         System.out.println("La Contraseña del Administrador se configurado Correctamente");
         
          }// cierra 2do else 
    
   }
    
    

    private static String cargarContraseñaAdmin(File archivoConfiguracion) throws IOException {
        try ( BufferedReader lector= new BufferedReader (new FileReader (archivoConfiguracion))){// abre try
           return lector.readLine(); 
        }// ciera try
          
        catch (IOException e){// abre catch
            e.printStackTrace();
            return null;
           }// cierra catch
             }
 
    // MENU GENERAL 
    private static void MenuGeneral() {// ABRE MENU GENERAL 
        Scanner scan= new Scanner (System.in);
        
        System.out.println("***Bienvenido al Sistema de Gestion de inventario***");
        System.out.println("----------------------------------------------------");
        
        // opciones del Sistema 
        int Opcion=0;
        
        System.out.println("\n Funcionalidades");
        System.out.println("1. Gestion de Productos");
        System.out.println("2. Control de Existencias");
        System.out.println("3. Pedidos de compra");
        System.out.println("4. Informes y Estadisticas"); 
        System.out.println("5. Salir");
        System.out.println("6. Ingrese la Opcion que Desee:");
        Opcion= scan.nextInt();
        
        switch (Opcion){// abre switch
            case 1: // Gestion de Productos 
                
            
            
            
            
            
        }// cierra switch 
        
        
    }// Cierra menu general 

    private static void guardarContraseñaAdmin(File archivoConfiguracion, String administrador) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
