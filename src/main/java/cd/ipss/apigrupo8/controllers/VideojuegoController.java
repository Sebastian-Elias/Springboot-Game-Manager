package cd.ipss.apigrupo8.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import cd.ipss.apigrupo8.models.Videojuego;
import cd.ipss.apigrupo8.responses.VideoJuegosResponse;
import cd.ipss.apigrupo8.responses.VideojuegoResponse;
import cd.ipss.apigrupo8.services.VideojuegoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@Controller
@RequestMapping("api")
public class VideojuegoController {
    @Autowired
    private VideojuegoService videojuegoService;


    //crear
    @PostMapping(value = "crear", produces = "application/json")
    public ResponseEntity<Object> createVideoJuego(@RequestBody Videojuego videojuego) {
        
    if (videojuego.getTitle() == null || videojuego.getTitle().trim().isEmpty()) {
        throw new RuntimeException("El título es requerido");
    }

    videojuegoService.crear(videojuego);

    // Crear respuesta
    VideojuegoResponse videojuegoResponse = new VideojuegoResponse();
    videojuegoResponse.setStatus(200);
    videojuegoResponse.setMessage("Videojuego creado correctamente");
    videojuegoResponse.setVideojuego(videojuego);

    return ResponseEntity.ok().body(videojuegoResponse);
}


    @GetMapping(value="listar", produces="application/json")
    public ResponseEntity<Object> getVideoJuegos() {
        VideoJuegosResponse videojuegosResponse = new VideoJuegosResponse();
        videojuegosResponse.setStatus(200);
        videojuegosResponse.setMessage("Listado de videojuegos disponibles");
        videojuegosResponse.setVideojuego(videojuegoService.ListarTodos());

        return ResponseEntity.ok()
        .body(videojuegosResponse);
    }

    @GetMapping(value="buscar/{id}", produces="application/json")
    public ResponseEntity<Object> getVideoJuego(@PathVariable String id) {

        //crear estructura de respuesta
        VideojuegoResponse videojuegoResponse = new VideojuegoResponse();
        videojuegoResponse.setStatus(200);
        videojuegoResponse.setMessage("videojuego encontrado");
        videojuegoResponse.setVideojuego(videojuegoService.buscar(id));

        return ResponseEntity.ok()
        .body(videojuegoResponse);
    }

    @PutMapping(value="actualizar/{id}", produces="application/json")
    public ResponseEntity<Object> setVideoJuego(@PathVariable String id, @RequestBody Videojuego videojuegoRequest){
        VideojuegoResponse videojuegoResponse = new VideojuegoResponse();
        Videojuego videojuego = new Videojuego();

        videojuego = videojuegoService.buscar(id);
        videojuego.setTitle(videojuegoRequest.getTitle());
        videojuego.setFabricante(videojuegoRequest.getFabricante());
        videojuegoService.crear(videojuego);

        videojuegoResponse.setStatus(200);
        videojuegoResponse.setMessage("videojuego actualizado");
        videojuegoResponse.setVideojuego(videojuego);

        return ResponseEntity.ok()
        .body(videojuegoResponse);
    }
}
