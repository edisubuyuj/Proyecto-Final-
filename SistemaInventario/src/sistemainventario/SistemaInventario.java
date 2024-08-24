/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemainventario;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
       
        int Opcion;
        
        Scanner scan= new Scanner (System.in);
        String[] categoria=new String[10];// ajuste del tamaño segun la necesidad del usuario
      int totalCategoria=0; // contador para llevar un seguimiento del numero actual  de los empleados
        
        System.out.println("***bienvenido a Definicion de Categorias***");
         System.out.println("------------------------------------------");
         System.out.println("1. Ver Categorias");
         System.out.println("2. Agregar Categorias"); 
         System.out.println("3. Modificar Categoria");
         System.out.println("4. Eliminar Categoria");
         System.out.println("5.Salir");
         System.out.println("Seleccione una opcion"); 
         Opcion= scan.nextInt();
         
         switch (Opcion){// Abre Switch
             
            case 1://agrega una Categoria 
             if(totalCategoria < categoria.length)// length quiere desir longitud
             { //abre if total categoria
                 System.out.println("ingrese Nombre de la Categoria");
                 scan.nextLine();// consume la linea en blanco
                 String nuevaCategoria=scan.nextLine();
                 categoria[totalCategoria]=nuevaCategoria;
                 totalCategoria++;
                 System.out.println("Categoria agregado con Exito!");
                 }// cierra if total Categoria 
             else { // abre else 
                 System.out.println("la lista de Categorias esta llena. No se pueden agregar mas ");
             }// cierra else
             
            case 2: 
                agregarCategoria();
            break;
            case 3:
                modificarCategoria();
            break;
            case 4: 
                eliminarCategoria();
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

    static void mostrarCategorias() {// abre Mostrar Categoria 
      File archivoCategorias = new File ("categorias.txt");
        try (BufferedReader br= new BufferedReader(new FileReader (archivoCategorias))){//abre try 
        String linea;
        while ((linea = br.readLine()) != null) {// abre while
          String[] partes= linea.split("\\|");
          System.out.println("nombre:"+ partes [0]);
          System.out.println("Descripción: " + (partes.length > 1 ? partes[1] : "N/A"));
       System.out.println();
       
       
        }// cierra while
        
           
       }catch (IOException e){// abre catch
     System.out.println("Error al leer el archivo.");
       } // cierra catch
    
    
 }// cierra mostrar categoria 

    private static void agregarCategoria() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void modificarCategoria() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void eliminarCategoria() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
   }
    

