package com.simon.peliculas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class PeliculaController {
    
    private List<Pelicula> peliculas = new ArrayList<Pelicula>();

    public PeliculaController() {
        this.peliculas.add(new Pelicula(1, "La naraja mecánica", 1971, "Stanley Kubrick", "Ciencia ficción,Comedia negra", "Alex es un joven muy agresivo que tiene dos pasiones: la violencia desaforada y Beethoven. Es el jefe de la banda de los drugos, que dan rienda suelta a sus instintos más salvajes aterrorizando a la población."));
        this.peliculas.add(new Pelicula(2, "El padrino", 1972, "Francis Ford Coppola", "Drama,Crimen", "Don Vito Corleone es el respetado y temido jefe de una de las cinco familias de la mafia de Nueva York en los años 40. El hombre tiene cuatro hijos: Connie, Sonny, Fredo y Michael, que no quiere saber nada de los negocios sucios de su padre. Cuando otro capo, Sollozzo, intenta asesinar a Corleone, empieza una cruenta lucha entre los distintos clanes."));
        this.peliculas.add(new Pelicula(3, "El gran dictador", 1940, "Charles Chaplin", "Comedia dramática,Sátira", "Emocionante alegato antifascista firmado por Charles Chaplin. Un humilde barbero judío tiene un parecido asombroso con el dictador de Tomania, un tirano que culpa a los judíos de la crítica situación que atraviesa el país. Un día, sus propios guardias lo confunden con el barbero y lo llevan a un campo de concentración. Al mismo tiempo, al pobre barbero lo confunden con el tirano. Una incontestable obra maestra."));
    }



    @GetMapping("/peliculas")
    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    @GetMapping("/peliculas/{id}")
    public Pelicula getPelicula(@PathVariable int id) {
        for (Pelicula pelicula : peliculas) {
            if(pelicula.getId() == id){
                return pelicula;
            }
        }
        return null;
    }
    
}
