package br.com.shift.data;

import br.com.shift.entity.Orcamento;
import jakarta.inject.Singleton;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class Dados {

    public List<Orcamento> orcamentos;

    Dados() throws ParseException {
        DateTimeFormatter dateFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        orcamentos = new ArrayList<>();
        orcamentos.add(new Orcamento(){
            {
                id = 1;
                dataCadastro = LocalDateTime.parse("01/10/2024 10:30:22", dateFormatObj);
                dataValidade = LocalDateTime.parse("30/10/2024 10:30:22", dateFormatObj);
                valorTotal = 1455;
                status = eTipoStatus.EmAnalise;
                finalizado = false;
                idFontePagadora = 100;
                idPessoaFisica = 300;
            }
        });
        orcamentos.add(new Orcamento(){
            {
                id = 2;
                dataCadastro = LocalDateTime.parse("01/05/2024 10:30:22",dateFormatObj);
                dataValidade = LocalDateTime.parse("20/05/2024 10:30:22",dateFormatObj);
                valorTotal = 950;
                status = eTipoStatus.Aprovado;
                finalizado = true;
                idFontePagadora = 100;
                idPessoaFisica = 200;
            }
        });
    }

    public int gerarCodigoOrcamento() {
        return this.orcamentos.size() + 1;
    }

}
