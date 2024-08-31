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
import java.util.ArrayList;
import java.util.List;
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
          
            case 2: //controlExistencias();
            break;
            
            case 3: //pedidosCompra();
            break;
            
            case 4: //InformesEstadistica();
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
      Scanner scan= new Scanner (System.in);  
      int Opcion;
      System.out.println("***Bienvenido ha Gestion de Productos***");
         System.out.println("------------------------------------");
         System.out.println("1. Definicion de Categorias");
         System.out.println("2. Definicion de Caracteristicas"); 
         System.out.println("3. Definicion de Especificaciones");
         System.out.println("4. Asignacion de Caracteristicas y Especificaciones a Productos");
         System.out.println("5. alta de Productos");
         System.out.println("6. baja de Productos"); 
         System.out.println("7. Modificacion de Productos");
         System.out.println("8. Consideraciones Adicionales");
         System.out.println("9. salir");
         System.out.println("Selecione una Opcion");
         Opcion= scan.nextInt();
      System.out.println(Opcion);
      switch (Opcion){// abre switch
          case 1: 
              definicionCategorias();
          break;
          case 2:definicionCaracteristicas();
          break;
              
      }// cierra switch
  }// cierra Gestion de Productos 
      
   
      static void definicionCategorias (){// abre Definicion de Categorias 
      String archivoCategoria= "categorias.txt";
       Scanner scan= new Scanner (System.in);
        
        int Opcion;
      
        System.out.println("***Categorias de Productos***");
           System.out.println("-----------------------");
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
  }// cierra Definicion de Categorias 

    static void mostrarCategorias() {// abre mostrar Categorias 
    File f= new File ("Categorias.txt");
    System.out.println("Listado de Categorias Existentes:");
            try (BufferedReader br = new BufferedReader(new FileReader("categorias.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("\\|");
                System.out.println("Nombre: " + partes[0]);
                System.out.println("Descripción: " + (partes.length > 1 ? partes[1] : "N/A"));
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");}

}//Cierra Mostrar Categorias

    static void agregarCategoria() {// abre agreagar Categoria 
        Scanner scan=new Scanner(System.in);
                System.out.print("Ingrese el nombre de la categoría: ");
        String nombre = scan.nextLine();
        
        if (nombre.isEmpty() || categoriaExiste(nombre)) {
            System.out.println("El nombre de la categoría no puede estar vacío o ya existe.");
            return;
        }

        System.out.print("Ingrese la descripcion de la categoría (opcional): ");
        String descripcion = scan.nextLine();
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(("categorias.txt"), true))) {
            bw.write(nombre + "|" + descripcion);
            bw.newLine();
            System.out.println("Categoria agregada exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo.");
        }

      }// Cierra Agregar Categoria 
          
    private static boolean categoriaExiste(String nombre) { // abre categoria exixtente
        try (BufferedReader br = new BufferedReader(new FileReader(("categorias.txt")))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("\\|");
                if (partes[0].equals(nombre)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }
        return false;
 } // categoria existente

    private static void modificarCategoria() {// Abre Modificar Categoira
      mostrarCategorias();
       Scanner scan=new Scanner(System.in);
     
        System.out.print("Ingrese el nombre de la categoria que desea modificar: ");// escribir el Nombre de la categoria existente en el archivo
        String nombreAntiguo = scan.nextLine();
        
        if (!categoriaExiste(nombreAntiguo)) {
            System.out.println("La categoria no existe.");
            return;
        }
        
        System.out.print("Ingrese el nuevo nombre de la categoria: ");
        String nuevoNombre = scan.nextLine();// ingresar el nuevo Nombre que se le dara a la Categoria
        
        if (nuevoNombre.isEmpty() || categoriaExiste(nuevoNombre)) {
            System.out.println("El nuevo nombre de la categoria no puede estar vacio o ya existe.");
            return;
        }
        
        System.out.print("Ingrese la nueva descripcion de la categoría (opcional): ");
        String nuevaDescripcion = scan.nextLine();// escribir la Nueva descripcion que se le dara a la categoria
        
        List<String> categorias = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("categorias.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("\\|");
                if (partes[0].equals(nombreAntiguo)) {
                    categorias.add(nuevoNombre + "|" + nuevaDescripcion);
                } else {
                    categorias.add(linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("categorias."))) {
            for (String categoria : categorias) {
                bw.write(categoria);
                bw.newLine();
            }
            System.out.println("Categoria modificada exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo.");
        }

  }// Cierra Modificar Categoria

    private static void eliminarCategoria() {// abre eliminar Categoria 
       mostrarCategorias();
        Scanner scan=new Scanner(System.in);
        
      System.out.print("Ingrese el nombre de la categoria que desea eliminar: ");
        String nombre = scan.nextLine();
        
        if (!categoriaExiste(nombre)) {
            System.out.println("La categoria no existe.");
            return;
        }
        
        System.out.print("¿Esta seguro de que desea eliminar la categoría? (si/no): ");
        String confirmacion = scan.nextLine();
        
        if (!confirmacion.equalsIgnoreCase("si")) {
            System.out.println("Eliminacion cancelada.");
            return;
        }
        
        List<String> categorias = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("categorias.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("\\|");
                if (!partes[0].equals(nombre)) {
                    categorias.add(linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("categorias.txt"))) {
            for (String categoria : categorias) {
                bw.write(categoria);
                bw.newLine();
            }
            System.out.println("Categoria eliminada exitosamente!");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo.");
        }
   }// Cierra eliminar Categoria 

    static void definicionCaracteristicas() {// abre Definicion de Caracteristicas
         Scanner scan= new Scanner (System.in);
        
        int Opcion;
      
        System.out.println("***Caracteristicas de Productos***");
        System.out.println("----------------------------------");
         System.out.println("1. Ver Caracteristicas");
         System.out.println("2. Agregar Caracteristica"); 
         System.out.println("3. Modificar Caracteristica");
         System.out.println("4. Eliminar Caracteristica");
         System.out.println("5.Salir");
         System.out.println("Seleccione una opcion"); 
         Opcion= scan.nextInt();
    
    switch (Opcion){// abre switch
        case 1: 
            mostrarCaracteristicas();
            break;
        case 2:
          agregarCaracteristicas();
          break;
        case 3:
            modificarCaracteristicas();
            break;
        case 4:
            eliminarCaracteristicas();
            break;
        case 5:
             System.out.println("Saliendo del Programa");
            break;
            default:
                throw new AssertionError();
          
    }// cieera switch 
    
    }// Cierra Defincion de Caracteristicas

    private static void mostrarCaracteristicas() {// Abre Mostrar Caracteristicas 
        
    }// cirra Mostrar Caracteristicas 

    private static void agregarCaracteristicas() {// Abre Agregar Caracteristicas
        
        }//cierra Agregar Caracteristicas 

    private static void modificarCaracteristicas() {// Abre Modificar caracteristicas 
        
        }// cierra Modificar Caracteristicas 

    private static void eliminarCaracteristicas() {// Abre Eliminar Caracteristicas 
        
        }// cierra Eliminar Caracteristicas 
    
     
  
        
        
     
    
    
   }// cierra sistema de inventario

    
    
    

    
   
   
        
     

