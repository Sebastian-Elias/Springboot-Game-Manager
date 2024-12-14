package cd.ipss.apigrupo8.responses;

import java.util.List;

import cd.ipss.apigrupo8.models.Videojuego;
import lombok.Data;

@Data
public class VideoJuegosResponse {
    private int status;
    private String message;
    private List<Videojuego> videojuego;

}
