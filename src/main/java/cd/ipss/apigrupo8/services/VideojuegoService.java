package cd.ipss.apigrupo8.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cd.ipss.apigrupo8.models.Videojuego;
import cd.ipss.apigrupo8.repositories.VideojuegoRepository;

@Service
public class VideojuegoService {
    @Autowired
    public VideojuegoRepository videojuegoRepository;

    //crear
    public Videojuego crear(Videojuego videojuego){
        return videojuegoRepository.save(videojuego);
    }
}
