package cd.ipss.apigrupo8.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cd.ipss.apigrupo8.models.Videojuego;
import cd.ipss.apigrupo8.responses.VideojuegoResponse;
import cd.ipss.apigrupo8.services.VideojuegoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("api")
public class VideojuegoController {
    @Autowired
    private VideojuegoService videojuegoService;

    //crear
    @PostMapping(value="crear", produces="application/json")
    public ResponseEntity<Object> createVideoJuego(@RequestBody Videojuego videojuego){
        videojuegoService.crear(videojuego);

        //crear estructura de respuesta
        VideojuegoResponse videojuegoResponse = new VideojuegoResponse();
        videojuegoResponse.setStatus(200);
        videojuegoResponse.setMessage("videojuego creado correctamente");
        videojuegoResponse.setVideojuego(videojuego);

        return ResponseEntity.ok()
        .body(videojuegoResponse);
    }
    
}
