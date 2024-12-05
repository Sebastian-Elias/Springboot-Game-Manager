package cd.ipss.apigrupo8.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import cd.ipss.apigrupo8.models.Videojuego;

public interface VideojuegoRepository extends MongoRepository <Videojuego, String>{

}
