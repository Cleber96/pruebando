# ATRIBUTOS DE CALIDAD
- [atributos de calidad - artículo completo](https://insights.sei.cmu.edu/documents/1142/1995_005_001_16427.pdf)
- [categorías de atributos de calidad - microsoft](https://learn.microsoft.com/en-us/previous-versions/msp-n-p/ee658094(v=pandp.10))
# METRICAS DE CALIDAD DE SOFTWARE

--------------------------------------------------------------------------------
# ACTIVIDAD: MÉTRICAS DE CALIDAD DE SOFTWARE
##### acoplamiento: nivel de dependencia de los módulos de un sistema de soft. se prefiere bajo acoplamiento, pues reduce la complejidad y mejora la matenibilidad
## MÉTRICAS DE ACOPLAMIENTO
permiten identificar la dependencia entre componentes y evaluar su diseño
- acoplamiento eferente (ce): mide cantidad de tipos o clases que un módulo usa (ejemplo: ce clase A es 3)
- acoplamiento aferente (ca): mide cantidad de tipos o clases que depende de un módulo (ejemplo: ca clase A = 3)
- factor de acoplamiento (cf): evalúa grado de acoplamiento entre módulos del sistema. se prefiere un número bajo, pues indica menor depencia entre módulos.
`cf = e/(a*(n-1))`. e: número total de conexiones de acoplamiento reales entre módulos, a: número de módulos en el sistema, n: número total de módulos.

``` java
//no se añaden importaciones de librerías necesarias
class UsuarioModulo {
    private List<Usuario> usuarios = new ArrayList<>();
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        GrupoContactoModulo.agregarUsuarioAGrupo(usuario, "General");
    }
    public void eliminarUsuario(String nombre) {
        usuarios.removeIf(u -> u.getNombre().equals(nombre));
    }
}
public class Usuario {
    private String nombre;
    public Usuario(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
}
class ContactoOperacionesModulo {
    public void enviarMensaje(String mensaje, Usuario usuario) {
        System.out.println("Enviando mensaje a " + usuario.getNombre() + ": " + mensaje);
    }
}
class GrupoContactoModulo {
    static Map<String, List<Usuario>> grupos = new HashMap<>();
    static {
        grupos.put("General", new ArrayList<>());
    }
    public static void agregarUsuarioAGrupo(Usuario usuario, String grupoNombre) {
        grupos.get(grupoNombre).add(usuario);
    }
    public static void crearGrupo(String nombre) {
        if (!grupos.containsKey(nombre)) {
            grupos.put(nombre, new ArrayList<>());
        }
    }
}
public class SistemaContactos {
    public static void main(String[] args) {
        UsuarioModulo usuarioModulo = new UsuarioModulo();
        Usuario nuevoUsuario = new Usuario("Juan");
        usuarioModulo.agregarUsuario(nuevoUsuario);
        ContactoOperacionesModulo operacionesModulo = new ContactoOperacionesModulo();
        operacionesModulo.enviarMensaje("¡Hola!", nuevoUsuario);
        GrupoContactoModulo.crearGrupo("Amigos");
        GrupoContactoModulo.agregarUsuarioAGrupo(nuevoUsuario, "Amigos");
    }
}
```
