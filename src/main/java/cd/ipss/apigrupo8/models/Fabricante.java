package cd.ipss.apigrupo8.models;

import java.util.List;

import lombok.Data;

@Data
public class Fabricante {
    private String name;
    private List<Consola> consola;
}
