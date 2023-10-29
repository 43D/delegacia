package br.edu.utfpr.td.tsi.delegacia.enuns;

public enum PeriodosEnum {
    MANHA("PELA MANHA"),
    TARDE("A TARDE"),
    NOITE("A NOITE"),
    MADRUGADA("DE MADRUGADA"),
    INCERTA("EM HORA INCERTA");

    private final String desc;

    PeriodosEnum(final String desc) {
        this.desc = desc;
    }

    public static PeriodosEnum fromDesc(final String desc) {
        for (final PeriodosEnum periodo : PeriodosEnum.values()) {
            if (periodo.desc.equalsIgnoreCase(desc)) {
                return periodo;
            }
        }

        throw new IllegalArgumentException(desc);
    }

    public String getDesc() {
        return desc;
    }
}
