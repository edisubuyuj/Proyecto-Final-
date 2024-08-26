/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemainventario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author 50240
 */
public class SistemaInventario {


    /**
     * @param args
     */
    public static void main(String[] args) {
        // configuracion Inicial del sistema
        
        Scanner scan = new Scanner (System.in);
        
        //configuracion Inicial del Sistema de Gestion de Inventario 
        
        // verificar si el archivo de configuracion existe.
        
      File archivoConfiguracion = new File ("Admin.txt");
      
      if (archivoConfiguracion.exists()){ // abre 1er if
      
          // Si el archivo de configuración existe, cargar contraseña del administrador
         
          String administrador= cargarContraseñaAdmin(archivoConfiguracion);
         
          // Solicitar Inicio de sesion
          System.out.println("Ingrese la contraseña del administrador");
          String contraseñaIngresada= scan.nextLine();
          
          if (contraseñaIngresada.equals(administrador)){ // abre 2do if
          
              // inicio de secion exitoso, mostrar opciones del sistema
              System.out.println("MenuGeneral");
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
         System.out.println("La Contraseña del Administrador se ha configurado Correctamente");
         
          }// cierra 2do else 
    
   }
    
    private static String cargarContraseñaAdmin(File archivoConfiguracion){
        try ( BufferedReader lector= new BufferedReader (new FileReader (archivoConfiguracion))){// abre try
           return lector.readLine(); 
        }// ciera try
          
        catch (IOException e){// abre catch
            e.printStackTrace();
            return null;
           }// cierra catch
             }
    
    private static void guardarContraseñaAdmin(File archivoConfiguracion, String contraseña) {// abre guardar contraseña
        try (PrintWriter escritor = new PrintWriter (archivoConfiguracion)){
       escritor.println(contraseña);
        }
        catch (IOException e) {// abre catch
                 e.printStackTrace();
                }// cierra Catch
            
        }// cierra Guardar Contraseña 
    
    
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
        Opcion=scan.nextInt();
        System.out.println(Opcion);
        switch (Opcion){// abre switch
            case 1: 
                gestionProductos();
                break;
          
            case 2: controlExistencias();
            break;
            
            case 3: pedidosCompra();
            break;
            
            case 4: InformesEstadistica();
            break;
            
            case 5: // salir del programa
                System.out.println("Saliendo del programa");
            break;
            
            default:
                System.out.println("Opcion invalida. Intentelo de Nuevo");
            scan.close();
        }// cierra switch      
    }// Cierra menu general 

  static void gestionProductos () {// abre metodo Gestion de Productos 
        String archivoCategoria= "categorias.txt";
       Scanner scan= new Scanner (System.in);
        
        int Opcion;
      
        System.out.println("***Definicion de Categorias***");
         System.out.println("-----------------------------");
         System.out.println("1. Ver Categorias");
         System.out.println("2. Agregar Categorias"); 
         System.out.println("3. Modificar Categoria");
         System.out.println("4. Eliminar Categoria");
         System.out.println("5.Salir");
         System.out.println("Seleccione una opcion"); 
         Opcion= scan.nextInt();
         
         switch (Opcion){// Abre Switch
             
            case 1:
                mostrarCategorias();
           break;
           
            case 2:
                agregarCategoria();
                
                break;
            
            case 3:
                
            break;
            case 4: 
               ;
            break;
            
            case 5: // Salir del sistema
            System.out.println("Saliendo del Programa");
            break;
            default:
                throw new AssertionError();
            
    }// Cierra Switch
  }// cierra gestion de productos 

    private static void controlExistencias() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void pedidosCompra() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void InformesEstadistica() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void mostrarCategorias() {// abre mostrar Categorias 
        
     
}//Cierra Mostrar Categorias

    static void agregarCategoria() {// abre agreagar Categoria 
        Scanner scan=new Scanner(System.in);
        
        System.out.println("ingrese el nombre de la Categoria");
        String nombre= scan.next();
        System.out.println("descripcion de Categoria");
        String descripcion= scan.next();
    String categoria= nombre+descripcion;
        System.out.println("categoria agregada exitosamente"+categoria);
         File f=new File("Categorias.txt");
        
         try {
            FileWriter fw = new FileWriter(f, true);
            BufferedWriter bw = new BufferedWriter(fw);

            // Escribir los datos en el archivo
            bw.write(categoria+"\n");
            
            
            bw.close();// Cerrar el archivo


            System.out.println("Las categorias se han guardado en el archivo correctamente!");
            } catch (IOException  e) {
          
        }
        }// Cieera Agregar Categoria 
            

     
  
        
        
     
    
    
   }// cierra sistema de inventario

    
    
    

    
   
    

