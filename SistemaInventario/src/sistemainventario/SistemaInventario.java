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
import java.util.UUID;

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
              System.out.println("contraseña incorrecta Saliendo del programa");
              
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
    
    private static String cargarContraseñaAdmin(File archivoConfiguracion){// abre cargar contraseña admin
        try ( BufferedReader lector= new BufferedReader (new FileReader (archivoConfiguracion))){// abre try
           return lector.readLine(); 
        }// ciera try
          
        catch (IOException e){// abre catch
            e.printStackTrace();
            return null;
           }// cierra catch
             }// cierra Cargar contraseña admin
    
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
        System.out.println(" Ingrese la Opcion que Desee");
        Opcion=scan.nextInt();
        System.out.println(Opcion);
        switch (Opcion){// abre switch
            case 1: 
                gestionProductos();
                break;
          
            case 2: controlExistencias();
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
         System.out.println("4. Asignacion de Categorias, Caracteristicas y Especificaciones a Productos");
         System.out.println("5. salir...");
         System.out.println("6. regresar a funcionalidades");
         System.out.println("Selecione una Opcion");
         Opcion= scan.nextInt();
         
      System.out.println(Opcion);
      
      switch (Opcion){// abre switch
          
          case 1: 
              definicionCategorias();
          break;
          case 2:definicionCaracteristicas();
          break;
          case 3:
              definicionEspecificaciones();
          case 4:
              asignacionCaracteristicasEspecificacionesProductos();
          case 5: 
               System.out.println("Saliendo del programa");
              break;
          case 6: 
              MenuGeneral(); return;
      }// cierra switch
  }// cierra Gestion de Productos 
      
   
      static void definicionCategorias (){// abre Definicion de Categorias 
      
       Scanner scan= new Scanner (System.in);
        
        int Opcion;
      
        System.out.println("***Categorias de Productos***");
           System.out.println("-----------------------");
         System.out.println("1. Ver Categorias");
         System.out.println("2. Agregar Categorias"); 
         System.out.println("3. Modificar Categoria");
         System.out.println("4. Eliminar Categoria");
         System.out.println("5.Salir");
         System.out.println("Seleccione una opcion."); 
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
        
    System.out.println("Listado de Categorias Existentes:");
            try (BufferedReader br = new BufferedReader(new FileReader("categorias.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("\\|");
                System.out.println("Nombre: " + partes[0]);
                System.out.println("Descripcion: " + (partes.length > 1 ? partes[1] : "N/A"));
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
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("categorias.txt"))) {
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
        
        if (!categoriaExiste(nombre)) {// si el nombre es diferente a carateforia existe. entonces no existe 
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
         System.out.println("5.Salir...");
         System.out.println("Seleccione una opcion."); 
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
        
     System.out.println("Listado de Caracteristicas Existentes:");
            try (BufferedReader br = new BufferedReader(new FileReader("caracteristicas.txt"))) {// abre try 
            String linea;
            while ((linea = br.readLine()) != null) {// abre while
                String[] partes = linea.split("\\|");
                System.out.println("Nombre: " + partes[0]);
                System.out.println("Descripcion: " + (partes.length > 1 ? partes[1] : "N/A"));
                System.out.println();
            }// cierra while
        }// cierra try 
            catch (IOException e) {// abre catch
            System.out.println("Error al leer el archivo.");}// cierra catch  
        }// cirra Mostrar Caracteristicas 

    private static void agregarCaracteristicas() {// Abre Agregar Caracteristicas
        Scanner scan=new Scanner(System.in);
        
        System.out.print("Ingrese el nombre de la Caracteristica: ");
        String nombre = scan.nextLine();
        
        if (nombre.isEmpty() || caracteristicaExiste(nombre)) {// abre if
            System.out.println("El nombre de la Caracteristica no puede estar vacío o ya existe.");
            return;
        }// cierra if

        System.out.print("Ingrese la descripcion de la Caracteristica (opcional): ");
        String descripcion = scan.nextLine();
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(("caracteristicas.txt"), true))) {// abre try
            bw.write(nombre + "|" + descripcion);
            bw.newLine();
            System.out.println("Caracteristicas agregada exitosamente.");
        }// cierra try
        catch (IOException e) {// abre catch
            System.out.println("Error al escribir en el archivo.");
        }// cierra catch
}//cierra Agregar Caracteristicas 

    private static void modificarCaracteristicas() {// Abre Modificar caracteristicas 
       mostrarCaracteristicas ();// listado de caracteristicas existentes en el archivo txt
       Scanner scan=new Scanner(System.in);
     
        System.out.print("Ingrese el nombre de la Caracteristica que desea modificar: ");// escribir el Nombre de la caracteristica existente en el archivo
        String nombreAntiguo = scan.nextLine();
        
        if (!caracteristicaExiste(nombreAntiguo)) {//abre if. si caracteritica no es igual a nombre antiguo enotnces no existe
            System.out.println("La caracteristica no existe.");
            return;
        }// cierra if
        
        System.out.print("Ingrese el nuevo nombre de la caracteristica: ");
        String nuevoNombre = scan.nextLine();// ingresar el nuevo Nombre que se le dara a la Caracteristica
        
        if (nuevoNombre.isEmpty() || caracteristicaExiste(nuevoNombre)) {// abre if
            System.out.println("El nuevo nombre de la Caracteristica no puede estar vacio o ya existe.");
            return;
        }// cierra if
        
        System.out.print("Ingrese la nueva descripcion de la Caracteristica (opcional): ");
        String nuevaDescripcion = scan.nextLine();// escribir la Nueva descripcion que se le dara a la caracteristica
        
        List<String> caracteristicas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("caracteristicas.txt"))) {// abre try
            String linea;
            while ((linea = br.readLine()) != null) {// abre while
                String[] partes = linea.split("\\|");
                if (partes[0].equals(nombreAntiguo)) {//abre if 
                    caracteristicas.add(nuevoNombre + "|" + nuevaDescripcion);// agrega el nuevo nombre / nueva descripcion
                }// cierra if 
                else {// abre else 
                    caracteristicas.add(linea);
                }// cierra else
            }// cierra while
        }// cierra try  
        catch (IOException e) {// abre catch
            System.out.println("Error al leer el archivo.");
        }// cierra catch
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("caracteristicas.txt"))) {// abre try
            for (String caracteristica : caracteristicas) {// abre for
                bw.write(caracteristica);
                bw.newLine();
            }// cierra for
            System.out.println("Caracteristica modificada exitosamente!");
        }// cierra try
        catch (IOException e) {// abre Catch
            System.out.println("Error al escribir en el archivo.");
        }// cierra Catch
        }// cierra Modificar Caracteristicas 

    private static void eliminarCaracteristicas() {// Abre Eliminar Caracteristicas 
        mostrarCaracteristicas(); // listado de Caracteristicas existentes en el archivo txt
        Scanner scan=new Scanner(System.in);
        
      System.out.print("Ingrese el nombre de la caracteristica que desea eliminar: ");
        String nombre = scan.nextLine();
        
        if (!caracteristicaExiste(nombre)) {// abre if.si caracteritica no es igual a nombre antiguo enotnces no existe
            System.out.println("La Caracteristica no existe.");
            return;
        }// cierra if
        
        System.out.print("¿Esta seguro de que desea eliminar la Caracteristica? (si/no): ");
        String confirmacion = scan.nextLine();
        
        if (!confirmacion.equalsIgnoreCase("si")) {// abre if. si confirmacion es diferente a si entonces eliminacion cancelada 
            System.out.println("Eliminacion cancelada.");
            return;
        }// cierra if 
        
        List<String> caracteristicas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("caracteristicas.txt"))) {// abre try
            String linea;
            while ((linea = br.readLine()) != null) {// abre while
                String[] partes = linea.split("\\|");
                if (!partes[0].equals(nombre)) {// abre if
                    caracteristicas.add(linea);
                }// cierra if
            }// cierra while
        }// cierra try
        catch (IOException e) {// abre catch
            System.out.println("Error al leer el archivo.");
        }// cierra catch
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("caracteristicas.txt"))) {// abre try
            for (String caracteristica : caracteristicas) {// abre for
                bw.write(caracteristica);
                bw.newLine();
            }// cierra for
            System.out.println("Caracteristica eliminada exitosamente!");
        }// cierra try
        catch (IOException e) {// abre catch
            System.out.println("Error al escribir en el archivo.");
        }// cierra catch
 }// cierra Eliminar Caracteristicas 

    private static boolean caracteristicaExiste(String nombre) {// abre caracteristicas existente
      try (BufferedReader br = new BufferedReader(new FileReader(("caracteristicas.txt")))) {// abre try
            String linea;
            while ((linea = br.readLine()) != null) {// abre while
                String[] partes = linea.split("\\|");
                if (partes[0].equals(nombre)) {// abre if
                    return true;
                }// cierra if
            }// cierra while
        }// cierra try 
      catch (IOException e) {// abre catch
            System.out.println("Error al leer el archivo.");
        }// cierra catch
        return false;  
   }// cierra caracteristicas existente

    private static void definicionEspecificaciones() {// abre definicion de especificaciones 
        
    Scanner scan= new Scanner (System.in);
        
        int Opcion;
      
        System.out.println("***Especificaciones de Productos***");
        System.out.println("----------------------------------");
         System.out.println("1. Ver Especificaciones");
         System.out.println("2. Agregar Especificaciones"); 
         System.out.println("3. Modificar Especificaciones");
         System.out.println("4. Eliminar Especificaciones");
         System.out.println("5.Salir...");
         System.out.println("Seleccione una opcion."); 
         Opcion= scan.nextInt();
    
    switch (Opcion){// abre switch
        case 1: 
           mostrarEspecificaciones ();
            break;
        case 2:
          agregarEspecificaciones();
          break;
        case 3:
           modificarEspecificaciones();
            break;
        case 4:
            eliminarEspecificaciones();
            break;
        case 5:
             System.out.println("Saliendo del Programa...");
            break;
            default: 
                throw new AssertionError();
          
    }// cieera switch 
}// cierra Definicion de especificaciones 

    private static void mostrarEspecificaciones() {// abre mostrar especificaciones 
        
        System.out.println("Listado de Especificaciones Existentes:");
            try (BufferedReader br = new BufferedReader(new FileReader("especificaciones.txt"))) {// abre try 
            String linea;
            while ((linea = br.readLine()) != null) {// abre while
                String[] partes = linea.split("\\|");
                System.out.println("Nombre: " + partes[0]);
                System.out.println("Descripcion: " + (partes.length > 1 ? partes[1] : "N/A"));
                System.out.println("Tipo de Dato: " + partes[2]);
                System.out.println();
            }// cierra while
        }// cierra try 
            catch (IOException e) {// abre catch
            System.out.println("Error al leer el archivo.");}// cierra catch 
}// cierra Mostrar especificaciones 

    private static void agregarEspecificaciones() {// abre agregar especificaciones
        
      Scanner scan=new Scanner(System.in);
        
        System.out.print("Ingrese el nombre de la Especificacion: ");
        String nombre = scan.nextLine();
        
        if (nombre.isEmpty() || especificacionExiste(nombre)) {// abre if
            System.out.println("El nombre de la Especificacion no puede estar vacío o ya existe.");
            return;
        }// cierra if

        System.out.print("Ingrese la descripcion de la Especificacion (opcional): ");
        String descripcion = scan.nextLine();
        
         System.out.print("Tipo de Dato (texto,numero,fecha,etc...): ");
        String tipoDato = scan.nextLine();
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(("especificaciones.txt"), true))) {// abre try
            bw.write(nombre + "|" + descripcion + "|" + tipoDato);
            bw.newLine();
            System.out.println("especificacion agregada exitosamente!");
        }// cierra try
        catch (IOException e) {// abre catch
            System.out.println("Error al escribir en el archivo.");
        }// cierra catch  
 }// cierra agregar especificaciones 

    private static boolean especificacionExiste(String nombre) {// abre especificacion existe
      
        try (BufferedReader br = new BufferedReader(new FileReader(("especificaciones.txt")))) {// abre try
            String linea;
            while ((linea = br.readLine()) != null) {// abre while
                String[] partes = linea.split("\\|");
                if (partes[0].equals(nombre)) {// abre if
                    return true;
                }// cierra if
            }// cierra while
        }// cierra try 
      catch (IOException e) {// abre catch
            System.out.println("Error al leer el archivo.");
        }// cierra catch
        return false;  
    }// cierra especificacion existe 

    private static void modificarEspecificaciones() {// abre Modificar especificaciones 
        mostrarEspecificaciones();
        
         Scanner scan=new Scanner(System.in);
     
        System.out.print("Ingrese el nombre de la Especificacion que desea modificar: ");// escribir el Nombre de la Especificacion existente en el archivo
        String nombreAntiguo = scan.nextLine();
        
        if (!especificacionExiste(nombreAntiguo)) {//abre if. si especificacion no es igual a nombre antiguo enotonces no existe
            System.out.println("La Especificacion no existe!");
            return;
        }// cierra if
        
        System.out.print("Ingrese el nuevo nombre de la Especificacion: ");
        String nuevoNombre = scan.nextLine();// ingresar el nuevo Nombre que se le dara a la Caracteristica
        
        if (nuevoNombre.isEmpty() || especificacionExiste(nuevoNombre)) {// abre if
            System.out.println("El nuevo nombre de la especificacion no puede estar vacio o ya existe.");
            return;
        }// cierra if
        
        System.out.print("Ingrese la nueva descripcion de la Especificacion (opcional): ");
        String nuevaDescripcion = scan.nextLine();// escribir la Nueva descripcion que se le dara a la Especificacion
        
         System.out.print("Ingrese el Nuevo tipo de Dato(texto,numero,fecha,etc...): ");
        String nuevoTipoDato= scan.nextLine();
        
        List<String> especificaciones = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("especificaciones.txt"))) {// abre try
            String linea;
            while ((linea = br.readLine()) != null) {// abre while
                String[] partes = linea.split("\\|");
                if (partes[0].equals(nombreAntiguo)) {//abre if 
                    especificaciones.add(nuevoNombre + "|" + nuevaDescripcion + "|" + nuevoTipoDato);// agrega el nuevo nombre / nueva descripcion
                }// cierra if 
                else {// abre else 
                    especificaciones.add(linea);
                }// cierra else
            }// cierra while
        }// cierra try 
        
        catch (IOException e) {// abre catch
            System.out.println("Error al leer el archivo.");
        }// cierra catch
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("especificaciones.txt"))) {// abre try
            for (String especificacion : especificaciones) {// abre for
                bw.write(especificacion);
                bw.newLine();
            }// cierra for
            System.out.println("Especificacion modificada exitosamente!");
        }// cierra try
        catch (IOException e) {// abre Catch
            System.out.println("Error al escribir en el archivo.");
        }// cierra Catch
}// cierra Modificar especificaciones 

    private static void eliminarEspecificaciones() {// abre Eliminar especificaciones 
        mostrarEspecificaciones();
        
        Scanner scan=new Scanner(System.in);
        
      System.out.print("Ingrese el nombre de la Especificacion que desea eliminar: ");
        String nombre =scan.nextLine();
        
        if (!especificacionExiste(nombre)) {// abre if.si la especificacion no es igual a nombre antiguo entonces no existe
            System.out.println("La Especificacion no existe.");
            return;
        }// cierra if
        
        System.out.print("¿Esta seguro de que desea eliminar la Especificacion? (si/no): ");
        String confirmacion = scan.nextLine();
        
        if (!confirmacion.equalsIgnoreCase("si")) {// abre if. si confirmacion es diferente a si entonces eliminacion cancelada 
            System.out.println("Eliminacion cancelada.");
            return;
        }// cierra if 
        
        List<String> especificaciones = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("especificaciones.txt"))) {// abre try
            String linea;
            while ((linea = br.readLine()) != null) {// abre while
                String[] partes = linea.split("\\|");
                if (!partes[0].equals(nombre)) {// abre if
                    especificaciones.add(linea);
                }// cierra if
            }// cierra while
        }// cierra try
        catch (IOException e) {// abre catch
            System.out.println("Error al leer el archivo.");
        }// cierra catch
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("especificaciones.txt"))) {// abre try
            for (String especificacion : especificaciones) {// abre for
                bw.write(especificacion);
                bw.newLine();
            }// cierra for
            System.out.println("Especificacion eliminada exitosamente!");
        }// cierra try
        catch (IOException e) {// abre catch
            System.out.println("Error al escribir en el archivo.");
        }// cierra catch
        }// Cierra Eliminar especificaciones 

    private static void asignacionCaracteristicasEspecificacionesProductos() {//abre asignacion de caracteristicas y especificaciones a productos
      Scanner scan= new Scanner (System.in);
        
        int Opcion;
      
        System.out.println("***Asignacion de Categorias, Caracteristicas y Especificaciones a Productos***");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("1. Crear Producto");
        System.out.println("2. Modificar Producto"); 
        System.out.println("3. Mostrar Productos");
        System.out.println("4.Salir...");
        System.out.println("Seleccione una opcion."); 
        Opcion= scan.nextInt();
    
    switch (Opcion){// abre switch
        
        case 1:
            crearProducto();
            break;
        case 2:
            modificarProducto();
            break;
        case 3:
            mostrarProducto();
            break;
        case 4:
            System.out.println("Saliendo del Programa...");
            return;
        default:
            System.out.println("Opción no valida, intente de nuevo");
    }// cierra switch 
 } // cierra asignacion de caracteristicas y especificaciones a productos

   
    private static void crearProducto() {// abre Crear producto
         Scanner scan=new Scanner(System.in);
        
        System.out.print("Ingrese el nombre del Producto: ");
        String nombre = scan.nextLine();
        
      if (nombre.isEmpty() || productoExiste(nombre)) {// abre if
            System.out.println("El nombre del prodcuto ya existe.");
            return;         
      }// cierra if
        
        mostrarCategorias();
        System.out.print("Ingrese el nombre de la Categoría: ");
        String categoria = scan.nextLine();
        if (categoriaExiste("categorias.txt")) {
            System.out.println("Categoría no encontrada.");
            return;
        }// cerrar if
        
        mostrarCaracteristicas();
        System.out.print("Ingrese el nombre de la Caracteristica: ");
        String caracteristica = scan.nextLine();
        if (caracteristicaExiste("caracteristicas.txt")) {
            System.out.println("Caracteristica no encontrada.");
            return;
        }// cerrar if
        
       
        mostrarEspecificaciones();
        System.out.print("Ingrese el nombre de la Especificacion: ");
        String especificacion= scan.nextLine();
        if (especificacionExiste("especificaciones.txt")) {
            System.out.println("Especificacion no encontrada.");
            return;
        }// cerrar if
        
        // Ingreso del precio de venta
        double precio;
        while (true) {
            System.out.print("Ingrese el precio de venta del producto: ");
            precio = scan.nextDouble();
            if (precio > 0) // evalua si la cantidad es mayor a 0
                break;
            System.out.println("El precio debe ser un número positivo. Intente nuevamente");
        }

        // Ingreso de la cantidad inicial de stock
        int stock;
        while (true) {
            System.out.print("Ingrese la cantidad inicial de stock del producto: ");
            stock = scan.nextInt();
            if (stock >= 0) // evalua que la cantidad sea mayor o igual a 0
                break;
            System.out.println("La cantidad de stock debe ser un numero no negativo. Intente nuevamente.");
        }

        // Generar un identificador unico
        String id = UUID.randomUUID().toString();

        
        
     try (BufferedWriter bw = new BufferedWriter(new FileWriter(("productos.txt"), true))) {// abre try
            bw.write(id + "|" + nombre + "|" + categoria + "|" + caracteristica + "|" + especificacion);
            bw.newLine();
            System.out.println("Producto agregado exitosamente!");
        }// cierra try
        catch (IOException e) {// abre catch
            System.out.println("Error al escribir en el archivo.");
        }
}// cierra Crear Producto 
    
    
     
    private static boolean productoExiste (String nombre) {// abre producto existe
       
    try (BufferedReader br = new BufferedReader(new FileReader(("productos.txt")))) {// abre try
            String linea;
            while ((linea = br.readLine()) != null) {// abre while
                String[] partes = linea.split("\\|");
                if (partes[0].equals(nombre)) {// abre if
                    return true;
                }// cierra if
            }// cierra while
        }// cierra try 
      catch (IOException e) {// abre catch
            System.out.println("Error al leer el archivo.");
        }// cierra catch
        return false;  
}// // cierra producto existe 

    private static void modificarProducto() {// abre Modificar Producto 
    
      mostrarProducto();
       Scanner scan=new Scanner(System.in);
     
        System.out.print("Ingrese el nombre del Producto que desea modificar: ");// escribir el Nombre del Producto existente en el archivo
        String nombreAntiguo = scan.nextLine();
        
        if (!productoExiste(nombreAntiguo)) {//abre if. si Producto no es igual a nombre antiguo entonces no existe el Producto
            System.out.println("El Producto no existe!");
            return;
        }// cierra if
        
        System.out.print("Ingrese el nuevo nombre del Producto: ");
        String nuevoNombre = scan.nextLine();// ingresar el nuevo Nombre para el Producto.
        
        if (nuevoNombre.isEmpty() || productoExiste(nuevoNombre)) {// abre if
            System.out.println("El nuevo nombre del Producto no puede estar vacio o ya existe.");
            return;
        }// cierra if
        
    mostrarCategorias();
            System.out.print("Ingrese la nueva Categoria ");
        String nuevaCategoria= scan.nextLine();
        if (categoriaExiste("categorias.txt")) {
            System.out.println("Categoría no encontrada.");
            return;
        }// Cierra if
            
    mostrarCaracteristicas();
          System.out.print("Ingrese la nueva Caracteristica: ");
        String nuevaCaracteristica= scan.nextLine();
        if (caracteristicaExiste("caracteristicas.txt")) {
            System.out.println("Caracteristica no encontrada.");
            return;
        }// cierra if
        
        mostrarEspecificaciones();
          System.out.print("Ingrese la nueva Especificacion: ");
        String nuevaEspecificacion= scan.nextLine();
        if (especificacionExiste("especificaciones.txt")) {
            System.out.println("Especificacion no encontrada.");
            return;
        }// cierra if
        
        
        List<String> producto = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("productos.txt"))) {// abre try
            String linea;
            while ((linea = br.readLine()) != null) {// abre while
                String[] partes = linea.split("\\|");
                if (partes[0].equals(nombreAntiguo)) {//abre if 
                    producto.add(nuevoNombre + "|" + nuevaCategoria + "|" + nuevaCaracteristica + "|"  + nuevaEspecificacion);// agrega el nuevo nombre,categoria,caracteristica, especificaion al Producto
                }// cierra if 
                
                else {// abre else 
                    producto.add(linea);
                }// cierra else
            }// cierra while
        }// cierra try 
        
        catch (IOException e) {// abre catch
            System.out.println("Error al leer el archivo.");
        }// cierra catch
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("productos.txt"))) {// abre try
            for (String productos : producto) {// abre for
                bw.write(productos);
                bw.newLine();
            }// cierra for
            System.out.println("Producto modificado exitosamente!");
        }// cierra try
        catch (IOException e) {// abre Catch
            System.out.println("Error al escribir en el archivo.");
        }// cierra Catch
    
 
    }// cierra Modificar Producto 

    private static void mostrarProducto() {// abre Mostrar Producto 
    
     System.out.println("Listado de Productos Existentes:");
            try (BufferedReader br = new BufferedReader(new FileReader("productos.txt"))) {// abre try 
            String linea;
            while ((linea = br.readLine()) != null) {// abre while
                String[] partes = linea.split("\\|");
                
                System.out.println("ID: " + partes[0]);
                System.out.println("Producto: " + partes[1]);
                System.out.println("Categoria: " + (partes.length > 2 ? partes[2] : "N/A"));
                System.out.println("Caracteristica: " + (partes.length > 3 ? partes[3] : "N/A"));
                System.out.println("Especificacion: " + (partes.length > 4 ? partes[4] : "N/A"));
                System.out.println();
            }// cierra while
        }// cierra try 
            catch (IOException e) {// abre catch
            System.out.println("Error al leer el archivo.");
            }// cierra catch 
   
}// cierra Mostrar Producto

    private static void controlExistencias() {// abre Control de Existencias 
         Scanner scan= new Scanner (System.in);
      
      int Opcion;
      System.out.println("*** Bienvenido ha Control de Existencias ***");
         System.out.println("--------------------------------------");
         System.out.println("1. Registro de Entrada de Prodcutos");
         System.out.println("2. Registro de Salida de Productos"); 
         System.out.println("3. Generacion de alertas de Stock Bajo");
         System.out.println("4. Visualización del Historial de Movimientos de Stock");
         System.out.println("5. salir...");
         System.out.println("Selecione una Opcion");
         Opcion= scan.nextInt();
         
      System.out.println(Opcion);
      
      switch (Opcion){// abre Switch  
       
          case 1:
              registroEntrada();
              break;
          case 2: 
              //registroSalida();
              break;
          case 3:
              //alertaStock();
              break;
          case 4:
              //historialMovimientos();
              break;
              
          case 5:
              System.out.println("Saliendo del Programa...");
            return;
        default:
            System.out.println("Opción no valida, intente de nuevo");
        
      }// cierra Switch
        
      
    }// Cierra Control de Exitencias 
    

    private static void registroEntrada() {// abre registro de entradas 
     
        Scanner scan = new Scanner(System.in);
       
        
         System.out.print("Ingrese el código del producto: ");
        String codigoProducto = scan.nextLine();
       
        if (!productoExiste(codigoProducto)) {//abre if. si el codigo de producto es diferente entonces no existe
             System.out.println("El producto no está registrado.");
            return;
        }// cierra if
        
         else {
            System.out.print("Ingrese la cantidad de productos a ingresar: ");
            int cantidad = scan.nextInt();
            if (cantidad <= 0) {
                System.out.println("La cantidad debe ser mayor que cero.");
                return;
            }
            
            System.out.println("La entrada de productos se ha realizado correctamente.");
        }
    
      
    
    }// cierra registro de entradas 

   



}// cierra sistema de inventario
    

    
   
   