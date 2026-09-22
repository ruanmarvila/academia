package dev.ruancmm.academia.faturas;

import java.math.BigDecimal;

public interface FaturamentoMensalProjection {

    String getMes();
    BigDecimal getTotal();
}
