import java.text.NumberFormat;

public class Produto {

private static final double MARGEM_PADRAO = 0.2;
private String descricao;
private double precoCusto;
private double margemLucro;

private void init(String desc, double precoCusto, double margemLucro) {

if (desc != null && desc.length() >= 3 && precoCusto >= 0 && margemLucro >= 0) {
this.descricao = desc;
this.precoCusto = precoCusto;
this.margemLucro = margemLucro;
} else {
throw new IllegalArgumentException("Valores inválidos para os dados do produto.");
}
}

public Produto(String desc, double precoCusto, double margemLucro) {
init(desc, precoCusto, margemLucro);
}

public Produto(String desc, double precoCusto) {
init(desc, precoCusto, MARGEM_PADRAO);
}

public double valorDeVenda() {
return precoCusto * (1.0 + margemLucro);
}

@Override
public String toString() {
NumberFormat moeda = NumberFormat.getCurrencyInstance();
return String.format("%s - %s", descricao, moeda.format(valorDeVenda()));
}
}