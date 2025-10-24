import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Empleado {
    protected String nombre;
    protected String puesto;

    public Empleado(String nombre, String puesto) {
        this.nombre = nombre;
        this.puesto = puesto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre + ", Puesto: " + puesto);
    }
}

class GerenteGeneral extends Empleado {
    private GerenteDeportivo gDeportivo;
    private GerenteAdministrativo gAdministrativo;

    public GerenteGeneral(String nombre, Scanner scanner) {
        super(nombre, "Gerente General");
        System.out.print("Ingrese el nombre del Gerente Deportivo: ");
        String NomGeDeport = scanner.nextLine();
        gDeportivo = new GerenteDeportivo(NomGeDeport, scanner);
        
        System.out.print("Ingrese el nombre del Gerente Administrativo: ");
        String NomGeAdminis = scanner.nextLine();
        gAdministrativo = new GerenteAdministrativo(NomGeAdminis);
    }

    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("  - " + gDeportivo.getPuesto() + ": " + gDeportivo.getNombre());
        System.out.println("  - " + gAdministrativo.getPuesto() + ": " + gAdministrativo.getNombre());
    }
}

class GerenteDeportivo extends Empleado {
    private DirectorTecnico directorTecnico;

    public GerenteDeportivo(String nombre, Scanner scanner) {
        super(nombre, "Gerente Deportivo");
        directorTecnico = new DirectorTecnico("Carlos Martínez", scanner);
    }

    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("  - " + directorTecnico.getPuesto() + ": " + directorTecnico.getNombre());
        directorTecnico.mostrarInfo();
    }
}

class GerenteAdministrativo extends Empleado {
    public GerenteAdministrativo(String nombre) {
        super(nombre, "Gerente Administrativo");
    }
}

class DirectorTecnico extends Empleado {
    private List<AsistenteTecnico> asistentes;
    private List<Jugador> jugadores;

    public DirectorTecnico(String nombre, Scanner scanner) {
        super(nombre, "Director Técnico");
        asistentes = new ArrayList<>();
        jugadores = new ArrayList<>();
        
        System.out.println("Ingrese los nombres de los asistentes técnicos (3 en total):");
        for (int i = 1; i <= 3; i++) {
            System.out.print("Nombre del Asistente Técnico " + i + ": ");
            String nombreAsistente = scanner.nextLine();
            asistentes.add(new AsistenteTecnico(nombreAsistente));
        }
        
        int cantidadJugadores = 0;
        while (cantidadJugadores <= 0 || cantidadJugadores > 25) {
            System.out.print("Ingrese el número de jugadores (máximo 25): ");
            cantidadJugadores = scanner.nextInt();
            scanner.nextLine();
            
            if (cantidadJugadores <= 0 || cantidadJugadores > 25) {
                System.out.println("¡Error! El número de jugadores debe estar entre 1 y 25.");
            }
        }

        System.out.println("Ingrese los nombres de los jugadores:");
        for (int i = 1; i <= cantidadJugadores; i++) {
            System.out.print("Nombre del Jugador " + i + ": ");
            String nombreJugador = scanner.nextLine();
            jugadores.add(new Jugador(nombreJugador));
        }
    }

    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("");
        System.out.println("  Asistentes Técnicos:");
        for (AsistenteTecnico asistente : asistentes) {
            System.out.println("    - " + asistente.getPuesto() + ": " + asistente.getNombre());
        }
        System.out.println("  Jugadores:");
        for (Jugador jugador : jugadores) {
            System.out.println("    - " + jugador.getPuesto() + ": " + jugador.getNombre());
        }
    }
}

class AsistenteTecnico extends Empleado {
    public AsistenteTecnico(String nombre) {
        super(nombre, "Asistente Técnico");
    }
}

class Jugador extends Empleado {
    public Jugador(String nombre) {
        super(nombre, "Jugador");
    }
}

public class FutbolClub {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=============================================");
        System.out.print("Ingrese el nombre del Gerente General: ");
        String nombreGerenteGeneral = scanner.nextLine();
        
        GerenteGeneral gerenteGeneral = new GerenteGeneral(nombreGerenteGeneral, scanner);

        System.out.println("\n--- Información del Club ---");
        gerenteGeneral.mostrarInfo();
        System.out.println("=============================================");
        scanner.close();
    }
}