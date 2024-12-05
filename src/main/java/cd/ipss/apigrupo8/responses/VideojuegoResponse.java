package cd.ipss.apigrupo8.responses;

import cd.ipss.apigrupo8.models.Videojuego;
import lombok.Data;

@Data
public class VideojuegoResponse {
    private int status;
    private String message;
    private Videojuego videojuego;
}
