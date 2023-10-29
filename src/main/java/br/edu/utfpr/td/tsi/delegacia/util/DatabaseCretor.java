package br.edu.utfpr.td.tsi.delegacia.util;

import java.util.ArrayList;
import java.util.List;

import br.edu.utfpr.td.tsi.delegacia.entity.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.delegacia.entity.Endereco;
import br.edu.utfpr.td.tsi.delegacia.entity.Parte;
import br.edu.utfpr.td.tsi.delegacia.entity.Placa;
import br.edu.utfpr.td.tsi.delegacia.entity.Veiculo;
import br.edu.utfpr.td.tsi.delegacia.repository.BoletimRepository;
import br.edu.utfpr.td.tsi.delegacia.values.Veiculo.AnoFabricado;
import br.edu.utfpr.td.tsi.delegacia.values.Veiculo.Cor;
import br.edu.utfpr.td.tsi.delegacia.values.Veiculo.Marca;
import br.edu.utfpr.td.tsi.delegacia.values.Veiculo.TipoVeiculo;
import br.edu.utfpr.td.tsi.delegacia.values.boletim.DataOcorrencia;
import br.edu.utfpr.td.tsi.delegacia.values.boletim.PeriodoOcorrencia;
import br.edu.utfpr.td.tsi.delegacia.values.endereco.Bairro;
import br.edu.utfpr.td.tsi.delegacia.values.endereco.Cidade;
import br.edu.utfpr.td.tsi.delegacia.values.endereco.Estado;
import br.edu.utfpr.td.tsi.delegacia.values.endereco.Logradouro;
import br.edu.utfpr.td.tsi.delegacia.values.endereco.Numero;
import br.edu.utfpr.td.tsi.delegacia.values.parte.EmailParte;
import br.edu.utfpr.td.tsi.delegacia.values.parte.EnvolvimentoParte;
import br.edu.utfpr.td.tsi.delegacia.values.parte.NomeParte;
import br.edu.utfpr.td.tsi.delegacia.values.parte.TelefoneParte;
import br.edu.utfpr.td.tsi.delegacia.values.placa.PlacaVeiculo;

public class DatabaseCretor {
    public static void create(String[] nextRecor, BoletimRepository rep) {
        if (!nextRecor[44].trim().isEmpty()) {
            try {
                Placa placa = createPlaca(nextRecor);
                Veiculo veiculo = createVeiculo(nextRecor, placa);
                List<Parte> partes = createPartes();
                Endereco endereco = createEndereco(nextRecor);
                BoletimFurtoVeiculo boletim = createBoletimFurtoVeiculo(nextRecor, veiculo, partes, endereco);
                System.out.println(boletim);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static BoletimFurtoVeiculo createBoletimFurtoVeiculo(String[] nextRecor, Veiculo veiculo,
            List<Parte> partes, Endereco endereco) {

        String crime = nextRecor[26];
        String data = nextRecor[5].replaceAll("/", "-");
        DataOcorrencia dataOcorrencia = new DataOcorrencia(data);
        PeriodoOcorrencia periodoOcorrencia = new PeriodoOcorrencia(nextRecor[7]);
        boolean flagrante = nextRecor[11].toUpperCase().contains("SIM");

        BoletimFurtoVeiculo bo = new BoletimFurtoVeiculo(crime, dataOcorrencia,
                periodoOcorrencia, flagrante, partes, endereco, veiculo);
        return bo;
    }

    private static Placa createPlaca(String[] nextRecor) {
        PlacaVeiculo placaVeiculo = new PlacaVeiculo(nextRecor[44]);
        Estado estado = new Estado(nextRecor[45]);
        Cidade cidade = new Cidade(nextRecor[46]);
        Placa placa = new Placa(placaVeiculo, estado, cidade);
        return placa;
    }

    private static Veiculo createVeiculo(String[] nextRecor, Placa placa) throws Exception {
        AnoFabricado anoFabricacao = new AnoFabricado(Integer.parseInt(nextRecor[49]));
        Cor cor = new Cor(nextRecor[47]);
        Marca marca = new Marca(nextRecor[48]);
        TipoVeiculo tipoVeiculo = new TipoVeiculo(nextRecor[51]);
        Veiculo veiculo = new Veiculo(placa, anoFabricacao, cor, marca, tipoVeiculo);
        return veiculo;
    }

    private static List<Parte> createPartes() {
        List<Parte> list = new ArrayList<Parte>();

        NomeParte nome = new NomeParte("Desconhecido");
        EmailParte email = new EmailParte("a@a.com");
        TelefoneParte telefone = new TelefoneParte("11987654321");
        EnvolvimentoParte tipoEnvolvimento = new EnvolvimentoParte("Sim");

        Parte p = new Parte(nome, email, telefone, tipoEnvolvimento);
        list.add(p);
        return list;
    }

    private static Endereco createEndereco(String[] nextRecor) {

        Logradouro logradouro = new Logradouro(nextRecor[13]);
        Numero numero = new Numero(nextRecor[14]);
        Bairro bairro = new Bairro(nextRecor[15]);
        Cidade cidade = new Cidade(nextRecor[16]);
        Estado estado = new Estado(nextRecor[17]);

        Endereco endereco = new Endereco(logradouro, numero, bairro, cidade, estado);
        return endereco;
    }

}
