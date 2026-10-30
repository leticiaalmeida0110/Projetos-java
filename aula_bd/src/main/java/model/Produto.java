
package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    private Integer id;
    private String nome;
    private Double valor;
    private int qtde;

    private String tipo;
    private String material;
    private Boolean possuiPedra;
    private Integer tamanhoAnel;
    private Double comprimentoCm;
}
