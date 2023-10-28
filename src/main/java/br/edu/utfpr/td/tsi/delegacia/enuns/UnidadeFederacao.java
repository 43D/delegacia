package br.edu.utfpr.td.tsi.delegacia.enuns;

public enum UnidadeFederacao {
    AMAZONAS("AM"),
    ALAGOAS("AL"),
    ACRE("AC"),
    AMAPA("AP"),
    BAHIA("BA"),
    CEARA("CE"),
    DISTRITO_FEDERAL("DF"),
    ESPIRITO_SANTO("ES"),
    GOIAS("GO"),
    MARANHAO("MA"),
    MATO_GROSSO("MT"),
    MATO_GROSSO_DO_SUL("MS"),
    MINAS_GERAIS("MG"),
    PARA("PA"),
    PARAIBA("PB"),
    PARANA("PR"),
    PERNAMBUCO("PE"),
    PIAUI("PI"),
    RIO_DE_JANEIRO("RJ"),
    RIO_GRANDE_DO_NORTE("RN"),
    RIO_GRANDE_DO_SUL("RS"),
    RONDONIA("RO"),
    RORAIMA("RR"),
    SANTA_CATARINA("SC"),
    SAO_PAULO("SP"),
    SERGIPE("SE"),
    TOCANTINS("TO");

    private final String sigla;

    UnidadeFederacao(final String sigla) {
        this.sigla = sigla;
    }

    public static UnidadeFederacao fromSigla(final String sigla) {
        for (final UnidadeFederacao uf : UnidadeFederacao.values()) {
            if (uf.sigla.equalsIgnoreCase(sigla)) {
                return uf;
            }
        }

        throw new IllegalArgumentException(sigla);
    }

    public String sigla() {
        return this.sigla;
    }
}
