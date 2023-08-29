package br.com.brunopaese.tdd.service;

import br.com.brunopaese.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BonusServiceTest {

    @Test
    public void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
        BonusService service = new BonusService();
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.calcularBonus(new Funcionario("Bruno", LocalDate.now(), new BigDecimal("25000"))));
    }

    @Test
    public void bonusDeveriaSerDezPorCentoDoSalario() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Bruno", LocalDate.now(), new BigDecimal("5000")));
        Assertions.assertEquals(new BigDecimal("500.00"), bonus);
    }

    @Test
    public void bonusDeveriaSerDezPorCentoParaSalarioDeExatamenteDezMil() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Bruno", LocalDate.now(), new BigDecimal("10000")));
        Assertions.assertEquals(new BigDecimal("1000.00"), bonus);
    }

}
