import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ProdutoPerecivel extends Produto {

private LocalDate validade;

public ProdutoPerecivel(String desc, double precoCusto, double margemLucro, LocalDate validade) {
super(desc, precoCusto, margemLucro);

if (validade == null || validade.isBefore(LocalDate.now())) {
throw new IllegalArgumentException("Produto fora da validade.");
}

this.validade = validade;
}

public ProdutoPerecivel(String desc, double precoCusto, LocalDate validade) {
super(desc, precoCusto);

if (validade == null || validade.isBefore(LocalDate.now())) {
throw new IllegalArgumentException("Produto fora da validade.");
}

this.validade = validade;
}

@Override
public double valorDeVenda() {
double precoBase = super.valorDeVenda();

long diasParaVencer = ChronoUnit.DAYS.between(LocalDate.now(), validade);

if (diasParaVencer <= 7) {
return precoBase * 0.75;
}

return precoBase;
}
}